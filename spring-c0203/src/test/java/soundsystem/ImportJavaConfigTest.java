package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * setero-mixedConfig
 * xml和java混合配置applicationContext beans
 * 在xml中导入java配置
 * classpath与classpath*区别：
 * classpath只加载类路径下第一个找到的资源文件；
 * classpath*会加载类路径下找到的所有配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cdplayer-config.xml")
public class ImportJavaConfigTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;


    @Test
    public void play() {
        player.play();
        assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\r\n",
                log.getLog());
    }

}
