package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.Model.PerformanceMatrix;
import mmec.ai.placement.ai_placement_app.Repository.PerformanceMatrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceMatrixService {
    @Autowired
    PerformanceMatrixRepository performanceMatrixRepository;

    public void setscore(PerformanceMatrix performanceMatrix){
         performanceMatrixRepository.save(performanceMatrix);
    }


}
