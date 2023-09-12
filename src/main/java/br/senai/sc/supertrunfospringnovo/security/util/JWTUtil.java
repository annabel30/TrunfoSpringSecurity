package br.senai.sc.supertrunfospringnovo.security.util;

import br.senai.sc.supertrunfospringnovo.security.model.entity.User;
import br.senai.sc.supertrunfospringnovo.security.repository.UserRepository;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

@Component
public class JWTUtil {

    private static UserRepository userRepository;
    private static final String STRONGPASSWORD = "c127a7b6adb013a5ff879ae71afa62afa4b4ceb72afaa54711dbcde67b6dc325";

    @Autowired
    JWTUtil(UserRepository userRepository) {
        JWTUtil.userRepository = userRepository;
    }

    public static String generateToken(User user) {

        Algorithm algorithm = Algorithm.HMAC256(STRONGPASSWORD);

        return JWT.create()
                .withIssuer("WEG")
                .withSubject(user.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(new Date().getTime() + 1800000))
                .sign(algorithm);
    }

    public static User getUser(String token) {
        String username = JWT.decode(token).getSubject();
        return userRepository.findByPlayer_Username(username);
    }
}