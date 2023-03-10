package designPattern.designPatterns03_BuilderDesignPattern;

public class BuilderPatternMain {

    public static void main(String[] args) {
        Computer comp = new Computer.ComputerBuilder("500 GB", "2 GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .build();
        System.out.println(comp);
    }
}
