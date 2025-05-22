# 使用支持 ARM64 的 OpenJDK 镜像
FROM eclipse-temurin:17-jdk

# 拷贝jar包到容器中
ADD ./oj-gateway.jar ./oj-gateway.jar

# 运行jar包
CMD ["java", "-jar", "oj-gateway.jar"]