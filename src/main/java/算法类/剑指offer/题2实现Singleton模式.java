package 算法类.剑指offer;

/**
 * Created by ryder on 2017/6/7.
 * 单例模式
 * 定义：指实现了特殊模式的类，该类仅能被实例化一次，产生唯一的一个对象
 * 应用举例：windows的任务管理器，回收站，web应用的配置对象，spring中的bean默认也是单例
 * 分类：饿汉式，懒汉式，双检锁，静态内部类，枚举
 * 评价指标有：单例（必须），线程安全，延迟加载，防止反序列化产生新对象，防止反射攻击
 * 实现方法的选择：一般情况下直接使用饿汉式就好了，要求延迟加载时倾向于用静态内部类，涉及到反序列化创建对象或反射问题最好选择枚举
 */

public class 题2实现Singleton模式 {
	
	//版本一：饿汉式
	//特点：线程安全；在类初始化执行到静态属性时就分配了资源，有资源浪费问题；
	static class Singleton1{	
		//或者将私有静态final成员设为公有成员，可省去getInstance公有函数
		private static final Singleton1 instance = new Singleton1();
		private Singleton1(){}
		public static Singleton1 getInstance() {
			return instance;
		}
	}

	//版本二：懒汉式(非线程安全)
	//特点：在第一次调用获取实例方法时分配内存，实现了懒加载；非线程安全；
	static class Singleton2{	
		private static Singleton2 instance = null;
		private Singleton2(){}
		public static Singleton2 getInstance() {
			if (instance==null) {
				instance = new Singleton2();
			}
			return instance;
		}
	}
	
	//版本三：懒汉式变种（synchronized同步方法，支持多线程）
	//特点：线程安全；synchronized而造成的阻塞致使效率低，而且很多的阻塞都是没必要的。
	static class Singleton3{	
		private static Singleton3 instance = null;
		private Singleton3(){}
		//把synchronized加在getinstance上会导致很多不必要的阻塞，比如实例已经不为null
		public static synchronized Singleton3 getInstance() {
			if (instance == null ) {
				instance = new Singleton3();
			}	
			return instance;
		}
	}
	
	//版本四：双检锁DCL，支持多线程-懒汉式
	//特点：线程安全；多进行一次if判断，看似不会有问题了，但是无法解决生成汇编代码时指令重排的问题
	static class Singleton4{	
		private static Singleton4 instance = null;
		private Singleton4(){}
		public static Singleton4 getInstance() {
			//双重null检验：使得原先检测到null而阻塞的B线程在A线程成功返回instance后能够发现其已经返回instance
			if (instance == null ) {
				synchronized (Singleton4.class){
					if (instance == null )
					instance = new Singleton4();//这一步非原子性操作，多线程下可能会出错
				}
			}
			return instance;
		}
	}
	
	//版本五：双检锁DCL，支持多线程-懒汉式
	//特点：线程安全；多进行一次if判断，加入volatile修饰,优点是只有在第一次实例化时加锁，之后不会加锁，提升了效率，缺点写法复杂
	//指令重排：编译器在生成汇编代码的时候会对流程顺序进行优化
	//instance = new Singleton5()可主要分为三步：
		//1在堆空间里分配内存								memory = allocate(); 
		//2调用构造函数进行初始化 								init(memory);  
		//3把instance指向被分配的内存（此时instance不为null了）	instance = memory;    
	//正常顺序为123，指令重排可能执行顺序为132，会造成已不为null但未执行构造函数的问题
	//内存可见性：
	//如果字段是被volatile修饰的，Java内存模型将在写操作后插入一个写屏障指令，在读操作前插入一个读屏障指令。
	//这意味着：
		//1一旦完成写入，任何访问这个字段的线程将会得到最新的；
		//2在写入前，任何更新过的数据值是可见的，因为内存屏障会把之前的写入值都刷新到缓存。
	//因此volatile可提供一定的线程安全，但不适用于写操作依赖于当前值的情况，如自增，自减
	//简单来说，volatile适合这种场景：一个变量被多个线程共享，线程直接给这个变量赋值。
	static class Singleton5{	
		private static volatile Singleton5 instance = null; //这里的instance在主内存
		private Singleton5(){}
		public static Singleton5 getInstance() {
			//双重null检验：使得原先检测到null而阻塞的B线程在A线程成功返回instance后能够发现其已经返回instance
			if (instance == null ) {//读取一次主内存
				synchronized (Singleton5.class){
					if (instance == null )//再次读取主内存
					instance = new Singleton5();
				}
			}	
			return instance;//写入主内存
		}
	}
	
	//版本六：双检锁DCL，支持多线程-懒汉式,volatile，并且加入优化
	//因为volatile操作的是主内存的数据，主内存速度比工作内存的慢，所以可以设置一个局部实例在工作内存，以此减少与主内存的交互次数
	static class Singleton6{
		private static volatile Singleton6 instance = null;//这里的instance在主内存
		private Singleton6(){}
		public static Singleton6 getInstance() {
			Singleton6 result = instance;//读取一次主内存，后序没有读取主内存的操作了
			if (result == null ) {
				synchronized (Singleton6.class){
					if ( result == null )
					instance = result = new Singleton6();
				}
			}	
			return instance;//写回主内存
		}
	}
	
	
	
	//版本七：静态内部类，支持多线程-懒汉
	//特点：利用静态内部类（只有在出现它的引用时才被加载），完成懒加载；final保证线程安全，防止资源的浪费;
	//类的加载顺序：http://blog.csdn.net/u012123160/article/details/53224469
	//final的作用:
	//1. 在构造函数内对一个final域的写入，与随后把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不能重排序。
	//2. 初次读一个包含final域的对象的引用，与随后读这个final域，这两个操作之间不能重排序。
	//扩展：static变量初始化遵循以下规则:
	//1.静态变量会按照声明的顺序先依次声明并设置为该类型的默认值，但不赋值为初始化的值。
	//2.声明完毕后,再按声明的顺序依次设置为初始化的值，如果没有初始化的值就跳过。
	//static变量初始化参考：http://www.jb51.net/article/86629.htm
	static class Singleton7{
		
		private static class Singleton7Holder{
			public static final Singleton7 instance = new Singleton7();
		}
		
		private Singleton7(){}
		
		public static Singleton7 getInstance() {
			return Singleton7Holder.instance;
		}
		
	}
	
	//版本八：通过枚举实现
	//一个完美的单例需要做到：单例，懒加载，线程安全，防止反序列化产生新对象，防止反射攻击
	//而枚举的特性保证了以上除了懒加载以外的所有要求，而且实现代码极其简单
	//Enum的单例模式参考：http://www.jianshu.com/p/83f7958b0944
	/*
	 * 枚举类型特点：
		枚举类就是class，而且是一个不可以被继承的final类。其枚举值(INSTANCE)都是Singleton类型的类静态常量
		默认私有的构造方法，即使不写访问权限也是private。（假构造器，底层没有无参数的构造器）
		所有枚举常量都通过静态代码块来进行初始化，即在类加载期间就初始化
		大部分方法也都是final的，特别是clone、readObject、writeObject这三个方法，这三个方法和枚举通过静态代码块来进行初始化一起，它保证了枚举类型的不可变性，不能通过克隆，不能通过序列化和反序列化来复制枚举，这能保证一个枚举常量只是一个实例，即是单例的
	 */
	enum Singleton8{
	    instance;
	    //以下代码只是给一个属性验证此枚举确实为单例模式
	    private String attribute;
	    void setAttribute(String attribute){
	        this.attribute = attribute;
	    }
	    String getAttribute(){
	        return this.attribute;
	    }
	}
	
	
	
	public static void main(String[] args){
        //调用方式
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton4 singleton4 = Singleton4.getInstance();
        Singleton5 singleton5 = Singleton5.getInstance();
        Singleton6 singleton6 = Singleton6.getInstance();
        Singleton7 singleton7 = Singleton7.getInstance();
        Singleton8 singleton81 = Singleton8.instance;
        Singleton8 singleton82 = Singleton8.instance;
        singleton81.setAttribute("aaa");
        System.out.println(singleton82.getAttribute());
    }

}
