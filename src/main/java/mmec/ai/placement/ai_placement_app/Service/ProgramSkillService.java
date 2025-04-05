package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.Model.Aptitude;
import mmec.ai.placement.ai_placement_app.Model.ProgramSkill;
import mmec.ai.placement.ai_placement_app.Repository.ProgramSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramSkillService {
    @Autowired
    ProgramSkillRepository programSkillRepository;

    public List<ProgramSkill> getProgramSkill(){
        return programSkillRepository.findAll();
    }

    public void saveProgramSkillQuestion(ProgramSkill p){
        programSkillRepository.save(p);

    }
}
