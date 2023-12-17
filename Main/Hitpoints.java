
public class Hitpoints {
    
    //user
    
    private int hp;
    
    public void userStartHp(int startHp)
    {
        hp = startHp;
    }

    public void userLoseHp(int loseHp)
    {
        hp = hp - loseHp;
    }

    public void userGainHp(int gainHp)
    {
        hp = hp + gainHp;
    }

    public String userHp()
    {
       return "| Your HP: " + hp + " | ";
    }

    public int curUserHp(int curUserHp)
    {
        hp = curUserHp;
        return curUserHp;
    }
    
    public boolean isDead() {
        return hp <= 0;
    }

    
}
