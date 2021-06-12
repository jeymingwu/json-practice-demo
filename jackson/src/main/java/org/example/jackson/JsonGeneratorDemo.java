package org.example.jackson;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.util.Date;

/**
 * @author : jeymingwu
 * @date : 2021-06-12
 **/

public class JsonGeneratorDemo {

    public static void builder() throws IOException {

        JsonFactory jsonFactory = new JsonFactory();

        JsonGenerator generator = jsonFactory.createGenerator(System.out, JsonEncoding.UTF8);

        try {
            generator.writeStartObject();
            // 字符串
            generator.writeStringField("name", "tony");

            // 数字
            generator.writeNumberField("age", 18);

            // 对象
            generator.writeFieldName("address");
            generator.writeStartObject();
            generator.writeStringField("province", "广东省");
            generator.writeStringField("city", "深圳市");
            generator.writeStringField("detail-address", "南山区粤海街道一号");
            generator.writeStringField("postcode", "518000");
            generator.writeEndObject();

            // 数组 （需先写 key，内容可以是不同数据类型，但原则上需确保同一数据类型）
            generator.writeFieldName("hobby");
            generator.writeStartArray();
            generator.writeString("singing");
            generator.writeString("drawing");
            generator.writeString("eating");
            generator.writeEndArray();

            int[] restDate = {2, 3, 7, 10, 11, 23};
            generator.writeFieldName("rest-date");
            generator.writeArray(restDate, 0, restDate.length);

            // 布尔
            generator.writeFieldName("success");
            generator.writeBoolean(true);

            generator.writeBooleanField("failure", false);

            // null
            generator.writeFieldName("tel");
            generator.writeNull();

            generator.writeNullField("phone");

            generator.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            generator.close();
        }
    }

    public static void main(String[] args) throws IOException {
        JsonGeneratorDemo.builder();
    }

}
