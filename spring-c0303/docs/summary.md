#bean scope设置
默认是singleton作用域

##prototype原型作用域
bean在applicationContext容器中不唯一，每次容器中取bean都是新建一个。
1.java配置


    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Notepad notepad() {
        return new Notepad();
    }

    @Bean
    public UniqueThing unique() {
        return new UniqueThing();
    }

    或

    @Component
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public class Notepad {
        // the details of this class are inconsequential to this example
    }

    然后在java配置是只是配置ComponentScan组件自动扫描

    @Configuration
    @ComponentScan(excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
    public class ComponentScannedConfig {

    }


2.xml配置


    <bean class="com.myapp.Notepad"
          scope="prototype"/>

    <bean class="com.myapp.UniqueThing"/>

##singleton单例作用域
    bean在applicationContext容器中唯一，每次容器中取bean都是同一个。
    默认是singleton作用域。