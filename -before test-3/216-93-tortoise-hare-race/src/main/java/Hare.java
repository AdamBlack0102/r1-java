public class Hare extends AnimalRacer {
    int sleepDuration;

    Hare(int s, int d ){
        speed = s;
        sleepDuration = d;
        //add some codes here
    }

    //add codes here
    public double race(int distance) {
        return ((double)distance / speed) + sleepDuration;
    }

    //add codes here
    public void win() {

    }
}
