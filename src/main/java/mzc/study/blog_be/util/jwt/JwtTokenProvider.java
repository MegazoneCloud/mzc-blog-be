package mzc.study.blog_be.util.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
    private final SecretKey secretKey;
    private final long expiration;

    public JwtTokenProvider(
        @Value("${jwt.secret}") String secret,
        @Value("${jwt.expiration}") long expireation
    ){
        this.secretKey = Keys.hmacShaKeyFor( secret.getBytes() );
        this.expiration = expireation;
    }

    // Token 생성
    public String generateToken( String email ){
        // Token 안에 담을 정보
        Map<String, Object> claims = new HashMap<>();
        return createToken( claims, email );
    }
    private String createToken( Map<String, Object> claims, String email ){
        Date now = new Date();
        Date expireDate = new Date( now.getTime() + expiration );

        return Jwts.builder()
                .claims( claims )
                .subject( email )
                .issuedAt( now )
                .expiration( expireDate )
                .signWith( secretKey )
                .compact();
    }
}
