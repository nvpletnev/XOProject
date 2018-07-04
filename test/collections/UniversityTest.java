package collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by nikolaypletnev on 27.06.18.
 */
public class UniversityTest {
    @Test
    public void iterator() throws Exception {

        final Student[] students = new Student[10_000];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }

        University university = new University(students);

        for (Student student: university) {
            System.out.println(student);
        }

    }



}