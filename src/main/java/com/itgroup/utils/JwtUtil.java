package com.itgroup.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    /**
     * Generate JWT
     * Using the Hs256 algorithm, private key with a fixed key
     *
     * @param secretKey JWT secret key
     * @param ttlMillis expiration time (milliseconds)
     * @param claims    Set information
     * @return
     */
    public static String createJWT(String secretKey, long ttlMillis, Map<String, Object> claims) {
        // Specify the signature algorithm used during signing, which is the 'header' part
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // Time of JWT generation
        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);

        // Set the JWT body
        JwtBuilder builder = Jwts.builder()
                // If there are custom claims, they must be set before the standard claims. These custom claims are assigned to the builder's claim.
                // Once they are set after the standard claims, they will overwrite those standard claims
                .setClaims(claims)
                // Set the signature algorithm and the key used for signing
                .signWith(signatureAlgorithm, secretKey.getBytes(StandardCharsets.UTF_8))
                // Set the expiration time
                .setExpiration(exp);

        return builder.compact();
    }

    /**
     * Token解密
     *
     * @param secretKey jwt key
     * @param token     Encrypted token
     * @return
     */
    public static Claims parseJWT(String secretKey, String token) {
        // get DefaultJwtParser
        Claims claims = Jwts.parser()
                // Set the signing key
                .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
                // Set the JWT to be parsed
                .parseClaimsJws(token).getBody();
        return claims;
    }

}
