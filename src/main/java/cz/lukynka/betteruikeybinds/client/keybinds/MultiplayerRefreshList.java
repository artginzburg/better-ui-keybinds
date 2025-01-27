package cz.lukynka.betteruikeybinds.client.keybinds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class MultiplayerRefreshList implements Keybind {
  @Override
  public String getActionName() {
    return "Refresh Server List";
  }

  @Override
  public List<Integer> getKeybinds() {
    return List.of(GLFW.GLFW_KEY_R);
  }

  @Override
  public Class<?> getScreen() {
    return JoinMultiplayerScreen.class;
  }

  @Override
  public int getRequiredPresses() {
    return 0;
  }

  @Override
  public void handle(Integer key) {
    var screen = (JoinMultiplayerScreen) Minecraft.getInstance().screen;
    assert screen != null;
    for (GuiEventListener child : screen.children()) {
      if (child.getClass() == Button.class) {
        var button = (Button) child;
        if (button.getMessage().contains(Component.translatable("selectServer.refresh"))) {
          button.onPress();
        }
      }
    }
  }
}
