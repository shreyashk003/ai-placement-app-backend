package mmec.ai.placement.ai_placement_app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScores {
    String usn;
    String sub_name;
    Integer attempt_no;
    Integer score;
    Date quiz_date;
    String timetaken;
}
