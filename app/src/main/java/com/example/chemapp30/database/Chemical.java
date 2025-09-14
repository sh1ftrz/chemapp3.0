package com.example.chemapp30.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Chemical {
    @PrimaryKey
    private String code;
    private String name;
    private String info;
    private String property;
    private String firstAid;

    // getters & setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }
    public String getProperty() { return property; }
    public void setProperty(String property) { this.property = property; }
    public String getFirstAid() { return firstAid; }
    public void setFirstAid(String firstAid) { this.firstAid = firstAid; }
}
