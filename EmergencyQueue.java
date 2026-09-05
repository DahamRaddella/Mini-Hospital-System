public class EmergencyQueue {
    
    // Queue එක සඳහා අවශ්‍ය Node එක
    class QueueNode {
        Patient patient;
        QueueNode next;
        
        public QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QueueNode front; // පෝලිමේ මුල
    private QueueNode rear;  // පෝලිමේ අග

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    // 1. රෝගියෙකුව පෝලිමට ඇතුළත් කිරීම (Enqueue)
    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        
        // පෝලිම හිස් නම්, අලුත් රෝගියා මුලටත් අගටත් දෙකටම සමාන වේ
        if (this.rear == null) {
            this.front = this.rear = newNode;
            System.out.println("Patient " + patient.patientName + " added to the emergency queue.");
            return;
        }
        
        // නැතහොත් පෝලිමේ අගට අලුත් රෝගියාව එකතු කිරීම
        this.rear.next = newNode;
        this.rear = newNode;
        System.out.println("Patient " + patient.patientName + " added to the emergency queue.");
    }

    // 2. ප්‍රතිකාර සඳහා පෝලිමෙන් ඉවත් කිරීම (Dequeue)
    public Patient dequeue() {
        // පෝලිම හිස් දැයි පරීක්ෂා කිරීම (Appropriate handling of an empty queue)
        if (this.front == null) {
            System.out.println("Emergency queue is empty. No patients waiting.");
            return null;
        }
        
        // මුලින්ම ඉන්න කෙනාව වෙන් කරගැනීම
        QueueNode temp = this.front;
        this.front = this.front.next;
        
        // මුලින්ම හිටපු කෙනා ඉවත් කළ පසු පෝලිම හිස් වුණා නම් rear එකත් null කිරීම
        if (this.front == null) {
            this.rear = null;
        }
        
        System.out.println("Patient " + temp.patient.patientName + " removed from the queue for treatment.");
        return temp.patient;
    }

    // 3. පෝලිමේ සිටින සියල්ලන් පෙන්වීම (Display all patients currently waiting)
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