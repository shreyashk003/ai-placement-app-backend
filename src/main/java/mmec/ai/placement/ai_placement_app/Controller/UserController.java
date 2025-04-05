package mmec.ai.placement.ai_placement_app.Controller;

import mmec.ai.placement.ai_placement_app.DTO.UserFaculty;
import mmec.ai.placement.ai_placement_app.DTO.UserStudent;
import mmec.ai.placement.ai_placement_app.Model.User;
import mmec.ai.placement.ai_placement_app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getUsers(){
        return userService.getUsersFromDatabase();
    }

    @PostMapping ("/StudentLogin")
    public List<UserStudent> getLogin(@RequestBody User u){
        System.out.println(u.getUsername()+"  "+u.getPassword());
        return userService.getByUP(u.getUsername(),u.getPassword());
    }

    @PostMapping ("/FacultyLogin")
    public List<UserFaculty> getFLogin(@RequestBody User u){
        System.out.println(u.getUsername()+"  "+u.getPassword());
        return userService.getByUP1(u.getUsername(),u.getPassword());
    }
    @PostMapping ("/AdminLogin")
    public List<UserFaculty> getALogin(@RequestBody User u){
        System.out.println(u.getUsername()+"  "+u.getPassword());
        return userService.getByUP2(u.getUsername(),u.getPassword());
    }




    @PostMapping("/storeUser")
    public String saveUser(@RequestBody User u){
        userService.storeInDatabase(u);
        return "User saved in Database";
    }
}
