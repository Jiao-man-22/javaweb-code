package shoppingmall.jiao.DBUtils;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		PrettyGirl prettyGirl = new PrettyGirl();

	    Map<PrettyGirl,String> map = new HashMap<>();

	    map.put(prettyGirl, "Java��̼�����԰");

	    map.put(prettyGirl, "�����ڳ�ɳ���Ӱ���");

	    map.put(prettyGirl, "�ڴ����������԰");

	    System.out.println("map :" + map.toString());

	    MyHashMap<PrettyGirl> myMap = new MyHashMap<PrettyGirl>();

	    myMap.put(prettyGirl, "����");

	    myMap.put(prettyGirl, "����");

	    myMap.put(prettyGirl, "ƨ");
	    
	    myMap.put(prettyGirl,"sb");

	    System.out.println("myMap :" + myMap.toString());
	}

	}


