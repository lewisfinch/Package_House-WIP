package com.java.bean;

import java.util.Objects;

public class Package {
    // Package Number
    private String number;

    // Package Company
    private String company;

    // Package Code
    private int code;

    // Constructors
    public Package() {}
    public Package(String number, String company, int code) {
        this.number = number;
        this.company = company;
        this.code = code;
    }

    // Setter & Getter
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Package{" +
                "number='" + number + '\'' +
                ", company='" + company + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return Objects.equals(number, aPackage.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
