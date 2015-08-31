#spring-c0101

##points

###java配置bean
1.@Configuration注解java配置文件；
2.@Bean注解构造方法，注入bean对象；
3.@ContextConfiguration(classes = KnightConfig.class, loader = AnnotationConfigContextLoader.class)
引入context配置。


###xml配置bean
1.在xml文件中配置bean id、class及引用参数；
2.通过ClassPathXmlApplicationContext加载context配置文件，然后通过getBean获取bean对象
3.或通过@ContextConfiguration(locations = {"classpath*:sia/knights/KnightXMLInjectionTest-context.xml"})
  或autowired自动装配bean。


###mock测试
 Quest mockQuest = mock(Quest.class);
 传入一个接口或类，使用mock测试框架生成一个对应的实例，可以用来测试相应接口。


###切面配置
    <aop:config>
        <aop:aspect ref="minstrel">
            <aop:pointcut id="embark"
                          expression="execution(* *.embarkOnQuest(..))"/>

            <aop:before pointcut-ref="embark"
                        method="singBeforeQuest"/>

            <aop:after pointcut-ref="embark"
                       method="singAfterQuest"/>
        </aop:aspect>
    </aop:config>


    切面（要增强的功能对应对象）
    切点id
    切点表达式（对什么接口进行功能增强）
    切入位置（before-在接口调用前，after-在接口调用后...等）
