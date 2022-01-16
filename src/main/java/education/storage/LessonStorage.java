package education.storage;

import education.model.Lesson;

import java.util.LinkedList;
import java.util.List;

public class LessonStorage {
    private List<Lesson> lessonList = new LinkedList<>();

    public void add(Lesson lesson) {
        lessonList.add(lesson);
    }


    public void print() {
        for (Lesson lesson : lessonList) {
            System.out.println(lesson);
        }
    }


    public Lesson getByName(String name) {
        for (Lesson lesson : lessonList) {
            if (lesson.getName().equals(name)) {
                return lesson;
            }
        }
        return null;
    }

    public void deleteLessonByName(String name) {
        for (Lesson lesson : lessonList) {
           if (lesson.getName().equals(name)) {
                lessonList.remove(lesson);
                break;
            }
        }
    }
}

