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
@Table(name = "TBL_REPORT_MEDICAL_CERTIFICATE")
@NamedQueries({
    @NamedQuery(name = "ReportMedicalCertificate.findAll", query = "SELECT r FROM ReportMedicalCertificate r"),
    @NamedQuery(name = "ReportMedicalCertificate.findByRmId", query = "SELECT r FROM ReportMedicalCertificate r WHERE r.rmId = :rmId")})
public class ReportMedicalCertificate implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RM_ID")
    private BigDecimal rmId;
    @JoinColumn(name = "RM_MEDICAL_CERTIFICATE_ID", referencedColumnName = "MC_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MedicalCertificate rmMedicalCertificateId;
    @JoinColumn(name = "RM_REPORT_ID", referencedColumnName = "RE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Report rmReportId;

    public ReportMedicalCertificate() {
    }

    public ReportMedicalCertificate(BigDecimal rmId) {
        this.rmId = rmId;
    }

    public BigDecimal getRmId() {
        return rmId;
    }

    public void setRmId(BigDecimal rmId) {
        this.rmId = rmId;
    }

    public MedicalCertificate getRmMedicalCertificateId() {
        return rmMedicalCertificateId;
    }

    public void setRmMedicalCertificateId(MedicalCertificate rmMedicalCertificateId) {
        this.rmMedicalCertificateId = rmMedicalCertificateId;
    }

    public Report getRmReportId() {
        return rmReportId;
    }

    public void setRmReportId(Report rmReportId) {
        this.rmReportId = rmReportId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmId != null ? rmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportMedicalCertificate)) {
            return false;
        }
        ReportMedicalCertificate other = (ReportMedicalCertificate) object;
        if ((this.rmId == null && other.rmId != null) || (this.rmId != null && !this.rmId.equals(other.rmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.ReportMedicalCertificate[ rmId=" + rmId + " ]";
    }
    
}
