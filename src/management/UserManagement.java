package management;

import Model.UserDetails;

import java.util.ArrayList;
import java.util.List;


public class UserManagement  implements UserManagementInterface {
    List<UserDetails> users = new ArrayList<>();

    public UserManagement() {
        this.users = new ArrayList<>();
    }

    @Override
    public void userDataCreate(UserDetails userDetails) throws UserManagementException {
        if (userDetails == null) {
            throw new UserManagementException("User details cannot be null");
        }
        users.add(userDetails);
    }

    @Override
    public List<UserDetails> getUsers() {
        return users;
    }

    @Override
    public void updateUser(int userId, UserDetails updatedUserDetails) throws UserManagementException {
        boolean userFound = false;
        for (UserDetails user : users) {
            if (user.getId() == userId) {
                user.setFirstName(updatedUserDetails.getFirstName());
                user.setLastName(updatedUserDetails.getLastName());
                user.setEmail(updatedUserDetails.getEmail());
                userFound = true;
                break;
            }
        }
        if (!userFound) {
            throw new UserManagementException("User with ID " + userId + " not found");
        }
    }

    @Override
    public void deleteUser(int userId) throws UserManagementException {
        boolean removed = users.removeIf(user -> user.getId() == userId);
        if (!removed) {
            throw new UserManagementException("User with ID " + userId + " not found");
        }
    }
}