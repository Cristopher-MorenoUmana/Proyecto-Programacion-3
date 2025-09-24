package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.entity.Report;
import models.entity.ReportMedicalCertificate;
import models.entity.MedicalCertificate;

public class ReportMedicalCertificateDto {
    
    SimpleStringProperty id;
    SimpleObjectProperty<Report> report;
    SimpleObjectProperty<MedicalCertificate> medicalCertificate;
    
    public ReportMedicalCertificateDto() {
        
        this.id = new SimpleStringProperty();
        this.report = new SimpleObjectProperty<>();
        this.medicalCertificate = new SimpleObjectProperty<>();
    }
    
    public ReportMedicalCertificateDto(ReportMedicalCertificate pReportMedicalCertificate) {
        
        this();
        this.id.set(pReportMedicalCertificate.getRmId().toString());
        this.report.set(pReportMedicalCertificate.getRmReportId());
        this.medicalCertificate.set(pReportMedicalCertificate.getRmMedicalCertificateId());
    }
    
    public Integer getID() {
        
        if (id.get() == null || id.get().isEmpty()) {
            return null;
        }
        try {
            return Integer.valueOf(id.get());
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public SimpleStringProperty getIDProperty() {
        
        return this.id;
    }
    
    public SimpleObjectProperty<Report> getReport() {
        
        return this.report;
    }
    
    public SimpleObjectProperty<MedicalCertificate> getMedicalCertificate() {
        
        return this.medicalCertificate;
    }
    
    public void setID(Integer pId) {
        
        this.id.set(pId.toString());
    }
    
    public void setReport(Report pReport) {
        
        this.report.set(pReport);
    }
    
    public void setMedicalCertificate(MedicalCertificate pMedicalCertificate) {
        
        this.medicalCertificate.set(pMedicalCertificate);
    }
    
    @Override
    public int hashCode() {
        
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.getID());
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final ReportMedicalCertificateDto other = (ReportMedicalCertificateDto) obj;
        
        return Objects.equals(this.getID(), other.getID());
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("ReportMedicalCertificateDto{id=").append(this.id.get());
        sb.append(", reporte=").append(this.report.get().getReId().toString());
        sb.append(", dictamen=").append(this.medicalCertificate.get().getMcId().toString());
        sb.append('}');
        return sb.toString();
    }    
}
