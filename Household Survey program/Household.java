package q1;
/**
 * <p>Household.java is a base class which provides a blue-print
 * for a household object.  It contains various methods below to 
 * set or get the ID number, annual income or number of members
 * for the household.  The class also provides a method to give
 * a description of the household returned as a string.</p>
 *
 * @author Your Name goes here
 * @version 1.0
 */
public class Household {
    /**
     * <p>Constant for house ID.</p>
     */
    private int iD;
    /**
     * <p>Constant for house income.</p>
     */
    private int income;
    /**
     * <p>Constant for number of members.</p>
     */
    private int members;
    /**
     * <p>Constant for maximum ID number.</p>
     */
    private final int idMax = 9999;
    /**
     * <p>Constructor for household object.</p>
     * @param identity formal parameter for the ID that was inputed.
     * @param annualIncome formal parameter for the annual income inputed.
     * @param numMembers formal parameter for number of household members.
     */
    public Household(int identity, int annualIncome, int numMembers) {
        if (identity < 0 || identity > idMax) {
            throw new IllegalArgumentException("ID must be more than or equal "
                    + "to 0000 or less than 9999");
        }
        if (annualIncome < 0) {
            throw new IllegalArgumentException("Annual income cannot be less "
                    + "than zero.");
        }
        if (numMembers <= 0) {
            throw new IllegalArgumentException("There must be at least 1 member"
                    + " of the household.");
        }
        iD = identity;
        income = annualIncome;
        members = numMembers;
    }
    
    /**
     * <p>Method for setting the ID in household object.</p>
     * @param identity formal parameter from another class
     */
    public void setID(int identity) {
        if (identity < 0 || identity > idMax) {
            throw new IllegalArgumentException("ID must be more than or equal "
                    + "to 0000 or less than or equal to 9999");
        }
        iD = identity;
    }
    /**
     * <p>Method for setting the annual income for household object.</p>
     * @param annualIncome formal parameter from another class
     */
    public void setIncome(int annualIncome) {
        if (annualIncome < 0) {
            throw new IllegalArgumentException("Annual income cannot be less "
                    + "than zero.");
        }
        income = annualIncome;
    }
    /**
     * <p>Method for setting the number of members for household object.</p>
     * @param numMembers formal parameter from another class
     */
    public void setMembers(int numMembers) {
        if (numMembers <= 0) {
            throw new IllegalArgumentException("There must be at least 1 member"
                    + " of the household.");
        }
        members = numMembers;
    }
    /**
     * <p>Method for returning the integer of ID for household object.</p>
     * @return ID
     */
    public int getID() {
        return iD;
    }
    /**
     * <p>Method for returning the integer of income for household object.</p>
     * @return income
     */
    public int getIncome() {
        return income;
    }
    /**
     * <p>Method for returning the number of members for household object.</p>
     * @return members
     */
    public int getMembers() {
        return members;
    }
    /**
     *  <p>Method for returning a description of house object.</p>
     *  @return String
     */
    public String toString() {
        return "" + iD + " " + income + " " + members;
    }
    
}
