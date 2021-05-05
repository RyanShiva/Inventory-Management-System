package Model;

/** This class creates an OutsourcedPart object.*/
public class OutsourcedPart extends Part {

    private String companyName;


    /** This is the OutsourcedPart Constructor. This constructor creates a new OutsourcedPart object.
     * @param id part id
     * @param name part name
     * @param price part price
     * @param stock part quantity
     * @param min part minimum quantity
     * @param max part maximum quantity
     * @param companyName name of the company that sourced the part*/
    public OutsourcedPart(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }


    /** This is the companyName Getter. This method returns the companyName.
     * @return name of the company that sourced the part*/
    public String getCompanyName() {
        return companyName;
    }

    /** This is the companyName Setter. This method sets the companyName.
     * @param companyName name of the company that sourced the part*/
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
