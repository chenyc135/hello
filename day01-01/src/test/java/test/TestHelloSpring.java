package test;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserDao;
import cn.tedu.demo.BeanLife;
import cn.tedu.demo.HelloSpring;

public class TestHelloSpring {
	//从容器中获取bean对象
	@Test
	public void testGetBean(){
		//1.初始化容器对象（获取 容器对象）
		//AbstractApplicationContext类中
		//定义了close方法，关闭容器。
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"application.xml");
		
		//2.获取bean对象
		HelloSpring hs =
		ac.getBean("hello",HelloSpring.class);
		
		//3.调用方法
		hs.sayHello();
		
		//4.关闭容器
		ac.close();
	}
	@Test
	public void testGetUserDao(){
		//1获取容器对象
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"application.xml");
		
		//2获取bean
		UserDao userDao = 
				ac.getBean("userDao",UserDao.class);
		
		//3调用方法
		userDao.login();
		
		//4关闭
		ac.close();
	}
	//静态方法初始化bean对象
	@Test
	public void testGetByStaticBean(){
		//1获取Spring容器
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
				"application.xml");
		//2获取bean对象
		Calendar c = ac.getBean("cl",Calendar.class);
		
		//3输出年月日
		System.out.println(c.get(Calendar.YEAR)
				      +","+(c.get(Calendar.MONTH)+1)
				      +","+c.get(Calendar.DATE));
		//4关闭容器对象
		ac.close();
	}
	@Test
	public void testBeanByInstance(){
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
				"application.xml");
		Calendar cl = ac.getBean("calendar",
				Calendar.class);
		System.out.println(cl.get(Calendar.YEAR));
		
		ac.close();
	}
	//测试bean的生命周期
	@Test
	public void testBeanLife(){
		AbstractApplicationContext ac=
				new ClassPathXmlApplicationContext(
				"application.xml");
		BeanLife beanLife = 
			ac.getBean("beanLife",BeanLife.class);
		ac.close();
	}
}














