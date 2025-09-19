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
@Table(name = "TBL_MEDICINE_SURGERY")
@NamedQueries({
    @NamedQuery(name = "MedicineSurgery.findAll", query = "SELECT m FROM MedicineSurgery m"),
    @NamedQuery(name = "MedicineSurgery.findByMsId", query = "SELECT m FROM MedicineSurgery m WHERE m.msId = :msId")})
public class MedicineSurgery implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MS_ID")
    private BigDecimal msId;
    @JoinColumn(name = "MS_MEDICINE_ID", referencedColumnName = "ME_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medicine msMedicineId;
    @JoinColumn(name = "MS_SURGERY_ID", referencedColumnName = "SU_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Surgery msSurgeryId;

    public MedicineSurgery() {
    }

    public MedicineSurgery(BigDecimal msId) {
        this.msId = msId;
    }

    public BigDecimal getMsId() {
        return msId;
    }

    public void setMsId(BigDecimal msId) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicineSurgery)) {
            return false;
        }
        MedicineSurgery other = (MedicineSurgery) object;
        if ((this.msId == null && other.msId != null) || (this.msId != null && !this.msId.equals(other.msId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.MedicineSurgery[ msId=" + msId + " ]";
    }
    
}
