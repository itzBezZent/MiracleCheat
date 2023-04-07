package com.example.examplemod.UI;
import com.example.examplemod.Client;
import com.example.examplemod.Module.Module;
import font.FontUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.Objects;

import static net.minecraft.client.gui.Gui.drawRect;
public class ui {
    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post e) {
        switch (e.getType()) {
            case TEXT:
                int y = 10;
                final int[] counter = {1};
                Minecraft mc = Minecraft.getMinecraft();
                FontRenderer fr = mc.fontRenderer;
                ScaledResolution sr = new ScaledResolution(mc);

                drawRect(5,5,200,14, new Color(0x151515).hashCode());
                drawRect(5,5,200,4, rainbow(300));

                try {
                    FontUtils.normal.drawString(Client.cName + "§f | " + mc.getSession().getUsername() + " | " + Objects.requireNonNull(mc.getCurrentServerData()).serverIP +
                                    " | FPS: §a" + Minecraft.getDebugFPS() + "§f | Ping: §a" + mc.getCurrentServerData().pingToServer,
                            10, 10, -1);
                } catch (Exception ex) {
                    FontUtils.normal.drawString(Client.cName + "§f | " + mc.getSession().getUsername() + " | FPS: §a" + Minecraft.getDebugFPS(), 10, 10, -1);
                }

                /*
                fr.drawString("Miracle§aClient §fB§a0.0.1", 5, 5, -1);
                fr.drawString("§fFPS: §a" + Minecraft.getDebugFPS(), 5, 15, -1);
                */

                for (Module module : Client.modules) {
                    if (module.toggled) {
                        Gui.drawRect(sr.getScaledWidth(), y, sr.getScaledWidth() - 2,
                                y + 10, rainbow(counter[0] * 300));
                        fr.drawStringWithShadow(module.name, sr.getScaledWidth() - 4 - fr.getStringWidth(module.name),
                                y, rainbow(counter[0] * 300));
                        y += 10;
                        counter[0]++;
                    }
                }
            default:
                break;
        }
    }
    public static int rainbow(int delay) {
        double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}