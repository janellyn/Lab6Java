class ElectricalAppliance {
    private String name;
    private double powerConsumption;
    private boolean on = true;

    public ElectricalAppliance(String name, double powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
    }

    public double getPowerConsumption() {
        if (on) return powerConsumption;
        else return 0;
    }

    public void turn(){
        on = !on;
    }
    @Override
    public String toString() {
        return name + " (Потужність: " + getPowerConsumption() + " Вт)";
    }
}


class Light extends ElectricalAppliance {
    public Light(String name, double powerConsumption) {
        super(name, powerConsumption);
    }
}

class Microwave extends ElectricalAppliance {
    public Microwave(String name, double powerConsumption) {
        super(name, powerConsumption);
    }
}

class WashingMachine extends ElectricalAppliance {
    public WashingMachine(String name, double powerConsumption) {
        super(name, powerConsumption);
    }
}

class Apartment {
    private ElectricalAppliance[] appliances;
    private int numberOfAppliances;

    public Apartment(int capacity) {
        appliances = new ElectricalAppliance[capacity];
        numberOfAppliances = 0;
    }

    public void addAppliance(ElectricalAppliance appliance) {
        if (numberOfAppliances < appliances.length) {
            appliances[numberOfAppliances] = appliance;
            numberOfAppliances++;
        } else {
            System.out.println("Квартира переповнена. Неможливо додати більше приладів.");
        }
    }

    public double calculateTotalPowerConsumption() {
        double totalPower = 0;
        for (int i = 0; i < numberOfAppliances; i++) {
            totalPower += appliances[i].getPowerConsumption();
        }
        return totalPower;
    }

    public void sortByPowerConsumption() {
        for (int i = 0; i < numberOfAppliances - 1; i++) {
            for (int j = 0; j < numberOfAppliances - i - 1; j++) {
                if (appliances[j].getPowerConsumption() > appliances[j + 1].getPowerConsumption()) {
                    ElectricalAppliance temp = appliances[j];
                    appliances[j] = appliances[j + 1];
                    appliances[j + 1] = temp;
                }
            }
        }
    }

    public void printSortedAppliances() {
        System.out.println("Сортування за потужністю:");
        for (int i = 0; i < numberOfAppliances; i++) {
            System.out.println(appliances[i]);
        }
    }

    public void findAppliancesInPowerRange(double minPower, double maxPower) {
        System.out.println("Прилади у діапазоні потужності " + minPower + " - " + maxPower + " Вт:");
        for (int i = 0; i < numberOfAppliances; i++) {
            double power = appliances[i].getPowerConsumption();
            if (power >= minPower && power <= maxPower) {
                System.out.println(appliances[i]);
            }
        }
    }
}

public class App{

    public static void main(String[] args) {
        Apartment apartment = new Apartment(6);

        apartment.addAppliance(new ElectricalAppliance("Холодильник", 150));
        apartment.addAppliance(new Light("Люстра", 25));
        apartment.addAppliance(new Microwave("Мікрохвильовка", 1200));
        apartment.addAppliance(new WashingMachine("Пральна машина", 900));
        apartment.addAppliance(new ElectricalAppliance("Телевізор", 60));
        ElectricalAppliance teleport = new ElectricalAppliance("Телепорт", 99999);
        //teleport.turn();
        apartment.addAppliance(teleport);

        System.out.println("Загальна потужність: " + apartment.calculateTotalPowerConsumption() + " Вт");

        apartment.sortByPowerConsumption();
        apartment.printSortedAppliances();

        double minPower = 50;
        double maxPower = 200;
        apartment.findAppliancesInPowerRange(minPower, maxPower);
    }
}