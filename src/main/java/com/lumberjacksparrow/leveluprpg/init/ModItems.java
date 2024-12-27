package com.lumberjacksparrow.leveluprpg.init;

import com.lumberjacksparrow.leveluprpg.item.ItemFullRespecBook;
import com.lumberjacksparrow.leveluprpg.item.ItemRespecBook;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class ModItems {

    public static ItemRespecBook respecBook;
    public static ItemFullRespecBook respecBookFull;

    public static void init() {
        respecBook = new ItemRespecBook("respec_book");
        respecBookFull = new ItemFullRespecBook("respec_book_full");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().register(respecBook);
        event.getRegistry().register(respecBookFull);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(respecBook);
        registerRender(respecBookFull);
    }

    private static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
}
