public class PatientBST {
    Patient root;

   
    public PatientBST() {
        root = null;
    }

   
    public void insert(Patient newPatient) {
        root = insertRec(root, newPatient);
        System.out.println("Patient " + newPatient.patientName + " added successfully.");
    }

    private Patient insertRec(Patient root, Patient newPatient) {
        if (root == null) {
            root = newPatient;
            return root;
        }
        
        if (newPatient.patientID < root.patientID) {
            root.left = insertRec(root.left, newPatient);
        } else if (newPatient.patientID > root.patientID) {
            root.right = insertRec(root.right, newPatient);
        }
        return root;
    }

   
    public Patient search(int patientID) {
        Patient result = searchRec(root, patientID);
        if (result != null) {
            System.out.println("Patient Found: " + result.patientName + " | Age: " + result.age + " | Condition: " + result.medicalCondition);
        } else {
            System.out.println("Patient with ID " + patientID + " not found.");
        }
        return result;
    }

    private Patient searchRec(Patient root, int patientID) {
        if (root == null || root.patientID == patientID) {
            return root;
        }
        if (root.patientID > patientID) {
            return searchRec(root.left, patientID);
        }
        return searchRec(root.right, patientID);
    }

    
    public void displayPatients() {
        System.out.println("--- Patient Records (Sorted by ID) ---");
        inorderRec(root);
        System.out.println("--------------------------------------");
    }

    private void inorderRec(Patient root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("ID: " + root.patientID + " | Name: " + root.patientName + " | Contact: " + root.contactNumber);
            inorderRec(root.right);
        }
    }

   
    public void deletePatient(int patientID) {
        root = deleteRec(root, patientID);
    }

    private Patient deleteRec(Patient root, int patientID) {
        if (root == null) {
            return root;
        }

        
        if (patientID < root.patientID) {
            root.left = deleteRec(root.left, patientID);
        } else if (patientID > root.patientID) {
            root.right = deleteRec(root.right, patientID);
        } else {
            
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

           
            root.patientID = minValue(root.right);
            
            root.right = deleteRec(root.right, root.patientID);
        }
        return root;
    }

    private int minValue(Patient root) {
        int minv = root.patientID;
        while (root.left != null) {
            minv = root.left.patientID;
            root = root.left;
        }
        return minv;
    }
}