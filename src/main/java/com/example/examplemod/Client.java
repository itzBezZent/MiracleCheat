package com.example.examplemod;
import com.example.examplemod.Module.COMBAT.TriggerBot;
import com.example.examplemod.Module.EXPLOIT.FakeCreative;
import com.example.examplemod.Module.MOVEMENT.Fly;
import com.example.examplemod.Module.MOVEMENT.Sprint;
import com.example.examplemod.Module.Module;
import com.example.examplemod.Module.PLAYER.BlockReach;
import com.example.examplemod.Module.RENDER.GlowESP;
import com.example.examplemod.Module.RENDER.Tracers;
import font.FontUtils;
import me.bushroot.clickgui.ClickGuiScreen;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.opengl.Display;
import sun.font.FontUtilities;

import java.util.concurrent.CopyOnWriteArrayList;

public class Client {

    public static String name = "MiracleClient 1.12.2";

    public static String cName = "Miracle§aClient §fB§aA0.0.2";

    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
    public static ClickGuiScreen clickGui;

    public static void startup() {

        Display.setTitle(name);

        modules.add(new BlockReach());

        modules.add(new TriggerBot());

        modules.add(new GlowESP());

        modules.add(new Sprint());

        modules.add(new Fly());

        modules.add(new FakeCreative());

        modules.add(new Tracers());



        clickGui = new ClickGuiScreen();

        FontUtils.bootstrap();


    }

    public static void keyPress(int key) {

        for (Module m : modules) {

            if (m.getKey() == key) {

                m.toggle();

            }

        }

    }

}