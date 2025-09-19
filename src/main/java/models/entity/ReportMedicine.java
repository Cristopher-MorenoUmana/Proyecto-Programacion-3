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
@Table(name = "TBL_REPORT_MEDICINE")
@NamedQueries({
    @NamedQuery(name = "ReportMedicine.findAll", query = "SELECT r FROM ReportMedicine r"),
    @NamedQuery(name = "ReportMedicine.findByRmeId", query = "SELECT r FROM ReportMedicine r WHERE r.rmeId = :rmeId")})
public class ReportMedicine implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RME_ID")
    private BigDecimal rmeId;
    @JoinColumn(name = "RME_MEDICINE_ID", referencedColumnName = "ME_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medicine rmeMedicineId;
    @JoinColumn(name = "RME_REPORT_ID", referencedColumnName = "RE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Report rmeReportId;

    public ReportMedicine() {
    }

    public ReportMedicine(BigDecimal rmeId) {
        this.rmeId = rmeId;
    }

    public BigDecimal getRmeId() {
        return rmeId;
    }

    public void setRmeId(BigDecimal rmeId) {
        this.rmeId = rmeId;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportMedicine)) {
            return false;
        }
        ReportMedicine other = (ReportMedicine) object;
        if ((this.rmeId == null && other.rmeId != null) || (this.rmeId != null && !this.rmeId.equals(other.rmeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.ReportMedicine[ rmeId=" + rmeId + " ]";
    }
    
}
