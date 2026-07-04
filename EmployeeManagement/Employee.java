package EmployeeManagement;


/*

employeeId
name
department
salary 

*/
public class Employee {

    private long employeeId;
    private String name;
    private String department;
    private int salary;

    Employee(long employeeId,String name,String department,int salary){
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public long getEmployeeId(){
        return this.employeeId;
    }

    public String getName(){
        return this.name;
    }

    public String getDepartment(){
        return this.department;
    }

    public int getSalary(){
        return this.salary;
    }
}