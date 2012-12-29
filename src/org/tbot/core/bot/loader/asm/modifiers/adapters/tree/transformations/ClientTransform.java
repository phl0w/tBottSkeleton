package org.tbot.core.bot.loader.asm.modifiers.adapters.tree.transformations;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.ClassGen;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import org.tbot.core.bot.loader.asm.modifiers.adapters.tree.generic.AbstractClassTransform;

import java.io.*;

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
public class ClientTransform extends AbstractClassTransform{

    @Override
    public boolean accept(ClassNode theClass) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        theClass.accept(cw);

        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(cw.toByteArray()));
        ClassParser cp = new ClassParser(dis, theClass.name);

        int utfIdx = 0;

        try {
            JavaClass jc = cp.parse();
            ClassGen cg = new ClassGen(jc);
            utfIdx = cg.getConstantPool().lookupUtf8("Welcome to Near Reality");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return theClass.name.equals("client") && utfIdx != 0;
    }

    @Override
    public void runTransform() {

    }

    @Override
    public Object queryProduct(String param) {
        return super.queryProduct();
    }
}
