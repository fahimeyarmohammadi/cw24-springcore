package ir.maktab.service;

import ir.maktab.data.entity.Prescription;
import ir.maktab.data.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {
  private final  PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public void save(Prescription prescription){
        prescriptionRepository.save(prescription);
    }
}
