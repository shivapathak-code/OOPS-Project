public class Employee {
    int empID;
    String name;
    String Department;
    double salary;
}
class Company{
    public static void main(String[] args)
    {
       Employee emp1 = new Employee();
       emp1.empID = 101;
       emp1.name = "Shiva Pathak";
       emp1.Department = "computer Science and Engineering";
       emp1.salary = 100000;

       System.out.println("Employee ID " + emp1.empID);
       System.out.println("Employee Name " + emp1.name);
       System.out.println("Employee Department " + emp1.Department);
       System.out.println("Employee Salary " + emp1.salary);
    }
}
