package me.julienraptor01.data.template;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

public enum Rarity {
	COMMON(TextColor.WHITE),
	UNCOMMON(TextColor.GREEN),
	RARE(TextColor.BLUE),
	EPIC(TextColor.DARK_PURPLE),
	LEGENDARY(TextColor.GOLD),
	MYTHIC(TextColor.LIGHT_PURPLE),
	DIVINE(TextColor.AQUA),
	SPECIAL(TextColor.RED),
	VERY_SPECIAL(TextColor.RED),
	ULTIMATE(TextColor.DARK_RED),
	ADMIN(TextColor.DARK_RED);

	private final TextColor textColor;

	Rarity(TextColor textColor) {
		this.textColor = textColor;
	}

	public @NotNull Color toColor() {
		return this.textColor.toColor();
	}

	@Override
	public @NotNull String toString() {
		return this.name().replaceAll("_", " ");
	}
}
