package techreborn.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import techreborn.Core;
import techreborn.client.GuiHandler;
import techreborn.tiles.TileCentrifuge;

public class BlockCentrifuge extends BlockContainer {

	 @SideOnly(Side.CLIENT)
	 private IIcon top;
	 @SideOnly(Side.CLIENT)
	 private IIcon other;
	    
    public BlockCentrifuge() {
        super(Material.piston);
        setHardness(2F);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileCentrifuge();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!player.isSneaking())
            player.openGui(Core.INSTANCE, GuiHandler.centrifugeID, world, x, y, z);
        return true;
    }
    

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        top = icon.registerIcon("techreborn:machine/industrial_grinder_top_on");
        other = icon.registerIcon("techreborn:machine/machine_side");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int currentSide, int meta) {
        if (currentSide == 1) {
            return top;
        } else {
            return other;
        }
    }

}
