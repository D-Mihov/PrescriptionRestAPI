package bg.softuni.PrescriptionRestAPI.web;

import bg.softuni.PrescriptionRestAPI.entity.Prescription;
import bg.softuni.PrescriptionRestAPI.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/patient/{patientId}/appointment/{appointmentId}")
    public Prescription getPrescriptionsByPatientId(@PathVariable Long patientId, @PathVariable Long appointmentId) {
        return prescriptionService.getPrescriptionsByPatientId(appointmentId, patientId);
    }

    @PostMapping
    public Prescription addPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.addPrescription(prescription);
    }

    @DeleteMapping("/patient/{patientId}/appointment/{appointmentId}")
    public void deletePrescription(@PathVariable Long patientId, @PathVariable Long appointmentId) {
        prescriptionService.deletePrescription(appointmentId, patientId);
    }
}
