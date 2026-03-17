package combat_engine_v1.action;

import combat_engine_v1.character.Characters;
import combat_engine_v1.ui.Ui;

public class ActionLogic {
    Ui ui = new Ui();

    public int basicAttack(Characters user, Characters oppenent) {
        int damage = 0;
        int end = user.getEND();
        if (end > 0) {
            damage = (((user.getAtk() + (int) (Math.random() * 10)) - (oppenent.getDef() / 2)));
            if (damage <= 0) {
                damage = 1;
            }
            String message = user.getClass().getSimpleName()+" deals "+damage+" damage!";
            ui.redMessage(message);
        } else {
           ui.yellowMessage("Low stamina!");
        }
        user.subEND(1);
        return damage;
    }

    public int doge(Characters user, Characters oppenent, int damage) {
        int doneDamage = 0, usedEND = 0;
        int end = user.getEND();
        if (end > 0) {
            if (user.getDex() < oppenent.getDex()) {
                String message = user.getClass().getSimpleName() + "'s block failed!";
                ui.redMessage(message);
                doneDamage = damage;
                usedEND = 1;
            } else if (user.getDex() > oppenent.getDex() && user.getDef() > oppenent.getAtk()) {
                String message = user.getClass().getSimpleName() + " took 50% reduced damage!";
                ui.redMessage(message);
                doneDamage = damage / 2;
                usedEND = 1;
            } else {
                String message = user.getClass().getSimpleName() + " successfully blocked the attack!";
                ui.greenMessage(message);
                doneDamage = 0;
                usedEND = 2;
            }
            user.subEND(usedEND);
        }
        return doneDamage;
    }

    public int block(Characters user, Characters opponent, int damage) {
        int doneDamage = 0, usedEND = 0;
        int end = user.getEND();
        if (end > 0) {
            if (user.getDef() > opponent.getAtk()) {
                String message = user.getClass().getSimpleName() + " Block succesfully";
                ui.greenMessage(message);
                doneDamage = damage / 2;
            } else {
                String message = user.getClass().getSimpleName() + " failed to block the attack!";
                ui.redMessage(message);
                doneDamage = damage;
            }
            user.subEND(usedEND);
        }
        return doneDamage;
    }
}
