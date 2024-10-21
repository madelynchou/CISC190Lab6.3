package edu.sdccd.cisc190.character;

import edu.sdccd.cisc190.weapon.Staff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wizard extends Character {
    private static final Logger LOGGER = LoggerFactory.getLogger(Wizard.class);
    private int magicPoints;
    private int enchantWeaponPoints;
    private int enchantWeaponBonus;

    public Wizard(String name, int healthPoints, int strengthPoints, int defensePoints, Staff staff, int magicPoints, int enchantWeaponPoints, int enchantWeaponBonus) {
        super(name, healthPoints, strengthPoints, defensePoints, staff);
        this.magicPoints = magicPoints;
        this.enchantWeaponPoints = enchantWeaponPoints;
        this.enchantWeaponBonus = enchantWeaponBonus;
    }

    @Override
    public void attack(Character opponent) {
        if(isAlive()) {
            // deal damage with the enchanted staff if enough magicPoints exist
            int damageDealt = getAttackDamage();

            if(magicPoints > enchantWeaponPoints) {
                magicPoints -= enchantWeaponPoints;
                LOGGER.info("Wizard {} casts Enchant Weapon Spell on {} for {} attack bonus, leaving {} magic points remaining!", name, getWeapon().getClass().getSimpleName(), enchantWeaponBonus, magicPoints-enchantWeaponPoints);
                damageDealt += enchantWeaponBonus;
            }

            LOGGER.info("Wizard {} attacks {} {} who takes {} damage", name, opponent.getClass().getSimpleName(), opponent.name, damageDealt);
            opponent.takeDamage(damageDealt);

            // if opponent survives, takes damage
            if(opponent.isAlive()){
                int damageReceived = opponent.getAttackDamage();
                LOGGER.info("{} {} returns attack, Wizzard {} takes {} damage", opponent.getClass().getSimpleName(), opponent.name, name, damageReceived);
                takeDamage(damageReceived);
            }
        } else {
            LOGGER.info("Wizard {} has perished, cannot attack!", name);
        }
    }

    public void equip(Staff staff) {
        this.setWeapon(staff);
    }
}
