#Spring项目中使用Tile设计页面

在网页设计时，一组网页具有相似外观和布局是很常见的情况，这时候可以通过设计和使用模板来减少重复代码，并保证修改时页面的一致性。在Spring中可以通过Tiles来设计页面布局，使模板的结构清晰，更好地进行页面分离，提高复用性。Tiles即Jakarta Tiles，它开始时是Struts的一部分，不过也可以独立使用。

使用Tiles时，在PROJECT-servlet.xml配置文件中添加：

<bean id="tilesConfiger" class="org.springframework.web.servlet.view.tiles.TilesConfigurer">
    <property name="definitions">
        <list>
            <value>/WEB-INF/PROJECT-tiles.xml</value>
        </list>
    </property>
</bean>

<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="viewClass" value="org.springframework.web.servlet.view.tiles.TilesJstlView" />
</bean>

声明使用Tiles，同时指定Tiles布局的配置文件。使用Tiles需要添加struts库。

PROJECT-tiles.xml配置文件中指定页面布局的逻辑关系，同时给出各个页面部分的jsp源文件路径。比如：

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE tiles-definitions PUBLIC "-//Apache Software Foundation//DTD Tiles Configuration 1.1//EN" "tiles-config_1_1.dtd">
<tiles-definitions>
    <definition name="base" path="/WEB-INF/jsp/base.jsp">
        <put name="title" value="PROJECT" />
        <put name="header" value="/WEB-INF/jsp/header.jsp" />
        <put name="sidebar" value="/WEB-INF/jsp/sidebar.jsp" />
        <put name="content" value="/WEB-INF/jsp/content.jsp" />
        <put name="footer" value="/WEB-INF/jsp/footer.jsp" />
    </definition>
    <definition name="register" extends="base">
        <put name="title" value="PROJECT - Register" />
        <put name="content" value="/WEB-INF/jsp/register.jsp" />
    </definition>
    <!-- ... -->
</tiles-definitions>

上面的配置中给出了base和register两个视图的定义，其中register视图扩展自base视图，它的title和content组件会覆盖base中的对应组件。

http://www.yeolar.com/note/2011/10/18/spring-tile/