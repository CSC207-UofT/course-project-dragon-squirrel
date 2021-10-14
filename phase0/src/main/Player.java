public class Player {
    public boolean white;
    public boolean human;

    public boolean isWhite(){
        return this.white;
    }

    public boolean isHuman(){
        return this.human;
    }
}

public class Human extends Player{
    public Human(white){
        this.white;
        this.human = true;
    }
}

public class Computer extends Player{
    public Computer(white){
        this.white;
        this.human = false;
    }
}