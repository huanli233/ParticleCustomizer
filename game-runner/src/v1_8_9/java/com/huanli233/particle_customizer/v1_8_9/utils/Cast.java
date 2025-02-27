package com.huanli233.particle_customizer.v1_8_9.utils;

import com.huanli233.particle_customizer.core.component.ParticleType;
import net.minecraft.util.EnumParticleTypes;

public class Cast {

  @SuppressWarnings("unchecked")
  public static <T> T cast(Object object) {
    return (T) object;
  }

  public static EnumParticleTypes toMinecraftParticleType(ParticleType type) {
    return EnumParticleTypes.valueOf(type.name());
  }

}
