一只兔子和一只乌龟进行赛跑，请判断出兔子和乌龟谁能获得胜利。
其中Hare为兔子的类，Tortoise为乌龟的类。在等长的赛跑(distance)途中，乌龟和兔子同时出发。兔子会先跑一段，然后进入一次的睡眠(sleepDuration)，然后再跑到终点。而乌龟会一刻不停地跑下去。乌龟和兔子的速度(speed)是不等的。
请在相应的类方法和TortoiseHareRace类中game方法中补上相应的代码。
如果兔子胜利，则输出Hare Win!;乌龟胜利，则输出Tortoise Win!;平局则输出Draw!。（最后无"\n"）

输入：
    //Game的定义 public void game(int hareSpeed, int hareSleepDuration, int tortoiseSpeed, int distance)
    game(5,80,1,100)

输出：
    Draw！


输入：
    //Game的定义 public void game(int hareSpeed, int hareSleepDuration, int tortoiseSpeed, int distance)
    game(5,79,1,100)

输出：
    Hare Win！