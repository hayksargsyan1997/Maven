package education;


import education.commands.Commands;
import education.exception.UserNotFoundException;
import education.model.Lesson;
import education.model.Student;
import education.model.User;
import education.storage.LessonStorage;
import education.storage.StudentStorage;
import education.storage.UserStorage;
import education.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class StudentLessonTest implements Commands {
    static Scanner scanner = new Scanner(System.in);
    static UserStorage userStorage = new UserStorage();
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage studentStorage = new StudentStorage();


    public static void main(String[] args)  {
        boolean isRun = true;
        while (isRun) {
            Commands.primeCommands();
            String command = scanner.nextLine();
            switch (command) {
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                case EXIT:
                    isRun = false;
                    break;
            }
        }

    }

    private static void register() {
        System.out.println("Էլ․ հասցե");
        String email = scanner.nextLine();
        try {
           userStorage.getByEmail(email);
            System.err.println("Այս էլ․հասցեով օգտատեր գոյություն ունի");
        } catch (UserNotFoundException e) {
            System.out.println("Անուն");
            String name = scanner.nextLine();
            System.out.println("Ազգանուն");
            String surname = scanner.nextLine();
            System.out.println("Գաղտաբառ");
            String password = scanner.nextLine();
            System.out.println("Ադմին թե Օգտատեր");
            String type = scanner.nextLine();
            if (type.equals("Ադմին") || type.equals("Օգտատեր")) {
                User newUser = new User(name, surname, email, password, type);
                userStorage.add(newUser);
                System.out.println("Դուք գրանցված եք");
            } else {
                System.err.println("Սխալ տիպ");
            }
        }




    }

    private static void login() {
        System.out.println("մուտքանուն");
        String email = scanner.nextLine();
        System.out.println("Գաղտնաբառ");
        String password = scanner.nextLine();
        User user;

        try {
            user = userStorage.getByEmail(email);
            if ( user.getPassword().equals(password) && user.getType().equals("Ադմին")) {
                adminMethods();
            } else if (  user.getPassword().equals(password) && user.getType().equals("Օգտատեր")) {
                userMethods();
            } else if (!user.getPassword().equals(password)) {
                System.err.println("Անվավեր գաղտնաբառ");
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }

    private static void userMethods()  {
        boolean isRun = true;
        while (isRun) {
            Commands.printUserCommands();
            String commands = scanner.nextLine();
            switch (commands) {
                case EXIT:
                    System.exit(0);
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                case LOGOUT:
                    isRun=false;
                    break;
                default:
                    System.err.println("Անվավեր հրաման");
            }
        }

    }

    private static void adminMethods()  {
        boolean isRun = true;
        while (isRun) {

           Commands.printAdminCommands();
            String commands = scanner.nextLine();
            switch (commands) {
                case EXIT:
                   System.exit(0);
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                case DELETE_LESSONS_BY_NAME:
                    deleteLessonByName();
                    break;
                case DELETE_STUDENT_BY_EMAIL:
                    deleteStudentByEmail();
                    break;
                case LOGOUT:
                  isRun=false;
                  break;
                default:
                    System.err.println("Անվավեր հրաման");
            }
        }
    }


    private static void deleteStudentByEmail() {
        System.out.println("խնդրում ենք մուտքագրել ուսանողի էլ․հասցեն");
        String email = scanner.nextLine();

        Student student = studentStorage.getByEmail(email);

        if (student != null) {
            studentStorage.deleteStudentBYEmail(email);
            System.out.println("ուսանողի տվյալները ջնջվել են");
        } else {
            System.out.println("Այս էլ․հասցեով ուսանող չկա");
            deleteStudentByEmail();
        }
    }

    private static void deleteLessonByName() {
        System.out.println("խնդրում եմ մուտքագրեք դասընթացի անվանումը");
        String name = scanner.nextLine();

        Lesson lesson = lessonStorage.getByName(name);

        if (lesson != null) {
            lessonStorage.deleteLessonByName(name);
            System.out.println("Այդ անունով դասընթացը ջնջվել է");
        } else {
            System.err.println("Այդ անունով դասընթաց չկա");
            deleteLessonByName();
        }
    }

    private static void printStudentsByLesson() {
        System.out.println("Խնդրում ենք մուտքագրել ուսանողական դասընթացի անունը");
        String lesson = scanner.nextLine();

        Lesson lesson1 = lessonStorage.getByName(lesson);

        if (lesson1 != null) {
            studentStorage.printStudentsByLesson(lesson1);
            System.out.println("Դասընթացին մասնակցում են տվյալ ուսանողները");
        } else {
            System.out.println("Այդ անունով դասընթաց չկա");

        }
    }

    private static void addStudent()  {
        System.out.println("խնդրում ենք մուտքագրել ուսանողի էլ․հասցեն");
        String email = scanner.nextLine();

        Student student = studentStorage.getByEmail(email);

        if (student == null) {
            System.out.println("խնդրում ենք մուտքագրել ուսանողի անունը");
            String name = scanner.nextLine();
            System.out.println("խնդրում ենք մուտքագրել ուսանողի ազգանունը");
            String surname = scanner.nextLine();
            System.out.println("խնդրում ենք մուտքագրել ուսանողի տարիքը");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("խնդրում ենք մուտքագրել ուսանողի հեռախոսահամարը");
            String phone = scanner.nextLine();
            System.out.println("Խնդրում ենք մուտքագրել ծննդըան օրը 22/12/2022");
            String birthday = scanner.nextLine();
            Date date = null;
            try {
                date = DateUtil.stringToDate(birthday);
            } catch (ParseException e) {
                System.err.println("Ամսաթվի անվավեր ձևաչափ");
            }
            System.out.println("խնդրում եմ մուտքագրել դասընթացները");
            String lessons = scanner.nextLine();
            String[] less = lessons.split(",");
            Lesson[] lesson = new Lesson[less.length];
            for (int i = 0; i < less.length; i++) {
                if (lessonStorage.getByName(less[i]) != null) {
                    lesson[i] = lessonStorage.getByName(less[i]);
                } else {
                    System.out.println("Դասընթացը գոյություն չունի");
                }
            }
            Student student1 = new Student(name, surname, age, email, phone, lesson, date);
            studentStorage.add(student1);
            System.out.println("Շնորհակալություն, ուսանողն ավելացվեց");

        }

    }

    private static void addLesson() {
        System.out.println("Խնդրում ենք մուտքագրել դասընթացի անունը");
        String name = scanner.nextLine();

        Lesson lesson = lessonStorage.getByName(name);

        if (lesson == null) {
            System.out.println("Խնդրում ենք մուտքագրել դասընթացի տևողությունը");
            String duration = scanner.nextLine();
            System.out.println("Խնդրում ենք մուտքագրել դասախոսի անունը");
            String lecturerName = scanner.nextLine();
            System.out.println("Խնդրում ենք մուտքագրել դասընթացի արժեքը");
            double price = Double.parseDouble(scanner.nextLine());

            Lesson lessons = new Lesson(name, duration, lecturerName, price);

            lessonStorage.add(lessons);

            System.out.println("Շնորհակալություն, դասընթացն ավելացվեց");
        } else {
            System.err.println("Այդ անունով դասընթաց արդեն կար");
        }
    }


}