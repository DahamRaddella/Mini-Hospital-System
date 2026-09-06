import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();
        VisitHistoryList visitHistory = new VisitHistoryList();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Mini Hospital Emergency Management System ===");
            System.out.println("1. Register New Patient (BST)");
            System.out.println("2. View All Patients (BST)");
            System.out.println("3. Add Patient to Emergency Queue (Queue)");
            System.out.println("4. Treat Next Patient in Queue (Queue & Stack)");
            System.out.println("5. View Treatment History (Stack)");
            System.out.println("6. Add Visit Record to Patient (Linked List)");
            System.out.println("7. View Patient's Visit History (Linked List)");
            System.out.println("8. Exit");
            System.out.print("Select an option (1-8): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Medical Condition: ");
                    String condition = scanner.nextLine();
                    
                    Patient newPatient = new Patient(id, name, age, contact, condition);
                    patientBST.insert(newPatient);
                    break;
                    
                case 2:
                    patientBST.displayPatients();
                    break;
                    
                case 3:
                    System.out.print("Enter Patient ID to add to Queue: ");
                    int qId = scanner.nextInt();
                    Patient pToQueue = patientBST.search(qId);
                    if (pToQueue != null) {
                        emergencyQueue.enqueue(pToQueue);
                    }
                    break;
                    
                case 4:
                    Patient treatedPatient = emergencyQueue.dequeue();
                    if (treatedPatient != null) {
                        System.out.print("Enter Visit ID for this treatment: ");
                        String vId = scanner.nextLine();
                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        System.out.print("Enter Doctor Name: ");
                        String doc = scanner.nextLine();
                        System.out.print("Enter Treatment given: ");
                        String treat = scanner.nextLine();
                        
                        Visit newTreatment = new Visit(vId, date, doc, treatedPatient.medicalCondition, treat);
                        treatmentStack.push(newTreatment); // ප්‍රතිකාර ඉතිහාසයට (Stack) දැමීම
                        visitHistory.addVisit(treatedPatient, newTreatment); // රෝගියාගේ පෞද්ගලික ඉතිහාසයට (Linked list) දැමීම
                    }
                    break;
                    
                case 5:
                    treatmentStack.displayStack();
                    break;
                    
                case 6:
                    System.out.print("Enter Patient ID to add past visit: ");
                    int vPatId = scanner.nextInt();
                    scanner.nextLine();
                    Patient pToVisit = patientBST.search(vPatId);
                    if (pToVisit != null) {
                        System.out.print("Enter Visit ID: ");
                        String visId = scanner.nextLine();
                        System.out.print("Enter Date: ");
                        String visDate = scanner.nextLine();
                        System.out.print("Enter Doctor: ");
                        String visDoc = scanner.nextLine();
                        System.out.print("Enter Diagnosis: ");
                        String diag = scanner.nextLine();
                        System.out.print("Enter Treatment: ");
                        String visTreat = scanner.nextLine();
                        
                        Visit pastVisit = new Visit(visId, visDate, visDoc, diag, visTreat);
                        visitHistory.addVisit(pToVisit, pastVisit);
                    }
                    break;
                    
                case 7:
                    System.out.print("Enter Patient ID to view history: ");
                    int histId = scanner.nextInt();
                    Patient pToHist = patientBST.search(histId);
                    if (pToHist != null) {
                        visitHistory.displayVisitHistory(pToHist);
                    }
                    break;
                    
                case 8:
                    running = false;
                    System.out.println("Exiting System. Good Bye!");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}