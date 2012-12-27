package org.tbot.core.bot.loader.asm.analysis.math;


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
 * Special statistic utils.
 *
 * @since 1.7
 * @author trDna
 */
public class ExtendedMath {

    /**
     * Calculates the standard deviation of a given point of a population.
     *
     * @param datum - The datum of the data set.
     * @param mean - The mean of the given data set.
     * @param numOfData - The number of data in a given data set.
     * @return How far away a data point is from the mean of the data set.
     */
    public double stdDevPop(final int datum, final int mean, final int numOfData){
        return Math.sqrt((datum - mean) / (numOfData));
    }

    /**
     * Calculates the standard deviation of a given point of a sample.
     *
     * @param datum - The datum of the data set.
     * @param mean - The mean of the given data set.
     * @param numOfData - The number of data in a given data set.
     * @return How far away a data point is from the mean of the data set.
     */
    public double stdDevSample(final int datum, final int mean, final int numOfData){
        return Math.sqrt((datum - mean) / (numOfData - 1));
    }
}
