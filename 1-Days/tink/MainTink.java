package com.works.utils;

import java.util.Base64;

public class MainTink {
    public static void main(String[] args) {

        String key128Bit = "%D*G-KaPdSgVkYp3";
        String extraKey = "key123";
        String plainText = "4938460158754205";

        String cipherText = TinkEncDec.encrypt(key128Bit, plainText, extraKey);
        String base64CipherText = Base64.getEncoder().encodeToString(cipherText.getBytes());
        System.out.println(base64CipherText);

        byte[] bytes = Base64.getDecoder().decode(base64CipherText.getBytes());
        String convertCipherText = new String(bytes);
        System.out.println(convertCipherText);
        String convertPlaintext = TinkEncDec.decrypt(key128Bit, convertCipherText, extraKey);
        System.out.println(convertPlaintext);

    }
}
