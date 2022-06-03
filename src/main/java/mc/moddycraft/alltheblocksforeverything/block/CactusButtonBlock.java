
package mc.moddycraft.alltheblocksforeverything.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.Material;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import mc.moddycraft.alltheblocksforeverything.procedures.CactusStairsEntityCollidesInTheBlockProcedure;
import mc.moddycraft.alltheblocksforeverything.AllTheBlocksForEverythingModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

@AllTheBlocksForEverythingModElements.ModElement.Tag
public class CactusButtonBlock extends AllTheBlocksForEverythingModElements.ModElement {
	@ObjectHolder("all_the_blocks_for_everything:cactus_button")
	public static final Block block = null;

	public CactusButtonBlock(AllTheBlocksForEverythingModElements instance) {
		super(instance, 386);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StoneButtonBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.CACTUS).sound(SoundType.PLANT).hardnessAndResistance(0.4f, 2f).setLightLevel(s -> 0));
			setRegistryName("cactus_button");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void onEntityCollision(BlockState blockstate, World world, BlockPos pos, Entity entity) {
			super.onEntityCollision(blockstate, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			CactusStairsEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		@Override
		public ActionResultType onBlockActivated(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, Hand hand,
				BlockRayTraceResult hit) {
			super.onBlockActivated(blockstate, world, pos, entity, hand, hit);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			double hitX = hit.getHitVec().x;
			double hitY = hit.getHitVec().y;
			double hitZ = hit.getHitVec().z;
			Direction direction = hit.getFace();

			CactusStairsEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ActionResultType.SUCCESS;
		}
	}
}
