package patterns.structural.bridge;

/*
 * Pattern: Bridge
 * Amac: Soyutlamayi uygulamadan ayirarak ikisini bagimsiz sekilde gelistirmek.
 * Neden/Ne zaman: Birden fazla boyutta degisim varsa (ornegin cihaz tipi + uzaktan kumanda tipi) kullanilir.
 * Arti: Sinif patlamasini azaltir, esnek bir yapi saglar.
 * Eksi: Ilk kurulumda soyutlama katmani nedeniyle yapi daha karmasik gorunebilir.
 */
public class BridgeExample {

    interface Device {
        void turnOn();

        void turnOff();

        void setVolume(int volume);
    }

    static class Tv implements Device {
        private int volume = 10;

        @Override
        public void turnOn() {
            System.out.println("TV acildi");
        }

        @Override
        public void turnOff() {
            System.out.println("TV kapandi");
        }

        @Override
        public void setVolume(int volume) {
            this.volume = volume;
            System.out.println("TV ses seviyesi: " + this.volume);
        }
    }

    static class Radio implements Device {
        private int volume = 5;

        @Override
        public void turnOn() {
            System.out.println("Radyo acildi");
        }

        @Override
        public void turnOff() {
            System.out.println("Radyo kapandi");
        }

        @Override
        public void setVolume(int volume) {
            this.volume = volume;
            System.out.println("Radyo ses seviyesi: " + this.volume);
        }
    }

    static abstract class RemoteControl {
        protected final Device device;

        RemoteControl(Device device) {
            this.device = device;
        }

        void powerOn() {
            device.turnOn();
        }

        void powerOff() {
            device.turnOff();
        }

        abstract void increaseVolume();
    }

    static class BasicRemote extends RemoteControl {
        private int currentVolume = 10;

        BasicRemote(Device device) {
            super(device);
        }

        @Override
        void increaseVolume() {
            currentVolume += 5;
            device.setVolume(currentVolume);
        }
    }

    public static void main(String[] args) {
        RemoteControl tvRemote = new BasicRemote(new Tv());
        tvRemote.powerOn();
        tvRemote.increaseVolume();
        tvRemote.powerOff();

        RemoteControl radioRemote = new BasicRemote(new Radio());
        radioRemote.powerOn();
        radioRemote.increaseVolume();
        radioRemote.powerOff();
    }
}
