package com.izofar.bygonenether.client.model;

import com.izofar.bygonenether.entity.WarpedEndermanEntity;
import net.minecraft.client.renderer.entity.model.EndermanModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class WarpedEndermanModel extends EndermanModel<WarpedEndermanEntity> {

    private final ModelRenderer stemBody;

    public WarpedEndermanModel(float scale) {
        super(scale);
        this.stemBody = new ModelRenderer(this);
        stemBody.setPos(0.0F, 39.0F, 0.0F);
        body.addChild(stemBody);
        stemBody.texOffs(42, 0).addBox(-10.0F, -54.0F, -0.5F, 6.0F, 15.0F, 1.0F, 0.0F, false);

        ModelRenderer stemArm = new ModelRenderer(this);
        stemArm.setPos(-5.0F, 37.0F, 0.0F);
        leftArm.addChild(stemArm);
        stemArm.texOffs(35, 0).addBox(6.0F, -38.0F, -0.5F, 6.0F, 15.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(WarpedEndermanEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch){
        super.setupAnim(pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
        float f3 = pAgeInTicks / 60.0F;
        this.stemBody.yRot = ((float)Math.PI / 180F) * MathHelper.sin(f3 * 3.5F) * 5.0F;
    }

}
