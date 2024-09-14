package Database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "airlines")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AirlinesEntity {

    @Id
    @Column
    private Integer airlineId;
    @Column
    private String airlineName;
    @Column
    private String IATACode;
    @Column
    private Integer fleet;
    @Column
    private Integer employees;
    @Column
    private String country;

  @OneToMany(mappedBy = "airlines")
  private List<FlightEntity> flights = new ArrayList<FlightEntity>();


}
