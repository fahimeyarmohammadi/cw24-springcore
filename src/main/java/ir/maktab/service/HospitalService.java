package ir.maktab.service;

import ir.maktab.data.entity.Clinic;
import ir.maktab.data.entity.Hospital;
import ir.maktab.data.repository.HospitalRepository;
import ir.maktab.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<Clinic> getClinics(String hospitalName) {
        Optional<Hospital> optionalHospital = hospitalRepository.findByName(hospitalName);
        return optionalHospital.orElseThrow(()->new NotFoundException("hospital is null")).getClinicList();

    }
    public void save(Hospital hospital){
        hospitalRepository.save(hospital);
    }
}
