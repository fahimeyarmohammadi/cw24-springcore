package ir.maktab.data.repository;

import ir.maktab.data.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
   Optional<Patient>  findByPasswordAndUserName(String password, String userName);
  List<Patient> findByFullNameLike(String fullName);

}
