package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.entity.Report;
import models.entity.ReportMedicine;
import models.entity.Medicine;

public class ReportMedicineDto {

    SimpleStringProperty id;
    SimpleObjectProperty<Report> report;
    SimpleObjectProperty<Medicine> medicine;
    
    public ReportMedicineDto() {

        this.id = new SimpleStringProperty();
        this.report = new SimpleObjectProperty<>();
        this.medicine = new SimpleObjectProperty<>();
    }

    public ReportMedicineDto(ReportMedicine pReportMedicine) {

        this();
        this.id.set(pReportMedicine.getRmeId().toString());
        this.report.set(pReportMedicine.getRmeReportId());
        this.medicine.set(pReportMedicine.getRmeMedicineId());
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
    
    public SimpleObjectProperty<Medicine> getMedicine() {
        
        return this.medicine;
    }
    
    public void setID(Integer pId) {

        this.id.set(pId.toString());
    }

    public void setReport(Report pReport) {

        this.report.set(pReport);
    }
    
    public void setMedicine(Medicine pMedicine) {
        
        this.medicine.set(pMedicine);
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
        
        final ReportMedicineDto other = (ReportMedicineDto) obj;
        
        return Objects.equals(this.getID(), other.getID());
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("ReportMedicineDto{id=").append(this.id.get());
        sb.append(", reporte=").append(this.report.get().getReId().toString());
        sb.append(", medicina=").append(this.medicine.get().getMeId().toString());
        sb.append('}');
        return sb.toString();
    }
}
