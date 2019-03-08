package com.games24x7.kafka;

import java.io.Serializable;
import java.util.List;

public class MyEmployeeList implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<MyEmployee> myEmployeeList;

    public MyEmployeeList() {

    }

    public MyEmployeeList(List<MyEmployee> myEmployeeList) {
        this.myEmployeeList = myEmployeeList;
    }

    public List<MyEmployee> getMyEmployeeList() {
        return myEmployeeList;
    }

    public void setMyEmployeeList(List<MyEmployee> myEmployeeList) {
        this.myEmployeeList = myEmployeeList;
    }

    public List<MyEmployee> getEmployeeList() {
        return myEmployeeList;
    }

    public void setEmployeeList(List<MyEmployee> myEmployeeList) {
        this.myEmployeeList = myEmployeeList;
    }


    @Override
    public String toString() {
        return "MyEmployeeList [ " + this.myEmployeeList + " ]";
    }
}
