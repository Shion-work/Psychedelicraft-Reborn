package com.beeftaquitos.psychedelicraft.effect;

import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Psychedelicraft.MOD_ID);

    public static final RegistryObject<MobEffect> FREEZE = MOB_EFFECTS.register("freeze",
            () -> new FreezeEffect(MobEffectCategory.HARMFUL, 3212123));

    public static final RegistryObject<MobEffect> CANNABIS_EFFECT = MOB_EFFECTS.register("cannabis_effect",
            () -> new CannabisEffect(MobEffectCategory.HARMFUL, 331111));

    public static final RegistryObject<MobEffect> TEST_EFFECT = MOB_EFFECTS.register("test_effect",
            () -> new TestEffect(MobEffectCategory.HARMFUL, 334411));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
