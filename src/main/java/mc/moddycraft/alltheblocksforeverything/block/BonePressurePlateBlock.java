
package mc.moddycraft.alltheblocksforeverything.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
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
public class BonePressurePlateBlock extends AllTheBlocksForEverythingModElements.ModElement {
	@ObjectHolder("all_the_blocks_for_everything:bone_pressure_plate")
	public static final Block block = null;

	public BonePressurePlateBlock(AllTheBlocksForEverythingModElements instance) {
		super(instance, 52);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends PressurePlateBlock {
		public CustomBlock() {
			super(Sensitivity.MOBS,
					Block.Properties.create(Material.CLAY).sound(SoundType.BONE).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));
			setRegistryName("bone_pressure_plate");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 25;
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
