package com.demo.e_wallet.utilities;

import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Base64;

public class KeyGen {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512);
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Your 512-bit Base64 key:\n" + base64Key);
    }
}
