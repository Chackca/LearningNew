package Test.代理.jdk动态代理;

public class AimImpl implements AimInterface {

	@Override
	public void aimMethod() {
		System.out.println("目标方法实现");
	}
}
