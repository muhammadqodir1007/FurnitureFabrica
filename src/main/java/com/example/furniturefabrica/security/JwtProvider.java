package com.example.furniturefabrica.security;

import com.example.furniturefabrica.entity.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {


    String passWord = "topolmisanUrinma";
    long expireTime = 8600 * 1000;


    public String generateToken(String email, Role role) {
        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .claim("role", role.getName())
                .signWith(SignatureAlgorithm.HS512, passWord)
                .compact();
        return token;

    }

    public String generateUserNameFromToken(String token) {

        return Jwts.parser()
                .setSigningKey(passWord)
                .parseClaimsJws(token).getBody().getSubject();

    }

    public boolean validateToken(String token) {

        try {
            Jwts
                    .parser()
                    .setSigningKey(passWord)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
