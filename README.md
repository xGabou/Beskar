# Beskar GeckoLib Template (Forge 1.20.1)

This project now includes a template armor set and tool set for Minecraft 1.20.1 with GeckoLib.

## Included template content

- GeckoLib setup in `build.gradle`
- Beskar armor items (`helmet`, `chestplate`, `leggings`, `boots`) using a GeckoLib armor renderer
- Beskar tools (`sword`, `pickaxe`, `axe`, `shovel`, `hoe`) with a custom tier
- Beskar spear item (`beskar_spear`) based on trident behavior (throw + loyalty retrieval + melee)
- Blaster-style damage immunity when wearing a full Beskar armor set
- Creative tab: `Beskar`
- Minimal language + item models + GeckoLib `geo` and `animation` template files

## Important template files

- `src/main/java/net/Gabou/beskar/registry/ModItems.java`
- `src/main/java/net/Gabou/beskar/registry/ModCreativeTabs.java`
- `src/main/java/net/Gabou/beskar/registry/ModToolTiers.java`
- `src/main/java/net/Gabou/beskar/item/BeskarArmorItem.java`
- `src/main/java/net/Gabou/beskar/item/BeskarSpearItem.java`
- `src/main/java/net/Gabou/beskar/event/BeskarCombatEvents.java`
- `src/main/java/net/Gabou/beskar/client/model/BeskarArmorModel.java`
- `src/main/java/net/Gabou/beskar/client/renderer/BeskarArmorRenderer.java`
- `src/main/resources/assets/beskar/geo/beskar_armor.geo.json`
- `src/main/resources/assets/beskar/animations/beskar_armor.animation.json`

## Next customization steps

1. Replace the vanilla texture references with your own textures.
2. Export a GeckoLib armor model from Blockbench and overwrite `beskar_armor.geo.json`.
3. Add real animation tracks to `beskar_armor.animation.json`.
4. Tune armor/tool stats in `ModItems.java` and `ModToolTiers.java`.
5. Add crafting recipes and tags via data generation.

