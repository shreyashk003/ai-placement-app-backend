package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.Model.Student;
import mmec.ai.placement.ai_placement_app.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<Student> getStudents(){
      return studentRepository.findAll();
    }

    public void storeInDatabase(Student s){
        studentRepository.save(s);

    }

    public List<Student> getStudentByUsn(String usn){
         return studentRepository.getstdByUsn((usn));
    }
}
