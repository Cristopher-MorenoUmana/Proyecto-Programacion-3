package models.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.entity.Client;
import models.entity.Report;

public class ReportDto {
    
    SimpleStringProperty id;
    SimpleObjectProperty<LocalDate> date;
    SimpleObjectProperty<Client> client;
    
    public ReportDto() {
      
        this.id = new SimpleStringProperty();
        this.date = new SimpleObjectProperty<>();
        this.client = new SimpleObjectProperty<>();
    }
    
    public ReportDto(Report pReport) {
        
        this();
        this.id.set(pReport.getReId().toString());
        this.date.set(pReport.getReDate());
        this.client.set(pReport.getReClientId());
    }
    
    public SimpleStringProperty getIDProperty() {
        
        return this.id;
    }
    
    public SimpleObjectProperty<LocalDate> getDate() {
        
        return this.date;
    }
    
    public SimpleObjectProperty<Client> getClient() {
        
        return this.client;
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

        final ReportDto other = (ReportDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("ReportDto{id=").append(this.id.get());
        sb.append(", fecha=").append(this.date.get().toString());
        sb.append(", cliente=").append(this.client.get());
        sb.append('}');
        return sb.toString();
    }   
}
