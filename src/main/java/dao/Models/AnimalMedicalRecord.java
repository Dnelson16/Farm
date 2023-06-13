package dao.Models;
import java.sql.Date;
import java.util.Objects;

public class AnimalMedicalRecord {
    private int recordId;
    private int animalID;
    private Date date;
    private String diagnosis;
    private String treatment;

    public AnimalMedicalRecord(int recordId, int animalID, String diagnosis, String treatment){
        this.recordId = recordId;
        this.animalID = animalID;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    @Override
    public String toString() {
        return "Animal Medical Record:" +
                "recordId:" + recordId +
                ", animalId: " + animalID + ',' +
                ", date: " + date + ',' +
                ", diagnosis: " + diagnosis + ',' +
                "treatment: " + treatment + ','+
                '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalMedicalRecord that = (AnimalMedicalRecord) o;
        return recordId == that.recordId &&
                Objects.equals(animalID, that.animalID) &&
                Objects.equals(date,that.date) &&
                Objects.equals(diagnosis, that.diagnosis) &&
                Objects.equals(treatment, that.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, animalID, date, diagnosis, treatment);
    }
}
