package com.btaarmor.mixin;

import com.btaarmor.client.ArmorStatsRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.screen.ScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.callback.CallbackInfo;

@Mixin(HandledScreen.class)
public abstract class HandledScreenMixin<T extends ScreenHandler> {
    
    @Inject(method = "render", at = @At("TAIL"))
    private void onRender(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        // Mostra la HUD solo nell'inventario del giocatore
        HandledScreen<?> screen = (HandledScreen<?>) (Object) this;
        
        if (screen instanceof InventoryScreen) {
            MinecraftClient client = MinecraftClient.getInstance();
            
            if (client.player != null) {
                int screenWidth = screen.width;
                int screenHeight = screen.height;
                
                ArmorStatsRenderer.renderArmorStats(context, screenWidth, screenHeight, client);
            }
        }
    }
}
