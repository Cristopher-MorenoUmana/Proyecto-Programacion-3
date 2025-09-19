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
@Table(name = "TBL_CLIENT")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClId", query = "SELECT c FROM Client c WHERE c.clId = :clId"),
    @NamedQuery(name = "Client.findByClName", query = "SELECT c FROM Client c WHERE c.clName = :clName")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CL_ID")
    private BigDecimal clId;
    @Basic(optional = false)
    @Column(name = "CL_NAME")
    private String clName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mcClientId", fetch = FetchType.EAGER)
    private Collection<MedicalCertificate> medicalCertificateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reClientId", fetch = FetchType.EAGER)
    private Collection<Report> reportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apClientId", fetch = FetchType.EAGER)
    private Collection<Appointment> appointmentCollection;

    public Client() {
    }

    public Client(BigDecimal clId) {
        this.clId = clId;
    }

    public Client(BigDecimal clId, String clName) {
        this.clId = clId;
        this.clName = clName;
    }

    public BigDecimal getClId() {
        return clId;
    }

    public void setClId(BigDecimal clId) {
        this.clId = clId;
    }

    public String getClName() {
        return clName;
    }

    public void setClName(String clName) {
        this.clName = clName;
    }

    public Collection<MedicalCertificate> getMedicalCertificateCollection() {
        return medicalCertificateCollection;
    }

    public void setMedicalCertificateCollection(Collection<MedicalCertificate> medicalCertificateCollection) {
        this.medicalCertificateCollection = medicalCertificateCollection;
    }

    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clId != null ? clId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clId == null && other.clId != null) || (this.clId != null && !this.clId.equals(other.clId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.Client[ clId=" + clId + " ]";
    }
    
}
