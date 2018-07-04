package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Group implements Iterable<Student> {

    private final Student[] students;

    public Group(final Student[] students) {
        this.students = students;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentsIterator(students);
    }

    private static class StudentsIterator implements Iterator<Student>{
        private int index = 0;
        private final Student[] students;

        public StudentsIterator(final Student[] students) {
            this.students = students;
        }



        @Override
        public boolean hasNext() {
            int nextIndex = index;
            return nextIndex < students.length;
        }

        @Override
        public Student next() {
            if (index >= students.length) throw new NoSuchElementException();
            return students[index++];
        }
    }


}
