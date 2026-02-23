package patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/*
 * Pattern: Flyweight
 * Amac: Ortak durumu paylastirarak cok sayida benzer nesnenin bellek maliyetini azaltmak.
 * Neden/Ne zaman: Cok fazla benzer nesne olusturuluyorsa ve ortak veri paylastirilabiliyorsa kullanilir.
 * Arti: Bellek kullanimini ciddi sekilde dusurur.
 * Eksi: Ic/dis durum ayrimini dogru tasarlamak gerekir, aksi halde karmasiklasabilir.
 */
public class FlyweightExample {

    interface TreeType {
        void draw(int x, int y);
    }

    static class ConcreteTreeType implements TreeType {
        private final String name;
        private final String color;
        private final String texture;

        ConcreteTreeType(String name, String color, String texture) {
            this.name = name;
            this.color = color;
            this.texture = texture;
        }

        @Override
        public void draw(int x, int y) {
            System.out.println("Agac cizildi -> tur: " + name + ", renk: " + color + ", doku: " + texture + ", konum: (" + x + ", " + y + ")");
        }
    }

    static class TreeFactory {
        private static final Map<String, TreeType> CACHE = new HashMap<>();

        static TreeType getTreeType(String name, String color, String texture) {
            String key = name + "_" + color + "_" + texture;
            CACHE.putIfAbsent(key, new ConcreteTreeType(name, color, texture));
            return CACHE.get(key);
        }

        static int cacheSize() {
            return CACHE.size();
        }
    }

    static class Tree {
        private final int x;
        private final int y;
        private final TreeType type;

        Tree(int x, int y, TreeType type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        void draw() {
            type.draw(x, y);
        }
    }

    public static void main(String[] args) {
        TreeType pine = TreeFactory.getTreeType("Cam", "Yesil", "Ince");
        TreeType oak = TreeFactory.getTreeType("Mesese", "Koyu Yesil", "Kalın");
        TreeType pineAgain = TreeFactory.getTreeType("Cam", "Yesil", "Ince");

        Tree t1 = new Tree(10, 20, pine);
        Tree t2 = new Tree(30, 40, oak);
        Tree t3 = new Tree(50, 60, pineAgain);

        t1.draw();
        t2.draw();
        t3.draw();

        System.out.println("Paylasilan agac tipi sayisi: " + TreeFactory.cacheSize());
    }
}
