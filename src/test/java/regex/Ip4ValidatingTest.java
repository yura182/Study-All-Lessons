package regex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Ip4ValidatingTest {
    private String ip;
    private boolean expected;

    public Ip4ValidatingTest(String ip, boolean expected) {
        this.ip = ip;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection ipAddressees() {
        return Arrays.asList(new Object[][] {
                { "1927168.0.1", false },
                { "111.16.15.2", true },
                { "1111.156.156.2", false },
                { "test", false }
        });
    }
    @Test
    public void shouldReturnResultOfValidatingIp() {
        assertEquals(expected, IpValidating.ip4Validatig(ip));
    }
}