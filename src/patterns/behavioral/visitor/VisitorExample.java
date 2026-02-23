package patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/*
 * Pattern: Visitor
 * Amac: Nesne yapisini degistirmeden, yeni islemleri ayri ziyaretci siniflarinda tanimlamak.
 * Neden/Ne zaman: Farkli tipte elemanlar uzerinde yeni davranislar sik eklenecekse kullanilir.
 * Arti: Yeni operasyon eklemek kolaydir, eleman siniflari sade kalir.
 * Eksi: Yeni eleman tipi eklendiginde tum visitor'lar guncellenir.
 */
public class VisitorExample {

    interface Shape {
        void accept(ShapeVisitor visitor);
    }

    static class Circle implements Shape {
        private final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        double getRadius() {
            return radius;
        }

        @Override
        public void accept(ShapeVisitor visitor) {
            visitor.visitCircle(this);
        }
    }

    static class Rectangle implements Shape {
        private final double width;
        private final double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        double getWidth() {
            return width;
        }

        double getHeight() {
            return height;
        }

        @Override
        public void accept(ShapeVisitor visitor) {
            visitor.visitRectangle(this);
        }
    }

    interface ShapeVisitor {
        void visitCircle(Circle circle);

        void visitRectangle(Rectangle rectangle);
    }

    static class AreaCalculatorVisitor implements ShapeVisitor {
        @Override
        public void visitCircle(Circle circle) {
            double area = Math.PI * circle.getRadius() * circle.getRadius();
            System.out.println("Daire alani: " + String.format("%.2f", area));
        }

        @Override
        public void visitRectangle(Rectangle rectangle) {
            double area = rectangle.getWidth() * rectangle.getHeight();
            System.out.println("Dikdortgen alani: " + String.format("%.2f", area));
        }
    }

    static class JsonExportVisitor implements ShapeVisitor {
        @Override
        public void visitCircle(Circle circle) {
            System.out.println("{\"tip\":\"Daire\",\"yaricap\":" + circle.getRadius() + "}");
        }

        @Override
        public void visitRectangle(Rectangle rectangle) {
            System.out.println("{\"tip\":\"Dikdortgen\",\"genislik\":" + rectangle.getWidth()
                    + ",\"yukseklik\":" + rectangle.getHeight() + "}");
        }
    }

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(4));
        shapes.add(new Rectangle(3, 6));

        ShapeVisitor areaVisitor = new AreaCalculatorVisitor();
        ShapeVisitor jsonVisitor = new JsonExportVisitor();

        System.out.println("Alan hesaplari:");
        for (Shape shape : shapes) {
            shape.accept(areaVisitor);
        }

        System.out.println("JSON ciktilari:");
        for (Shape shape : shapes) {
            shape.accept(jsonVisitor);
        }
    }
}
