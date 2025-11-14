package mzc.study.blog_be.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mzc.study.blog_be.domain.post.PostEntity;
import mzc.study.blog_be.domain.user.UserEntity;
import mzc.study.blog_be.repository.post.PostRepository;
import mzc.study.blog_be.util.exception.ServerException;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    @Transactional
    public PostEntity create(
        String title,
        String content,
        UserEntity writer
    ){
        PostEntity post = PostEntity.builder()
                            .title( title )
                            .content( content )
                            .writer( writer )
                            .build();
        return repository.save( post );
    }

    @Transactional
    public void update( long id, String title, String content ){
        PostEntity post = repository.findById( id ).orElseThrow( () -> new ServerException("해당하는 게시글이 존재하지 않습니다") );
        post.update( title, content );
    }

    public PostEntity findById( long id ){
        return repository.findById( id ).orElseThrow( () -> new ServerException("해당하는 게시글이 존재하지 않습니다") );
    }
    public List<PostEntity> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void delete( long id ){
        repository.findById( id ).orElseThrow( () -> new ServerException("해당하는 게시글이 존재하지 않습니다") );
        repository.deleteById( id );
    }

}
