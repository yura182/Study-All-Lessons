package student.encoder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@Component
public class PasswordEncoder {
    private static final Logger LOGGER = Logger.getLogger(PasswordEncoder.class);
    private static final SecureRandom RAND = new SecureRandom();
    private static final int ITERATIONS = 1000;
    private static final int KEY_LENGTH = 256;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
    private static final String SALT = "EqdmPh53c9x33EygXpTpcoJvc4VXLK";


    public Optional<String> encode(String password) {
        return hashPassword(password, SALT);
    }

    public Optional<String> hashPassword (String password, String salt) {
        char[] chars = password.toCharArray();
        byte[] bytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

        Arrays.fill(chars, Character.MIN_VALUE);
        try {
            SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] securePassword = fac.generateSecret(spec).getEncoded();
            return Optional.of(Base64.getEncoder().encodeToString(securePassword));

        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            LOGGER.error("Error during hashing password", ex);
            return Optional.empty();

        } finally {
            spec.clearPassword();
        }
    }

    public boolean verifyPassword (String password, String key) {
        Optional<String> encryptedPassword = hashPassword(password, SALT);
        return encryptedPassword.map(s -> s.equals(key)).orElse(false);
    }
}
