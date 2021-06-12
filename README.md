# json-practice-demo
JSON 解析与生成练习 Demo

## JSON 解析
Java 的 JDK 中没有内置 JSON 的解析，所以需要借助第三方类库实现；

常见的 JSON 解析类库：
+ [FastJson](https://github.com/alibaba/fastjson)：阿里巴巴开发的 JSON 库，性能十分优秀；
+ [Jackson](https://github.com/FasterXML/jackson)：社区十分活跃且更新速度很快；
+ [Gson](https://github.com/google/gson)：谷歌开发的 JSON 库，功能十分全面；

### Jackson 解析

+ [Jackson 源码地址](https://github.com/FasterXML/jackson)
+ 简单、功能强大、基于 Java 的应用库；Java 的标准 JSON 库，最佳的 JSON 解析器；可方便地将 Java Bean 与 JSON 对象进行互相转换；社区活跃度高、更新速度快；
+ 主要特点：
  + 高性能且稳定； 
  + 流行度高、易使用；
  + 内置大多数序列化和 Java 类型的映射关系；、
  + 无需第三方依赖； 
  + Spring 家族默认的 JSON/XML 解析器；
+ Jackson 是一套 JVM 平台的数据处理工具集，主要组成：
  + JSON 解析器、JSON 生成器；
  + 数据绑定库（POJOs to and from JSON）；
  + 相关模块支持 Avro、BSON、CBOR、CSV、Smile、Properties、Protobuf、XML or YAML 等多种数据格式；
+ 两个重要分支：
  + ```1.x```：维护状态，接近淘汰；
  + ```2.x```：开发状态，持续更新；
  + 两个版本使用不同的 Java 包名和 Maven GAV，并不互相兼容，但可共存；
+ 三大核心模块：
  + ```Jackson-core```：Streaming 流处理模块；定义底层处理流的 API；
    + Streaming JSON 解析器、生成器；
    + 开销少、损耗少、性能高、灵活性高；
    + 底层 API，易错性高、可读性差；
    + 两种处理 JSON 的方式：
      + 流式 API：将读取的 JSON 内容写入作为离散事件，JsonParser 读取数据，JsonGenerator 写入数据；
      + 树模型：JSON 文件的内容在内存中以树状形式存储；较灵活；（类似 XML 中的 DOM 解析）
  + ```Jackson-annotations```：Annotations 标准注解模块，包含标准的 Jackson 注解；
  + ```Jackson-databind```：Databind 数据绑定模块，在 streaming 包上实现数据绑定支持；
+ Jackson 隶属于 ** FasterXML** 这个组织；
  + [FasterXML 官网](http://fasterxml.com/)
  + 该组织主要有：
    + Woodstox 流的 XML 解析器；
    + Jackson 流的 JSON 解析器；
    + Aalto 非阻塞 XML 解析器；
    + 等等；
+ 参考文章：
  + [初识Jackson](https://www.yourbatman.cn/tags/Jackson)

+ 相关 API
  + 基础：
    + [JsonGenerator Demo](./jackson/src/main/java/org/example/jackson/JsonGeneratorDemo.java)
  + 进阶：
    + ```writeRaw()``` 与 ```writeRawValue() ```：强制生成器不做任何修改逐字复制输入文本；
    + ```writeBinary()```：使用 Base64 编码将数据写进去；
    + ```writeEmbeddedObject()```：使用 byte 数组将数据写进去；
    + ```writeObject()```：写 POJO，需给 JsonGenerator 指定一个 ObjectCode 解码器（ObjectMapper），否则抛出异常；
    + ```writeTree()```：写树模型；
```java
// Jackson 关键 API
public class Demo {

    public JsonFactory factory;
    
    public Demo(JsonFactory jsonFactory) {
        this.factory = jsonFactory;
    } 
    
    public void function() {
        JsonGenerator jsonGenerator = this.factory.createGenerator(System.out, JsonEncoding.UTF8);
        jsonGenerator.writeStartObject();
        
        // 1. Json key （可单独存在）
        // 三种方式写 JSON 的 key
        // writeFieldName(String):void
        // wirteFieldName(SerializableString):void
        // writeFieldId(long):void
        jsonGenerator.writeFiledName("name"); // 输出 {"name"} 
        
        // 2. Json value 
        // 形式十分众多：字符串、数字、对象、布尔、null（由 JsonGenerator 作适配）
        // 字符串（如{ "name":"YourBatman" }）-> writeString
        // 数字（如{ "age":18 }） -> writeNumber
        // 对象（JSON 对象）（如{ "person":{ "name":"YourBatman", "age":18}}） -> writeStartObject
        // 数组（如{"names":[ "YourBatman", "A哥" ]}） -> writeStartArray
        // 布尔（如{ "success":true }） -> writeBoolean
        // null（如：{ "name":null }） -> writeNull
        jsonGenerator.writeFiledName("name");
        jsonGenerator.writeString("tony"); // 输出 {"name":"tony"} 
        jsonGenerator.writeEndObject();
    } 
    
}
```

### FastJson 解析

+ [FastJson 源码地址](https://github.com/alibaba/fastjson)
+ [中文 Wiki](https://github.com/alibaba/fastjson/wiki/Quick-Start-CN)
+ 第三方 Java 库，可将 Java 对象转换成 JSON 格式，也可将 JSON 格式转换成 Java 对象；
+ 特性：
    + 由服务端和安卓客户端两种解析工具；
    + ```toJSONString()``` 和 ```parseObject()``` 两者间将 Java 对象和 JSON 互相转换；
        + [toJSONString Demo](./fastjson/src/main/java/org/example/fastjson/simpledemo/JSONBuilder.java)
        + [parseObject Demo](./fastjson/src/main/java/org/example/fastjson/simpledemo/JSONParse.java)
    + 允许转换预先存在的无法修改的对象；（只有 class 编译后的文件，无源代码）
    + 支持注解；[JSONField Demo](./fastjson/src/main/java/org/example/fastjson/annotation/Account.java)
    + 支持 Java 泛型；
    + 允许对象的自定义表示、自定义序列化类；
    + 支持任意复杂对象（具有深厚地继承层次和广泛使用的泛型类型）；
+ [参考文章：Fastjson 简明教程](https://www.runoob.com/w3cnote/fastjson-intro.html)
+ 总结：
    + 优点：速度快；
    + 缺点：流行度不高，主要以 Jackson 与 gson 为主；设计与代码质量不高；较多待修复的问题；