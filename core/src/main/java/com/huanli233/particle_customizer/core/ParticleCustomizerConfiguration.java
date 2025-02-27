package com.huanli233.particle_customizer.core;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;

@ConfigName("settings")
public class ParticleCustomizerConfiguration extends AddonConfig {

  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @SwitchSetting
  private final ConfigProperty<Boolean> alwaysSharpness = new ConfigProperty<>(false);

  @SwitchSetting
  private final ConfigProperty<Boolean> alwaysCriticals = new ConfigProperty<>(false);

  @SliderSetting(min = 1, max = 10)
  public final ConfigProperty<Integer> sharpnessAmount = new ConfigProperty<>(1);

  @SliderSetting(min = 1, max = 10)
  public final ConfigProperty<Integer> criticalsAmount = new ConfigProperty<>(1);

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }

  public boolean alwaysSharpness() {
    return this.alwaysSharpness.getOrDefault(false);
  }

  public boolean alwaysCriticals() {
    return this.alwaysCriticals.getOrDefault(false);
  }
}
