package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.Controller.AllConstants;
import mmec.ai.placement.ai_placement_app.Model.Aptitude;
import mmec.ai.placement.ai_placement_app.Repository.AptitudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AptitudeService {
    @Autowired
    AptitudeRepository aptitudeRepository;

    public List<Aptitude> getAptitude(){
      return aptitudeRepository.findAll();
    }

    public void saveAptitude(Aptitude a){
        aptitudeRepository.save(a);

    }

    public List<Aptitude> getRandomAptitudeQuestions(int count) {
        List<Aptitude> allQuestions = aptitudeRepository.findAll();


        // Shuffle to randomize the list
        Collections.shuffle(allQuestions);

        // Return only 'count' number of unique questions
        return allQuestions.stream()
                .limit(count)
                .collect(Collectors.toList());
    }

}
