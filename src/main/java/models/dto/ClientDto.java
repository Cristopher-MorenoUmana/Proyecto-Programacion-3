package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import models.entity.Client;

public class ClientDto {
    
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    
    public ClientDto() {
        
        this.id = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
    }
    
    public ClientDto(Client client) {
        
        this();
        this.id.set(client.getClId().toString());
        this.name.set(client.getClName());
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
    
    public void setName(String pName) {
        
        this.name.set(pName);
    }
    
    public void setID(Integer pId) {
        
        this.id.set(id.toString());
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

        final ClientDto other = (ClientDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("ClientDto{id=").append(this.id.get());
        sb.append(", nombre=").append(this.name.get());
        sb.append('}');
        return sb.toString();
    }
}
