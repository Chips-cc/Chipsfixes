package chips.chipsfixes.mixin.astralsorcery;

import hellfirepvp.astralsorcery.common.item.crystal.CrystalProperties;
import hellfirepvp.astralsorcery.common.util.CrystalCalculations;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * @author Chips
 * 修复了纯度高于100计算损耗会导致一直增幅的问题,超频直接玩不了嘻嘻
 */
@Mixin(value = CrystalCalculations.class,remap = false)
public class ChipsCrystalCalculations {

    /**
     * @author Chips
     * @reason 这个公式会导致纯度大于100就增幅
     */
    @Overwrite
    public static float getThroughputMultiplier(CrystalProperties properties) {
        // 现在永远不会大于1了嘿嘿
        return (float) Math.min(Math.sqrt((((float) properties.getPurity()) / 100)),1);
    }
}
