package mmec.ai.placement.ai_placement_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "performancematrix")
@Data
public class PerformanceMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String usn;
    String sub_name;
    Integer score;
    Integer attempt_no;
    Date quiz_date;
    String timetaken;

    String category;
}
