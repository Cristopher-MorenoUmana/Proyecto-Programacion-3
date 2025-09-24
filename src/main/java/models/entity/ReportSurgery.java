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
import models.dto.ReportSurgeryDto;

@Entity
@Table(name = "TBL_REPORT_SURGERY")
@NamedQueries({
    @NamedQuery(name = "ReportSurgery.findAll", query = "SELECT r FROM ReportSurgery r"),
    @NamedQuery(name = "ReportSurgery.findByRsId", query = "SELECT r FROM ReportSurgery r WHERE r.rsId = :rsId")})
public class ReportSurgery implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "RS_ID")
    private Integer rsId;
    @JoinColumn(name = "RS_REPORT_ID", referencedColumnName = "RE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Report rsReportId;
    @JoinColumn(name = "RS_SURGERY_ID", referencedColumnName = "SU_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Surgery rsSurgeryId;

    public ReportSurgery() {
    }

    public ReportSurgery(ReportSurgeryDto pReportSurgery) {
        
        this.rsId = pReportSurgery.getID();
        this.rsReportId = pReportSurgery.getReport().get();
        this.rsSurgeryId = pReportSurgery.getSurgery().get();
    }

    public ReportSurgery(Integer rsId) {
        this.rsId = rsId;
    }

    public Integer getRsId() {
        return rsId;
    }

    public void setRsId(Integer rsId) {
        this.rsId = rsId;
    }

    public Report getRsReportId() {
        return rsReportId;
    }

    public void setRsReportId(Report rsReportId) {
        this.rsReportId = rsReportId;
    }

    public Surgery getRsSurgeryId() {
        return rsSurgeryId;
    }

    public void setRsSurgeryId(Surgery rsSurgeryId) {
        this.rsSurgeryId = rsSurgeryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rsId != null ? rsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ReportSurgery)) {
            return false;
        }
        ReportSurgery other = (ReportSurgery) object;
        return !((this.rsId == null && other.rsId != null) || (this.rsId != null && !this.rsId.equals(other.rsId)));
    }

    @Override
    public String toString() {
        return "models.entity.ReportSurgery[ rsId=" + rsId + " ]";
    }
    
}
