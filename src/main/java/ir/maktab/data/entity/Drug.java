package ir.maktab.data.entity;



import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Drug {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String nameDrug;
}
