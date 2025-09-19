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
@Table(name = "TBL_REPORT_SURGERY")
@NamedQueries({
    @NamedQuery(name = "ReportSurgery.findAll", query = "SELECT r FROM ReportSurgery r"),
    @NamedQuery(name = "ReportSurgery.findByRsId", query = "SELECT r FROM ReportSurgery r WHERE r.rsId = :rsId")})
public class ReportSurgery implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RS_ID")
    private BigDecimal rsId;
    @JoinColumn(name = "RS_REPORT_ID", referencedColumnName = "RE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Report rsReportId;
    @JoinColumn(name = "RS_SURGERY_ID", referencedColumnName = "SU_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Surgery rsSurgeryId;

    public ReportSurgery() {
    }

    public ReportSurgery(BigDecimal rsId) {
        this.rsId = rsId;
    }

    public BigDecimal getRsId() {
        return rsId;
    }

    public void setRsId(BigDecimal rsId) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportSurgery)) {
            return false;
        }
        ReportSurgery other = (ReportSurgery) object;
        if ((this.rsId == null && other.rsId != null) || (this.rsId != null && !this.rsId.equals(other.rsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.ReportSurgery[ rsId=" + rsId + " ]";
    }
    
}
