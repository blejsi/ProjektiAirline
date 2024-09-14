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
    @Column
    private Integer flightID;

    @Column(nullable = false)
    private String flightNumber;

    @Column
    private String routeID;


    @Column
    private String date;

    @Column
    private String departureTime;

    @Column
    private String landingTime;

    @Column
    private String duration;

    @ManyToMany
    @JoinTable(
            name = "employee_flights",
            joinColumns = {@JoinColumn(name = "flight_ID")},
            inverseJoinColumns = {@JoinColumn(name = "employee_ID")}
    )
    private List<EmployeeEntity> employee = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "airlineId")
    private AirlinesEntity airlines = new AirlinesEntity();


    @OneToMany(mappedBy = "flight")
    private List<PassengersEntity> passengersEntities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "routes_ID")
    private RoutesEntity routes = new RoutesEntity();
}

