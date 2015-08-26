package profiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertNull;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:datasource-config.xml")
@ActiveProfiles("prod")
public class ProductionDataSourceTest_XMLConfig {
    @Autowired(required = false)
    private DataSource dataSource;

    @Test
    public void shouldBeEmbeddedDatasource() {
        // should be null, because there isn't a datasource configured in JNDI
        assertNull(dataSource);
    }
}
