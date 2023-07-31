package money.jupiter.studentmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {


    private String firstName;
    private String lastName;
    private int std;
    private String id;

}
