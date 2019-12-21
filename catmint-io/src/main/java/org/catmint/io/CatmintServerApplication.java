package org.catmint.io;

import org.catmint.io.server.CatmintServerStartupListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author Shuo Xiang
 */
@SpringBootApplication
public class CatmintServerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CatmintServerApplication.class);
        application.addListeners(new CatmintServerStartupListener());
        application.run(args);
    }
}
