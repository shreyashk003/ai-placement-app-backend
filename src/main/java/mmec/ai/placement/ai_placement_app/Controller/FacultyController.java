package mmec.ai.placement.ai_placement_app.Controller;


import mmec.ai.placement.ai_placement_app.Model.Faculty;
import mmec.ai.placement.ai_placement_app.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class FacultyController {
    @Autowired
    FacultyService facultyService;


    @GetMapping("/getAllFaculty")
    List<Faculty> getAllFaculty(){
    return facultyService.getAllFaculty();
    }

    @PostMapping("/insertFaculty")
    String insertFaculty(@RequestBody Faculty f){
        facultyService.SaveFaculty(f);
        return "Faculty Saved";
    }
}
