package patterns.structural.proxy;

/*
 * Pattern: Proxy
 * Amac: Gercek nesneye erisimi kontrol eden bir vekil nesne sunmak.
 * Neden/Ne zaman: Erisim kontrolu, gecikmeli yukleme veya loglama gerektiginde kullanilir.
 * Arti: Guvenlik ve performans optimizasyonu saglar.
 * Eksi: Ek katman sebebiyle yapisal karmasiklik artabilir.
 */
public class ProxyExample {

    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private final String fileName;

        RealImage(String fileName) {
            this.fileName = fileName;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("Diskten yukleniyor: " + fileName);
        }

        @Override
        public void display() {
            System.out.println("Goruntu ekranda: " + fileName);
        }
    }

    static class ImageProxy implements Image {
        private final String fileName;
        private RealImage realImage;

        ImageProxy(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image image = new ImageProxy("rapor.png");
        System.out.println("Ilk cagri:");
        image.display();
        System.out.println("Ikinci cagri:");
        image.display();
    }
}
