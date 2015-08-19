package game.entity;

import game.model.TexturedModel;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class EntityPlayerCell extends Entity{

	public EntityPlayerCell(TexturedModel model, Vector3f position, float rotX,
			float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
	}
	public void move(){
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			position.z-=0.05;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			position.z+=0.05;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			position.x-=0.05;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			position.x+=0.05;
		}
	}
}
