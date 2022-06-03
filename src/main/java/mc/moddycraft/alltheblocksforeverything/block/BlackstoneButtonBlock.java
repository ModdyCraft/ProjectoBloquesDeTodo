
package mc.moddycraft.alltheblocksforeverything.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import mc.moddycraft.alltheblocksforeverything.AllTheBlocksForEverythingModElements;

import java.util.List;
import java.util.Collections;

@AllTheBlocksForEverythingModElements.ModElement.Tag
public class BlackstoneButtonBlock extends AllTheBlocksForEverythingModElements.ModElement {
	@ObjectHolder("all_the_blocks_for_everything:blackstone_button")
	public static final Block block = null;

	public BlackstoneButtonBlock(AllTheBlocksForEverythingModElements instance) {
		super(instance, 291);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StoneButtonBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 3f).setLightLevel(s -> 0).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("blackstone_button");
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
