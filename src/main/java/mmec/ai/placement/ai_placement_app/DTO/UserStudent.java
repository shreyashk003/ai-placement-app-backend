package mmec.ai.placement.ai_placement_app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mmec.ai.placement.ai_placement_app.Model.Student;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStudent {
    String username;
    String password;
    String role;
    String usn;
    String stdname;
    Integer sem;
    String branch;
    Float SSLCScore;
    Float PUCScore;
    Float BE1Score;
    Float BE2Score;
    Float BE3Score;
}

