package ir.maktab.service;

import ir.maktab.data.entity.Doctor;
import ir.maktab.data.entity.Drug;
import ir.maktab.data.repository.DoctorRepository;
import ir.maktab.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
     public void save(Doctor doctor){
        doctorRepository.save(doctor);
     }
    public Doctor findByCode(String code){
        return doctorRepository.findByCode(code).orElseThrow(()->new NotFoundException("drug is null"));
    }
}
