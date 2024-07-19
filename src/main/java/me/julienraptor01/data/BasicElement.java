package me.julienraptor01.data;

import javax.swing.ImageIcon;
import java.awt.Image;

public abstract class BasicElement {
	private String name;
	private String identifier;
	private String textureLocation;
	private Image icon;
	private Long timestamp;

	public BasicElement(String name, String identifier, String textureLocation, Long timestamp) {
		this.setName(name);
		this.setIdentifier(identifier);
		this.setTextureLocation(textureLocation);
		this.setTimestamp(timestamp);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getTextureLocation() {
		return textureLocation;
	}

	public void setTextureLocation(String textureLocation) {
		this.textureLocation = textureLocation;
		this.icon = new ImageIcon(textureLocation).getImage();
	}

	public Image getIcon() {
		return icon;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return String.format("BasicElement{name='%s', identifier='%s', textureLocation='%s', icon=%s, timestamp=%d}", name, identifier, textureLocation, icon, timestamp);
	}
}
