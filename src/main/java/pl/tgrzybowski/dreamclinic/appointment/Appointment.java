package pl.tgrzybowski.dreamclinic.appointment;

import lombok.Data;
import pl.tgrzybowski.dreamclinic.appointment.api.AppointmentCreateDto;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;
import pl.tgrzybowski.dreamclinic.patient.Patient;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    private String reason;
    private String comment;
    private String symptom;

    private Date date;

    private Integer hourFrom;
    private Integer hourTo;


    public AppointmentCreateDto toDto() {
        AppointmentCreateDto dto = new AppointmentCreateDto();
        dto.setComment(this.comment);
        dto.setReason(this.reason);
        dto.setDate(this.date);
        dto.setPatientId(this.patient.getId());
        dto.setDoctorId(this.getDoctor().getId());
        dto.setHourFrom(this.getHourFrom());
        dto.setHourTo(this.getHourTo());
        return dto;
    }
}
