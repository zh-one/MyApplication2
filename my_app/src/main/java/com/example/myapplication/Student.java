package com.example.myapplication;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable {

    private String name ;
    private int    age  ;
    private int    hei ;
    private String firstName ;

    private String number ;
	private String id;
        private String adr;
        private String fenshu ;
        private String test ;
        private String testTwo ;
        private String testThree ;
        private String testFour ;
		
		private String  testFive ;
		private String testSix ;
		private String testSeven ;
		private String testEight ;
		private String testNine ;

		
    public int getHei() {
        return hei;
    }

    public void setHei(int hei) {
        this.hei = hei;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return "name == " + name + " age == " + age ;

    }
}
