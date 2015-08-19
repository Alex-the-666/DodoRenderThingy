package game.engineTester;

import game.entity.Camera;
import game.entity.EntityOtherCell;
import game.entity.EntityPlayerCell;
import game.entity.Light;
import game.model.RawModel;
import game.model.TexturedModel;
import game.renderEngine.DisplayManager;
import game.renderEngine.MasterRenderer;
import game.renderEngine.ModelLoader;
import game.renderEngine.OBJLoader;
import game.renderEngine.texture.ModelTexture;
import game.terrain.Terrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class GameLoop {
	public static final String NAME = "Test Game";
	public static void main(String[] args){
	
	
		DisplayManager.createDisplay();
		ModelLoader loader = new ModelLoader();
		MasterRenderer renderer = new MasterRenderer();
		
		RawModel model = OBJLoader.loadObjModel("dodo", loader);
		TexturedModel texturedModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("dodo")));
		EntityPlayerCell testEntity = new EntityPlayerCell(texturedModel, new Vector3f(0, 0, 0), 0, 0, 0, 1);
		

		//EntityOtherCell entityCells = new EntityOtherCell(texturedModel, new Vector3f(0, 0, 0), 0, 0, 0, 1);
		
		Camera camera = new Camera();
		Light light = new Light(new Vector3f(0, 0, 0), new Vector3f(1, 1, 1));
		
		Terrain terrain = new Terrain(0,0,loader, new ModelTexture(loader.loadTexture("background")));
		Terrain terrain1 = new Terrain(-1,0,loader, new ModelTexture(loader.loadTexture("background")));
		Terrain terrain2 = new Terrain(0,-1,loader, new ModelTexture(loader.loadTexture("background")));
		Terrain terrain3 = new Terrain(-1,-1,loader, new ModelTexture(loader.loadTexture("background")));

		List<EntityOtherCell> allCells = new ArrayList<EntityOtherCell>();
		
		Random rand = new Random();
		
		for(int i = 0; i < 700; i++){
			float x = rand.nextFloat() * 600 - 100;
			float y = 0.5F;
			float z = rand.nextFloat() * 600 - 100;
			allCells.add(new EntityOtherCell(texturedModel, new Vector3f(x,y,z), 0, 0, 0, 6));
		}
		
		System.out.println("OS name " + System.getProperty("os.name"));
	    System.out.println("OS version " + System.getProperty("os.version"));
	    System.out.println("LWJGL version " + org.lwjgl.Sys.getVersion());
	    System.out.println("OpenGL version " + GL11.glGetString(GL11.GL_VERSION));

		while(!Display.isCloseRequested()){
			//testEntity.increasePosition(0, 0, -0.02F);
			camera.move();
			testEntity.move();
			renderer.processTerrain(terrain);
			renderer.processTerrain(terrain1);
			renderer.processTerrain(terrain2);
			renderer.processTerrain(terrain3);
			
			for(EntityOtherCell cell:allCells){
				renderer.processEntity(cell);
				cell.increaseRotation(0, 0.4F, 0);
			}
			light.move(camera);
			//renderer.processEntity(testEntity);
			renderer.render(light, camera);
			DisplayManager.updateDisplay();
		}
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
