package me.julienraptor01.data.assets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Assets {
	public static final String TEXTURE_LOCATION = "src/main/resources/assets/";
	private static final ImageIcon IMAGE_ICON = new ImageIcon(TEXTURE_LOCATION + "icon.png");

	public static Image getAppImage() {
		return IMAGE_ICON.getImage();
	}

	public static Icon getAppIcon() {
		return IMAGE_ICON;
	}
}
