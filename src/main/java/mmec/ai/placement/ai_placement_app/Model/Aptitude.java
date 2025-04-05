package mmec.ai.placement.ai_placement_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "aptitude")
public class Aptitude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long q_no;
    String question;
    String option_1;
    String option_2;
    String option_3;
    String option_4;
    Integer correct_ans_no;
    String category;
}
