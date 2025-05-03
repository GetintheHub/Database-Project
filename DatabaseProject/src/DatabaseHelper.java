import java.util.HashMap;
import java.util.Map;

public class DatabaseHelper {

    // user database (placeholder)
    private static final Map<String, String> usersDB = new HashMap<>();

    // rentals storage (placeholder)
    private static final Map<String, Rental> rentalsDB = new HashMap<>();

    static {
        // users (placeholder)
        usersDB.put("Electric Boogalo", "COSC 457");
    }

    // validating a user (placeholder)
    public static boolean validateUser(String username, String password) {
        // Placeholder for database query
        return usersDB.containsKey(username) && usersDB.get(username).equals(password);
    }

    // adding a rental (placeholder)
    public static void addRental(Rental rental) {
        // Placeholder for inserting rental into database
        rentalsDB.put(rental.getItemName(), rental);
    }

    // list of rentals (placeholder)
    public static Map<String, Rental> getRentals() {
        // Placeholder for fetching rentals from database
        return rentalsDB;
    }

  
}
