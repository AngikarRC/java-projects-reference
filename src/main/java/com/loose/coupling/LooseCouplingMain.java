package com.loose.coupling;

public class LooseCouplingMain {

    public static void main(String[] args) {
        UserDatabaseProvider mysqlProvider = new MySqlDB();
        UserManager userManagerMySQL = new UserManager(mysqlProvider);
        System.out.println(userManagerMySQL.getUserinfo());

        UserDatabaseProvider webProvider = new WebServiceData();
        UserManager userManagerWeb = new UserManager(webProvider);
        System.out.println(userManagerWeb.getUserinfo());

    }
}
