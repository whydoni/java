package com.javaDB;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String type = "";
        try {
            login();
            while (!type.equals("99")) {
                showMenu();
                type = br.readLine();

                switch (type) {
                    case "1":
                        menu1();
                        break;

                    case "2":
                        menu2();
                        break;

                    case "3":
                        menu3();
                        break;

                    case "4":
                        menu4();
                        type = "99";
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public static void login() {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        Connection con;
        ResultSet rs;
        Statement stmt;
        try {
            System.out.print("Username : ");
            String user = br.readLine();
            System.out.print("Password : ");
            String pass = br.readLine();

            boolean emailCorrect = Pattern.matches("([\\w])*@([\\w])*[.]{1}([\\w])*", user);
            boolean pswdCorrect = Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}", pass);

            if (emailCorrect && pswdCorrect){
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/jsondb?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","Rahasia=123");

                stmt =con.createStatement();
                String sql = "Select * from users Where username='" + user + "' and password='" + pass + "'";
                rs = stmt.executeQuery(sql);
                if(rs.next()){
                    System.out.println("Success Login");
                } else {
                    System.out.println("User not found");
                }
                con.close();
            } else {
                System.out.println("Invalid username or password");
            }

        }  catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private static void showMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Input Data to DB");
        System.out.println("2. Edit Data from DB");
        System.out.println("3. Delete Data from DB");
        System.out.println("4. Exit\n");
    }

    private static void menu1() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        Connection con;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/jsondb?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","Rahasia=123");
            System.out.print("Fullname : ");
            String fullname = br.readLine();
            System.out.print("Nickname : ");
            String name = br.readLine();
            System.out.print("Address : ");
            String address = br.readLine();
            System.out.print("Status : ");
            String status = br.readLine();
            System.out.print("Physics Grade : ");
            int physics = Integer.parseInt(br.readLine());
            System.out.print("Calculus Grade : ");
            int calculus = Integer.parseInt(br.readLine());
            System.out.print("Biology Grade : ");
            int biology = Integer.parseInt(br.readLine());

            stmt=con.createStatement();
            stmt.executeUpdate("insert into mhs values(null,'"+fullname+"','"+name+"','"+address+"','"+status+
                    "',"+physics+","+calculus+","+biology+")");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private static void menu2() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        Connection con;
        ResultSet rs;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/jsondb?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","Rahasia=123");
            stmt =con.createStatement();
            rs =stmt.executeQuery(String.format("select * from mhs"));
            while(rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getInt(7)+"  "+rs.getInt(8));
            }

            System.out.print("Edit ID Data : ");
            int id = Integer.parseInt(br.readLine());
            System.out.print("Fullname : ");
            String fullname1 = br.readLine();
            System.out.print("Nickname : ");
            String name1 = br.readLine();
            System.out.print("Address : ");
            String address1 = br.readLine();
            System.out.print("Status : ");
            String status1 = br.readLine();
            System.out.print("Physics Grade : ");
            int physics1 = Integer.parseInt(br.readLine());
            System.out.print("Calculus Grade : ");
            int calculus1 = Integer.parseInt(br.readLine());
            System.out.print("Biology Grade : ");
            int biology1 = Integer.parseInt(br.readLine());

            stmt.executeUpdate("update mhs set fullname='"+fullname1+"',name='"+name1+"',address='"+address1+"',status='"+status1+"',gradesphysics='"+physics1+"',gradescalculus='"+calculus1+"',gradesbiologi='"+biology1+"' where id="+id);
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private static void menu3() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        Connection con;
        ResultSet rs;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/jsondb?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","Rahasia=123");
            stmt =con.createStatement();
            rs =stmt.executeQuery(String.format("select * from mhs"));
            while(rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getInt(7)+"  "+rs.getInt(8));
            }
            System.out.print("Delete ID Data : ");
            int id1 = Integer.parseInt(br.readLine());

            stmt.executeUpdate("delete from mhs where id="+id1);
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    private static void menu4() throws IOException {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/jsondb?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","Rahasia=123");
            con.close();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}
