package com.huanli233.particle_customizer.v1_8_9;

import com.huanli233.particle_customizer.core.referenceable.EnchantmentHelper;
import net.labymod.api.client.entity.Entity;
import net.labymod.api.models.Implements;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import javax.inject.Singleton;

@Singleton
@Implements(EnchantmentHelper.class)
public class VersionedEnchantmentHelper implements EnchantmentHelper {

  @Override
  public float getModifierForCreature(Entity entity) {
    return net.minecraft.enchantment.EnchantmentHelper.getModifierForCreature(Minecraft.getMinecraft().thePlayer.getHeldItem(), ((EntityLivingBase) entity).getCreatureAttribute());
  }

}
