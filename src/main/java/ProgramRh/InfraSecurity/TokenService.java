package ProgramRh.InfraSecurity;

import ProgramRh.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TokenService {
@Value("${api.security.token.secret}")
    private String secret;

    public  String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("login-auth-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(this.generateExpireDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro de autenticação");
        }
    }

    public String validateToken(String token) {
    try{
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm)
                .withIssuer("login-auth-api")
                .build()
                .verify(token)
                .getSubject();
    } catch (JWTVerificationException exception) {
        return null;
    }
    }

    private Instant generateExpireDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of(String.valueOf(-3)));
    }
}
