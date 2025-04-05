package mmec.ai.placement.ai_placement_app.Repository;

import mmec.ai.placement.ai_placement_app.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value="select * from student where usn=:usn",nativeQuery = true)
    public List<Student> getstdByUsn(@Param("usn") String usn);
}
