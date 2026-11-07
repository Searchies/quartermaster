package org.agmas.init;

//? if >=1.21.11 {
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
//? }
import org.agmas.porting.QMIdentifier;

public class ModGameRule {
    //? if >=1.21.11 {
    public static final GameRule<Boolean> ALLOW_ITEM_INTERACTIONS_WHEN_DISARMED = GameRuleBuilder
            .forBoolean(true)
            .category(GameRuleCategory.PLAYER)
            .buildAndRegister(QMIdentifier.of("allow_item_interactions_when_disarmed").id);
    //? }

    public static void init() {}
}
