package io.github.thebusybiscuit.ecopower.generators;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

/**
 * This is the multiblock variant of the {@link SteamTurbine}, as shown in the {@link SlimefunGuide}.
 * 
 * @author TheBusyBiscuit
 *
 */
public class SteamTurbineMultiblock extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {

    public SteamTurbineMultiblock(ItemGroup itemGroup, SlimefunItemStack item, SteamTurbine turbine) {
        super(itemGroup, item, RecipeType.MULTIBLOCK, new ItemStack[] {
                null, turbine.getItem(), null,
                null, new CustomItemStack(Material.WATER_BUCKET, "&f水 (需含有气泡)"), null,
                null, new ItemStack(Material.MAGMA_BLOCK), null
        });
    }

    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
            e.cancel();
            e.getPlayer().sendMessage("你需要按照指南中所示的结构搭建这个多方块结构的发电机!");
        };
    }

}
