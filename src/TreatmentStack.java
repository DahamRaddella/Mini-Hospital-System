public class TreatmentStack {
    
   
    class StackNode {
        Visit treatmentRecord;
        StackNode next;
        
        public StackNode(Visit treatmentRecord) {
            this.treatmentRecord = treatmentRecord;
            this.next = null;
        }
    }

    private StackNode top; 

    public TreatmentStack() {
        this.top = null;
    }

    
    public void push(Visit treatmentRecord) {
        StackNode newNode = new StackNode(treatmentRecord);
        
        
        newNode.next = top;
        top = newNode;
        
        System.out.println("Treatment record for Visit ID " + treatmentRecord.visitID + " added to the stack.");
    }

   
    public Visit pop() {
       
        if (top == null) {
            System.out.println("Treatment history stack is empty. No records to remove.");
            return null;
        }
        
       
        Visit poppedRecord = top.treatmentRecord;
        top = top.next;
        
        System.out.println("Most recent treatment record (Visit ID: " + poppedRecord.visitID + ") removed from the stack.");
        return poppedRecord;
    }

    
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