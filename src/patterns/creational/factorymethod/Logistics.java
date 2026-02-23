package patterns.creational.factorymethod;

/*
 * Pattern: Factory Method
 * Amac: Hangi somut urunun olusturulacagina alt siniflar karar verir.
 * Neden/Ne zaman: Istemci kodu soyutlamalarla calissin ve olusturma mantigi degisebilsin istendiginde kullanilir.
 * Arti: Genisletmeye aciktir, nesne olusturma kodunu temizler.
 * Eksi: Ek siniflar ve dolayli yapi olusturur.
 */
public abstract class Logistics {

    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();
        System.out.println("Teslimat plani: " + transport.deliver());
    }
}
