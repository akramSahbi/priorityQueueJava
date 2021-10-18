import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
 * Create the Student and Priorities classes here.
 */

class Student implements Comparable<Student> {
    int id;
    String name;
    double cgpa;

    public Student() {

    }

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public Integer getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCGPA() {
        return cgpa;
    }

    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public int compareTo(Student s2) {
        if (this.getCGPA() > s2.getCGPA()) {
            return -1;
        } else if (this.getCGPA() < s2.getCGPA()) {
            return 1;
        } else if (this.getCGPA().equals(s2.getCGPA()) &&
                (this.getName().compareTo(s2.getName()) == 0)) {
            return this.getID().compareTo(s2.getID());

        } else if (this.getCGPA().equals(s2.getCGPA())) {
            return this.getName().compareTo(s2.getName());
        }
        else {
            return 0;
        }
    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        // ENTER name CGPA id
        // or SERVED
        PriorityQueue<Student> queue = new PriorityQueue<>();
        for (String event : events) {
            String[] data = event.split(" ");
            if (data.length == 1) {
                Student removedStudent = queue.poll();
            } else {
                Student student = new Student(Integer.parseInt(data[3]),new String(data[1]),Double.parseDouble(data[2]));
                queue.add(student);
            }
        }
        List<Student> remainingStudents = queue.stream().sorted((s1,s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());
        return remainingStudents;

        // JzCPHyWsDqSOVDOjxtNiCpohE 0.33 26684
        // ENTER XzRcGPDebq 0.33 53631
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
