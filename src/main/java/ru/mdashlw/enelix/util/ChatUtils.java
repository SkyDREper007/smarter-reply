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

package ru.mdashlw.enelix.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.apache.commons.lang3.StringUtils;

public final class ChatUtils {

  private ChatUtils() {
  }

  public static int getBreakDashCount() {
    final Minecraft mc = Minecraft.getMinecraft();

    return (int) Math.floor((280 * mc.gameSettings.chatWidth + 40) / 320 * (1 / mc.gameSettings.chatScale) * 53) - 3;
  }

  public static void printBreakLine() {
    final int dashCount = getBreakDashCount();
    final String dashes = StringUtils.repeat('-', dashCount);

    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§9§m" + dashes));
  }
}
