package com.beeftaquitos.psychedelicraft.recipe;
import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Psychedelicraft.MOD_ID);

    public static final RegistryObject<RecipeSerializer<DryingTableRecipe>> DRYING_SERIALIZER =
            SERIALIZERS.register("drying", () -> DryingTableRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<ShroomBoxRecipe>> JUICING_SERIALIZER =
            SERIALIZERS.register("juicing", () -> ShroomBoxRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<DistilleryRecipe>> DISTILLING_SERIALIZER =
            SERIALIZERS.register("distilling", () -> DistilleryRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}