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
import models.dto.MedicineSurgeryDto;

@Entity
@Table(name = "TBL_MEDICINE_SURGERY")
@NamedQueries({
    @NamedQuery(name = "MedicineSurgery.findAll", query = "SELECT m FROM MedicineSurgery m"),
    @NamedQuery(name = "MedicineSurgery.findByMsId", query = "SELECT m FROM MedicineSurgery m WHERE m.msId = :msId")})
public class MedicineSurgery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "MS_ID")
    private Integer msId;
    @JoinColumn(name = "MS_MEDICINE_ID", referencedColumnName = "ME_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medicine msMedicineId;
    @JoinColumn(name = "MS_SURGERY_ID", referencedColumnName = "SU_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Surgery msSurgeryId;

    public MedicineSurgery() {
    }

    public MedicineSurgery(Integer msId) {
        this.msId = msId;
    }

    public Integer getMsId() {
        return msId;
    }

    public MedicineSurgery(MedicineSurgeryDto pMedicineSurgeryDto) {
        this.msId = pMedicineSurgeryDto.getID();
        this.msMedicineId = pMedicineSurgeryDto.getMedicine().get();
        this.msSurgeryId = pMedicineSurgeryDto.getSurgery().get();
    }

    public void setMsId(Integer msId) {
        this.msId = msId;
    }

    public Medicine getMsMedicineId() {
        return msMedicineId;
    }

    public void setMsMedicineId(Medicine msMedicineId) {
        this.msMedicineId = msMedicineId;
    }

    public Surgery getMsSurgeryId() {
        return msSurgeryId;
    }

    public void setMsSurgeryId(Surgery msSurgeryId) {
        this.msSurgeryId = msSurgeryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (msId != null ? msId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof MedicineSurgery)) {
            return false;
        }
        MedicineSurgery other = (MedicineSurgery) object;
        return !((this.msId == null && other.msId != null) || (this.msId != null && !this.msId.equals(other.msId)));
    }

    @Override
    public String toString() {
        return "models.entity.MedicineSurgery[ msId=" + msId + " ]";
    }
    
}
