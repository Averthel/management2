import api.UserService;
import entity.User;
import org.junit.Assert;
import org.junit.Test;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Test
    public void testGetAllUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(1l,"franca","twojastara"));
        users.add(new User(2l, "pablo", "admin"));

        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersFromTestClass = userService.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass );
    }

    @Test
    public void testAddUser(){
        List<User> users = new ArrayList<User>();
        User user = new User(1l, "Pati", "Patisonek");
        users.add(user);

        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        List<User> usersFromTestClass = userService.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass);

    }

    @Test
    public void testRemoveUser(){
        List<User> users = new ArrayList<User>();
        User admin = new User(1l, "admin", "admin");
        User pablo = new User(2l, "pablo", "admin");
        users.add(admin);
        users.add(pablo);

        UserServiceImpl userService = new UserServiceImpl(users);
        userService.removeUserById(1l);
        users.remove(admin);
        List<User> usersFromTestClass = userService.getAllUsers();

        Assert.assertEquals(users, usersFromTestClass);
    }

}
