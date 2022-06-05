package zoom.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler
{
	private static final float ZOOM_FACTOR = 5.0F;
	
	private final Minecraft minecraft = Minecraft.getInstance();
	private boolean wasZooming = false;
	private boolean hadSmoothCamera = false;
	
	@SubscribeEvent
	public void onFOVUpdate(FOVUpdateEvent event)
	{
		boolean isZooming = KeyBindings.ZOOM.isDown();
		
		float fov = event.getNewfov();
		if(isZooming)
		{
			fov /= ZOOM_FACTOR;
			event.setNewfov(fov);
		}
		
		if(isZooming != this.wasZooming)
		{
			// Update the fov instantly
			this.minecraft.gameRenderer.fov = fov;
			this.minecraft.gameRenderer.oldFov = fov;
			
			// Update the render area
			this.minecraft.levelRenderer.needsUpdate();
			
			// Update camera smoothness
			if(isZooming)
				this.hadSmoothCamera = this.minecraft.options.smoothCamera;
			else this.minecraft.options.smoothCamera = this.hadSmoothCamera;
		}
		
		if(isZooming)
			this.minecraft.options.smoothCamera = true;
		
		this.wasZooming = isZooming;
	}
	
	@SubscribeEvent
	public void onRenderHand(RenderHandEvent event)
	{
		if(KeyBindings.ZOOM.isDown())
			event.setCanceled(true); // Do not render the player's hand while zooming
	}
}
