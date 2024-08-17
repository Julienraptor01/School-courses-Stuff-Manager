package me.julienraptor01.data.template;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;

public abstract class BasicElement implements Serializable {
	private int internalId;
	private String name;
	private String identifier;
	private String textureLocation;
	private transient Image icon; //TODO: Fix serialization issue with Image
	private Long timestamp;

	public BasicElement(int internalId, String name, String identifier, String textureLocation, Long timestamp) {
		this.setInternalId(internalId);
		this.setName(name);
		this.setIdentifier(identifier);
		this.setTextureLocation(textureLocation);
		this.setTimestamp(timestamp);
	}

	public int getInternalId() {
		return internalId;
	}

	public void setInternalId(int internalId) {
		this.internalId = internalId;
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
		return String.format("BasicElement{internalId='%s',  name='%s', identifier='%s', textureLocation='%s', icon=%s, timestamp=%d}", internalId, name, identifier, textureLocation, icon, timestamp);
	}
}
