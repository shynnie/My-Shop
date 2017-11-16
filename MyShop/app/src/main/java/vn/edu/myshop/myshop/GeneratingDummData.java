package vn.edu.myshop.myshop;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by quangngoc430 on 16/11/2017.
 */

public class GeneratingDummData {
    private ArrayList<User> userArrayList;

    public GeneratingDummData(){
        userArrayList = new ArrayList<User>();
    }

    public void generate(int numberOfUsers){
        FirebaseDatabase.getInstance().getReference().removeValue();
        generateListUsers(numberOfUsers);
    }

    private ArrayList<User> generateListUsers(int numberOfUsers){
        ArrayList<User> userArrayList = new ArrayList<User>();

        for(int i = 0; i < numberOfUsers; i++) {
            userArrayList.add(generateSingleUser(i));
        }

        return userArrayList;
    }
    private User generateSingleUser(int userID){
        User newUser = new User();
        newUser.setUserID(userID);
        newUser.setUsername("customer" + userID);
        newUser.setPassword("password" + userID);

        FirebaseDatabase
                .getInstance()
                .getReference()
                .child("root")
                .child("users")
                .child(newUser.getUsername() + "-" + newUser.getPassword())
                .setValue(newUser);

        return newUser;
    }

}
