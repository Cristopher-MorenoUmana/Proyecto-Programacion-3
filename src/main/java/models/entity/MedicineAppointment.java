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
@Table(name = "TBL_MEDICINE_APPOINTMENT")
@NamedQueries({
    @NamedQuery(name = "MedicineAppointment.findAll", query = "SELECT m FROM MedicineAppointment m"),
    @NamedQuery(name = "MedicineAppointment.findByMaId", query = "SELECT m FROM MedicineAppointment m WHERE m.maId = :maId")})
public class MedicineAppointment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MA_ID")
    private BigDecimal maId;
    @JoinColumn(name = "MA_APPOINTMENT_ID", referencedColumnName = "AP_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Appointment maAppointmentId;
    @JoinColumn(name = "MA_MEDICINE_ID", referencedColumnName = "ME_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medicine maMedicineId;

    public MedicineAppointment() {
    }

    public MedicineAppointment(BigDecimal maId) {
        this.maId = maId;
    }

    public BigDecimal getMaId() {
        return maId;
    }

    public void setMaId(BigDecimal maId) {
        this.maId = maId;
    }

    public Appointment getMaAppointmentId() {
        return maAppointmentId;
    }

    public void setMaAppointmentId(Appointment maAppointmentId) {
        this.maAppointmentId = maAppointmentId;
    }

    public Medicine getMaMedicineId() {
        return maMedicineId;
    }

    public void setMaMedicineId(Medicine maMedicineId) {
        this.maMedicineId = maMedicineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maId != null ? maId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicineAppointment)) {
            return false;
        }
        MedicineAppointment other = (MedicineAppointment) object;
        if ((this.maId == null && other.maId != null) || (this.maId != null && !this.maId.equals(other.maId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.MedicineAppointment[ maId=" + maId + " ]";
    }
    
}
