package collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by nikolaypletnev on 27.06.18.
 */
public class University implements Iterable<Student> {

    private final Student[] students;


    public University(final Student[] students) {
        this.students = students;
    }


    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator();
    }

    private class StudentIterator implements Iterator<Student> {

        private int index = 0;

        @Override
        public boolean hasNext() {

            return index < University.this.students.length;
        }

        @Override

        public Student next() {
            if (index >= University.this.students.length) throw new NoSuchElementException();
            return University.this.students[index++];
        }
    }
}
