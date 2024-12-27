package com.lumberjacksparrow.leveluprpg.item;

import com.lumberjacksparrow.leveluprpg.LevelUpRPG;
import com.lumberjacksparrow.leveluprpg.event.FMLEventHandler;
import com.lumberjacksparrow.leveluprpg.player.PlayerExtendedProperties;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemRespecBook extends Item {
    public ItemRespecBook(String name) {
        setRegistryName(name);
        setUnlocalizedName(LevelUpRPG.MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
        setHasSubtypes(true);
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        if (!world.isRemote) {
            PlayerExtendedProperties.getClassOfPlayer(player).refundSkillPoints(true, player);
            FMLEventHandler.INSTANCE.loadPlayer(player);
        }
        if (!player.capabilities.isCreativeMode)
            itemstack.shrink(1);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
