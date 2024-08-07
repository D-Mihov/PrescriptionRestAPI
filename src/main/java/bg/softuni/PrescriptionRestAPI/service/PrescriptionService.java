package bg.softuni.PrescriptionRestAPI.service;

import bg.softuni.PrescriptionRestAPI.entity.Prescription;
import bg.softuni.PrescriptionRestAPI.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription getPrescriptionsByPatientId(Long appointmentId, Long patientId) {
        Optional<Prescription> optionalPrescription = prescriptionRepository.findByPatientIdAndAppointmentId(patientId, appointmentId);
        if (optionalPrescription.isEmpty()) {
            return new Prescription();
        }
        return optionalPrescription.get();
    }

    public Prescription addPrescription(Prescription prescription) {
        prescription.setIssuedAt(new Timestamp(System.currentTimeMillis()));
        return prescriptionRepository.save(prescription);
    }

    @Transactional
    public void deletePrescription(Long appointmentId, Long patientId) {
        prescriptionRepository.deleteByAppointmentIdAndPatientId(appointmentId, patientId);
    }
}
