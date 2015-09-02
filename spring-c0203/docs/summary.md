#java和xml混合配置

##在java配置中引入xml配置

@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:cd-config.xml")
public class SoundSystemConfig {

}


##在xml配置中引入java配置

<bean class="soundsystem.CDConfig"/>