 public class aiHp {
    private int aiCurHp;

    public void aiStartHp(int initialHp) {
        aiCurHp = initialHp;
    }

    public void aiLoseHp(int damage) {
        aiCurHp -= damage;
    }

    public void aiGainHp(int healing) {
        aiCurHp += healing;
    }

    public int aiCurHp() {
        return aiCurHp;
    }
    
    public boolean isDead() {
        return aiCurHp <= 0;
    }
}