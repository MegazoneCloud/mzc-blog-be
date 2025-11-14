package mzc.study.blog_be.domain.user;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mzc.study.blog_be.domain.post.PostEntity;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;

    @Builder
    public UserEntity( String email, String password, String name, String nickname ){
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    public void update( String password, String nickname ){
        if( password != null ) this.password = password;
        if( nickname != null ) this.nickname = nickname;
    }
    
    // 연관 관계 필드
    @OneToMany( fetch=FetchType.LAZY, mappedBy="writer" )
    private List<PostEntity> posts = new ArrayList<>();
    
    // 연관 관계 메서드

}
