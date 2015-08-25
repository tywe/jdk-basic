package sia.knights;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:sia/knights/KnightXMLInjectionTest-context.xml"})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class KnightXMLInjectionTest {

    @Autowired
    Knight knight;

    @Autowired
    FakePrintStream printStream;

    @After
    public void clearPrintStream() {
        printStream.clear();
    }

    @Test
    public void shouldInjectKnightWithSlayDragonQuest() {
        knight.embarkOnQuest();
        String message = printStream.getPrintedString();
        System.out.println("message:" + message);
        assertEquals(
                "Fa la la, the knight is so brave!\n" +
                        "Embarking on quest to slay the dragon!\n" +
                        "Tee hee hee, the brave knight did embark on a quest!\n",
                printStream.getPrintedString());
    }

}
