package education.commands;

public interface Commands {
    String EXIT = "0";
    String ADD_LESSON = "1";
    String ADD_STUDENT = "2";
    String PRINT_STUDENTS = "3";
    String PRINT_STUDENTS_BY_LESSON = "4";
    String PRINT_LESSONS = "5";
    String DELETE_LESSONS_BY_NAME = "6";
    String DELETE_STUDENT_BY_EMAIL = "7";
    String LOGOUT = "8";
    String LOGIN = "1";
    String REGISTER = "2";

    static void printAdminCommands() {
        System.out.println("\u001B[35m" + "Խնդրում եմ մուտքագրեք " + EXIT + " ելքի համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + ADD_LESSON + " դասընթաց ավելացնելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + ADD_STUDENT + " ուսանող ավելացնելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + PRINT_STUDENTS + " ուսանողների ցանկը տպելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + PRINT_STUDENTS_BY_LESSON + " ուսանողներին դասընթացով տպելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + PRINT_LESSONS + " դասընթացները տպելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + DELETE_LESSONS_BY_NAME + "դասընացը անունով ջնջելու հմար");
        System.out.println("Խնդրում եմ մուտքագրեք" + DELETE_STUDENT_BY_EMAIL + " ուսանողին էլ․հասցեով ջնջելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + LOGOUT + " դուրս գալու համար" + "\u001B[36m");


    }

    static void printUserCommands() {
        System.out.println("\u001B[35m" + "Խնդրում եմ մուտքագրեք " + EXIT + " ելքի համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + ADD_LESSON + " դասընթաց ավելացնելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + ADD_STUDENT + " ուսանող ավելացնելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + PRINT_STUDENTS + " ուսանողների ցանկը տպելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + PRINT_STUDENTS_BY_LESSON + " ուսանողներին դասընթացով տպելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + PRINT_LESSONS + " դասընթացները տպելու համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + LOGOUT + " դուրս գալու համար" + "\u001B[36m");

    }

    static void primeCommands() {
        System.out.println("\u001B[30m" + "Խնդրում եմ մուտքագրեք " + EXIT + " ելքի համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + LOGIN + " մուտքի համար");
        System.out.println("Խնդրում եմ մուտքագրեք " + REGISTER + "գրանցվելու համար" + "\u001B[37m");

    }
}
