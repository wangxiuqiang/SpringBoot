package com.test.demo.MyAdapter;

//import com.test.demo.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 自定义的mvc配置类, 可以配置静态资源 (外部,内部文件夹) ,可配置页面跳转,
 * 可配置拦截器
 */
@Configuration
//继承了WebMvcConfigurerAdapter 就不需要下面的注解了
//@EnableWebMvc
public class MyWebMvnConfigureAdapter extends WebMvcConfigurerAdapter {


    /**
     * 静态资源的访问,如果是外部文件的话,要 用 file: 开头
     * 内部的话用 classpath: (如果放在resources里面的话 )
     */
    /**
     * 访问静态资源
     * 项目内部的文件夹, 前面是路径, 后面的location是文件夹位置
     */
    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry ) {
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
        super.addResourceHandlers(registry);
    }

    /**
     * 在 项目外的目录下,,  .要加 file:
     * @param registry
     */
//    @Override
//    public void addResourceHandlers (ResourceHandlerRegistry registry ) {
//        registry.addResourceHandler( "/my/**").addResourceLocations("file:/home/wxq/");
//        super.addResourceHandlers(registry);
//    }

    /**
     * 这个跳转会到jsp中去,
     * 我们自己的配置和Spring Boot的自动配置同时有效，
     * 这也是我们推荐添加自己的MVC配置的方式
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry ) {
        registry.addViewController("/toLogin").setViewName( "testPageTransitions");
        super.addViewControllers( registry );
    }

    /**
     *  addPathPatterns 用于添加拦截规则
     *  excludePathPatterns 用户排除拦截
     *  addPathPatterns("/**")对所有请求都拦截，
     *  但是排除了/toLogin和/login请求的拦截。
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry ) {
//        registry.addInterceptor( new MyInterceptor() )
//                .addPathPatterns("/**")
//                .excludePathPatterns("/toLogin","/login");
//        super.addInterceptors( registry );
//    }
}
