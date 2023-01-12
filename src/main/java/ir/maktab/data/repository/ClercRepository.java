package ir.maktab.data.repository;

import ir.maktab.data.entity.Clerk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClercRepository extends JpaRepository<Clerk, Long> {

    Optional<Clerk> findClerkByUserNameAndPassword(String userNAme, String password);


}
