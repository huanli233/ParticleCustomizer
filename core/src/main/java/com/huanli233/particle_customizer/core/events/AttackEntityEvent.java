package com.huanli233.particle_customizer.core.events;

import net.labymod.api.client.entity.Entity;
import net.labymod.api.event.Event;

public class AttackEntityEvent implements Event {

  private final Entity entity;

  public AttackEntityEvent(Entity entity) {
    this.entity = entity;
  }

  public Entity entity() {
    return entity;
  }
}