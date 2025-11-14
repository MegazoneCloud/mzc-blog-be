
package mzc.study.blog_be.controller.user;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mzc.study.blog_be.facade.user.AuthFacade;

@RestController
@RequestMapping( "/api/v1/auth" )
@RequiredArgsConstructor
public class AuthController {
    private final AuthFacade authFacade;

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> login(
        @RequestParam String email,
        @RequestParam String password
    ){
        return ResponseEntity.ok( authFacade.login( email, password ) );
    }

}
