package mzc.study.blog_be.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;

    public void update( String password, String nickname ){
        if( password != null ) this.password = password;
        if( nickname != null ) this.nickname = nickname;
    }
    
    // 연관 관계 메서드

}
