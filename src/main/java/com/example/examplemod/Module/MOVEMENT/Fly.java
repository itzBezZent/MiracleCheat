package com.example.examplemod.Module.MOVEMENT;

import com.example.examplemod.Module.Module;

import org.lwjgl.input.Keyboard;

public class Fly extends Module {

    public Fly() {

        super("Fly", Keyboard.KEY_F, Category.MOVEMENT);

    }

    @Override

    public void onEnable() {

        mc.player.capabilities.isFlying = true;

        mc.player.capabilities.allowFlying = true;

    }

    @Override

    public void onDisable() {

        mc.player.capabilities.isFlying = false;

        mc.player.capabilities.allowFlying = false;

    }

}