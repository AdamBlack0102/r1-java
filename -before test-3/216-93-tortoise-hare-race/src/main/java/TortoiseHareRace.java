public class TortoiseHareRace {
    public void game(int hareSpeed, int hareSleepDuration, int tortoiseSpeed, int distance){
        AnimalRacer hare = new Hare(hareSpeed, hareSleepDuration);
        AnimalRacer tortoise = new Tortoise(tortoiseSpeed);

        double hareTime = hare.race(distance);
        double tortoiseTime = tortoise.race(distance);

        if(hareTime < tortoiseTime){
            System.out.print("Hare Win!");
        } else if (tortoiseTime < hareTime){
            System.out.print("Tortoise Win!");
        } else {
            System.out.print("Draw!");
        }

        //add some codes here
    }
}
