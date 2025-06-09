package chips.chipsfixes.mixin.astralsorcery;

import hellfirepvp.astralsorcery.common.base.TileAccelerationBlacklist;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.sci.torcherino.blocks.tiles.TileTorcherino;

/**
 * @author Chips
 * 放置时钟座加速加速火把,虽然星辉配置文件也能改,但是懒得改
 */
@Mixin(value = TileAccelerationBlacklist.class,remap = false)
public abstract class ChipsTileAccelerationBlacklist {

    @Inject(
            method = "canAccelerate",
            at = @At("HEAD"),
            cancellable = true,
            require = 0
    )
    private static void canAccelerate(TileEntity te, CallbackInfoReturnable<Boolean> cir) {
        // 直接不能加速加速火把,哈哈
        if (te instanceof TileTorcherino){
            cir.setReturnValue(false);
        }
    }
}
