package game.entity;

import game.model.TexturedModel;

import org.lwjgl.util.vector.Vector3f;

public class EntityOtherCell extends Entity{
	
	public EntityOtherCell(TexturedModel model, Vector3f position, float rotX,
			float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
	}
	public void move(){
	
		this.increasePosition(0.02F, 0, 0.02F);
	}
	
}
