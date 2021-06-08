package org.example.common;

/**
 * @author : jeymingwu
 * @date : 2021-06-08
 **/

public class HobbyModel {

    private String name;
    private String decs;

    public HobbyModel() {
    }

    public HobbyModel(String name, String decs) {
        this.name = name;
        this.decs = decs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    @Override
    public String toString() {
        return "HobbyModel{" +
                "name='" + name + '\'' +
                ", decs='" + decs + '\'' +
                '}';
    }
}
