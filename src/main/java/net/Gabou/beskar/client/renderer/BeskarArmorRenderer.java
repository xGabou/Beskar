package net.Gabou.beskar.client.renderer;

import net.Gabou.beskar.client.model.BeskarArmorModel;
import net.Gabou.beskar.item.BeskarArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BeskarArmorRenderer extends GeoArmorRenderer<BeskarArmorItem> {
    public BeskarArmorRenderer() {
        super(new BeskarArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}

