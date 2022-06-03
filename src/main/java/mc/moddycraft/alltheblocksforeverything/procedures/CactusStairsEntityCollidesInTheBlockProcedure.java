package mc.moddycraft.alltheblocksforeverything.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import mc.moddycraft.alltheblocksforeverything.AllTheBlocksForEverythingMod;

import java.util.Map;

public class CactusStairsEntityCollidesInTheBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AllTheBlocksForEverythingMod.LOGGER.warn("Failed to load dependency entity for procedure CactusStairsEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.CACTUS, (float) 1);
	}
}
