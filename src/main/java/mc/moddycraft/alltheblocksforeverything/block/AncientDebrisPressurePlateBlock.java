
package mc.moddycraft.alltheblocksforeverything.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import mc.moddycraft.alltheblocksforeverything.AllTheBlocksForEverythingModElements;

import java.util.List;
import java.util.Collections;

@AllTheBlocksForEverythingModElements.ModElement.Tag
public class AncientDebrisPressurePlateBlock extends AllTheBlocksForEverythingModElements.ModElement {
	@ObjectHolder("all_the_blocks_for_everything:ancient_debris_pressure_plate")
	public static final Block block = null;

	public AncientDebrisPressurePlateBlock(AllTheBlocksForEverythingModElements instance) {
		super(instance, 214);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends PressurePlateBlock {
		public CustomBlock() {
			super(Sensitivity.MOBS, Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(30f, 0f).setLightLevel(s -> 0)
					.harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("ancient_debris_pressure_plate");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
