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

}
