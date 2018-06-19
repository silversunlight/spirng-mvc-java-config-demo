package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 相当于applicationContext.xml
 * 一般用来加载配置什么的
 */
@Configuration
@ComponentScan
public class RootConfig {
}
