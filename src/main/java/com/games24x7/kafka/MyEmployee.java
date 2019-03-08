package com.games24x7.kafka;

public class MyEmployee {
    private String naveenName;

    public MyEmployee() {

    }

    public MyEmployee(String name) {
        this.naveenName = name;

    }


    public String getName() {
        return this.naveenName;
    }

    public void setName(String name) {
        this.naveenName = name;
    }

    public String getNaveenName() {
        return this.naveenName;
    }

    public void setNaveenName(String name) {
        this.naveenName = name;
    }

    @Override
    public String toString() {
        return "MyEmployee( " + this.getName() + " )";
    }
}
