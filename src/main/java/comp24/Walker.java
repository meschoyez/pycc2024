package comp24;

import org.antlr.v4.runtime.tree.TerminalNode;

import comp24.comp24BaseVisitor;
import comp24.comp24Parser.DeclaracionContext;
import comp24.comp24Parser.InstruccionesContext;
import comp24.comp24Parser.ProgramaContext;

public class Walker extends comp24BaseVisitor<String> {

    @Override
    public String visitDeclaracion(DeclaracionContext ctx) {
        System.out.println(" Declaracion --> " + ctx.getChild(0).getText());
        System.out.println("             --> " + ctx.getChild(1).getText());
        return super.visitDeclaracion(ctx);
    }

    @Override
    public String visitPrograma(ProgramaContext ctx) {
        System.out.println("Comienza programa -> Hijos = " + ctx.getChildCount());
        System.out.println(" Hijo 0 --> Nieto 1 --> " + ctx.getChild(0).getChild(1).getText());
        return super.visitInstrucciones((InstruccionesContext)ctx.getChild(0));
    }
    
    @Override
    public String visitTerminal (TerminalNode node) {
        System.out.println(" Token -> " + node.getText());
        return null;
    }
}
