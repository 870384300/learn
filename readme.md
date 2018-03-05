所有配置文件都是从配置中心获取： <br/>
配置文件：learn-cloud-config--->cloud-config-repo-->cloud-config-dev.properties <br/>
修改后提交git后才能生效 <br/>

公用组件<br/>
learn-cloud-common  除learn-cloud-config所有的learn-cloud-* 都要依赖 <br/>
learn-shop-public-common  依赖learn-cloud-common，所有的learn-shop-admin-* 和learn-shop-core-* 都要依赖<br/>

核心服务，端口：87**： <br/>
learn-cloud-eureka  注册中心，端口：8761 <br/>
learn-cloud-zuul    路由网关，端口：8771 <br/>
learn-cloud-config  分布式配置中心，端口：8781 <br/>
learn-cloud-turbine  熔断器控制聚合，端口：8791 <br/>

公用业务服务，端口：80**： <br/>
learn-shop-public-tools 公用工具，端口： <br/>
learn-shop-public-job 自动任务，端口：8011 <br/>

后端业务服务，端口：88**： <br/>
learn-shop-admin-user  用户管理服务，端口：8801 <br/>
learn-shop-admin-system  系统管理服务，端口： <br/>

前台业务服务，端口：89**： <br/>
learn-shop-core-order   购物车服务，端口：8901 <br/>
learn-shop-core-cart   购物车服务，端口： <br/>
learn-shop-core-product   购物车服务，端口： <br/>



项目启动顺序： <br/>
<ul>
    <li> learn-cloud-config </li>
    <li> learn-cloud-eureka </li>
    <li> learn-cloud-zuul </li>
    <li> learn-cloud-turbine </li>
    <li> 启动公用业务服务 </li>
    <li> 启动业务服务 </li>
</ul>

访问：（通过路由） <br/>
注册中心： <br/>
http://localhost:8761/eureka <br/>

业务服务： <br/>
http://localhost:8771/core-order #订单相关 <br/>
http://localhost:8771/admin-user #用户相关 <br/>

熔断器： <br/>
访问：http://localhost:<port>/hystrix <br>
输入：http://localhost:<port>/hystrix.stream <br>

熔断器聚合： <br/>
访问：http://http://localhost:8791/hystrix <br>
输入：http://localhost:<port>/hystrix.stream <br>

RabbitMQ: 管理页面 <br>
http://localhost:15672 <br>

Druid: 管理页面 <br>
http://localhost:<port>/druid <br>

Swagger2: 管理页面 <br>
http://localhost:<port>/swagger-ui.html <br>
或者进入注册中心点击实例链接直接查看<br/>

注意： <br/>
1.添加新服务时，要在learn-cloud-zuul中添加路由表 <br/>
&nbsp;core-order: <br/>
&nbsp;&nbsp;&nbsp;&nbsp;path: /core-order/** <br/>
&nbsp;&nbsp;&nbsp;&nbsp;serviceId: learn-shop-core-order <br/>

2.使用配置中心时， <br/>
配置中心启动时会向注册中心注册，这里注册中心还没启动会报异常，不用关心 <br/>
如果是learn-cloud-* pom中添加learn-cloud-common依赖<br/>
如果是learn-shop-admin-* 和learn-shop-core-* pom中添加learn-shop-public-common依赖 <br/>

3.项目需要启动RabbitMQ, rabbitmq-server.bat <br/>
    添加新用户：admin 密码：admin123，修改admin用为超级管理员 <br/>
    查询所有用户：rabbitmqctl.bat list_users  <br/>
    添加新用户: rabbitmqctl.bat add_user  username password  <br/>
    赋予用户权限：rabbitmqctl.bat set_user_tags username administrator <br/>
    在admin中设定虚拟主机（virtual-host）为/learn-default <br/>

4.swagger2注解使用说明： <br/>
https://www.jianshu.com/p/12f4394462d5 <br/>