package org.tbot.core.bot.loader.asm.analysis.patterns;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;

import org.tbot.core.hierarchy.*;

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
public class InstructionPatternConstruct implements Constructable{


    private String regex, byteCodeText;

    private ClassNode cn;

    private AbstractInsnNode[] insnNodes;


    /**
     * Creates a representation of a set of instruction nodes to be formed into a pattern.
     *
     * @param insnNodes - The instructions to be added.
     */

    public InstructionPatternConstruct(final AbstractInsnNode... insnNodes){
        this.insnNodes = insnNodes;
        this.byteCodeText = null; //figure this out.
    }

    /**
     * Creates a representation of a set of instruction nodes to be formed into a pattern.
     *
     * @param byteCodeText - The instructions to be added as a java.lang.String.
     * @param regex - A regular expression to be used as a set of guidelines.
     */
    public InstructionPatternConstruct(final String byteCodeText, final String regex){
        this.regex = regex;
        this.byteCodeText = byteCodeText;
    }

    /**
     * Compares two or more instruction constructs to calculate a confidence percentage.
     *
     * @param primeConstruct - The prime set of instructions to be compared to.
     * @param patternConstructs - The set of instructions to be compared with the prime set of instructions.
     *
     * @return A percentage out of 100%.
     */
    public int getConfidencePercentage(final InstructionPatternConstruct primeConstruct, final InstructionPatternConstruct... patternConstructs){
        return 0;
    }


    public String getByteCodeText(){
        return byteCodeText;
    }


    public InstructionPatternConstruct getConstruct(){
        return new InstructionPatternConstruct(byteCodeText, regex);
    }

    public AbstractInsnNode[] toInsnNodeArray(final InstructionPatternConstruct pattern){
        return null;
    }


    @Override
    public Object queryProduct(String param) {
        throw new NoSuchMethodError("Pointless use of this method in InstructionPatternConstruct!");
    }

    @Override
    public InstructionPatternConstruct queryProduct() {
        return this;
    }
}
