package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.entity.Report;
import models.entity.ReportSurgery;
import models.entity.Surgery;

public class ReportSurgeryDto {
    
    SimpleStringProperty id;
    SimpleObjectProperty<Report> report;
    SimpleObjectProperty<Surgery> surgery;
    
    public ReportSurgeryDto() {
        
        this.id = new SimpleStringProperty();
        this.report = new SimpleObjectProperty();
        this.surgery = new SimpleObjectProperty();
    }
    
    public ReportSurgeryDto(ReportSurgery pReportSurgery) {
        
        this();
        this.id.set(pReportSurgery.getRsId().toString());
        this.report.set(pReportSurgery.getRsReportId());
        this.surgery.set(pReportSurgery.getRsSurgeryId());
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

    public SimpleObjectProperty<Surgery> getSurgery() {
        
        return this.surgery;
    }

    public void setID(Integer pId) {

        this.id.set(pId.toString());
    }

    public void setReport(Report pReport) {

        this.report.set(pReport);
    }
    
    public void setSurgery(Surgery pSurgery) {
        
        this.surgery.set(pSurgery);
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

        final ReportSurgeryDto other = (ReportSurgeryDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("ReportSurgeryDto{id=").append(this.id.get());
        sb.append(", reporte=").append(this.report.get().getReId().toString());
        sb.append(", cirugia=").append(this.surgery.get().getSuId().toString());
        sb.append('}');
        return sb.toString();
    }
}
