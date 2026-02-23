package patterns.behavioral.strategy;

/*
 * Pattern: Strategy
 * Amac: Degistirilebilir algoritmalari ortak bir arayuz arkasinda kapsullemek.
 * Neden/Ne zaman: Davranis baglama veya kullanici secimine gore degisiyorsa kullanilir.
 * Arti: if-else zincirlerini azaltir, genisletmesi kolaydir.
 * Eksi: Nesne/sinif sayisini artirir.
 */
public class StrategyExample {

    interface DiscountStrategy {
        double apply(double price);
    }

    static class NoDiscount implements DiscountStrategy {
        @Override
        public double apply(double price) {
            return price;
        }
    }

    static class StudentDiscount implements DiscountStrategy {
        @Override
        public double apply(double price) {
            return price * 0.8;
        }
    }


    static class Checkout {
        private DiscountStrategy strategy;

        Checkout(DiscountStrategy strategy) {
            this.strategy = strategy;
        }

        void setStrategy(DiscountStrategy strategy) {
            this.strategy = strategy;
        }

        double finalPrice(double price) {
            return strategy.apply(price);
        }
    }

    public static void main(String[] args) {
        Checkout checkout = new Checkout(new NoDiscount());
        System.out.println("Indirimsiz fiyat: " + checkout.finalPrice(100));
        checkout.setStrategy(new StudentDiscount());
        System.out.println("Ogrenci indirimi sonrasi fiyat: " + checkout.finalPrice(100));
    }
}
