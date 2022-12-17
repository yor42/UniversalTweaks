package mod.acgaming.universaltweaks.mods.biomesoplenty.mixin;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import biomesoplenty.common.fluids.blocks.BlockHotSpringWaterFluid;
import mod.acgaming.universaltweaks.UniversalTweaks;
import mod.acgaming.universaltweaks.config.UTConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockHotSpringWaterFluid.class)
public class UTHotSpringWaterMixin
{
    @Inject(method = "func_180634_a", at = @At(value = "HEAD"), cancellable = true, remap = false)
    public void utHotSpringWater(World world, BlockPos pos, IBlockState state, Entity entity, CallbackInfo ci)
    {
        if (!UTConfig.mods.utBoPHotSpringWaterToggle) return;
        if (UTConfig.debug.utDebugToggle) UniversalTweaks.LOGGER.debug("UTHotSpringWater ::: Check regeneration effect");
        if (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).getActivePotionEffect(MobEffects.REGENERATION) != null) ci.cancel();
    }
}