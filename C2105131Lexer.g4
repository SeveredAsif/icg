lexer grammar C2105131Lexer;

@header {
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
}

@members {
    void writeIntoLexLogFile(String message) {
        try {
            if (Main.lexLogFile != null) {
                Main.lexLogFile.write(message + "\n");
                Main.lexLogFile.flush();
            }
        } catch (IOException e) {
            System.err.println("Lexer log error: " + e.getMessage());
        }
    }
    // helper to write into parserLogFile
    void writeIntoParserLogFile(String message) {
        try {
            Main.parserLogFile.write(message);
            Main.parserLogFile.newLine();
            Main.parserLogFile.flush();
        } catch (IOException e) {
            System.err.println("Parser log error: " + e.getMessage());
        }
    }

    // helper to write into Main.errorFile
    void writeIntoErrorFile(String message) {
        try {
            Main.errorFile.write(message);
            Main.errorFile.newLine();
            Main.errorFile.flush();
        } catch (IOException e) {
            System.err.println("Error file write error: " + e.getMessage());
        }
    }

}

// Comments
LINE_COMMENT
    : '//' ~[\r\n]* {
        writeIntoLexLogFile("Line# " + getLine() + ": Token <SINGLE LINE COMMENT> Lexeme " + getText());
    } -> skip
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' {
        writeIntoLexLogFile("Line# " + getLine() + ": Token <MULTI LINE COMMENT> Lexeme " + getText());
    } -> skip
    ;

// String
STRING
    : '"' ( '\\' . | ~["\\\r\n] )* '"' {
        writeIntoLexLogFile("Line# " + getLine() + ": Token <STRING> Lexeme " + getText());
    } -> skip
    ;

WS : [ \t\r\n\f]+ -> skip ;

// Keywords
IF : 'if' { writeIntoLexLogFile("Line# " + getLine() + ": Token <IF> Lexeme " + getText()); };
CASE : 'case' { writeIntoLexLogFile("Line# " + getLine() + ": Token <CASE> Lexeme " + getText()); };
SWITCH : 'switch' { writeIntoLexLogFile("Line# " + getLine() + ": Token <SWITCH> Lexeme " + getText()); };
IN : 'in' { writeIntoLexLogFile("Line# " + getLine() + ": Token <IN> Lexeme " + getText()); };
TO : 'to' { writeIntoLexLogFile("Line# " + getLine() + ": Token <TO> Lexeme " + getText()); };
ELSE : 'else' { writeIntoLexLogFile("Line# " + getLine() + ": Token <ELSE> Lexeme " + getText()); };
FOR : 'for' { writeIntoLexLogFile("Line# " + getLine() + ": Token <FOR> Lexeme " + getText()); };
FOREACH : 'foreach' { writeIntoLexLogFile("Line# " + getLine() + ": Token <FOREACH> Lexeme " + getText()); };
FORIN : 'forin' { writeIntoLexLogFile("Line# " + getLine() + ": Token <FORIN> Lexeme " + getText()); };
DO : 'do' {writeIntoLexLogFile("Line# " + getLine() + ": Token <DO> Lexeme " + getText());};
WHILE : 'while' { writeIntoLexLogFile("Line# " + getLine() + ": Token <WHILE> Lexeme " + getText()); };
TIMES : 'times' { writeIntoLexLogFile("Line# " + getLine() + ": Token <TIMES> Lexeme " + getText()); };
PRINTLN : 'printf' { writeIntoLexLogFile("Line# " + getLine() + ": Token <PRINTLN> Lexeme " + getText()); };
RETURN : 'return' { writeIntoLexLogFile("Line# " + getLine() + ": Token <RETURN> Lexeme " + getText()); };
INT : 'int' { writeIntoLexLogFile("Line# " + getLine() + ": Token <INT> Lexeme " + getText()); };
FLOAT : 'float' { writeIntoLexLogFile("Line# " + getLine() + ": Token <FLOAT> Lexeme " + getText()); };
VOID : 'void' { writeIntoLexLogFile("Line# " + getLine() + ": Token <VOID> Lexeme " + getText()); };
BREAK : 'break' {};
CONTINUE : 'continue' {writeIntoLexLogFile("Line# " + getLine() + ": Token <CONTINUE> Lexeme " + getText()); };
GOTO : 'goto' {writeIntoLexLogFile("Line# " + getLine() + ": Token <GOTO> Lexeme " + getText());};

// Symbols
COLON : ':' {writeIntoLexLogFile("Line# " + getLine() + ": Token <COLON> Lexeme " + getText());};
QMARK : '?' {writeIntoLexLogFile("Line# " + getLine() + ": Token <QMARK> Lexeme " + getText());};
LPAREN : '(' { writeIntoLexLogFile("Line# " + getLine() + ": Token <LPAREN> Lexeme " + getText()); };
RPAREN : ')' { writeIntoLexLogFile("Line# " + getLine() + ": Token <RPAREN> Lexeme " + getText()); };
LCURL : '{' { writeIntoLexLogFile("Line# " + getLine() + ": Token <LCURL> Lexeme " + getText()); };
RCURL : '}' { writeIntoLexLogFile("Line# " + getLine() + ": Token <RCURL> Lexeme " + getText()); };
LTHIRD : '[' { writeIntoLexLogFile("Line# " + getLine() + ": Token <LTHIRD> Lexeme " + getText()); };
RTHIRD : ']' { writeIntoLexLogFile("Line# " + getLine() + ": Token <RTHIRD> Lexeme " + getText()); };
SEMICOLON : ';' { writeIntoLexLogFile("Line# " + getLine() + ": Token <SEMICOLON> Lexeme " + getText()); };
COMMA : ',' { writeIntoLexLogFile("Line# " + getLine() + ": Token <COMMA> Lexeme " + getText()); };


ADDOP : [+\-] { writeIntoLexLogFile("Line# " + getLine() + ": Token <ADDOP> Lexeme " + getText()); };
SUBOP : [+\-] { writeIntoLexLogFile("Line# " + getLine() + ": Token <SUBOP> Lexeme " + getText()); };
MULOP : [*/%] { writeIntoLexLogFile("Line# " + getLine() + ": Token <MULOP> Lexeme " + getText()); };
INCOP : '++' { writeIntoLexLogFile("Line# " + getLine() + ": Token <INCOP> Lexeme " + getText()); };
DECOP : '--' { writeIntoLexLogFile("Line# " + getLine() + ": Token <DECOP> Lexeme " + getText()); };
NOT : '!' { writeIntoLexLogFile("Line# " + getLine() + ": Token <NOT> Lexeme " + getText()); };
RELOP : '<=' | '==' | '>=' | '>' | '<' | '!=' { writeIntoLexLogFile("Line# " + getLine() + ": Token <RELOP> Lexeme " + getText());};
LOGICOP : '&&' | '||' { writeIntoLexLogFile("Line# " + getLine() + ": Token <LOGICOP> Lexeme " + getText());};
ASSIGNOP : '=' { writeIntoLexLogFile("Line# " + getLine() + ": Token <ASSIGNOP> Lexeme " + getText()); };

// Identifiers and constants
ID : [A-Za-z_][A-Za-z0-9_]* {
    writeIntoLexLogFile("Line# " + getLine() + ": Token <ID> Lexeme " + getText());
};

CONST_INT : [0-9]+ {
    writeIntoLexLogFile("Line# " + getLine() + ": Token <CONST_INT> Lexeme " + getText());
};

CONST_FLOAT
    : [0-9]+ ('.' [0-9]*)? ([Ee][+\-]? [0-9]+)? {
        writeIntoLexLogFile("Line# " + getLine() + ": Token <CONST_FLOAT> Lexeme " + getText());
    }
    | '.' [0-9]+ {
        writeIntoLexLogFile("Line# " + getLine() + ": Token <CONST_FLOAT> Lexeme " + getText());
    }
    | [0-9]+ '.' {
        writeIntoLexLogFile("Line# " + getLine() + ": Token <CONST_FLOAT> Lexeme " + getText());
    }
    ;

ERROR_CHAR
    : .  // Matches any single character not already matched by other rules
    {
        System.err.println("Unrecognized character: " + getText());
        Main.syntaxErrorCount++;
        writeIntoParserLogFile("Error at line " + getLine() + ": Unrecognized character " + getText() + "\n");
        writeIntoErrorFile("Error at line " + getLine() + ": Unrecognized character " + getText() + "\n");
        writeIntoLexLogFile("Line# " + getLine() + ": Token <ERROR_CHAR> Lexeme " + getText());
    }
    ;

