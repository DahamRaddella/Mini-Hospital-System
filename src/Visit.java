public class Visit { 
    String visitID;
    String visitDate;
    String doctorName;
    String diagnosis;
    String treatment;
    Visit next; // Pointer for the Singly Linked List

    // Constructor
    public Visit(String visitID, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitID = visitID;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.next = null;
    }
}

