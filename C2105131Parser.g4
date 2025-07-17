parser grammar C2105131Parser;

options {
    tokenVocab = C2105131Lexer;
}

@header {
import java.io.BufferedWriter;
import java.io.IOException;
import SymbolTable.SymbolInfo;

}

@members {
    int stack_offset = 0;
    int prev_offset = 0;
    int label = 0;
    boolean code = false;
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

    void writeIntoAsmFile(String message) {
        try {
            Main.asmWriter.write(message);
            Main.asmWriter.newLine();
            Main.asmWriter.flush();
        } catch (IOException e) {
            System.err.println("Parser log error: " + e.getMessage());
        }
    }

    void newLabel()
    { 
        label++;
        writeIntoAsmFile("L"+label+":");
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
    

    void insertIntoSymbolTable(String name, String type){
        try {
            Main.st.insert(name,type);

        } catch (Exception e) {
            System.err.println("Parser log error: " + e.getMessage());
        }
    }

    void insertIntoSymbolTable(String name, String type, String IDType){
        try {
            String printingLine = "< " + name + " : " + "ID" + " >";
            SymbolInfo sym = new SymbolInfo(name,type,printingLine,IDType); 
            Main.st.insert(sym);

        } catch (Exception e) {
            System.err.println("Parser log error: " + e.getMessage());
        }
    }


    void enterNewScope(){
        try {
            Main.st.enterScope();
            Main.addToSymbolTable();
            

        } catch (Exception e) {
            System.err.println("Parser log error: " + e.getMessage());
        }
    }
        
        
    void exitScope(){
        try {
            Main.addToSymbolTable();
            printSymboltable();
            Main.st.exitScope();

        } catch (Exception e) {
            System.err.println("Parser log error: " + e.getMessage());
        }
    }
    void printSymboltable(){
        try {
            writeIntoParserLogFile(Main.st.getAllScopesAsString());
        } catch (Exception e) {
            System.err.println("Parser log error: " + e.getMessage());
        }
    }
    void addToPendingList(String name,String IDType){
        try {
            Main.addToPending(name,IDType);
        } catch (Exception e) {
            System.err.println("Parser log error: " + e.getMessage());
        }        
    }
    void addToPendingList(String name){
        try {
            Main.addToPending(name);
        } catch (Exception e) {
            System.err.println("Parser log error: " + e.getMessage());
        }        
    }

    boolean lookUp(String name){
        try {
            return Main.lookup(name);
        } catch (Exception e) {
            System.err.println("Parser log error: " + e.getMessage());
            return false;
        } 
     }

    String normalizeType(String rawType) {
        if (rawType == null) return null;
        switch (rawType.toUpperCase()) {
            case "CONST_INT":
                return "int";
            case "CONST_FLOAT":
                return "float";
            default:
                return rawType.toLowerCase(); 
        }
    }

}

 start 
    : 
    { 
        writeIntoAsmFile(".MODEL SMALL\n.STACK 1000H");
        writeIntoAsmFile(".Data");
        writeIntoAsmFile("\t CR EQU 0DH");
        writeIntoAsmFile("\t LF EQU 0AH");
        writeIntoAsmFile("\t number DB \"00000$\"");
    }
    p=program
      {
    writeIntoParserLogFile(
        "Line "+  $p.stop.getLine() + ": start : program\n"
    );         
        writeIntoParserLogFile(Main.st.getAllScopesAsString());
        writeIntoParserLogFile(
            "Total number of lines: "
            + $p.stop.getLine() 
        );
        writeIntoParserLogFile(
            "Total number of errors: "
            + Main.syntaxErrorCount
        );
        writeIntoAsmFile("end main");
      }
    ;

program
    returns [String name_line]
    : p=program u=unit
    {
    writeIntoParserLogFile(
        "Line "+  $u.stop.getLine() + ": program : program unit\n\n" + $p.name_line + "\n" + $u.name_line + "\n"
    ); 
    $name_line=$p.name_line + "\n" + $u.name_line;
    }
    | u=unit
    {
    writeIntoParserLogFile(
        "Line "+  $u.stop.getLine() + ": program : unit\n\n" + $u.name_line + "\n"
    ); 
    $name_line = $u.name_line;
    }
    
    ;

unit
    returns [String name_line]
    : v=var_declaration
    {
    writeIntoParserLogFile(
        "Line "+  $v.stop.getLine() + ": unit : var_declaration\n\n" + $v.name_line + "\n"
    ); 
    $name_line=$v.name_line;
    }
    | f=func_declaration
    {
    writeIntoParserLogFile(
        "Line "+  $f.stop.getLine() + ": unit : func_declaration\n\n" + $f.name_line + "\n"
    ); 
    $name_line=$f.name_line;
    }
    | f1=func_definition
    {
    writeIntoParserLogFile(
        "Line "+  $f1.stop.getLine() + ": unit : func_definition\n\n" + $f1.name_line + "\n"
    ); 
    $name_line=$f1.name_line;
    }
    ;

func_declaration
    returns [String name_line]
    : t=type_specifier ID LPAREN p=parameter_list RPAREN sm=SEMICOLON
      {
        writeIntoParserLogFile(
            "Line "
            + $sm.getLine() + ": func_declaration : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON\n\n" +$t.text + " "+ $ID.getText() + "(" + $p.name_line +")"+ ";\n"
        ); 
        $name_line=$t.text + " "+ $ID.getText() + "(" + $p.name_line +");";    
   
        String printingLine =  "< " + $ID.getText() + " : " + "ID" + " >";
        SymbolInfo sym = new SymbolInfo($ID.getText(),"ID",printingLine,"function");

        sym.returnType = $t.text; 
        sym.paramNumber = $p.paramNumber;

        String[] paramDefs = $p.name_line.split(",");
        for (String def : paramDefs) {
            String type = def.trim().split(" ")[0];
            sym.paramList.add(type);
        }

        // writeIntoErrorFile(
        //     "debug at setting  "
        //     + $sm.getLine() + ":" +sym.paramList.get(0) + " "+ sym.getIDType() + " " + sym.getName() +" is the function name\n"
        // );          
        Main.st.insert(sym);
        Main.pendingInsertions.clear();
      }
    | t=type_specifier ID LPAREN RPAREN sm=SEMICOLON
      {
        writeIntoParserLogFile(
            "Line "
            + $sm.getLine() + ": func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n\n" +$t.text + " "+ $ID.getText() + "()"+ ";\n"
        );   
        $name_line = $t.text + " "+ $ID.getText() + "();";         
        String printingLine =  "< " + $ID.getText() + " : " + "ID" + " >";
        // writeIntoErrorFile(
        //     "debug "
        //     + $sm.getLine() + ": func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n\n" +$t.name_line + " "+ $ID.getText() + "()"+ ";\n"
        // );        
        SymbolInfo sym = new SymbolInfo($ID.getText(),"ID",printingLine,"function");
        sym.returnType = $t.text; 

        Main.st.insert(sym);
      }
    ;

func_definition
    returns [String name_line]
    : t=type_specifier 
    ID
    {
        if(!code)
        { 
            writeIntoAsmFile(".CODE");
            code = true;
        }
        
        writeIntoAsmFile($ID.getText()+" PROC");
    } 
    LPAREN p=parameter_list 
    {
        prev_offset = stack_offset;
        stack_offset = 0;
        if(Main.lookup($ID.getText())){
            SymbolInfo s = Main.st.lookup($ID.getText());
            if(!s.getIDType().equalsIgnoreCase("function")){
                
                    Main.syntaxErrorCount++;

                    writeIntoParserLogFile(
                        "Error at line " + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"
                    ); 

                    writeIntoErrorFile(
                        "Error at line " + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"
                    ); 


            } else if(s.getIDType().equalsIgnoreCase("function")){


                if(!s.returnType.equalsIgnoreCase($t.text)){


                    Main.syntaxErrorCount++;

                    writeIntoParserLogFile(
                        "Error at line " + $ID.getLine() + ": Return type mismatch of " + $ID.getText() + "\n"
                    ); 

                    writeIntoErrorFile(
                        "Error at line " + $ID.getLine() + ": Return type mismatch of " + $ID.getText() + "\n"
                    ); 

                }

                else if(s.paramNumber!=$p.paramNumber){


                    Main.syntaxErrorCount++;

                    writeIntoParserLogFile(
                        "Error at line " + $ID.getLine() + ": Total number of arguments mismatch with declaration in function " + $ID.getText() + "\n"
                    ); 

                    writeIntoErrorFile(
                        "Error at line " + $ID.getLine() + ": Total number of arguments mismatch with declaration in function " + $ID.getText() + "\n"
                    ); 


                }
            } 
        } else {


            String printingLine =  "< " + $ID.getText() + " : " + "ID" + " >";
            SymbolInfo sym = new SymbolInfo($ID.getText(),"ID",printingLine,"function");
            sym.returnType=$t.text;            

            String[] paramDefs = $p.name_line.split(",");
            for (String def : paramDefs) {
                String type = def.trim().split(" ")[0];
                sym.paramList.add(type);
            }
            Main.st.insert(sym);

        } 
    }
    
    RPAREN c=compound_statement
    {
        
        if($c.retuurn && $t.text.equalsIgnoreCase("void")){
            Main.syntaxErrorCount++;

            writeIntoParserLogFile(
                "Error at line " + $c.stop.getLine() + ": Cannot return value from function " + $ID.getText() + " with void return type \n"
            ); 

            writeIntoErrorFile(
                "Error at line " + $c.stop.getLine() + ": Cannot return value from function " + $ID.getText() + " with void return type \n"
            ); 


        }

        writeIntoParserLogFile(
            "Line "
            + $c.stop.getLine() + ": func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement\n\n" +$t.text + " "+ $ID.getText() + "("+$p.name_line+ ")"+ $c.name_line + "\n"
        );          
        $name_line = $t.text + " "+ $ID.getText() + "("+$p.name_line+ ")"+ $c.name_line;
        //Main.st.insert($ID.getText(),"ID");

        
        // for(int i=0;i<stack_offset;i++)
        // { 
        //     writeIntoAsmFile("\tPOPPINGG AX");
        // }
        writeIntoAsmFile("\tRET");
        stack_offset = prev_offset;

        writeIntoAsmFile($ID.getText()+" ENDP");
        stack_offset += 2;

    }
    | t=type_specifier 
    ID
    {
        
        if(!$ID.getText().equalsIgnoreCase("main")){ 
            prev_offset = stack_offset;
            stack_offset = 0;
        }

        if(Main.lookup($ID.getText())){
            SymbolInfo s = Main.st.lookup($ID.getText());
            if(!s.getIDType().equalsIgnoreCase("function")){
                
                    Main.syntaxErrorCount++;

                    writeIntoParserLogFile(
                        "Error at line " + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"
                    ); 

                    writeIntoErrorFile(
                        "Error at line " + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"
                    ); 


            } else if(s.getIDType().equalsIgnoreCase("function")){


                if(!s.returnType.equalsIgnoreCase($t.text)){


                    Main.syntaxErrorCount++;

                    writeIntoParserLogFile(
                        "Error at line " + $ID.getLine() + ": Return type mismatch of " + $ID.getText() + "\n"
                    ); 

                    writeIntoErrorFile(
                        "Error at line " + $ID.getLine() + ": Return type mismatch of " + $ID.getText() + "\n"
                    ); 

                }
            } 
        } else {

                String printingLine =  "< " + $ID.getText() + " : " + "ID" + " >";
                SymbolInfo sym = new SymbolInfo($ID.getText(),"ID",printingLine,"function");
                sym.returnType = $t.text; 

                Main.st.insert(sym);

                if($ID.getText().equalsIgnoreCase("main"))
                { 
                    if(!code)
                    { 
                        writeIntoAsmFile(".CODE");
                        code = true;
                    }
                    writeIntoAsmFile("main PROC");
                    writeIntoAsmFile("\tMOV AX,@DATA");
                    writeIntoAsmFile("\tMOV DS,AX");
                    writeIntoAsmFile("\tPUSH BP");
                    writeIntoAsmFile("\tMOV BP,SP");
                }
                else
                { 
                    if(!code)
                    { 
                        writeIntoAsmFile(".CODE");
                        code = true;
                    }                    
                    writeIntoAsmFile($ID.getText() +" PROC");
                }

        }
    } 
    LPAREN RPAREN c=compound_statement
    {
        writeIntoParserLogFile(
            "Line "
            + $c.stop.getLine() + ": func_definition : type_specifier ID LPAREN RPAREN compound_statement\n\n" +$t.text + " "+ $ID.getText() + "()"+ $c.name_line + "\n"
        );          
        $name_line = $t.text + " "+ $ID.getText() + "()"+ $c.name_line;
        
        
        if($ID.getText().equalsIgnoreCase("main")){ 
            writeIntoAsmFile("\tMOV AX,4CH");
            writeIntoAsmFile("\tINT 21H");
            writeIntoAsmFile($ID.getText()+" ENDP");
        }
        if(!$ID.getText().equalsIgnoreCase("main")){ 
        // for(int i=0;i<stack_offset;i++)
        // { 
        //     writeIntoAsmFile("\tPOPPPIN AX");
        // }
        writeIntoAsmFile("\tRET");
            stack_offset=prev_offset;
            writeIntoAsmFile($ID.getText()+" ENDP");
            stack_offset += 2;
        }

        
        	
	
        if($ID.getText().equalsIgnoreCase("main"))
        { 
                String new_line_and_print_func = """
                                                new_line proc
                                                    push ax
                                                    push dx
                                                    mov ah,2
                                                    mov dl,cr
                                                    int 21h
                                                    mov ah,2
                                                    mov dl,lf
                                                    int 21h
                                                    pop dx
                                                    pop ax
                                                    ret
                                                new_line endp
                                                print_output proc  ;print what is in ax
                                                    push ax
                                                    push bx
                                                    push cx
                                                    push dx
                                                    push si
                                                    lea si,number
                                                    mov bx,10
                                                    add si,4
                                                    cmp ax,0
                                                    jnge negate
                                                print:
                                                    xor dx,dx
                                                    div bx
                                                    mov [si],dl
                                                    add [si],'0'
                                                    dec si
                                                    cmp ax,0
                                                    jne print
                                                    inc si
                                                    lea dx,si
                                                    mov ah,9
                                                    int 21h
                                                    pop si
                                                    pop dx
                                                    pop cx
                                                    pop bx
                                                    pop ax
                                                    ret
                                                negate:
                                                    push ax
                                                    mov ah,2
                                                    mov dl,'-'
                                                    int 21h
                                                    pop ax
                                                    neg ax
                                                    jmp print
                                                print_output endp
                                                """;

            writeIntoAsmFile(new_line_and_print_func);
        }
        
    }
    ;

parameter_list
    returns [String name_line, int paramNumber]
    : p=parameter_list COMMA t=type_specifier ID
    {
        $paramNumber = $p.paramNumber + 1;

        boolean alreadyDeclared = false;
        for (SymbolInfo si : Main.pendingInsertions) {
            if (si.getName().equals($ID.getText())) {
                alreadyDeclared = true;
                break;
            }
        }

        if (alreadyDeclared) {
            Main.syntaxErrorCount++;
            writeIntoParserLogFile(
                "Error at line " + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + " in parameter\n"
            ); 
            writeIntoErrorFile(
                "Error at line " + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + " in parameter\n"
            );           
        } else {
            addToPendingList($ID.getText(), $t.text);
        }
      
        writeIntoParserLogFile(
            "Line "
            + $ID.getLine() + ": parameter_list : parameter_list COMMA type_specifier ID\n\n" + $p.name_line + ","+ $t.text + " " + $ID.getText() + "\n"
        );          
        $name_line = $p.name_line + ","+ $t.text + " " + $ID.getText();
    //addToPendingList($ID.getText(),$t.text);  
    }
    | p=parameter_list COMMA t=type_specifier
    {
        writeIntoParserLogFile(
            "Line "
            + $t.stop.getLine() + ": parameter_list : parameter_list COMMA type_specifier\n\n" + $p.name_line + ","+ $t.text + "\n"
        );          
        $name_line = $p.name_line + ","+ $t.text;
    }
    | t=type_specifier ID
    {
        $paramNumber = 1;
        boolean alreadyDeclared = false;
        for (SymbolInfo si : Main.pendingInsertions) {
            if (si.getName().equals($ID.getText())) {
                alreadyDeclared = true;
                break;
            }
        }

        if (alreadyDeclared) {
            Main.syntaxErrorCount++;
            writeIntoParserLogFile(
                "Error at line " + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + " in parameter\n"
            ); 
            writeIntoErrorFile(
                "Error at line " + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + " in parameter\n"
            );           
        } else {
            addToPendingList($ID.getText(), $t.text);
        }       
        writeIntoParserLogFile(
            "Line "
            + $t.stop.getLine() + ": parameter_list : type_specifier ID\n\n" + $t.text + " " + $ID.getText() + "\n"
        );          
        $name_line = $t.text + " " + $ID.getText();
        // addToPendingList($ID.getText(),$t.text);  
    }
    | t=type_specifier
    {
        writeIntoParserLogFile(
            "Line "
            + $t.stop.getLine() + ": parameter_list : type_specifier\n\n" + $t.text + "\n"
        );          
        $name_line = $t.text ;
    }
    |t=type_specifier ADDOP
    { 
        Main.syntaxErrorCount++;
        writeIntoParserLogFile(
            "Line "
            + $t.stop.getLine() + ": parameter_list : type_specifier\n\n" + $t.text + "\n"
        ); 
        writeIntoParserLogFile(
            "Error at line " + $ADDOP.getLine() + ": syntax error, unexpected ADDOP, expecting RPAREN or COMMA\n"
        ); 
        writeIntoErrorFile(
            "Error at line " + $ADDOP.getLine() + ": syntax error, unexpected ADDOP, expecting RPAREN or COMMA\n"
        );  
        $name_line = $t.text;      
    }
    ;

compound_statement 
    returns [String name_line,boolean retuurn]
    : LCURL 
    {
        enterNewScope();
    }
    stmts=statements 
    RCURL
    {
        
        writeIntoParserLogFile(
            "Line " + $RCURL.getLine() + ": compound_statement : LCURL statements RCURL\n\n{\n" + $stmts.name_line + "\n}\n"
        );
        $name_line = "{\n" + $stmts.name_line + "\n}";
        $retuurn=$stmts.retuurn;
        exitScope();
    }
    | LCURL RCURL
    {
        enterNewScope();
        writeIntoParserLogFile(
            "Line " + $RCURL.getLine() + ": compound_statement : LCURL RCURL\n\n{}\n"
        );
        $name_line = "{}";
        exitScope();
    }
    ;


var_declaration
    returns [String name_line]
    : t=type_specifier dl=declaration_list sm=SEMICOLON
      {

        writeIntoParserLogFile(
            "Line "
            + $sm.getLine() + ": var_declaration : type_specifier declaration_list SEMICOLON\n"  
        );

        if($t.text.equalsIgnoreCase("void")){

                Main.syntaxErrorCount++;

                writeIntoParserLogFile(
                    "Error at line " + $sm.getLine() + ": Variable type cannot be void" + "\n"
                ); 

                writeIntoErrorFile(
                    "Error at line " + $sm.getLine() + ": Variable type cannot be void"  + "\n"
                ); 

        }

        writeIntoParserLogFile(
            $t.text +  " " + $dl.name_line + ";\n"
        );

        



        $name_line = $t.text +  " " + $dl.name_line+";";   
        //get the count from main's pending list 
        int declaration_list_size = Main.pendingInsertions.size();
        //writeIntoAsmFile("The size of parameters is " + declaration_list_size);
        if(Main.st.getCurrentScope().getParent()==null)
        { 
            for(SymbolInfo item: Main.pendingInsertions)
            { 
                writeIntoAsmFile("\t" + item.getName() + " DW 1 DUP(0000H)" );
            }
        }
        else
        {
            
            //stack_offset += 2;
            for(SymbolInfo item: Main.pendingInsertions)
            { 
                writeIntoAsmFile("\tSUB SP,2");
            }
        }
        Main.addToSymbolTable($t.text,stack_offset);   
        writeIntoParserLogFile("symbol table scope id : " + Main.st.getCurrentScope().getId()+" ,added" + $dl.name_line);
      }
    | t=type_specifier de=declaration_list_err sm=SEMICOLON
      {
        writeIntoErrorFile(
            "Line# "
            + $sm.getLine()
            + " with error name: "
            + $de.error_name
            + " - Syntax error at declaration list of variable declaration"
        );
        //Main.syntaxErrorCount++;
      }
    ;

declaration_list_err
    returns [String error_name]
    : { $error_name = "Error in declaration list"; }
    ;

type_specifier
    returns [String name_line]
    : INT
      {
        writeIntoParserLogFile(
            "Line "
            + $INT.getLine() + ": type_specifier : INT\n\n" + $INT.getText() + "\n"
        );        
        $name_line = "type: INT at line" + $INT.getLine();
      }
    | FLOAT
      {
        writeIntoParserLogFile(
            "Line "
            + $FLOAT.getLine() + ": type_specifier : FLOAT\n\n" + $FLOAT.getText() + "\n"
        );              
        $name_line = "type: FLOAT at line" + $FLOAT.getLine();
      }
    | VOID
      {
        writeIntoParserLogFile(
            "Line "
            + $VOID.getLine() + ": type_specifier : VOID\n\n" + $VOID.getText() + "\n"
        );              
        $name_line = "type: VOID at line" + $VOID.getLine();
      }
    ;

declaration_list
returns [String name_line]
    : dec1=declaration_list COMMA ID
    {
        
        if(Main.st.getCurrentScope().getParent()!=null)
        {
            stack_offset += 2;
        }
        boolean b = lookUp($ID.getText());
        if(b==true){
            Main.syntaxErrorCount++;
        writeIntoParserLogFile(
            "Error at line "
            + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"
        ); 
        writeIntoErrorFile(
            "Error at line "
            + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"            
        );             
        }     
        
        writeIntoParserLogFile(
            "Line "
            + $ID.getLine() + ": declaration_list : declaration_list COMMA ID\n\n" + $dec1.name_line + ","+$ID.getText() + "\n"
        );   
    $name_line=$dec1.name_line + ","+$ID.getText();
    addToPendingList($ID.getText());  
    //insertIntoSymbolTable($ID.getText(),"ID");     
    }
    | dec2=declaration_list COMMA ID LTHIRD CONST_INT RTHIRD
    {
        
        boolean b = lookUp($ID.getText());
        if(b==true){
            Main.syntaxErrorCount++;
        writeIntoParserLogFile(
            "Error at line "
            + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"
        );  
        writeIntoErrorFile(
            "Error at line "
            + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"            
        );            
        }       
        writeIntoParserLogFile(
            "Line "
            + $ID.getLine() + ": declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD\n\n" + $dec2.name_line+","+$ID.getText()+"["+$CONST_INT.getText() + "]\n"
        );  
        $name_line = $dec2.name_line+","+$ID.getText()+"["+$CONST_INT.getText() + "]";
        addToPendingList($ID.getText(),"array"); 
        //insertIntoSymbolTable($ID.getText(),"ID","array"); 
    }
    |dec3=declaration_list ADDOP ID
    {
        Main.syntaxErrorCount++;   
        writeIntoParserLogFile(
            "Error at line "
            + $ID.getLine() + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n"
        );  
        writeIntoErrorFile(
            "Error at line "
            + $ID.getLine() + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n"            
        );  
        $name_line=$dec3.name_line;
               
    }
    | ID
    {
        if(Main.st.getCurrentScope().getParent()!=null)
        {
            stack_offset += 2;
        }
        boolean b = lookUp($ID.getText());
        if(b==true){
            Main.syntaxErrorCount++;
        writeIntoParserLogFile(
            "Error at line "
            + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"
        );      
        writeIntoErrorFile(
            "Error at line "
            + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"            
        );        
        }
        writeIntoParserLogFile(
            "Line "
            + $ID.getLine() + ": declaration_list : ID\n\n" + $ID.getText() + "\n"
        );
        $name_line= $ID.getText();
        addToPendingList($ID.getText());            
    }
    | ID LTHIRD CONST_INT RTHIRD
    {
        
        boolean b = lookUp($ID.getText());
        if(b==true){
            Main.syntaxErrorCount++;
        writeIntoParserLogFile(
            "Error at line "
            + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"
        );        
        writeIntoErrorFile(
            "Error at line "
            + $ID.getLine() + ": Multiple declaration of " + $ID.getText() + "\n"            
        );      
        }       
        writeIntoParserLogFile(
            "Line "
            + $ID.getLine() + ": declaration_list : ID LTHIRD CONST_INT RTHIRD\n\n" + $ID.getText() + "[" + $CONST_INT.getText()+ "]\n"
        );  
        $name_line=$ID.getText() + "[" + $CONST_INT.getText()+ "]";
        addToPendingList($ID.getText(),"array");          
    }
    ;

statements 
    returns [String name_line,boolean retuurn]
    : s=statement
    {
        writeIntoParserLogFile(
            "Line " + $s.stop.getLine() + ": statements : statement\n\n" + $s.name_line + "\n"
        );
        $name_line = $s.name_line;
        $retuurn = $s.retuurn;

    }
   
    | s1=statements s2=statement
    {
        if($s2.name_line!=null){
        //if(!$s2.name_line.equalsIgnoreCase("debug")){
            writeIntoParserLogFile(
                "Line " + $s2.stop.getLine() + ": statements : statements statement\n\n" + $s1.name_line + "\n" + $s2.name_line + "\n"
            );
            $name_line = $s1.name_line + "\n" + $s2.name_line;
          } else {
           $name_line = $s1.name_line; 
          }
        
        $retuurn = $s2.retuurn;
    }
    ;


statement returns [String name_line,boolean retuurn,int lbl]
    : v=var_declaration
    {
        writeIntoParserLogFile(
            "Line " + $v.stop.getLine() + ": statement : var_declaration\n\n" + $v.name_line + "\n"
        );
        $name_line = $v.name_line;
        $retuurn=false;
    }
    |e=expression COLON
    {
        writeIntoParserLogFile(
            "Line " + $e.stop.getLine() + ": statement : expression COLON\n\n"  +$e.name_line + ":\n"
        );        
        Main.st.insert($e.name_line,"label");
        $name_line=$e.name_line+":";
    }
    | SWITCH LPAREN em=expression RPAREN LCURL cs=case_statements RCURL 
    {
        writeIntoParserLogFile(
            "Line " + $cs.stop.getLine() + ": statements : SWITCH LPAREN expression RPAREN compound_statement\n\n" + " switch("+$em.name_line+"){" +$cs.name_line + "}\n"
        );
        $name_line = " switch("+$em.name_line+")" +$cs.name_line;        
    } 
    |GOTO e=expression SEMICOLON
    {
        if(Main.st.lookup($e.name_line)==null){
            Main.syntaxErrorCount++;
            writeIntoParserLogFile("Error at line " + $e.name_line + ": No label declared " + $e.name_line + ";\n");
            writeIntoErrorFile("Error at line " + $e.name_line + ": No label declared " + $e.name_line + ";\n");
    }  
        writeIntoParserLogFile(
            "Line " + $e.stop.getLine() + ": statement : GOTO expression\n\n" +"goto " +$e.name_line + ";\n"
        );
    }
    | ex=expression_statement
    {
        if($ex.name_line!=null){
        //if(!$ex.name_line.equalsIgnoreCase("debug")){ 
        writeIntoParserLogFile(
            "Line " + $ex.stop.getLine() + ": statement : expression_statement\n\n" + $ex.name_line + "\n"
        );
        
        //}
        }
        $name_line = $ex.name_line;
        
        $retuurn=false;
    }
    | c=compound_statement
    {
        writeIntoParserLogFile(
            "Line " + $c.stop.getLine() + ": statement : compound_statement\n\n" + $c.name_line + "\n"
        );
        $name_line = $c.name_line;
        $retuurn=false;
    }

    | FOR 
    { 
        int Inclabel = label+11;
    }
    LPAREN e1=expression_statement 
    { 
        newLabel();
        int forlabel = label;
        writeIntoAsmFile(";for label");
    }
    e2=expression_statement 
    { 
        newLabel();
        int afterChecklabel = label;
        writeIntoAsmFile(";after check label");
        writeIntoAsmFile("\tPOP AX");
        stack_offset-=2;
        writeIntoAsmFile("\tCMP AX,1");
        writeIntoAsmFile("\tJE L"+Inclabel+" ;jumping to body");
        int end = Inclabel+1;
        writeIntoAsmFile("\tJMP L"+end+" ;jumping to end of loop,works if for doent print other labels");
    } 
    e3=expression RPAREN 
    { 
        newLabel();
        Inclabel = label;
        writeIntoAsmFile(";after inc label");    
        writeIntoAsmFile("\tJMP L"+forlabel+" ;jumping to for");    
    }
    s=statement
    {
        //get statements last label 
        // int next = label+1;
        // writeIntoAsmFile("\tJMP L"+next+" ;jumping out of forlabel");
        writeIntoParserLogFile(
            "Line " + $s.stop.getLine() + ": statement : FOR LPAREN expression_statement expression_statement expression RPAREN statement\n\n"
            + "for(" + $e1.name_line + "" + $e2.name_line + "" + $e3.name_line + ")" + $s.name_line + "\n"
        );
        $name_line = "for(" + $e1.name_line + "" + $e2.name_line + "" + $e3.name_line + ")" + $s.name_line;
        $retuurn=false;
        int inc = afterChecklabel+1;
        writeIntoAsmFile("\tJMP L"+inc+" ;jumping to increase"); 
        newLabel();
        writeIntoAsmFile(";for end label"); 
    }


    | IF LPAREN e=expression RPAREN BREAK SEMICOLON
    {
        writeIntoParserLogFile(
            "Line " + $BREAK.getLine() + ": statement : IF LPAREN expression RPAREN BREAK SEMICOLON\n\n"
            + "if(" + $e.name_line + ")" +  " break;\n"
        );
        $name_line = "if(" + $e.name_line + ")" +  " break;\n";
        $retuurn=false;
    }
    | IF 
    { 
        //currlabel = 6 
    }
    LPAREN e=expression RPAREN 
    { 
        int next = label+2;
        //writeIntoAsmFile("\tCMP AX,0"); //if false, jump to next label
        writeIntoAsmFile("\tJMP L"+next); //jmp to label 8, curr label = 6, next label 7=statement's label
    }
    s=statement
    {
        //label 7 created in statement
        // newLabel(); //label 8
        // next = label+2;
        // writeIntoAsmFile("\tJMP L"+next);
        writeIntoParserLogFile(
            "Line " + $s.stop.getLine() + ": statement : IF LPAREN expression RPAREN statement\n\n"
            + "if(" + $e.name_line + ")" + $s.name_line + "\n"
        );
        $name_line = "if(" + $e.name_line + ")" + $s.name_line;
        $retuurn=false;
        
    }
    | IF LPAREN e=expression RPAREN 
    { 
        int next = label+3; //
        //this section is under not equals of expression region. so it should jump to label+2 (label+1 is for equals) 
        //writeIntoAsmFile("\tCMP AX,0"); //if false, jump to next label
        writeIntoAsmFile("\tJMP L"+next); //jmp to label 8, curr label = 6, next label 7=statement's label        
    }
    s1=statement 
    { 
        //label 7 created in statement
        newLabel(); //label 8 for else if , redundant ig 
        next = label+5;
        writeIntoAsmFile("\tJMP L"+next);
    }
    ELSE s2=statement
    {
     
        writeIntoParserLogFile(
            "Line " + $s2.stop.getLine() + ": statement : IF LPAREN expression RPAREN statement ELSE statement\n\n"
            + "if(" + $e.name_line + ")" + $s1.name_line + "else " + $s2.name_line + "\n"
        );
        $name_line = "if(" + $e.name_line + ")" + $s1.name_line + "else " + $s2.name_line;
        $retuurn=false;
        newLabel();
        newLabel();
        newLabel(); //last label 
        writeIntoAsmFile(";End of if else");
    }

    |CONTINUE SEMICOLON
    {
        Main.syntaxErrorCount++;
        writeIntoParserLogFile(
            "Error at line " + $CONTINUE.getLine() + ":\n\n"
            + "CONTINUE outside loop\n"
        );    
    }
    | WHILE 
    { 
        newLabel();
        int whileLabel = label;
        writeIntoAsmFile(";while label : "+whileLabel);
    }
    LPAREN e=expression 
    { 

    }
    RPAREN s=statement
    {
        writeIntoParserLogFile(
            "Line " + $s.stop.getLine() + ": statement : WHILE LPAREN expression RPAREN statement\n\n"
            + "while(" + $e.name_line + ")" + $s.name_line + "\n"
        );
        $name_line = "while(" + $e.name_line + ")" + $s.name_line;
        $retuurn=false;
        writeIntoAsmFile("\tPOP AX");
        stack_offset-=2;
        writeIntoAsmFile("\tCMP AX,0");
        int nextLabel = label+1;
       
        writeIntoAsmFile("\tJE L"+nextLabel);
        
        writeIntoAsmFile("\tJMP L"+whileLabel+";whilelabel jump");
    }
    | PRINTLN LPAREN ID RPAREN SEMICOLON
    {
        writeIntoParserLogFile(
            "Line " + $SEMICOLON.getLine() + ": statement : PRINTLN LPAREN ID RPAREN SEMICOLON\n"
        );

        boolean b = lookUp($ID.getText());
        if(b==false){
            Main.syntaxErrorCount++;
        writeIntoParserLogFile(
            "Error at line "
            + $ID.getLine() + ": Undeclared variable " + $ID.getText() + "\n"
        );        
        writeIntoErrorFile(
            "Error at line "
            + $ID.getLine() + ": Undeclared variable " + $ID.getText() + "\n"            
        );      
        } 
        writeIntoParserLogFile(
            "printf(" + $ID.getText() + ");\n"
        );
        
        $name_line = "printf(" + $ID.getText() + ");";
        $retuurn=false;
    }
    | RETURN e=expression SEMICOLON
    {
        writeIntoParserLogFile(
            "Line " + $SEMICOLON.getLine() + ": statement : RETURN expression SEMICOLON\n\n"
            + "return " + $e.name_line + ";\n"
        );
        $name_line = "return " + $e.name_line + ";";
        $retuurn=true;
    }
    ;


case_statements
    returns [String name_line]
    : c=case_statement
    { $name_line=$c.name_line;}
    |c1=case_statements c2=case_statement
    {
        $name_line=$c1.name_line + " "+$c2.name_line;
    }; 

case_statement
    returns [String name_line]
    : CASE CONST_INT COLON st=statements  
    {
            writeIntoParserLogFile(
            "Line "
            + $CONST_INT.getLine()+ ": case_statement : CASE factor COLON statements BREAK SEMICOLON\n\n" +"case "+$CONST_INT.getText()  +":"+$st.name_line +"break;\n"
        );        
        $name_line = "case "+$CONST_INT.getText()  +":"+$st.name_line +"break;";
    };


expression_statement 
    returns [String name_line]
    : SEMICOLON
    {
        writeIntoParserLogFile(
            "Line " + $SEMICOLON.getLine() + ": expression_statement : SEMICOLON\n\n;\n"
        );
        $name_line = ";";
    }
    | ex=expression SEMICOLON
    {
        if($ex.name_line!=null){
        if(!$ex.name_line.equalsIgnoreCase("debug")){
        //"debug check: [" + $ex.name_line + "]\n"+
        writeIntoParserLogFile(
            "Line " + $SEMICOLON.getLine() + ": expression_statement : expression SEMICOLON\n\n" + $ex.name_line + ";\n"
        );
        $name_line = $ex.name_line + ";";
        }
        }else{ 
            $name_line =  "debug";
         }
        
    }
    ;

forin_statement
    returns [String name_line]
    : fe=foreach_statement TO s1=simple_expression 
    {
        $name_line = $fe.name_line + " to " + $s1.name_line;
    };


foreach_statement
    returns [String name_line]
    : s1=simple_expression IN s2=simple_expression 
    {
        
        if(Main.st.lookup($s1.name_line)!=null){
        
        if(!Main.st.lookup($s1.name_line).getIDType().equalsIgnoreCase("int")){
            Main.syntaxErrorCount++;
            writeIntoParserLogFile("Error at line " + $s2.stop.getLine() + ": Loop variable "+ $s1.name_line + " is not an integer\n" );
            writeIntoErrorFile("Error at line " + $s1.stop.getLine() + ": Loop variable "+ $s1.name_line + " is not an integer\n" );
        }
        }        
        if(Main.st.lookup($s2.name_line)!=null){
        
        if(!Main.st.lookup($s2.name_line).getIDType().equalsIgnoreCase("array")){
            Main.syntaxErrorCount++;
            writeIntoParserLogFile("Error at line " + $s2.stop.getLine() + ": "+ $s2.name_line + " is not an array\n" );
            writeIntoErrorFile("Error at line " + $s2.stop.getLine() + ": "+ $s2.name_line + " is not an array\n" );
        }
        }
        $name_line = $s1.name_line + " in " + $s2.name_line;
    };


variable
    returns [String name_line]
    : ID
    {
        writeIntoParserLogFile(
        "Line "
        + $ID.getLine() + ": variable : ID\n" 
    );    
    $name_line=$ID.getText();   
    if(Main.st.lookup($ID.getText())==null){
            Main.syntaxErrorCount++;
            writeIntoParserLogFile("Error at line " + $ID.getLine() + ": Undeclared variable " + $ID.getText() + "\n");
            writeIntoErrorFile("Error at line " + $ID.getLine() + ": Undeclared variable " + $ID.getText() + "\n");
    }  
    if(Main.st.lookup($ID.getText())!=null){
        
        if(Main.st.lookup($ID.getText()).getIDType().equalsIgnoreCase("array")){
            Main.syntaxErrorCount++;
            writeIntoParserLogFile("Error at line " + $ID.getLine() + ": Type mismatch, " + $ID.getText() + " is an array\n");
            writeIntoErrorFile("Error at line " + $ID.getLine() + ": Type mismatch, " + $ID.getText() + " is an array\n");
        }
        
        for (SymbolInfo sym : Main.pendingInsertions) {
            if (sym.getName().equals($ID.getText())) {
                if (sym.getIDType().equalsIgnoreCase("array")) {
                    Main.syntaxErrorCount++;
                    writeIntoParserLogFile("Error at line " + $ID.getLine() + ": Type mismatch, " + $ID.getText() + " is an array\n");
                    writeIntoErrorFile("Error at line " + $ID.getLine() + ": Type mismatch, " + $ID.getText() + " is an array\n");
                }
                break; 
            }
        }
    }
    

    writeIntoParserLogFile($ID.getText()+"\n");

    //addToPendingList($ID.getText());
    }
    | ID LTHIRD e=expression RTHIRD
    {
        writeIntoParserLogFile(
        "Line "
        + $ID.getLine() + ": variable : ID LTHIRD expression RTHIRD\n" 
    );

        if(Main.st.lookup($ID.getText())!=null){
            if(!Main.st.lookup($ID.getText()).getIDType().equalsIgnoreCase("array")){

                Main.syntaxErrorCount++;
                writeIntoParserLogFile(
                    "Error at line "
                    + $ID.getLine() + ": "+$ID.getText()+" not an array\n"
                ); 
                writeIntoErrorFile(
                    "Error at line "
                    + $ID.getLine() + ": "+$ID.getText()+" not an array\n"
                );
            }
        }


        if(!$e.type.equalsIgnoreCase("CONST_INT")){
        Main.syntaxErrorCount++;
        writeIntoParserLogFile(
            "Error at line "
            + $ID.getLine() + ": Expression inside third brackets not an integer\n"
        ); 
        writeIntoErrorFile(
            "Error at line "
            + $ID.getLine() + ": Expression inside third brackets not an integer\n"        
        );  
        } 

        writeIntoParserLogFile(
            $ID.getText() + "[" + $e.name_line+ "]\n"
        );

    $name_line=$ID.getText() + "[" + $e.name_line+ "]";  
   // addToPendingList($ID.getText());      
    }
    ;

expression
    returns [String name_line,String type]
    : l=logic_expression
    {
        if(!$l.name_line.equalsIgnoreCase("debug")){
            writeIntoParserLogFile(
            "Line "
            + $l.stop.getLine() + ": expression : logic_expression\n\n" + $l.name_line +"\n"
        ); 
         }
       
    $name_line =$l.name_line;
    $type = $l.type;
    }

    | v=variable a=ASSIGNOP l=logic_expression
    {
        newLabel();
        if(!$l.name_line.equalsIgnoreCase("debug")){ 
                writeIntoParserLogFile(
                "Line "
                + $l.stop.getLine() + ": expression : variable ASSIGNOP logic_expression\n" 
            );  
            $name_line=$v.name_line+""+ $a.text + "" + $l.name_line;
            
         } else{
            $name_line=$l.name_line;
          }
        
        
        String fullName = $v.name_line;
        String actualName = fullName.contains("[") ? fullName.substring(0, fullName.indexOf("[")): fullName;
        boolean isError = false;
        if($l.type!=null){  
            if($l.type.equalsIgnoreCase("void")){
                Main.syntaxErrorCount++;
                writeIntoParserLogFile("Error at line "  + $l.stop.getLine() + ": Void function used in expression\n");
                writeIntoErrorFile("Error at line " +  $l.stop.getLine() + ": Void function used in expression\n");  
                isError = true;          
            }
        }

        // if(Main.st.lookup($v.name_line)==null){
        //     writeIntoParserLogFile("debug at line "  + $l.stop.getLine() +$v.name_line+" not found in symbol table\n");
        // }

        if(Main.st.lookup(actualName)!=null && !isError){
            SymbolInfo sym2 = Main.st.lookup($l.name_line);
            SymbolInfo sym = Main.st.lookup(actualName);
            String IDtokenType = sym.getIDType();

            int stck_off = sym.getStackOffset();
            
            if(stck_off==-1)
            {
                
                if(sym2==null)
                { 
                    writeIntoAsmFile("\tPOP AX;getting assignop's RHS val fromm stack,as logical expr is pushed to stack");
                }
                else{ 
                    int stck_off2 = sym2.getStackOffset();
                    if(stck_off2==-1)
                    { 
                        writeIntoAsmFile("\tMOV AX,"+$l.name_line+";Global variable;rare");
                    }
                    else
                    { 
                       writeIntoAsmFile("\tMOV AX,[BP"+stck_off2+"];rare");
                    }
                }
                
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
                
                //writeIntoAsmFile("\tMOV AX,"+$l.name_line);
                writeIntoAsmFile("\tMOV "+actualName+",AX;LHS is global variable");
            }
            else 
            {
                if(sym2==null)
                { 
                    writeIntoAsmFile("\tPOP AX;getting assignop's RHS val fromm stack,as logical expr is pushed to stack");
                }                
                writeIntoAsmFile("\tMOV [BP-"+stck_off+"],AX;LHS is local variable");
            }
            //writeIntoParserLogFile("debug at line "  + $l.stop.getLine() +IDtokenType+"\n");
            if(!IDtokenType.equalsIgnoreCase(normalizeType($l.type)) && !IDtokenType.equalsIgnoreCase("array") && $l.type!=null){
                if(!(IDtokenType.equalsIgnoreCase("float") && normalizeType($l.type).equalsIgnoreCase("int"))){
                    Main.syntaxErrorCount++;
                    writeIntoParserLogFile("Error at line "  + $l.stop.getLine() + ": Type Mismatch\n");
                    writeIntoErrorFile("Error at line " +  $l.stop.getLine() + ": Type Mismatch\n");
                 }
            }
            if(IDtokenType.equalsIgnoreCase("array")&& $l.type!=null){
                //writeIntoParserLogFile("debug at line "  + $l.stop.getLine() +sym.arrayType+"\n");
                if(!sym.arrayType.equalsIgnoreCase(normalizeType($l.type))){
                    Main.syntaxErrorCount++;
                    writeIntoParserLogFile("Error at line "  + $l.stop.getLine() + ": Type Mismatch\n");
                    writeIntoErrorFile("Error at line " +  $l.stop.getLine() + ": Type Mismatch\n");                    
                }
            }
        }
        if(!$l.name_line.equalsIgnoreCase("debug")){ 
        writeIntoParserLogFile(
            $v.name_line+""+ $a.text + "" + $l.name_line +"\n"
        );
        }
    }
    ;

ternary_expression
    returns [String name_line]
    : LPAREN l1=logic_expression RELOP l4=logic_expression RPAREN QMARK l2=logic_expression COLON l3=logic_expression
    {
        $name_line = "(" + $l1.name_line + "< " +$l4.name_line +")? " + $l2.name_line + ": " +$l3.name_line; 
    };

logic_expression
    returns [String name_line,String type,boolean isConst]
    : r=rel_expression
    {
        $isConst=$r.isConst;
        if(!$r.name_line.equalsIgnoreCase("debug")){  
            writeIntoParserLogFile(
            "Line "
            + $r.stop.getLine() + ": logic_expression : rel_expression\n\n" + $r.name_line +"\n"
            );
        }
        $name_line=$r.name_line;
        $type = $r.type;
    }
    | r=rel_expression 
    { 
        newLabel();
        //push the result to stack AX 

        SymbolInfo sym = Main.st.lookup($r.name_line);
        if(sym==null)
        { 
            //some constant
            writeIntoAsmFile("\tMOV AX,"+$r.name_line);
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset += 2;

        }
        else {
            int offset = sym.getStackOffset();
            if(offset==-1)
            {
                writeIntoAsmFile("\tMOV AX,"+$r.name_line);
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            }
            else
            {
                writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            } 
        } 
        
        writeIntoAsmFile("\t MOV DX,AX");
    }
    LOGICOP re=rel_expression
    {
       sym = Main.st.lookup($re.name_line);
        if(sym==null)
        { 
            
            //writeIntoAsmFile("\tMOV AX,"+$re.name_line); //this is constant,this should be redundant
            writeIntoAsmFile("\tPOP AX;getting from stack"); //getting the stored value
            stack_offset-=2;
        }
        else {
            int offset = sym.getStackOffset();
            if(offset==-1)
            {
                writeIntoAsmFile("\tMOV AX,"+$re.name_line);
                writeIntoAsmFile("\tPUSH AX");
                stack_offset+=2;
            }
            else{
                
                writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
                writeIntoAsmFile("\tPUSH AX");
                stack_offset+=2;
            } 
        }
        //store logicop result in AX  

        //DX has the LHS value,Ax has the RHS value
        
        if($LOGICOP.getText().equals("||"))
        { 
            //curr L9
            //if DX true, jump to L10 - this level sets AX=1 
            int next = label+1;
            writeIntoAsmFile("\tCMP DX,1");
            writeIntoAsmFile("\tJE L"+next);
            //if AX true, jump to L10 - this level sets AX=1 
            writeIntoAsmFile("\tCMP AX,1");
            writeIntoAsmFile("\tJE L"+next);
            //if reached here (none true), jump to L11 - this sets AX=0
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L10
            newLabel();
            //AX=1
            writeIntoAsmFile("\tMOV AX,1");
            //writeIntoAsmFile("\tPUSH AX");
            //jump to L12 - because L11 sets AX=0
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L11
            newLabel();
            writeIntoAsmFile("\tMOV AX,0");
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }
        else if($LOGICOP.getText().equals("&&"))
        { 
            //curr L9
            //if DX false, jump to L11 - this level sets AX=0 
            int next = label+2;
            writeIntoAsmFile("\tCMP DX,1");
            writeIntoAsmFile("\tJNE L"+next);
            //if AX false, jump to L11 - this level sets AX=0 
            writeIntoAsmFile("\tCMP AX,1");
            writeIntoAsmFile("\tJNE L"+next);

  
            //L10 - rhis level sets AX=1, both true
            newLabel();
            //AX=1
            writeIntoAsmFile("\tMOV AX,1");
            //writeIntoAsmFile("\tPUSH AX");
            //jump to L12 - because L11 sets AX=0
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L11
            newLabel();
            writeIntoAsmFile("\tMOV AX,0");
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }

        writeIntoParserLogFile(
        "Line "
        + $re.stop.getLine() + ": logic_expression : rel_expression LOGICOP rel_expression\n\n" + $r.name_line+ "" + $LOGICOP.getText() + "" + $re.name_line +"\n"
    );          
        $name_line=$r.name_line+ "" + $LOGICOP.getText() + "" + $re.name_line;
    }
    ;

rel_expression
    returns [String name_line,String type,boolean isConst]
    : s=simple_expression
    {
        $isConst=$s.isConst;
        if(!$s.name_line.equalsIgnoreCase("debug")){ 
                writeIntoParserLogFile(
                "Line "
                + $s.stop.getLine() + ": rel_expression : simple_expression\n\n" + $s.name_line +"\n"
            );
        }
        $name_line=$s.name_line;
        $type = $s.type;
    }
    | s=simple_expression
    {
        newLabel();
        $isConst=false;
        //push the result to stack AX 

        SymbolInfo sym = Main.st.lookup($s.name_line);
        if(sym==null)
        { 
            //some constant
            writeIntoAsmFile("\tMOV AX,"+$s.name_line);
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }
        else {
            int offset = sym.getStackOffset();
            if(offset==-1)
            {
                writeIntoAsmFile("\tMOV AX,"+$s.name_line);
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            }
            else
            {
                writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            } 
        } 
        
        writeIntoAsmFile("\t MOV DX,AX");
    } 
    RELOP s1=simple_expression
    {

        
        sym = Main.st.lookup($s1.name_line);
        if(sym==null)
        { 
            
            writeIntoAsmFile("\tMOV AX,"+$s1.name_line);
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }
        else {
            int offset = sym.getStackOffset();
            if(offset==-1)
            {
                writeIntoAsmFile("\tMOV AX,"+$s1.name_line);
            }
            else{
                
                writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            } 
        }
        //store relop result in AX  

        //DX has the RHS value,Ax has the LHS value
        writeIntoAsmFile("\tCMP DX,AX");
        if($RELOP.getText().equals("<="))
        { 
            //curr L9
            //if less equal, jump to L10 
            int next = label+1;
            writeIntoAsmFile("\tJLE L"+next);
            //if not less equal, jump to L11
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L10
            newLabel();
            //AX=1
            writeIntoAsmFile("\tMOV AX,1");
            //writeIntoAsmFile("\tPUSH AX");
            //jump to L12
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L11
            newLabel();
            writeIntoAsmFile("\tMOV AX,0");
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }
        if($RELOP.getText().equals("<"))
        { 
            writeIntoAsmFile(";Less rule");
            //curr L9
            //if less , jump to L10 
            int next = label+1;
        

            

            writeIntoAsmFile("\tJL L"+next);
            //if not less equal, jump to L11
            next = label+2;
            

            

            writeIntoAsmFile("\tJMP L"+next);
            //L10
            newLabel();
            //AX=1
            writeIntoAsmFile("\tMOV AX,1");
            writeIntoAsmFile("\tPUSH AX");
            //jump to L12
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L11
            newLabel();
            writeIntoAsmFile("\tMOV AX,0");
            writeIntoAsmFile("\tPUSH AX");
            stack_offset+=2;
        }
        if($RELOP.getText().equals(">"))
        { 
            //curr L9
            //if less , jump to L10 
            int next = label+1;
            writeIntoAsmFile("\tJG L"+next);
            //if not less equal, jump to L11
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L10
            newLabel();
            //AX=1
            writeIntoAsmFile("\tMOV AX,1");
            //writeIntoAsmFile("\tPUSH AX");
            //jump to L12
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L11
            newLabel();
            writeIntoAsmFile("\tMOV AX,0");
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }
        else if($RELOP.getText().equals("!="))
        { 
            //curr L9
            //if not equal, jump to L10 
            int next = label+1;
            writeIntoAsmFile("\tJNE L"+next);
            //if equal, jump to L11
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L10
            newLabel();
            //AX=1
            writeIntoAsmFile("\tMOV AX,1");
            //writeIntoAsmFile("\tPUSH AX");
            //jump to L12
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L11
            newLabel();
            writeIntoAsmFile("\tMOV AX,0");
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }
        else if($RELOP.getText().equals("=="))
        { 
            //curr L9
            //if equal, jump to L10 
            int next = label+1;
            writeIntoAsmFile("\tJE L"+next);
            //if not equal, jump to L11
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L10
            newLabel();
            //AX=1
            writeIntoAsmFile("\tMOV AX,1");
            //writeIntoAsmFile("\tPUSH AX");
            //jump to L12
            next = label+2;
            writeIntoAsmFile("\tJMP L"+next);
            //L11
            newLabel();
            writeIntoAsmFile("\tMOV AX,0");
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }


        writeIntoParserLogFile(
        "Line "
        + $s1.stop.getLine() + ": rel_expression : simple_expression RELOP simple_expression\n\n" + $s.name_line +"" +$RELOP.getText() +""+$s1.name_line +"\n"
    );
        $name_line=$s.name_line +"" +$RELOP.getText()+""+$s1.name_line;
    }
    ;

simple_expression
    returns [String name_line,String type,boolean isConst]
    : t=term
    {
        $isConst=$t.isConst;
        writeIntoParserLogFile(
        "Line "
        + $t.stop.getLine() + ": simple_expression : term\n\n" + $t.name_line +"\n"
    );
        $name_line=$t.name_line;
        $type = $t.type;
    }
    | s=simple_expression ADDOP t=term
    {
        
        newLabel();

    
        $isConst=false;
        writeIntoAsmFile("\tPOP AX; popping the latest result to AX");
        stack_offset-=2;
        writeIntoAsmFile("\tMOV DX,AX");

       SymbolInfo sym = Main.st.lookup($s.name_line);
        if(sym==null)
        { 
            
            writeIntoAsmFile("\tPOP AX; popping the second result from stack");
            stack_offset-=2;
        }
        else {
            int offset = sym.getStackOffset();
            if(offset==-1)
            {
                writeIntoAsmFile("\tMOV AX,"+$s.name_line+";getting the LHS argument in ADDOP from global variable");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            }
            else{
                writeIntoAsmFile("sym name: "+sym.getName());
                writeIntoAsmFile("\tMOV AX,[BP-"+offset+"];getting the LHS argument in ADDOP from global variable");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            } 
        }
 
        writeIntoParserLogFile(
        "Line "
        + $t.stop.getLine() + ": simple_expression : simple_expression ADDOP term\n\n" +$s.name_line+""+$ADDOP.getText()+"" +$t.name_line +"\n"
    );
        $name_line=$s.name_line+""+$ADDOP.getText()+"" +$t.name_line;
        // writeIntoAsmFile("\tPOP AX");
        // stack_offset -= 2;
        writeIntoAsmFile("\tADD AX,DX;Adding in ADDOP");
        writeIntoAsmFile("\tPUSH AX;pushing the result of addop(simple expression) to stack");
    }

    |s=simple_expression ADDOP ASSIGNOP
 
    {
        Main.syntaxErrorCount++;
        writeIntoParserLogFile(
            "Error at line " + $ASSIGNOP.getLine() + ": syntax error, unexpected ASSIGNOP\n"  
            
        );
        writeIntoErrorFile(
            "Error at line " + $ASSIGNOP.getLine() + ": syntax error, unexpected ASSIGNOP\n"
        );
        $name_line="debug";
    }
    |  
    ;

term
    returns [String name_line,String type,boolean isConst]
    : u=unary_expression
    {
        $isConst = true;
        if(!$u.name_line.equalsIgnoreCase("debug")){ 
            writeIntoParserLogFile(
            "Line "
            + $u.stop.getLine() + ": term : unary_expression\n\n" +$u.name_line +"\n"
        );
         }

        $name_line=$u.name_line;
        $type=$u.type;
    }
    | t=term MULOP u=unary_expression
    {
        newLabel();
        $isConst = false;
        SymbolInfo sym = Main.st.lookup($u.name_line);
        if(sym==null)
        { 
            
            writeIntoAsmFile("\tPOP AX; extracting from stack");
            stack_offset-=2;
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }
        else {
            int offset = sym.getStackOffset();
            if(offset==-1)
            {
                writeIntoAsmFile("\tMOV AX,"+$u.name_line);
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            }
            else{

                writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            } 
        }
        


        
        writeIntoAsmFile("\tMOV CX,AX");
        

        sym = Main.st.lookup($t.name_line);
                
        if(sym==null)
        { 
            
            writeIntoAsmFile("\tPOP AX;getting from stack, as it is not in SymbolTable");
            stack_offset-=2;
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }
        else {
            int offset = sym.getStackOffset();
            if(offset==-1)
            {
                writeIntoAsmFile("\tMOV AX,"+$t.name_line);
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            }
            else{

                writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            } 
        } 

        writeIntoAsmFile("\tCWD");

        if($MULOP.getText().equals("*"))
        { 
            writeIntoAsmFile("\tMUL CX");
            writeIntoAsmFile("\tPUSH AX");
        }
        else{ 
            writeIntoAsmFile("\tDIV CX");
            //writeIntoAsmFile("\tPUSH CX"); //may have to remove it 
        }

        if($MULOP.getText().equals("%"))
        { 
            writeIntoAsmFile("\tPUSH DX");
            // writeIntoAsmFile("\tPOP AX"); //may have to remove it, handled in other place 
            // stack_offset-=2;
        }
        
        writeIntoParserLogFile(
        "Line "
        + $u.stop.getLine() + ": term : term MULOP unary_expression\n" 
    );

        
        if($u.name_line.equalsIgnoreCase("0") && $MULOP.getText().equalsIgnoreCase("%")){ 
            Main.syntaxErrorCount++;
            writeIntoParserLogFile(
            "Error at line "
            + $u.stop.getLine() + ": Modulus by Zero" +"\n"
        ); 
            writeIntoErrorFile(
            "Error at line "
            + $u.stop.getLine() + ": Modulus by Zero" +"\n"
        ); 
        }

        
        else if($u.type!=null){
                if($u.type.equalsIgnoreCase("void")){

                    Main.syntaxErrorCount++;
                    writeIntoParserLogFile(
                    "Error at line "
                    + $u.stop.getLine() + ": Void function used in expression" +"\n"
                ); 
                    writeIntoErrorFile(
                    "Error at line "
                    + $u.stop.getLine() + ": Void function used in expression" +"\n"
                );                    
                }

                else if(!$u.type.equalsIgnoreCase("CONST_INT")){
                    Main.syntaxErrorCount++;
                    writeIntoParserLogFile(
                    "Error at line "
                    + $u.stop.getLine() + ": Non-Integer operand on modulus operator" +"\n"
                ); 
                    writeIntoErrorFile(
                    "Error at line "
                    + $u.stop.getLine() + ": Non-Integer operand on modulus operator" +"\n"
                );       
            }
        }


    writeIntoParserLogFile($t.name_line+""+$MULOP.getText()+"" +$u.name_line +"\n");     
        $name_line=$t.name_line+""+$MULOP.getText()+"" +$u.name_line;
    }
    ;

unary_expression
    returns [String name_line, String type,boolean isConst]
    : ADDOP u=unary_expression
    {
        
        newLabel();
        

        SymbolInfo sym = Main.st.lookup($u.name_line);
        if(sym==null)
        { 
            //some constant
            writeIntoAsmFile("\tPOP AX;popping from stack which was pushed before");
            stack_offset-=2;
            // writeIntoAsmFile("\tPUSH AX");
            // stack_offset+=2;
        }
        else {
            int offset = sym.getStackOffset();
            if(offset==-1)
            {
                writeIntoAsmFile("\tMOV AX,"+$u.name_line);
                writeIntoAsmFile("\tNEG AX");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            }
            else
            {
                writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
                writeIntoAsmFile("\tNEG AX");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            } 
        }         
        writeIntoParserLogFile(
        "Line "
        + $u.stop.getLine() + ": unary_expression : ADDOP unary_expression\n\n" + $ADDOP.getText()+"" +$u.name_line +"\n"
    );
        $name_line=$ADDOP.getText()+"" +$u.name_line;
    }
    | NOT u=unary_expression
    {
        $isConst = false;
        writeIntoParserLogFile(
        "Line "
        + $u.stop.getLine() + ": unary_expression : NOT unary_expression\n\n" +$NOT.getText()+"" +$u.name_line +"\n"
    );
        $name_line=$NOT.getText()+"" +$u.name_line;
    }
    | f=factor
    {
        $isConst = true;
        if(!$f.name_line.equalsIgnoreCase("debug")){ 
            writeIntoParserLogFile(
            "Line "
            + $f.stop.getLine() + ": unary_expression : factor\n\n" +$f.name_line +"\n"
        );
         }

        $name_line=$f.name_line;
        $type=$f.type;
    }
    ;



factor
    returns [String name_line,String type]
    : v=variable
    {
        writeIntoParserLogFile(
        "Line "
        + $v.stop.getLine() + ": factor : variable\n\n" +$v.name_line +"\n"
    );
        $name_line=$v.name_line;
    }
    | ID LPAREN RPAREN
    { 
        newLabel();
        writeIntoAsmFile("\tCALL "+$ID.getText());    
        writeIntoAsmFile("\tPUSH AX;pushing the return value of function to stack");    
        writeIntoParserLogFile(
            "Line " + $RPAREN.getLine() + ": factor : ID LPAREN RPAREN\n"
        );   
        $name_line = $ID.getText() + "("  + ")";     
        SymbolInfo funcSymbol = Main.st.lookup($ID.getText());

    }
    | ID LPAREN a=argument_list RPAREN
    {
        writeIntoParserLogFile(
            "Line " + $RPAREN.getLine() + ": factor : ID LPAREN argument_list RPAREN\n"
        );
        $name_line = $ID.getText() + "(" + $a.name_line + ")";

        SymbolInfo funcSymbol = Main.st.lookup($ID.getText());

            if($ID.getText().equals("println"))
            {
                
                newLabel();
                SymbolInfo id = Main.st.lookup($a.name_line);
                if(id!=null)
                {
                    if(id.getStackOffset()!=-1)
                    {
                        writeIntoAsmFile("\tMOV AX,[BP-"+id.getStackOffset()+"]");
                        // writeIntoAsmFile("\tPUSH AX");
                        // stack_offset+=2;
                        writeIntoAsmFile("\tCALL print_output");
                        writeIntoAsmFile("\tCALL new_line");
                    }
                    else{
                            writeIntoAsmFile("\tMOV AX,"+$a.name_line);
                            // writeIntoAsmFile("\tPUSH AX");
                            // stack_offset+=2;
                            writeIntoAsmFile("\tCALL print_output");
                            writeIntoAsmFile("\tCALL new_line");
                     }
                }
                else {
                        writeIntoAsmFile("\tMOV AX,"+$a.name_line);
                        // writeIntoAsmFile("\tPUSH AX");
                        // stack_offset+=2;
                        writeIntoAsmFile("\tCALL print_output");
                        writeIntoAsmFile("\tCALL new_line");
                 }

            }
            else { 
                newLabel();
                List<String> actualArgs = new ArrayList<>();
                if (!$a.name_line.trim().isEmpty()) {
                    String[] argDefs = $a.name_line.split(",");
                    for (String def : argDefs) {
                        String[] tokens = def.trim().split(" ");
                        if (tokens.length > 0) {
                            actualArgs.add(tokens[0]);
                            
                        }
                    }
                }
                for(int i=actualArgs.size()-1;i>=0;i--)
                { 
                    SymbolInfo sym = Main.st.lookup(actualArgs.get(i));
                    if(sym == null)
                    { 
                        writeIntoAsmFile("\tPUSH "+actualArgs.get(i));
                    }
                    else{ 
                        int off = sym.getStackOffset();
                        if(off==-1)
                        { 
                            writeIntoAsmFile("\tPUSH "+actualArgs.get(i));
                        }
                        else{ 
                            writeIntoAsmFile("\tMOV AX,[BP-"+off+"]");
                            // writeIntoAsmFile("\tPUSH AX");
                            // stack_offset+=2;
                        }
                    }
                }
                writeIntoAsmFile("\tCALL "+$ID.getText());
                writeIntoAsmFile("\tPUSH AX;pushing the return value of function to stack");
            }
        if (funcSymbol == null) {
            Main.syntaxErrorCount++;
            

            writeIntoParserLogFile(
                "Error at line " + $RPAREN.getLine() + ": Undefined function " + $ID.getText() +  "\n"
                
            );
            writeIntoErrorFile(
                "Error at line " + $RPAREN.getLine() + ": Undefined function " + $ID.getText() +  "\n"
            );
        }

        else if (funcSymbol != null && funcSymbol.getIDType().equals("function")) {
        // if(funcSymbol.getName().equals("foo4")){
        // writeIntoParserLogFile(
        //     "debug "
        //     + $RPAREN.getLine() + ":"  + " "+ funcSymbol.getName() +  "return type:" + funcSymbol.returnType + "\n"
        // ); 

        // }
            $type= funcSymbol.returnType;
            List<String> expectedParams = funcSymbol.paramList;

            List<String> actualArgs = new ArrayList<>();
            if (!$a.name_line.trim().isEmpty()) {
                String[] argDefs = $a.name_line.split(",");
                for (String def : argDefs) {
                    String[] tokens = def.trim().split(" ");
                    if (tokens.length > 0) {
                        actualArgs.add(tokens[0]);
                    }
                }
            }

            if (expectedParams.size() != actualArgs.size()) {
                Main.syntaxErrorCount++;
                writeIntoParserLogFile(
                    "Error at line " + $RPAREN.getLine() + ": Total number of arguments mismatch with declaration in function " + $ID.getText() + "\n"
                );
                writeIntoErrorFile(
                  
                    "Error at line " + $RPAREN.getLine() + ": Total number of arguments mismatch with declaration in function " + $ID.getText() + "\n"
                );
            } else {
                for (int i = 0; i < expectedParams.size(); i++) {
                    String expected = expectedParams.get(i).toLowerCase();
                    String actual = actualArgs.get(i);
                    String actualIdType="not found";

                    if(Main.st.lookup(actual)!=null){
                        actualIdType = Main.st.lookup(actual).getIDType();
                    }else{
                        if (actual.contains(".")) {
                            actualIdType = "float";
                        }
                        else{ 
                            actualIdType = "int";
                        }
                    }

                    if (!expected.equals(actualIdType) && !actualIdType.equalsIgnoreCase("array")) {
                        Main.syntaxErrorCount++;
                        
                        // writeIntoParserLogFile(
                        //     "Actual: " + actualIdType + " ,Got: "+expected+ "expected id type: "+expected+"\n"
                            
                        // );
                        writeIntoParserLogFile(
                            "Error at line " + $RPAREN.getLine() + ": "+(i + 1)+ "th argument mismatch in function " + $ID.getText() +  "\n"
                            
                        );
                        writeIntoErrorFile(
                            "Error at line " + $RPAREN.getLine() + ": "+(i + 1)+ "th argument mismatch in function " + $ID.getText() +  "\n"
                        );
                        break;
                    }
                }
            }
            
        }
            writeIntoParserLogFile(
                $ID.getText() + "(" + $a.name_line + ")\n"
            );
    }

    | LPAREN e=expression RPAREN
    {
        writeIntoParserLogFile(
        "Line "
        + $RPAREN.getLine() + ": factor : LPAREN expression RPAREN\n\n" +"(" +$e.name_line +")\n"
    );
        $name_line="(" +$e.name_line +")";
    }
    | CONST_INT
    {
        newLabel();
        writeIntoAsmFile("\tMOV AX,"+$CONST_INT.getText());
        writeIntoAsmFile("\tPUSH AX");
        stack_offset += 2;
        writeIntoParserLogFile(
        "Line "
        + $CONST_INT.getLine() + ": factor : CONST_INT\n\n" +$CONST_INT.getText() +"\n"
    );
        $name_line=$CONST_INT.getText();
        $type="CONST_INT";
    }
    | CONST_FLOAT
    {
        newLabel();
        writeIntoAsmFile("\tMOV AX,"+$CONST_FLOAT.getText());
        writeIntoAsmFile("\tPUSH AX");
        stack_offset += 2;
        writeIntoParserLogFile(
        "Line "
        + $CONST_FLOAT.getLine() + ": factor : CONST_FLOAT\n\n" +$CONST_FLOAT.getText() +"\n"
    );
        $name_line=$CONST_FLOAT.getText();
        $type="CONST_FLOAT";
    }
    | v=variable INCOP
    {
        
        newLabel();
        //push the result to stack AX 

        SymbolInfo sym = Main.st.lookup($v.name_line);
        if(sym==null)
        { 
            //some constant
            writeIntoAsmFile("\tMOV AX,"+$v.name_line);
            writeIntoAsmFile("\tPUSH AX");
            stack_offset+=2;
        }
        else {
            int offset = sym.getStackOffset();
            if(offset==-1)
            {
                writeIntoAsmFile("\tMOV AX,"+$v.name_line);
                writeIntoAsmFile("\tINC AX");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
                writeIntoAsmFile("\tMOV "+$v.name_line+"AX");
            }
            else
            {
                writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
                writeIntoAsmFile("\tINC AX");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
                writeIntoAsmFile("\tMOV [BP-"+offset+"],AX");
            } 
        } 
        
        writeIntoParserLogFile(
        "Line "
        + $INCOP.getLine() + ": factor : variable INCOP\n\n" +$v.name_line +$INCOP.getText() +"\n"
    );
        $name_line=$v.name_line +$INCOP.getText();
    }
    | v=variable DECOP
    {
        
        newLabel();


        SymbolInfo sym = Main.st.lookup($v.name_line);
        if(sym==null)
        { 
            //some constant
            writeIntoAsmFile("\tMOV AX,"+$v.name_line);
            writeIntoAsmFile("\tPUSH AX");
            stack_offset+=2;
        }
        else {
            int offset = sym.getStackOffset();
            if(offset==-1)
            {
                writeIntoAsmFile("\tMOV AX,"+$v.name_line);
                writeIntoAsmFile("\tDEC AX");
                writeIntoAsmFile("\tMOV "+$v.name_line+"AX");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            }
            else
            {
                writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
                writeIntoAsmFile("\tDEC AX");
                writeIntoAsmFile("\tMOV [BP-"+offset+"],AX");
                // writeIntoAsmFile("\tPUSH AX");
                // stack_offset+=2;
            } 
        }         
        writeIntoParserLogFile(
        "Line "
        + $DECOP.getLine() + ": factor : variable DECOP\n\n" +$v.name_line +$DECOP.getText() +"\n"
    );
        $name_line=$v.name_line +$DECOP.getText();
    }
    ;

argument_list
returns [String name_line]
    : a=arguments
    {
        writeIntoParserLogFile(
        "Line "
        + $a.stop.getLine() + ": argument_list : arguments\n\n" +$a.name_line +"\n"
    );
        $name_line=$a.name_line;
    }
    | /* empty */
    ;

arguments
    returns [String name_line]
    : a=arguments COMMA l=logic_expression
    {
        writeIntoParserLogFile(
        "Line "
        + $l.stop.getLine() + ": arguments : arguments COMMA logic_expression\n\n" +$a.name_line + "," + $l.name_line +"\n"
    );
        $name_line=$a.name_line + "," + $l.name_line;
    }
    | l1=logic_expression
    {
        writeIntoParserLogFile(
        "Line "
        + $l1.stop.getLine() + ": arguments : logic_expression\n\n" +$l1.name_line +"\n"
    );
        $name_line=$l1.name_line;
    }
    ;
