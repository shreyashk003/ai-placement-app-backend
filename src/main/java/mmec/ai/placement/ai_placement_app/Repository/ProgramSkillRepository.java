package mmec.ai.placement.ai_placement_app.Repository;

import mmec.ai.placement.ai_placement_app.Model.ProgramSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramSkillRepository extends JpaRepository<ProgramSkill,Long> {
}
