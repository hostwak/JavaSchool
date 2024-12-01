
package hm3;

import java.util.Map;

public interface CountMap <T>{
    void add (T o); // добавлегние элемента

    int getCount(T o); // получить элемент

    int remove (T o); // удалить элемент

    int size (T o); // кол-во элементов

    int size();

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей,суммировать значения
    void addAll(CountMap<T> source);

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    Map<T, Integer> toMap();


    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map<T, Integer> destination);


}