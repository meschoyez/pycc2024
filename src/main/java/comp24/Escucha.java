package comp24;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import comp24.comp24Parser.DeclaracionContext;
import comp24.comp24Parser.ProgramaContext;

public class Escucha extends comp24BaseListener {
    private Integer nodos = 0;
    private Integer hojas = 0;

    @Override
    public void enterPrograma(ProgramaContext ctx) {
        System.out.println("Comienza el parsing...");
    }

    @Override
    public void exitPrograma(ProgramaContext ctx) {
        System.out.println("Visite " + nodos + " nodos");
        System.out.println("Encontre " + hojas + " hojas");
        System.out.println("Fin del parsing!!!");
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        nodos++;
    }

    @Override
    public void enterDeclaracion(DeclaracionContext ctx) {
        System.out.println("\tAnalizando declaracion");
        System.out.println("\t\tgetText() -->" + ctx.getText() + "<--");
        System.out.println("\t\tgetChildCount() -->" + ctx.getChildCount() + "<--");
    }

    @Override
    public void exitDeclaracion(DeclaracionContext ctx) {
        System.out.println("\tDeclaracion analizada");
        System.out.println("\t\tgetText() -->" + ctx.getText() + "<--");
        System.out.println("\t\tgetChildCount() -->" + ctx.getChildCount() + "<--");
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        hojas++;
        // System.out.println("\tHoja -->" + node.getText() + "<--");
    }
    
}
