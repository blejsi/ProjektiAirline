package Database;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "airport")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer airportId;
    @Column
    private String airportName;
    @Column
    private String IATACode;
    @Column
    private String country;


    @ManyToMany(mappedBy = "airport")
    private List<DestinationEntity> destinations = new ArrayList<DestinationEntity>();





}
