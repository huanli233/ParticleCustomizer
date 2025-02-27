package com.huanli233.particle_customizer.core.referenceable;

import com.huanli233.particle_customizer.core.component.ParticleType;
import net.labymod.api.client.entity.Entity;
import net.labymod.api.reference.annotation.Referenceable;

@Referenceable
public interface ParticleHelper {

  void showParticle(Entity entity, ParticleType type);

  boolean checkCritical();

}