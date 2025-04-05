package mmec.ai.placement.ai_placement_app.Controller;

import mmec.ai.placement.ai_placement_app.Model.PerformanceMatrix;
import mmec.ai.placement.ai_placement_app.Service.PerformanceMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PerformanceMatrixController {

    @Autowired
    private PerformanceMatrixService performanceMatrixService;

    @PostMapping("/score")
    public String setScore(@RequestBody PerformanceMatrix performanceScore) {
        performanceMatrixService.setscore(performanceScore);  // Passing request body to service
        return "Score saved successfully";
    }
}
