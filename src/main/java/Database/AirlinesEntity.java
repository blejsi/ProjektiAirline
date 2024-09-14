package Database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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




}
