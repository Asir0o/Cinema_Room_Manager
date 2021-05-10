package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void showTheSeats(char[][] cinema, int[] num) {
        //вывод зала кинотеатра
        System.out.print("Cinema:\n ");

        for (int i = 0; i < cinema[0].length; i++) {
            System.out.printf(" %d", num[i]);
        }

        for (int i = 0; i < cinema.length; i++) {
            System.out.printf("%n%d", num[i]);
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.printf(" %c", cinema[i][j]);
            }
        }
    }

    public static void buyATicket(char[][] cinema, Scanner scanner, int numOfSeats) {

        System.out.print("\nEnter a row number:\n");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();

        do {
            if ((row < 0 || row > cinema.length) || ((seat < 0 || seat > cinema[0].length))) {
                System.out.println("Wrong input!");
            } else {
                if (cinema[row - 1][seat - 1] != 'B') {
                    break;
                } else {
                    System.out.println("\nThat ticket has already been purchased!");
                }
            }

            System.out.print("\nEnter a row number:\n");
            row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt();
        } while (true);

        cinema[row - 1][seat - 1] = 'B';

        //определяет цену билета
        if (numOfSeats <= 60) {
            System.out.println("Ticket price: $10");
        } else {
            if (row <= cinema.length / 2) {
                System.out.println("Ticket price: $10");
            } else if (row >= cinema.length / 2 + cinema.length % 2) {
                System.out.println("Ticket price: $8");
            }
        }
    }

    public static void statistics(char[][] cinema, int numOfSeats) {
        int count = 0;
        int profit = 0;
        int totalProfit = 0;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {

                //определяет цену билета
                if (numOfSeats <= 60) {
                    if (cinema[i][j] == 'B') {
                        count++;
                        profit += 10;
                    }
                    totalProfit = numOfSeats * 10;
                } else {
                    if (cinema[i][j] == 'B') {
                        count++;
                        if (i + 1 <= cinema.length / 2) {
                            profit += 10;
                        } else if (i + 1 >= cinema.length / 2 + cinema.length % 2) {
                            profit += 8;
                        }
                    }
                    totalProfit = (((cinema.length / 2) * cinema[i].length) * 10) +
                            ((cinema.length / 2 + cinema.length % 2) * cinema[i].length * 8);
                }
            }
        }
        double percent = (Math.rint(count) / Math.rint(numOfSeats)) * 100;

        System.out.printf("Number of purchased tickets: %d\n", count);
        System.out.printf("Percentage: %.2f%c\n", percent, '%');
        System.out.printf("Current income: $%d\n", profit);
        System.out.printf("Total income: $%d\n", totalProfit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ввод размера зала кинотеатра
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seatsInRows = scanner.nextInt();

        char[][] cinema = new char[rows][seatsInRows];
        int[] num = new int[Math.max(rows, seatsInRows)];
        int numOfSeats = rows * seatsInRows;
        int action;

        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
        }
        for (char[] chars : cinema) {   //заполнение массива
            Arrays.fill(chars, 'S');
        }

        do {
            System.out.print("\n1. Show the seats\n");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            action = scanner.nextInt();

            switch (action) {
                case 1:
                    showTheSeats(cinema, num);
                    break;
                case 2:
                    buyATicket(cinema, scanner, numOfSeats);
                    break;
                case 3:
                    statistics(cinema, numOfSeats);
                default:
                    break;
            }
        } while (action != 0);
    }
}