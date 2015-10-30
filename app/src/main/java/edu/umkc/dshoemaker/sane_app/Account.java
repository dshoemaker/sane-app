package edu.umkc.dshoemaker.sane_app;

/**
 * Created by choits on 10/14/15.
 */
public class Account {

    private String id;
    private String pw;
    private String name;
    private String age;
    private String gender;


    public Account(){

    }

    public Account(String id, String pw, String name, String age, String gender){
        this.id=id;
        this.pw=pw;
        this.age=age;
        this.name=name;
        this.gender=gender;
    }

    public String getPw(){
        return this.pw;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }
}
