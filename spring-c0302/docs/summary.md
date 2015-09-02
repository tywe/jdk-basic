#Condition控制ApplicationContext容器注入Bean
当conditional注解指定类重写的matches方法返回true，才将对应的bean注入容器。

    @Configuration
    public class MagicConfig {
     @Bean
     @Conditional(MagicExistsCondition.class)
     public MagicBean magicBean() {
        return new MagicBean();
        }

    }