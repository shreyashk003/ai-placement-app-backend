package mmec.ai.placement.ai_placement_app.Repository;

import mmec.ai.placement.ai_placement_app.Controller.FacultyController;
import mmec.ai.placement.ai_placement_app.DTO.UserFaculty;
import mmec.ai.placement.ai_placement_app.DTO.UserStudent;
import mmec.ai.placement.ai_placement_app.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    @Query(value = "select username,password, role, u.usnorfid,name, department from user u,faculty f where username=:username and password=:password and u.usnorfid=f.fid",nativeQuery = true)
    List<UserFaculty> getByusernamepassword(String username, String password);
}
