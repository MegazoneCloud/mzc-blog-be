package mzc.study.blog_be.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mzc.study.blog_be.domain.user.UserEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserResponse {
    private Long id;
    private String email;
    private String name;
    private String nickname;

    public static GetUserResponse of( UserEntity user ){
        return GetUserResponse.builder()
            .id( user.getId() )
            .email( user.getEmail() )
            .name( user.getName() )
            .nickname( user.getNickname() )
            .build();
    }
}
