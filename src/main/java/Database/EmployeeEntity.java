package Database;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeEntity {

    @Id
    @Column
    private Integer employee_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column
    private Integer age;

    @Column
    private String gender;

    @Column
    private String status;

    @Column
    private String phoneNumber;

    @Column
    private String airportIDNumber;

    @ManyToMany(mappedBy = "employee")
    private List<FlightEntity> flights = new ArrayList<>();

}

