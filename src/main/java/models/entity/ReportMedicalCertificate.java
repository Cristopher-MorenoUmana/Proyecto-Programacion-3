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
import models.dto.ReportMedicalCertificateDto;

@Entity
@Table(name = "TBL_REPORT_MEDICAL_CERTIFICATE")
@NamedQueries({
    @NamedQuery(name = "ReportMedicalCertificate.findAll", query = "SELECT r FROM ReportMedicalCertificate r"),
    @NamedQuery(name = "ReportMedicalCertificate.findByRmId", query = "SELECT r FROM ReportMedicalCertificate r WHERE r.rmId = :rmId")})
public class ReportMedicalCertificate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "RM_ID")
    private Integer rmId;
    @JoinColumn(name = "RM_MEDICAL_CERTIFICATE_ID", referencedColumnName = "MC_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MedicalCertificate rmMedicalCertificateId;
    @JoinColumn(name = "RM_REPORT_ID", referencedColumnName = "RE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Report rmReportId;

    public ReportMedicalCertificate() {
    }

    public ReportMedicalCertificate(Integer rmId) {
        this.rmId = rmId;
    }

    public ReportMedicalCertificate(ReportMedicalCertificateDto pReportMedicalCertificateDto) {

        this.rmId = pReportMedicalCertificateDto.getID();
        this.rmMedicalCertificateId = pReportMedicalCertificateDto.getMedicalCertificate().get();
        this.rmReportId = pReportMedicalCertificateDto.getReport().get();
    }

    public Integer getRmId() {
        return rmId;
    }

    public void setRmId(Integer rmId) {
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

        if (!(object instanceof ReportMedicalCertificate)) {
            return false;
        }
        ReportMedicalCertificate other = (ReportMedicalCertificate) object;
        return !((this.rmId == null && other.rmId != null) || (this.rmId != null && !this.rmId.equals(other.rmId)));
    }

    @Override
    public String toString() {
        return "models.entity.ReportMedicalCertificate[ rmId=" + rmId + " ]";
    }
    
}
