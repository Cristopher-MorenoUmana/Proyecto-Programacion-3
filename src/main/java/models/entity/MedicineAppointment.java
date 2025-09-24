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
import models.dto.MedicineAppointmentDto;

@Entity
@Table(name = "TBL_MEDICINE_APPOINTMENT")
@NamedQueries({
    @NamedQuery(name = "MedicineAppointment.findAll", query = "SELECT m FROM MedicineAppointment m"),
    @NamedQuery(name = "MedicineAppointment.findByMaId", query = "SELECT m FROM MedicineAppointment m WHERE m.maId = :maId")})
public class MedicineAppointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "MA_ID")
    private Integer maId;
    @JoinColumn(name = "MA_APPOINTMENT_ID", referencedColumnName = "AP_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Appointment maAppointmentId;
    @JoinColumn(name = "MA_MEDICINE_ID", referencedColumnName = "ME_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medicine maMedicineId;

    public MedicineAppointment() {
    }

    public MedicineAppointment(Integer maId) {
        this.maId = maId;
    }
    
    public MedicineAppointment(MedicineAppointmentDto pMedicineAppointmentDto) {
        
        this.maId = pMedicineAppointmentDto.getID();
        this.maAppointmentId = pMedicineAppointmentDto.getAppointment().get();
        this.maMedicineId = pMedicineAppointmentDto.getMedicine().get();
    }
    
    public Integer getMaId() {
        return maId;
    }

    public void setMaId(Integer maId) {
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

        if (!(object instanceof MedicineAppointment)) {
            return false;
        }
        MedicineAppointment other = (MedicineAppointment) object;
        return !((this.maId == null && other.maId != null) || (this.maId != null && !this.maId.equals(other.maId)));
    }

    @Override
    public String toString() {
        return "models.entity.MedicineAppointment[ maId=" + maId + " ]";
    }
    
}
