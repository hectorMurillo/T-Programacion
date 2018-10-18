import java.util.HashMap;

public class Par<K,V> {
    HashMap<K,V> hashMap = new HashMap<>();

    public V put(K key, V value){
        return hashMap.put(key,value);
    }
    public V get(Object key) {
        return hashMap.get(key);
    }
    public int size(){
        return hashMap.size();
    }
}
