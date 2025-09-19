/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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

/**
 *
 * @author neynm
 */
@Entity
@Table(name = "TBL_APPOINTMENT")
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findByApId", query = "SELECT a FROM Appointment a WHERE a.apId = :apId"),
    @NamedQuery(name = "Appointment.findByApDate", query = "SELECT a FROM Appointment a WHERE a.apDate = :apDate"),
    @NamedQuery(name = "Appointment.findByApState", query = "SELECT a FROM Appointment a WHERE a.apState = :apState")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "AP_ID")
    private BigDecimal apId;
    @Basic(optional = false)
    @Column(name = "AP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date apDate;
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

    public Appointment(BigDecimal apId) {
        this.apId = apId;
    }

    public Appointment(BigDecimal apId, Date apDate, String apState) {
        this.apId = apId;
        this.apDate = apDate;
        this.apState = apState;
    }

    public BigDecimal getApId() {
        return apId;
    }

    public void setApId(BigDecimal apId) {
        this.apId = apId;
    }

    public Date getApDate() {
        return apDate;
    }

    public void setApDate(Date apDate) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.apId == null && other.apId != null) || (this.apId != null && !this.apId.equals(other.apId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.Appointment[ apId=" + apId + " ]";
    }
    
}
