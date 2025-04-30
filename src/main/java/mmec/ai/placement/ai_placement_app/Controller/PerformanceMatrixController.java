package mmec.ai.placement.ai_placement_app.Controller;

import mmec.ai.placement.ai_placement_app.DTO.StdUsn;
import mmec.ai.placement.ai_placement_app.DTO.StudentScores;
import mmec.ai.placement.ai_placement_app.DTO.UsnSubcode;
import mmec.ai.placement.ai_placement_app.Model.PerformanceMatrix;
import mmec.ai.placement.ai_placement_app.Service.PerformanceMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PerformanceMatrixController {

    @Autowired
    private PerformanceMatrixService performanceMatrixService;

    @PostMapping("/Aptiscore")
    public String setScore(@RequestBody PerformanceMatrix performanceScore) {
        performanceMatrixService.setAptiscore(performanceScore);  // Passing request body to service
        return "Score saved successfully";
    }

    @PostMapping("/Progscore")
    public String setProgScore(@RequestBody PerformanceMatrix performanceScore) {
        System.out.println("I am In PROG");
        performanceMatrixService.setProgscore(performanceScore);  // Passing request body to service
        return " Program Score saved successfully";
    }

    @PostMapping("/getAllScores")
    public List<StudentScores> getAllScore(@RequestBody StdUsn stdusn) {
        System.out.println("usn"+stdusn.getUsn()+"attempt number"+stdusn.getAttempt_no());
        return performanceMatrixService.getAllscore(stdusn.getUsn(),stdusn.getAttempt_no());  // Passing request body to service
    }

    @GetMapping("/getAptiscore/{stdusn}")
    public List<StudentScores> getAllScore(@PathVariable String stdusn) {
        System.out.println(stdusn);
        return performanceMatrixService.getAptiscoreByUsn(stdusn);  // Passing request body to service
    }

    @GetMapping("/studentperformance/{usn}")
    public List<StudentScores> getViewScore(@PathVariable String usn) {
        System.out.println(usn);
        return performanceMatrixService.getViewPerformByUsn(usn);  // Passing request body to service
    }

    @GetMapping("/getUserCompletedTests/{stdusn}")
    public List<StudentScores> getCTest(@PathVariable String stdusn) {
        System.out.println(stdusn);
        return performanceMatrixService.getCtestByUsn(stdusn);  // Passing request body to service
    }

    @GetMapping("/getProgAttempt_no/{stdusn}")
    public List<StudentScores> getProgAttempt_no(@PathVariable String stdusn) {
        System.out.println(stdusn);
        return performanceMatrixService.getProgAttemptByUsn(stdusn);  // Passing request body to service
    }

    @PostMapping("/getTechAttempt_no")
    public List<StudentScores> getTechAttempt_no(@RequestBody UsnSubcode usncode) {
        System.out.println("get attempt number "+usncode.getSub_name());
        System.out.println(usncode.getUsn()+usncode.getSub_name());

        return performanceMatrixService.getTechAttemptByUsn(usncode);  // Passing request body to service
    }

    @PostMapping("/storeScores")
    public String storeAllScore(@RequestBody PerformanceMatrix performanceScore) {
        performanceMatrixService.storeTechscore(performanceScore);  // Passing request body to service
        return " Score saved successfully";
    }
}
