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
import models.dto.ReportMedicineDto;

@Entity
@Table(name = "TBL_REPORT_MEDICINE")
@NamedQueries({
    @NamedQuery(name = "ReportMedicine.findAll", query = "SELECT r FROM ReportMedicine r"),
    @NamedQuery(name = "ReportMedicine.findByRmeId", query = "SELECT r FROM ReportMedicine r WHERE r.rmeId = :rmeId")})
public class ReportMedicine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "RME_ID")
    private Integer rmeId;
    @JoinColumn(name = "RME_MEDICINE_ID", referencedColumnName = "ME_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medicine rmeMedicineId;
    @JoinColumn(name = "RME_REPORT_ID", referencedColumnName = "RE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Report rmeReportId;

    public ReportMedicine() {
    }

    public ReportMedicine(Integer rmeId) {
        this.rmeId = rmeId;
    }

    public Integer getRmeId() {
        return rmeId;
    }

    public void setRmeId(Integer rmeId) {
        this.rmeId = rmeId;
    }
   
    public void setRmeId(ReportMedicineDto pReportMedicineDto) {
        
        this.rmeId = pReportMedicineDto.getID();
        this.rmeReportId = pReportMedicineDto.getReport().get();
        this.rmeMedicineId = pReportMedicineDto.getMedicine().get();
    }

    public Medicine getRmeMedicineId() {
        return rmeMedicineId;
    }

    public void setRmeMedicineId(Medicine rmeMedicineId) {
        this.rmeMedicineId = rmeMedicineId;
    }

    public Report getRmeReportId() {
        return rmeReportId;
    }

    public void setRmeReportId(Report rmeReportId) {
        this.rmeReportId = rmeReportId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmeId != null ? rmeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ReportMedicine)) {
            return false;
        }
        ReportMedicine other = (ReportMedicine) object;
        return !((this.rmeId == null && other.rmeId != null) || (this.rmeId != null && !this.rmeId.equals(other.rmeId)));
    }

    @Override
    public String toString() {
        return "models.entity.ReportMedicine[ rmeId=" + rmeId + " ]";
    }
    
}
