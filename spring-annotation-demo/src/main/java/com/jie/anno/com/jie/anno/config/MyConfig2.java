package com.jie.anno.com.jie.anno.config;

import com.jie.anno.com.jie.anno.entity.Color;
import com.jie.anno.com.jie.anno.entity.ColorFactoryBean;
import com.jie.anno.com.jie.anno.entity.Person;
import com.jie.anno.com.jie.anno.entity.Red;
import com.jie.anno.condition.LinuxCondition;
import com.jie.anno.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @version 1.0
 * @author: Jie Zhang
 * @date: 2020/5/17 14:40
 */
//@Conditional(WindowsCondition.class)
@Import({Red.class, MyImportSelector.class})
@Configuration
public class MyConfig2 {

    @Bean()
    public Person person() {
        return new Person("张三", 20);
    }

    @Scope("prototype")
    @Bean("lisi")
    public Person person4() {
        System.out.println("new Person lisi.....");
        return new Person("李四", 30);
    }

    @Lazy
    @Bean("wangwu")
    public Person person5() {
        System.out.println("new Person wang_5.....");
        return new Person("王五", 50);
    }

    @Conditional(WindowsCondition.class)
    @Bean
    public Person personWin() {
        return new Person("bill", 60);
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public Person personLinux() {
        return new Person("linux", 50);
    }

    /**
     * 给容器中注册组件：
     * 1. 包扫描+组件标注注解(@Controller @Service @Repository @Component)
     * 2. @Bean
     * 3. @Import 快速给容器中导入一个组件
     * 	    a. @Import(要导入到容器中的组件), 容器就会自动注册这个组件，id默认是全类名
     * 	    b. ImportSelector 返回需要导入的组件的全类名数组（springboot 用的比较多）
     * 	    c. ImportBeanDefinitionRegistrar 手动注册bean到容器中
     * 4. 使用Spring提供的 FactoryBean (工厂bean)
     * 	    a. 默认获取的是工厂bean 调用 getObject创建的对象
     * 	    b. 要获取去工厂Bean 本身，需要给id前面加一个 &
     */
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
