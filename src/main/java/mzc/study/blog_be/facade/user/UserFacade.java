package mzc.study.blog_be.facade.user;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mzc.study.blog_be.dto.request.user.CreateUserRequest;
import mzc.study.blog_be.dto.response.user.GetUserResponse;
import mzc.study.blog_be.service.UserService;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;

    public void createUser( CreateUserRequest request ){
        userService.create( request.getEmail(), request.getPassword(), request.getName(), request.getNickname() );
    }

    public List<GetUserResponse> getAllUsers(){
        return userService.findAll().stream().map( GetUserResponse::of ).toList();
    }
}
