package net.backupcup.everlasting.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.projectile.TridentEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TridentEntity.class)
public abstract class TridentEntityMixin {

    @Shadow private boolean dealtDamage;

    @Inject(
            method = "tick",
            at = @At("HEAD")
    )
    private void loyaltyVoid(CallbackInfo ci) {
        if (((TridentEntity)(Object)this).getY() <= -48 && EnchantmentHelper.getLevel(Enchantments.LOYALTY, ((TridentEntity)(Object)this).getItemStack()) > 0) {
            dealtDamage = true;
        }
    }
}
