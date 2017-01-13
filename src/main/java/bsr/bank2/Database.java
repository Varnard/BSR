package bsr.bank2;

import bsr.bank.Account;
import bsr.bank.Operation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varn on 2017-01-06.
 */
public class Database {

    public static boolean checkLogin(String login, String password){

        Boolean success=false;

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/bank.db");

            String sql = "Select login, password from accounts where login='" + login +"\'";

            stmt = c.createStatement();
            ResultSet rs =stmt.executeQuery(sql);

            String pass = rs.getString("password");

            success=password.equals(pass);

            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return success;
    }

    public static Account getAccount(String login){

        Account account = null;

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/bank.db");

            String sql = "Select number,saldo from accounts where login='" + login +"\'";

            stmt = c.createStatement();
            ResultSet rs =stmt.executeQuery(sql);

            String number = rs.getString("number");
            double saldo = rs.getDouble("saldo");

            account = new Account();
            account.setNumber(number);
            account.setSaldo(saldo);

            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return account;
    }

    public static List<Operation> getOperations(String accountNumber){

        List<Operation> operations = new ArrayList<>();

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/bank.db");

            String sql = "Select * from operations where acc_number='" + accountNumber +"\'";

            stmt = c.createStatement();
            ResultSet rs =stmt.executeQuery(sql);
            do {
                Operation o = new Operation();
                o.setAccNumber(rs.getString("acc_number"));
                o.setTitle(rs.getString("title"));
                o.setType(rs.getString("type"));
                o.setValue(rs.getDouble("value"));
                o.setSaldoAfter(rs.getDouble("saldo_after"));
                //o.setDate(rs.getString("date"));
                //o.set(rs.getString("source"));

                operations.add(o);
            }
            while (rs.next());



            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return operations;
    }


    public static boolean updateSaldo(String accountNumber, double amount) throws AccountNotFoundException {

        Boolean success=false;

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/bank.db");

            String sql = "Select saldo from accounts where number='" + accountNumber +"\'";

            stmt = c.createStatement();
            ResultSet rs =stmt.executeQuery(sql);

            if (rs.isClosed()) throw new AccountNotFoundException();
            double saldo = rs.getDouble("saldo");

            saldo+=amount;

            sql = "Update accounts set saldo=" + saldo + " where number ="+ accountNumber;

            stmt.close();
            stmt = c.createStatement();
            stmt.executeUpdate(sql);

            success=true;
            stmt.close();
            c.close();

        } catch ( SQLException | ClassNotFoundException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return success;
    }



}
