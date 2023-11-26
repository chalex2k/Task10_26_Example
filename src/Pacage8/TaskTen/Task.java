package Pacage8.TaskTen;

import java.util.ArrayList;

public class Task {
    static int X;
    static int N;

    public static String[][] execution(String[][] arr2) {
        ArrayList<InfoAboutStudents>[] courses = makeCourses(arr2);
        for (int i = 0; i < courses.length; i++) {
            courses[i] = sort(courses[i]);
            expulsionOfStudents(courses[i]);
        }
        String[][] answer = toString2(courses);
        return answer;
    }

    public static ArrayList<InfoAboutStudents>[] makeCourses(String[][] arr2) {
        ArrayList<InfoAboutStudents>[] courses = new ArrayList[4];
        for (int i = 0; i < courses.length; i++) {
            courses[i] = new ArrayList<>();
        }
        X = Integer.parseInt(arr2[0][0]);
        N = Integer.parseInt(arr2[0][1]);
        for (int i = 1; i < arr2.length; i++) {
            courses[Integer.parseInt(arr2[i][2]) - 1].add(new InfoAboutStudents(arr2[i]));
        }
        return courses;
    }

    public static ArrayList<InfoAboutStudents> sort(ArrayList<InfoAboutStudents> course) {
        ArrayList<InfoAboutStudents> sortedCourse = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        InfoAboutStudents newStudent = null;
        while (!course.isEmpty()) {
            for (InfoAboutStudents student: course) {
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

    public static void expulsionOfStudents(ArrayList<InfoAboutStudents> course) {
        if (course.isEmpty()) {
            return;
        }
        int count = 0;
        while (true) {
            if (course.get(0).averageScore < X) {
                while (course.get(0 + count).averageScore == course.get(1 + count).averageScore) {
                    count++;
                    if (course.size() <= N + count) {
                        return;
                    }
                }
                count = 0;
                if (course.size() <= N) {
                    return;
                } else {
                    course.remove(0);
                }
            } else {
                return;
            }
        }
    }

    public static String[][] toString2(ArrayList<InfoAboutStudents>[] courses) {
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < courses.length; i++) {
            for (InfoAboutStudents student: courses[i]) {
                list.add(new String[] {student.name, student.manOrGirl, String.valueOf(student.course), String.valueOf(student.averageScore)});
            }
        }

        String[][] newList = new String[list.size()][];
        for (int i = 0; i < newList.length; i++) {
            newList[i] = list.get(i);
        }
        return newList;
    }
}


