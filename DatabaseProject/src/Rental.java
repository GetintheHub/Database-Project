public class Rental {
    private String itemName;
    private String rentalStartDate;
    private String rentalEndDate;
    private String username;
    private String renterId;
    private String itemId;

    // Constructor
    public Rental(String itemName, String rentalStartDate, String rentalEndDate, String username, String renterId) {
        this.itemName = itemName;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.username = username;
        this.renterId = renterId;
    }

    // Getters and Setters
    
    public String getRenterID() {
       return renterId;
    } 
    
    public void setRenterID(String renterID) {
       this.renterId = renterID;
    }
    
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(String rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public String getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(String rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Display rental details
    @Override
    public String toString() {
        return "Rental for ID: "+ renterId + "Item "+ itemName + " from " + rentalStartDate + " to " + rentalEndDate;
    }
}
