package fr.pursuit.minecraft.zoom.client;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class KeyBindings
{
	public static final KeyMapping ZOOM = new InGameKeyBinding("key.zoom", GLFW.GLFW_KEY_V, "key.categories.misc");
	
	public static void register()
	{
		ClientRegistry.registerKeyBinding(ZOOM);
	}
	
	public KeyBindings() {}
}
