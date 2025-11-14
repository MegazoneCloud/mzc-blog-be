package mzc.study.blog_be.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mzc.study.blog_be.domain.post.AttatchmentEntity;
import mzc.study.blog_be.domain.post.PostEntity;
import mzc.study.blog_be.repository.post.AttachmentRepository;

@Service
@RequiredArgsConstructor
public class AttatchmentService {
    private final AttachmentRepository repository;

    public AttatchmentEntity create( 
        String filePath,
        String fileName,
        PostEntity post
    ){
        AttatchmentEntity attatchment = AttatchmentEntity.builder()
                                            .filePath(filePath)
                                            .fileName(fileName)
                                            .post(post)
                                            .build();
        post.addAttatchment( attatchment );
        return repository.save( attatchment );
    }
}
