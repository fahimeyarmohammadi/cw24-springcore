package ir.maktab.service;

import ir.maktab.data.entity.Clinic;
import ir.maktab.data.repository.ClinicRepository;
import ir.maktab.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicService {
    private final ClinicRepository clinicRepository;

    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public void save(Clinic clinic) {
        clinicRepository.save(clinic);
    }

    public Clinic getClinic(String name) {
        Optional<Clinic> optionalClinic = clinicRepository.findByName(name);
        return optionalClinic.orElseThrow(() -> new NotFoundException("clinic is null"));
    }
}
