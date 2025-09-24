package models.entity;

import java.io.Serializable;
import java.util.Collection;
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
import models.dto.SurgeryDto;

@Entity
@Table(name = "TBL_SURGERY")
@NamedQueries({
    @NamedQuery(name = "Surgery.findAll", query = "SELECT s FROM Surgery s"),
    @NamedQuery(name = "Surgery.findBySuId", query = "SELECT s FROM Surgery s WHERE s.suId = :suId"),
    @NamedQuery(name = "Surgery.findBySuName", query = "SELECT s FROM Surgery s WHERE s.suName = :suName")})
public class Surgery implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "SU_ID")
    private Integer suId;
    @Basic(optional = false)
    @Column(name = "SU_NAME")
    private String suName;
    @JoinColumn(name = "SU_APPOINTMENT_ID", referencedColumnName = "AP_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Appointment suAppointmentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "msSurgeryId", fetch = FetchType.EAGER)
    private Collection<MedicineSurgery> medicineSurgeryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rsSurgeryId", fetch = FetchType.EAGER)
    private Collection<ReportSurgery> reportSurgeryCollection;

    public Surgery() {
    }

    public Surgery(Integer suId) {
        this.suId = suId;
    }

    public Surgery(Integer suId, String suName) {
        this.suId = suId;
        this.suName = suName;
    }

    public Surgery(SurgeryDto pSurgeryDto) {
        
        this.suName = pSurgeryDto.getName().get();
        this.suId = pSurgeryDto.getID();
        this.suAppointmentId = pSurgeryDto.getAppointment().get();
    }
    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    public String getSuName() {
        return suName;
    }

    public void setSuName(String suName) {
        this.suName = suName;
    }

    public Appointment getSuAppointmentId() {
        return suAppointmentId;
    }

    public void setSuAppointmentId(Appointment suAppointmentId) {
        this.suAppointmentId = suAppointmentId;
    }

    public Collection<MedicineSurgery> getMedicineSurgeryCollection() {
        return medicineSurgeryCollection;
    }

    public void setMedicineSurgeryCollection(Collection<MedicineSurgery> medicineSurgeryCollection) {
        this.medicineSurgeryCollection = medicineSurgeryCollection;
    }

    public Collection<ReportSurgery> getReportSurgeryCollection() {
        return reportSurgeryCollection;
    }

    public void setReportSurgeryCollection(Collection<ReportSurgery> reportSurgeryCollection) {
        this.reportSurgeryCollection = reportSurgeryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suId != null ? suId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Surgery)) {
            return false;
        }
        Surgery other = (Surgery) object;
        return !((this.suId == null && other.suId != null) || (this.suId != null && !this.suId.equals(other.suId)));
    }

    @Override
    public String toString() {
        return "models.entity.Surgery[ suId=" + suId + " ]";
    }
    
}
