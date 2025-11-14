package mzc.study.blog_be.controller.user;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mzc.study.blog_be.dto.request.user.CreateUserRequest;
import mzc.study.blog_be.dto.response.user.GetUserResponse;
import mzc.study.blog_be.facade.user.UserFacade;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserFacade userFacade;

    @PostMapping("")
    public ResponseEntity<Map<String, Boolean>> register(
        @RequestBody CreateUserRequest request
    ){
        userFacade.createUser( request );
        return ResponseEntity.ok(Map.of( "result", true ));
    }

    @GetMapping("")
    public ResponseEntity<List<GetUserResponse>> getAllUsers(){
        return ResponseEntity.ok( userFacade.getAllUsers() );
    }
}
