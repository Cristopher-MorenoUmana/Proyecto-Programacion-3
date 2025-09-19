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
@Table(name = "TBL_REPORT_APPOINTMENT")
@NamedQueries({
    @NamedQuery(name = "ReportAppointment.findAll", query = "SELECT r FROM ReportAppointment r"),
    @NamedQuery(name = "ReportAppointment.findByRaId", query = "SELECT r FROM ReportAppointment r WHERE r.raId = :raId"),
    @NamedQuery(name = "ReportAppointment.findByRaType", query = "SELECT r FROM ReportAppointment r WHERE r.raType = :raType")})
public class ReportAppointment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RA_ID")
    private BigDecimal raId;
    @Basic(optional = false)
    @Column(name = "RA_TYPE")
    private String raType;
    @JoinColumn(name = "RA_APPOINTMENT_ID", referencedColumnName = "AP_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Appointment raAppointmentId;
    @JoinColumn(name = "RA_REPORT_ID", referencedColumnName = "RE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Report raReportId;

    public ReportAppointment() {
    }

    public ReportAppointment(BigDecimal raId) {
        this.raId = raId;
    }

    public ReportAppointment(BigDecimal raId, String raType) {
        this.raId = raId;
        this.raType = raType;
    }

    public BigDecimal getRaId() {
        return raId;
    }

    public void setRaId(BigDecimal raId) {
        this.raId = raId;
    }

    public String getRaType() {
        return raType;
    }

    public void setRaType(String raType) {
        this.raType = raType;
    }

    public Appointment getRaAppointmentId() {
        return raAppointmentId;
    }

    public void setRaAppointmentId(Appointment raAppointmentId) {
        this.raAppointmentId = raAppointmentId;
    }

    public Report getRaReportId() {
        return raReportId;
    }

    public void setRaReportId(Report raReportId) {
        this.raReportId = raReportId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (raId != null ? raId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportAppointment)) {
            return false;
        }
        ReportAppointment other = (ReportAppointment) object;
        if ((this.raId == null && other.raId != null) || (this.raId != null && !this.raId.equals(other.raId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entity.ReportAppointment[ raId=" + raId + " ]";
    }
    
}
