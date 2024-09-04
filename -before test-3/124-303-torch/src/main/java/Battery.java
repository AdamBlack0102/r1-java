public class Battery {
    double left;

    //add the attributes for class Battery


    //No Parameter Constructor
    //set the attributes with default value
    public Battery(){
        this.left = 0.0;
    }

    public double getConsumptionRate(){
        return 0.1;
    }

    public double getProductionRate(){
        return 0.2;
    }


    //充 p 电量
    //charge power which amount is p
    public void chargeBattery(int hours){
        if(left < 1.0) {
            left += getProductionRate() * hours;
        } else if (left >= 1.0) {
            left = 1.0;
        }
    }
    //如果剩余电量》=p，使用 p电量，返回true，否则剩余电量=0，返回false
    //if the remaining power amount is larger than p, consume the p power and return true;
    //else the remaining power become 0 and return false;
    public boolean useBattery(double p){
        if(left >= p){
            left -= p;
            return true;
        } else {
            left = 0;
            return false;
        }
    }
}
