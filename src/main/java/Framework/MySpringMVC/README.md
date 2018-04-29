# 手写SpringMVC介绍

## 流程：

### 配置阶段

1. web.xml
2. DispatcherServlet
3. 配置初始化参数：application.properties
4. /*.json

### 初始化阶段
1. init方法
2. 加载application.xml内容
3. 扫描相关联的class
4. IOC容器的初始化
5. 依赖注入DI
6. 初始化一个HandlerMapping


### 运行阶段
1. service方法
2. 调用一个doDispatch方法
3. 通过反射机制，动态调用
4. 通过Response输出