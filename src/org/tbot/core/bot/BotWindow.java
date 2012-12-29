package org.tbot.core.bot;

import org.tbot.core.hierarchy.Buildable;
import org.tbot.core.hierarchy.Constructable;

import javax.swing.*;
import java.applet.Applet;
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
public class BotWindow extends JFrame implements Buildable, Constructable{

    private Class<?> theClass;

    private Applet game;

    public BotWindow(final Class<?> theClass){
        this.theClass = theClass;

        assert theClass != null : "BotWindow: Class is null!";

        createWindow();
    }

    public void addComponentsToPane(final Container pane){
        //Setting the layout of the pane. GridBag is the most flexible.
        pane.setLayout(new GridBagLayout());

        //Constraints
        GridBagConstraints constraints = new GridBagConstraints();

        //---------------AppletPane-------------------------------\\
        JPanel appletPane = new JPanel();
        appletPane.setSize(1024, 768);

        //AppletPane constraints
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0;
        constraints.ipadx = 1024; //padding
        constraints.ipady = 768;
        constraints.gridx = 2;
        constraints.gridy = 2;

        try {
            Applet applet = (Applet) theClass.newInstance();
            appletPane.add(applet, BorderLayout.CENTER);
            applet.init();
            applet.start();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

         //Adding AppletPane
        pane.add(appletPane, constraints);
        appletPane.setVisible(true);

        //--------------MenuBar-----------------------------------\\
        JMenuBar menuBar = new JMenuBar();

        //--------------MenuItems---------------------------------\\
        JMenuItem fileMenu = new JMenuItem();
        fileMenu.setText("File");


        menuBar.add(fileMenu);
        setJMenuBar(menuBar);


    }


    /**
     * Creates the GUI.
     * It should be invoked from an event dispatching thread to ensure thread safety.
     */
    private void createWindow(){

        //Creating the window
        JFrame frame = this;
        frame.setTitle("tBot - Revamped");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set up the content pane
        addComponentsToPane(frame.getContentPane());

        //Displaying the window
        frame.pack();
        frame.setVisible(true);

    }


    @Override
    public Object queryProduct(String param) {
        throw new NoSuchMethodError("Pointless use of this method in BotWindow!");
    }

    @Override
    public JFrame queryProduct() {
        return this;
    }

}
