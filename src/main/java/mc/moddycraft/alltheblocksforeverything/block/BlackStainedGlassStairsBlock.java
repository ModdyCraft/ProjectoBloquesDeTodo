
package mc.moddycraft.alltheblocksforeverything.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import mc.moddycraft.alltheblocksforeverything.AllTheBlocksForEverythingModElements;

import java.util.List;
import java.util.Collections;

@AllTheBlocksForEverythingModElements.ModElement.Tag
public class BlackStainedGlassStairsBlock extends AllTheBlocksForEverythingModElements.ModElement {
	@ObjectHolder("all_the_blocks_for_everything:black_stained_glass_stairs")
	public static final Block block = null;

	public BlackStainedGlassStairsBlock(AllTheBlocksForEverythingModElements instance) {
		super(instance, 362);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.GLASS).sound(SoundType.GLASS).hardnessAndResistance(0.3f, 0f).setLightLevel(s -> 0)
					.slipperiness(0.7999999999999999f).notSolid().setOpaque((bs, br, bp) -> false)).getDefaultState(),
					Block.Properties.create(Material.GLASS).sound(SoundType.GLASS).hardnessAndResistance(0.3f, 0f).setLightLevel(s -> 0)
							.slipperiness(0.7999999999999999f).notSolid().setOpaque((bs, br, bp) -> false));
			setRegistryName("black_stained_glass_stairs");
		}

		@Override
		public float[] getBeaconColorMultiplier(BlockState state, IWorldReader world, BlockPos pos, BlockPos beaconPos) {
			return new float[]{0f, 0f, 0f};
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
