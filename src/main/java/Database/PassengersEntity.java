package Database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity(name = "passengers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PassengersEntity {

    @Id
    @Column
    private Integer passengerId;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Integer age;
    @Column
    private String gender;

   @ManyToOne
    @JoinColumn(name = "flight_ID")
    private FlightEntity flight = new FlightEntity();

}
