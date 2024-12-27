package com.lumberjacksparrow.leveluprpg.proxy;

import com.lumberjacksparrow.leveluprpg.LevelUpRPG;
import com.lumberjacksparrow.leveluprpg.event.LevelUpMenuKeyHandler;
import com.lumberjacksparrow.leveluprpg.gui.LevelUpHUD;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
    @Override
    public void tryUseMUD() {
        try {
            Class.forName("mods.mud.ModUpdateDetector").getDeclaredMethod("registerMod", ModContainer.class, String.class, String.class).invoke(null,
                    FMLCommonHandler.instance().findContainerFor(LevelUpRPG.instance),
                    "https://raw.github.com/GotoLink/LevelUp/master/update.xml",
                    "https://raw.github.com/GotoLink/LevelUp/master/changelog.md"
            );
        } catch (Throwable ignored) {
        }
    }

//    @Override
//    public void registerGui() {
//
//    }

    @Override
    public EntityPlayer getPlayer() {
        return FMLClientHandler.instance().getClient().player;
    }

    public static void preInitClient(FMLPreInitializationEvent event) {

    }

    public static void initClient(FMLInitializationEvent event) {

    }

    public static void postInitClient(FMLPostInitializationEvent event) {

    }
}
