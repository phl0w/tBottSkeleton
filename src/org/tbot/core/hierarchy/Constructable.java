package org.tbot.core.hierarchy;

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
public interface Constructable {

    /**
     * Retrieves the intended product of a Construct.
     *
     * For example, a JarConstruct's createBase method would return a class.
     *
     * @param param - Path
     * @return - An instance of the product.
     */
    public Object queryProduct(final String param);

    /**
     * Retrieves the intended product of a Construct.
     *
     * For example, a JarConstruct's createBase method would return a class.
     *
     * @return - The instance of the product.
     */
    public Object queryProduct();
}
