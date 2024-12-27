package com.lumberjacksparrow.leveluprpg.proxy;

import com.lumberjacksparrow.leveluprpg.event.LevelUpMenuKeyHandler;
import com.lumberjacksparrow.leveluprpg.gui.LevelUpHUD;
import com.lumberjacksparrow.leveluprpg.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void tryUseMUD() {
    }

    public static void registerGui() {
        MinecraftForge.EVENT_BUS.register(LevelUpHUD.INSTANCE);
        FMLCommonHandler.instance().bus().register(LevelUpMenuKeyHandler.INSTANCE);
    }

    public EntityPlayer getPlayer() {
        return null;
    }

    public static void preInitCommon(FMLPreInitializationEvent event){
        ModItems.init();
    }

    public static void initCommon(FMLInitializationEvent event){
    }

    public static void postInitCommon(FMLPostInitializationEvent event){

    }
}
