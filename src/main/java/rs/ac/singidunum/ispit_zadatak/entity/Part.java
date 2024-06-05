package rs.ac.singidunum.ispit_zadatak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "part")


public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private Integer id;
    @Column
    private String name;
    @Column
    private String fuel_type;
    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;
}
