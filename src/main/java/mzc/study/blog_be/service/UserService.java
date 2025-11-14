package mzc.study.blog_be.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mzc.study.blog_be.domain.user.UserEntity;
import mzc.study.blog_be.repository.user.UserRepository;
import mzc.study.blog_be.util.exception.ServerException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passowrdEncoder;

    @Transactional
    public void create( String email, String password, String name, String nickname ){
        // check validation
        if( email.isEmpty() ) throw new ServerException( "이메일은 필수입니다" );
        if( password.isEmpty() ) throw new ServerException( "비밀번호는 필수입니다" );
        if( nickname.isEmpty() ) throw new ServerException( "닉네임은 필수입니다" );
        if( name.isEmpty() ) throw new ServerException( "이름은 필수입니다" );

        // check duplication
        if( !repository.findByEmail( email ).isEmpty() ) throw new ServerException( "이미 가입된 이메일입니다" );
        if( !repository.findByNickname( nickname ).isEmpty() ) throw new ServerException( "이미 존재하는 닉네임입니다." );

        UserEntity user = UserEntity.builder()
                            .email( email )
                            .password( passowrdEncoder.encode(password) )
                            .name( name )
                            .nickname( nickname )
                            .build();
        this.repository.save( user );
    }

    public UserEntity findById( long id ){
        return repository.findById( id ).orElseThrow( () -> new ServerException("해당하는 사용자를 찾을 수 없습니다") );
    }
    public List<UserEntity> findAll(){
        return repository.findAll();
    }

    public void update( long id, String password, String nickname ){
        UserEntity user = repository.findById( id ).orElseThrow( () -> new ServerException("해당하는 사용자를 찾을 수 없습니다") );
        user.update( password, nickname );
    }

    public void delete( long id ){
        repository.findById( id ).orElseThrow( () -> new ServerException("해당하는 사용자를 찾을 수 없습니다") );
        repository.deleteById( id );
    }
}
