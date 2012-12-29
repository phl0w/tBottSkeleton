package org.tbot.core.bot.loader.asm.modifiers.adapters.tree.generic;

import org.objectweb.asm.tree.ClassNode;
import org.tbot.core.bot.config.settings.Filter;

/**
 * This file is part of tBot.
 * <p/>
 * tBot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * tBot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with tBot.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @author trDna
 * @since 1.7
 */
public abstract class Transform implements Filter<ClassNode> {

    public abstract boolean accept(ClassNode theClass);

    public abstract void process(ClassNode cNode);

    public abstract void runTransform();

}
