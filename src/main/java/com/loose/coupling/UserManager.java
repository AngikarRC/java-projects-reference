package com.loose.coupling;

public class UserManager {
    private UserDatabaseProvider userDatabaseProvider;

    public UserManager(UserDatabaseProvider userDatabaseProvider) {
        this.userDatabaseProvider = userDatabaseProvider;
    }

    public String getUserinfo(){
        return userDatabaseProvider.getUserDetailsDB();
    }
}
