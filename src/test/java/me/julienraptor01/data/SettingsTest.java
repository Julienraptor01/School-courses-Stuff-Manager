package me.julienraptor01.data;

import me.julienraptor01.data.config.Settings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingsTest {
	@Test
	void getInstance() {
		assertNotNull(Settings.getInstance());
		assertEquals(Settings.getInstance(), Settings.getInstance());
	}

	@Test
	void isStartMaximized() {
		assertEquals(Settings.DEFAULT_START_MAXIMIZED, Settings.getInstance().isStartMaximized());
		Settings.getInstance().setStartMaximized(false);
		assertFalse(Settings.getInstance().isStartMaximized());
		Settings.getInstance().setStartMaximized(true);
		assertTrue(Settings.getInstance().isStartMaximized());
		Settings.getInstance().setStartMaximized(null);
		assertEquals(Settings.DEFAULT_START_MAXIMIZED, Settings.getInstance().isStartMaximized());
	}

	@Test
	void getDatetimeFormat() {
		assertEquals(Settings.DEFAULT_DATETIME_FORMAT, Settings.getInstance().getDatetimeFormat());
		String datetimeFormat = "dd/MM/YYYY HH:mm:ss";
		Settings.getInstance().setDatetimeFormat(datetimeFormat);
		assertEquals(datetimeFormat, Settings.getInstance().getDatetimeFormat());
		Settings.getInstance().setDatetimeFormat(null);
		assertEquals(Settings.DEFAULT_DATETIME_FORMAT, Settings.getInstance().getDatetimeFormat());
	}
}
