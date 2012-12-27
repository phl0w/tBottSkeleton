package org.tbot.core.bot.loader;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import org.tbot.core.bot.config.*;

import org.tbot.core.bot.config.settings.BotInfo;
import org.tbot.core.hierarchy.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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
 *
 * This is a representation of a JAR content vector.
 *
 * TODO:
 * - Print out actions as the JAR is loaded with classes (perhaps with style!)
 * - Finishing up the loader.
 * - Finishing up the basic skeleton of the bot itself.
 *
 * @version 0.1
 * @since 1.7
 *
 * @author trDna
 */

public class JarConstruct implements Constructable{

    private final float VERSION = 0.1F;

    /**
     * The URLClassLoader that loads the JAR from a given path.
     */
    private URLClassLoader url;

    /**
     * This is where the classes are stored. For use only in the loader package!
     */
    protected HashMap<String, ClassNode> loadedClassNodes = new HashMap<String, ClassNode>();

    /**
     * The JAR's path.
     */
    private String jarPath;


    /**
     * Creates a representation of a loaded jar.
     *
     * @param jarPath - The path to the JAR.
     */
    public JarConstruct(final String jarPath){
        try {

            //Set up logger and print out the path.
            Logger.setAppName("JarConstruct " + getClass().hashCode());
            Logger.printlnInfo("Path to JAR: " + BotInfo.JAR_PATH);

            //Creates a new URLClassLoader and loads the JAR.
            url = new URLClassLoader(new URL[]{new URL("file:" + jarPath)});


            //Referencing the JAR's path.
            this.jarPath = jarPath;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads all classes from the given JAR file and stores them into a HashMap for future use.
     *
     * @return True if it was successful, False if it was not.
     */
    public boolean loadClasses(){
        short count = 0;

        try {
            //Startup
            p("---------------------------------------------------------------------");
            p("--------------------      Jar Loader     ----------------------------");
            p("Version: " + VERSION);
            p("File: " + BotInfo.JAR_PATH);

            p("JC Hash: " + getClass().hashCode());

            //Referencing the JAR file.
            JarFile jf = new JarFile(jarPath);

            //Print out the size of the JarFile
            p("JarFile Size = " + jf.size());
            p("-----------------------------------------------------------------");

            //Referencing the entries.
            Enumeration<? extends JarEntry> en = jf.entries();

            //Looping through the elements (the entries).
            while(en.hasMoreElements()){

                //The entry to work with.
                JarEntry entry = en.nextElement();

                //Grabbing solely the class files
                if (entry.getName().endsWith(".class")) {

                    //Count out the entries
                    ++count;

                    //Print out the entry
                    p("Entry " + count + ") " + entry.getName());
                    p(" -> Decompressed Size = " + entry.getSize() + " Bytes" + "\n");

                    //ClassReader retrieves the bytes from a given entry.
                    ClassReader cr = new ClassReader(jf.getInputStream(entry));

                    //Creating a new ClassNode to act as a representative of a class.
                    ClassNode cn = new ClassNode();

                    //Delegating all method calls and data from ClassReader to ClassNode.
                    //Think of it as data from 'cr' are being entrusted or put into 'cn' (such as the class bytes).
                    cr.accept(cn, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);

                    //Put it into the local package's HashMap as a ClassNode.
                    loadedClassNodes.put(cn.name, cn);
                }

            }

            System.out.println(count + " classes were loaded and stored!");
            p("-----------------------------------------------------------------");
            p("-----------------------------------------------------------------");

            Logger.printlnInfo("Load successful.");

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Retrieves a given class from the class HashMap.
     *
     * @param clazz - The class name.
     * @return - A Class object.
     */
    public ClassNode retrieveClass(final String clazz){
        //Assume that the HashMap
        return loadedClassNodes.get(clazz);
    }

    private void p(Object msg){
        System.out.println(msg);
    }


    @Override
    public ClassNode queryProduct(final String param) {
        return loadedClassNodes.get(param);
    }

    @Override
    public HashMap queryProduct() {
        return loadedClassNodes;
    }
}
