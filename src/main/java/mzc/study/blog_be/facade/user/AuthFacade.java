package mzc.study.blog_be.facade.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mzc.study.blog_be.service.AuthService;
import mzc.study.blog_be.service.UserService;
import mzc.study.blog_be.util.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class AuthFacade {
    private final AuthService authService;
    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    public Map<String, Object> login(
        String email, String password
    ){
        // 비밀번호 검증
        Long id = authService.login( email, password );

        // 토큰 발급
        String token = tokenProvider.generateToken(email);
        Map<String, Object> result = new HashMap<>();
        result.put( "accessToken", token );
        result.put( "uid", id );

        return result;
    }
}
