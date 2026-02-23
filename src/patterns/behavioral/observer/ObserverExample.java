package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/*
 * Pattern: Observer
 * Amac: Konunun durumu degistiginde birden fazla aboneyi bilgilendirmek.
 * Neden/Ne zaman: Olay gudumlu guncellemelerde (UI, mesajlasma, hisse verisi) kullanilir.
 * Arti: Yayinci/abone arasinda gevsek baglilik saglar.
 * Eksi: Bildirim sirasi ve performans yonetimi zorlasabilir.
 */
public class ObserverExample {

    interface Subscriber {
        void update(String message);
    }

    static class NewsChannel {
        private final List<Subscriber> subscribers = new ArrayList<>();

        void subscribe(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        void publish(String news) {
            for (Subscriber subscriber : subscribers) {
                subscriber.update(news);
            }
        }
    }

    static class MobileAppSubscriber implements Subscriber {
        private final String name;

        MobileAppSubscriber(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(name + " bildirimi aldi: " + message);
        }
    }

    public static void main(String[] args) {
        NewsChannel channel = new NewsChannel();
        channel.subscribe(new MobileAppSubscriber("Ali"));
        channel.subscribe(new MobileAppSubscriber("Sara"));
        channel.publish("Yeni pattern makalesi yayinda");
    }
}
