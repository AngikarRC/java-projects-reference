package com.loose.coupling;

public class MySqlDB implements UserDatabaseProvider {

    @Override
    public String getUserDetailsDB() {
        return "Details Fetched from MySQL";
    }
}
