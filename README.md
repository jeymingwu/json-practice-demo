# json-practice-demo
JSON 解析与生成练习 Demo

## JSON 解析
Java 的 JDK 中没有内置 JSON 的解析，所以需要借助第三方类库实现；

常见的 JSON 解析类库：
+ [FastJson](https://github.com/alibaba/fastjson)：阿里巴巴开发的 JSON 库，性能十分优秀；
+ [Jackson](https://github.com/FasterXML/jackson)：社区十分活跃且更新速度很快；
+ [Gson](https://github.com/google/gson)：谷歌开发的 JSON 库，功能十分全面；

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