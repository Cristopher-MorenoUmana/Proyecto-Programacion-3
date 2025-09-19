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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author neynm
 */
@Entity
@Table(name = "TBL_MEDICAL_CERTIFICATE")
@NamedQueries({
    @NamedQuery(name = "MedicalCertificate.findAll", query = "SELECT m FROM MedicalCertificate m"),
    @NamedQuery(name = "MedicalCertificate.findByMcId", query = "SELECT m FROM MedicalCertificate m WHERE m.mcId = :mcId"),
    @NamedQuery(name = "MedicalCertificate.findByMcDescription", query = "SELECT m FROM MedicalCertificate m WHERE m.mcDescription = :mcDescription")})
public class MedicalCertificate implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MC_ID")
    private BigDecimal mcId;
    @Basic(optional = false)
    @Column(name = "MC_DESCRIPTION")
    private String mcDescription;
    @JoinColumn(name = "MC_CLIENT_ID", referencedColumnName = "CL_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Client mcClientId;
    @JoinColumn(name = "MC_DOCTOR_ID", referencedColumnName = "DC_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Doctor mcDoctorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rmMedicalCertificateId", fetch = FetchType.EAGER)
    private Collection<ReportMedicalCertificate> reportMedicalCertificateCollection;

    public MedicalCertificate() {
    }

    public MedicalCertificate(BigDecimal mcId) {
        this.mcId = mcId;
    }

    public MedicalCertificate(BigDecimal mcId, String mcDescription) {
        this.mcId = mcId;
        this.mcDescription = mcDescription;
    }

    public BigDecimal getMcId() {
        return mcId;
    }

    public void setMcId(BigDecimal mcId) {
        this.mcId = mcId;
    }

    public String getMcDescription() {
        return mcDescription;
    }

    public void setMcDescription(String mcDescription) {
        this.mcDescription = mcDescription;
    }

    public Client getMcClientId() {
        return mcClientId;
    }

    public void setMcClientId(Client mcClientId) {
        this.mcClientId = mcClientId;
    }

    public Doctor getMcDoctorId() {
        return mcDoctorId;
    }

    public void setMcDoctorId(Doctor mcDoctorId) {
        this.mcDoctorId = mcDoctorId;
    }

    public Collection<ReportMedicalCertificate> getReportMedicalCertificateCollection() {
        return reportMedicalCertificateCollection;
    }

    public void setReportMedicalCertificateCollection(Collection<ReportMedicalCertificate> reportMedicalCertificateCollection) {
        this.reportMedicalCertificateCollection = reportMedicalCertificateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mcId != null ? mcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalCertificate)) {
            return false;
        }
        MedicalCertificate other = (MedicalCertificate) object;
        if ((this.mcId == null && other.mcId != null) || (this.mcId != null && !this.mcId.equals(other.mcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.MedicalCertificate[ mcId=" + mcId + " ]";
    }
    
}
