package concurrency;

import java.util.HashMap;
import java.util.Map;

public class Example_04_Cache {

    public static void main(String[] args) {
        SimpleCache<String, String> cacheExample = new SimpleCache<>();

        for (int i = 0; i < 10000; i++) {
            cacheExample.save("a" + i, "b");
            cacheExample.get("a" + (i - 1));
        }

        System.out.println(cacheExample.size());
    }



    public static class SimpleCache<K, V> {

        private final Map<K, V> storage = new HashMap<>();

        public void save(K key, V val) {
            storage.put(key, val);
        }

        public V get(K key) {
            return storage.get(key);
        }

        public int size() {
            return storage.size();
        }

    }

}
