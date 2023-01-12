package ir.maktab.data.entity;

import ir.maktab.util.StringListConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@NamedQueries(value = {
        @NamedQuery(name = "User.findByLastname", query = "select p from Patient p where p.fullName = ?1")})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String userName;
    private String password;


    @OneToMany
    private Set<Prescription> prescriptionList = new HashSet<>();


    @Convert(converter = StringListConverter.class)
    private List<String> patientRecords = new ArrayList<>();

    private LocalDateTime reservedTurn;
}
