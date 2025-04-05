package mmec.ai.placement.ai_placement_app.Repository;

import mmec.ai.placement.ai_placement_app.Model.Technical_Subject_Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalSkillRepository extends JpaRepository<Technical_Subject_Skill,Long> {
    @Query(value = "select * from technical_subject_skill where sub_name=:subName",nativeQuery = true)
    List<Technical_Subject_Skill> getByName(String subName);
}
