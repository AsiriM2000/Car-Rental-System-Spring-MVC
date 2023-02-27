package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver {

    @Id
    private String driverEmail;
    private String driverName;
    private String driverAddress;
    private String driverAge;
    private String driverContact;
//    @OneToMany(mappedBy = "driverEmail", cascade = CascadeType.ALL)
//    private List<RentDetail> rental_details = new ArrayList<>();
}
