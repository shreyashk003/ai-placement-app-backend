package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.Model.Aptitude;
import mmec.ai.placement.ai_placement_app.Model.ProgramSkill;
import mmec.ai.placement.ai_placement_app.Repository.ProgramSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProgramSkill> getRandomProgramSkills(int count) {
        List<ProgramSkill> allQuestions = programSkillRepository.findAll();

        // Shuffle for randomness
        Collections.shuffle(allQuestions);

        // Return only the first 'count' unique entries
        return allQuestions.stream()
                .limit(count)
                .collect(Collectors.toList());
    }

}
