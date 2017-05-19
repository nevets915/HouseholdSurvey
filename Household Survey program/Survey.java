package q1;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.NumberFormat;

/**
 * <p>Survey.java is a driver class which utilizes the Household.java to
 * construct multiple households from a given input.  For the assignment 
 * purposes, this was given through the command prompt in the form of a 
 * text file (survey.txt).  This driver class calls upon the Household 
 * objects methods to return the ID, annual income, and number of 
 * members in the household.  The driver class then provides the income
 * average, description of households above the average, and the percentage
 * of households who are below the low-income cut-offs set by Stats Canada.</p>
 *
 * @author Steven Ma
 * @version 1.0
 */
public class Survey {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int identity;
        int annualIncome;
        int numMembers;
        int incomeM = 0;
        double percent;
        double count = 0;
        double total = 0;
        double average = 0;
        ArrayList<Household> list = new ArrayList();
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        NumberFormat fmt1 = NumberFormat.getPercentInstance();

        while (scan.hasNext()) {
            identity = scan.nextInt();
            annualIncome = scan.nextInt();
            numMembers = scan.nextInt();
            Household h = new Household(identity, annualIncome, numMembers);
            list.add(h);
            count++;
        }
        System.out.print("ID\tAnnual Income\tHousehold Members\n");
        for (Household house : list) {
            System.out.print(house.getID() + "\t" 
                    + fmt.format(house.getIncome()) + "\t\t" 
                    + house.getMembers() + "\n");
            incomeM = incomeM + house.getIncome();
        }
        average = incomeM / count;
        System.out.println("\nThere are " + (int) count + " houses."
                + "\nThe average household income is: " 
                + fmt.format(average) 
                + "\nThe households above this average income are:"
                + "\nID\tAnnual Income\t\n");
        for (Household house : list) {
            if (house.getIncome() > average) {
                System.out.print(house.getID() + "\t" 
                        + fmt.format(house.getIncome()) + "\n");
            }
            if (test(house)) {
                total++;
            }

        }
        percent = (double) (total / count);

        System.out.println("The percentage of households below "
                + "the low-income cut-off is: " + fmt1.format(percent) 
                + "\nQuestion one was called and ran sucessfully.");
    }
    /**
     * <p>Private method called, "Test" which is used to determine
     * if a household with a given number of members will be below 
     * the low income threshold.</p>
     * @param house formal parameter for the household object entered.
     * @return boolean
     */
    private static boolean test(Household house) {
        int lic;
        final int lic1 = 22229;
        final int lic2 = 27674;
        final int lic3 = 34022;
        final int lic4 = 41307;
        final int lic5 = 46850;
        final int lic6 = 52838;
        final int lic7 = 58827;
        final int licadd = 5989;
        final int licoff = 7;
        final int scn3 = 3;
        final int scn4 = 4;
        final int scn5 = 5;
        final int scn6 = 6;
        final int scn7 = 7;

        switch (house.getMembers()) {
        case 1:
            lic = lic1;
            break;
        case 2:
            lic = lic2;
            break;
        case scn3:
            lic = lic3;
            break;
        case scn4:
            lic = lic4;
            break;
        case scn5:
            lic = lic5;
            break;
        case scn6:
            lic = lic6;
            break;
        case scn7:
            lic = lic7;
            break;
        default:
            lic = lic7 + (house.getMembers() - licoff) * licadd;
            break;
        }
        return (lic > house.getIncome() ? true : false);
    }
}
