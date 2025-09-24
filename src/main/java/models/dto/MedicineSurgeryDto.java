package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.entity.MedicineSurgery;
import models.entity.Medicine;
import models.entity.Surgery;

public class MedicineSurgeryDto {
    
    SimpleStringProperty id;
    SimpleObjectProperty<Medicine> medicine;
    SimpleObjectProperty<Surgery> Surgery;
    
    public MedicineSurgeryDto() {
        
        this.id = new SimpleStringProperty();
        this.medicine = new SimpleObjectProperty<>();
        this.Surgery = new SimpleObjectProperty<>();
    }
    
    public MedicineSurgeryDto(MedicineSurgery pMedicineSurgery) {
        
        this.id.set(pMedicineSurgery.getMsId().toString());
        this.medicine.set(pMedicineSurgery.getMsMedicineId());
        this.Surgery.set(pMedicineSurgery.getMsSurgeryId());
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
    
    public SimpleObjectProperty<Medicine> getMedicine() {
        
        return this.medicine;
    }
    
    public SimpleObjectProperty<Surgery> getSurgery() {
        
        return this.Surgery;
    }
    
    public void setID(Integer pId) {
        
        this.id.set(pId.toString());
    }
    
    public void setMedicine(Medicine pMedicine) {
        
        this.medicine.set(pMedicine);
    }
    
    public void setSurgery(Surgery pSurgery) {
        
        this.Surgery.set(pSurgery);
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
        
        final MedicineSurgeryDto other = (MedicineSurgeryDto) obj;
        
        return Objects.equals(this.getID(), other.getID());
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("MedicineSurgeryDto{id=").append(this.id.get());
        sb.append(", surgery=").append(this.Surgery.get().getSuId().toString());
        sb.append(", medicina=").append(this.medicine.get().getMeId().toString());
        sb.append('}');
        return sb.toString();
    }
}
