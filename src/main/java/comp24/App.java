package comp24;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

// Las diferentes entradas se explicaran oportunamente
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Compilador!!!");
        // create a CharStream that reads from file
        // CharStream input = CharStreams.fromFileName("input/entrada.txt");
        // CharStream input = CharStreams.fromFileName("input/parentesis.txt");
        // CharStream input = CharStreams.fromFileName("input/programa.txt");
        // CharStream input = CharStreams.fromFileName("input/miniC.txt");
        CharStream input = CharStreams.fromFileName("input/aritmetica.txt");

        // create a lexer that feeds off of input CharStream
        comp24Lexer lexer = new comp24Lexer(input);
        
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // create a parser that feeds off the tokens buffer
        comp24Parser parser = new comp24Parser(tokens);
                
        // create Listener
        comp24BaseListener escucha = new Escucha();

        // Conecto el objeto con Listeners al parser
        parser.addParseListener(escucha);

        // Solicito al parser que comience indicando una regla gramatical
        // En este caso la regla es el simbolo inicial
        parser.programa();
        // ParseTree tree = parser.programa();
        // Conectamos el visitor
        // Caminante visitor = new Caminante();
        // visitor.visit(tree);
        // System.out.println(visitor);
        // System.out.println(visitor.getErrorNodes());
        // Imprime el arbol obtenido
        // System.out.println(tree.toStringTree(parser));
        // System.out.println(escucha);
        
    }
}