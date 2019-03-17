grammar XSEScript;

program: ((instruction '\n'+) | COMMENT)* (instruction | COMMENT);

    //instruction: ((v_assig | f_assig | instr) ';') | cond;
    instruction: v_assig | f_assig | instr | cond;

        v_assig: VAR '=' value;
            value: (DEC_LIT | HEX_LIT);

        f_assig: FLAG '=' bool;
            bool: TRUE | FALSE;

        instr: COMMAND args*;
            args: STRING | ID | value | list | tuple | FLAG;
                list: '[' ( | (elem ',')* elem) ']';
                tuple: '(' elem (',' elem)* ')';
                    elem: ID | DEC_LIT | HEX_LIT;

        cond: IF b_expr '\n'+ program '\n'+ ( | ELSE '\n'+ program '\n'+) END;
            b_expr: CHECKGENDER | choice | (VAR op value) | FLAG;
                choice: CHOICE STRING;
                op: LT | EQ | GT | LE | GE | NE;




WHITESPACE: (' ' | '\r' | '\t' | EOF) -> skip;
//WHITESPACE: (' ' | '\n' | '\t' | '\r') -> skip;
NEWLINE: '\n'+;
ASSIG: '=';
EQ: '==';
NE: '!=';
GE: '>=';
GT: '>';
LE: '<=';
LT: '<';
fragment QUOTE: '\'';
IF: 'if';
THEN: 'then';
ELSE: 'else';
END: 'end';
TRUE: 'true';
FALSE: 'false';
CHECKGENDER: 'checkgender';
CHOICE: 'choice';
STRING: QUOTE .*? QUOTE;
FLAG: 'f0x' [0-9A-F]+;
VAR: 'v0x' [0-9A-F]+;
HEX_LIT: '0x' [0-9A-F]+;
COMMENT: '//' .*? ('\n'|EOF);
DEC_LIT: [0-9]+;
//FLAG: '$' [0-9]+;
//VAR: '_' [0-9]+;
COMMAND: [a-z]+;
ID: [A-Z0-9]+;