package com.lumberjacksparrow.leveluprpg;

import com.lumberjacksparrow.leveluprpg.event.FMLEventHandler;
import com.lumberjacksparrow.leveluprpg.event.PlayerEventHandler;
import com.lumberjacksparrow.leveluprpg.player.IPlayerClass;
import com.lumberjacksparrow.leveluprpg.player.PlayerExtendedProperties;
import com.lumberjacksparrow.leveluprpg.proxy.ClientProxy;
import com.lumberjacksparrow.leveluprpg.proxy.CommonProxy;
import com.lumberjacksparrow.leveluprpg.util.handlers.SkillPacketHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.logging.Logger;

@Mod(modid = LevelUpRPG.MODID, name = LevelUpRPG.NAME, version = LevelUpRPG.VERSION)
public class LevelUpRPG {
    public static final String MODID = "leveluprpg";
    public static final String NAME = "Level Up: RPG";
    public static final String VERSION = "1.0.0";
    public static final String CLIENT_PROXY = "com.lumberjacksparrow.leveluprpg.proxy.ClientProxy";
    public static final String COMMON_PROXY = "com.lumberjacksparrow.leveluprpg.proxy.CommonProxy";
    //private static final String guiFactory = ;
    //guiFactory = guiFactory
//    private static Configuration config;
//    private Property[] clientProperties;
//    private Property[] serverProperties;
//    public static boolean allowHUD = true, renderTopLeft = true, renderExpBar = true, changeFOV = true;
    public static FMLEventChannel initChannel, skillChannel, classChannel, configChannel;

    @Mod.Instance
    public static LevelUpRPG instance;

    @SidedProxy
            (clientSide = CLIENT_PROXY,
            serverSide = COMMON_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        ClientProxy.preInitClient(event);
        CommonProxy.preInitCommon(event);
//        initClientProperties();
//        initServerProperties();
//        useServerProperties();
        CapabilityManager.INSTANCE.register(IPlayerClass.class, new com.lumberjacksparrow.leveluprpg.capabilities.LevelUpCapability.CapabilityPlayerClass<IPlayerClass>(), PlayerExtendedProperties.class);
        CapabilityManager.INSTANCE.register(com.lumberjacksparrow.leveluprpg.api.IProcessor.class, new com.lumberjacksparrow.leveluprpg.capabilities.LevelUpCapability.CapabilityProcessorClass<com.lumberjacksparrow.leveluprpg.api.IProcessor>(), com.lumberjacksparrow.leveluprpg.capabilities.LevelUpCapability.CapabilityProcessorDefault.class);
        if (event.getSourceFile().getName().endsWith(".jar")) {
            proxy.tryUseMUD();
        }
        MinecraftForge.EVENT_BUS.register(FMLEventHandler.INSTANCE);
        MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        ClientProxy.initClient(event);
        CommonProxy.initCommon(event);
        Logger logger = Logger.getLogger("leveluprpg");
        logger.info("[Level Up] registering events");

        logger.info("[Level Up] registering packets");
        SkillPacketHandler sk = new SkillPacketHandler();
        initChannel = NetworkRegistry.INSTANCE.newEventDrivenChannel(SkillPacketHandler.CHAN[0]);
        initChannel.register(sk);
        classChannel = NetworkRegistry.INSTANCE.newEventDrivenChannel(SkillPacketHandler.CHAN[1]);
        classChannel.register(sk);
        skillChannel = NetworkRegistry.INSTANCE.newEventDrivenChannel(SkillPacketHandler.CHAN[2]);
        skillChannel.register(sk);
        configChannel = NetworkRegistry.INSTANCE.newEventDrivenChannel(SkillPacketHandler.CHAN[3]);
        configChannel.register(sk);
        logger.info("[Level Up] registering clientside stuff");
        CommonProxy.registerGui();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        ClientProxy.postInitClient(event);
        CommonProxy.postInitCommon(event);
    }

    public static int getVitality(EntityPlayer player) {
        return PlayerExtendedProperties.getSkillFromIndex(player, 0);
    }

    public static int getMight(EntityPlayer player) {
        return PlayerExtendedProperties.getSkillFromIndex(player, 1);
    }

    public static int getFinesse(EntityPlayer player) {
        return PlayerExtendedProperties.getSkillFromIndex(player, 2);
    }

    public static int getFocus(EntityPlayer player) {
        return PlayerExtendedProperties.getSkillFromIndex(player, 3);
    }

    public static int getStealth(EntityPlayer player) {
        return PlayerExtendedProperties.getSkillFromIndex(player, 4);
    }

    public static int getLuck(EntityPlayer player) {
        return PlayerExtendedProperties.getSkillFromIndex(player, 6);
    }
}
