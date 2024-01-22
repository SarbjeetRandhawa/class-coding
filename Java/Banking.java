package Java;

import java.util.Scanner;

abstract class Account {
    protected double interestRate;
    protected double amount;

    public abstract double calculateInterest();
}

class FDAccount extends Account {
    private int noOfDays;
    private int ageOfAccountHolder;

    public FDAccount(double interestRate, double amount, int noOfDays, int ageOfAccountHolder) {
        this.interestRate = interestRate;
        this.amount = amount;
        this.noOfDays = noOfDays;
        this.ageOfAccountHolder = ageOfAccountHolder;
    }

    @Override
    public double calculateInterest() {
        if (noOfDays < 0 || amount < 0 || ageOfAccountHolder < 0) {
            throw new IllegalArgumentException("Invalid input. Please enter correct values.");
        }

        if (amount <= 10000000) {  // Below 1 Crore
            if (7 <= noOfDays && noOfDays <= 14) {
                return amount * (interestRate / 100);
            } else if (15 <= noOfDays && noOfDays <= 29) {
                return amount * (interestRate / 100);
            } else if (30 <= noOfDays && noOfDays <= 45) {
                return amount * (interestRate / 100);
            } else if (45 <= noOfDays && noOfDays <= 60) {
                return amount * (interestRate / 100);
            } else if (61 <= noOfDays && noOfDays <= 184) {
                return amount * (interestRate / 100);
            } else if (185 <= noOfDays && noOfDays <= 365) {
                return amount * (interestRate / 100);
            } else {
                throw new IllegalArgumentException("Invalid number of days. Please enter correct values.");
            }
        } else {  // Above 1 Crore
            if (7 <= noOfDays && noOfDays <= 14) {
                return amount * (6.50 / 100);
            } else if (15 <= noOfDays && noOfDays <= 29) {
                return amount * (6.75 / 100);
            } else if (30 <= noOfDays && noOfDays <= 45) {
                return amount * (6.75 / 100);
            } else if (45 <= noOfDays && noOfDays <= 60) {
                return amount * (8 / 100);
            } else if (61 <= noOfDays && noOfDays <= 184) {
                return amount * (8.50 / 100);
            } else if (185 <= noOfDays && noOfDays <= 365) {
                return amount * (10.00 / 100);
            } else {
                throw new IllegalArgumentException("Invalid number of days. Please enter correct values.");
            }
        }
    }
}

class SBAccount extends Account {
    public SBAccount(double interestRate, double amount) {
        this.interestRate = interestRate;
        this.amount = amount;
    }

    @Override
    public double calculateInterest() {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid input. Please enter correct values.");
        }
        return amount * (4 / 100);
    }
}

class RDAccount extends Account {
    private int noOfMonths;
    private double monthlyAmount;

    public RDAccount(double interestRate, double amount, int noOfMonths, double monthlyAmount) {
        this.interestRate = interestRate;
        this.amount = amount;
        this.noOfMonths = noOfMonths;
        this.monthlyAmount = monthlyAmount;
    }

    @Override
    public double calculateInterest() {
        if (noOfMonths < 0 || amount < 0 || monthlyAmount < 0) {
            throw new IllegalArgumentException("Invalid input. Please enter correct values.");
        }
        return amount * (interestRate / 100);
    }
}

public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select the option:");
            System.out.println("1. Interest Calculator –SB");
            System.out.println("2. Interest Calculator –FD");
            System.out.println("3. Interest Calculator –RD");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            if (choice == 4) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the Average amount in your account: ");
                    double sbAmount = scanner.nextDouble();
                    SBAccount sbAccount = new SBAccount(4, sbAmount);
                    double sbInterest = sbAccount.calculateInterest();
                    System.out.println("Interest gained: Rs. " + sbInterest);
                    break;
                case 2:
                    System.out.print("Enter the FD amount: ");
                    double fdAmount = scanner.nextDouble();
                    System.out.print("Enter the number of days: ");
                    int fdDays = scanner.nextInt();
                    System.out.print("Enter your age: ");
                    int fdAge = scanner.nextInt();
                    FDAccount fdAccount = new FDAccount(8, fdAmount, fdDays, fdAge);
                    try {
                        double fdInterest = fdAccount.calculateInterest();
                        System.out.println("Interest gained is: " + fdInterest);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter the RD amount: ");
                    double rdAmount = scanner.nextDouble();
                    System.out.print("Enter the number of months: ");
                    int rdMonths = scanner.nextInt();
                    System.out.print("Enter the monthly amount: ");
                    double rdMonthlyAmount = scanner.nextDouble();
                    RDAccount rdAccount = new RDAccount(8, rdAmount, rdMonths, rdMonthlyAmount);
                    try {
                        double rdInterest = rdAccount.calculateInterest();
                        System.out.println("Interest gained is: " + rdInterest);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}