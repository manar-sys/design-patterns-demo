package patterns.creational.abstractfactory;

/*
 * Pattern: Abstract Factory
 * Amac: Somut siniflara baglanmadan birbiriyle iliskili urun aileleri olusturmak.
 * Neden/Ne zaman: Uyumlu urun varyantlari (ornegin acik/koyu tema UI seti) gerektiginde kullanilir.
 * Arti: Urun tutarliligini korur, urun ailesini degistirmek kolaydir.
 * Eksi: Yeni bir urun tipi eklemek daha zordur (tum fabrikalara dokunulur).
 */
public class AbstractFactoryExample {

    interface Button {
        String paint();
    }

    interface Checkbox {
        String render();
    }

    interface UIFactory {
        Button createButton();

        Checkbox createCheckbox();
    }



    static class DarkButton implements Button {
        @Override
        public String paint() {
            return "Koyu tema butonu";
        }
    }

    static class DarkCheckbox implements Checkbox {
        @Override
        public String render() {
            return "Koyu tema onay kutusu";
        }
    }


    static class DarkUIFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new DarkButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new DarkCheckbox();
        }
    }

    static class Screen {
        private final Button button;
        private final Checkbox checkbox;

        Screen(UIFactory factory) {
            this.button = factory.createButton();
            this.checkbox = factory.createCheckbox();
        }

        void draw() {
            System.out.println(button.paint() + " + " + checkbox.render());
        }
    }

    public static void main(String[] args) {
        UIFactory factory = new DarkUIFactory();
        Screen screen = new Screen(factory);
        screen.draw();
    }
}
