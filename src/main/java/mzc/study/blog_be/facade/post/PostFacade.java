package mzc.study.blog_be.facade.post;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mzc.study.blog_be.domain.post.PostEntity;
import mzc.study.blog_be.domain.user.UserEntity;
import mzc.study.blog_be.dto.request.post.CreatePostRequest;
import mzc.study.blog_be.dto.response.post.GetPostResponse;
import mzc.study.blog_be.service.AttatchmentService;
import mzc.study.blog_be.service.PostService;
import mzc.study.blog_be.service.UserService;
import mzc.study.blog_be.util.files.FileUtils;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostService postService;
    private final AttatchmentService attatchmentService;
    private final UserService userService;

    private final FileUtils fileUtils;

    @Transactional
    public void createPost( CreatePostRequest request, List<MultipartFile> files ){
        UserEntity writer = userService.findById( request.getWriterid() );
        PostEntity post = postService.create( request.getTitle(), request.getContent(), writer );
        for( MultipartFile file : files ){
            Map<String, String> result = fileUtils.uploadFile( file );
            attatchmentService.create(result.get("filePath"), result.get("filePath"), post);
        }
    }

    public List<GetPostResponse> getPosts() {
        return postService.findAll().stream().map(GetPostResponse::of).toList();
    }
    public GetPostResponse getPost( long id ){
        return GetPostResponse.of(postService.findById( id ));
    }

}
