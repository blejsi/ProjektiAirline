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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String airline_name;
    @Column
    private String airline_code;
    @Column
    private String country;

   @ManyToMany
    private List<AirportEntity> airport =  new ArrayList<>();


}
