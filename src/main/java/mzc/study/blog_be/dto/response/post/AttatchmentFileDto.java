package mzc.study.blog_be.dto.response.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mzc.study.blog_be.domain.post.AttatchmentEntity;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttatchmentFileDto {
    private Long id;
    private String filePath;
    private String fileName;

    public static AttatchmentFileDto of( AttatchmentEntity attatchment ){
        return AttatchmentFileDto.builder()
                .fileName( attatchment.getFileName() )
                .filePath( attatchment.getFilePath() )
                .id( attatchment.getId() )
                .build();
    }
}
