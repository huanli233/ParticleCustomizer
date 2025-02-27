package com.huanli233.particle_customizer.v1_8_9;

import com.huanli233.particle_customizer.core.component.ParticleType;
import com.huanli233.particle_customizer.core.referenceable.ParticleHelper;
import com.huanli233.particle_customizer.v1_8_9.utils.Cast;
import net.labymod.api.client.entity.Entity;
import net.labymod.api.models.Implements;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;

@Implements(ParticleHelper.class)
public class VersionedParticleHelper implements ParticleHelper {

  @Override
  public void showParticle(Entity entity, ParticleType type) {
    Minecraft.getMinecraft().effectRenderer.emitParticleAtEntity(Cast.cast(entity), Cast.toMinecraftParticleType(type));
  }

  @Override
  public boolean checkCritical() {
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
    return player.fallDistance > 0.0F && !player.onGround && !player.isOnLadder() && !player.isInWater() && !player.isPotionActive(
        Potion.blindness) && player.ridingEntity == null;
  }
}
