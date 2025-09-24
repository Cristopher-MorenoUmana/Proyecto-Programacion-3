package models.dto;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import models.entity.MedicineAppointment;
import models.entity.Medicine;
import models.entity.Appointment;

public class MedicineAppointmentDto {

    SimpleStringProperty id;
    SimpleObjectProperty<Medicine> medicine;
    SimpleObjectProperty<Appointment> appointment;

    public MedicineAppointmentDto() {

        this.id = new SimpleStringProperty();
        this.medicine = new SimpleObjectProperty<>();
        this.appointment = new SimpleObjectProperty<>();
    }

    public MedicineAppointmentDto(MedicineAppointment pMedicineAppointment) {

        this.id.set(pMedicineAppointment.getMaId().toString());
        this.medicine.set(pMedicineAppointment.getMaMedicineId());
        this.appointment.set(pMedicineAppointment.getMaAppointmentId());
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

    public SimpleObjectProperty<Appointment> getAppointment() {

        return this.appointment;
    }

    public void setID(Integer pId) {

        this.id.set(pId.toString());
    }

    public void setMedicine(Medicine pMedicine) {

        this.medicine.set(pMedicine);
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

        final MedicineAppointmentDto other = (MedicineAppointmentDto) obj;

        return Objects.equals(this.getID(), other.getID());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("MedicineAppointmentDto{id=").append(this.id.get());
        sb.append(", surgery=").append(this.appointment.get().getApId().toString());
        sb.append(", medicina=").append(this.medicine.get().getMeId().toString());
        sb.append('}');
        return sb.toString();
    }
}
