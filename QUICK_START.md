# 🎮 BTA Armor System Mod - Installazione e Uso

## ✅ Mod Completata!

La mod è stata creata con successo in: `C:\MinecraftMods\BTA-Armor-Mod`

---

## 📋 Cosa Include la Mod

### Caratteristiche Principali
✨ **HUD nell'Inventario** - Pannello che mostra le statistiche in tempo reale
🛡️ **Sistema Armature BTA** - Calcolo completo degli attributi
🎨 **Colori Distintivi** - Ogni statistica ha il suo colore unico
⚡ **Aggiornamento Dinamico** - Le stats cambiano quando cambi armatura

### Statistiche Visualizzate
- **Armor** (Protezione) - Colore: Blu chiaro
- **Toughness** (Resistenza) - Colore: Arancione  
- **Knockback Resistance** (Resistenza Contraccolpi) - Colore: Verde
- **Movement Speed** (Velocità Movimento) - Colore: Giallo
- **Attack Speed** (Velocità Attacco) - Colore: Rosso chiaro
- **Attack Damage** (Danno Attacco) - Colore: Rosso

---

## 🚀 Come Compilare la Mod

### Prerequisiti
1. **Java 21** o superiore ([Scarica qui](https://adoptium.net/))
2. **Connessione Internet** (per scaricare le dipendenze)

### Passo 1: Apri il Terminale
```bash
cd C:\MinecraftMods\BTA-Armor-Mod
```

### Passo 2: Compila
```bash
gradlew.bat build
```

### Passo 3: Trova il JAR
Il file compilato sarà in:
```
build/libs/bta-armor-mod-1.0.0.jar
```

---

## 📦 Come Installare in Minecraft

### 1. Installa Fabric
- Vai su [fabricmc.net](https://fabricmc.net/use/installer/)
- Scarica e avvia l'installer
- Seleziona **Minecraft 1.21.5** e **Fabric Loader 0.17.3**
- Clicca "Install"

### 2. Installa Fabric API
- Vai su [modrinth.com/mod/fabric-api](https://modrinth.com/mod/fabric-api)
- Scarica la versione per **1.21.5**
- Metti il file nella cartella `mods`

### 3. Installa la Mod BTA Armor
- Copia `bta-armor-mod-1.0.0.jar` nella cartella `mods`
- Posizione: `%appdata%\.minecraft\mods\`

### 4. Avvia Minecraft
- Apri il launcher
- Seleziona il profilo **Fabric**
- Clicca "Play"!

---

## 🎯 Come Usare la Mod

1. **Avvia il gioco** con il profilo Fabric
2. **Entra in un mondo** (Singolo o Multiplayer)
3. **Premi E** per aprire l'inventario
4. **Guarda in alto a destra** - vedrai il pannello con le tue stats!
5. **Equipaggia armatura** - le statistiche si aggiorneranno in tempo reale

---

## 🎨 Personalizzazione

### Cambiare i Colori
Modifica il file: `src/main/java/com/btaarmor/armor/ArmorStatsCalculator.java`

```java
public static int getAttributeColor(String attributeName) {
    return switch (attributeName.toLowerCase()) {
        case "armor" -> 0x99CCFF;      // Cambia qui!
        case "toughness" -> 0xFF9933;  // Formato: 0xRRGGBB
        // ... altri colori
    };
}
```

### Cambiare Posizione del Pannello
Modifica il file: `src/main/java/com/btaarmor/client/ArmorStatsRenderer.java`

```java
int panelX = screenWidth / 2 + 90;  // Modifica X
int panelY = screenHeight / 2 - 80; // Modifica Y
```

### Cambiare Dimensioni
Sempre in `ArmorStatsRenderer.java`:

```java
private static final int PANEL_WIDTH = 120;  // Larghezza
private static final int PANEL_HEIGHT = 90;  // Altezza
```

---

## 🐛 Risoluzione Problemi

### La mod non appare in gioco
✅ Verifica che Fabric Loader 0.17.3 sia installato
✅ Controlla che Fabric API sia nella cartella mods
✅ Assicurati che il JAR sia in `%appdata%\.minecraft\mods\`

### Errori di compilazione
Pulisci e ricompila:
```bash
gradlew.bat clean build
```

### Java non trovato
Installa Java 21 da [adoptium.net](https://adoptium.net/) e riavvia il terminale

### Il pannello non si vede
La HUD appare solo nell'**inventario del giocatore** (E), non in chest o altri container

---

## 📁 Struttura del Progetto

```
BTA-Armor-Mod/
├── src/main/
│   ├── java/com/btaarmor/
│   │   ├── BTAArmorMod.java           # Entry point principale
│   │   ├── BTAArmorModClient.java      # Entry point client
│   │   ├── armor/
│   │   │   └── ArmorStatsCalculator.java  # Calcolo statistiche
│   │   ├── client/
│   │   │   └── ArmorStatsRenderer.java    # Rendering HUD
│   │   └── mixin/
│   │       └── HandledScreenMixin.java    # Iniezione nel rendering
│   └── resources/
│       ├── fabric.mod.json            # Configurazione mod
│       └── btaarmor.mixins.json       # Configurazione mixins
├── build.gradle                        # Configurazione build
├── gradle.properties                   # Proprietà progetto
└── README.md                          # Documentazione
```

---

## 🔧 Test in Sviluppo

Per testare senza compilare ogni volta:

```bash
# Avvia client di test
gradlew.bat runClient

# Avvia server di test  
gradlew.bat runServer
```

---

## 📖 File Utili

- **README.md** - Documentazione completa
- **BUILD_GUIDE.md** - Guida dettagliata alla compilazione
- **CHANGELOG.md** - Storico delle versioni
- **QUICK_START.md** - Questa guida rapida!

---

## 🌟 Caratteristiche Tecniche

- ✅ **Mixins** per iniezione pulita del codice
- ✅ **Sistema modulare** per facile estensione
- ✅ **Performance ottimizzate** - calcolo efficiente
- ✅ **Compatibilità completa** con Fabric API
- ✅ **Codice pulito** e ben commentato
- ✅ **Supporto completo** per tutti i tipi di armatura

---

## 💡 Suggerimenti

### Per Giocatori
- Le statistiche vengono calcolate in tempo reale
- Funziona con qualsiasi armatura vanilla o modata
- Il pannello appare solo nell'inventario personale
- I colori aiutano a identificare rapidamente le stats

### Per Developer
- Il codice è ben strutturato per modifiche
- I Mixins sono minimamente invasivi
- Facile aggiungere nuove statistiche
- Sistema estendibile per futuri aggiornamenti

---

## 🎉 Buon Divertimento!

La mod è pronta all'uso. Compila, installa e goditi il sistema di armature di Better Than Adventure in Minecraft 1.21.5!

**Domande o problemi?** Controlla i file di documentazione o apri una issue.

---

*Creato con ❤️ per la community di Minecraft Fabric*
