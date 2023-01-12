package ir.maktab.data.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Clerk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String userName;
    String password;

    @OneToMany(fetch = FetchType.EAGER)
    List<Patient> patientList = new ArrayList<>();

    @OneToOne
    Doctor doctor;

}
