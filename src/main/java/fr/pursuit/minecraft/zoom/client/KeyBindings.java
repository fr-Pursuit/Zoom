package fr.pursuit.minecraft.zoom.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class KeyBindings
{
	public static final KeyBinding ZOOM = new InGameKeyBinding("key.zoom", GLFW.GLFW_KEY_V, "key.categories.misc");
	
	public static void register()
	{
		ClientRegistry.registerKeyBinding(ZOOM);
	}
	
	public KeyBindings() {}
}
