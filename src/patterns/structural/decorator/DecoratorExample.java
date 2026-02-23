package patterns.structural.decorator;

/*
 * Pattern: Decorator
 * Amac: Nesnelere dinamik olarak yeni davranis eklemek.
 * Neden/Ne zaman: Ozellik kombinasyonlari calisma aninda esnek sekilde gerekli oldugunda kullanilir.
 * Arti: Esnek bilesim saglar, alt sinif patlamasini onler.
 * Eksi: Cok sayida kucuk sarmalayici sinif olusabilir.
 */
public class DecoratorExample {

    interface Notifier {
        String send(String message);
    }

    static class BasicNotifier implements Notifier {
        @Override
        public String send(String message) {
            return "E-posta: " + message;
        }
    }

    static abstract class NotifierDecorator implements Notifier {
        protected final Notifier wrappee;

        NotifierDecorator(Notifier wrappee) {
            this.wrappee = wrappee;
        }

        @Override
        public String send(String message) {
            return wrappee.send(message);
        }
    }

    static class SmsDecorator extends NotifierDecorator {
        SmsDecorator(Notifier wrappee) {
            super(wrappee);
        }

        @Override
        public String send(String message) {
            return super.send(message) + " | SMS: " + message;
        }
    }

    static class SlackDecorator extends NotifierDecorator {
        SlackDecorator(Notifier wrappee) {
            super(wrappee);
        }

        @Override
        public String send(String message) {
            return super.send(message) + " | Slack: " + message;
        }
    }

    public static void main(String[] args) {
        Notifier notifier = new SlackDecorator(new SmsDecorator(new BasicNotifier()));
        System.out.println(notifier.send("Sunucu durumu iyi"));
    }
}
