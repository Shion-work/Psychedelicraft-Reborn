package com.beeftaquitos.psychedelicraft.sound;

import com.beeftaquitos.psychedelicraft.Psychedelicraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Psychedelicraft.MOD_ID);

    //item sounds

    //block sounds
    public static final RegistryObject<SoundEvent> MOGUS_BREAK = registerSoundEvent("mogus_break");
    public static final RegistryObject<SoundEvent> MOGUS_STEP = registerSoundEvent("mogus_step");
    public static final RegistryObject<SoundEvent> MOGUS_PLACE = registerSoundEvent("mogus_place");
    public static final RegistryObject<SoundEvent> MOGUS_HIT = registerSoundEvent("mogus_hit");
    public static final RegistryObject<SoundEvent> MOGUS_FALL = registerSoundEvent("mogus_fall");

    //discs
    public static final RegistryObject<SoundEvent> MOGUS_TRAP = registerSoundEvent("mogus_trap");
    public static final RegistryObject<SoundEvent> SBOB = registerSoundEvent("sbob");
    public static final RegistryObject<SoundEvent> ENJOY_MINECRAFT = registerSoundEvent("enjoy_minecraft");


    public static final ForgeSoundType MOGUS_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.MOGUS_BREAK, ModSounds.MOGUS_STEP, ModSounds.MOGUS_PLACE, ModSounds.MOGUS_HIT, ModSounds.MOGUS_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Psychedelicraft.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
