package com.btaarmor;

import com.btaarmor.client.ArmorStatsRenderer;
import net.fabricmc.api.ClientModInitializer;

public class BTAArmorModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BTAArmorMod.LOGGER.info("BTA Armor System client initialized!");
    }
}
