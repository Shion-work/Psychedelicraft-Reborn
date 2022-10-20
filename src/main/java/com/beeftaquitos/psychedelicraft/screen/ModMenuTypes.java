package com.beeftaquitos.psychedelicraft.screen;
import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, Psychedelicraft.MOD_ID);

    public static final RegistryObject<MenuType<DryingTableMenu>> DRYING_TABLE_MENU =
            registerMenuType(DryingTableMenu::new, "drying_table_menu");

    public static final RegistryObject<MenuType<ShroomBoxMenu>> SHROOM_BOX_MENU =
            registerMenuType(ShroomBoxMenu::new, "shroom_box_menu");

    public static final RegistryObject<MenuType<DistilleryMenu>> DISTILLERY_MENU =
            registerMenuType(DistilleryMenu::new, "distillery_menu");

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                 String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}