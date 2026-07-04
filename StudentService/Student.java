package StudentService;
public class Student {
    private  String name;
    private int mark;

    Student(String name,int Mark){
        this.name = name;
        this.mark = Mark;
    }

    public String getName(){
        return this.name;
    }

    public int getMark(){
        return this.mark;
    }
    
}
