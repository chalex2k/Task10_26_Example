package Pacage8.TaskTen;

public class InfoAboutStudents {
    public String name;
    public String manOrGirl;
    public int course;
    public int averageScore;


    public InfoAboutStudents(String[] info) {
        this.name = info[0];
        this.manOrGirl = info[1];
        this.course = Integer.parseInt(info[2]);
        this.averageScore = Integer.parseInt(info[3]);
    }
}
