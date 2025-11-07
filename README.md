# BTA Armor System Mod

Questa mod porta il sistema di armature di Better Than Adventure in Minecraft 1.21.5 usando Fabric Loader 0.17.3.

## Caratteristiche

- **HUD nell'Inventario**: Mostra le statistiche dell'armatura in tempo reale quando apri l'inventario
- **Statistiche Complete**:
  - Armor (Protezione)
  - Armor Toughness (Resistenza)
  - Knockback Resistance (Resistenza ai Contraccolpi)
  - Movement Speed (Velocità di Movimento)
  - Attack Speed (Velocità d'Attacco)
  - Attack Damage (Danno d'Attacco)

- **Colori Distintivi**: Ogni statistica ha un colore unico per una facile lettura
- **Aggiornamento Dinamico**: Le statistiche si aggiornano in tempo reale quando cambi armatura

## Installazione

1. Assicurati di avere **Minecraft 1.21.5** installato
2. Scarica e installa **Fabric Loader 0.17.3** da [fabricmc.net](https://fabricmc.net)
3. Scarica **Fabric API** per Minecraft 1.21.5
4. Copia il file `.jar` della mod nella cartella `mods` del tuo profilo Minecraft
5. Avvia Minecraft con il profilo Fabric

## Compilazione

Per compilare la mod dal codice sorgente:

```bash
# Windows
gradlew.bat build

# Linux/Mac
./gradlew build
```

Il file JAR compilato si troverà in `build/libs/`

## Come Funziona

La mod utilizza:
- **Mixins** per iniettare codice nel rendering dell'inventario
- **Fabric API** per accedere agli attributi del giocatore
- **Rendering personalizzato** per mostrare le statistiche in un pannello elegante

## Compatibilità

- Minecraft: 1.21.5
- Fabric Loader: 0.17.3+
- Java: 21+
- Fabric API: Richiesto

## Licenza

MIT License - Sentiti libero di modificare e distribuire!

## Crediti

Ispirato dal sistema di armature di Better Than Adventure (BTA)
