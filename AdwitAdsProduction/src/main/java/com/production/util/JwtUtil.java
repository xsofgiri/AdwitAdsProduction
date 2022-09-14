package com.production.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Java web token Tools
 *
 * @author Giri
 * @date 2022/04/13
 */
public class JwtUtil {
    /**
     * 1 day
     * TODO The official runtime is modified to 15 minutes
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;
    /**
     * token private key
     */
    private static final String TOKEN_SECRET = "f26e587c28064d0e855e72c0a6a0e618";

    /**
     *Check if the token is correct
     *
     * @param token key
     * @return is it right or not
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * Obtain the information in the token without decrypting the secret
     *
     * @return token Username contained in
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获取登陆用户ID
     * @param token
     * @return
     */
    public static int getAdRepId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("adRepId").asInt();
        } catch (JWTDecodeException e) {
            return 0;
        }
    }

    /**
     * Generate signature, expire after 15 minutes
     *
     * @param username 
     * @return Encrypted token
     */
    public static String sign(String username,int adRepId) {
        try {
//            Expiration
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
//            Private key and encryption algorithm
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//            set header information
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            // With username, adRepId information, generate signature
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userName", username)
                    .withClaim("adRepId",adRepId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

}
