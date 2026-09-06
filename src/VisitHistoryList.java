public class VisitHistoryList {

   
    public void addVisit(Patient patient, Visit newVisit) {
        // රෝගියාගේ පළමු පැමිණීම නම්
        if (patient.headVisit == null) {
            patient.headVisit = newVisit;
        } else {
            
            Visit temp = patient.headVisit;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVisit;
        }
        System.out.println("New visit (ID: " + newVisit.visitID + ") added to patient: " + patient.patientName);
    }

    
    public void removeVisit(Patient patient, String visitID) {
        if (patient.headVisit == null) {
            System.out.println("No visit history found for patient: " + patient.patientName);
            return;
        }

        
        if (patient.headVisit.visitID.equals(visitID)) {
            patient.headVisit = patient.headVisit.next;
            System.out.println("Visit ID " + visitID + " removed successfully.");
            return;
        }

        
        Visit temp = patient.headVisit;
        while (temp.next != null && !temp.next.visitID.equals(visitID)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Visit ID " + visitID + " not found.");
        } else {
           
            temp.next = temp.next.next;
            System.out.println("Visit ID " + visitID + " removed successfully.");
        }
    }

    
    public Visit searchVisit(Patient patient, String visitID) {
        Visit temp = patient.headVisit;
        while (temp != null) {
            if (temp.visitID.equals(visitID)) {
                System.out.println("Visit Found: Date: " + temp.visitDate + " | Doctor: " + temp.doctorName + " | Diagnosis: " + temp.diagnosis);
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("Visit ID " + visitID + " not found.");
        return null;
    }

    
    public void displayVisitHistory(Patient patient) {
        if (patient.headVisit == null) {
            System.out.println("No visit history available for patient: " + patient.patientName);
            return;
        }

        System.out.println("--- Visit History for " + patient.patientName + " ---");
        Visit temp = patient.headVisit;
        while (temp != null) {
            System.out.println("Visit ID: " + temp.visitID + " | Date: " + temp.visitDate + 
                               " | Doctor: " + temp.doctorName + " | Treatment: " + temp.treatment);
            temp = temp.next;
        }
        System.out.println("----------------------------------------");
    }
}