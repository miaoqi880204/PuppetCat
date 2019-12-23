package org.catmint.config.init;

import org.catmint.CatmintServerTestApplication;
import org.catmint.config.model.CatmintConnectConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Title:</p>
 * <p>Description:</p>
 *
 * @author QIQI
 * @date
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CatmintServerTestApplication.class})
public class InitConfigTest {
    private CatmintConnectConfig catmintConnectConfig;

    @Before
    public void before(){
        catmintConnectConfig = new CatmintConnectConfig( "admin","123",false,3306,"127.9.9.9",false,"127.0.0.1","999.99.99.99",8799 );
    }
}
