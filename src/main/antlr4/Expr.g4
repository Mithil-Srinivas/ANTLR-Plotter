grammar Expr;

@header {
  package com.example.calc;
}

prog:   stat* EOF ;

stat
    : ID '=' expr                       # assignStat
    | funcDef                            # funcDefStat
    | expr                               # exprStat
    ;

funcDef
    : ID '(' paramList? ')' '=' expr
    ;

paramList
    : ID (',' ID)*
    ;

expr
    : expr '+' term                      # add
    | expr '-' term                      # sub
    | term                               # toTerm
    ;

term
    : term '*' pow                      # mul
    | term '/' pow                      # div
    | term pow                          # implicitMul   // <--- added
    | pow                               # toPow
    ;

pow
    : unary '^' pow                     # power
    | unary                             # toUnary
    ;

unary
    : '+' unary                          # plusUnary
    | '-' unary                          # minusUnary
    | primary                            # toPrimary
    ;

primary
    : NUMBER                             # number
    | STRING                             # stringLiteral
    | ID '(' argList? ')'                # funcCall
    | ID                                 # id
    | '(' expr ')'                       # parens
    ;

argList
    : expr (',' expr)*
    ;

NUMBER
    : DIGIT+ ('.' DIGIT+)? ( [eE] [+-]? DIGIT+ )?
    ;

ID
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;

STRING
    : '"' (~["\r\n])* '"'     // double-quoted strings like "red"
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

fragment DIGIT : [0-9] ;
