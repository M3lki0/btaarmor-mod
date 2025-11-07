package com.btaarmor.armor;

import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.HashMap;
import java.util.Map;

public class ArmorStatsCalculator {
    
    public static class ArmorStats {
        public double armor;
        public double armorToughness;
        public double knockbackResistance;
        public double movementSpeed;
        public double attackSpeed;
        public double attackDamage;
        
        public ArmorStats() {
            this.armor = 0;
            this.armorToughness = 0;
            this.knockbackResistance = 0;
            this.movementSpeed = 0;
            this.attackSpeed = 0;
            this.attackDamage = 0;
        }
    }
    
    public static ArmorStats calculateArmorStats(PlayerEntity player) {
        ArmorStats stats = new ArmorStats();
        
        // Calcola gli attributi base del giocatore
        stats.movementSpeed = player.getAttributeValue(EntityAttributes.MOVEMENT_SPEED);
        stats.attackSpeed = player.getAttributeValue(EntityAttributes.ATTACK_SPEED);
        stats.attackDamage = player.getAttributeValue(EntityAttributes.ATTACK_DAMAGE);
        
        // Itera attraverso tutti i pezzi di armatura equipaggiati
        for (ItemStack armorStack : player.getArmorItems()) {
            if (armorStack.isEmpty()) continue;
            
            if (armorStack.getItem() instanceof ArmorItem armorItem) {
                // Ottieni gli attributi dell'armatura
                var attributes = armorStack.getAttributeModifiers();
                
                attributes.modifiers().forEach((registryEntry, modifier) -> {
                    EntityAttribute attribute = registryEntry.value();
                    
                    if (attribute == EntityAttributes.ARMOR) {
                        stats.armor += modifier.value();
                    } else if (attribute == EntityAttributes.ARMOR_TOUGHNESS) {
                        stats.armorToughness += modifier.value();
                    } else if (attribute == EntityAttributes.KNOCKBACK_RESISTANCE) {
                        stats.knockbackResistance += modifier.value();
                    }
                });
            }
        }
        
        return stats;
    }
    
    // Metodo per calcolare la riduzione del danno basata sull'armatura
    public static double calculateDamageReduction(double armor, double toughness, double damage) {
        // Formula di Minecraft per la riduzione del danno
        double defensePoints = Math.min(20, Math.max(armor / 5, armor - damage / (2 + toughness / 4)));
        return defensePoints / 25.0;
    }
    
    // Metodo per ottenere il colore dell'attributo (per la visualizzazione)
    public static int getAttributeColor(String attributeName) {
        return switch (attributeName.toLowerCase()) {
            case "armor" -> 0x99CCFF; // Blu chiaro
            case "toughness" -> 0xFF9933; // Arancione
            case "knockback" -> 0x66FF66; // Verde chiaro
            case "speed" -> 0xFFFF66; // Giallo
            case "attack_speed" -> 0xFF6666; // Rosso chiaro
            case "damage" -> 0xFF3333; // Rosso
            default -> 0xFFFFFF; // Bianco
        };
    }
}
