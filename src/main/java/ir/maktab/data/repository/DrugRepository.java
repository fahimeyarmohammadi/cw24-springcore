package ir.maktab.data.repository;

import ir.maktab.data.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrugRepository extends JpaRepository<Drug,Long> {

}
