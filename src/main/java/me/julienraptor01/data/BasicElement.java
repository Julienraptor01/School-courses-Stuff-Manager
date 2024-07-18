package me.julienraptor01.data;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.time.Instant;

public abstract class BasicElement {
	private String name;
	private String description;
	private String textureLocation;
	private Image icon;
	private Long timestamp;

	public BasicElement(String name, String description, String textureLocation) {
		this.setName(name);
		this.setDescription(description);
		this.setTextureLocation(textureLocation);
		this.setTimestamp(Instant.now().getEpochSecond());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
}
