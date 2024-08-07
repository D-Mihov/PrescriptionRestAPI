package bg.softuni.PrescriptionRestAPI.repository;

import bg.softuni.PrescriptionRestAPI.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    Optional<Prescription> findByPatientIdAndAppointmentId(Long patientId, Long appointmentId);

    @Modifying
    @Query("DELETE FROM Prescription p WHERE p.appointmentId = :appointmentId AND p.patientId = :patientId")
    void deleteByAppointmentIdAndPatientId(Long appointmentId, Long patientId);
}
