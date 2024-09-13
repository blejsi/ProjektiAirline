package Database;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "flight")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer flightID;

    @Column(nullable = false)
    private String flightNumber;

    @Column
    private String routeID;

    @Column
    private String airlineID;

    @Column
    private String date;

    @Column
    private String departureTime;

    @Column
    private String landingTime;

    @Column
    private String duration;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<EmployeeFlightAssignmentEntity> employeeAssignments = new ArrayList<>();
}

