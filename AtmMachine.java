import java.util.*;

public class AtmMachine {
    private double totalBal = 100;
    Scanner sc = new Scanner(System.in);

    public int userAccount() {
        System.out.print("Enter your account number: ");
        int account;
        account = sc.nextInt();
        return account;
    }

    public int userPin() {
        System.out.print("Enter your pin number: ");
        int pin;
        pin = sc.nextInt();
        return pin;
    }

    public void startAtm() {
        userAccount();
        userPin();
        drawMainMenu();
    }

    public void drawMainMenu() {
        int choice;
        System.out.print("\nATM main menu: ");
        System.out.println("\n1: View Account Balance");
        System.out.println("2: Withdraw Funds");
        System.out.println("3: Deposit Funds");
        System.out.println("4: Terminate Transaction");
        System.out.print("Choice: ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                viewAccountInfo();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                addFunds();
                break;
            case 4:
                System.out.print(
                        "Thank you for using this ATM,Have a good day and Sanitize your hands after using this machine.");
                break;
            default:
                System.out.print("Wrong choice, Please select the correct option.");
                break;
        }
    }

    public void viewAccountInfo() {
        System.out.println("Account Information:");
        System.out.println("The total Available balance is : Rs " + totalBal);
        drawMainMenu();
    }

    public void deposit(int depositAmount) {
        System.out.println("\n***Please Insert Your Money Now...***");
        totalBal += depositAmount;
        System.out.println("\nThe total balance after money deposition is: Rs " + totalBal);

    }

    public void checkNsf(int withdrawAmount) {
        if (totalBal < withdrawAmount) {
            System.out.println("\n****ERRoR!!! Insufficient Funds in your account...***");

        } else {
            totalBal = totalBal - withdrawAmount;
            System.out.println("\n***Please take your money now..***");
            System.out.println("\nThe total balance after money withdrawl is: Rs " + totalBal);
        }
    }

    public void addFunds() {

        System.out.println("Deposit funds: Minimum amount is 1000..");
        System.out.println("1: Rs 1000");
        System.out.println("2: Rs 2000");
        System.out.println("3: Rs 5000");
        System.out.println("4: Rs 10000");
        System.out.println("5: Back to main menu..");
        System.out.println("Choice: ");
        int selectionChoice = sc.nextInt();
        switch (selectionChoice) {
            case 1:
                deposit(1000);
                drawMainMenu();
                break;
            case 2:
                deposit(2000);
                break;
            case 3:
                deposit(5000);
                break;
            case 4:
                deposit(10000);
                break;
        }
    }

    public void withdraw() {
        int withdrawSelection;
        System.out.println("--Withdraw Money--");
        System.out.println("1: Rs 100");
        System.out.println("2: Rs 200");
        System.out.println("3: Rs 500");
        System.out.println("4: Rs 1000");
        System.out.println("3: Rs 2000");
        System.out.println("3: Rs 5000");
        System.out.println("3: Rs 10000");
        System.out.println("5: Back to main menu..");
        System.out.println("Choice: ");
        withdrawSelection = sc.nextInt();
        switch (withdrawSelection) {
            case 1:
                checkNsf(100);
                drawMainMenu();
                break;
            case 2:
                checkNsf(200);
                drawMainMenu();
                break;
            case 3:
                checkNsf(500);
                drawMainMenu();
                break;
            case 4:
                checkNsf(1000);
                drawMainMenu();
                break;
            case 5:
                checkNsf(2000);
                drawMainMenu();
                break;
            case 6:
                checkNsf(5000);
                drawMainMenu();
                break;
            case 7:
                checkNsf(10000);
                drawMainMenu();
                break;
            default:
                System.out.println("Please enter only the above mentioned amounts for withdrawing..");
                break;
        }
    }

    public static void main(String[] args) {
        AtmMachine atmObj = new AtmMachine();
        atmObj.startAtm();
    }

}
