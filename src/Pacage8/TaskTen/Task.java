package Pacage8.TaskTen;

import java.util.ArrayList;

public class Task {
    public static ArrayList<Student>[] execution(ArrayList<Student> students, int x, int n) {
        ArrayList<Student>[] courses = makeCourses(students);
        for (int i = 0; i < courses.length; i++) {
            courses[i] = sort(courses[i]);
            expulsionOfStudents(courses[i], x, n);
        }
        return courses;

    }

    public static ArrayList<Student>[] makeCourses(ArrayList<Student> students) {
        ArrayList<Student>[] courses = new ArrayList[4];
        for (int i = 0; i < courses.length; i++) {
            courses[i] = new ArrayList<>();
        }

        for (Student s : students) {
            courses[s.course - 1].add(s);
        }
        return courses;
    }

    public static ArrayList<Student> sort(ArrayList<Student> course) {
        ArrayList<Student> sortedCourse = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Student newStudent = null;
        while (!course.isEmpty()) {
            for (Student student: course) {
                if (student.averageScore < min) {
                    newStudent = student;
                    min = student.averageScore;
                }
            }
            sortedCourse.add(newStudent);
            course.remove(newStudent);
            min = Integer.MAX_VALUE;
        }
        return sortedCourse;
    }

    public static void expulsionOfStudents(ArrayList<Student> course, int x, int n) {
        if (course.isEmpty()) {
            return;
        }
        int count = 0;
        while (true) {
            if (course.get(0).averageScore < x) {
                while (course.get(0 + count).averageScore == course.get(1 + count).averageScore) {
                    count++;
                    if (course.size() <= n + count) {
                        return;
                    }
                }
                count = 0;
                if (course.size() <= n) {
                    return;
                } else {
                    course.remove(0);
                }
            } else {
                return;
            }
        }
    }

    public static ArrayList<Student> makeStudents(String[][] arrStudents) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i < arrStudents.length; i++) {
            Student s = new Student(arrStudents[i]);
            students.add(s);
        }
        return students;
    }
    
    public static String[][] courcesToString(ArrayList<Student>[] courses) {
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < courses.length; i++) {
            for (Student student: courses[i]) {
                list.add(student.toStringArray());
            }
        }

        String[][] newList = new String[list.size()][];
        for (int i = 0; i < newList.length; i++) {
            newList[i] = list.get(i);
        }
        return newList;
    }
}


