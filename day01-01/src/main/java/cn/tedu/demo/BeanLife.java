package cn.tedu.demo;

public class BeanLife {
	//实例化对象调用无参的构造方法
	public BeanLife(){
		System.out.println("BeanLife");
	}
	//自定义初始化方法
	public void init(){
		System.out.println("init");
	}
	//自定义销毁的方法
	public void destroy(){
		System.out.println("destroy");
	}

}








