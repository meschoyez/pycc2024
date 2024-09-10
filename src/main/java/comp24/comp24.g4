grammar comp24;

@header {
package comp24;
}

fragment LETRA : [A-Za-z] ;
fragment DIGITO : [0-9] ;

FOR   : 'for' ;
WHILE : 'while' ;
INT   : 'int' ;

PYC : ';' ;
PA : '(' ;
PC : ')' ;
LLA : '{' ;
LLC : '}' ;
ASIG  : '=' ;
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
            | iwhile
            | bloque
            ;

bloque : LLA instrucciones LLC ;

declaracion : INT ID PYC ;

iwhile : WHILE PA opal PC instruccion;

opal : ID ;