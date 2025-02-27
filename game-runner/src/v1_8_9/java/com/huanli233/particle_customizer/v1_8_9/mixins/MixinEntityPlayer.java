package com.huanli233.particle_customizer.v1_8_9.mixins;

import com.huanli233.particle_customizer.core.ParticleCustomizerAddon;
import com.huanli233.particle_customizer.core.events.AttackEntityEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer {

  @Inject(method = "attackTargetEntityWithCurrentItem", at = @At("HEAD"))
  private void injectAttackTargetEntityWithCurrentItem(Entity lvt_1_1_, CallbackInfo ci) {
    if (lvt_1_1_.canAttackWithItem()) {
      ParticleCustomizerAddon.get().checkAndShowParticle(new AttackEntityEvent((net.labymod.api.client.entity.Entity) lvt_1_1_));
    }
  }

}
