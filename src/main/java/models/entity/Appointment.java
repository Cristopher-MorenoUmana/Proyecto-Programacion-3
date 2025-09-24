package models.entity;

import java.io.Serializable;
import java.util.Collection;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import models.dto.AppointmentDto;

@Entity
@Table(name = "TBL_APPOINTMENT")
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findByApId", query = "SELECT a FROM Appointment a WHERE a.apId = :apId"),
    @NamedQuery(name = "Appointment.findByApLocalDate", query = "SELECT a FROM Appointment a WHERE a.apDate = :apDate"),
    @NamedQuery(name = "Appointment.findByApState", query = "SELECT a FROM Appointment a WHERE a.apState = :apState")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @Basic(optional = false)
    @Column(name = "AP_ID")
    private Integer apId;
    @Basic(optional = false)
    @Column(name = "AP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate apDate;
    @Basic(optional = false)
    @Column(name = "AP_STATE")
    private String apState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suAppointmentId", fetch = FetchType.EAGER)
    private Collection<Surgery> surgeryCollection;
    @JoinColumn(name = "AP_CLIENT_ID", referencedColumnName = "CL_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Client apClientId;
    @JoinColumn(name = "AP_DOCTOR_ID", referencedColumnName = "DC_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Doctor apDoctorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "raAppointmentId", fetch = FetchType.EAGER)
    private Collection<ReportAppointment> reportAppointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coAppointmentId", fetch = FetchType.EAGER)
    private Collection<Consultation> consultationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maAppointmentId", fetch = FetchType.EAGER)
    private Collection<MedicineAppointment> medicineAppointmentCollection;

    public Appointment() {
    }

    public Appointment(Integer apId) {
        this.apId = apId;
    }

    public Appointment(Integer apId, LocalDate apDate, String apState) {
        this.apId = apId;
        this.apDate = apDate;
        this.apState = apState;
    }

    public Appointment(AppointmentDto pAppointmentDto) {
        
        this.apId = pAppointmentDto.getID();
        this.apClientId = pAppointmentDto.getClient().get();
        this.apDoctorId = pAppointmentDto.getDoctor().get();
        this.apDate = pAppointmentDto.getDate().get();
        this.apState = pAppointmentDto.getState().get();
    }
    
    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
    }

    public LocalDate getApDate() {
        return apDate;
    }

    public void setApDate(LocalDate apDate) {
        this.apDate = apDate;
    }

    public String getApState() {
        return apState;
    }

    public void setApState(String apState) {
        this.apState = apState;
    }

    public Collection<Surgery> getSurgeryCollection() {
        return surgeryCollection;
    }

    public void setSurgeryCollection(Collection<Surgery> surgeryCollection) {
        this.surgeryCollection = surgeryCollection;
    }

    public Client getApClientId() {
        return apClientId;
    }

    public void setApClientId(Client apClientId) {
        this.apClientId = apClientId;
    }

    public Doctor getApDoctorId() {
        return apDoctorId;
    }

    public void setApDoctorId(Doctor apDoctorId) {
        this.apDoctorId = apDoctorId;
    }

    public Collection<ReportAppointment> getReportAppointmentCollection() {
        return reportAppointmentCollection;
    }

    public void setReportAppointmentCollection(Collection<ReportAppointment> reportAppointmentCollection) {
        this.reportAppointmentCollection = reportAppointmentCollection;
    }

    public Collection<Consultation> getConsultationCollection() {
        return consultationCollection;
    }

    public void setConsultationCollection(Collection<Consultation> consultationCollection) {
        this.consultationCollection = consultationCollection;
    }

    public Collection<MedicineAppointment> getMedicineAppointmentCollection() {
        return medicineAppointmentCollection;
    }

    public void setMedicineAppointmentCollection(Collection<MedicineAppointment> medicineAppointmentCollection) {
        this.medicineAppointmentCollection = medicineAppointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apId != null ? apId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        return !((this.apId == null && other.apId != null) || (this.apId != null && !this.apId.equals(other.apId)));
    }

    @Override
    public String toString() {
        return "models.entity.Appointment[ apId=" + apId + " ]";
    }
    
}
