package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * 相当于dispatcherServlet.xml
 * AbstractAnnotationConfigDispatcherServletInitializer
 * 会创建 DispatcherServlet 和 ContextLoaderListener
 */

@Configuration
public class DispatcherConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //如果要注册一个Filter，并且只映射到DispatcherServlet上的话，
    //这个类提供了一个简单的实现方式
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new MyFilter()};
    }

    //设置multipart的相关配置，如果继承了abs类的话，要这么配置
    //如果是继承webApplicationInitializer，就在init方法里面设置
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/example/uploads", 2097152, 4194304, 0)
        );
    }
}
