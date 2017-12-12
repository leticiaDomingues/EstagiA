package com.example.leticia.estagia;

import java.util.ArrayList;
import java.util.HashMap;

public class MyDB {
    public static boolean firstExecution = true;
    public static String ra = "";
    private static HashMap<String, User> users = new HashMap<String, User>();

    public static void populateDB() {
        if(firstExecution) {
            //add the 4 users the system starts with
            MyDB.addUser(new User("Leticia", "551724", "BCC", "leticia@mail.com", "senha", false));
            MyDB.addUser(new User("Marcelo", "111111", "BCC", "marcelo@mail.com", "senha", false));
            MyDB.addUser(new User("Jorge", "222222", "BCC", "jorge@mail.com", "senha", false));
            MyDB.addUser(new User("Juliano", "333333", "BCC", "juliano@mail.com", "senha", false));
        }
    }

    /* USERS OPERATIONS */
    public static void clearUsers() {
        users.clear();
    }
    public static void addUser(User user) { users.put(user.getRA(), user);}
    public static HashMap<String, User> getAllUsers() {
        return users;
    }
    public static User getUser(String ra) {
        if(users.containsKey(ra))
            return users.get(ra);
        return null;
    }
    public void updateUser(User user) {
        users.remove(user.getRA());
        users.put(user.getRA(), user);
    }
    public static void deleteUser(User user) {
        users.remove(user.getRA());
    }
}
