package org.kniit.lab3.task6;

abstract class Player {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected boolean isAlive;
    protected int positionX;
    protected int positionY;
    protected int damage;
    protected int defence;

    public Player(String name, int maxHealth, int damage, int defence) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.isAlive = true;
        this.damage = damage;
        this.defence = defence;
        this.positionX = 0;
        this.positionY = 0;
    }

    public void increaseHealth(int value) {
        health = Math.min(health + value, maxHealth);
        System.out.println(name + " восстановил " + value + " здоровья. Текущее здоровье: " + health);
    }

    public void decreaseHealth(int value) {
        health = health + defence - value;
        if (health <= 0) {
            health = 0;
            isAlive = false;
            System.out.println(name + " погиб!");
        } else {
            System.out.println(name + " получил " + value + " урона. Текущее здоровье: " + health);
        }
    }

    public void moveTo(int x, int y) {
        positionX = x;
        positionY = y;
        System.out.println(name + " переместился в позицию (" + x + ", " + y + ")");
    }

    // Геттеры
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public boolean isAlive() { return isAlive; }
    public int getPositionX() { return positionX; }
    public int getPositionY() { return positionY; }
    public int getDamage() { return damage; }
    public int getDefence() { return defence; }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health + "/" + maxHealth +
                ", alive=" + isAlive +
                ", pos=(" + positionX + "," + positionY + ")" +
                ", damage=" + damage +
                ", defence=" + defence +
                '}';
    }
}

// Класс Mage
class Mage extends Player implements SpellCaster {
    private int spellPower;

    public Mage(String name) {
        super(name, 80, 25, 5);
        this.spellPower = 30;
    }

    @Override
    public void castSpell(Player target) {
        if (!isAlive) {
            System.out.println(name + " мертв и не может колдовать!");
            return;
        }
        if (!target.isAlive()) {
            System.out.println("Нельзя атаковать мертвого " + target.getName());
            return;
        }
        System.out.println(name + " использует атакующее заклинание на " + target.getName() + "!");
        target.decreaseHealth(spellPower);
    }

    @Override
    public String toString() {
        return "Mage{" + super.toString().substring(6) + ", spellPower=" + spellPower + '}';
    }
}

// Класс Priest
class Priest extends Player implements Healer {
    private int healPower;

    public Priest(String name) {
        super(name, 70, 10, 8);
        this.healPower = 25;
    }

    @Override
    public void heal(Player target) {
        if (!isAlive) {
            System.out.println(name + " мертв и не может лечить!");
            return;
        }
        if (target.isAlive()) {
            System.out.println(name + " лечит " + target.getName() + "!");
            target.increaseHealth(healPower);
        } else {
            System.out.println("Нельзя лечить мертвого " + target.getName());
        }
    }

    @Override
    public String toString() {
        return "Priest{" + super.toString().substring(6) + ", healPower=" + healPower + '}';
    }
}

// Базовый класс Warrior
abstract class Warrior extends Player implements Attacker {
    protected int attackPower;

    public Warrior(String name) {
        super(name, 100, 20, 15);
        this.attackPower = 25;
    }

    @Override
    public void attack(Player target) {
        if (!isAlive) {
            System.out.println(name + " мертв и не может атаковать!");
            return;
        }
        if (!target.isAlive()) {
            System.out.println("Нельзя атаковать мертвого " + target.getName());
            return;
        }
        System.out.println(name + " атакует " + target.getName() + "!");
        target.decreaseHealth(attackPower);
    }

    @Override
    public String toString() {
        return "Warrior{" + super.toString().substring(6) + ", attackPower=" + attackPower + '}';
    }
}

// Подкласс Guard (Tank)
class WarriorGuard extends Warrior {
    private int additionalDefence = 10;

    public WarriorGuard(String name) {
        super(name);
    }

    @Override
    public void decreaseHealth(int value) {
        int totalDefence = defence + additionalDefence;
        health = health + totalDefence - value;
        if (health <= 0) {
            health = 0;
            isAlive = false;
            System.out.println(name + " (Танк) погиб! Дополнительная защита: " + additionalDefence);
        } else {
            System.out.println(name + " (Танк) получил " + value + " урона. " +
                    "Общая защита: " + totalDefence + ". Здоровье: " + health);
        }
    }

    @Override
    public String toString() {
        return "WarriorGuard{" + super.toString().substring(7) + ", additionalDefence=" + additionalDefence + '}';
    }
}