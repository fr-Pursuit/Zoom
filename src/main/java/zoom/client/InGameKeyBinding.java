package zoom.client;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class InGameKeyBinding extends KeyMapping
{
	public InGameKeyBinding(String name, int key, String category)
	{
		super(name, key, category);
		this.setKeyConflictContext(KeyConflictContext.IN_GAME);
	}
}
