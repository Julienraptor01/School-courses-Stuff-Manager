package me.julienraptor01.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RarityTest {

	@Test
	void testToString() {
		assertEquals("COMMON", Rarity.COMMON.toString());
		assertEquals("UNCOMMON", Rarity.UNCOMMON.toString());
		assertEquals("RARE", Rarity.RARE.toString());
		assertEquals("EPIC", Rarity.EPIC.toString());
		assertEquals("LEGENDARY", Rarity.LEGENDARY.toString());
		assertEquals("MYTHIC", Rarity.MYTHIC.toString());
		assertEquals("DIVINE", Rarity.DIVINE.toString());
		assertEquals("SPECIAL", Rarity.SPECIAL.toString());
		assertEquals("VERY SPECIAL", Rarity.VERY_SPECIAL.toString());
		assertEquals("ULTIMATE", Rarity.ULTIMATE.toString());
		assertEquals("ADMIN", Rarity.ADMIN.toString());
	}
}
