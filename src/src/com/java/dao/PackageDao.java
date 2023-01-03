package com.java.dao;

import com.java.bean.Package;
import java.util.Random;

public class PackageDao {

    //Create Package List
    private Package[][] packageList = new Package[10][];
    //Current number of packages
    private int size;
    {
        for(int i = 0; i < 10; i++){
            packageList[i] = new Package[10];
        }
    }
    private Random random = new Random();

    /**
     * Add a new package into package list
     * @param p new package
     * @return true if success else false
     */
    public boolean add(Package p){
        if(size == 100){
            return false;
        }
        //Generate 2 random index
        int x = -1;
        int y = -1;
        while(true){
            x = random.nextInt(10);
            y = random.nextInt(10);
            if(packageList[x][y] == null){
                //No package in this place
                break;
            }
        }
        //Generate package code
        int code = randomCode();
        p.setCode(code);
        packageList[x][y] = p;
        return true;
    }

    /**
     * Generate random package code
     * @return generated code
     */
    private int randomCode(){
        //Generate six digits code
        while(true){
            int code = random.nextInt(900000)+100000;
            Package p = findByCode(code);
            if(p == null) {
                return code;
            }
        }
    }

    /**
     * Searching for package using package number
     * @param number package number
     * @return Searching result, null if not exist
     */
    public Package findByNumber(String number){
        Package p = new Package();
        p.setNumber(number);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(p.equals(packageList[i][j])){
                    return packageList[i][j];
                }
            }
        }
        return null;
    }


    /**
     * Searching for package using package code
     * @param code package code
     * @return Searching result, null if not exist
     */
    public Package findByCode(int code){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(packageList[i][j] != null)
                if(packageList[i][j].getCode() == code){
                    return packageList[i][j];
                }
            }
        }
        return null;
    }

    /**
     * (Not necessary step)
     * @param oldP
     * @param newP
     */
    public void update(Package oldP, Package newP){
        delete(oldP);
        add(newP);
    }

    /**
     * delete package from package list
     * @param p the package to delete
     */
    public void delete(Package p){
        s: for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(p.equals(packageList[i][j])){
                    packageList[i][i] = null;
                    break s;
                }
            }
        }
    }

    public Package[][] findAll(){
        return packageList;
    }

}
