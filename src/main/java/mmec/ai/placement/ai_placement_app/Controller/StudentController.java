package mmec.ai.placement.ai_placement_app.Controller;

import mmec.ai.placement.ai_placement_app.Model.Student;
import mmec.ai.placement.ai_placement_app.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping("/getAllStudent")
    List<Student> getStudent(){
    return studentService.getStudents();
    }


    @PostMapping("/saveStudent")
    public String storeStudent(@RequestBody Student s){
          studentService.storeInDatabase(s);
          return "Student Info Saved In Database";
    }
    @GetMapping("/getbyusn/{usn}")
    public List<Student> getStudentByUsn(@PathVariable("usn") String usn){
        return studentService.getStudentByUsn(usn);
    }

}
