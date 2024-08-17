package me.julienraptor01.data.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextColorTest {

	@Test
	void testToString() {
		assertEquals("Black", TextColor.BLACK.toString());
		assertEquals("Dark Blue", TextColor.DARK_BLUE.toString());
		assertEquals("Dark Green", TextColor.DARK_GREEN.toString());
		assertEquals("Dark Aqua", TextColor.DARK_AQUA.toString());
		assertEquals("Dark Red", TextColor.DARK_RED.toString());
		assertEquals("Dark Purple", TextColor.DARK_PURPLE.toString());
		assertEquals("Gold", TextColor.GOLD.toString());
		assertEquals("Gray", TextColor.GRAY.toString());
		assertEquals("Dark Gray", TextColor.DARK_GRAY.toString());
		assertEquals("Blue", TextColor.BLUE.toString());
		assertEquals("Green", TextColor.GREEN.toString());
		assertEquals("Aqua", TextColor.AQUA.toString());
		assertEquals("Red", TextColor.RED.toString());
		assertEquals("Light Purple", TextColor.LIGHT_PURPLE.toString());
		assertEquals("Yellow", TextColor.YELLOW.toString());
		assertEquals("White", TextColor.WHITE.toString());
	}
}
