import Model.UserDetails;
import management.UserManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        Scanner scanner = new Scanner(System.in);

        boolean continueInput = true;
        while (continueInput) {
            try {
                System.out.println("Choose an operation:");
                System.out.println("1. Create User");
                System.out.println("2. Read Users");
                System.out.println("3. Update User");
                System.out.println("4. Delete User");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        UserDetails userDetails = new UserDetails();
                        System.out.println("Enter details for the User:");
                        System.out.print("Enter ID: ");
                        userDetails.setId(scanner.nextInt());
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Enter First Name: ");
                        userDetails.setFirstName(scanner.nextLine());

                        System.out.print("Enter Last Name: ");
                        userDetails.setLastName(scanner.nextLine());

                        System.out.print("Enter Email: ");
                        userDetails.setEmail(scanner.nextLine());

                        userManagement.userDataCreate(userDetails);
                        break;

                    case 2:
                        System.out.println("UserDetails:");
                        for (UserDetails user : userManagement.getUsers()) {
                            System.out.println(user.toString());
                        }
                        break;

                    case 3:
                        System.out.print("Enter the ID of the user to update: ");
                        int userIdToUpdate = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        UserDetails updatedUser = new UserDetails();
                        System.out.println("Enter updated details for the User:");
                        System.out.print("Enter First Name: ");
                        updatedUser.setFirstName(scanner.nextLine());

                        System.out.print("Enter Last Name: ");
                        updatedUser.setLastName(scanner.nextLine());

                        System.out.print("Enter Email: ");
                        updatedUser.setEmail(scanner.nextLine());

                        userManagement.updateUser(userIdToUpdate, updatedUser);
                        break;

                    case 4:
                        System.out.print("Enter the ID of the user to delete: ");
                        int userIdToDelete = scanner.nextInt();
                        userManagement.deleteUser(userIdToDelete);
                        break;

                    case 5:
                        continueInput = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Consume the newline character
            }
        }
    }
}