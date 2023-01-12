package ir.maktab.data.entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedNativeQuery(name="Clinic.findByName",query = "select * from clinic where name = ?1",resultClass = Clinic.class)
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Doctor> doctorList = new HashSet<>();

    String name;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Clerk> clerk = new HashSet<>();


    @OneToMany(fetch = FetchType.EAGER)
    private Set<Patient> patientList = new HashSet<>();
}
