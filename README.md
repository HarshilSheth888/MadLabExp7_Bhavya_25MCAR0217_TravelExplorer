# Travel Explorer — Experiment 7

An Android application built with **Kotlin and XML Views** that presents three travel destinations in a minimalist, image-led interface. The home screen uses a `ListView` with destination thumbnails; selecting a destination opens a detail screen with a larger `ImageView`, location information, and a back action.

> **Lab experiment:** Create an adaptive UI using `ListView` and `ImageView`.

## Overview

Travel Explorer is a small travel-discovery app for browsing a curated set of destinations. It demonstrates how Android can display a collection of data in a `ListView`, use a custom `BaseAdapter` to create each row, and open a separate Activity when a row is selected.

The sample destinations are:

1. **Cinque Terre, Italy** — coastal villages overlooking the Mediterranean.
2. **Kyoto, Japan** — traditional streets, temples, and culture.
3. **Lauterbrunnen, Switzerland** — an alpine valley surrounded by mountains and waterfalls.

The app uses local drawable resources for images, so destination photographs do not need to be downloaded at runtime.

## Objectives

- Create a scrollable destination list using `ListView`.
- Display a thumbnail with text in each list row using `ImageView` and `TextView`.
- Use a custom `BaseAdapter` to bind destination data to the row layout.
- Open a destination details screen when a list item is tapped.
- Display a larger destination photograph using `ImageView`.
- Use XML layouts and Android resources to maintain a consistent visual theme.
- Keep the interface usable on different screen sizes through flexible layout dimensions and a scrollable details screen.

## Features

- Three destinations displayed on the home screen.
- Destination thumbnail, country, name, and short description in each row.
- Tap a row to open its details.
- Large destination photograph on the details screen.
- Back action to return to the destination list.
- Minimalist blue-grey, white, near-black, and pale-yellow colour palette.
- Local images stored in `res/drawable`.
- No network connection or backend service required for the sample data.

## Technology and Android components

| Technology/component | Purpose |
|---|---|
| Kotlin | Application logic |
| XML Views | Screen and row layouts |
| `MainActivity` | Displays the destination list |
| `DestinationDetailActivity` | Displays the selected destination |
| `ListView` | Shows the scrollable list of destinations |
| `BaseAdapter` | Binds destination data to list rows |
| `ImageView` | Displays list thumbnails and the detail photograph |
| `TextView` | Displays destination names, countries, and descriptions |
| `LinearLayout` | Arranges views vertically or horizontally |
| `ScrollView` | Allows the details content to scroll on smaller screens |
| `Intent` | Passes selected destination information to the detail Activity |
| Drawable resources | Store destination photographs locally |

## UI design

The interface follows the supplied minimalist visual reference.

| Element | Colour |
|---|---|
| Main background | `#CBD5E8` — soft blue-grey |
| Cards and surfaces | `#F8F9FC` — soft white |
| Primary text | `#17191F` — near-black |
| Secondary text | `#626D80` — muted blue-grey |
| Dividers and supporting details | `#DCE2ED` |
| Accent | `#F3D99B` — pale butter yellow |

The home screen displays destinations in clean rows with thumbnails. The detail screen uses a larger image, destination name, country, and description. The design avoids unnecessary visual elements so that the photographs and destination names remain prominent.

## Application flow

```text
MainActivity
    |
    v
ListView of destinations
    |
    | User taps a row
    v
DestinationDetailActivity
    |
    +-- Read destination data from Intent extras
    +-- Display destination name and country
    +-- Display larger ImageView photograph
    |
    v
Back action
    |
    v
MainActivity / destination list
```

## Project structure

The structure below describes the files used by this implementation. Your exact package path may differ if you selected a different package name when creating the project.

```text
TravelExplorer/
├── README.md
├── screenshots/
│   ├── output_home.png
│   ├── output_detail.png
│   ├── test_case_1.png
│   ├── test_case_2.png
│   └── test_case_3.png
└── app/
    └── src/
        └── main/
            ├── AndroidManifest.xml
            ├── java/com/example/travelexplorer/
            │   ├── MainActivity.kt
            │   ├── Destination.kt
            │   ├── DestinationAdapter.kt
            │   └── DestinationDetailActivity.kt
            └── res/
                ├── drawable/
                │   ├── bg_destination_row.xml
                │   ├── cinque_terre.jpg
                │   ├── kyoto.jpg
                │   └── lauterbrunnen.jpg
                ├── layout/
                │   ├── activity_main.xml
                │   ├── item_destination.xml
                │   └── activity_destination_detail.xml
                └── values/
                    └── colors.xml
```

The screenshot filenames are suggested names. Add the actual screenshots you capture from your running app; do not commit placeholder images in their place.

## How the implementation works

### 1. `Destination.kt`

A data class represents a destination. Its fields are `name`, `country`, `description`, and `imageResId`. The image resource ID links the destination to its local drawable photograph.

### 2. `DestinationAdapter.kt`

The custom adapter extends `BaseAdapter`. It reports the number of destinations, returns an item for a position, and inflates `item_destination.xml` for each row. It binds the image resource, destination number, name, and description to the row's views.

The adapter reuses `convertView` when possible, avoiding unnecessary row inflation while scrolling.

### 3. `MainActivity.kt`

`MainActivity` creates the sample destination list, sets `DestinationAdapter` on the `ListView`, and handles row clicks. When a destination is selected, it starts `DestinationDetailActivity` and passes the destination fields through Intent extras.

### 4. `DestinationDetailActivity.kt`

The detail Activity reads the Intent extras and updates its `TextView` and `ImageView` views. Its back control calls `finish()` to return to the previous screen.

### 5. XML layout files

- `activity_main.xml` defines the home screen and its `ListView`.
- `item_destination.xml` defines the appearance of one list row.
- `activity_destination_detail.xml` defines the destination details screen.
- `bg_destination_row.xml` provides the rounded white row background.
- `colors.xml` defines the shared colour palette.

## Setup and execution

### Requirements

- Android Studio.
- A compatible Android emulator or Android device.
- The Android SDK configured by Android Studio.
- The three destination image resources placed in `app/src/main/res/drawable/`.

### Steps

1. Open the `TravelExplorer` project in Android Studio.
2. Wait for Gradle sync to finish.
3. Verify that `cinque_terre`, `kyoto`, and `lauterbrunnen` exist as drawable resources. Android resource filenames should use lowercase letters and underscores.
4. Confirm that `DestinationDetailActivity` is declared in `AndroidManifest.xml`.
5. Select an emulator or connected device.
6. Click **Run**.
7. Tap each destination and verify its details screen and back action.

If the project uses a different package name, make sure each Kotlin file's `package` declaration and the manifest Activity declaration match the project.

## Recording



https://github.com/user-attachments/assets/b38dc9a8-276e-4bb2-8693-90603a941f4d


