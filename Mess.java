import java.util.Scanner;

class ProductNotFoundException extends Exception {
  public ProductNotFoundException(String message) {
    super(message);
  }
}

public class Mess {
  int product_id;
  String product_name;
  ProImp arr[] = new ProImp[100];
  int num = 0;
  Scanner sc = new Scanner(System.in);

  public void add() {
    System.out.println("Enter the product id:");
    int product_id = sc.nextInt();
    System.out.println("Enter the product name:");
    String product_name = sc.next();
    ProImp obj = new ProImp();

    obj.setproduct_id(product_id);
    obj.setproduct_name(product_name);
    arr[num] = obj;
    num++;
  }

  public void remove() {
    System.out.println("Enter the product id to delete the product details");
    int id = sc.nextInt();
    for (int i = 0; i < num; i++) {
      if (id == arr[i].product_id) {
        for (int j = i; j < num; j++) {
          arr[j] = arr[j + 1];
          num--;
          break;
        }
      }
    }
  }

  public void display() throws ProductNotFoundException {
    System.out.println("Enter the product name to search details");
    String name = sc.next();
    for (int i = 0; i < num; i++) {
      if (name.equals(product_name)) {
        System.out.println(product_id);
        System.out.println(product_name);
      } else {
        throw new ProductNotFoundException("Invalid product name ");
      }
    }
  }

  public void viewOptions() {

    System.out.println("====================Welcome to Product Details======================");
    int option = 0;
    while (option != 4) {
      System.out.println("1.Add products");
      System.out.println("2.Remove products");
      System.out.println("3.Display Products");
      System.out.println("4.Exit");
      option = sc.nextInt();
      if (option == 1) {
        add();

      } else if (option == 2) {
        remove();
      }

      else if (option == 3) {
        try {
          display();
        } catch (ProductNotFoundException e) {
          System.out.println("Exception :" + e.getMessage());
        }
      }
    }

  }

  public static void main(String args[]) {

    Mess obj = new Mess();
    obj.viewOptions();
  }
}
