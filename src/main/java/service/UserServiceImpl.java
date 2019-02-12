package service;

import api.UserService;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> users;

    public UserServiceImpl(){
        this.users = new ArrayList<User>();
    }

    public UserServiceImpl(List<User> users){
        this.users = users;
    }


    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUserById(Long userId) {
        for(int i=0; i<users.size(); i++){
            //wyciągnięcie i-tego usera z listy
            User userFromList = users.get(i);
            //jeżeli ID usera z listy jest równe podanemu userId do usunięcia
            if(userFromList.getId() == userId){
                //to usuń tego usera z pod i-tego indexu
                users.remove(i);
                // i przerwij pętle w końcu user już został usunięty
                break;
            }
        }
    }
}

