package sia.knights;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = KnightConfig.class, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class KnightJavaConfigInjectionTest {

    @Autowired
    Knight knight;

    @Autowired
//  @Qualifier(value = "fakePrintStream")
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
                "Embarking on quest to slay the dragon!\n",
                printStream.getPrintedString());
    }

}
