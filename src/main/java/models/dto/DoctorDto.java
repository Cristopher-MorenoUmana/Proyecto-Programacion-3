package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import models.entity.Doctor;
public class DoctorDto {
    
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty degree;
    private SimpleStringProperty doctorID;
    
    public DoctorDto() {
        
        this.id = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.degree = new SimpleStringProperty();
        this.doctorID = new SimpleStringProperty();
    }
    
    public DoctorDto(Doctor doctor) {
        
        this();
        this.id.set(doctor.getDcId().toString());
        this.name.set(doctor.getDcName());
        this.degree.set(doctor.getDcDegree());
        this.doctorID.set(doctor.getDcDoctorId());
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
    
    public SimpleStringProperty getName() {
        
        return this.name;
    }
    
    public SimpleStringProperty getIDProperty() {
        
        return this.id;
    }
    
    public SimpleStringProperty getDegree() {
        
        return this.degree;
    }
    
    public SimpleStringProperty getDoctorID(){
        
        return this.doctorID;
    }
    
    public void setName(String pName) {
        
        this.name.set(pName);
    }
    
    public void setID(Integer pId) {
        
        this.id.set(pId.toString());
    }
    
    public void setDoctorID(String pDoctorID) {
        
        this.doctorID.set(pDoctorID);
    }
    
    public void setDegree(String pDegree) {
        
        this.degree.set(pDegree);
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

        final DoctorDto other = (DoctorDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("DoctorDto{id=").append(this.id.get());
        sb.append(", nombre=").append(this.name.get());
        sb.append(", titulo=").append(this.name.get());
        sb.append(", id de doctor=").append(this.name.get());
        sb.append('}');
        return sb.toString();
    }
}
