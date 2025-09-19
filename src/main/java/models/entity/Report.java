/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author neynm
 */
@Entity
@Table(name = "TBL_REPORT")
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findByReId", query = "SELECT r FROM Report r WHERE r.reId = :reId"),
    @NamedQuery(name = "Report.findByReDate", query = "SELECT r FROM Report r WHERE r.reDate = :reDate")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RE_ID")
    private BigDecimal reId;
    @Basic(optional = false)
    @Column(name = "RE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rmReportId", fetch = FetchType.EAGER)
    private Collection<ReportMedicalCertificate> reportMedicalCertificateCollection;
    @JoinColumn(name = "RE_CLIENT_ID", referencedColumnName = "CL_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Client reClientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "raReportId", fetch = FetchType.EAGER)
    private Collection<ReportAppointment> reportAppointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rmeReportId", fetch = FetchType.EAGER)
    private Collection<ReportMedicine> reportMedicineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rsReportId", fetch = FetchType.EAGER)
    private Collection<ReportSurgery> reportSurgeryCollection;

    public Report() {
    }

    public Report(BigDecimal reId) {
        this.reId = reId;
    }

    public Report(BigDecimal reId, Date reDate) {
        this.reId = reId;
        this.reDate = reDate;
    }

    public BigDecimal getReId() {
        return reId;
    }

    public void setReId(BigDecimal reId) {
        this.reId = reId;
    }

    public Date getReDate() {
        return reDate;
    }

    public void setReDate(Date reDate) {
        this.reDate = reDate;
    }

    public Collection<ReportMedicalCertificate> getReportMedicalCertificateCollection() {
        return reportMedicalCertificateCollection;
    }

    public void setReportMedicalCertificateCollection(Collection<ReportMedicalCertificate> reportMedicalCertificateCollection) {
        this.reportMedicalCertificateCollection = reportMedicalCertificateCollection;
    }

    public Client getReClientId() {
        return reClientId;
    }

    public void setReClientId(Client reClientId) {
        this.reClientId = reClientId;
    }

    public Collection<ReportAppointment> getReportAppointmentCollection() {
        return reportAppointmentCollection;
    }

    public void setReportAppointmentCollection(Collection<ReportAppointment> reportAppointmentCollection) {
        this.reportAppointmentCollection = reportAppointmentCollection;
    }

    public Collection<ReportMedicine> getReportMedicineCollection() {
        return reportMedicineCollection;
    }

    public void setReportMedicineCollection(Collection<ReportMedicine> reportMedicineCollection) {
        this.reportMedicineCollection = reportMedicineCollection;
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
        hash += (reId != null ? reId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.reId == null && other.reId != null) || (this.reId != null && !this.reId.equals(other.reId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.Report[ reId=" + reId + " ]";
    }
    
}
