package rs.ac.singidunum.ispit_zadatak.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CarModel {
    private String manufacturer;
    private String model;
    private String release_year;
    private Integer partId;
}
