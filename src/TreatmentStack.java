public class TreatmentStack {
    
    // Stack එක සඳහා අවශ්‍ය Node එක
    class StackNode {
        Visit treatmentRecord;
        StackNode next;
        
        public StackNode(Visit treatmentRecord) {
            this.treatmentRecord = treatmentRecord;
            this.next = null;
        }
    }

    private StackNode top; // Stack එකේ ඉහළම ස්ථානය (Top)

    public TreatmentStack() {
        this.top = null;
    }

    // 1. අලුත් ප්‍රතිකාර වාර්තාවක් Stack එකට ඇතුළත් කිරීම (Push)
    public void push(Visit treatmentRecord) {
        StackNode newNode = new StackNode(treatmentRecord);
        
        // අලුත් Node එක දැනට ඇති top එකට සම්බන්ධ කර, එය අලුත් top එක බවට පත් කිරීම
        newNode.next = top;
        top = newNode;
        
        System.out.println("Treatment record for Visit ID " + treatmentRecord.visitID + " added to the stack.");
    }

    // 2. අලුතින්ම එකතු කළ ප්‍රතිකාර වාර්තාව ඉවත් කිරීම (Pop)
    public Visit pop() {
        // Stack එක හිස් දැයි පරීක්ෂා කිරීම (Appropriate handling of an empty stack)
        if (top == null) {
            System.out.println("Treatment history stack is empty. No records to remove.");
            return null;
        }
        
        // ඉහළින්ම ඇති වාර්තාව ඉවත් කිරීම
        Visit poppedRecord = top.treatmentRecord;
        top = top.next;
        
        System.out.println("Most recent treatment record (Visit ID: " + poppedRecord.visitID + ") removed from the stack.");
        return poppedRecord;
    }

    // 3. Stack එකේ ඇති සියලුම ප්‍රතිකාර වාර්තා පෙන්වීම (Display treatment records)
    public void displayStack() {
        if (top == null) {
            System.out.println("Treatment history stack is empty.");
            return;
        }
        
        System.out.println("--- Treatment History (Recent First) ---");
        StackNode temp = top;
        while (temp != null) {
            System.out.println("Visit ID: " + temp.treatmentRecord.visitID + 
                               " | Doctor: " + temp.treatmentRecord.doctorName + 
                               " | Treatment: " + temp.treatmentRecord.treatment);
            temp = temp.next;
        }
        System.out.println("----------------------------------------");
    }
}