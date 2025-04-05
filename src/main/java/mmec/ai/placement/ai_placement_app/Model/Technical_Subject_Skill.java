package mmec.ai.placement.ai_placement_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "technical_Subject_Skill")
public class Technical_Subject_Skill {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long q_no;
    String sub_name;
    String branch_name;
    String question;
    String option_1;
    String option_2;
    String option_3;
    String option_4;
    Integer correct_ans;

}
