package edu.sdccd.cisc190.character;

import edu.sdccd.cisc190.weapon.Bow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archer extends Character {
    private static final Logger LOGGER = LoggerFactory.getLogger(Archer.class);
    private int numArrows;

    public Archer(String name, int healthPoints, int strengthPoints, int defensePoints, Bow bow, int numArrows) {
        super(name, healthPoints, strengthPoints, defensePoints, bow);
        this.numArrows = numArrows;
    }

    @Override
    public void attack(Character opponent) {
        if(isAlive()) {
            // deal damage if arrow available
            if (numArrows > 0) {
               int damage = getAttackDamage();
               LOGGER.info("Archer {} fires an arrow at {} {} who takes {} damage", this.name, opponent.getClass().getSimpleName(), opponent.name, damage);
               opponent.takeDamage(damage);

                numArrows--;

                if(!opponent.isAlive()){
                    LOGGER.info("{} {} has perished", opponent.getClass().getSimpleName(), opponent.name);
                }
            } else{
                LOGGER.info("Archer {} is out of arrows, cannot attack!", this.name);
            }
            // take no damage since this is a ranged attack
        } else {
            LOGGER.info("Archer {} has perished, cannot attack!", this.name);
        }
    }
}
