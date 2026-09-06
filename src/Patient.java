public class Patient { 
    int patientID; 
    String patientName;
    int age;
    String contactNumber;
    String medicalCondition;
    
    Patient left;  
    Patient right; 
    Visit headVisit; 

    public Patient(int patientID, String patientName, int age, String contactNumber, String medicalCondition) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.left = null;
        this.right = null;
        this.headVisit = null;
    }
}