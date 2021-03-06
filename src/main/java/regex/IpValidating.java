package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpValidating {
    private static final String IP4_PATTERN = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                                            + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                                            + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                                            + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
    private static final String IP6_PATTERN = "([A-Fa-f0-9]{1,4}:){7}[A-Fa-f0-9]{1,4}";

    private IpValidating() {
        throw new AssertionError();
    }

    public static boolean ip4Validatig(String ip) {
        Pattern pattern = Pattern.compile(IP4_PATTERN);
        Matcher matcher = pattern.matcher(ip);

        if (matcher.matches()) {
            return true;
        }

        return false;
    }

    public static boolean ip6Validatig(String ip) {
        Pattern pattern = Pattern.compile(IP6_PATTERN);
        Matcher matcher = pattern.matcher(ip);

        if (matcher.matches()) {
            return true;
        }

        return false;
    }

}
