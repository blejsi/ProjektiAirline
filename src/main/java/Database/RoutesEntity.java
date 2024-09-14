package Database;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "routes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoutesEntity {
    @Id
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "airport_ID")
    private AirportEntity airport;

    @ManyToOne
    @JoinColumn(name= "destination_ID")
    private DestinationEntity destination;

    private Integer frequencies;

    @OneToMany(mappedBy = "routes")
    private List<FlightEntity> flightEntities = new ArrayList<>();


}
