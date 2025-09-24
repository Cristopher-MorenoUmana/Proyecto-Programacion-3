package models.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import models.dto.DoctorDto;

@Entity
@Table(name = "TBL_DOCTOR")
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByDcId", query = "SELECT d FROM Doctor d WHERE d.dcId = :dcId"),
    @NamedQuery(name = "Doctor.findByDcName", query = "SELECT d FROM Doctor d WHERE d.dcName = :dcName"),
    @NamedQuery(name = "Doctor.findByDcDegree", query = "SELECT d FROM Doctor d WHERE d.dcDegree = :dcDegree"),
    @NamedQuery(name = "Doctor.findByDcDoctorId", query = "SELECT d FROM Doctor d WHERE d.dcDoctorId = :dcDoctorId")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "DC_ID")
    private Integer dcId;
    @Basic(optional = false)
    @Column(name = "DC_NAME")
    private String dcName;
    @Basic(optional = false)
    @Column(name = "DC_DEGREE")
    private String dcDegree;
    @Basic(optional = false)
    @Column(name = "DC_DOCTOR_ID")
    private String dcDoctorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mcDoctorId", fetch = FetchType.EAGER)
    private Collection<MedicalCertificate> medicalCertificateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apDoctorId", fetch = FetchType.EAGER)
    private Collection<Appointment> appointmentCollection;

    public Doctor() {
    }

    public Doctor(Integer dcId) {
        this.dcId = dcId;
    }

    public Doctor(Integer dcId, String dcName, String dcDegree, String dcDoctorId) {
        this.dcId = dcId;
        this.dcName = dcName;
        this.dcDegree = dcDegree;
        this.dcDoctorId = dcDoctorId;
    }

    public Doctor(DoctorDto pDoctorDto) {
        
        this.dcId = pDoctorDto.getID();
        this.dcName = pDoctorDto.getName().get();
        this.dcDoctorId = pDoctorDto.getDoctorID().get();
        this.dcDegree = pDoctorDto.getDegree().get();
    }
    
    public Integer getDcId() {
        return dcId;
    }

    public void setDcId(Integer dcId) {
        this.dcId = dcId;
    }

    public String getDcName() {
        return dcName;
    }

    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public String getDcDegree() {
        return dcDegree;
    }

    public void setDcDegree(String dcDegree) {
        this.dcDegree = dcDegree;
    }

    public String getDcDoctorId() {
        return dcDoctorId;
    }

    public void setDcDoctorId(String dcDoctorId) {
        this.dcDoctorId = dcDoctorId;
    }

    public Collection<MedicalCertificate> getMedicalCertificateCollection() {
        return medicalCertificateCollection;
    }

    public void setMedicalCertificateCollection(Collection<MedicalCertificate> medicalCertificateCollection) {
        this.medicalCertificateCollection = medicalCertificateCollection;
    }

    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dcId != null ? dcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        return !((this.dcId == null && other.dcId != null) || (this.dcId != null && !this.dcId.equals(other.dcId)));
    }

    @Override
    public String toString() {
        return "models.entity.Doctor[ dcId=" + dcId + " ]";
    }
    
}
