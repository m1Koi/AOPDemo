package com.m1ku.aopdemo.aspectj.checklogin;

public class DataManager {
    private static DataManager instance;

    private DataManager(){

    }
    public static DataManager getInstance() {
        if (instance==null){
            instance = new DataManager();
        }
        return instance;
    }

    private boolean isLogin;


    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
