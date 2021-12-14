package com.example.SensorEventBus.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;


public class Listener extends AbstractVerticle {
  private final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
  private final DecimalFormat format = new DecimalFormat("#.##");

  @Override
  public void start() throws Exception {
    EventBus bus = vertx.eventBus();
    bus.<JsonObject>consumer("sensor.updates", msg -> {
      JsonObject body = msg.body();
      String id = body.getString("id");
      String temperature = format.format(body.getDouble("temp"));
      LOGGER.info("{} reports a temperature ~{}C", id, temperature);
    });
  }
}
