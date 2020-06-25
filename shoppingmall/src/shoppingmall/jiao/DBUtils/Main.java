package shoppingmall.jiao.DBUtils;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		PrettyGirl prettyGirl = new PrettyGirl();

	    Map<PrettyGirl,String> map = new HashMap<>();

	    map.put(prettyGirl, "Java编程技术乐园");

	    map.put(prettyGirl, "生活在长沙的延安人");

	    map.put(prettyGirl, "期待和你加入乐园");

	    System.out.println("map :" + map.toString());

	    MyHashMap<PrettyGirl> myMap = new MyHashMap<PrettyGirl>();

	    myMap.put(prettyGirl, "西瓜");

	    myMap.put(prettyGirl, "桃子");

	    myMap.put(prettyGirl, "屁");
	    
	    myMap.put(prettyGirl,"sb");

	    System.out.println("myMap :" + myMap.toString());
	}

	}


