package 设计模式.大话设计模式.flyweight;

import java.util.HashMap;

/**
 * 享元工厂
 * 
 * @author liu yuning
 *
 */
//享元工厂
public class FlyWeightFactory {
    private HashMap<String, FlyWeight> flyWeights = new HashMap<String, FlyWeight>();
    public FlyWeight getFlyWeight(String key) {
		if (!flyWeights.containsKey(key)) {
			flyWeights.put(key, new ConcreteFlyWeight());
		}
		return flyWeights.get(key);
    }
}
