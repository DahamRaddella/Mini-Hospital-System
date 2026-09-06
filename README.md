# Mini Hospital Emergency Management System

## Overview
This is a Java-based console application designed to simulate the management of patients arriving at a hospital's emergency unit. The system efficiently handles patient registration, emergency treatment queuing, treatment history tracking, and individual patient visit records using fundamental Data Structures.

## Data Structures Implemented
1. **Binary Search Tree (BST) - Patient Records:** 
   Used to store and manage patient details using the Patient ID as the primary key. It allows for efficient insertion, searching, deletion, and displaying of patient records in ascending order.
2. **Queue - Emergency Patient Queue:** 
   Implements a First-In, First-Out (FIFO) approach to manage the waiting list of patients requiring emergency admission and treatment.
3. **Stack - Treatment History:** 
   Implements a Last-In, First-Out (LIFO) approach to store completed treatment records, allowing the system to retrieve and view the most recently completed treatments first.
4. **Singly Linked List - Patient Visit History:** 
   Maintains a chronological history of previous hospital visits and medical records for each individual patient.

## How to Run the Program
1. Ensure you have the Java Development Kit (JDK) installed on your system.
2. Open your terminal or command prompt and navigate to the project directory.
3. Change the directory to the `src` folder:
   ```bash
   cd src