package edu.sdccd.cisc190.character;

import edu.sdccd.cisc190.weapon.Weapon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract public class Character {
    private static final Logger LOGGER = LoggerFactory.getLogger(Character.class);
    public static final int NUM_CHARACTERS = 3;

    public final String name;
    private Weapon weapon;
    private int healthPoints;
    private int strengthPoints;
    private int defensePoints;

    public Character(String name, int healthPoints, int strengthPoints, int defensePoints, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
        this.healthPoints = healthPoints;
        this.strengthPoints = strengthPoints;
        this.defensePoints = defensePoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getStrengthPoints() {
        return strengthPoints;
    }

    public void setStrengthPoints(int strengthPoints) {
        this.strengthPoints = strengthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    abstract public void attack(Character opponent);

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public int getAttackDamage() {
        return getStrengthPoints() + weapon.attackBonus;
    }

    public void takeDamage(int damage) {
        LOGGER.debug("{} has {} health points and {} defense points", name, healthPoints, defensePoints);
        int damageAfterDefense = damage - getDefensePoints();
        if(damageAfterDefense < 0) damageAfterDefense = 0;
        setHealthPoints(getHealthPoints() + damageAfterDefense);
        LOGGER.debug("{} took {} damage reduced by {} defense points, leaving {} health points remaining", name, damage, defensePoints, healthPoints);
    }
}