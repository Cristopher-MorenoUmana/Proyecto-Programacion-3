package models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import models.dto.ConsultationDto;

@Entity
@Table(name = "TBL_CONSULTATION")
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c"),
    @NamedQuery(name = "Consultation.findByCoId", query = "SELECT c FROM Consultation c WHERE c.coId = :coId"),
    @NamedQuery(name = "Consultation.findByCoDescription", query = "SELECT c FROM Consultation c WHERE c.coDescription = :coDescription")})
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "CO_ID")
    private Integer coId;
    @Basic(optional = false)
    @Column(name = "CO_DESCRIPTION")
    private String coDescription;
    @JoinColumn(name = "CO_APPOINTMENT_ID", referencedColumnName = "AP_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Appointment coAppointmentId;

    public Consultation() {
    }

    public Consultation(Integer coId) {
        this.coId = coId;
    }

    public Consultation(Integer coId, String coDescription) {
        this.coId = coId;
        this.coDescription = coDescription;
    }

    public Consultation(ConsultationDto consultationDto) {
    
        this.coId = consultationDto.getID();
        this.coDescription = consultationDto.getDescription().get();
        this.coAppointmentId = consultationDto.getAppointment().get();
    }
    
    public Integer getCoId() {
        return coId;
    }

    public void setCoId(Integer coId) {
        this.coId = coId;
    }

    public String getCoDescription() {
        return coDescription;
    }

    public void setCoDescription(String coDescription) {
        this.coDescription = coDescription;
    }

    public Appointment getCoAppointmentId() {
        return coAppointmentId;
    }

    public void setCoAppointmentId(Appointment coAppointmentId) {
        this.coAppointmentId = coAppointmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coId != null ? coId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        return !((this.coId == null && other.coId != null) || (this.coId != null && !this.coId.equals(other.coId)));
    }

    @Override
    public String toString() {
        return "models.entity.Consultation[ coId=" + coId + " ]";
    }
    
}
