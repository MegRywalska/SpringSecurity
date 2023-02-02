package mryw.exercises.springsecurity.registration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String plateNo;
    private String personName;
    private String title;
    private String description;
    private Boolean approved;

    public Registration() {
        super();
        this.approved = Boolean.FALSE;
    }

    public Registration(Long id, String brand, String plateNo, String personName, String title, String description) {
        super();
        this.id = id;
        this.brand = brand;
        this.plateNo = plateNo;
        this.personName = personName;
        this.title = title;
        this.description = description;
        this.approved = Boolean.FALSE;
    }
}
