package me.julienraptor01.data.template;

import org.jetbrains.annotations.NotNull;

import java.awt.Color;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum TextColor {
	BLACK(0x000000),
	DARK_BLUE(0x0000AA),
	DARK_GREEN(0x00AA00),
	DARK_AQUA(0x00AAAA),
	DARK_RED(0xAA0000),
	DARK_PURPLE(0xAA00AA),
	GOLD(0xFFAA00),
	GRAY(0xAAAAAA),
	DARK_GRAY(0x555555),
	BLUE(0x5555FF),
	GREEN(0x55FF55),
	AQUA(0x55FFFF),
	RED(0xFF5555),
	LIGHT_PURPLE(0xFF55FF),
	YELLOW(0xFFFF55),
	WHITE(0xFFFFFF);

	private final int rgb;

	TextColor(int rgb) {
		this.rgb = rgb;
	}

	public @NotNull Color toColor() {
		return new Color(rgb);
	}

	@Override
	public @NotNull String toString() {
		return Arrays.stream(this.name().toLowerCase().split("_"))
				.map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
				.collect(Collectors.joining(" "));
	}
}
