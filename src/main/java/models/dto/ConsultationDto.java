package models.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.util.Objects;
import models.entity.Appointment;
import models.entity.Consultation;

public class ConsultationDto {
    
    SimpleStringProperty id;
    SimpleStringProperty description;
    SimpleObjectProperty<Appointment> appointment;
    
    public ConsultationDto() {
        
        this.id = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.appointment = new SimpleObjectProperty<>();
    }
    
    public ConsultationDto(Consultation consultation) {

        this();
        this.id.set(consultation.getCoId().toString());
        this.description.set(consultation.getCoDescription());
        this.appointment.set(consultation.getCoAppointmentId());
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
    
    public SimpleStringProperty getDescription() {
        
        return this.description;
    }
    
    public SimpleObjectProperty<Appointment> getAppointment() {
        
        return this.appointment;
    }
    
    public void setID(Integer pId) {
        
        this.id.set(pId.toString());
    }
    
    public void setDescription(String pDescription) {
        
        this.description.set(pDescription);
    }
    
    public void setAppointment(Appointment pAppointment) {
        
        this.appointment.set(pAppointment);
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

        final ConsultationDto other = (ConsultationDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("ConsultationDto{id=").append(this.id.get());
        sb.append(", description=").append(this.description.get());
        sb.append(", cita=").append(this.appointment.get().getApClientId());
        sb.append('}');
        return sb.toString();
    }
}
