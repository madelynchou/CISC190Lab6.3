package edu.sdccd.cisc190.weapon;

abstract public class Weapon {
    public final String name;
    public final int attackBonus;

    public Weapon(String name, int attackBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
    }
}
