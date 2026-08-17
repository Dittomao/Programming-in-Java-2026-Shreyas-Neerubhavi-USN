import java.util.*;
public class Program_2 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Student Name:");
        String name=sc.nextLine();
        System.out.println("Enter Student ID:");
        String studentid=sc.nextLine();
        System.out.println("Enter the department: ");
        String department=sc.nextLine();
        System.out.println("Enter the type of student: (UG/PG) ");
        String stutype=sc.next();
        sc.nextLine();
        if (stutype.equals("UG")){
            System.out.println("Enter current semester: ");
            int sem=sc.nextInt();
            System.out.println("Enter the grade achieved: ");
            double grade=sc.nextDouble();
            UndergraduateStudent stu=new UndergraduateStudent(name, studentid, department, sem, grade);
            stu.displayUGDetails();
        }
        else if(stutype.equals("PG")){
            System.out.println("Enter your specialization: ");
            String spec=sc.nextLine();
            System.out.println("Enter your research topic: ");
            String res=sc.nextLine();
            PostgraduateStudent stu=new PostgraduateStudent(name, studentid, department, spec, res);
            stu.displayPGDetails();
        }
        else{
            System.out.println("Please Enter valid details!");
        }
        sc.close();
    }
}
class Student{
    String studentID;
    String studentName;
    String department;
    void display(){
        System.out.println("Student Name: "+studentName+"\nStudent ID: "+studentID+"\nDepartment: "+department);
    }
}
class UndergraduateStudent extends Student{
    int semester;
    double cgpa;
    UndergraduateStudent(String name, String id, String dept, int sem, double grade){
        studentName=name;
        studentID=id;
        department=dept;
        semester=sem;
        cgpa=grade;
    }
    void displayUGDetails(){
        System.out.println("Student Name: "+studentName+"\nStudent ID: "+studentID+"\nDepartment: "+department+"\nSemester: "+semester+"\nCGPA: "+cgpa);
    }
}
class PostgraduateStudent extends Student{
    String specialization;
    String researchTopic;
    PostgraduateStudent(String name, String id, String dept, String spec, String res){
        studentName=name;
        studentID=id;
        department=dept;
        specialization=spec;
        researchTopic=res;
    }
    void displayPGDetails(){
        System.out.println("Student Name: "+studentName+"\nStudent ID: "+studentID+"\nDepartment: "+department+"\nSpecialization: "+specialization+"\nResearch Topic: "+researchTopic);
    }
}