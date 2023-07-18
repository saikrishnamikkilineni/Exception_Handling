import java.util.Scanner;

class InsufficientFundsException extends Exception {
  public InsufficientFundsException(String message) {
    super(message);
  }
}

// Bank class
public class Bank {
  double balance;
  Scanner sc = new Scanner(System.in);

  public void deposit() {
    System.out.println("enter amount:");
    double intialbalance = sc.nextDouble();
    balance = balance + intialbalance;
    System.out.println("Deposit Amount: " + balance);
  }

  public void withDraw() throws InsufficientFundsException {
    System.out.println("Enter withdraw amount: ");
    double withdraw = sc.nextDouble();

    if (withdraw > balance) {
      throw new InsufficientFundsException("Withdrawal is attempted with insufficient balance");
    }
    balance = balance - withdraw;
    System.out.println("After withdraw balance :" + balance);
  }

  public void balanceEnquiry() {
    System.out.println("Balance Enquiry :" + balance);
  }

  public void viewOptions() {
    System.out.println("=======================Welcome to BankAccount================");
    int option = 0;
    while (option != 4) {
      System.out.println("1.Deposit Amount");
      System.out.println("2.Withdraw Amount");
      System.out.println("3.Balance Enquiry");
      System.out.println("4.Exit");
      option = sc.nextInt();
      if (option == 1) {
        deposit();
      } 
      else if (option == 2) {
        try {
          withDraw();
        } catch (InsufficientFundsException e) {
          System.out.println("Exception :" + e.getMessage());
        }
      } 
      else if (option == 3) {
        balanceEnquiry();
      }

    }
  }

  public static void main(String args[]) {
    Bank obj = new Bank();
    obj.viewOptions();

  }
}