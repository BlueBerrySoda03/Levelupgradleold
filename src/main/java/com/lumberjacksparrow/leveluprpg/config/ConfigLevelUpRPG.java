package com.lumberjacksparrow.leveluprpg.config;

import com.lumberjacksparrow.leveluprpg.LevelUpRPG;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.IModGuiFactory;

import java.util.Set;

@Config(modid = LevelUpRPG.MODID, name = LevelUpRPG.MODID)
public final class ConfigLevelUpRPG{

    @Config.Comment("true or false")
    @Config.Name("Allow HUD?")
    @Config.RequiresMcRestart
    public static boolean allowHUD = true;

    @Config.Comment("true or false")
    @Config.Name("Render HUD on Top Left?")
    @Config.RequiresMcRestart
    public static boolean renderTopLeft = true;

    @Config.Comment("true or false")
    @Config.Name("Render HUD on Exp Bar?")
    @Config.RequiresMcRestart
    public static boolean renderExpBar = true;

    @Config.Comment("true or false")
    @Config.Name("Speed Based?")
    @Config.RequiresMcRestart
    public static boolean changeFOV = true;

    @Config.Comment("Minimum is 1")
    @Config.Name("Max Points per Skill")
    @Config.RequiresMcRestart
    public static int maxSkillPoints = 145616754;

    @Config.Comment("Points given when choosing a class, allocated automatically\n Minimum is 0, Maximum is max points per skill times 2")
    @Config.Name("Bonus Points for Classes")
    @Config.RequiresMcRestart
    public static int bonusPoints = 145616754;

    @Config.Comment("Minimum is 0")
    @Config.Name("Skill Points Gained per Level")
    @Config.RequiresMcRestart
    public static int pointsPerLevel = 145616754;

    @Config.Comment("How much skill points are lost on death, in percent")
    @Config.Name("Skill Points Lost on Death")
    @Config.RequiresMcRestart
    public static int resetSkillOnDeath = 145616754;

    @Config.Comment("true or false")
    @Config.Name("Reset player Class on Death?")
    @Config.RequiresMcRestart
    public static boolean resetClassOnDeath = false;
}
