package com.ioc.coupling;

public class NewDatabaseService implements UserDatabaseProvider {


    @Override
    public String getUserDetailsDB() {
        return "NoSQL DB fetched";
    }
}
