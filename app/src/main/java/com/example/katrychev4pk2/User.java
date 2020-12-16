package com.example.katrychev4pk2;

public class User {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
    public int getStateSignal() {
        return StateSignal;
    }
    public void setStateSignal(int stateSignal) {
         StateSignal=StateSignal;
    }



    private String Name, State;
    private int Age;

    public User(String name, String state, int age, int stateSignal) {
        Name = name;
        State = state;
        Age = age;
        StateSignal=stateSignal;
    }
       private int StateSignal;
}




