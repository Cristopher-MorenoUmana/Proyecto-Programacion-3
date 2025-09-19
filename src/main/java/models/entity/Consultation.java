/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author neynm
 */
@Entity
@Table(name = "TBL_CONSULTATION")
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c"),
    @NamedQuery(name = "Consultation.findByCoId", query = "SELECT c FROM Consultation c WHERE c.coId = :coId"),
    @NamedQuery(name = "Consultation.findByCoDescription", query = "SELECT c FROM Consultation c WHERE c.coDescription = :coDescription")})
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CO_ID")
    private BigDecimal coId;
    @Basic(optional = false)
    @Column(name = "CO_DESCRIPTION")
    private String coDescription;
    @JoinColumn(name = "CO_APPOINTMENT_ID", referencedColumnName = "AP_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Appointment coAppointmentId;

    public Consultation() {
    }

    public Consultation(BigDecimal coId) {
        this.coId = coId;
    }

    public Consultation(BigDecimal coId, String coDescription) {
        this.coId = coId;
        this.coDescription = coDescription;
    }

    public BigDecimal getCoId() {
        return coId;
    }

    public void setCoId(BigDecimal coId) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.coId == null && other.coId != null) || (this.coId != null && !this.coId.equals(other.coId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.Consultation[ coId=" + coId + " ]";
    }
    
}
