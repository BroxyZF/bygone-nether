package com.izofar.bygonenether;

import com.izofar.bygonenether.init.*;
import com.izofar.bygonenether.util.ModStructureUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BygoneNetherMod.MODID)
public class BygoneNetherMod
{
    public static final String MODID = "bygonenether";
    public static final Logger LOGGER = LogManager.getLogger();

    public BygoneNetherMod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModStructures.register(eventBus);
        ModSensorTypes.register(eventBus);
        ModMemoryModuleTypes.register(eventBus);
        ModFeatures.register(eventBus);
        ModSounds.register(eventBus);

        eventBus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModProcessors.registerProcessors();
            ModFeatures.registerPlacedFeatures();
            ModStructureUtils.addBasaltRestrictions();
            ModEntityTypes.modifyPiglinMemoryAndSensors();
            ModTags.initTags();
        });
    }

}
