package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.Model.Aptitude;
import mmec.ai.placement.ai_placement_app.Model.Technical_Subject_Skill;
import mmec.ai.placement.ai_placement_app.Repository.TechnicalSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalSkillService {
    @Autowired
    TechnicalSkillRepository technicalSkillRepository;

    public List<Technical_Subject_Skill> getTechnicalSkill(){
        return technicalSkillRepository.findAll();
    }

    public void saveTechnicalSkill(Technical_Subject_Skill t){
        technicalSkillRepository.save(t);

    }

    public List<Technical_Subject_Skill> getTechnicalSkillByname(String subName) {
        return technicalSkillRepository.getByName(subName);
    }
}
