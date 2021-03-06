/*
 * MIT License
 *
 * Copyright (c) 2020 mdashlw
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ru.mdashlw.smartreply;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.mdashlw.enelix.updater.ModInfo;
import ru.mdashlw.enelix.updater.Updater;
import ru.mdashlw.smartreply.listeners.ChatListener;
import ru.mdashlw.smartreply.listeners.GuiListener;

@Mod(modid = "smart-reply", name = "Smart Reply", version = SmartReply.VERSION, clientSideOnly = true)
public final class SmartReply {

  public static final String VERSION = "1.0.0";

  @Mod.Instance
  public static SmartReply INSTANCE;

  private String lastSender;

  @EventHandler
  public void onPreInit(final FMLPreInitializationEvent event) {
    this.registerListeners();
  }

  public void registerListeners() {
    MinecraftForge.EVENT_BUS.register(new ChatListener());
    MinecraftForge.EVENT_BUS.register(new GuiListener());
  }

  @EventHandler
  public void onPostInit(final FMLPostInitializationEvent event) {
    Updater.builder()
        .modInfo(new ModInfo("Smart Reply", "mdashlw"))
        .currentVersion(SmartReply.VERSION)
        .changelogUrl("https://raw.githubusercontent.com/mdashlw/smart-reply/master/changelog")
        .downloadUrl("https://github.com/mdashlw/smart-reply/releases/latest")
        .build()
        .checkAsync();
  }

  public String getLastSender() {
    return this.lastSender;
  }

  public void setLastSender(final String lastSender) {
    this.lastSender = lastSender;
  }
}
