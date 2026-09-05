public class Patient { 
    int patientID; // This will act as the key for the BST
    String patientName;
    int age;
    String contactNumber;
    String medicalCondition;
    
    Patient left;  // BST left child
    Patient right; // BST right child
    Visit headVisit; // Head of the Singly Linked List for this patient's visit history

    // Constructor
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