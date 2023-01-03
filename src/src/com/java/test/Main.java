package com.java.test;

import com.java.dao.PackageDao;
import com.java.view.Views;
import com.java.bean.Package;

public class Main {

    //Init view
    private static Views view = new Views();
    //Init dao
    private static PackageDao dao = new PackageDao();

    public static void main(String[] args) {

        //1. Welcome
        view.welcome();

        m: while (true) {
            //2. Identity choose
            int menu = view.menu();
            switch (menu) {
                case 0:
                    break m;
                case 1:
                    cClient();
                    break;
                case 2:
                    uClient();
                    break;
            }
        }
        view.bye();
    }

    private static void cClient(){
        while(true) {
            int menu = view.cMenu();
            switch (menu) {
                case 0:
                    return;
                case 1: {   //Insert
                    //1. Enter package information
                    Package p = view.insert();
                    //2. Check if already existed
                    Package p2 = dao.findByNumber(p.getNumber());
                    //3. Store Package
                    if(p2 == null) {
                        dao.add(p);
                    }else{
                        //already existed
                        view.packageExist();
                    }
                }
                    break;
                case 2: {   //Modify
                    //1. Enter package info
                    String num = view.findByNumber();
                    //2. Search for data
                    Package p = dao.findByNumber(num);
                    //3. Print package info
                    if(p == null){
                        view.printNull();
                    }else{
                        view.printPackage(p);
                        //4. Modification
                        view.update(p);
                        dao.update(p,p);    //Not necessary
                        view.printPackage(p);
                    }
                }
                    break;
                case 3: {   //delete
                    //1. Enter package number
                    String num = view.findByNumber();
                    //2. Search for data
                    Package p = dao.findByNumber(num);
                    if(p == null){
                        view.printNull();
                    }else{
                        view.printPackage(p);
                        int choice = view.delete();
                        if(choice == 1){
                            dao.delete(p);
                            view.success();
                        }
                    }
                }
                    break;
                case 4: {   //show all
                    dao.findAll();
                    Package[][] data = dao.findAll();
                    view.printAll(data);
                }
                    break;
            }
        }
    }

    private static void uClient(){
        //1. Get package code
        int code = view.uMenu();
        //2. Search for package using package code
        Package p = dao.findByCode(code);
        if(p == null){
            view.printNull();
        }else{
            view.success();
            view.printPackage(p);
            dao.delete(p);
        }
    }
}
