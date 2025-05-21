package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.DTO.UserFaculty;
import mmec.ai.placement.ai_placement_app.DTO.UserStudent;
import mmec.ai.placement.ai_placement_app.Model.User;
import mmec.ai.placement.ai_placement_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsersFromDatabase(){
        return userRepository.findAll();
    }

    public List<UserStudent> getByUP(String u, String p){

        System.out.println(userRepository.getByusernamepassword(u,p));
        return userRepository.getByusernamepassword(u,p);
    }
    public List<UserFaculty> getByUP1(String u, String p){
        return userRepository.getByusernamepassword1(u,p);
    }
    public List<UserFaculty> getByUP2(String u, String p){
        return userRepository.getByusernamepassword2(u,p);
    }


    public void storeInDatabase(User u){
        userRepository.save(u);
    }
}
