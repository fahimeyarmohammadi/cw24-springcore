package ir.maktab.data.repository;

import ir.maktab.data.entity.Doctor;
import ir.maktab.data.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {
    Optional<Doctor> findByCode(String code);
}
