# Guida alla Compilazione

## Prerequisiti

1. **Java Development Kit (JDK) 21** o superiore
   - Scarica da: https://adoptium.net/ (Eclipse Temurin)
   - Verifica con: `java -version`

2. **Git** (opzionale, ma raccomandato)

## Passaggi per Compilare

### 1. Preparazione

Apri il terminale nella cartella del progetto:

```bash
cd C:\MinecraftMods\BTA-Armor-Mod
```

### 2. Compila la Mod

**Windows:**
```bash
gradlew.bat build
```

**Linux/Mac:**
```bash
./gradlew build
```

### 3. Trova il File JAR

Dopo la compilazione, il file JAR sarà in:
```
build/libs/bta-armor-mod-1.0.0.jar
```

## Test in Ambiente di Sviluppo

Per testare la mod senza compilare:

**Avvia il client Minecraft:**
```bash
gradlew.bat runClient
```

**Avvia il server dedicato:**
```bash
gradlew.bat runServer
```

## Risoluzione Problemi

### Errore: "JAVA_HOME not set"
Imposta la variabile d'ambiente JAVA_HOME:
- Windows: `set JAVA_HOME=C:\Path\To\JDK`
- Linux/Mac: `export JAVA_HOME=/path/to/jdk`

### Errore: "Could not find fabric-loom"
Gradle scaricherà automaticamente tutte le dipendenze alla prima esecuzione. Assicurati di avere una connessione internet attiva.

### La mod non appare in Minecraft
1. Verifica che Fabric Loader 0.17.3 sia installato
2. Controlla che Fabric API sia presente nella cartella mods
3. Verifica che il file JAR sia nella cartella mods corretta

### Errori di compilazione
Pulisci e ricompila:
```bash
gradlew.bat clean build
```

## Personalizzazione

### Cambiare la versione della mod
Modifica `gradle.properties`:
```properties
mod_version=1.0.0
```

### Cambiare colori delle statistiche
Modifica `ArmorStatsCalculator.java`, metodo `getAttributeColor()`:
```java
case "armor" -> 0x99CCFF; // Formato: 0xRRGGBB
```

### Modificare posizione del pannello
Modifica `ArmorStatsRenderer.java`:
```java
int panelX = screenWidth / 2 + 90; // Cambia questi valori
int panelY = screenHeight / 2 - 80;
```

## Supporto

Per problemi o domande, apri una issue sul repository GitHub.
