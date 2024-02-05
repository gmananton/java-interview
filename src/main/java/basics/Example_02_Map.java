package basics;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Example_02_Map {

    public static void main(String[] args) {

        Map<KeyObject, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(new KeyObject("k_" + i), i);
        }

    }

    @AllArgsConstructor
    private static final class KeyObject {

        private final String name;

        @Override
        public int hashCode() {
            return Objects.hash("CONST_VALUE");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            KeyObject that = (KeyObject) o;

            return name.equals(that.name);
        }
    }

}
