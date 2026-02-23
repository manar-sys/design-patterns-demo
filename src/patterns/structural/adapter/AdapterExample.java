package patterns.structural.adapter;

/*
 * Pattern: Adapter
 * Amac: Bir arayuzu, istemcinin bekledigi baska bir arayuze donusturmek.
 * Neden/Ne zaman: Uyumsuz API'ye sahip legacy/ucuncu parti kod entegre edilirken kullanilir.
 * Arti: Mevcut kod degistirilmeden yeniden kullanilir.
 * Eksi: Ek katman karmasiklik ekleyebilir.
 */
public class AdapterExample {

    interface PaymentProcessor {
        void pay(double amount);
    }

    static class LegacyBankApi {
        void makeTransfer(double value) {
            System.out.println("Transfer edilen tutar: " + value);
        }
    }

    static class BankApiAdapter implements PaymentProcessor {
        private final LegacyBankApi legacyApi;

        BankApiAdapter(LegacyBankApi legacyApi) {
            this.legacyApi = legacyApi;
        }

        @Override
        public void pay(double amount) {
            legacyApi.makeTransfer(amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new BankApiAdapter(new LegacyBankApi());
        processor.pay(125.5);
    }
}
