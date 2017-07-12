package ua.nure.maxim.baykalov.filecounter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class Main implements NativeKeyListener{
	
	private static CounterThread counterThread;
	
	public static void main(String[] args) {
				
		Logger.getLogger(GlobalScreen.class.getPackage().getName()).setLevel(Level.OFF);	// Disable GlobalScreen logs
		
		try {
			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(new Main());	// Set listeners
			System.out.println("Author is Maxim Baykalov");
			System.out.println("Press ESC to stop process");
		} catch (NativeHookException e) {
			System.err.println("Exit listener is crushed");
		}
		
		// create Start count thread
		counterThread = new CounterThread(args[0], args[1]);	
		counterThread.start();
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			counterThread.stopCount();
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {}

}
