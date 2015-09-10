#spring web flow

##实现功能
spring web flow是一个web框架，它是spring mvc的扩展，它适用于元素按照规定流程运行的程序。
它将流程的定义和实现流程行为的类和视图分离开。
构建与springmvc基础之上，流程的所有请求都要首先经过spring mvc的dispatchServlet。

比如购物：从购物车开始，依次通过配送详情，账单信息以及订单确认流程。
可以使用任何web框架实现流程，但是无法将流程和实现分开，流程定义分散在组成流程的各个元素中，不能完整的描述整个流程。


##概念说明

###流程执行器（flow-excutor）
驱动流程执行，当用户进入一个流程时，流程执行器会为用户情动一个流程实例。暂停时（为用户展示视图时），流程执行器会在用户执行操作后恢复流程。

    <!-- Executes flows: the entry point into the Spring Web Flow system -->
    <flow:flow-executor id="flowExecutor"/>

流程执行器负责创建和执行流程，但是不负责加载流程定义。

###流程注册表（flow register）
加载流程定义，让流程执行器执行。

    <!-- The registry of executable flow definitions -->
    <flow:flow-registry id="flowRegistry"
                        base-path="/WEB-INF/flows">
        <flow:flow-location-pattern value="/**/*-flow.xml"/>
    </flow:flow-registry>

流程都是通过流程ID来引用。
流程ID说明：
1.隐式制定流程ID
流程注册表基本路径--流程ID--流程定义
/WEB-INF/flows/order/order-flow.xml
流程注册表基本路径：/WEB-INF/flows
流程ID:order
流程定义：order-flow.xml

        <flow:flow-registry id="flowRegistry"
                        base-path="/WEB-INF/flows">
             <flow:flow-location-pattern value="/**/*-flow.xml"/>
        </flow:flow-registry>

2.显示制定流程ID
去掉 base-path属性，显示指定flow-location,path属性直接致命文件作为流程定义。
如此配置，流程ID从流程定义文件的文件名中获得，流程ID:springpizza

        <flow:flow-registry id="flowRegistry">
            <flow:flow-location path="/WEB-INF/flows/springpizza.xml"/>
        </flow:flow-registry>

更进一步，直接显示指定流程ID：

    <flow:flow-registry id="flowRegistry">
        <flow:flow-location id="pizza"
        path="/WEB-INF/flows/springpizza.xml"/>
    </flow:flow-registry>


###流程请求
1.请求映射
DispatcherServlet一般讲请求分发给控制器，在web flow中需要FlowHandlerMapping将请求发送给spring web flow。

           <!--Maps request paths to flows in the flowRegistry-->
           <bean class="org.springframework.webflow.mvc.servlet.FlowHandlerMapping">
                <property name="flowRegistry" ref="flowRegistry"/>
           </bean>

 FlowHandlerMapping装配流程注册表的引用，它将请求的URL匹配到流程上。
 examples：
 请求为/pizza(相应于应用程序的上下文路径)的URL模式，FlowHandlerMapping装配了流程注册表引用，将会去匹配ID为pizza的流程。

 2.请求处理
 FlowHandlerMapping只负责将请求定向到spring web flow，响应请求的是FlowHandlerAdapter。
 它等同于spring mvc的控制器，负责响应发送的流程请求并对其进行处理。
 它是dispatcherServlet和spring web flow之间的桥梁，处理流程请求并管理基于这些请求的流程。

        <!--
        Dispatches requests mapped to flows to FlowHandler implementations
         -->
        <bean class="org.springframework.webflow.mvc.servlet.FlowHandlerAdapter">
            <property name="flowExecutor" ref="flowExecutor"/>
         </bean>


###流程的组件
流程是由三个主要元素定义的：状态、转移和流程数据。

状态（state）：流程中事件发生的地点，是业务逻辑执行、做出决策或将页面展示给用户的地方。
转移（transition）：从一个状态到另一个状态。
流程数据：在流程处理中，收集的一些数据：流程的当前状况。

examples：
公路旅行-->景点、城镇（状态），连接地点的公路（转移），购买的东西等（流程数据）
1.状态
五种状态：行为（action）、决策（decision）、结束（end）、子流程（subflow）、视图（view）。
不同类型的状态组合起来形成一个完整的流程。

（1）视图状态
暂停流程，为用户展现信息并邀请用户参与流程（填写数据）。
视图可以是spring支持的任意视图类型，通常使用jsp。
状态id属性作用：在流程内标示这个状态；隐式指定了到达这个状态展示的视图逻辑名。

    <!-- Customer -->
    <view-state id="welcome">
        <transition on="phoneEntered" to="lookupCustomer"/>
        <transition on="cancel" to="endState"/>
    </view-state>
    或通过view属性直接指定：
    <!-- Customer -->
       <view-state id="welcome" view="index.jsp">
           <transition on="phoneEntered" to="lookupCustomer"/>
           <transition on="cancel" to="endState"/>
    </view-state>

流程为用户展示表单时，可以指明表单所绑定的对象。

    <view-state id="registrationForm" model="order" popup="true">
        <on-entry>
            <evaluate expression=
                              "order.customer.phoneNumber = requestParameters.phoneNumber"/>
        </on-entry>
        <transition on="submit" to="checkDeliveryArea"/>
        <transition on="cancel" to="cancel"/>
    </view-state>
    evaluate expression属性指定了评估要执行的表达式
    ？？？popup做什么的？？？？

（2）行为状态
流程逻辑发生的地方，是应用程序自身在执行任务（相对于视图状态的应用程序用户动作）。
它一般会触发spring所管理bean的一些方法，并根据方法执行结果转移到另一个状态。

    <action-state id="lookupCustomer">
        <evaluate result="order.customer"
                  result-type="com.springinaction.pizza.domain.Customer"
                  expression="pizzaFlowActions.lookupCustomer(requestParameters.phoneNumber)"/>
        <transition to="registrationForm"
                    on-exception="com.springinaction.pizza.service.CustomerNotFoundException"/>
        <transition to="showOrder"/>
    </action-state>

 evaluate属性给出了行为状态要做的事情，expression属性指定了评估要执行的表达式（spel）。
 找到ID为pizzaFlowActions的bean执行lookupCustomer方法。

（3）决策状态
基于流程数据的评估结果确定流程的方向。

    <decision-state id="checkDeliveryArea">
        <if test="pizzaFlowActions.checkDeliveryArea(order.customer.zipCode)"
            then="addCustomer"
            else="deliveryWarning"/>
    </decision-state>

if元素是决策状态的核心，是表达式进行评估的地方。如果为true，流程转移到then属性指定的状态；如果为false，流程转移到else指定的状态。

（4）子流程状态
在当前正在运行的流程上下文中启动一个新的流程，类似在一个方法中调用其他方法。
每一个子流程构成一个完整的处理步骤结合，完成特定的事情，提高每个子流程的内聚和复用性。

    <subflow-state id="customer" subflow="pizza/customer">
        <input name="order" value="order"/>
        <transition on="customerReady" to="order"/>
    </subflow-state>

<input>元素作为子流程的输入，用于传递数据对象。 如果子流程结束状态为customerReady，那么本流程转移到id为order的状态。

（5）结束状态
流程的最后一站，一旦进入，流程就终止。
后续操作的决定因素：
·如果结束流程为一个子流程，end-state的id触发后续的流程继续执行。
·如果end-state设置了view属性，指定的视图将会被渲染。
    externalRedirection前缀重定向到流程外的页面；flowRedirect重定向到另一个流程。
·不是上面两种，就是流程结束。

流程可能不止一个结束状态，子流程结束状态ID确定了激活的事件。

    <end-state id="cancel"/>
    <end-state id="orderCreated"/>

2.转移
转移连接了流程中的状态，除了结束状态，每个状态至少有一个转移来决定当前状态完成时流程的去向。
转移定义是基于事件的触发来进行的。视图状态，事件通常是用户采取的动作；行为状态，事件是评估表达式得到的结果；子流程状态，事件取决于子流程结束状态的ID.
在任意事件中，可以用on属性来指定触发转移的时间。

        <transition on="addPizza" to="showOrder">
            <evaluate expression="order.addPizza(flowScope.pizza)"/>
        </transition>

        <transition on="cancel" to="showOrder"/>

        <transition to="registrationForm" on-exception=
                "com.springinaction.pizza.service.CustomerNotFoundException"/>
        <transition to="customerReady"/>

为了避免在多个状态中重复定义通用转移，可以使用<global-transitions>定义全局转移，流程中的所有状态都会默认拥有这个转移。

        <global-transitions>
           <transition on="cancel" to="endState"/>
        </global-transitions>

3.流程数据
流程从一个状态转移到另一个状态，它会带走一些数据，这些数据可能只在在下面某一个流程中使用（显示页面给用户），也可能在流程结束时使用（结账）。

（1）声明变量
流程数据保存在变量中，它可以在流程的任意地方引用。

·最简单的形式：使用<var>属性定义：

    <var name="order" class="com.springinaction.pizza.domain.Order"/>

·<evaluate>元素计算表达式赋值变量：

    <evaluate result="order.customer" expression=
                "pizzaFlowActions.lookupCustomer(requestParameters.phoneNumber)"/>

·<set>元素计算表达式赋值变量

        <set name="flowScope.pizza"
                 value="new com.springinaction.pizza.domain.Pizza()"/>

        <evaluate result="viewScope.toppingsList"
                      expression="@com.springinaction.pizza.domain.Topping@asList()"/>
        viewScope指定了变量的作用域

（2）变量作用域
流程中携带的数据会拥有不同的生命作用域和可见性，这取决与保存数据的变量本身作用域。

使用<var>元素定义变量，作用域是流程作用域；
使用<set>和<evaluate>元素定义变量，作用域可以通过那么火result属性前缀指定。


    conversion--最高流程开始时创建，在最高级的流程结束时销毁，被最高级流程和子流程共享；

    flow--当流程开始创建，在流程结束时销毁，只在创建它的流程中可见；

    request--当一个请求进入流程时创建，在流程返回时销毁；

    flash--当流程开始时创建，在流程结束时销毁，在视图渲染后也被清除；

    view--当进入视图状态是创建，当这个视图状态退出时销毁，只在视图状态内是可见的。
