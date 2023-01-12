package ir.maktab;

import ir.maktab.config.SpringConfig;
import ir.maktab.data.entity.*;
import ir.maktab.exception.ValidationException;
import ir.maktab.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DoctorService doctorService = context.getBean(DoctorService.class);
        DrugService drugService = context.getBean(DrugService.class);
        PrescriptionService prescriptionService = context.getBean(PrescriptionService.class);
        PatientService patientService = context.getBean(PatientService.class);
        ClercService clercService = context.getBean(ClercService.class);
        ClinicService clinicService = context.getBean(ClinicService.class);
        HospitalService hospitalService = context.getBean(HospitalService.class);

        Doctor doctor = new Doctor();
        doctor.setName("somaye");
        doctor.setCode("123456");
        doctorService.save(doctor);
        Doctor doctor1= doctorService.findByCode("123456");
        System.out.println(doctor1);

        Drug drug1 = new Drug();
        drug1.setNameDrug("a");
        Drug drug2 = new Drug();
        drug2.setNameDrug("b");
        List<Drug> drugList = Arrays.asList(drug1, drug2);
        drugService.saveAll(drugList);

        Prescription prescription = new Prescription();
        Prescription prescription1 = new Prescription();

        prescription.getDrugList().add(drug1);
        prescription.getDrugList().add(drug2);
        prescriptionService.save(prescription);

        prescription1.setDrugList(List.of(drug1,drug2));
         prescriptionService.save(prescription1);
        Set<Prescription> prescriptionList = new HashSet<>();
        prescriptionList.add(prescription);
        List<String> stringList = Arrays.asList("heart", "stomatch");
        Patient patient = Patient.builder().fullName("somaye").
                userName("som").password("12345").
                patientRecords(stringList).prescriptionList(prescriptionList).build();
        patientService.registry(patient);

        Patient patient1=Patient.builder().fullName("esiye").
                userName("ensy").
                password("123").patientRecords(stringList).prescriptionList(Set.of(prescription1)).build();
        patientService.registry(patient1);

        Clerk clerc = Clerk.builder().userName("mahbobeh")
                .password("7865").
                doctor(doctor).build();
        clercService.save(clerc);

        Clinic clinic = new Clinic();
        clinic.setDoctorList(Set.of(doctor));
        clinic.setPatientList(Set.of(patient));
        clinic.setClerk(Set.of(clerc));
        clinic.setName("heart");
        clinicService.save(clinic);
        Clinic clinicHeart = clinicService.getClinic("heart");
        System.out.println(clinicHeart.getDoctorList());

        Hospital hospital = Hospital.builder().clinicList(List.of(clinic)).name("shafa").address("kerman street shafa").build();
        hospitalService.save(hospital);

        try {

            patientService.reservedTurn(clerc, patient);
            patientService.reservedTurn(clerc, patient1);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}