package Database;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity(name = "employee_flight_assignment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeFlightAssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "uniqueID")
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "flightID")
    private FlightEntity flight;

    @Column
    private String role;

    @Column
    private String status;
}

