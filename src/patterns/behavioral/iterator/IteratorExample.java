package patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/*
 * Pattern: Iterator
 * Amac: Bir koleksiyonun elemanlarini ic yapisini aciga cikarmadan sirayla gezmek.
 * Neden/Ne zaman: Farkli koleksiyon turlerinde ortak dolasma mantigi gerekiyorsa kullanilir.
 * Arti: Koleksiyonun ic yapisindan bagimsiz dolasma saglar.
 * Eksi: Basit durumlarda ek soyutlama katmani gereksiz gorunebilir.
 */
public class IteratorExample {

    interface MyIterator<T> {
        boolean hasNext();

        T next();
    }

    static class CourseCollection {
        private final List<String> courses = new ArrayList<>();

        void addCourse(String course) {
            courses.add(course);
        }

        MyIterator<String> iterator() {
            return new CourseIterator(courses);
        }
    }

    static class CourseIterator implements MyIterator<String> {
        private final List<String> items;
        private int index = 0;

        CourseIterator(List<String> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            return index < items.size();
        }

        @Override
        public String next() {
            return items.get(index++);
        }
    }

    public static void main(String[] args) {
        CourseCollection collection = new CourseCollection();
        collection.addCourse("Design Patterns");
        collection.addCourse("Clean Code");
        collection.addCourse("System Design");

        MyIterator<String> iterator = collection.iterator();
        System.out.println("Kurs listesi:");
        while (iterator.hasNext()) {
            System.out.println("- " + iterator.next());
        }
    }
}
