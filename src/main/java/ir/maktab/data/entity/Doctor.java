package ir.maktab.data.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NamedQueries(value ={@NamedQuery(name="Drug.findByCode",query = "select d from Doctor d where d.code = ?1")})

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

}
