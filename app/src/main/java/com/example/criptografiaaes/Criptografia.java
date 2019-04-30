package com.example.criptografiaaes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

public class Criptografia {

    static String IV = "AAAAAAAAAAAAAAAA";

    public static String criptografar(String textopuro, String chaveencriptacao) throws Exception {
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte senhaMD5Byte[] = algorithm.digest(chaveencriptacao.getBytes("UTF-8"));

        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
        SecretKeySpec key = new SecretKeySpec(senhaMD5Byte, "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(encripta.doFinal(textopuro.getBytes("UTF-8")));
    }

    public static String descriptografar(String textoencriptado, String chaveencriptacao) throws Exception{
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte senhaMD5Byte[] = algorithm.digest(chaveencriptacao.getBytes("UTF-8"));

        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
        SecretKeySpec key = new SecretKeySpec(senhaMD5Byte, "AES");
        decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado.getBytes("UTF-8")), "UTF-8");
    }

}
