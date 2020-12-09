package security.demo.SecurityDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class Controller {
    @GetMapping("/hello-world")
    public String test(){
        return "Hello World!";
    }

    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping("/all-managers")
    public List<Manager> getManagers() {
        return managerRepository.findAll();
    }
//    @GetMapping("/all-managers")
//    public List<Manager> getAllManager(){
//        return managerRepository.findAll();
//    }
    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody Employee user) {
        String result = "";
        HttpStatus httpStatus = null;
        try {
            if (userService.checkLogin(user)) {
                result = jwtTokenProvider.generateToken(user.getUsername());
                httpStatus = HttpStatus.OK;
            } else {
                result = "Wrong userId and password";
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception ex) {
            result = "Server Error";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<String>(result, httpStatus);
    }
}

