public class PatientBST {
    Patient root;

    // මුලින්ම BST එක හිස්ව (empty) පටන් ගනී
    public PatientBST() {
        root = null;
    }

    // 1. රෝගියෙකු ඇතුළත් කිරීම (Insert a new patient)
    public void insert(Patient newPatient) {
        root = insertRec(root, newPatient);
        System.out.println("Patient " + newPatient.patientName + " added successfully.");
    }

    private Patient insertRec(Patient root, Patient newPatient) {
        if (root == null) {
            root = newPatient;
            return root;
        }
        // Patient ID එක අනුව වමට හෝ දකුණට යොමු කිරීම
        if (newPatient.patientID < root.patientID) {
            root.left = insertRec(root.left, newPatient);
        } else if (newPatient.patientID > root.patientID) {
            root.right = insertRec(root.right, newPatient);
        }
        return root;
    }

    // 2. රෝගියෙකු සෙවීම (Search for a patient using Patient ID)
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

    // 3. රෝගීන් පිළිවෙලට පෙන්වීම (In-order traversal - ascending order of Patient ID)
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

    // 4. රෝගියෙකු මකා දැමීම (Delete a patient)
    public void deletePatient(int patientID) {
        root = deleteRec(root, patientID);
    }

    private Patient deleteRec(Patient root, int patientID) {
        if (root == null) {
            return root;
        }

        // මකා දැමිය යුතු ID එක සොයාගෙන යාම
        if (patientID < root.patientID) {
            root.left = deleteRec(root.left, patientID);
        } else if (patientID > root.patientID) {
            root.right = deleteRec(root.right, patientID);
        } else {
            // Node එක සොයාගත්තාට පසු (දරුවන් එකක් හෝ නොමැති අවස්ථා)
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // දරුවන් දෙදෙනෙකු සිටින අවස්ථාව (දකුණු පස ඇති කුඩාම අගය ගෙන ඒම)
            root.patientID = minValue(root.right);
            // එම කුඩාම අගය තිබූ පැරණි ස්ථානය මකා දැමීම
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