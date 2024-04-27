package c322spring2024homework2.work.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratorUtils {

    private KeyGeneratorUtils() {

    }

    static KeyPair generateRsaKey() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return keyPair;
    }
}
