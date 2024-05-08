package com.ltp.workbook;

public class Employee {
    private String name;
    private int age;
    private String Role;

    public Employee(String name, int age, String Role) {
        this.name = name;
        this.age = age;
        this.Role = Role;
    }

    public Employee() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return this.Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

}
