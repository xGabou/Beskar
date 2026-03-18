package net.Gabou.beskar.client.model;

import net.Gabou.beskar.Beskar;
import net.Gabou.beskar.item.BeskarArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BeskarArmorModel extends GeoModel<BeskarArmorItem> {
    @Override
    public ResourceLocation getModelResource(BeskarArmorItem animatable) {
        return new ResourceLocation(Beskar.MODID, "geo/beskar_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BeskarArmorItem animatable) {
        // Uses a vanilla armor texture so the template works without custom png files.
        return new ResourceLocation("minecraft", "textures/models/armor/netherite_layer_1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BeskarArmorItem animatable) {
        return new ResourceLocation(Beskar.MODID, "animations/beskar_armor.animation.json");
    }
}

