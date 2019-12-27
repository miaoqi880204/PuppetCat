package org.catmint.config;

import org.springframework.core.io.support.SpringFactoriesLoader;
import java.util.List;

/**
 * <p>Title:利用SPI机制</p>
 * <p>Description:实现多平台注册中心集成</p>
 * <p>客户端链接catmint时调用这个方法</p>
 *
 * @author QIQI
 * @date
 */
public class RegisterConfig {

    public void initRegister() {
        List<ServiceRegistryConfig> serviceRegistries = SpringFactoriesLoader.loadFactories( ServiceRegistryConfig.class, null );
        if (null != serviceRegistries && !serviceRegistries.isEmpty()) {
            for(ServiceRegistryConfig registryConfig : serviceRegistries){
                //一旦有满足条件的实现器被加载，那么拒绝后面的实现器加载行为
                if(registryConfig.register()) break;
            }
        }
    }
}