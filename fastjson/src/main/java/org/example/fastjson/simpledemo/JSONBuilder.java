package org.example.fastjson.simpledemo;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author : jeymingwu
 * @date : 2021-06-08
 **/

public class JSONBuilder {

    public void jsonBuilderTest() {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("int", 2);
        jsonObject.put("double", 3.14);
        jsonObject.put("char", 'c');
        jsonObject.put("boolean", true);
        jsonObject.put("string", "string");
        jsonObject.put("date", new Date());

        List<Integer> integers = Arrays.asList(1, 2, 3);
        jsonObject.put("list", integers);

        jsonObject.put("null", null);

        System.out.println(jsonObject);
    }

    public static void main(String[] args) {
        JSONBuilder jsonBuilder = new JSONBuilder();
        jsonBuilder.jsonBuilderTest();
    }
}
