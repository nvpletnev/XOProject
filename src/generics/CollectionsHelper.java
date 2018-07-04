package generics;

import java.util.List;

public class CollectionsHelper {

    public static <T>int findFirstIndex(final List<T> list, final T element) {
        if(list.contains(element)) return list.indexOf(element);
        return -1;
    }

    public static <T>int findLastIndex(final List<T> list, final T element) {
        if(list.contains(element)) return list.lastIndexOf(element);
        return -1;
    }

    public int findFirstIndexNew(final List<? extends Human> list, final String element) {
        for (Human h : list) {
            if(h.getName().contains(element)) return list.indexOf(h);

        } return -1;
    }


}