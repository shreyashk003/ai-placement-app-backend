package mmec.ai.placement.ai_placement_app.Repository;

import mmec.ai.placement.ai_placement_app.DTO.UserFaculty;
import mmec.ai.placement.ai_placement_app.DTO.UserStudent;
import mmec.ai.placement.ai_placement_app.Model.Technical_Subject_Skill;
import mmec.ai.placement.ai_placement_app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select username,password, role, u.usnorfid,stdname, sem, branch,SSLCScore,PUCScore,BE1Score,BE2Score,BE3Score from user u,student s where username=:username and password=:password and u.usnorfid=s.usn",nativeQuery = true)
    List<UserStudent> getByusernamepassword(String username, String password);

    @Query(value = "select username,password, role, u.usnorfid,name from user u,faculty f where username=:username and password=:password and u.usnorfid=f.fid",nativeQuery = true)
    List<UserFaculty> getByusernamepassword1(String username, String password);

    @Query(value = "select username,password, role, u.usnorfid,name from user u,faculty f where username=:username and password=:password and u.usnorfid=f.fid",nativeQuery = true)
    List<UserFaculty> getByusernamepassword2(String username, String password);
}
