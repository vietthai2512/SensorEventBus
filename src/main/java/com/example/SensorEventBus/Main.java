package com.example.SensorEventBus;

import com.example.SensorEventBus.verticles.HeatSensor;
import com.example.SensorEventBus.verticles.HttpServer;
import com.example.SensorEventBus.verticles.Listener;
import com.example.SensorEventBus.verticles.SensorData;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class Main {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(HeatSensor.class.getCanonicalName(), new DeploymentOptions().setInstances(4));
    vertx.deployVerticle(Listener.class.getCanonicalName());
    vertx.deployVerticle(SensorData.class.getCanonicalName());
    vertx.deployVerticle(HttpServer.class.getCanonicalName());
  }
}
