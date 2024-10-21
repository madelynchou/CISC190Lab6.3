package edu.sdccd.cisc190.character;

import edu.sdccd.cisc190.weapon.Blade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fighter extends Character {
    private static final Logger LOGGER = LoggerFactory.getLogger(Fighter.class);

    public Fighter(String name, int healthPoints, int strengthPoints, int defensePoints, Blade blade) {
        super(name, healthPoints, strengthPoints, defensePoints, blade);
    }

    @Override
    public void attack(Character opponent) {
        if(isAlive()) {
            // deal damaage
            int damage = getAttackDamage();
            LOGGER.info("Fighter {} attacks {} {} who takes {} damage", this.name, opponent.getClass().getSimpleName(), opponent.getName(), damage);
            opponent.takeDamage(damage);

            // if opponent still alive, take damage
            if(opponent.isAlive()){
                int damageReceived = opponent.getAttackDamage();
                LOGGER.info("{} {} returns attack, Fighter {} takes {} damage", opponent.getClass().getSimpleName(), opponent.getName(), name, damageReceived);
            }
        } else {
            LOGGER.info("Fighter {} has perished, cannot attack!", name);
        }
    }
}
