package org.agmas.mixin;

import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
//? if >=26.3
//import net.minecraft.world.item.component.SwingAnimation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.agmas.Quartermaster;
import org.agmas.init.ModEffects;
import org.agmas.init.ModEnchants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class ShieldBashMixin extends Entity {


    @Shadow
    public abstract ItemStack getUseItem();


    //? if >=1.21.11 {
    @Shadow
    public abstract ItemStack getItemBlockingWith();
    //? } else {

    /*@Unique
    public ItemStack getItemBlockingWith() {
        if (getUseItem().is(Items.SHIELD)) {
            return getUseItem();
        }
        return null;
    }
    *///? }

    public ShieldBashMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    //? if <26.3 {
    @Inject(method = "swing(Lnet/minecraft/world/InteractionHand;Z)V", at = @At("HEAD"))
    public void alwaysDisarmed(InteractionHand interactionHand, boolean bl, CallbackInfo ci) {
        Quartermaster.shieldBash((LivingEntity) (Object)this);
    }
    //? }


}
