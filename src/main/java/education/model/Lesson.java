package education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    private String name;
    private String duration;
    private String lectureName;
    private double price;


}
