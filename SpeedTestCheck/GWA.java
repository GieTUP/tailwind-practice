package SpeedTestCheck;

import java.util.ArrayList;
import java.util.Scanner;

public class GWA {

    public static ArrayList<String[]> subjects = new ArrayList<>();
    public static ArrayList<String[]> GWA = new ArrayList<>();

    static {
        subjects.add(new String[] { "COMP212A", "COMPUTER PROGRAMMING - OOP", "Prelim", "Midterm", "Endterm", "Grade" });
        subjects.add(new String[] { "COMP222A", "COMPUTER PROGRAMMING - JAVA EE", "Prelim", "Midterm", "Endterm", "Grade" });
        subjects.add(new String[] { "COMP312A", "WEB PROGRAMMING", "Prelim", "Midterm", "Endterm", "Grade" });
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalGWA = 0;
        int subjectCount = 0;

        String choice;
        do {
            String code = getSubjectCode(input);
            double prelim = getGrade(input, "Prelim");
            double midterm = getGrade(input, "Midterm");
            double endterm = getGrade(input, "Endterm");

            double total = calculateTotal(prelim, midterm, endterm);
            totalGWA += total;

            addGradeToList(code, prelim, midterm, endterm, total);
            subjectCount++;

            choice = askToContinue(input);

        } while (choice.equalsIgnoreCase("Y"));

        printGrades();
        printFinalGWA(totalGWA, subjectCount);
    }

    private static String getSubjectCode(Scanner input) {
        System.out.print("Enter your subject Code: ");
        return input.nextLine();
    }

    private static double getGrade(Scanner input, String gradeType) {
        System.out.print("Enter your " + gradeType + " grade: ");
        return input.nextDouble();
    }

    private static double calculateTotal(double prelim, double midterm, double endterm) {
        return (prelim * 0.3) + (midterm * 0.3) + (endterm * 0.4);
    }

    private static void addGradeToList(String code, double prelim, double midterm, double endterm, double total) {
        for (String[] subject : subjects) {
            if (subject[0].equals(code)) {
                GWA.add(new String[] { subject[0], subject[1], String.valueOf(prelim), String.valueOf(midterm), String.valueOf(endterm), String.valueOf(total) });
                break;
            }
        }
    }

    private static String askToContinue(Scanner input) {
        input.nextLine(); // Clear the newline character from previous input
        System.out.print("Enter Y to continue: ");
        return input.nextLine();
    }

    private static void printGrades() {
        System.out.println("Code:" + "\t" + "Description" + "\t\t" + "Prelim" + "\t" + "Midterm" + "\t" + "Endterm" + "\t" + "Grade");
        for (String[] item : GWA) {
            System.out.println(item[0] + "\t" + item[1] + "\t" + item[2] + "\t" + item[3] + "\t" + item[4] + "\t" + item[5]);
            System.out.println();
        }
    }

    private static void printFinalGWA(double totalGWA, int subjectCount) {
        double finalGWA = totalGWA / subjectCount;
        System.out.println("YOUR FINAL GWA IS: " + finalGWA);
        System.out.println();
    }
}
