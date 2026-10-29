package com.pluralsight;

import java.util.Scanner;

public class Main {
    private static Book[] books = new Book[20];

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // //////// List of all books /////////
        books[0] = new Book(1, "", "Genesis", false);
        books[1] = new Book(2, "", "Exodus", false);
        books[2] = new Book(3, "ggg", "Leviticus", true);
        books[3] = new Book(4, "", "Numbers", false);
        books[4] = new Book(5, "", "Deuteronomy", false);
        books[5] = new Book(6, "", "Joshua", false);
        books[6] = new Book(7, "", "Judges", false);
        books[7] = new Book(8, "", "Ruth", false);
        books[8] = new Book(9, "", "1 Samuel", true);
        books[9] = new Book(10, "", "2 Samuel", false);
        books[10] = new Book(11, "", "1 Kings", false);
        books[11] = new Book(12, "", "2 Kings", false);
        books[12] = new Book(13, "", "Psalms", false);
        books[13] = new Book(14, "", "Proverbs", false);
        books[14] = new Book(15, "", "Ecclesiastes", false);
        books[15] = new Book(16, "", "Isaiah", false);
        books[16] = new Book(17, "", "Jeremiah", false);
        books[17] = new Book(18, "", "Matthew", false);
        books[18] = new Book(19, "", "Mark", false);
        books[19] = new Book(20, "", "Luke", false);


        // /////// List chose ////
        boolean isDone = false;
        System.out.println();
        System.out.println("====Welcome to neighborhood library====");
        do {
            try {
                System.out.println();
                System.out.println("Please use the numbers to choose.");
                System.out.println(" 1. List all Available books ");
                System.out.println(" 2. List all checked out books ");
                System.out.print(" 3. Exit \n>> ");

                int chose = input.nextInt();
                input.nextLine();
                switch (chose){
                    case 1:
                        listAllBooks();
                        break;

                    case 2:
                        checkedOutBooks();

                        break;
                    case 3:
                        System.out.println("Thank you! :)");
                        isDone = true;
                        break;
                    default:
                        System.out.println("!! Invalid input !!");
                        break;

                }
            }catch (Exception e ){
                System.out.println("Sorry something went wrong");
                input.nextLine();
            }

        }while (!isDone);

        input.close();
    }


      // listing all available books for the user and chacking out book
    public static void listAllBooks (){
        try {

        for (int i = 0; i < books.length; i++) {
            if (books[i].isCheckedOut() != true){
                System.out.println(books[i]);
            }
        }
            System.out.println();
        System.out.println("Pleas select a book to checkout or 0 to exit");
        int userSelection = input.nextInt();
        if (userSelection == 0){
            return;
        }
        input.nextLine();
        System.out.println("Book " + books[userSelection-1]+ " << SELECTED");
        System.out.println("Pleas enter your full name to checkout");
        String userName = input.nextLine();
        books[userSelection-1].setCheckedOutTo(userName);
        books[userSelection-1].setCheckedOut(true);
        System.out.println("Enjoy :) " + userName);
        System.out.println();
        }catch (Exception e){
            System.out.println("Sorry something went wrong");
        }

    }
       // Listing all checkedOutBooks and chacking in book back
    public static void checkedOutBooks (){
        boolean haseCheckedOutBooks = false;
        System.out.println("Checked out books");

        for (int i = 0; i < books.length; i++) {
            if (books[i].isCheckedOut() == true) {
                haseCheckedOutBooks = true;
                System.out.println(books[i].getId() + " " + books[i].getTitle() + " To " + books[i].getCheckedOutTo());

            }
        } if (!haseCheckedOutBooks) {
            System.out.println("No checked out books yet.");
            return;
        }
        System.out.println();
        System.out.println("pleas select\nC to check in\nX to exit");
       String userInput = input.nextLine();
        if (userInput.equalsIgnoreCase("c")){
            System.out.println("Thank you! Please enter book id Id: ");
            int checkedOutBookIdInput = input.nextInt();
            input.nextLine();
            if (checkedOutBookIdInput <1 || checkedOutBookIdInput>books.length){
                System.out.println("Invalid input");
            return;}

                Book selectedBook = books[checkedOutBookIdInput-1];
                if (selectedBook.isCheckedOut()){
                    selectedBook.setCheckedOut(false);
                    selectedBook.setCheckedOutTo("");
                    System.out.println("Thank you! Book returned successfully.");
                }else {
                    System.out.println("This book is not checked out.");
                }

            }else if (userInput.equalsIgnoreCase("x")) {
            return;}
        else {
            System.out.println("invalid input ");
        }
        }

   }

 /*
                String userInput = input.nextLine();

                    if (books[checkedOutBookIdInput - 1].isCheckedOut() == true){
                        books[checkedOutBookIdInput - 1].setCheckedOut(false);
                        System.out.println("Thank you!");
                    }

                }*/





