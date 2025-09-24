package models.dto;

import java.time.LocalDate;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.entity.Doctor;
import models.entity.Client;
import models.entity.Appointment;

public class AppointmentDto {
    
    SimpleStringProperty id;
    SimpleObjectProperty<LocalDate> date;
    SimpleObjectProperty<Client> client;
    SimpleObjectProperty<Doctor> doctor;
    SimpleStringProperty state;
    
    public AppointmentDto() {
        
        this.id = new SimpleStringProperty();
        this.date = new SimpleObjectProperty<>();
        this.client = new SimpleObjectProperty<>();
        this.doctor = new SimpleObjectProperty<>();
        this.state = new SimpleStringProperty();
    }
    
    public AppointmentDto(Appointment appointment) {
        
        this();
        this.id.set(appointment.getApId().toString());
        this.client.set(appointment.getApClientId());
        this.doctor.set(appointment.getApDoctorId());
        this.date.set(appointment.getApDate());
        this.state.set(appointment.getApState());
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
    
    public SimpleObjectProperty<LocalDate> getDate() {
        
        return this.date;
    }
    
    public SimpleStringProperty getIDProperty() {
        
        return this.id;
    }
    
    public SimpleObjectProperty<Client> getClient() {
        
        return this.client;
    }
    
    public SimpleObjectProperty<Doctor> getDoctor() {
        
        return this.doctor;
    }
    
    public SimpleStringProperty getState() {
        
        return this.state;
    }
    
    public void setID(Integer pId) {
        
        this.id.set(pId.toString());
    }
    
    public void setDate(LocalDate pDate) {
        
        this.date.set(pDate);
    }
    
    public void setClient(Client pClient) {
        
        this.client.set(pClient);
    }
    
    public void setDoctor(Doctor pDoctor) {
        
        this.doctor.set(pDoctor);
    }
    
    public void setState(String pState) {
        
        this.state.set(pState);
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

        final AppointmentDto other = (AppointmentDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("AppointmentDto{id=").append(this.id.get());
        sb.append(", fecha=").append(this.date.get().toString());
        sb.append(", cliente=").append(this.client.get());
        sb.append(", doctor=").append(this.doctor.get());
        sb.append(", estado=").append(this.state.get());
        sb.append('}');
        return sb.toString();
    }   
}
