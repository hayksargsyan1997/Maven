package education.storage;

import education.model.Lesson;
import education.model.Student;

import java.util.LinkedList;
import java.util.List;

public class StudentStorage {
    private List<Student> studentList = new LinkedList<>();

    public void add(Student student) {
        studentList.add(student);
    }


    public void print() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public Student getByEmail(String email) {
        for (Student student : studentList) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    public void getStudentLesson(Student student) {
        for (Student student1 : studentList) {
            if (student1.getLesson().equals(student.getLesson())) {
                System.out.println(student1);
            }
        }
    }

    public void deleteStudentBYEmail(String email) {
        for (Student student : studentList) {
            if (student.getEmail().equals(email)) {
                studentList.remove(student);
                break;
            }
        }
    }


    public void printStudentsByLesson(Lesson lesson1) {
        for (Student student1 : studentList) {
            for (Lesson lesson : student1.getLesson()) {
                if (lesson.equals(lesson1)) {
                    System.out.println(student1);
                }
            }
        }
    }

}

