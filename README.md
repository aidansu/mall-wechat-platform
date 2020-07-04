# Mall-Wechat-Platform
微商平台

## 技术选型
核心框架：Spring Boot 2

微服务框架：Spring Cloud Alibaba 

API网关：Spring Cloud Gateway

服务注册与发现：Nacos 

服务限流与熔断：Sentinel 

持久层框架：MyBatis-Plus

HTTP客户端：Feign

认证授权：JWT

测试框架：Junit

数据库：MySql 5.7.28


## 核心依赖
|依赖                   | 版本           |
|----------------------|---------------|
| Spring Boot          | 2.1.9         |
| Spring Cloud         | Greenwich.SR6 |
| Spring Cloud Alibaba | 2.1.2.RELEASE |
| MyBatis-Plus         | 3.1.2         |

## 工程结构
```
mall-wechat-platform
├── mall-auth -- 认证授权系统
├── mall-common -- 常用工具共用模块
├── mall-gateway -- 网关系统
├── mall-user -- 用户系统
```

## 环境要求
### 基础开发环境
|软件       | 版本   |
|----------|-------|
| JDK      | 1.8   |
| Maven    | 3.3+  |
| MySql    | 5.7+  |
| Nacos    | 1.2.1 |
| Sentinel | 1.7.1 |

### 开发工具
IntelliJ IDEA

### IDE插件
Lombok Plugin

MybatisX Plugin

## 环境搭建
### *  **创建数据库**
```
CREATE DATABASE `mall_wechat` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
```

### *  **默认账号密码**
```
tenantId: 000000
username: admin
password: 123456
```
