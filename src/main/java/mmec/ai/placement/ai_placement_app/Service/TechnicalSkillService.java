package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.Model.Aptitude;
import mmec.ai.placement.ai_placement_app.Model.Technical_Subject_Skill;
import mmec.ai.placement.ai_placement_app.Repository.TechnicalSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Technical_Subject_Skill> getRandomTechnicalSkillByName(String subName, int count) {
        List<Technical_Subject_Skill> filteredQuestions = technicalSkillRepository.getByName(subName);

        // Shuffle the filtered list
        Collections.shuffle(filteredQuestions);

        // Return only 'count' random, unique questions
        return filteredQuestions.stream()
                .limit(count)
                .collect(Collectors.toList());
    }


}
