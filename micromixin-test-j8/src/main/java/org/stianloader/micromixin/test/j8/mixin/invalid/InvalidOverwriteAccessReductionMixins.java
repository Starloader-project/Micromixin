package org.stianloader.micromixin.test.j8.mixin.invalid;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.stianloader.micromixin.test.j8.targets.invalid.InvalidOverwriteAccessReduction;

@Mixin(InvalidOverwriteAccessReduction.class)
public class InvalidOverwriteAccessReductionMixins {

    @Overwrite
    private void callMethod() {}
}
