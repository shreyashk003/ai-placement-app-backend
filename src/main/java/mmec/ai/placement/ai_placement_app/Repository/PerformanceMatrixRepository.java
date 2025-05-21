package mmec.ai.placement.ai_placement_app.Repository;

import mmec.ai.placement.ai_placement_app.DTO.StudentScores;
import mmec.ai.placement.ai_placement_app.Model.PerformanceMatrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceMatrixRepository extends JpaRepository<PerformanceMatrix,Long> {
@Query(value ="select sub_name,attempt_no,score from performancematrix where usn=:usn",nativeQuery = true)
    public List<StudentScores> findScoresByusn(String usn);

    @Query(value ="select usn,sub_name,attempt_no,score,quiz_date,timetaken from performancematrix where usn=:usn",nativeQuery = true)
    public List<StudentScores> findAllScoresByusn(String usn);

    @Query(value ="select usn,sub_name,attempt_no,score,quiz_date,timetaken from performancematrix where usn=:usn and attempt_no=:attemptNo",nativeQuery = true)
    public List<StudentScores> findAllScoresByusnandAttemptno(String usn, Integer attemptNo);

    @Query(value ="select usn,sub_name,attempt_no,score,quiz_date,timetaken from performancematrix where usn=:usn and sub_name='Apti'",nativeQuery = true)
    public List<StudentScores> getAptiscoreByUsn(String usn);

    @Query(value ="select usn,sub_name,attempt_no,score,quiz_date,timetaken from performancematrix where usn=:usn and sub_name='Program-Skill'",nativeQuery = true)
    public List<StudentScores> getProgAttemptByUsn(String usn);

    @Query(value = "SELECT usn, sub_name, attempt_no, score, quiz_date, timetaken FROM performancematrix WHERE usn = :usn AND sub_name != 'Apti'", nativeQuery = true)
    public List<StudentScores> getCtestByUsn(String usn);


    @Query(value ="select usn,sub_name,attempt_no,score,quiz_date,timetaken from performancematrix where usn=:usn and sub_name=:scode",nativeQuery = true)
    public List<StudentScores> getTechAttemptByUsn(String  usn,String scode);


    @Modifying

    @Query(value = "UPDATE performancematrix SET Cat_1 = Cat_1 + 1 WHERE attempt_no = :attemptNo AND usn = :usn AND sub_name = :subName", nativeQuery = true)
    void incrementCat1(@Param("attemptNo") int attemptNo, @Param("usn") String usn, @Param("subName") String subName);

    @Modifying
    @Query(value = "UPDATE performancematrix SET Cat_2 = Cat_2 + 1 WHERE attempt_no = :attemptNo AND usn = :usn AND sub_name = :subName", nativeQuery = true)
    void incrementCat2(@Param("attemptNo") int attemptNo, @Param("usn") String usn, @Param("subName") String subName);

    @Modifying
    @Query(value = "UPDATE performancematrix SET Cat_3 = Cat_3 + 1 WHERE attempt_no = :attemptNo AND usn = :usn AND sub_name = :subName", nativeQuery = true)
    void incrementCat3(@Param("attemptNo") int attemptNo, @Param("usn") String usn, @Param("subName") String subName);

    @Modifying
    @Query(value = "UPDATE performancematrix SET Cat_4 = Cat_4 + 1 WHERE attempt_no = :attemptNo AND usn = :usn AND sub_name = :subName", nativeQuery = true)
    void incrementCat4(@Param("attemptNo") int attemptNo, @Param("usn") String usn, @Param("subName") String subName);

    @Modifying
    @Query(value = "UPDATE performancematrix SET Cat_5 = Cat_5 + 1 WHERE attempt_no = :attemptNo AND usn = :usn AND sub_name = :subName", nativeQuery = true)
    void incrementCat5(@Param("attemptNo") int attemptNo, @Param("usn") String usn, @Param("subName") String subName);

    @Modifying
    @Query(value = "UPDATE performancematrix SET Cat_6 = Cat_6 + 1 WHERE attempt_no = :attemptNo AND usn = :usn AND sub_name = :subName", nativeQuery = true)
    void incrementCat6(@Param("attemptNo") int attemptNo, @Param("usn") String usn, @Param("subName") String subName);


    @Modifying
    @Query(value = "UPDATE performancematrix SET Cat_7 = Cat_7 + 1 WHERE attempt_no = :attemptNo AND usn = :usn AND sub_name = :subName", nativeQuery = true)
    void incrementCat7(@Param("attemptNo") int attemptNo, @Param("usn") String usn, @Param("subName") String subName);

}


