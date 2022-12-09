package src.CinemaHallManager;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static int currentIncome = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();

        String[][] seats = new String[numberOfRows][numberOfSeats];
        for (String[] seat : seats) {
            Arrays.fill(seat, "S");
        }

        displayMenu(seats);
    }

    /* --------------------- MENU OPTIONS --------------------- */

    public static void displayMenu(String[][] seats) {
        String menuPanel = """
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                """;
        System.out.println(menuPanel);
        selectMenu(seats);
    }

    public static void selectMenu(String[][] seats) {
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                showSeats(seats);
                displayMenu(seats);
                break;
            case 2:
                buyATicket(seats);
                displayMenu(seats);
                break;
            case 3:
                statistics(seats);
                displayMenu(seats);
                break;
            case 0:
                break;
            default:
                break;
        }
    }

    /* --------------------- FEATURES --------------------- */

    public static void buyATicket(String[][] seats) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        if (rowNumber >= 0 && rowNumber <= seats.length) {
            if (seatNumber >= 0 && seatNumber <= seats[1].length) {
                if (seats[rowNumber - 1][seatNumber - 1].equalsIgnoreCase("B")) {
                    System.out.println("That ticket has already been purchased!");
                    buyATicket(seats);
                } else {
                    seats[rowNumber - 1][seatNumber - 1] = "B";
                    // Ticket price calculation
                    int totalSeats = seats.length * seats[1].length;
                    int frontHalf = (seats.length / 2);
                    int ticketPrice;

                    if (totalSeats > 60) {
                        if (rowNumber <= frontHalf) {
                            ticketPrice = 10;
                            currentIncome += ticketPrice;
                            System.out.println("Ticket price: $" + ticketPrice);
                        } else {
                            ticketPrice = 8;
                            currentIncome += ticketPrice;
                            System.out.println("Ticket price: $" + ticketPrice);
                        }
                    } else {
                        ticketPrice = 10;
                        currentIncome += ticketPrice;
                        System.out.println("Ticket price: $" + ticketPrice);
                    }
                }
            } else {
                System.out.println("Wrong input!");
                buyATicket(seats);
            }
        } else {
            System.out.println("Wrong input!");
            buyATicket(seats);
        }
    }

    public static void showSeats(String[][] seats) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats[1].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void statistics(String[][] seats) {
        // Initializing all data
        int purchasedTickets = 0;
        float percentage;
        int totalIncome;

        // Other required data
        int totalSeats = seats.length * seats[1].length;

        // Finding all purchased tickets
        for (String[] seat : seats) {
            for (String s : seat) {
                if (s.equalsIgnoreCase("B")) {
                    purchasedTickets += 1;
                }
            }
        }

        // Calculating percentage
        percentage = ((float) purchasedTickets / (float) totalSeats) * 100;

        // Calculating total income
        if (totalSeats > 60) {
            int frontSeats = (seats.length / 2) * seats[1].length;
            int backSeats = totalSeats - frontSeats;
            totalIncome = (frontSeats * 10) + (backSeats * 8);
        } else {
            totalIncome = totalSeats * 10;
        }

        // Displaying results
        System.out.printf("Number of purchased tickets: %d %n", purchasedTickets);
        System.out.printf("Percentage: %.2f%% %n", percentage);
        System.out.printf("Current income: $%d %n", currentIncome);
        System.out.printf("Total income: $%d %n", totalIncome);
    }
}
