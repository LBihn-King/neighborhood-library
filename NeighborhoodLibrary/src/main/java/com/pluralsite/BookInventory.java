package com.pluralsite;

import java.util.Scanner;

public class BookInventory {
    static Scanner scanner = new Scanner(System.in);
    static Book[] Inventory = new Book[20];

    public static void main(String[] args) {
        bookInformation();
        userChoice();
    }

    public static void bookInformation() {
        Inventory[0] = new Book(1, "0-345-41337-7", "The Amber Spyglass", "Phillip Pullman", "His Dark Materials", false, "");
        Inventory[1] = new Book(2, "0-765-35470-5", "Halo: Ghosts of Onyx", "Eric Nylund", "Halo", false, "");
        Inventory[2] = new Book(3, "978-0-547-25830-0", "Graceling", "Kristin Cashore", "Graceling Realm", false, "");
        Inventory[3] = new Book(4, "0-553-56494-3", "Magician: Apprentice", "Raymond E. Feist", "The Riftwar Saga", false, "");
        Inventory[4] = new Book(5, "0-553-56493-5", "Magician: Master", "Raymond E. Feist", "The Riftwar Saga", false, "");
        Inventory[5] = new Book(6, "0-550-27054-0", "Silverthorn", "Raymond E. Feist", "The Riftwar Saga", false, "");
        Inventory[6] = new Book(7, "0-553-26328-5", "A Darkness At Sethanon", "Raymond E. Feist", "The Riftwar Saga", false, "");
        Inventory[7] = new Book(8, "0-553-56373-4", "The King's Buccaneer", "Raymond E. Feist", "The Riftwar Saga", false, "");
        Inventory[8] = new Book(9, "0-553-28524-6", "Prince Of The Blood", "Raymond E. Feist", "The Riftwar Saga", false, "");
        Inventory[9] = new Book(10, "0-345-33392-6", "Ringworld", "Larry Niven", "Ringworld", false, "");
        Inventory[10] = new Book(11, "0-345-33430-2", "The Ringworld Engineers", "Larry Niven", "Ringworld", false, "");
        Inventory[11] = new Book(12, "0-345-41296-6", "The Ringworld Throne", "Larry Niven", "Ringworld", false, "");
        Inventory[12] = new Book(13, "0-765-34102-6", "Ringworld's Children", "Larry Niven", "Ringworld", false, "");
        Inventory[13] = new Book(14, "978-0-541-4581-3", "Storm Front", "Jim Butcher", "The Dresden Files", true, "Dude McBro");
        Inventory[14] = new Book(15, "978-0-451-45812-4", "Fool Moon", "Jim Butcher", "The Dresden Files", true, "Dude McBro");
        Inventory[15] = new Book(16, "0-451-45844-3", "Grave Peril", "Jim Butcher", "The Dresden Files", false, "");
        Inventory[16] = new Book(17, "978-0-451-45892-6", "Summer Knight", "Jim Butcher", "The Dresden Files", false, "");
        Inventory[17] = new Book(18, "978-1-705-62028-1", "Unknown Horizons", "Casey White", "Halfway To Home", false, "");
        Inventory[18] = new Book(19, "979-8-374-24806-7", "Past The Redline", "RavensDagger", "N/A", false, "");
        Inventory[19] = new Book(20, "979-8-353-18317-4", "Mark Of The Fool", "J.M. Clarke", "Mark Of The Fool", false, "");
    }


    public static void userChoice() {
        System.out.println("Home:\n\t 1) Show Available Books\n\t 2) Show Checked Out Books\n\t 3) Exit - close application");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                availableBooks();
                break;
            case 2:
                unavailableBooks();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }


    public static void availableBooks() {
        for (Book book : Inventory) {
            if (!book.isCheckedOut) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
            }
        }
        System.out.println("\t1) Check out a book?\n\t2)Return to home screen");
        int choiceCheckOut = scanner.nextInt();
        switch (choiceCheckOut) {
            case 1:
                checkOutBook();
                break;
            case 2:
                userChoice();
                break;
        }
    }
    public static void unavailableBooks() {
        for (Book book : Inventory) {
            if (book.isCheckedOut) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + " - Checked out by " + book.getIsCheckedOutTo());
            }
        }
        System.out.println("\t1) Check in a book?\n\t2)Return to home screen");
        int choiceCheckIn = scanner.nextInt();
        switch (choiceCheckIn) {
            case 1:
                checkInBook();
            case 2:
                userChoice();
                break;
        }
    }


    public static void checkOutBook() {
        System.out.print("Enter book ID: ");
        int enteredID = scanner.nextInt();
        scanner.nextLine();
        for (Book book : Inventory) {
            if (book.getId() == enteredID && !book.getIsCheckedOut()) {
                book.checkOut();
                break;
            }
        }
    }
    public static void checkInBook() {
        System.out.print("Enter book ID: ");
        int enteredID = scanner.nextInt();
        for (Book book : Inventory) {
            if (book.getId() == enteredID && book.getIsCheckedOut()) {
                book.checkIn();
                break;
            }
        }
    }
}



