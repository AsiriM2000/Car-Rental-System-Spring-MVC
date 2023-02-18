package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver {

    @Id
    private String driverEmail;
    private String driverName;
    private String driverAddress;
    private String driverAge;
    private String driverContact;
}
