package me.julienraptor01.data.storage;

import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Assets {
	public static final String TEXTURE_LOCATION = String.join(File.separator, "src", "main", "resources", "assets");
	private static final ImageIcon IMAGE_ICON = new ImageIcon(String.join(File.separator, TEXTURE_LOCATION, "icon.png"));

	public static Image getAppImage() {
		return IMAGE_ICON.getImage();
	}

	public static Icon getAppIcon() {
		return IMAGE_ICON;
	}
}
