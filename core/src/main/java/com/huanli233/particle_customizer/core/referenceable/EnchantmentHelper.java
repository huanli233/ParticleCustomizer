package com.huanli233.particle_customizer.core.referenceable;

import net.labymod.api.client.entity.Entity;
import net.labymod.api.reference.annotation.Referenceable;

@Referenceable
public interface EnchantmentHelper {

  float getModifierForCreature(Entity entity);

}
