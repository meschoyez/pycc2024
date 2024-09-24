grammar comp24;

@header {
package comp24;
}

fragment LETRA : [A-Za-z] ;
fragment DIGITO : [0-9] ;

FOR   : 'for' ;
WHILE : 'while' ;
INT   : 'int' ;
DOUBLE : 'double' ;
CHAR  : 'char' ;
VOID  : 'void' ;

COMA  : ',' ;
PYC   : ';' ;
PA    : '(' ;
PC    : ')' ;
LLA   : '{' ;
LLC   : '}' ;
ASIG  : '=' ;
SUMA  : '+' ;
RESTA : '-' ;
MULT  : '*' ;
DIV   : '/' ;
MOD   : '%' ;
IGUAL : '==' ;

// LINEA : (LETRA | DIGITO | [ {}()=;+*])*'\n' ;
ID : (LETRA | '_')(LETRA | DIGITO | '_')* ;
NUMERO : DIGITO+ ;

WS : [ \t\n\r] -> skip ;

OTRO : . ;


// s : ID { System.out.println("ID ->" + $ID.getText() + "<--"); } s
//   | NUMERO { System.out.println("NUMERO ->" + $NUMERO.getText() + "<--"); } s
//   | FOR { System.out.println("FOR ->" + $FOR.getText() + "<--"); } s
//   | WHILE { System.out.println("WHILE ->" + $WHILE.getText() + "<--"); } s
//   | OTRO { System.out.println("Otro ->" + $OTRO.getText() + "<--"); } s
//   | EOF
//   ;

// si : s EOF ;

// s : PA s PC s
//   |
//   ;

programa : instrucciones EOF ;

instrucciones : instruccion instrucciones
              |
              ;

// instruccion : LINEA { System.out.println("LINEA ->" + $LINEA.getText() + "<--"); } ;

instruccion : declaracion
            | asignacion PYC
            | iwhile
            | bloque
            | exp
            ;

bloque : LLA instrucciones LLC ;

declaracion : tdato ID inic lvars PYC ;

tdato : INT
      | DOUBLE
      | CHAR
      | VOID
      ;

inic : ASIG opal
     |
     ;

lvars : COMA ID inic lvars
      |
      ;

asignacion : ID ASIG opal ;

iwhile : WHILE PA opal PC instruccion;

opal : exp ;

// a + b / (c + d)
exp : term e ;

e : SUMA  term e
  | RESTA term e
  |
  ;

term : factor t ;

t : MULT factor t
  | DIV  factor t
  | MOD  factor t
  |
  ;

factor : NUMERO
       | ID
       | PA exp PC
       ;


