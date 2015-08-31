#bean自动扫描

##java配置自动扫描bean

@Configuration
@ComponentScan
public class CDPlayerConfig {
}


##xml配置自动扫描bean

 <context:component-scan base-package="soundsystem"/>

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }

}

非抽象类标注@Component注解，接口和抽象类不需要？？待确定？？

##问题
spring自动装配bean时，先按类型type扫描类型相同的bean注入。如果相同类型的bean有多个，再按名字name扫描注入。

   @Autowired(required = false)
   @Qualifier("CDPlayer")
    private MediaPlayer player;