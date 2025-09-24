package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import models.entity.Medicine;

public class MedicineDto {
    
    SimpleStringProperty id;
    SimpleStringProperty name;
    SimpleStringProperty description;
    
    public MedicineDto() {
        
        this.id = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
    }
    
    public MedicineDto(Medicine medicine) {
        
        this();
        this.id.set(medicine.getMeId().toString());
        this.name.set(medicine.getMeName());
        this.description.set(medicine.getMeDescription());
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
    
    public SimpleStringProperty getDescription() {
        
        return this.description;
    }
    
    public void setID(Integer pId) {
        
        this.id.set(id.toString());
    }
    
    public void setName(String pName) {
        
        this.name.set(pName);
    }
    
    public void setDescription(String pDescription) {
        
        this.description.set(pDescription);
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

        final MedicineDto other = (MedicineDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("MedicineDto{id=").append(this.id.get());
        sb.append(", name=").append(this.name.get());
        sb.append(", description=").append(this.description.get());
        sb.append('}');
        return sb.toString();
    }   
}
