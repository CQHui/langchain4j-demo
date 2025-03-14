# Langchain4j Demo

This readme file was generated By Qwen.

## 项目描述
Langchain4j Demo 是一个基于 Langchain4j 框架的示例项目，展示了如何使用 Langchain4j 构建一个简单的聊天机器人。该项目集成了 Qwen 模型和 AllMiniLmL6V2 嵌入模型，用于处理聊天和文档嵌入。

## 技术栈
- **Java**: 编程语言
- **Spring Boot**: 应用框架
- **Langchain4j**: 用于构建聊天机器人和文档嵌入
- **Qwen**: 大规模语言模型
- **AllMiniLmL6V2**: 嵌入模型

## 安装和运行

### 前提条件
- Java 11 或更高版本
- Maven

### 构建项目
```
bash mvn clean install
```

### 运行项目
```
bash mvn spring-boot:run
```

## 配置
在 `src/main/resources/application.properties` 文件中配置必要的属性，例如 API 密钥：
```
properties dashscope.api-key=your_api_key_here
```

## 使用示例
启动项目后，你可以通过以下方式与聊天机器人交互：
- 访问 `http://localhost:8080/chat` 页面进行聊天
- 使用 API 进行交互

### 示例 API 请求
```
bash curl -X POST http://localhost:8080/chat -H "Content-Type: application/json" -d '{"message": "你好"}'
```

## 许可证
该项目采用 [MIT 许可证](LICENSE)。
