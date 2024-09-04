public class Torch extends Battery{
    //add attributes for torch
    double consumptionRate;
    double productionRate;
    double use = 0.0;


    public Torch(Battery battery){
       this.consumptionRate = battery.getConsumptionRate();
       this.productionRate = battery.getProductionRate();
    }

    /**
     * 10% power consumption per hour for using a torch
     * return true if enough power
     * return false if battery cannot support for the specified hours
     */
    public boolean turnOn(int hours){
        use = hours * 0.1;
        return useBattery(use);
        //add code here
    }
    /**
     * 20% power production per hour for charging the battery
     */
    public void charge(int hours){
        chargeBattery(hours);
        //add code here
    }

}
