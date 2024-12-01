
package hm3;

import java.util.HashMap;
import java.util.Map;

public class CountMapImp<T> implements CountMap<T> {

    private Map<T, Integer> map;

    public CountMapImp() {
        map = new HashMap<>();
    }

    @Override
    public void add(T o) {
        if (map.containsKey(o)) {
            map.put(o, map.get(o) + 1);
        } else {
            map.put(o, 1);
        }
    }

    @Override
    public int getCount(T o) {
        return map.getOrDefault(o, 0);

    }

    @Override
    public int remove(T o) {
        if(map.containsKey(o)){
            int count = map.get(o);
            map.remove(o);
            return count;
        }else {
            return 0;
        }
    }

    @Override
    public int size(T o) {
        return 0;
    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (var item: source.toMap().keySet()){
            this.add(item);
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(map);
    }
}