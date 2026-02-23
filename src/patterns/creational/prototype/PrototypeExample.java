package patterns.creational.prototype;

/*
 * Pattern: Prototype
 * Amac: Yeni nesneleri sifirdan uretmek yerine mevcut bir nesneyi klonlayarak olusturmak.
 * Neden/Ne zaman: Olusturma maliyeti yuksek nesnelerde veya benzer konfigurasyonlar hizli kopyalanacaksa kullanilir.
 * Arti: Performans ve hizli kopyalama saglar, kurulum maliyetini azaltir.
 * Eksi: Derin kopya/yuzeysel kopya yonetimi dogru kurulmazsa hata riski olusur.
 */
public class PrototypeExample {

    interface Prototype {
        Prototype copy();
    }

    static class Document implements Prototype {
        private String title;
        private final String content;

        Document(String title, String content) {
            this.title = title;
            this.content = content;
        }

        @Override
        public Prototype copy() {
            return new Document(this.title, this.content);
        }

        void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Belge{baslik='" + title + "', icerik='" + content + "'}";
        }
    }

    public static void main(String[] args) {
        Document original = new Document("Teklif Taslagi", "Standart teklif metni");
        Document clone = (Document) original.copy();
        clone.setTitle("Teklif Taslagi - Musteri B");

        System.out.println("Orijinal: " + original);
        System.out.println("Klon: " + clone);
    }
}
