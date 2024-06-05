package rs.ac.singidunum.ispit_zadatak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity(name = "car")
@NoArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer id;

    @Column(nullable = false)
    private String car_manufacturer;
    @Column(nullable = false)
    private String car_model;
    @Column(nullable = false)
    private String car_release_year;

    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;

}
