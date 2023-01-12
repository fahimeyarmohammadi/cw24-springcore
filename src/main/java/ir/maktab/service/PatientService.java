package ir.maktab.service;

import ir.maktab.data.entity.Clerk;
import ir.maktab.data.entity.Patient;
import ir.maktab.data.repository.PatientRepository;
import ir.maktab.exception.NotFoundException;
import ir.maktab.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    @Autowired
    private ClercService clercService;

    public PatientService(PatientRepository patientRepository) {

        this.patientRepository = patientRepository;
    }

    public void registry(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient findByUserNameAndPassword(String password, String userName) {
        Optional<Patient> optionalPatient = patientRepository.findByPasswordAndUserName(password, userName);
        if (optionalPatient.isPresent()) return optionalPatient.get();
        else throw new NotFoundException("patient is null");
    }

    public void reservedTurn(Clerk clerk, Patient patient) {
        int start = 15;
        LocalDateTime today = LocalDateTime.now();
        Clerk clerk1 = clercService.login(clerk.getUserName(), clerk.getPassword());
        int size = 0;
        if (clerk1.getPatientList() != null) {
            size = clerk1.getPatientList().size();
        } else size = 0;
        if (today.getDayOfWeek().equals("FRIDAY") || today.getDayOfWeek().equals("THURSDAY") || today.getHour() > 14)
            throw new ValidationException("You can't make a turn on this day.");
        if (size <= 10) {
            LocalDateTime timeReserve = timeset(start, today, size);
            Patient newPatient = updatePatient(patient, timeReserve);
            System.out.println(timeReserve);

            if (clerk1.getPatientList() == null)
                clerk1.setPatientList(List.of(newPatient));
            else {
                clerk1.getPatientList().add(newPatient);
            }
            clercService.updateClerk(clerk1);
        } else {
            throw new ValidationException("The innings have been resused.");
        }
    }


    private Patient updatePatient(Patient patient, LocalDateTime timeReserve) {
        Patient newPatient = findByUserNameAndPassword(patient.getPassword(), patient.getUserName());
        newPatient.setReservedTurn(timeReserve);
        patientRepository.save(newPatient);
        return newPatient;
    }

    private static LocalDateTime timeset(int start, LocalDateTime today, int size) {
        double timeReserve = (size * 0.5 + start) * 10;
        int hour = (int) (timeReserve / 10);
        LocalDateTime localDateTime = today.withHour(hour);
        LocalDateTime timereserv = localDateTime.withMinute((int) timeReserve % 10 == 0 ? 0 : 30);
        return timereserv;

    }

}




