package com.example.examplemod;

import com.example.examplemod.Module.COMBAT.TriggerBot;
import com.example.examplemod.Module.MOVEMENT.Fly;

import com.example.examplemod.Module.MOVEMENT.Sprint;

import com.example.examplemod.Module.Module;

import com.example.examplemod.Module.PLAYER.BlockReach;
import me.bushroot.clickgui.ClickGuiScreen;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.opengl.Display;

import java.util.concurrent.CopyOnWriteArrayList;

public class Client {

    public static String name = "MiracleClient 1.12.2";

    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
    public static ClickGuiScreen clickGui;

    public static void startup() {

        Display.setTitle(name);

        modules.add(new BlockReach());

        modules.add(new TriggerBot());

        modules.add(new Sprint());

        modules.add(new Fly());

        clickGui = new ClickGuiScreen();

    }

    public static void keyPress(int key) {

        for (Module m : modules) {

            if (m.getKey() == key) {

                m.toggle();

            }

        }

    }

}