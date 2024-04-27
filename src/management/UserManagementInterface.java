package management;

import Model.UserDetails;
import java.util.List;

// Define an interface for UserManagement operations
public interface UserManagementInterface {
    void userDataCreate(UserDetails userDetails) throws UserManagementException;
    List<UserDetails> getUsers();
    void updateUser(int userId, UserDetails updatedUserDetails) throws UserManagementException;
    void deleteUser(int userId) throws UserManagementException;
}