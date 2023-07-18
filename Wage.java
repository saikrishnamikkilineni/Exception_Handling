import java.util.Scanner;

class InvalidSalaryException extends Exception {
  public InvalidSalaryException(String message) {
    super(message);
  }
}

public class Wage {

  int Emp_id;
  String Emp_name;
  double minimum_wage, salary;
  EmpImp arr[] = new EmpImp[100];
  int emp = 0;
  Scanner sc = new Scanner(System.in);

  public void addEmp()  {

    System.out.println("Enter the employee id:");
    int Emp_id = sc.nextInt();
    System.out.println("Enter the employee name:");
    String Emp_name = sc.next();
    System.out.println("Enter the Minimum wage:");
    double minimum_wage = sc.nextDouble();
    System.out.println("Enter the salary :");
    double salary = sc.nextDouble();
    EmpImp obj = new EmpImp();
    



    
    obj.setEmp_id(Emp_id);
    obj.setEmp_name(Emp_name);
    obj.setminimum_wage(minimum_wage);
    obj.setsalary(salary);
    arr[emp] = obj;
    emp++;
  }

  public void remEmp() {
    System.out.println("Enter the product id to delete the product details");
    int id = sc.nextInt();
    for (int i = 0; i < emp; i++) {
      if (id == arr[i].Emp_id) {
        for (int j = i; j < emp; j++) {
          arr[j] = arr[j + 1];
          emp--;
          break;
        }
      }
    }

  }


public void disEmp() throws InvalidSalaryException {
System.out.println("Enter the salary to check with the minimum wage");
  double salary=sc.nextDouble();
  for(int i=0;i<emp;i++) {
    if(salary<=arr[i].minimum_wage) {
      throw new InvalidSalaryException("Salary should be greater than minimum wage:"+Emp_name) ;
    }
  }
  
  
}


  
  

public void viewOptions() {

  System.out.println("====================Welcome to Employee Details======================");
    int option = 0;
    while (option != 4) {
      System.out.println("1.Add Employee");
      System.out.println("2.Remove Employee");
      System.out.println("3.Display Employee");
      System.out.println("4.Exit");
      option = sc.nextInt();
      if (option == 1) {
        addEmp();
      }
      else if(option==2) {
       remEmp();
        
      }
      else if(option==3) {
        try {
        disEmp();
      }catch(InvalidSalaryException e) {
          System.out.println("Exception: "+e.getMessage());
      }
      }

    }  
}
  

  public static void main(String args[]) {

    Wage obj = new Wage();
    obj.viewOptions();

  }

}
