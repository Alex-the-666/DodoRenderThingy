package game.entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

	private Vector3f position = new Vector3f(0, 100, 0);
	private float pitch;
	private float yaw;
	private float roll;

	public Camera(){
		pitch = 90;
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
		if(Keyboard.isKeyDown(Keyboard.KEY_E)){
			pitch -=0.5;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			position.y-=0.05;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			position.y+=0.05;
		}
	}
	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getRoll() {
		return roll;
	}

	public void setRoll(float roll) {
		this.roll = roll;
	}
}
