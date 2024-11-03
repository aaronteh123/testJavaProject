package javatest.com.example.JavaTest.controller;
import javatest.com.example.JavaTest.model.User;
import javatest.com.example.JavaTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> getUser(@PathVariable int userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
}
