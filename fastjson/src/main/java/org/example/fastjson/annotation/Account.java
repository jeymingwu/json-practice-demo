package org.example.fastjson.annotation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author : jeymingwu
 * @date : 2021-06-08
 **/

public class Account {

    @JSONField(name = "id", ordinal = 1)
    private String id;

    @JSONField(name = "username", ordinal = 2)
    private String username;

    @JSONField(name = "password", serialize = false)
    private String password;

    @JSONField(name = "lastLoginDate", format = "yyyy-MM-dd-HH-mm-ss", ordinal = 3, deserialize = false)
    private Date lastLoginDate;

    public Account() {
    }

    public Account(String id, String username, String password, Date lastLoginDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastLoginDate = lastLoginDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }

    public static void main(String[] args) {

        Account tony = new Account("001", "Tony", "123456", new Date());
        Account lisa = new Account("002", "lisa", "123456", new Date());
        Account jane = new Account("003", "jane", "123456", new Date());

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(tony);
        accounts.add(lisa);
        accounts.add(jane);

        JSON json = new JSONObject();
        System.out.println(json.toJSONString(accounts));

        String text = json.toJSONString(tony);
        Account account = JSON.parseObject(text, Account.class);
        System.out.println(account);
    }
}
