public class VisitHistoryList {

    // 1. පැමිණීමක් අලුතින් එකතු කිරීම (Adding a new visit)
    public void addVisit(Patient patient, Visit newVisit) {
        // රෝගියාගේ පළමු පැමිණීම නම්
        if (patient.headVisit == null) {
            patient.headVisit = newVisit;
        } else {
            // පළමු පැමිණීම නොවේ නම්, ලැයිස්තුවේ අගටම ගොස් අලුත් පැමිණීම සම්බන්ධ කිරීම
            Visit temp = patient.headVisit;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVisit;
        }
        System.out.println("New visit (ID: " + newVisit.visitID + ") added to patient: " + patient.patientName);
    }

    // 2. පැමිණීමක් මකා දැමීම (Removing a visit)
    public void removeVisit(Patient patient, String visitID) {
        if (patient.headVisit == null) {
            System.out.println("No visit history found for patient: " + patient.patientName);
            return;
        }

        // මකා දැමිය යුත්තේ මුලින්ම තියෙන Visit එක නම්
        if (patient.headVisit.visitID.equals(visitID)) {
            patient.headVisit = patient.headVisit.next;
            System.out.println("Visit ID " + visitID + " removed successfully.");
            return;
        }

        // අදාළ ID එක සොයාගෙන යාම
        Visit temp = patient.headVisit;
        while (temp.next != null && !temp.next.visitID.equals(visitID)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Visit ID " + visitID + " not found.");
        } else {
            // අදාළ Node එක මඟහැර ඊළඟ එකට සම්බන්ධ කිරීම (මකා දැමීම)
            temp.next = temp.next.next;
            System.out.println("Visit ID " + visitID + " removed successfully.");
        }
    }

    // 3. පැමිණීමක් සෙවීම (Searching for a visit)
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

    // 4. රෝගියාගේ සියලුම පැමිණීම් පෙන්වීම (Displaying the patient's visit history)
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