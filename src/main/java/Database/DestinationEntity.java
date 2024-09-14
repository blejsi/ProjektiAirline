package Database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name="destination")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DestinationEntity {
    @Id
    @Column
    private Integer id;
    @Column
    private String airline_name;
    @Column
    private String airline_code;
    @Column
    private String country;

   @ManyToOne
   @JoinColumn(name = "airport")
    private AirportEntity airport = new AirportEntity();

   @OneToMany(mappedBy = "destination")
   private List<RoutesEntity> routes = new ArrayList<>();

    @Override
    public String toString() {
        return "DestinationEntity{" +
                "id=" + id +
                ", airline_name='" + airline_name + '\'' +
                ", airline_code='" + airline_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
