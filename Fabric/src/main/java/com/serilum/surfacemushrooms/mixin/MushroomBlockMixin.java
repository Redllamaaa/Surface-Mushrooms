package com.serilum.surfacemushrooms.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MushroomBlock.class)
public class MushroomBlockMixin {
	@Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
	private void allowSurfaceMushrooms(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		if (level.getBlockState(pos.below()).isSolidRender()) {
			cir.setReturnValue(true);
		}
	}
}
