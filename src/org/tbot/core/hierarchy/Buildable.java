package org.tbot.core.hierarchy;

import java.awt.*;

/**
 * This file is part of tBot.
 *
 * tBot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * tBot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with tBot.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @since 1.7
 * @author trDna
 */
public interface Buildable {

    /**
     * For any Swing applications.
     *
     * @param pane - The pane to add components to.
     */
    public void addComponentsToPane(final Container pane);
}
