package org.example.fastjson.simpledemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author : jeymingwu
 * @date : 2021-06-08
 **/

public class JSONParse {

    public void jsonParseTest() {

        String text = "{\"date\":1623157670280,\"boolean\":true,\"string\":\"string\",\"double\":3.14,\"char\":\"c\",\"list\":[1,2,3],\"int\":2}\n";

        JSONObject jsonObject = JSONObject.parseObject(text);

        int anInt = jsonObject.getIntValue("int");
        double aDouble = jsonObject.getDoubleValue("double");
        String aChar = jsonObject.getString("char");
        boolean aBoolean = jsonObject.getBooleanValue("boolean");
        String string = jsonObject.getString("string");
        Date date = jsonObject.getDate("date");
        List<Integer> integers = JSON.parseArray(jsonObject.getJSONArray("list").toJSONString(), Integer.class);
        String aNull = jsonObject.getString("null");

        System.out.println("int:" + anInt);
        System.out.println("double:" + aDouble);
        System.out.println("aChar:" + aChar);
        System.out.println("aBoolean:" + aBoolean);
        System.out.println("string:" + string);
        System.out.println("date:" + date);
        System.out.println("integers:" + Arrays.toString(integers.toArray()));
        System.out.println("null:" + aNull);

    }

    public static void main(String[] args) {
        JSONParse jsonParse = new JSONParse();
        jsonParse.jsonParseTest();
    }
}
