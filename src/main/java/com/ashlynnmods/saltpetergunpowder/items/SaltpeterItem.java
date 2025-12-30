package com.ashlynnmods.saltpetergunpowder.items;


import java.util.function.Function;

import com.ashlynnmods.saltpetergunpowder.SaltpeterGunpowder;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

public class SaltpeterItem {
	public static final Item SALTPETER = register("saltpeter", Item::new, new Item.Properties());

	public static void initialize() {
		// Get the event for modifying entries in the ingredients group.
		// And register an event handler that adds our suspicious item to the ingredients group.
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
			.register((itemGroup) -> itemGroup.accept(SaltpeterItem.SALTPETER));
	}

	public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
		// Create the item key.
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(SaltpeterGunpowder.MOD_ID, name));

		// Create the item instance.
		GenericItem item = itemFactory.apply(settings.setId(itemKey));

		// Register the item.
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		return item;
	}
}