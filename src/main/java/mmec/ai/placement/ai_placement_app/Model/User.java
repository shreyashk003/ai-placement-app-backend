package mmec.ai.placement.ai_placement_app.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String role;
    String usnorfid;

    //@OneToOne
    //@JoinColumn(name = "usn", referencedColumnName = "usn")  // The foreign key column
    //private Student student;
}
