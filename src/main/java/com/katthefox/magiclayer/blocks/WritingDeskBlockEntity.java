package com.katthefox.magiclayer.blocks;

import com.katthefox.magiclayer.registries.MagicLayerBlockEntities;
import com.katthefox.magiclayer.tags.MagicLayerTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

public class WritingDeskBlockEntity extends BlockEntity implements Container {

    private ItemStack inventory = ItemStack.EMPTY;

    @Override
    public int getContainerSize() {
        return 1;
    }

    // Whether the container is considered empty.
    @Override
    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    // Return the item stack in the specified slot.
    @Override
    public ItemStack getItem(int slot) {
        return slot == 0 ? inventory : ItemStack.EMPTY;
    }

    // Remove the specified amount of items from the given slot, returning the stack that was just removed.
    // We defer to ContainerHelper here, which does this as expected for us.
    // However, we must call #setChanged manually.
    @Override
    public ItemStack removeItem(int slot, int amount) {
        if (slot != 0) return ItemStack.EMPTY;
        ItemStack stack = inventory.copyWithCount(Math.min(amount, inventory.getCount()));
        inventory.shrink(amount);
        this.setChanged();
        return stack;
    }

    // Remove all items from the specified slot, returning the stack that was just removed.
    // We again defer to ContainerHelper here, and we again have to call #setChanged manually.
    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        if (slot != 0) return ItemStack.EMPTY;
        ItemStack stack = inventory;
        inventory = ItemStack.EMPTY;
        this.setChanged();
        return stack;
    }

    // Set the given item stack in the given slot. Limit to the max stack size of the container first.
    @Override
    public void setItem(int slot, ItemStack stack) {
        if (slot != 0 || !stack.is(MagicLayerTags.PAPER)) return;
        stack.limitSize(this.getMaxStackSize(stack));
        inventory = stack;
        this.setChanged();
    }

    // Whether the container is considered "still valid" for the given player. For example, chests and
    // similar blocks check if the player is still within a given distance of the block here.
    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    // Clear the internal storage, setting all slots to empty again.
    @Override
    public void clearContent() {
        inventory = ItemStack.EMPTY;
        this.setChanged();
    }

    public WritingDeskBlockEntity(BlockPos pos, BlockState state) {
        super(MagicLayerBlockEntities.WRITING_DESK.get(), pos, state);
    }

    // Read values from the passed CompoundTag here.
    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        // Will default to 0 if absent. See the NBT article for more information.
//        this.value = tag.getInt("value");
    }

    // Save values into the passed CompoundTag here.
    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
//        tag.putInt("value", this.value);
    }
}
