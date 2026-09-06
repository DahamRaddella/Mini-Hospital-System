public class EmergencyQueue {
    
    
    class QueueNode {
        Patient patient;
        QueueNode next;
        
        public QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QueueNode front; 
    private QueueNode rear; 

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    
    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        
       
        if (this.rear == null) {
            this.front = this.rear = newNode;
            System.out.println("Patient " + patient.patientName + " added to the emergency queue.");
            return;
        }
        
       
        this.rear.next = newNode;
        this.rear = newNode;
        System.out.println("Patient " + patient.patientName + " added to the emergency queue.");
    }

   
    public Patient dequeue() {
       
        if (this.front == null) {
            System.out.println("Emergency queue is empty. No patients waiting.");
            return null;
        }
        
       
        QueueNode temp = this.front;
        this.front = this.front.next;
        
       
        if (this.front == null) {
            this.rear = null;
        }
        
        System.out.println("Patient " + temp.patient.patientName + " removed from the queue for treatment.");
        return temp.patient;
    }

   
    public void displayQueue() {
        if (this.front == null) {
            System.out.println("Emergency queue is empty. No patients waiting.");
            return;
        }
        
        System.out.println("--- Emergency Patient Queue ---");
        QueueNode temp = this.front;
        while (temp != null) {
            System.out.println("ID: " + temp.patient.patientID + " | Name: " + temp.patient.patientName + " | Condition: " + temp.patient.medicalCondition);
            temp = temp.next;
        }
        System.out.println("-------------------------------");
    }
}