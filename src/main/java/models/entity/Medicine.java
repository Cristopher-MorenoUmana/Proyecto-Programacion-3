/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author neynm
 */
@Entity
@Table(name = "TBL_MEDICINE")
@NamedQueries({
    @NamedQuery(name = "Medicine.findAll", query = "SELECT m FROM Medicine m"),
    @NamedQuery(name = "Medicine.findByMeId", query = "SELECT m FROM Medicine m WHERE m.meId = :meId"),
    @NamedQuery(name = "Medicine.findByMeName", query = "SELECT m FROM Medicine m WHERE m.meName = :meName"),
    @NamedQuery(name = "Medicine.findByMeDescription", query = "SELECT m FROM Medicine m WHERE m.meDescription = :meDescription")})
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ME_ID")
    private BigDecimal meId;
    @Basic(optional = false)
    @Column(name = "ME_NAME")
    private String meName;
    @Basic(optional = false)
    @Column(name = "ME_DESCRIPTION")
    private String meDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "msMedicineId", fetch = FetchType.EAGER)
    private Collection<MedicineSurgery> medicineSurgeryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rmeMedicineId", fetch = FetchType.EAGER)
    private Collection<ReportMedicine> reportMedicineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maMedicineId", fetch = FetchType.EAGER)
    private Collection<MedicineAppointment> medicineAppointmentCollection;

    public Medicine() {
    }

    public Medicine(BigDecimal meId) {
        this.meId = meId;
    }

    public Medicine(BigDecimal meId, String meName, String meDescription) {
        this.meId = meId;
        this.meName = meName;
        this.meDescription = meDescription;
    }

    public BigDecimal getMeId() {
        return meId;
    }

    public void setMeId(BigDecimal meId) {
        this.meId = meId;
    }

    public String getMeName() {
        return meName;
    }

    public void setMeName(String meName) {
        this.meName = meName;
    }

    public String getMeDescription() {
        return meDescription;
    }

    public void setMeDescription(String meDescription) {
        this.meDescription = meDescription;
    }

    public Collection<MedicineSurgery> getMedicineSurgeryCollection() {
        return medicineSurgeryCollection;
    }

    public void setMedicineSurgeryCollection(Collection<MedicineSurgery> medicineSurgeryCollection) {
        this.medicineSurgeryCollection = medicineSurgeryCollection;
    }

    public Collection<ReportMedicine> getReportMedicineCollection() {
        return reportMedicineCollection;
    }

    public void setReportMedicineCollection(Collection<ReportMedicine> reportMedicineCollection) {
        this.reportMedicineCollection = reportMedicineCollection;
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
        hash += (meId != null ? meId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicine)) {
            return false;
        }
        Medicine other = (Medicine) object;
        if ((this.meId == null && other.meId != null) || (this.meId != null && !this.meId.equals(other.meId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.Medicine[ meId=" + meId + " ]";
    }
    
}
