package com.java.view;

import com.java.bean.Package;

import java.util.Scanner;

public class Views {
    // Scanner for User Input
    private Scanner input = new Scanner(System.in);

    // Function to welcome
    public void welcome() {
        System.out.println("$$$ Welcome to Package House $$$\n");
    }

    // Function to bye
    public void bye() {
        System.out.println("$$$ See You Next Time! $$$\n");
    }

    /**
     * Menu for User (Insert)
     *
     * @return The mode users choose.
     */
    public int menu() {
        System.out.println(
                "Please Follow the Instruction and Select the Mode: \n" +
                        "   0 --> Exit\n" +
                        "   1 --> Insert\n" +
                        "   2 --> Unlock\n" +
                        "Enter: ");

        // Catch User Input
        String mode = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(mode);
        } catch (NumberFormatException e) {
            System.out.println("menu Exception!\n");
        }

        // Check User Input
        if (num < 0 || num > 2) {
            System.out.println("Please choose the correct mode.\n");
            return menu();
        }
        return num;
    }

    /**
     * Menu for User (Unlock)
     *
     * @return the code users enter.
     */
    public int uMenu() {
        System.out.println("Please Enter your Code: ");

        // Catch User Input
        String code = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(code);
        } catch (NumberFormatException e) {
            System.out.println("uMenu Exception!\n");
        }

        // Check User Input
        if (num < 100000 || num > 999999) {
            System.out.println("Recheck your code!\n");
            return uMenu();
        }
        return num;
    }

    /**
     * Function for Insert
     *
     * @return the Package with package number and its company.
     */
    public Package insert() {
        System.out.println(
                "Please follow the instruction:\n" +
                        "Package Number: " +
                        "Package Company: ");
        String number = input.nextLine();
        String company = input.nextLine();
        Package p = new Package();
        p.setNumber(number);
        p.setCompany(company);
        return p;
    }

    // Function for finding a package by its number
    public String findByNumber() {
        System.out.println("To find your package, please enter your package Number: ");
        return input.nextLine();
    }

    // Function for printing a package
    public void printPackage(Package p) {
        System.out.println(
                "$$$ Package Information $$$\n" +
                        "Package Number: " + p.getNumber() +
                        "\nPackage Company: " + p.getCompany()
        );
    }

    /**
     * Update the information of a package
     *
     * @return the updated package
     */
    public Package update(Package p) {
        System.out.println("Please Enter New Package Number: ");
        String number = input.nextLine();
        System.out.println("\nPlease Enter New Package Company: ");
        String company = input.nextLine();
        p.setNumber(number);
        p.setCompany(company);
        return p;
    }

    /**
     * Function for deleting packages
     *
     * @return 1: Delete, 2: Cancel
     */
    public int delete() {
        // Print delete message
        System.out.println(
                "Make Sure You Want to Delete! \n" +
                        "1. Delete\n" +
                        "2. Cancel"
        );

        // Catch User Input
        String del = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(del);
        } catch (NumberFormatException e) {
            System.out.println("delete Exception!\n");
        }

        // Check User Input
        if (num < 1 || num > 2) {
            System.out.println("Please make your choice!");
            return delete();
        }
        return num;
    }


    public void printAll(Package[] packages) {
        // Check if lockers are empty
        if (packages == null || packages.length == 0) {
            System.out.println("$$$ No Packages Yet.\n");
            return;
        }

        for (Package aPackage : packages) {
            printPackage(aPackage);
        }
    }

    // TODO:
    //  think about the mechanism of inserting for customers who need to insert their returned packages.
    //  If a customer want to return a package, what should we do to put packages back into database?
    //  How should we notify carriers for returned packages? Should we create interfaces for customers and carriers such that this works?
}
