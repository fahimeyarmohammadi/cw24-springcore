package ir.maktab.service;

import ir.maktab.data.entity.Clerk;
import ir.maktab.data.entity.Patient;
import ir.maktab.data.repository.ClercRepository;
import ir.maktab.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClercService {

    private final ClercRepository clercRepository;

    public ClercService(ClercRepository clercRepository) {
        this.clercRepository = clercRepository;
    }

    public void save(Clerk clerk) {
        clercRepository.save(clerk);
    }

    public Clerk login(String username, String password) {
        Optional<Clerk> optionalClerc = clercRepository.findClerkByUserNameAndPassword(username, password);
        return optionalClerc.orElseThrow(() -> new NotFoundException("clerc is null"));
    }
    public void updateClerk(Clerk clerk){
        Clerk newClerk = clercRepository.findClerkByUserNameAndPassword(clerk.getUserName(), clerk.getPassword()).get();
        newClerk.setPatientList(clerk.getPatientList());
        clercRepository.save(newClerk);
    }

}
