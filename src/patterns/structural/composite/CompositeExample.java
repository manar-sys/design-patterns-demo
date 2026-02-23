package patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/*
 * Pattern: Composite
 * Amac: Tekil nesneler ile nesne gruplarini ayni arayuzle kullanmak.
 * Neden/Ne zaman: Hiyerarsik yapi (agac yapisi) oldugunda ve istemci tek/parca ayrimi yapmadan calismaliysa kullanilir.
 * Arti: Istemci kodu sade kalir, tekil ve bileşik nesneler ayni sekilde yonetilir.
 * Eksi: Bazi durumlarda cok genel bir arayuz, kurallari gevsetebilir.
 */
public class CompositeExample {

    interface FileSystemItem {
        int getSize();

        void show(String indent);
    }

    static class FileItem implements FileSystemItem {
        private final String name;
        private final int size;

        FileItem(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public int getSize() {
            return size;
        }

        @Override
        public void show(String indent) {
            System.out.println(indent + "- Dosya: " + name + " (" + size + " KB)");
        }
    }

    static class Folder implements FileSystemItem {
        private final String name;
        private final List<FileSystemItem> children = new ArrayList<>();

        Folder(String name) {
            this.name = name;
        }

        void add(FileSystemItem item) {
            children.add(item);
        }

        @Override
        public int getSize() {
            int total = 0;
            for (FileSystemItem child : children) {
                total += child.getSize();
            }
            return total;
        }

        @Override
        public void show(String indent) {
            System.out.println(indent + "+ Klasor: " + name + " (Toplam: " + getSize() + " KB)");
            for (FileSystemItem child : children) {
                child.show(indent + "  ");
            }
        }
    }

    public static void main(String[] args) {
        FileItem file1 = new FileItem("rapor.pdf", 120);
        FileItem file2 = new FileItem("sunum.ppt", 300);
        FileItem file3 = new FileItem("notlar.txt", 30);

        Folder docs = new Folder("Dokumanlar");
        docs.add(file1);
        docs.add(file2);

        Folder root = new Folder("Proje");
        root.add(docs);
        root.add(file3);

        root.show("");
        System.out.println("Genel boyut: " + root.getSize() + " KB");
    }
}
