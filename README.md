## MyBatis 入门 ##

MyBatis 是支持普通 SQL 查询，存储过程和高级映射的优秀持久层框架。MyBatis 消除了几乎所有的JDBC代码和参数的手工设置以及结果集的检索。

MyBatis 使用简单的 XML 或注解用于配置和原始映射，将接口和 Java 的POJOs（Plain Old Java Objects，普通的 Java对象）映射成数据库中的记录。

每个 MyBatis 应用程序主要都是使用 SqlSessionFactory 实例的，一个 SqlSessionFactory 实例可以通过 SqlSessionFactoryBuilder 获得。

SqlSessionFactoryBuilder 可以从一个 xml 配置文件或者一个预定义的配置类的实例获得。
