import java.util.Random;

public class AI {

    private int aiCurHp;
    private Random random;
    private aiHp aiHitpoints;

    public AI(int initialHp, aiHp aiHitpoints) {
        this.aiCurHp = initialHp;
        this.random = new Random();
        this.aiHitpoints = aiHitpoints;
    }

    public void aiChooseAction() {
        boolean shouldAttack = random.nextBoolean();

        if (shouldAttack) {
            int damage = generateRandomDamage();
            System.out.println("AI attacks for " + damage + " damage.");
            aiHitpoints.aiLoseHp(damage);
        } else {
            int healing = generateRandomHealing();
            System.out.println("AI heals for " + healing + " health.");
            aiHitpoints.aiGainHp(healing);
        }
    }
        public void aiLoseHp(int damage) {
            aiCurHp = aiCurHp - damage;
        }

    public int aiCurHp() {
        return aiCurHp;
    }

    private int generateRandomDamage() {
        return random.nextInt(10) + 1; // Adjust the damage range as needed
    }

    private int generateRandomHealing() {
        return random.nextInt(10) + 1; // Adjust the healing range as needed
    }
}
