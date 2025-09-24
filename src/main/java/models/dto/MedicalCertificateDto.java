package models.dto;

import models.entity.MedicalCertificate;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.entity.Client;
import models.entity.Doctor;

public class MedicalCertificateDto {
    
    SimpleStringProperty id;
    SimpleStringProperty description;
    SimpleObjectProperty<Client> client;
    SimpleObjectProperty<Doctor> doctor;
    
    public MedicalCertificateDto() {

        this.id = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.client = new SimpleObjectProperty<>();
        this.doctor = new SimpleObjectProperty<>();
    }

    public MedicalCertificateDto(MedicalCertificate medicalCertificate) {

        this();
        this.id.set(medicalCertificate.getMcId().toString());
        this.description.set(medicalCertificate.getMcDescription());
        this.client.set(medicalCertificate.getMcClientId());
        this.doctor.set(medicalCertificate.getMcDoctorId());
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

    public SimpleObjectProperty<Client> getClient() {

        return this.client;
    }

    public SimpleObjectProperty<Doctor> getDoctor() {

        return this.doctor;
    }

    public void setID(Integer pId) {

        this.id.set(pId.toString());
    }

    public void setDescription(String pDescription) {

        this.description.set(pDescription);
    }

    public void setClient(Client pClient) {

        this.client.set(pClient);
    }

    public void setDoctor(Doctor pDoctor) {

        this.doctor.set(pDoctor);
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

        final MedicalCertificateDto other = (MedicalCertificateDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("ConsultationDto{id=").append(this.id.get());
        sb.append(", descripcion=").append(this.description.get());
        sb.append(", cliente=").append(this.client.get());
        sb.append(", doctor=").append(this.doctor.get());
        sb.append('}');
        return sb.toString();
    }
}
