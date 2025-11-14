package mzc.study.blog_be.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mzc.study.blog_be.domain.user.UserEntity;
import mzc.study.blog_be.repository.user.UserRepository;
import mzc.study.blog_be.util.exception.ServerException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Long login( String email, String password ){
        UserEntity user = userRepository.findByEmail( email ).orElseThrow( () -> new ServerException("아이디/비밀번호가 일치하지 않습니다." ) );
        if( !passwordEncoder.matches( password, user.getPassword() ) ) throw new ServerException("아이디/비밀번호가 일치하지 않습니다." );

        return user.getId();
    }
}
