package mmec.ai.placement.ai_placement_app.Controller;

import mmec.ai.placement.ai_placement_app.Model.Technical_Subject_Skill;
import mmec.ai.placement.ai_placement_app.Service.TechnicalSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class TechnicalSkillController {
    @Autowired
    TechnicalSkillService technicalSkillService;

    @GetMapping("/getTechnicalSkill")
    List<Technical_Subject_Skill> getTechnicalSkill(){
        return technicalSkillService.getTechnicalSkill();
    }
    @GetMapping("/getTechSubQuestionsByName/{sub_name}")
    List<Technical_Subject_Skill> getTechnicalSkillByname(@PathVariable String sub_name) {
        System.out.println(sub_name);
        return technicalSkillService.getRandomTechnicalSkillByName( sub_name, AllConstants.TECH_RANDOM_QUESTION_COUNT);
    }


    @PostMapping("/insertTechnicalQuestion")
    String insertTechnicalSkill(@RequestBody Technical_Subject_Skill t){
        technicalSkillService.saveTechnicalSkill(t);
        return "Technical Skill inserted";
    }

}
