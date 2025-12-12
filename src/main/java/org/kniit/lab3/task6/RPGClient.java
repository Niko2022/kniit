package org.kniit.lab3.task6;
interface Attacker {
    void attack(Player target);
}

// Интерфейс для исцеляющих способностей
interface Healer {
    void heal(Player target);
}

// Интерфейс для магических атак
interface SpellCaster {
    void castSpell(Player target);
}

public class RPGClient {
    public static void main(String[] args) {
        System.out.println("=== Классическая 2D RPG симуляция ===\n");

        // Создание персонажей
        WarriorGuard warrior = new WarriorGuard("Страж");
        Mage mage = new Mage("Маг");
        Priest priest = new Priest("Целитель");

        System.out.println("Персонажи созданы:");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);
        System.out.println();

        // Перемещение персонажей
        warrior.moveTo(5, 3);
        mage.moveTo(2, 7);
        priest.moveTo(4, 4);
        System.out.println();

        // Бой
        System.out.println("=== БОЙ НАЧИНАЕТСЯ ===\n");
        warrior.attack(mage);
        System.out.println("Состояние после атаки воина:");
        System.out.println(mage + "\n");

        mage.castSpell(warrior);
        System.out.println("Состояние после заклинания мага:");
        System.out.println(warrior + "\n");

        priest.heal(mage);
        System.out.println("Состояние после лечения священником:");
        System.out.println(mage + "\n");

        // Финальное состояние
        System.out.println("=== ФИНАЛЬНОЕ СОСТОЯНИЕ ===");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);
    }
}