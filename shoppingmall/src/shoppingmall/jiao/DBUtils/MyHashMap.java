package shoppingmall.jiao.DBUtils;

import java.util.HashMap;
/**
 * 实现put方法插入多个值
 * 
 * 
 * */
public class MyHashMap<K> extends HashMap<K, String> {
    /**
     * 使用HashMap中containsKey判断key是否已经存在
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


