package org.poc.chain.of.responsibility.infra.service;

import org.poc.chain.of.responsibility.core.exceptions.ErrorWhenCipherPassword;
import org.poc.chain.of.responsibility.core.service.StudentCipher;
import org.poc.chain.of.responsibility.core.domain.valueobjects.Password;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class JavaxCryptoCipher implements StudentCipher {
    private static final String className = JavaxCryptoCipher.class.getSimpleName();
    private static final Logger log = Logger.getLogger(className);

    @Override
    public Password encrypt(final String key) throws ErrorWhenCipherPassword {
        try {
            log.info("[" + className + ":execute] Ciphering Student password.");

            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey secretKey = keyGenerator.generateKey();

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(new byte[16]));

            byte[] encryptedBytes = cipher.doFinal(key.getBytes(StandardCharsets.UTF_8));

            log.info("[" + className + ":execute] Ciphered successfully!");
            return Password.builder().key(encryptedBytes).secretKey(secretKey).build();

        } catch (Exception ex) {
            log.warning("[" + className + ":execute] Ciphered failed!");
            throw new ErrorWhenCipherPassword(ex.getMessage());
        }
    }

    @Override
    public String decrypt(final Password password) throws ErrorWhenCipherPassword {
        try {
            log.info("[" + className + ":execute] Deciphering Student password.");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, password.getSecretKey(), new IvParameterSpec(new byte[16]));

            byte[] decryptedBytes = cipher.doFinal(password.getKey());

            log.info("[" + className + ":execute] Deciphered successfully!");
            return new String(decryptedBytes, StandardCharsets.UTF_8);

        } catch (Exception ex) {
            log.warning("[" + className + ":execute] Deciphered failed!");
            throw new ErrorWhenCipherPassword(ex.getMessage());
        }
    }
}
