package mmec.ai.placement.ai_placement_app.Service;

import mmec.ai.placement.ai_placement_app.DTO.StudentScores;
import mmec.ai.placement.ai_placement_app.DTO.UsnSubcode;
import mmec.ai.placement.ai_placement_app.Model.PerformanceMatrix;
import mmec.ai.placement.ai_placement_app.Repository.PerformanceMatrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceMatrixService {
    @Autowired
    PerformanceMatrixRepository performanceMatrixRepository;

    public void setAptiscore(PerformanceMatrix performanceMatrix){
         performanceMatrixRepository.save(performanceMatrix);
    }

    public List<StudentScores> getAptiscoreByUsn(String stdusn){
        List<StudentScores> myScores=performanceMatrixRepository.getAptiscoreByUsn(stdusn);
        myScores.forEach(System.out::println);
        return myScores;
    }

    public List<StudentScores> getProgAttemptByUsn(String stdusn){
        List<StudentScores> myProgScores=performanceMatrixRepository.getProgAttemptByUsn(stdusn);
        myProgScores.forEach(System.out::println);
        return myProgScores;
    }

    public List<StudentScores> getCtestByUsn(String stdusn){
        List<StudentScores> myCtest=performanceMatrixRepository.getCtestByUsn(stdusn);
        //myCtest.forEach(System.out::println);
        return myCtest;
    }

    public List<StudentScores> getViewPerformByUsn(String usn){
        List<StudentScores> myViewPerform=performanceMatrixRepository.findAllScoresByusn(usn);
        myViewPerform.forEach(System.out::println);
        return myViewPerform;
    }

    public List<StudentScores> getTechAttemptByUsn(UsnSubcode usncode){
        List<StudentScores> myTechScores=performanceMatrixRepository.getTechAttemptByUsn(usncode.getUsn(),usncode.getSub_name());
        myTechScores.forEach(System.out::println);
        return myTechScores;
    }

    public void setProgscore(PerformanceMatrix performanceMatrix){
        performanceMatrixRepository.save(performanceMatrix);
    }
    public List<StudentScores> getAllscore(String usn, Integer attemptNo){

        List<StudentScores> sc=performanceMatrixRepository.findAllScoresByusnandAttemptno(usn,attemptNo);
        sc.forEach(System.out::println);
        return sc;
    }
    public void storeTechscore(PerformanceMatrix performanceMatrix){
        performanceMatrixRepository.save(performanceMatrix);
    }

}
