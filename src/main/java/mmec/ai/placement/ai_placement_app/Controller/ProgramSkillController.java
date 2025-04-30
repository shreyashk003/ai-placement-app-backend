package mmec.ai.placement.ai_placement_app.Controller;

import mmec.ai.placement.ai_placement_app.Model.Aptitude;
import mmec.ai.placement.ai_placement_app.Model.ProgramSkill;
import mmec.ai.placement.ai_placement_app.Repository.ProgramSkillRepository;
import mmec.ai.placement.ai_placement_app.Service.ProgramSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class ProgramSkillController {
    @Autowired
    ProgramSkillService programSkillService;

    @GetMapping("/getAllProgramQuestions")
    List<ProgramSkill> getProgramSkill(){
    return programSkillService.getRandomProgramSkills(AllConstants.PROG_RANDOM_QUESTION_COUNT);
    }

    @PostMapping("/insertProgramProblemStatement")
    String insertProgramQuestion(@RequestBody ProgramSkill p){
        programSkillService.saveProgramSkillQuestion(p);
        return "Program Statement saved";
    }
}
