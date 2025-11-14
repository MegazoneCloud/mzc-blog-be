package mzc.study.blog_be.dto.response.post;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mzc.study.blog_be.domain.post.PostEntity;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPostResponse {
    private Long id;
    private String title;
    private String content;
    private String writerNickname;
    private Long writerId;
    private List<AttatchmentFileDto> files;

    public static GetPostResponse of( PostEntity post ){
        GetPostResponseBuilder builder = GetPostResponse.builder()
                .id( post.getId() )
                .title( post.getTitle() )
                .content( post.getContent() )
                .writerNickname( post.getWriter().getNickname() )
                .writerId( post.getWriter().getId() );
        List<AttatchmentFileDto> files = post.getAttatchments().stream().map(AttatchmentFileDto::of).toList();
        builder.files( files );
        return builder.build();
    }
}
