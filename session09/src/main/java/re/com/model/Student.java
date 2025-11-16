package re.com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "student_name")
    private String studentName;
    @ManyToMany(mappedBy = "listStudents")
    private List<Classs> listClass;
}
