package com.huanli233.particle_customizer.core;

import com.huanli233.particle_customizer.core.component.ParticleType;
import com.huanli233.particle_customizer.core.events.AttackEntityEvent;
import com.huanli233.particle_customizer.core.generated.*;
import com.huanli233.particle_customizer.core.referenceable.EnchantmentHelper;
import com.huanli233.particle_customizer.core.referenceable.ParticleHelper;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class ParticleCustomizerAddon extends LabyAddon<ParticleCustomizerConfiguration> {

  private static ParticleCustomizerAddon instance;

  public ParticleCustomizerAddon() {
    instance = this;
  }

  public static ParticleCustomizerAddon get() {
    return instance;
  }

  @Override
  protected void enable() {
    this.registerSettingCategory();
  }

  @Override
  protected Class<ParticleCustomizerConfiguration> configurationClass() {
    return ParticleCustomizerConfiguration.class;
  }

  public void checkAndShowParticle(AttackEntityEvent event) {
    if (!configuration().enabled().getOrDefault(false)) return;
    DefaultReferenceStorage storage = referenceStorageAccessor();
    ParticleHelper particleHelper = storage.particleHelper();
    EnchantmentHelper enchantmentHelper = storage.enchantmentHelper();
    boolean critical = configuration().alwaysCriticals() || particleHelper.checkCritical();
    boolean sharpness = configuration().alwaysSharpness() || enchantmentHelper.getModifierForCreature(event.entity()) > 0;
    if (critical) {
      for (int i = 0; i < configuration().criticalsAmount.getOrDefault(1); i++) {
        particleHelper.showParticle(event.entity(), ParticleType.CRIT);
      }
    }
    if (sharpness) {
      for (int i = 0; i < configuration().sharpnessAmount.getOrDefault(1); i++) {
        particleHelper.showParticle(event.entity(), ParticleType.CRIT_MAGIC);
      }
    }
  }

}
