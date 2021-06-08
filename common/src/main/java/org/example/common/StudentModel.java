package org.example.common;

import java.util.Date;
import java.util.List;

/**
 * @author : jeymingwu
 * @date : 2021-06-08
 **/

public class StudentModel {

    private String name;
    private Date birthday;
    private String address;
    private String telephone;
    private String mobilePhone;

    private List<HobbyModel> hobbyModelList;

    public StudentModel() {
    }

    public StudentModel(String name, Date birthday, String address, String telephone, String mobilePhone, List<HobbyModel> hobbyModelList) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.telephone = telephone;
        this.mobilePhone = mobilePhone;
        this.hobbyModelList = hobbyModelList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public List<HobbyModel> getHobbyModelList() {
        return hobbyModelList;
    }

    public void setHobbyModelList(List<HobbyModel> hobbyModelList) {
        this.hobbyModelList = hobbyModelList;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", hobbyModelList=" + hobbyModelList +
                '}';
    }
}
