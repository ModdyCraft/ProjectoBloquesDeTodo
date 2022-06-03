
package mc.moddycraft.alltheblocksforeverything.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.state.properties.SlabType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import mc.moddycraft.alltheblocksforeverything.AllTheBlocksForEverythingModElements;

import java.util.List;
import java.util.Collections;

@AllTheBlocksForEverythingModElements.ModElement.Tag
public class GoldaSlabBlock extends AllTheBlocksForEverythingModElements.ModElement {
	@ObjectHolder("all_the_blocks_for_everything:golda_slab")
	public static final Block block = null;

	public GoldaSlabBlock(AllTheBlocksForEverythingModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends SlabBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(3f, 30f).setLightLevel(s -> 0).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("golda_slab");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}
	}
}
