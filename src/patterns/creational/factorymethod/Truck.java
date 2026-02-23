package patterns.creational.factorymethod;

public class Truck implements Transport {

    @Override
    public String deliver() {
        return "Kamyon ile karayolundan teslim et";
    }
}
