package com.btaarmor;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BTAArmorMod implements ModInitializer {
    public static final String MOD_ID = "bta-armor-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("BTA Armor System initialized!");
    }
}
