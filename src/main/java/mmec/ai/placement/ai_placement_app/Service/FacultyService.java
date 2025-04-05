package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.DTO.UserFaculty;
import mmec.ai.placement.ai_placement_app.Model.Faculty;
import mmec.ai.placement.ai_placement_app.Repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository facultyRepository;


    public List<Faculty> getAllFaculty(){
        return facultyRepository.findAll();
    }

    public List<UserFaculty> getByUP(String u, String p){
        return facultyRepository.getByusernamepassword(u,p);
    }

    public void SaveFaculty(Faculty f){
        facultyRepository.save(f);
    }
}
