package id.my.avmmartin.matched.data.network.firestore.model;

import id.my.avmmartin.matched.utils.HashUtils;

public class User {
    private String name;
    private String hashPassword;

    public boolean isValidPassword(String password) {
        return getHashPassword().equals(HashUtils.sha512(password));
    }

    public void setPassword(String password) {
        setHashPassword(HashUtils.sha512(password));
    }

    // constructor

    public User() {
        // default constructor
    }

    public User(String name, String password) {
        setName(name);
        setPassword(password);
    }

    // getter

    public String getName() {
        return name;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    // setter

    private void setName(String name) {
        this.name = name;
    }

    private void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }
}
