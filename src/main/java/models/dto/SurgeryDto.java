package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.entity.Appointment;
import models.entity.Surgery;

public class SurgeryDto {
    
    SimpleStringProperty id;
    SimpleStringProperty name;
    SimpleObjectProperty<Appointment> appointment;
    
    public SurgeryDto() {
        
        this.id = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.appointment = new SimpleObjectProperty<>();
    }
    
    public SurgeryDto(Surgery pSurgery) {
        
        this();
        this.id.set(pSurgery.getSuId().toString());
        this.name.set(pSurgery.getSuName());
        this.appointment.set(pSurgery.getSuAppointmentId());
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
    
    public SimpleStringProperty getName() {
        
        return this.name;
    }
    
    public SimpleObjectProperty<Appointment> getAppointment() {
        
        return this.appointment;
    }
    
    public void setID(Integer pId) {
        
        this.id.set(pId.toString());
    }
    
    public void setName(String pName) {
        
        this.name.set(pName);
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

        final SurgeryDto other = (SurgeryDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("SurgeryDto{id=").append(this.id.get());
        sb.append(", nombre=").append(this.name.get());
        sb.append(", cita=").append(this.appointment.get());
        sb.append('}');
        return sb.toString();
    }
}
