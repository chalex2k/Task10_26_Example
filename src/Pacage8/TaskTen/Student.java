package Pacage8.TaskTen;

public class Student {
    public String name;
    public String gender;
    public int course;
    public int averageScore;


    public Student(String[] info) {
        this.name = info[0];
        this.gender = info[1];
        this.course = Integer.parseInt(info[2]);
        this.averageScore = Integer.parseInt(info[3]);
    }

    public String[] toStringArray(){
        return new String[] {name, gender, String.valueOf(course), String.valueOf(averageScore)};
    }
}
