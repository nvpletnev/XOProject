package generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class CollectionsHelperTest {
    @Test
    public void findFirstIndexNew() throws Exception {
        CollectionsHelper collectionsHelper = new CollectionsHelper();

        List<Man> humans = new ArrayList();
        humans.add(new Man("Vasya"));
        collectionsHelper.findFirstIndexNew(humans, "Vasya");

        assertEquals(0, collectionsHelper.findFirstIndexNew(humans, "Vasya"));


    }

    @Test
    public void findFirstIndex() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Vasya");
        list.add("Petya");
        list.add("Vasya");
        list.add("Andrey");
        list.add("Petya");
        list.add("Max");
        int exceptedElement = 0;
        assertEquals(exceptedElement, CollectionsHelper.findFirstIndex(list, "Vasya"));
    }

    @Test
    public void findLastIndex() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Vasya");
        list.add("Petya");
        list.add("Vasya");
        list.add("Andrey");
        list.add("Petya");
        list.add("Max");
        int exceptedElement = 2;
        assertEquals(exceptedElement, CollectionsHelper.findLastIndex(list, "Vasya"));

    }

    @Test
    public void findLastIndexWhenNoElement() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Vasya");
        list.add("Petya");
        list.add("Vasya");
        list.add("Andrey");
        list.add("Petya");
        list.add("Max");
        int exceptedElement = -1;
        assertEquals(exceptedElement, CollectionsHelper.findLastIndex(list, "Grigoriy"));

    }
    @Test
    public void findFirstIndexWhenNoElement() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Vasya");
        list.add("Petya");
        list.add("Vasya");
        list.add("Andrey");
        list.add("Petya");
        list.add("Max");
        int exceptedElement = -1;
        assertEquals(exceptedElement, CollectionsHelper.findFirstIndex(list, "Grigoriy"));

    }
}