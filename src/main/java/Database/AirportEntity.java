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
    @Column
    private Integer airportId;
    @Column
    private String airportName;
    @Column
    private String IATACode;
    @Column
    private String country;


    @OneToMany(mappedBy = "airport")
    private List<DestinationEntity> destinations = new ArrayList<DestinationEntity>();

    @OneToMany(mappedBy = "airport")
    private List<RoutesEntity> routesEntities;

    @Override
    public String toString() {
        return "AirportEntity{" +
                "airportId=" + airportId +
                ", airportName='" + airportName + '\'' +
                ", IATACode='" + IATACode + '\'' +
                ", country='" + country + '\'' +
                ", destinations=" + destinations +
                '}';
    }
}
