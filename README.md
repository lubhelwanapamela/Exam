# 🏕 Campsite Commander

An Android inventory app built with **Kotlin** in Android Studio for managing camping gear and food supplies.

## Features

| Screen | Description |
|--------|-------------|
| **Splash Screen** | Displays logo & title for 3 seconds, then transitions to Main |
| **Main Screen** | Shows Total Items Packed (loop-calculated) + navigation buttons |
| **Add Gear Screen** | Form with input validation to add new gear items |
| **Detailed View Screen** | Full scrollable list with Item, Category, Quantity & Notes |

## Tech Highlights

- **Parallel Arrays** — `itemNames`, `categories`, `quantities`, `comments` stored in `GearData` singleton
- **Loops** — Total items calculated by looping through the quantities array
- **Screen Navigation** — `Intent`-based navigation with a "Back to Base" button on every sub-screen
- **Error Handling** — Input validation with inline error messages on all fields
- **Dark / Nature Theme** — Custom colour palette (midnight blue, forest green, earth brown)

## Sample Data (Pre-loaded)

| Item | Category | Qty | Notes |
|------|----------|-----|-------|
| Tent | Shelter | 1 | 4-person waterproof |
| Marshmallows | Food | 3 | For S'mores (Mega size) |
| Flashlight | Safety | 2 | Check batteries (AA) |
| First Aid Kit | First Aid | 1 | Include bandages and antiseptic |
| Sleeping Bag | Shelter | 2 | Rated -5°C |
| Water Bottle | Cooking | 4 | 1L stainless steel |

## Project Structure

```
CampsiteCommander/
├── app/src/main/
│   ├── java/com/campsite/commander/
│   │   ├── SplashActivity.kt       ← 3-second splash
│   │   ├── MainActivity.kt         ← Main hub + total counter
│   │   ├── AddGearActivity.kt      ← Add items with validation
│   │   ├── DetailedViewActivity.kt ← Full gear list
│   │   └── GearData.kt             ← Parallel arrays data store
│   ├── res/layout/
│   │   ├── activity_splash.xml
│   │   ├── activity_main.xml
│   │   ├── activity_add_gear.xml
│   │   └── activity_detailed_view.xml
│   └── AndroidManifest.xml
└── README.md
```

## How to Run

1. Clone this repo in Android Studio
2. Sync Gradle
3. Run on an emulator or physical device (minSdk 24)
