package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.entity.Appointment;
import models.entity.Report;
import models.entity.ReportAppointment;

public class ReportAppointmentDto {
    
    SimpleStringProperty id;
    SimpleStringProperty type;
    SimpleObjectProperty<Report> report;
    SimpleObjectProperty<Appointment> appointment;
    
    public ReportAppointmentDto() {
        
        this.id = new SimpleStringProperty();
        this.type = new SimpleStringProperty();
        this.report = new SimpleObjectProperty<>();
        this.appointment = new SimpleObjectProperty<>();
    }
    
    public ReportAppointmentDto(ReportAppointment pReportAppointment) {
        
        this();
        this.id.set(pReportAppointment.getRaId().toString());
        this.type.set(pReportAppointment.getRaType());
        this.report.set(pReportAppointment.getRaReportId());
        this.appointment.set(pReportAppointment.getRaAppointmentId());
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
    
    public SimpleStringProperty getType () {
        
        return this.type;
    }
    
    public SimpleObjectProperty<Report> getReport() {
        
        return this.report;
    }
    
    public SimpleObjectProperty<Appointment> getAppointment() {
        
        return this.appointment;
    }
    
    public void setID(Integer pId) {
        
        this.id.set(pId.toString());
    }
    
    public void setType(String pType) {
        
        this.type.set(pType);
    } 
    
    public void setReport(Report pReport) {
        
        this.report.set(pReport);
    }
    
    public void setApppointment(Appointment pAppoinment) {
        
        this.appointment.set(pAppoinment);
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

        final ReportAppointmentDto other = (ReportAppointmentDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("ReportAppointmentDto{id=").append(this.id.get());
        sb.append(", tipo=").append(this.type.get());
        sb.append(", reporte=").append(this.report.get());
        sb.append(", cita=").append(this.appointment.get());
        sb.append('}');
        return sb.toString();
    }
}
