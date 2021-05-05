package Model;

/** This class creates an InHousePart object.*/
public class InHousePart extends Part {

    private int machineId;


    /** This is the InHousePart Constructor. This constructor creates a new InHousePart object.
     * @param id part id
     * @param name part name
     * @param price part price
     * @param stock part quantity
     * @param min minimum part quantity
     * @param max maximum part quantity
     * @param machineId machine ID*/
    public InHousePart(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }


    /** This is the machineId Getter. This method returns the machineId.
     * @return machine ID*/
    public int getMachineId() {
        return machineId;
    }

    /** This is the machineId Setter. This method sets the machineId.
     * @param machineId machine ID*/
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

}
