package fr.pursuit.minecraft.zoom.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;

public class InGameKeyBinding extends KeyBinding
{
	public InGameKeyBinding(String name, int key, String category)
	{
		super(name, key, category);
		this.setKeyConflictContext(KeyConflictContext.IN_GAME);
	}
}
