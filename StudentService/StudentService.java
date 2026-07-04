package StudentService;
/*

Add a student
Remove a student
Update marks
Get marks
Get average marks
Get the highest-scoring student
Print all students


*/

import java.util.*;
import java.lang.*;

public class StudentService{

    private long studentId = 1;
    Map<Long,Student> students = new HashMap<>();

    public static void main(String args[]){
        StudentService stdGrdMaster = new StudentService();
        stdGrdMaster.addStudent("Thina", 453);
        stdGrdMaster.addStudent("Surya", 400);
        stdGrdMaster.addStudent("Uma Shanker", 479);
        stdGrdMaster.addStudent("Vishal", 460);
        stdGrdMaster.addStudent("Vickey", 485);

        stdGrdMaster.printMarks();
        stdGrdMaster.printHighestMarkScoredStudent();

    }

    private void addStudent(String name,int mark){
        if(name.isEmpty() || mark<0 || mark>500){
            System.out.println("Please enter valid student name and mark !");
            return;
        }
        Student std = new Student(name,mark);
        students.put(studentId,std);
        studentId++;
    }

    private void removeStudent(Long stdId){
        if(students.containsKey(stdId)){
            students.remove(stdId);
        }else{
            System.out.println("Student Id is not in the list");
        }
    }

    private void printMarks(){
        for(Map.Entry<Long,Student> stdEntry : students.entrySet()){
            Student std = stdEntry.getValue();
            System.out.println("Student Name: "+std.getName()+" Student Mark: "+std.getMark());
        }
    }

    private void printAverageMark(){
        if(students.size()==0){
            System.out.println("Student List is Empty !!!");
            return;
        }
        int sumOfAllStudendMark = 0;
        for(Map.Entry<Long,Student> stdEntry : students.entrySet()){
            Student std = stdEntry.getValue();
            sumOfAllStudendMark += std.getMark();
        }

        int avgStudentsMark = sumOfAllStudendMark/students.size();
        System.out.println("Students Average Mark : "+ avgStudentsMark);
    }

    private void printHighestMarkScoredStudent(){
        Student highestMarkScoredStd = null;
        for(Map.Entry<Long,Student> stdEntry : students.entrySet()){
            Student std = stdEntry.getValue();
            if(highestMarkScoredStd==null){
                highestMarkScoredStd = std;
            }else if(highestMarkScoredStd.getMark() < std.getMark()){
                highestMarkScoredStd = std;
            }
        }

        System.out.println("Highest Mark Scored Student Name: "+highestMarkScoredStd.getName()+" and Mark: "+highestMarkScoredStd.getMark());
    }

    private void printAllStudentsInfo(){
        for(Map.Entry<Long,Student> stdEntry : students.entrySet()){
            Student std = stdEntry.getValue();
            System.out.println("Student Id:"+ stdEntry.getKey() +" Name: "+std.getName()+" Mark: "+std.getMark());
        }
    }
}