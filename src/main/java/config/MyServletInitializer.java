package config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 基于java的initializer的一个好处就是我们可以定义任意数量的初始化器类，
 * 因此，如果我我们想往Web容器中注册其他组件的话，只需要创建一个新的初始化器
 * 就可以了，最简单的方式就是实现Spring的WebApplicationInitializer接口
 *
 * 我们也可以通过这种方式手动注册DisaptcherServlet，但是没有必要
 * 因为AbstractAnnotation。。。Initializer 实现的很好
 */
public class MyServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //注册Filter
        FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
        //添加filter的映射路径
        filter.addMappingForUrlPatterns(null, false, "/custom/**");
    }

    /**
     * 这是注册servlet的代码
     */
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        //注册servlet
//        ServletRegistration.Dynamic myServlet=
//                servletContext.addServlet("myServlet",MyServlet.class);
//        //映射servlet
//        myServlet.addMapping("/custom/**");
//    }
}
