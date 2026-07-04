package EmployeeManagement;

import java.util.*;

/*
Add employee
Remove employee
Update salary
Find employee by ID
Find all employees in a department
Find the highest-paid employee
Calculate average salary
Print all employees
*/

public class EmployeeService {
    private long employeeId = 1;

    private Map<String,Map<Long,Employee>> departmentVsEmployee = new HashMap<>();
    private Map<Long,String> employeeIdVsDepartment = new HashMap<>();
    public static void main(String args[]){

    }

    public void addEmployee(long employeeId,String name,String department,int salary){
        Employee employee = new Employee(employeeId++, name, department, salary);
        Map<Long,Employee> empIdVsEmployee = null;
        if(!departmentVsEmployee.containsKey(department)){
            empIdVsEmployee = new HashMap<>();
        }else{
            empIdVsEmployee = departmentVsEmployee.get(department);
        }
        empIdVsEmployee.put(employeeId,employee);
        departmentVsEmployee.put(department,empIdVsEmployee);
        employeeIdVsDepartment.put(employeeId,department);
    }

    public boolean removeEmployee(long employeeId){
        if(!employeeIdVsDepartment.containsKey(employeeId)){
            return false;
        }
        departmentVsEmployee.get(employeeIdVsDepartment.get(employeeId)).remove(employeeId);
        if(departmentVsEmployee.get(employeeIdVsDepartment.get(employeeId)).size()==0) {
            departmentVsEmployee.remove(employeeIdVsDepartment.get(employeeId));
        }
        employeeIdVsDepartment.remove(employeeId);
        return true;
    }

    public boolean updateSalary(long employeeId,int newSalary){
        if(!employeeIdVsDepartment.containsKey(employeeId)){
            return false;
        }
        Map<Long,Employee> employeeIdVsEmplyeeInfo = departmentVsEmployee.get(employeeIdVsDepartment.get(employeeId));
        Employee employee = employeeIdVsEmplyeeInfo.get(employeeId);
        Employee newUpdatedEmployeeSalary = new Employee(employeeId, employee.getName(), employee.getDepartment(), newSalary);
        employeeIdVsEmplyeeInfo.put(employeeId,newUpdatedEmployeeSalary);
        return true;
    }

    public Employee getEmployeeByID(long employeeId){
        if(!employeeIdVsDepartment.containsKey(employeeId)){
            return null;
        }
        return departmentVsEmployee.get(employeeIdVsDepartment.get(employeeId)).get(employeeId);
    }

    public Set<Employee> getAllEmployeeListByDepartment(String department){
        if(!departmentVsEmployee.containsKey(department)){
            return new HashSet<>();
        }
        return (Set<Employee>) departmentVsEmployee.get(department).values();
    }

    public Employee getHighestPayingEmployee(){
        if(employeeIdVsDepartment.size()==0){
            return null;
        }
        Employee highPayingEmployee = null;
        for(Map.Entry<String,Map<Long,Employee>> departmentVsEmployeeList : departmentVsEmployee.entrySet()){
            for(Employee employee : departmentVsEmployeeList.getValue().values()){
                if(highPayingEmployee == null){
                    highPayingEmployee = employee;
                }else if(highPayingEmployee.getSalary() < employee.getSalary()){
                    highPayingEmployee = employee;
                }
            }
        }
        return highPayingEmployee;
    }

    public int getAverageSalaryOfAllDepartmentEmployees(){
        if(employeeIdVsDepartment.size()==0){
            return 0;
        }
        int totoalSalary = 0;
        for(Map.Entry<String,Map<Long,Employee>> departmentVsEmployeeList : departmentVsEmployee.entrySet()){
            for(Employee employee : departmentVsEmployeeList.getValue().values()){
                totoalSalary += employee.getSalary();
            }
        }
        return totoalSalary/employeeIdVsDepartment.size();
    }

    public Set<Employee> getAllDepartmentEmployees(){
        if(employeeIdVsDepartment.size()==0){
            return new HashSet<>();
        }
        Set<Employee> employeeList = null;
        for(Map.Entry<String,Map<Long,Employee>> departmentVsEmployeeList : departmentVsEmployee.entrySet()){
            employeeList.addAll(departmentVsEmployeeList.getValue().values());
        }
        return employeeList;
    }

}
