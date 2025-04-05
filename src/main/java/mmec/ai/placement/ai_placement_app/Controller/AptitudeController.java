package mmec.ai.placement.ai_placement_app.Controller;

import mmec.ai.placement.ai_placement_app.Model.Aptitude;
import mmec.ai.placement.ai_placement_app.Service.AptitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class AptitudeController {
    @Autowired
    AptitudeService aptitudeService;
    @GetMapping("/getAllAptitudeQuestions")
    List<Aptitude> getAptitude(){
        return aptitudeService.getAptitude();
    }

    @PostMapping("/insertAptitude")
    String insertAptitude(@RequestBody Aptitude a){
        aptitudeService.saveAptitude(a);
        return "Aptitude saved";
    }
}
