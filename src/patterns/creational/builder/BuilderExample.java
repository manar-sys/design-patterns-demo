package patterns.creational.builder;

/*
 * Pattern: Builder
 * Amac: Karmasik nesneleri adim adim olusturmak.
 * Neden/Ne zaman: Kurucular cok uzadiginda veya cok sayida opsiyonel alan oldugunda kullanilir.
 * Arti: Okunabilir nesne olusturma, immutable sonuc mumkun.
 * Eksi: Ek builder sinifi/boilerplate gerektirir.
 */
public class BuilderExample {

    static class House {
        private final int windows;
        private final boolean garage;
        private final boolean garden;

        private House(Builder builder) {
            this.windows = builder.windows;
            this.garage = builder.garage;
            this.garden = builder.garden;
        }

        @Override
        public String toString() {
            return "Ev{pencereSayisi=" + windows + ", garaj=" + garage + ", bahce=" + garden + "}";
        }

        static class Builder {
            private int windows;
            private boolean garage;
            private boolean garden;

            Builder windows(int windows) {
                this.windows = windows;
                return this;
            }

            Builder garage(boolean garage) {
                this.garage = garage;
                return this;
            }

            Builder garden(boolean garden) {
                this.garden = garden;
                return this;
            }

            House build() {
                return new House(this);
            }
        }
    }

    public static void main(String[] args) {
        House house = new House.Builder().windows(6).garage(true).garden(false).build();
        System.out.println(house);
    }
}
