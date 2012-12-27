package org.tbot.core.bot.loader;

import org.objectweb.asm.tree.ClassNode;
import org.tbot.core.bot.config.settings.BotInfo;
import org.tbot.core.bot.config.settings.UpdaterConfiguration;
import org.tbot.core.bot.loader.asm.modifiers.adapters.tree.modifiers.generic.AbstractClassTransform;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This file is part of tBot.
 *
 * tBot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * tBot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with tBot.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * Must be run via the injector!
 *
 * TODO:
 * - Add the transformation classes
 * - Support functionality for flags
 *
 * @author trDna
 * @since 1.7
 */

public class Updater {

    //The JarConstruct that transformations are based off of.
    private static JarConstruct jc;

    //The transformation classes
    private static ArrayList<AbstractClassTransform> transforms = new ArrayList<AbstractClassTransform>();

    //The transformed classes
    protected HashMap<String, ClassNode> injClasses = new HashMap<String, ClassNode>();

    //Keep UpdaterConfiguration.ADAPT as default for the updater flags
    private int flags = UpdaterConfiguration.ADAPT;


    /**
     * Constructs an Updater instance.
     *
     * @param flags - To notify the way the updater operates.
     *              - See UpdaterConfiguration for a set of flags.
     *
     */
    public Updater(final int flags){
        this.flags = flags;


        if((flags & UpdaterConfiguration.ADAPT) != 0){

            //Startup the JarConstruct
            jc = new JarConstruct(BotInfo.JAR_PATH);

            //Load all of the classes and store it into a HashMap
            jc.loadClasses();

        }

        //TODO: Add the transformation classes


        //Run the transforms
        runTransforms();

    }


    /**
     * The JarConstruct to work with.
     *
     * @return The JarConstruct with all loaded files.
     */
    protected JarConstruct getJar(){
        return jc;
    }


    private void runTransforms(){

        //Loop through the AbstractClassTransforms.
        for(AbstractClassTransform act : transforms){

            //Loop through the classes.
            for(ClassNode cn : getJar().loadedClassNodes.values()){

                //Allow a ClassNode to be processed IF the Transformation class filter accepts it.
                if(act.accept(cn)){

                    //Process the transform.
                    act.process(cn);

                    //Run the event transformations.
                    act.runTransform();

                    //Produce the events.
                    act.applyChanges();

                    //Get the altered ClassNode
                    ClassNode c = act.queryProduct();

                    //Store it onto a HashMap for the injector's use.
                    injClasses.put(c.name, c);
                }
            }
        }
    }

}
