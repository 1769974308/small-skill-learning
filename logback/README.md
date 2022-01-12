

<a name="XPSwq"></a>
## 你会学到什么？

-  了解目前主流的日志框架以及日志实现门面
- LOGBACK日志框架与日志实现门面的组合
- LOGBACK日志框架配置文件如何配置节点以及各节点的作用
- 快速将LOGBACK日志框架使用到项目上

​<br />
<a name="oViGQ"></a>
## LogBack日志框架

<br />在项目开发过程中，可以通过debug查询问题，但是项目上线后查找问题只能通过打印日志的方式查找问题。因此对于一个项目而言，选择一个合适的日志框架也是非常的重要。<br />在Java开发中，常用的日志框架有JDKLog、Log4J、Log4J2、LogBack、SLF4J.这些日志框架各有各的特点，各有各的应用场景。现在最主流的日志框架解决方案莫过于SLF4J+LogBack。<br />​<br />
<a name="q2AVN"></a>
### 选择LogBack的原因有以下几点：

- LogBack自身实现了SLF4J的日志接口，不需要SLF4J做进一步的适配。
- LogBack自身是在Log4J的基础上优化而成的。其运行速度和效率都比LOG4J高。
- SLF4J+LogBack支持占位符，方便日志代码的阅读，而LOG4J则不支持。

从上面几点来看，SLF4J+LogBacK是一个较好的选择。<br />​<br />
<a name="Iw0GD"></a>
### LogBack分为三个组件：logback-core、logback-classic和logback-access
logback-core：提供logback的核心功能，是另外二个组件的基础。<br />logback-classic：则实现了SLF4J的API，所以当配合SLF4J使用时，需要将logback-classic引入依赖中。<br />logback-access：是为了集成Servlet环境而准备的，可提供HTTP-access的日志接口。<br />​

LogBack日志记录数据流从 Class(Package) 到 Logger , 再从 Logger 到 Appender ,最后从 Appender 到具体的输出终端。<br />![](https://cdn.nlark.com/yuque/0/2022/png/1429632/1641954870503-cd03051d-8d7e-46c7-acd9-3a521d42b958.png#clientId=u15694872-cb2e-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=u610fad9e&margin=%5Bobject%20Object%5D&originHeight=826&originWidth=1302&originalType=url&ratio=1&rotation=0&showTitle=false&status=done&style=none&taskId=uc6d8f96a-4dbd-4502-8aa4-ea2dd9f4b45&title=)<br />Logback配置文件可以分为几个节点，其中Configuration是根节点，Appender、Logger、Root是Configuration的子节点。<br />​<br />
<a name="zUZJt"></a>
## 添加POM
使用logback+slf4j的组合，需要依赖的pom如下：
```java
		<dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.10</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>
```
<a name="TtKL5"></a>
## 添加logback.xml
logback查找配置的顺序如下：

- 在系统配置文件System Properties中寻找是否有logback.configurationFile对应的value
- 在classpath下寻找是否有logback.groovy（即logback支持groovy与xml两种配置方式）
- 在classpath下寻找是否有logback.xml


<br />在resources目录下添加logback.xml<br />![image.png](https://cdn.nlark.com/yuque/0/2022/png/1429632/1641956400168-a70be97f-e7b9-48d8-aee7-a38f4dd16c03.png#clientId=u358289da-8ada-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=204&id=u2178cb4e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=204&originWidth=382&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8183&status=done&style=none&taskId=u5152b704-eae2-4f5c-a6b6-b0f45e715eb&title=&width=382)
<a name="RC014"></a>
## 配置appender节点
appender是负责写日志的组件，appender有两个必要属性name，calss。name指定appender的名称，class指定appender的全限定名<br />class主要包括：<br />    		ch.qos.logback.core.ConsoleAppender 控制台输出<br />               ch.qos.logback.core.FileAppender 文件输出<br />               ch.qos.logback.core.RollingFileAppender 文件滚动输出<br />配置如下：
```java
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <property name="APP_NAME" value="logbacktest" />
    <property name="LOG_NAME" value="${user.home}/logs/${APP_NAME}/${APP_NAME}.log" />

    <appender name="APP_LOG" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!--指定日志文件名称、可以是相对目录 , 也可以是绝对目录 , 如果目录不存在则会自动创建-->
        <file>${LOG_NAME}</file>
        <!--日志进行格式化-->
        <encoder>
            <!--指定日志内容格式-->
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
            <charset>utf8</charset>
        </encoder>
        <!--设置滚动策略，当发生滚动时，决定 RollingFileAppender 的行为，涉及文件移动和重命名-->
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <!--设置日志命名模式--> 
            <fileNamePattern>${LOG_NAME}.%d{yyyy-MM-dd}.%i.log</fileNamePattern>
            <!--日志最大保存15天-->
            <maxHistory>15</maxHistory>
            <!--日志最大的文件大小-->
            <maxFileSize>100MB</maxFileSize>
            <!--日志最大保存10GB-->
            <totalSizeCap>10GB</totalSizeCap>
        </rollingPolicy>
    </appender>
</configuration>
```
​<br />
<a name="emiB7"></a>
## 配置root节点
先配置root，即：默认表示所有路径。该元素有一个level属性，没有name属性，因为已经被命令为root
```java
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <property name="APP_NAME" value="logbacktest" />
    <property name="LOG_NAME" value="${user.home}/logs/${APP_NAME}/${APP_NAME}.log" />

    <appender name="APP_LOG" class="ch.qos.logback.core.rolling.RollingFileAppender">
       ...
    </appender>


    <root level="INFO">
        <!--ref表示具体的appender name-->
        <appender-ref ref="APP_LOG" />
    </root>
</configuration>
```
此配置之后，所有的日志都会以root的level，即INFO去使用APP_LOG这个appender打印日志。<br />​<br />
<a name="N9Nqn"></a>
## 打印日志
编辑Utils.java，打印5个级别的日志：
```java
/**
 * @auther ASUS
 * @date 2022/1/12
 */
public class Utils {


    private  static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static  void utilsLogger(){
        logger.trace("LogbackApplication {} log","trace");
        logger.debug("LogbackApplication {} log","debug");
        logger.info("LogbackApplication {} log","info");
        logger.warn("LogbackApplication {} log","warn");
        logger.error("LogbackApplication {} log","error");
    }
}
```
运行项目，打印日志，效果如上<br />![image.png](https://cdn.nlark.com/yuque/0/2022/png/1429632/1641958844887-b2f54026-360b-487e-bb66-fe49b58664d5.png#clientId=u358289da-8ada-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=370&id=ue3d3777a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=370&originWidth=581&originalType=binary&ratio=1&rotation=0&showTitle=false&size=31295&status=done&style=none&taskId=uc37321e4-03d1-4e7d-94e9-b6b6c09cdc9&title=&width=581)<br />![image.png](https://cdn.nlark.com/yuque/0/2022/png/1429632/1641958908533-a38bc71f-b7ea-483b-b0fc-e342c2dc9020.png#clientId=u358289da-8ada-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=193&id=u3b6d984d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=193&originWidth=1046&originalType=binary&ratio=1&rotation=0&showTitle=false&size=37375&status=done&style=none&taskId=u6096173a-0e8c-40bb-af05-1bb5ef2986b&title=&width=1046)
<a name="m7eJA"></a>
## 配置logger节点
logger用来配置某个包或者类具体日志的打印级别，logger仅有一个name属性，两个可选属性level、addtivity。<br />name ：用来指定受此logger约束的某一个包或者具体的某一个类<br />_       level _：用来设置打印级别，大小写无关。可选值有TRACE、DEBUG、INFO、WARN、ERROR、ALL和OFF。还有一个特俗值INHERITED 或者 同义词NULL，代表强制执行上级的级别。如果未设置此属性，那么当前logger将会继承上级的级别<br />addtivity ：是否向上级logger传递打印信息，默认为true<br />​

下面把utils.java配置拆出去，添置如下配置信息<br />![image.png](https://cdn.nlark.com/yuque/0/2022/png/1429632/1641959430213-5bde4d71-567b-4478-9c43-8b17f624bfb6.png#clientId=u358289da-8ada-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=882&id=ua85ed81f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=882&originWidth=1056&originalType=binary&ratio=1&rotation=0&showTitle=false&size=91674&status=done&style=none&taskId=ubce6c829-6d82-4f16-b142-2e6bb816c00&title=&width=1056)<br />配置完成后，重新启动项目，查询日志打印文件夹效果如下：<br />![image.png](https://cdn.nlark.com/yuque/0/2022/png/1429632/1641959656440-669ac813-9c5d-4d1f-95f4-4b713594cd39.png#clientId=u358289da-8ada-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=190&id=u0183b398&margin=%5Bobject%20Object%5D&name=image.png&originHeight=190&originWidth=919&originalType=binary&ratio=1&rotation=0&showTitle=false&size=23281&status=done&style=none&taskId=u51fc8875-63c0-4147-b6b8-e65acc5736a&title=&width=919)
<a name="mZNas"></a>
## 配置filter过滤节点
<a name="NKbN0"></a>
###     级别过滤器（LevelFilter）
levelfilter根据记录级别对记录事件进行过滤，如果事件的级别等于配置的级别，过滤器会根据 onMatch 和 onMismatch属性接受或者拒绝事件。<br />配置文件如下：
```java
	<appender name ="CONSOLE_LOG" class="ch.qos.logback.core.ConsoleAppender">
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <!-- 过滤掉非INFO级别 -->
            <level>INFO</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <encoder>
            <pattern>%-4relative [%thread] %-5level %logger{30} - %msg%n</pattern>
        </encoder>
    </appender>
   
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1429632/1641969262404-63073bff-3df3-463b-b8a8-89c019e97160.png#clientId=u358289da-8ada-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=285&id=ue73dd791&margin=%5Bobject%20Object%5D&name=image.png&originHeight=285&originWidth=1821&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56474&status=done&style=none&taskId=ua90c8fbb-a56e-4c31-8b33-3c8a91473f9&title=&width=1821)<br />

<a name="GujMc"></a>
### 临界值过滤器（ThresholdFilter）
ThresholdFilter过滤掉低于指定临界值的事件
```java
<appender name ="CONSOLE_LOG" class="ch.qos.logback.core.ConsoleAppender">
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <!-- 过滤掉TRACE和DEBUG级别的日志 -->
            <level>INFO</level>
        </filter>
        <encoder>
            <pattern>%-4relative [%thread] %-5level %logger{30} - %msg%n</pattern>
        </encoder>
    </appender>
```
<a name="NUUzb"></a>
### 求值过滤器（EvaluatorFilter）
评估是否符合指定的条件
```java
<appender name ="console_out" class="ch.qos.logback.core.ConsoleAppender">
        <filter class="ch.qos.logback.classic.filter.EvaluatorFilter">  
             <evaluator>
             <!--过滤掉所有日志中不包含hello字符的日志-->
                <expression>
                    message.contains("hello")
                </expression>
                <onMatch>NEUTRAL</onMatch>
                <onMismatch>DENY</onMismatch>
             </evaluator>
        </filter>
        
        <encoder>
            <pattern>%-4relative [%thread] %-5level %logger{30} - %msg%n</pattern>
        </encoder>
    </appender>
```
<a name="T6fHo"></a>
### 匹配器（Matchers）
```java
<appender name ="console_out" class="ch.qos.logback.core.ConsoleAppender">
        <filter class="ch.qos.logback.classic.filter.EvaluatorFilter">  
             <evaluator> 
                <matcher>
                    <Name>odd</Name>
                    <!-- 过滤掉序号为奇数的语句-->
                    <regex>statement [13579]</regex>
                </matcher>
                <expression>odd.matches(formattedMessage)</expression>
                <onMatch>NEUTRAL</onMatch>
                <onMismatch>DENY</onMismatch>
             </evaluator>
        </filter>
        
        <encoder>
            <pattern>%-4relative [%thread] %-5level %logger{30} - %msg%n</pattern>
        </encoder>
    </appender>
    
```
<a name="bekbI"></a>
## 总结
<a name="V3Rjn"></a>
### 日志技术框架

- JUL：JDK中的日志记录工具，也常称为JDKLog、JDK-Logging
- LOG4J ：一个具体的日志实现框架
- LOG4J2 ：一个具体的日志实现框架，是LOG4J升级版本
- LOGBACK：一个具体的日志实现框架，其性能更好
- JCL：一个日志门面，提供统一的日志记录接口，也常称为commons-logging
- SLF4J：一个日志门面，与JCL一样提供统一的日志记录接口，可以方便地切换具体的实现框架


<br />JUL、LOG4J1、LOG4J2、LOGBACK是**日志实现框架**，而JCL、SLF4J是**日志实现门面**。<br />​<br />
<a name="t3K5Q"></a>
## 项目源码
[Github](https://github.com/1769974308/small-skill-learning/tree/master/logback) : [https://github.com/1769974308/small-skill-learning/tree/master/logback](https://github.com/1769974308/small-skill-learning/tree/master/logback)
