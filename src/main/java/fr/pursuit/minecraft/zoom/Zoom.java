package fr.pursuit.minecraft.zoom;

import fr.pursuit.minecraft.zoom.client.EventHandler;
import fr.pursuit.minecraft.zoom.client.KeyBindings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Zoom.MOD_ID)
public class Zoom
{
	public static final String MOD_ID = "zoom";
	
	public Zoom()
	{
		IEventBus events = FMLJavaModLoadingContext.get().getModEventBus();
		events.addListener(this::initialize);
	}
	
	private void initialize(FMLClientSetupEvent event)
	{
		KeyBindings.register();
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
}
