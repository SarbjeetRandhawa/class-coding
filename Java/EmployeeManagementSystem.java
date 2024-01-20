package Java;
import java.util.*;
import java.util.Date;

class Employee {
    private int emoNo;
    private String empName;
    private String designationCode;
    private String department;
    private int basic;
    private int hra;
    private int it;

    public Employee() {
    }

    public Employee(int emoNo, String empName, String designationCode, String department, int basic, int hra, int it) {
        this.emoNo = emoNo;
        this.empName = empName;
        this.designationCode = designationCode;
        this.department = department;
        this.basic = basic;

        this.hra = hra;
        this.it = it;
    }

    public int getEmoNo() {
        return emoNo;
    }

    public void setEmoNo(int emoNo) {
        this.emoNo = emoNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesignationCode() {
        return designationCode;
    }

    public void setDesignationCode(String designationCode) {
        this.designationCode = designationCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getBasic() {
        return basic;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    public int getHra() {
        return hra;
    }

    public void setHra(int hra) {
        this.hra = hra;
    }

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }

    public String getDesignation(String designationCode) {
        return switch (designationCode) {
            case "e" -> "Engineer";
            case "c" -> "Consultant";
            case "k" -> "Clerk";
            case "r" -> "Receptionist";
            case "m" -> "Manager";
            default -> "Unknown";
        };
    }

    int calculateSalary(String designationCode) {
        int salary = 0;
        switch (designationCode) {
            case "e":
                salary = basic + hra + 20000 - it;
                break;
            case "c":
                salary = basic + hra + 32000 - it;
                break;

            case "k":
                salary = basic + hra + 12000 - it;
                break;
            case "r":
                salary = basic + hra + 15000 - it;
                break;
            case "m":
                salary = basic + hra + 40000 - it;

                break;
            default:
        }
        return salary;
    }

 void display(List<Employee> list){
 System.out.println("Emp No.\t Emp Name\t Department\t Designation\tSalary");
 for (Employee e : list) {
 System.out.println(e.getEmoNo() + "\t\t" + e.getEmpName() + "\t\t" +
 e.getDepartment() + "\t\t" + e.getDesignation(e.designationCode) +
"\t\t" +
 e.calculateSalary(e.designationCode));
 }
 System.out.println();
 }

 void getEmployeeById(int empId,List<Employee> list){
 System.out.println("Emp No.\t Emp Name\t Department\t Designation\tSalary");
 for (Employee e : list) {
 if (empId == e.emoNo) {
 System.out.println(e.getEmoNo() + "\t\t" + e.getEmpName() + "\t\t" +
 e.getDepartment() + "\t\t" + e.getDesignationCode() + "\t\t" +
 e.calculateSalary(e.designationCode));
 }
 }
 System.out.println();
 }

 void run(Scanner in){
 List<Employee> list = new ArrayList<>();
 list.add(new Employee(9200,"Sabhya Mahajan","e","Eng",40000,8000,3000));
 list.add(new Employee(9895,"Rishav","e","Eng",20000,8000,3000));
 list.add(new Employee(9217,"Sachin Kumar Singh","k","R&D",32000,5000,2000));
 list.add(new Employee(1234,"Keshav","r","Finance",22000,5000,3000));
 list.add(new Employee(9194,"Sarbeet","c","R&D",32000,2000,2000));

 while(true){
 System.out.println("Enter 1 to enter employee details");
 System.out.println("Enter 2 to fetch employee details");
 System.out.println("Enter 3 to get employee by employee no.");
 System.out.println("Enter 4 to exit");
 int choice = in.nextInt();
 switch(choice){
 case 1: {
 System.out.println("Enter employee id");
 int empNo = in.nextInt();
 System.out.println("Enter employee name");
 String empName= in.next();
 System.out.println("Enter employee designation code ");
 String designationCode = in.next();
 System.out.println("Enter employee department");
 String department = in.next();
 System.out.println("Enter Basic");
 int basic = in.nextInt();
 System.out.println("Enter HRA");
 int hra = in.nextInt();
 System.out.println("Enter IT");
 int it= in.nextInt();
 Employee employee = new

Employee(empNo,empName,designationCode,department,basic,hra,it);
 list.add(employee);
 }
 break;
 case 2:{
 new Employee().display(list);

 }break;
 case 3:{
 System.out.println("Enter the Emp No. to fetch details");
 int empNo = in.nextInt();
 new Employee().getEmployeeById(empNo,list);
 }
 break;
 case 4:{
 System.exit(0);
 }
 break;
 default:{
 System.out.println("Invalid input");
 }
 }
 }
 }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Name: Sarbjeet Singh\n UID: 21BCS9194");
        Employee employee = new Employee();
        employee.run(in);
    }
}