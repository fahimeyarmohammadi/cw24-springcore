package ir.maktab.data.repository;

import ir.maktab.data.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    Optional<Hospital> findByName(String name);
}
