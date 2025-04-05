package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.Model.Aptitude;
import mmec.ai.placement.ai_placement_app.Repository.AptitudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
