package com.btaarmor.client;

import com.btaarmor.armor.ArmorStatsCalculator;
import com.btaarmor.armor.ArmorStatsCalculator.ArmorStats;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

public class ArmorStatsRenderer {
    
    private static final int PANEL_WIDTH = 120;
    private static final int PANEL_HEIGHT = 90;
    private static final int PADDING = 5;
    private static final int LINE_HEIGHT = 10;
    
    public static void renderArmorStats(DrawContext context, int screenWidth, int screenHeight, MinecraftClient client) {
        ClientPlayerEntity player = client.player;
        if (player == null) return;
        
        // Calcola le statistiche dell'armatura
        ArmorStats stats = ArmorStatsCalculator.calculateArmorStats(player);
        
        // Posiziona il pannello nell'angolo in alto a destra dell'inventario
        int panelX = screenWidth / 2 + 90;
        int panelY = screenHeight / 2 - 80;
        
        // Disegna lo sfondo del pannello
        context.fill(panelX, panelY, panelX + PANEL_WIDTH, panelY + PANEL_HEIGHT, 0xCC000000);
        
        // Disegna il bordo
        context.fill(panelX, panelY, panelX + PANEL_WIDTH, panelY + 1, 0xFF555555);
        context.fill(panelX, panelY + PANEL_HEIGHT - 1, panelX + PANEL_WIDTH, panelY + PANEL_HEIGHT, 0xFF555555);
        context.fill(panelX, panelY, panelX + 1, panelY + PANEL_HEIGHT, 0xFF555555);
        context.fill(panelX + PANEL_WIDTH - 1, panelY, panelX + PANEL_WIDTH, panelY + PANEL_HEIGHT, 0xFF555555);
        
        TextRenderer textRenderer = client.textRenderer;
        int yOffset = panelY + PADDING;
        
        // Titolo
        Text title = Text.literal("Armor Stats");
        context.drawText(textRenderer, title, panelX + PADDING, yOffset, 0xFFFFFF, true);
        yOffset += LINE_HEIGHT + 3;
        
        // Armatura
        Text armorText = Text.literal("Armor: " + String.format("%.1f", stats.armor));
        context.drawText(textRenderer, armorText, panelX + PADDING, yOffset, 
            ArmorStatsCalculator.getAttributeColor("armor"), false);
        yOffset += LINE_HEIGHT;
        
        // Toughness
        Text toughnessText = Text.literal("Toughness: " + String.format("%.1f", stats.armorToughness));
        context.drawText(textRenderer, toughnessText, panelX + PADDING, yOffset, 
            ArmorStatsCalculator.getAttributeColor("toughness"), false);
        yOffset += LINE_HEIGHT;
        
        // Knockback Resistance
        Text knockbackText = Text.literal("KB Resist: " + String.format("%.1f%%", stats.knockbackResistance * 100));
        context.drawText(textRenderer, knockbackText, panelX + PADDING, yOffset, 
            ArmorStatsCalculator.getAttributeColor("knockback"), false);
        yOffset += LINE_HEIGHT;
        
        // Movement Speed
        Text speedText = Text.literal("Speed: " + String.format("%.2f", stats.movementSpeed));
        context.drawText(textRenderer, speedText, panelX + PADDING, yOffset, 
            ArmorStatsCalculator.getAttributeColor("speed"), false);
        yOffset += LINE_HEIGHT;
        
        // Attack Speed
        Text attackSpeedText = Text.literal("Atk Speed: " + String.format("%.2f", stats.attackSpeed));
        context.drawText(textRenderer, attackSpeedText, panelX + PADDING, yOffset, 
            ArmorStatsCalculator.getAttributeColor("attack_speed"), false);
        yOffset += LINE_HEIGHT;
        
        // Attack Damage
        Text damageText = Text.literal("Damage: " + String.format("%.1f", stats.attackDamage));
        context.drawText(textRenderer, damageText, panelX + PADDING, yOffset, 
            ArmorStatsCalculator.getAttributeColor("damage"), false);
    }
}
