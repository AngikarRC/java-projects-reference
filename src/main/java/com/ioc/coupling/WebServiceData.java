package com.ioc.coupling;

public class WebServiceData implements UserDatabaseProvider {
    @Override
    public String getUserDetailsDB() {
        return "Webservice Data Returned";
    }
}
