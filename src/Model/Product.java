package Model;

import javafx.collections.ObservableList;

/** This class creates a Product object.*/
public class Product {

    private ObservableList<Part> associatedParts;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;


    /** This is the Product Constructor. This constructor creates a new Product object.
     * @param associatedParts list of parts associated with the product
     * @param id product id
     * @param name product name
     * @param price product price
     * @param stock product quantity
     * @param min minimum product quantity
     * @param max maximum product quantity*/
    public Product(ObservableList<Part> associatedParts, int id, String name, double price, int stock, int min, int max) {
        this.associatedParts = associatedParts;
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }


    /** This is the id Getter. This method returns the Product id.
     * @return product id*/
    public int getId() {
        return id;
    }

    /** This is the id Setter. This method sets the Product id.
     * @param id product id*/
    public void setId(int id) {
        this.id = id;
    }

    /** This is the name Getter. This method returns the Product name.
     * @return product name*/
    public String getName() {
        return name;
    }

    /** This is the name Setter. This method sets the Product name.
     * @param name product name*/
    public void setName(String name) {
        this.name = name;
    }

    /** This is the price Getter. This method returns the Product price.
     * @return product price*/
    public double getPrice() {
        return price;
    }

    /** This is the price Setter. This method sets the Product price.
     * @param price product price*/
    public void setPrice(double price) {
        this.price = price;
    }

    /** This is the stock Getter. This method returns the Product stock quantity.
     * @return product quantity*/
    public int getStock() {
        return stock;
    }

    /** This is the stock Setter. This method sets the Product stock quantity.
     * @param stock product quantity*/
    public void setStock(int stock) {
        this.stock = stock;
    }

    /** This is the min Getter. This method returns the Product minimum quantity value.
     * @return minimum product quantity*/
    public int getMin() {
        return min;
    }

    /** This is the min Setter. This method sets the Product minimum quantity value.
     * @param min minimum product quantity*/
    public void setMin(int min) {
        this.min = min;
    }

    /** This is the max Getter. This method returns the Product maximum quantity value.
     * @return maximum product quantity*/
    public int getMax() {
        return max;
    }

    /** This is the max Setter. This method sets the Product maximum quantity value.
     * @param max maximum product quantity*/
    public void setMax(int max) {
        this.max = max;
    }

    /** This is the addAssociatedPart method. This method adds the part that is passed in to the associatedParts list.
     * @param part part to add to associated parts list*/
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }

    /** This is the deleteAssociatedPart method. This method removes the part that is passed in from the associatedParts list.
     * @param selectedAssociatedPart part to delete from associated parts list
     * @return boolean value of whether part was deleted from associated parts list*/
    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        return associatedParts.remove(selectedAssociatedPart);
    }

    /** This is the getAllAssociatedParts Getter. This method returns associatedParts.
     * @return list of associated parts*/
    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }

}
