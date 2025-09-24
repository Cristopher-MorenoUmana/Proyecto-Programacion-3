package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import models.entity.User;

public class UserDto {
    
    SimpleStringProperty id;
    SimpleStringProperty name;
    SimpleStringProperty password;
    SimpleStringProperty role;
    
    public UserDto() {
        
        this.id = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.role = new SimpleStringProperty();
    }
    
    public UserDto(User pUser) {
        
        this();
        this.id.set(pUser.getUsId().toString());
        this.name.set(pUser.getUsName());
        this.password.set(pUser.getUsPassword());
        this.role.set(pUser.getUsRole());
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
    
    public SimpleStringProperty getPassword() {
        
        return this.password;
    }
    
    public SimpleStringProperty getRole() {
        
        return this.role;
    }
    
    public void setID(Integer pId) {
        
        this.id.set(pId.toString());
    }
    
    public void setName(String pName) {
        
        this.name.set(pName);
    }
    
    public void setPassword(String pPassword) {
        
        this.password.set(pPassword);
    }
    
    public void setRole(String pRole) {
        
        this.role.set(pRole);
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

        final UserDto other = (UserDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("UserDto{id=").append(this.id.get());
        sb.append(", nombre=").append(this.name.get());
        sb.append(", contrasenia=").append(this.password.get());
        sb.append(", rol=").append(this.role.get());
        sb.append('}');
        return sb.toString();
    }
}
