package frapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired private UserRepository userRepository;

  @PostMapping(value = "/user/signup")
  public void addUser(@RequestBody Map<String, String> body) {
    userRepository.save(
      new User( body.get("firstName"),
                body.get("lastName"),
                body.get("userName"),
                body.get("email"),
                body.get("password"),
                body.get("dateOfBirth")
              )
    );
  }
}