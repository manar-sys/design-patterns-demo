package patterns.creational.singleton;

/*
 * Pattern: Singleton
 * Amac: Tek bir ornegi garanti etmek ve global erisim noktasi sunmak.
 * Neden/Ne zaman: Config/logger gibi paylasilan kaynaklarda tek ornek zorunluysa kullanilir.
 * Arti: Tek ornek kontrolu saglar, lazy/eager secenekleri vardir.
 * Eksi: Gizli global durum yaratir, test ve mock islemlerini zorlastirir.
 */
public class SingletonExample {

    static class AppConfig {
        private static final AppConfig INSTANCE = new AppConfig();
        private String environment = "gelistirme";

        private AppConfig() {
        }

        static AppConfig getInstance() {
            return INSTANCE;
        }

        String getEnvironment() {
            return environment;
        }

        void setEnvironment(String environment) {
            this.environment = environment;
        }
    }

    public static void main(String[] args) {
        AppConfig a = AppConfig.getInstance();
        AppConfig b = AppConfig.getInstance();
        a.setEnvironment("uretim");
        System.out.println(a == b);
        System.out.println("Ortam: " + b.getEnvironment());
    }
}
