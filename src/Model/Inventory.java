package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** This class supplies static methods for Parts and Products.*/
public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Part> filteredParts = FXCollections.observableArrayList();
    private static ObservableList<Product> filteredProducts = FXCollections.observableArrayList();

    /** This is the lookupPart method. This method returns the part matching the partId parameter.
     * @param partId part ID to look up
     * @return part with matching ID*/
    public static Part lookupPart(int partId) {
        for(Part part : getAllParts()) {
            if (part.getId() == partId)
                return part;

        }
        return null;
    }

    /** This is the lookupProduct method. This method returns the product matching the productId parameter.
     * @param productId product ID to look up
     * @return product with matching ID*/
    public static Product lookupProduct(int productId) {
        for(Product product : getAllProducts()) {
            if (product.getId() == productId)
                return product;

        }
        return null;
    }

    /** This is the getAllFilteredParts Getter. This method returns filteredParts.
     * @return filtered parts list*/
    public static ObservableList<Part> getAllFilteredParts() {
        return filteredParts;
    }

    /** This is the getAllFilteredProducts Getter. This method returns filteredProducts.
     * @return filtered products list*/
    public static ObservableList<Product> getAllFilteredProducts() {
        return filteredProducts;
    }

    /** This is the lookupPart method. This method returns the part matching the partName input.
     * @param partName part name to look up
     * @return filtered parts list*/
    public static ObservableList<Part> lookupPart(String partName) {
        if(!(getAllFilteredParts().isEmpty()))
            getAllFilteredParts().clear();


        for(Part part : getAllParts()) {
            if(part.getName().contains(partName)) {
                getAllFilteredParts().add(part);
            }
        }

        return getAllFilteredParts();
    }

    /** This is the lookupProduct method. This method returns the product matching the productName parameter.
     * @param productName product name to look up
     * @return filtered products list*/
    public static ObservableList<Product> lookupProduct(String productName) {
        if(!(getAllFilteredProducts().isEmpty()))
            getAllFilteredProducts().clear();


        for(Product product : getAllProducts()) {
            if(product.getName().contains(productName)) {
                getAllFilteredProducts().add(product);
            }
        }

        return getAllFilteredProducts();
    }

    /** This is the updatePart method. This method updates the part with the matching index.
     * @param index the index of the part to update
     * @param selectedPart the part to update*/
    public static void updatePart(int index, Part selectedPart) {
        getAllParts().set(index, selectedPart);
    }

    /** This is the updateProduct method. This method updates the product with the matching index.
     * @param index the index of the product to update
     * @param newProduct the product to update*/
    public static void updateProduct(int index, Product newProduct) {
        getAllProducts().set(index, newProduct);
    }

    /** This is the deletePart method. This method deletes the part that is passed in.
     * @param selectedPart part to be deleted
     * @return boolean value of whether part was deleted*/
    public static boolean deletePart(Part selectedPart) {
        for(Part part : getAllParts()) {

            if(part.getId() == selectedPart.getId()) {
                return getAllParts().remove(part);
            }
        }
        return false;
    }

    /** This is the deleteProduct method. This method deletes the product that is passed in.
     * @param selectedProduct product to be deleted
     * @return boolean value of whether product was deleted*/
    public static boolean deleteProduct(Product selectedProduct) {
        for(Product product : getAllProducts()) {

            if(product.getId() == selectedProduct.getId()) {
                return getAllProducts().remove(product);
            }
        }
        return false;
    }

    /** This is the allParts Getter. This method returns allParts.
     * @return all parts list*/
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /** This is the allProducts Getter. This method returns allProducts.
     * @return all products list*/
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    /** This is the addPart method. This method adds the part that is passed in.
     * @param newPart part to add*/
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /** This is the addProduct method. This method adds the product that is passed in.
     * @param newProduct product to add*/
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

}
