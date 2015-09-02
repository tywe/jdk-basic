#spring获取属性文件配置

##java配置方式获取
配置文件路径及属性获取：


    @Configuration
    @PropertySource("classpath:/com/soundsystem/app.properties")
    public class EnvironmentConfig {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(
                env.getProperty("disc.title"),
                env.getProperty("disc.artist"));
    }

    }

    在需要设置默认值的情况：
     @Bean
        public BlankDisc blankDisc() {
            return new BlankDisc(
                    env.getProperty("disc.title", "Rattle and Hum"),
                    env.getProperty("disc.artist", "U2"));
        }

##xml配置方式获取
配置属性文件路径：

    <context:property-placeholder
            location="com/soundsystem/app.properties"/>

获取属性文件中的属性：

    <bean class="com.soundsystem.BlankDisc"
          c:_0="${disc.title}"
          c:_1="${disc.artist}"/>