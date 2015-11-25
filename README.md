# turbulent-octo-hockeypuck

package gpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class GPA {

    public static double askUserForClassGrade(Scanner in) {
        while (true) {
            System.out.println("What is your grade in this class?(A, A-, B+, B, B-, etc.)");
            String grade = in.next();

            Double gradePoints = grades.get(grade);
            if (gradePoints != null) {
                return gradePoints;
            }

            System.out.println("Invalid Input.");
        }
    }
    
    private static Map<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        grades.put("A", 4.00);
        grades.put("A-", 3.67);
        grades.put("B+", 3.33);
        grades.put("B", 3.00);
        grades.put("B-", 2.67);
        grades.put("C+", 2.33);
        grades.put("C", 2.00);
        grades.put("C-", 1.67);
        grades.put("D", 1.00);
        grades.put("F", 0.00);

        String grade = "";
        Scanner in = new Scanner(System.in);
        System.out.println("How many classes?");
        int numClasses = in.nextInt();
        int[] creds = new int[numClasses];
        double[] classGrades = new double[numClasses];
        double[] classPoints = new double[numClasses];
        
        double totalcredits = 0;
        double gradevalue = 0.0;
        double totalpoints = 0.0;
        
        for(int k = 0; k < numClasses; ++k) {
            System.out.println("How many credits is your class worth?");
            creds[k] = in.nextInt();
            classGrades[k] = askUserForClassGrade(in);
            
            classPoints[k] = creds[k] * classGrades[k];
            totalcredits += creds[k];
            totalpoints += classPoints[k];
        }


        {
            
            double gpa = totalpoints / totalcredits;
            System.out.printf("Your calculated semester GPA is %.2f\n", gpa);
            System.out.println("Is this your first semester at UF? (yes or no)");
            in.nextLine(); // clear the previous
            
            String j = in.nextLine();
            if (j.equals("no")) {

                System.out.println("what is the total amount of credits you've taken at UF excluding this semester?");
                int k = in.nextInt();
                System.out.println("What is your total GPA from the previous semesters?");
                double a = in.nextDouble();
                double gpapoints = (a * k);
                double totalgpa = (gpapoints + totalpoints) / (totalcredits + k);
                System.out.println("Your cumulative GPA is " + totalgpa);

            } else if (j.equals("yes")) {
                System.out.println("Then your cumulative GPA is ." + gpa);
            }

        }

    }

}
