package regex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class Ip6ValidatingTest {
    private String ip;
    private boolean expected;

    public Ip6ValidatingTest(String ip, boolean expected) {
        this.ip = ip;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection ipAddressees() {
        return Arrays.asList(new Object[][] {
                { "2001:0db8:0a0b:12f0:0000:0000:0000:0001", true },
                { "2001:db8:0:0:0:0:2:1", true },
                { "1111.156.156.2", false },
                { "test", false }
        });
    }
    @Test
    public void shouldReturnResultOfValidatingIp() {
        assertEquals(expected, IpValidating.ip6Validatig(ip));
    }
}

