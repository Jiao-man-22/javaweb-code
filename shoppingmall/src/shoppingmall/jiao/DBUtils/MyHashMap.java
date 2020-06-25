package shoppingmall.jiao.DBUtils;

import java.util.HashMap;
/**
 * ʵ��put����������ֵ
 * 
 * 
 * */
public class MyHashMap<K> extends HashMap<K, String> {
    /**
     * ʹ��HashMap��containsKey�ж�key�Ƿ��Ѿ�����
     * @param key
     * @param value
     * @return
     */
    @Override
    public String put(K key, String value) {
        String newV = value;
        if (containsKey(key)) {
            String oldV = get(key);
            newV = oldV +" " + newV;
        }
        return super.put(key, newV);
    }
}


