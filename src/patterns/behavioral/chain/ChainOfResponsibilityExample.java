package patterns.behavioral.chain;

/*
 * Pattern: Chain of Responsibility
 * Amac: Bir istegi, zincirdeki uygun isleyiciye sirayla iletip ele almak.
 * Neden/Ne zaman: Bir istegin kim tarafindan islenecegi onceden belli degilse kullanilir.
 * Arti: Istek gonderen ile isleyen taraf birbirinden ayrisir, zincir kolayca genisler.
 * Eksi: Zincir iyi tasarlanmazsa istek hic ele alinmayabilir veya takibi zorlasir.
 */
public class ChainOfResponsibilityExample {

    abstract static class SupportHandler {
        private SupportHandler next;

        SupportHandler setNext(SupportHandler next) {
            this.next = next;
            return next;
        }

        void handle(String issueType) {
            if (canHandle(issueType)) {
                process(issueType);
            } else if (next != null) {
                next.handle(issueType);
            } else {
                System.out.println("Bu talep icin uygun destek bulunamadi: " + issueType);
            }
        }

        protected abstract boolean canHandle(String issueType);

        protected abstract void process(String issueType);
    }

    static class BillingSupport extends SupportHandler {
        @Override
        protected boolean canHandle(String issueType) {
            return "fatura".equalsIgnoreCase(issueType);
        }

        @Override
        protected void process(String issueType) {
            System.out.println("Fatura destegi talebi cozuldu.");
        }
    }

    static class TechnicalSupport extends SupportHandler {
        @Override
        protected boolean canHandle(String issueType) {
            return "teknik".equalsIgnoreCase(issueType);
        }

        @Override
        protected void process(String issueType) {
            System.out.println("Teknik destek talebi cozuldu.");
        }
    }

    static class GeneralSupport extends SupportHandler {
        @Override
        protected boolean canHandle(String issueType) {
            return "genel".equalsIgnoreCase(issueType);
        }

        @Override
        protected void process(String issueType) {
            System.out.println("Genel destek talebi cozuldu.");
        }
    }

    public static void main(String[] args) {
        SupportHandler billing = new BillingSupport();
        SupportHandler technical = new TechnicalSupport();
        SupportHandler general = new GeneralSupport();

        billing.setNext(technical).setNext(general);

        billing.handle("teknik");
        billing.handle("fatura");
        billing.handle("hesap");
    }
}
