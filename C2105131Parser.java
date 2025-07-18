// Generated from C2105131Parser.g4 by ANTLR 4.13.2

import java.io.BufferedWriter;
import java.io.IOException;
import SymbolTable.SymbolInfo;

import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class C2105131Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, BLOCK_COMMENT=2, STRING=3, WS=4, IF=5, CASE=6, SWITCH=7, 
		IN=8, TO=9, ELSE=10, FOR=11, FOREACH=12, FORIN=13, DO=14, WHILE=15, TIMES=16, 
		PRINTLN=17, RETURN=18, INT=19, FLOAT=20, VOID=21, BREAK=22, CONTINUE=23, 
		GOTO=24, COLON=25, QMARK=26, LPAREN=27, RPAREN=28, LCURL=29, RCURL=30, 
		LTHIRD=31, RTHIRD=32, SEMICOLON=33, COMMA=34, ADDOP=35, SUBOP=36, MULOP=37, 
		INCOP=38, DECOP=39, NOT=40, RELOP=41, LOGICOP=42, ASSIGNOP=43, ID=44, 
		CONST_INT=45, CONST_FLOAT=46, ERROR_CHAR=47;
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_unit = 2, RULE_func_declaration = 3, 
		RULE_func_definition = 4, RULE_parameter_list = 5, RULE_compound_statement = 6, 
		RULE_var_declaration = 7, RULE_declaration_list_err = 8, RULE_type_specifier = 9, 
		RULE_declaration_list = 10, RULE_statements = 11, RULE_statement = 12, 
		RULE_case_statements = 13, RULE_case_statement = 14, RULE_expression_statement = 15, 
		RULE_forin_statement = 16, RULE_foreach_statement = 17, RULE_variable = 18, 
		RULE_expression = 19, RULE_ternary_expression = 20, RULE_logic_expression = 21, 
		RULE_rel_expression = 22, RULE_simple_expression = 23, RULE_term = 24, 
		RULE_unary_expression = 25, RULE_factor = 26, RULE_argument_list = 27, 
		RULE_arguments = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program", "unit", "func_declaration", "func_definition", "parameter_list", 
			"compound_statement", "var_declaration", "declaration_list_err", "type_specifier", 
			"declaration_list", "statements", "statement", "case_statements", "case_statement", 
			"expression_statement", "forin_statement", "foreach_statement", "variable", 
			"expression", "ternary_expression", "logic_expression", "rel_expression", 
			"simple_expression", "term", "unary_expression", "factor", "argument_list", 
			"arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'if'", "'case'", "'switch'", "'in'", "'to'", 
			"'else'", "'for'", "'foreach'", "'forin'", "'do'", "'while'", "'times'", 
			"'printf'", "'return'", "'int'", "'float'", "'void'", "'break'", "'continue'", 
			"'goto'", "':'", "'?'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", 
			"','", null, null, null, "'++'", "'--'", "'!'", null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "CASE", 
			"SWITCH", "IN", "TO", "ELSE", "FOR", "FOREACH", "FORIN", "DO", "WHILE", 
			"TIMES", "PRINTLN", "RETURN", "INT", "FLOAT", "VOID", "BREAK", "CONTINUE", 
			"GOTO", "COLON", "QMARK", "LPAREN", "RPAREN", "LCURL", "RCURL", "LTHIRD", 
			"RTHIRD", "SEMICOLON", "COMMA", "ADDOP", "SUBOP", "MULOP", "INCOP", "DECOP", 
			"NOT", "RELOP", "LOGICOP", "ASSIGNOP", "ID", "CONST_INT", "CONST_FLOAT", 
			"ERROR_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C2105131Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    int stack_offset = 0;
	    int prev_offset = 0;
	    int prev_main_offset = 0;
	    int label = 0;
	    boolean code = false;
	    int paramSize = 0;
	    int sub = 0;
	    int prev_sub = 0;
	    Stack<String> stack = new Stack<>();
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


	public C2105131Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ProgramContext p;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
			        writeIntoAsmFile(".MODEL SMALL\n.STACK 1000H");
			        writeIntoAsmFile(".Data");
			        writeIntoAsmFile("\t CR EQU 0DH");
			        writeIntoAsmFile("\t LF EQU 0AH");
			        writeIntoAsmFile("\t number DB \"00000$\"");
			    
			setState(59);
			((StartContext)_localctx).p = program(0);

			    writeIntoParserLogFile(
			        "Line "+  (((StartContext)_localctx).p!=null?(((StartContext)_localctx).p.stop):null).getLine() + ": start : program\n"
			    );         
			        writeIntoParserLogFile(Main.st.getAllScopesAsString());
			        writeIntoParserLogFile(
			            "Total number of lines: "
			            + (((StartContext)_localctx).p!=null?(((StartContext)_localctx).p.stop):null).getLine() 
			        );
			        writeIntoParserLogFile(
			            "Total number of errors: "
			            + Main.syntaxErrorCount
			        );
			        writeIntoAsmFile("end main");
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public String name_line;
		public ProgramContext p;
		public UnitContext u;
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		return program(0);
	}

	private ProgramContext program(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ProgramContext _localctx = new ProgramContext(_ctx, _parentState);
		ProgramContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_program, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(63);
			((ProgramContext)_localctx).u = unit();

			    writeIntoParserLogFile(
			        "Line "+  (((ProgramContext)_localctx).u!=null?(((ProgramContext)_localctx).u.stop):null).getLine() + ": program : unit\n\n" + ((ProgramContext)_localctx).u.name_line + "\n"
			    ); 
			    ((ProgramContext)_localctx).name_line =  ((ProgramContext)_localctx).u.name_line;
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ProgramContext(_parentctx, _parentState);
					_localctx.p = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_program);
					setState(66);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(67);
					((ProgramContext)_localctx).u = unit();

					              writeIntoParserLogFile(
					                  "Line "+  (((ProgramContext)_localctx).u!=null?(((ProgramContext)_localctx).u.stop):null).getLine() + ": program : program unit\n\n" + ((ProgramContext)_localctx).p.name_line + "\n" + ((ProgramContext)_localctx).u.name_line + "\n"
					              ); 
					              ((ProgramContext)_localctx).name_line = ((ProgramContext)_localctx).p.name_line + "\n" + ((ProgramContext)_localctx).u.name_line;
					              
					}
					} 
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnitContext extends ParserRuleContext {
		public String name_line;
		public Var_declarationContext v;
		public Func_declarationContext f;
		public Func_definitionContext f1;
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public Func_declarationContext func_declaration() {
			return getRuleContext(Func_declarationContext.class,0);
		}
		public Func_definitionContext func_definition() {
			return getRuleContext(Func_definitionContext.class,0);
		}
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitUnit(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unit);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				((UnitContext)_localctx).v = var_declaration();

				    writeIntoParserLogFile(
				        "Line "+  (((UnitContext)_localctx).v!=null?(((UnitContext)_localctx).v.stop):null).getLine() + ": unit : var_declaration\n\n" + ((UnitContext)_localctx).v.name_line + "\n"
				    ); 
				    ((UnitContext)_localctx).name_line = ((UnitContext)_localctx).v.name_line;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				((UnitContext)_localctx).f = func_declaration();

				    writeIntoParserLogFile(
				        "Line "+  (((UnitContext)_localctx).f!=null?(((UnitContext)_localctx).f.stop):null).getLine() + ": unit : func_declaration\n\n" + ((UnitContext)_localctx).f.name_line + "\n"
				    ); 
				    ((UnitContext)_localctx).name_line = ((UnitContext)_localctx).f.name_line;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				((UnitContext)_localctx).f1 = func_definition();

				    writeIntoParserLogFile(
				        "Line "+  (((UnitContext)_localctx).f1!=null?(((UnitContext)_localctx).f1.stop):null).getLine() + ": unit : func_definition\n\n" + ((UnitContext)_localctx).f1.name_line + "\n"
				    ); 
				    ((UnitContext)_localctx).name_line = ((UnitContext)_localctx).f1.name_line;
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_declarationContext extends ParserRuleContext {
		public String name_line;
		public Type_specifierContext t;
		public Token ID;
		public Parameter_listContext p;
		public Token sm;
		public TerminalNode ID() { return getToken(C2105131Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105131Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105131Parser.RPAREN, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(C2105131Parser.SEMICOLON, 0); }
		public Func_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterFunc_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitFunc_declaration(this);
		}
	}

	public final Func_declarationContext func_declaration() throws RecognitionException {
		Func_declarationContext _localctx = new Func_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_declaration);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				((Func_declarationContext)_localctx).t = type_specifier();
				setState(87);
				((Func_declarationContext)_localctx).ID = match(ID);
				setState(88);
				match(LPAREN);
				setState(89);
				((Func_declarationContext)_localctx).p = parameter_list(0);
				setState(90);
				match(RPAREN);
				setState(91);
				((Func_declarationContext)_localctx).sm = match(SEMICOLON);

				        writeIntoParserLogFile(
				            "Line "
				            + ((Func_declarationContext)_localctx).sm.getLine() + ": func_declaration : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON\n\n" +(((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null) + " "+ ((Func_declarationContext)_localctx).ID.getText() + "(" + ((Func_declarationContext)_localctx).p.name_line +")"+ ";\n"
				        ); 
				        ((Func_declarationContext)_localctx).name_line = (((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null) + " "+ ((Func_declarationContext)_localctx).ID.getText() + "(" + ((Func_declarationContext)_localctx).p.name_line +");";    
				   
				        String printingLine =  "< " + ((Func_declarationContext)_localctx).ID.getText() + " : " + "ID" + " >";
				        SymbolInfo sym = new SymbolInfo(((Func_declarationContext)_localctx).ID.getText(),"ID",printingLine,"function");

				        sym.returnType = (((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null); 
				        sym.paramNumber = ((Func_declarationContext)_localctx).p.paramNumber;

				        String[] paramDefs = ((Func_declarationContext)_localctx).p.name_line.split(",");
				        for (String def : paramDefs) {
				            String type = def.trim().split(" ")[0];
				            sym.paramList.add(type);
				        }

				        // writeIntoErrorFile(
				        //     "debug at setting  "
				        //     + ((Func_declarationContext)_localctx).sm.getLine() + ":" +sym.paramList.get(0) + " "+ sym.getIDType() + " " + sym.getName() +" is the function name\n"
				        // );          
				        Main.st.insert(sym);
				        Main.pendingInsertions.clear();
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				((Func_declarationContext)_localctx).t = type_specifier();
				setState(95);
				((Func_declarationContext)_localctx).ID = match(ID);
				setState(96);
				match(LPAREN);
				setState(97);
				match(RPAREN);
				setState(98);
				((Func_declarationContext)_localctx).sm = match(SEMICOLON);

				        writeIntoParserLogFile(
				            "Line "
				            + ((Func_declarationContext)_localctx).sm.getLine() + ": func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n\n" +(((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null) + " "+ ((Func_declarationContext)_localctx).ID.getText() + "()"+ ";\n"
				        );   
				        ((Func_declarationContext)_localctx).name_line =  (((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null) + " "+ ((Func_declarationContext)_localctx).ID.getText() + "();";         
				        String printingLine =  "< " + ((Func_declarationContext)_localctx).ID.getText() + " : " + "ID" + " >";
				        // writeIntoErrorFile(
				        //     "debug "
				        //     + ((Func_declarationContext)_localctx).sm.getLine() + ": func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n\n" +((Func_declarationContext)_localctx).t.name_line + " "+ ((Func_declarationContext)_localctx).ID.getText() + "()"+ ";\n"
				        // );        
				        SymbolInfo sym = new SymbolInfo(((Func_declarationContext)_localctx).ID.getText(),"ID",printingLine,"function");
				        sym.returnType = (((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null); 

				        Main.st.insert(sym);
				      
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_definitionContext extends ParserRuleContext {
		public String name_line;
		public Type_specifierContext t;
		public Token ID;
		public Parameter_listContext p;
		public Compound_statementContext c;
		public TerminalNode ID() { return getToken(C2105131Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105131Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105131Parser.RPAREN, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterFunc_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitFunc_definition(this);
		}
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_definition);
		try {
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				((Func_definitionContext)_localctx).t = type_specifier();
				setState(104);
				((Func_definitionContext)_localctx).ID = match(ID);

				        if(!code)
				        { 
				            writeIntoAsmFile(".CODE");
				            code = true;
				        }
				        
				        writeIntoAsmFile(((Func_definitionContext)_localctx).ID.getText()+" PROC");
				        writeIntoAsmFile("\tPUSH BP");
				        writeIntoAsmFile("\tMOV BP,SP");
				    
				setState(106);
				match(LPAREN);
				setState(107);
				((Func_definitionContext)_localctx).p = parameter_list(0);

				        
				        prev_offset = stack_offset;
				        prev_sub = sub;
				        prev_main_offset = Main.prev_stack_off;
				        //writeIntoAsmFile("prev off: "+prev_offset+" in ((Func_definitionContext)_localctx).ID.getText()");

				        if(((Func_definitionContext)_localctx).ID.getText().equals("main"))
				        { 
				            prev_offset=0;
				            prev_main_offset = 0;
				            prev_sub = 0;
				        }
				        stack_offset = 0;
				        Main.prev_stack_off = 0;
				        if(Main.lookup(((Func_definitionContext)_localctx).ID.getText())){
				            SymbolInfo s = Main.st.lookup(((Func_definitionContext)_localctx).ID.getText());
				            if(!s.getIDType().equalsIgnoreCase("function")){
				                
				                    Main.syntaxErrorCount++;

				                    writeIntoParserLogFile(
				                        "Error at line " + ((Func_definitionContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Func_definitionContext)_localctx).ID.getText() + "\n"
				                    ); 

				                    writeIntoErrorFile(
				                        "Error at line " + ((Func_definitionContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Func_definitionContext)_localctx).ID.getText() + "\n"
				                    ); 


				            } else if(s.getIDType().equalsIgnoreCase("function")){


				                if(!s.returnType.equalsIgnoreCase((((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null))){


				                    Main.syntaxErrorCount++;

				                    writeIntoParserLogFile(
				                        "Error at line " + ((Func_definitionContext)_localctx).ID.getLine() + ": Return type mismatch of " + ((Func_definitionContext)_localctx).ID.getText() + "\n"
				                    ); 

				                    writeIntoErrorFile(
				                        "Error at line " + ((Func_definitionContext)_localctx).ID.getLine() + ": Return type mismatch of " + ((Func_definitionContext)_localctx).ID.getText() + "\n"
				                    ); 

				                }

				                else if(s.paramNumber!=((Func_definitionContext)_localctx).p.paramNumber){


				                    Main.syntaxErrorCount++;

				                    writeIntoParserLogFile(
				                        "Error at line " + ((Func_definitionContext)_localctx).ID.getLine() + ": Total number of arguments mismatch with declaration in function " + ((Func_definitionContext)_localctx).ID.getText() + "\n"
				                    ); 

				                    writeIntoErrorFile(
				                        "Error at line " + ((Func_definitionContext)_localctx).ID.getLine() + ": Total number of arguments mismatch with declaration in function " + ((Func_definitionContext)_localctx).ID.getText() + "\n"
				                    ); 


				                }
				            } 
				        } else {


				            String printingLine =  "< " + ((Func_definitionContext)_localctx).ID.getText() + " : " + "ID" + " >";
				            SymbolInfo sym = new SymbolInfo(((Func_definitionContext)_localctx).ID.getText(),"ID",printingLine,"function");
				            sym.returnType=(((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null); 

				            Main.st.insert(sym);
				            Main.st.enterScope();           

				            String[] paramDefs = ((Func_definitionContext)_localctx).p.name_line.split(",");
				            paramSize= paramDefs.length;
				            int paramOff=2;
				            for (String def : paramDefs) {
				                paramOff += 2;
				                //writeIntoAsmFile("stack offset in params made: "+stack_offset);
				                String type = def.trim().split(" ")[0];
				                String name = def.trim().split(" ")[1];
				                sym.paramList.add(type);
				                String print = "<"+name+","+"ID>";
				                SymbolInfo param = new SymbolInfo(name,"ID",print);
				                param.setStackOffset(-paramOff);
				                Main.st.insert(param);
				            }
				            Main.pendingInsertions.clear();

				        } 

				    
				setState(109);
				match(RPAREN);
				setState(110);
				((Func_definitionContext)_localctx).c = compound_statement();

				        
				        if(((Func_definitionContext)_localctx).c.retuurn && (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null).equalsIgnoreCase("void")){
				            Main.syntaxErrorCount++;

				            writeIntoParserLogFile(
				                "Error at line " + (((Func_definitionContext)_localctx).c!=null?(((Func_definitionContext)_localctx).c.stop):null).getLine() + ": Cannot return value from function " + ((Func_definitionContext)_localctx).ID.getText() + " with void return type \n"
				            ); 

				            writeIntoErrorFile(
				                "Error at line " + (((Func_definitionContext)_localctx).c!=null?(((Func_definitionContext)_localctx).c.stop):null).getLine() + ": Cannot return value from function " + ((Func_definitionContext)_localctx).ID.getText() + " with void return type \n"
				            ); 


				        }

				        writeIntoParserLogFile(
				            "Line "
				            + (((Func_definitionContext)_localctx).c!=null?(((Func_definitionContext)_localctx).c.stop):null).getLine() + ": func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement\n\n" +(((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null) + " "+ ((Func_definitionContext)_localctx).ID.getText() + "("+((Func_definitionContext)_localctx).p.name_line+ ")"+ ((Func_definitionContext)_localctx).c.name_line + "\n"
				        );          
				        ((Func_definitionContext)_localctx).name_line =  (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null) + " "+ ((Func_definitionContext)_localctx).ID.getText() + "("+((Func_definitionContext)_localctx).p.name_line+ ")"+ ((Func_definitionContext)_localctx).c.name_line;
				        //Main.st.insert(((Func_definitionContext)_localctx).ID.getText(),"ID");

				        
				        // for(int i=0;i<stack_offset;i++)
				        // { 
				        //     writeIntoAsmFile("\tPOPPINGG AX");
				        // }
				        while(sub>0)
				        { 
				            writeIntoAsmFile("\tADD SP,2");
				            sub -= 2;
				        }
				        writeIntoAsmFile("\tPOP BP");
				        
				        writeIntoAsmFile("\tRET "+(paramSize)*2);
				        stack_offset = prev_offset;
				        Main.prev_stack_off = prev_main_offset;
				        sub = prev_sub;

				        //writeIntoAsmFile("stack offset restoring from "+stack_offset + " to "+prev_offset);

				        writeIntoAsmFile(((Func_definitionContext)_localctx).ID.getText()+" ENDP");
				        exitScope();

				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				((Func_definitionContext)_localctx).t = type_specifier();
				setState(114);
				((Func_definitionContext)_localctx).ID = match(ID);

				        
				        if(!((Func_definitionContext)_localctx).ID.getText().equalsIgnoreCase("main")){ 
				            prev_offset = stack_offset;
				            prev_main_offset = Main.prev_stack_off;
				            stack_offset = 0;
				            Main.prev_stack_off = 0;
				            prev_sub = sub;
				        }

				        if(((Func_definitionContext)_localctx).ID.getText().equals("main"))
				        { 
				            prev_offset=0;
				            prev_main_offset = 0;
				            prev_sub=0;
				        }
				        //writeIntoAsmFile("prev off: "+prev_offset+" in ((Func_definitionContext)_localctx).ID.getText()");

				        if(Main.lookup(((Func_definitionContext)_localctx).ID.getText())){
				            SymbolInfo s = Main.st.lookup(((Func_definitionContext)_localctx).ID.getText());
				            if(!s.getIDType().equalsIgnoreCase("function")){
				                
				                    Main.syntaxErrorCount++;

				                    writeIntoParserLogFile(
				                        "Error at line " + ((Func_definitionContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Func_definitionContext)_localctx).ID.getText() + "\n"
				                    ); 

				                    writeIntoErrorFile(
				                        "Error at line " + ((Func_definitionContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Func_definitionContext)_localctx).ID.getText() + "\n"
				                    ); 


				            } else if(s.getIDType().equalsIgnoreCase("function")){


				                if(!s.returnType.equalsIgnoreCase((((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null))){


				                    Main.syntaxErrorCount++;

				                    writeIntoParserLogFile(
				                        "Error at line " + ((Func_definitionContext)_localctx).ID.getLine() + ": Return type mismatch of " + ((Func_definitionContext)_localctx).ID.getText() + "\n"
				                    ); 

				                    writeIntoErrorFile(
				                        "Error at line " + ((Func_definitionContext)_localctx).ID.getLine() + ": Return type mismatch of " + ((Func_definitionContext)_localctx).ID.getText() + "\n"
				                    ); 

				                }
				            } 
				        } else {

				                String printingLine =  "< " + ((Func_definitionContext)_localctx).ID.getText() + " : " + "ID" + " >";
				                SymbolInfo sym = new SymbolInfo(((Func_definitionContext)_localctx).ID.getText(),"ID",printingLine,"function");
				                sym.returnType = (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null); 

				                Main.st.insert(sym);
				                Main.st.enterScope();

				                if(((Func_definitionContext)_localctx).ID.getText().equalsIgnoreCase("main"))
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
				                    writeIntoAsmFile(((Func_definitionContext)_localctx).ID.getText() +" PROC");
				                    writeIntoAsmFile("\tPUSH BP");
				                    writeIntoAsmFile("\tMOV BP,SP");
				                }

				        }
				    
				setState(116);
				match(LPAREN);
				setState(117);
				match(RPAREN);
				setState(118);
				((Func_definitionContext)_localctx).c = compound_statement();

				        writeIntoParserLogFile(
				            "Line "
				            + (((Func_definitionContext)_localctx).c!=null?(((Func_definitionContext)_localctx).c.stop):null).getLine() + ": func_definition : type_specifier ID LPAREN RPAREN compound_statement\n\n" +(((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null) + " "+ ((Func_definitionContext)_localctx).ID.getText() + "()"+ ((Func_definitionContext)_localctx).c.name_line + "\n"
				        );          
				        ((Func_definitionContext)_localctx).name_line =  (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null) + " "+ ((Func_definitionContext)_localctx).ID.getText() + "()"+ ((Func_definitionContext)_localctx).c.name_line;


				        
				        writeIntoAsmFile("\tPOP BP");

				        while(sub>0)
				        { 
				            writeIntoAsmFile("\tADD SP,2");
				            sub -= 2;
				        }
				        if(((Func_definitionContext)_localctx).ID.getText().equalsIgnoreCase("main")){ 
				            writeIntoAsmFile("\tMOV AX,4CH");
				            writeIntoAsmFile("\tINT 21H");
				            
				        }
				        if(!((Func_definitionContext)_localctx).ID.getText().equalsIgnoreCase("main")){ 

				            writeIntoAsmFile("\tRET");
				        }
				        
				        

				        // writeIntoAsmFile("sub: "+sub);

				        
				            stack_offset=prev_offset;
				            Main.prev_stack_off = prev_main_offset;
				            sub = prev_sub;


				            //writeIntoAsmFile("stack offset restoring from "+stack_offset + " to "+prev_offset);
				            writeIntoAsmFile(((Func_definitionContext)_localctx).ID.getText()+" ENDP");
				       
				        	
					
				        if(((Func_definitionContext)_localctx).ID.getText().equalsIgnoreCase("main"))
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
				        exitScope();
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_listContext extends ParserRuleContext {
		public String name_line;
		public int paramNumber;
		public Parameter_listContext p;
		public Type_specifierContext t;
		public Token ID;
		public Token ADDOP;
		public TerminalNode ID() { return getToken(C2105131Parser.ID, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(C2105131Parser.ADDOP, 0); }
		public TerminalNode COMMA() { return getToken(C2105131Parser.COMMA, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterParameter_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitParameter_list(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		return parameter_list(0);
	}

	private Parameter_listContext parameter_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, _parentState);
		Parameter_listContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_parameter_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(124);
				((Parameter_listContext)_localctx).t = type_specifier();
				setState(125);
				((Parameter_listContext)_localctx).ID = match(ID);

				        ((Parameter_listContext)_localctx).paramNumber =  1;
				        boolean alreadyDeclared = false;
				        for (SymbolInfo si : Main.pendingInsertions) {
				            if (si.getName().equals(((Parameter_listContext)_localctx).ID.getText())) {
				                alreadyDeclared = true;
				                break;
				            }
				        }

				        if (alreadyDeclared) {
				            Main.syntaxErrorCount++;
				            writeIntoParserLogFile(
				                "Error at line " + ((Parameter_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Parameter_listContext)_localctx).ID.getText() + " in parameter\n"
				            ); 
				            writeIntoErrorFile(
				                "Error at line " + ((Parameter_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Parameter_listContext)_localctx).ID.getText() + " in parameter\n"
				            );           
				        } else {
				            addToPendingList(((Parameter_listContext)_localctx).ID.getText(), (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));
				        }       
				        writeIntoParserLogFile(
				            "Line "
				            + (((Parameter_listContext)_localctx).t!=null?(((Parameter_listContext)_localctx).t.stop):null).getLine() + ": parameter_list : type_specifier ID\n\n" + (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + " " + ((Parameter_listContext)_localctx).ID.getText() + "\n"
				        );          
				        ((Parameter_listContext)_localctx).name_line =  (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + " " + ((Parameter_listContext)_localctx).ID.getText();
				        // addToPendingList(((Parameter_listContext)_localctx).ID.getText(),(((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));  
				    
				}
				break;
			case 2:
				{
				setState(128);
				((Parameter_listContext)_localctx).t = type_specifier();

				        writeIntoParserLogFile(
				            "Line "
				            + (((Parameter_listContext)_localctx).t!=null?(((Parameter_listContext)_localctx).t.stop):null).getLine() + ": parameter_list : type_specifier\n\n" + (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + "\n"
				        );          
				        ((Parameter_listContext)_localctx).name_line =  (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) ;
				    
				}
				break;
			case 3:
				{
				setState(131);
				((Parameter_listContext)_localctx).t = type_specifier();
				setState(132);
				((Parameter_listContext)_localctx).ADDOP = match(ADDOP);
				 
				        Main.syntaxErrorCount++;
				        writeIntoParserLogFile(
				            "Line "
				            + (((Parameter_listContext)_localctx).t!=null?(((Parameter_listContext)_localctx).t.stop):null).getLine() + ": parameter_list : type_specifier\n\n" + (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + "\n"
				        ); 
				        writeIntoParserLogFile(
				            "Error at line " + ((Parameter_listContext)_localctx).ADDOP.getLine() + ": syntax error, unexpected ADDOP, expecting RPAREN or COMMA\n"
				        ); 
				        writeIntoErrorFile(
				            "Error at line " + ((Parameter_listContext)_localctx).ADDOP.getLine() + ": syntax error, unexpected ADDOP, expecting RPAREN or COMMA\n"
				        );  
				        ((Parameter_listContext)_localctx).name_line =  (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null);      
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(148);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						_localctx.p = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(137);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(138);
						match(COMMA);
						setState(139);
						((Parameter_listContext)_localctx).t = type_specifier();
						setState(140);
						((Parameter_listContext)_localctx).ID = match(ID);

						                  ((Parameter_listContext)_localctx).paramNumber =  ((Parameter_listContext)_localctx).p.paramNumber + 1;

						                  boolean alreadyDeclared = false;
						                  for (SymbolInfo si : Main.pendingInsertions) {
						                      if (si.getName().equals(((Parameter_listContext)_localctx).ID.getText())) {
						                          alreadyDeclared = true;
						                          break;
						                      }
						                  }

						                  if (alreadyDeclared) {
						                      Main.syntaxErrorCount++;
						                      writeIntoParserLogFile(
						                          "Error at line " + ((Parameter_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Parameter_listContext)_localctx).ID.getText() + " in parameter\n"
						                      ); 
						                      writeIntoErrorFile(
						                          "Error at line " + ((Parameter_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Parameter_listContext)_localctx).ID.getText() + " in parameter\n"
						                      );           
						                  } else {
						                      addToPendingList(((Parameter_listContext)_localctx).ID.getText(), (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));
						                  }
						                
						                  writeIntoParserLogFile(
						                      "Line "
						                      + ((Parameter_listContext)_localctx).ID.getLine() + ": parameter_list : parameter_list COMMA type_specifier ID\n\n" + ((Parameter_listContext)_localctx).p.name_line + ","+ (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + " " + ((Parameter_listContext)_localctx).ID.getText() + "\n"
						                  );          
						                  ((Parameter_listContext)_localctx).name_line =  ((Parameter_listContext)_localctx).p.name_line + ","+ (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + " " + ((Parameter_listContext)_localctx).ID.getText();
						              //addToPendingList(((Parameter_listContext)_localctx).ID.getText(),(((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));  
						              
						}
						break;
					case 2:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						_localctx.p = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(143);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(144);
						match(COMMA);
						setState(145);
						((Parameter_listContext)_localctx).t = type_specifier();

						                  writeIntoParserLogFile(
						                      "Line "
						                      + (((Parameter_listContext)_localctx).t!=null?(((Parameter_listContext)_localctx).t.stop):null).getLine() + ": parameter_list : parameter_list COMMA type_specifier\n\n" + ((Parameter_listContext)_localctx).p.name_line + ","+ (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + "\n"
						                  );          
						                  ((Parameter_listContext)_localctx).name_line =  ((Parameter_listContext)_localctx).p.name_line + ","+ (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null);
						              
						}
						break;
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Compound_statementContext extends ParserRuleContext {
		public String name_line;
		public boolean retuurn;
		public StatementsContext stmts;
		public Token RCURL;
		public TerminalNode LCURL() { return getToken(C2105131Parser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(C2105131Parser.RCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterCompound_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitCompound_statement(this);
		}
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compound_statement);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(LCURL);

				        //enterNewScope();
				    
				setState(155);
				((Compound_statementContext)_localctx).stmts = statements(0);
				setState(156);
				((Compound_statementContext)_localctx).RCURL = match(RCURL);

				        
				        writeIntoParserLogFile(
				            "Line " + ((Compound_statementContext)_localctx).RCURL.getLine() + ": compound_statement : LCURL statements RCURL\n\n{\n" + ((Compound_statementContext)_localctx).stmts.name_line + "\n}\n"
				        );
				        ((Compound_statementContext)_localctx).name_line =  "{\n" + ((Compound_statementContext)_localctx).stmts.name_line + "\n}";
				        ((Compound_statementContext)_localctx).retuurn = ((Compound_statementContext)_localctx).stmts.retuurn;
				        //exitScope();
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(LCURL);
				setState(160);
				((Compound_statementContext)_localctx).RCURL = match(RCURL);

				        //enterNewScope();
				        writeIntoParserLogFile(
				            "Line " + ((Compound_statementContext)_localctx).RCURL.getLine() + ": compound_statement : LCURL RCURL\n\n{}\n"
				        );
				        ((Compound_statementContext)_localctx).name_line =  "{}";
				        exitScope();
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_declarationContext extends ParserRuleContext {
		public String name_line;
		public Type_specifierContext t;
		public Declaration_listContext dl;
		public Token sm;
		public Declaration_list_errContext de;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(C2105131Parser.SEMICOLON, 0); }
		public Declaration_list_errContext declaration_list_err() {
			return getRuleContext(Declaration_list_errContext.class,0);
		}
		public Var_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterVar_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitVar_declaration(this);
		}
	}

	public final Var_declarationContext var_declaration() throws RecognitionException {
		Var_declarationContext _localctx = new Var_declarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_declaration);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(165);
				((Var_declarationContext)_localctx).dl = declaration_list(0);
				setState(166);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);


				        writeIntoParserLogFile(
				            "Line "
				            + ((Var_declarationContext)_localctx).sm.getLine() + ": var_declaration : type_specifier declaration_list SEMICOLON\n"  
				        );

				        if((((Var_declarationContext)_localctx).t!=null?_input.getText(((Var_declarationContext)_localctx).t.start,((Var_declarationContext)_localctx).t.stop):null).equalsIgnoreCase("void")){

				                Main.syntaxErrorCount++;

				                writeIntoParserLogFile(
				                    "Error at line " + ((Var_declarationContext)_localctx).sm.getLine() + ": Variable type cannot be void" + "\n"
				                ); 

				                writeIntoErrorFile(
				                    "Error at line " + ((Var_declarationContext)_localctx).sm.getLine() + ": Variable type cannot be void"  + "\n"
				                ); 

				        }

				        writeIntoParserLogFile(
				            (((Var_declarationContext)_localctx).t!=null?_input.getText(((Var_declarationContext)_localctx).t.start,((Var_declarationContext)_localctx).t.stop):null) +  " " + ((Var_declarationContext)_localctx).dl.name_line + ";\n"
				        );

				        



				        ((Var_declarationContext)_localctx).name_line =  (((Var_declarationContext)_localctx).t!=null?_input.getText(((Var_declarationContext)_localctx).t.start,((Var_declarationContext)_localctx).t.stop):null) +  " " + ((Var_declarationContext)_localctx).dl.name_line+";";   
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
				            
				            stack_offset += 2;
				            //writeIntoAsmFile("stack offset made:"+stack_offset);
				            for(SymbolInfo item: Main.pendingInsertions)
				            { 
				                writeIntoAsmFile("\tSUB SP,2");
				                sub += 2;

				            }
				        }
				        Main.addToSymbolTable((((Var_declarationContext)_localctx).t!=null?_input.getText(((Var_declarationContext)_localctx).t.start,((Var_declarationContext)_localctx).t.stop):null),stack_offset);   
				        writeIntoParserLogFile("symbol table scope id : " + Main.st.getCurrentScope().getId()+" ,added" + ((Var_declarationContext)_localctx).dl.name_line);
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(170);
				((Var_declarationContext)_localctx).de = declaration_list_err();
				setState(171);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

				        writeIntoErrorFile(
				            "Line# "
				            + ((Var_declarationContext)_localctx).sm.getLine()
				            + " with error name: "
				            + ((Var_declarationContext)_localctx).de.error_name
				            + " - Syntax error at declaration list of variable declaration"
				        );
				        //Main.syntaxErrorCount++;
				      
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_list_errContext extends ParserRuleContext {
		public String error_name;
		public Declaration_list_errContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list_err; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterDeclaration_list_err(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitDeclaration_list_err(this);
		}
	}

	public final Declaration_list_errContext declaration_list_err() throws RecognitionException {
		Declaration_list_errContext _localctx = new Declaration_list_errContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration_list_err);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Declaration_list_errContext)_localctx).error_name =  "Error in declaration list"; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specifierContext extends ParserRuleContext {
		public String name_line;
		public Token INT;
		public Token FLOAT;
		public Token VOID;
		public TerminalNode INT() { return getToken(C2105131Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(C2105131Parser.FLOAT, 0); }
		public TerminalNode VOID() { return getToken(C2105131Parser.VOID, 0); }
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterType_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitType_specifier(this);
		}
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type_specifier);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				((Type_specifierContext)_localctx).INT = match(INT);

				        writeIntoParserLogFile(
				            "Line "
				            + ((Type_specifierContext)_localctx).INT.getLine() + ": type_specifier : INT\n\n" + ((Type_specifierContext)_localctx).INT.getText() + "\n"
				        );        
				        ((Type_specifierContext)_localctx).name_line =  "type: INT at line" + ((Type_specifierContext)_localctx).INT.getLine();
				      
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				((Type_specifierContext)_localctx).FLOAT = match(FLOAT);

				        writeIntoParserLogFile(
				            "Line "
				            + ((Type_specifierContext)_localctx).FLOAT.getLine() + ": type_specifier : FLOAT\n\n" + ((Type_specifierContext)_localctx).FLOAT.getText() + "\n"
				        );              
				        ((Type_specifierContext)_localctx).name_line =  "type: FLOAT at line" + ((Type_specifierContext)_localctx).FLOAT.getLine();
				      
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				((Type_specifierContext)_localctx).VOID = match(VOID);

				        writeIntoParserLogFile(
				            "Line "
				            + ((Type_specifierContext)_localctx).VOID.getLine() + ": type_specifier : VOID\n\n" + ((Type_specifierContext)_localctx).VOID.getText() + "\n"
				        );              
				        ((Type_specifierContext)_localctx).name_line =  "type: VOID at line" + ((Type_specifierContext)_localctx).VOID.getLine();
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_listContext extends ParserRuleContext {
		public String name_line;
		public Declaration_listContext dec1;
		public Declaration_listContext dec2;
		public Declaration_listContext dec3;
		public Token ID;
		public Token CONST_INT;
		public TerminalNode ID() { return getToken(C2105131Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C2105131Parser.LTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(C2105131Parser.CONST_INT, 0); }
		public TerminalNode RTHIRD() { return getToken(C2105131Parser.RTHIRD, 0); }
		public TerminalNode COMMA() { return getToken(C2105131Parser.COMMA, 0); }
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(C2105131Parser.ADDOP, 0); }
		public Declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterDeclaration_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitDeclaration_list(this);
		}
	}

	public final Declaration_listContext declaration_list() throws RecognitionException {
		return declaration_list(0);
	}

	private Declaration_listContext declaration_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, _parentState);
		Declaration_listContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_declaration_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(187);
				((Declaration_listContext)_localctx).ID = match(ID);

				        if(Main.st.getCurrentScope().getParent()!=null)
				        {
				            stack_offset += 2;
				        }
				        boolean b = lookUp(((Declaration_listContext)_localctx).ID.getText());
				        if(b==true){
				            Main.syntaxErrorCount++;
				        writeIntoParserLogFile(
				            "Error at line "
				            + ((Declaration_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Declaration_listContext)_localctx).ID.getText() + "\n"
				        );      
				        writeIntoErrorFile(
				            "Error at line "
				            + ((Declaration_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Declaration_listContext)_localctx).ID.getText() + "\n"            
				        );        
				        }
				        writeIntoParserLogFile(
				            "Line "
				            + ((Declaration_listContext)_localctx).ID.getLine() + ": declaration_list : ID\n\n" + ((Declaration_listContext)_localctx).ID.getText() + "\n"
				        );
				        ((Declaration_listContext)_localctx).name_line =  ((Declaration_listContext)_localctx).ID.getText();
				        addToPendingList(((Declaration_listContext)_localctx).ID.getText());            
				    
				}
				break;
			case 2:
				{
				setState(189);
				((Declaration_listContext)_localctx).ID = match(ID);
				setState(190);
				match(LTHIRD);
				setState(191);
				((Declaration_listContext)_localctx).CONST_INT = match(CONST_INT);
				setState(192);
				match(RTHIRD);

				        
				        boolean b = lookUp(((Declaration_listContext)_localctx).ID.getText());
				        if(b==true){
				            Main.syntaxErrorCount++;
				        writeIntoParserLogFile(
				            "Error at line "
				            + ((Declaration_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Declaration_listContext)_localctx).ID.getText() + "\n"
				        );        
				        writeIntoErrorFile(
				            "Error at line "
				            + ((Declaration_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Declaration_listContext)_localctx).ID.getText() + "\n"            
				        );      
				        }       
				        writeIntoParserLogFile(
				            "Line "
				            + ((Declaration_listContext)_localctx).ID.getLine() + ": declaration_list : ID LTHIRD CONST_INT RTHIRD\n\n" + ((Declaration_listContext)_localctx).ID.getText() + "[" + ((Declaration_listContext)_localctx).CONST_INT.getText()+ "]\n"
				        );  
				        ((Declaration_listContext)_localctx).name_line = ((Declaration_listContext)_localctx).ID.getText() + "[" + ((Declaration_listContext)_localctx).CONST_INT.getText()+ "]";
				        addToPendingList(((Declaration_listContext)_localctx).ID.getText(),"array");          
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(211);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.dec1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(196);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(197);
						match(COMMA);
						setState(198);
						((Declaration_listContext)_localctx).ID = match(ID);

						                  
						                  if(Main.st.getCurrentScope().getParent()!=null)
						                  {
						                      stack_offset += 2;
						                  }
						                  boolean b = lookUp(((Declaration_listContext)_localctx).ID.getText());
						                  if(b==true){
						                      Main.syntaxErrorCount++;
						                  writeIntoParserLogFile(
						                      "Error at line "
						                      + ((Declaration_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Declaration_listContext)_localctx).ID.getText() + "\n"
						                  ); 
						                  writeIntoErrorFile(
						                      "Error at line "
						                      + ((Declaration_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Declaration_listContext)_localctx).ID.getText() + "\n"            
						                  );             
						                  }     
						                  
						                  writeIntoParserLogFile(
						                      "Line "
						                      + ((Declaration_listContext)_localctx).ID.getLine() + ": declaration_list : declaration_list COMMA ID\n\n" + ((Declaration_listContext)_localctx).dec1.name_line + ","+((Declaration_listContext)_localctx).ID.getText() + "\n"
						                  );   
						              ((Declaration_listContext)_localctx).name_line = ((Declaration_listContext)_localctx).dec1.name_line + ","+((Declaration_listContext)_localctx).ID.getText();
						              addToPendingList(((Declaration_listContext)_localctx).ID.getText());  
						              //insertIntoSymbolTable(((Declaration_listContext)_localctx).ID.getText(),"ID");     
						              
						}
						break;
					case 2:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.dec2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(200);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(201);
						match(COMMA);
						setState(202);
						((Declaration_listContext)_localctx).ID = match(ID);
						setState(203);
						match(LTHIRD);
						setState(204);
						((Declaration_listContext)_localctx).CONST_INT = match(CONST_INT);
						setState(205);
						match(RTHIRD);

						                  
						                  boolean b = lookUp(((Declaration_listContext)_localctx).ID.getText());
						                  if(b==true){
						                      Main.syntaxErrorCount++;
						                  writeIntoParserLogFile(
						                      "Error at line "
						                      + ((Declaration_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Declaration_listContext)_localctx).ID.getText() + "\n"
						                  );  
						                  writeIntoErrorFile(
						                      "Error at line "
						                      + ((Declaration_listContext)_localctx).ID.getLine() + ": Multiple declaration of " + ((Declaration_listContext)_localctx).ID.getText() + "\n"            
						                  );            
						                  }       
						                  writeIntoParserLogFile(
						                      "Line "
						                      + ((Declaration_listContext)_localctx).ID.getLine() + ": declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD\n\n" + ((Declaration_listContext)_localctx).dec2.name_line+","+((Declaration_listContext)_localctx).ID.getText()+"["+((Declaration_listContext)_localctx).CONST_INT.getText() + "]\n"
						                  );  
						                  ((Declaration_listContext)_localctx).name_line =  ((Declaration_listContext)_localctx).dec2.name_line+","+((Declaration_listContext)_localctx).ID.getText()+"["+((Declaration_listContext)_localctx).CONST_INT.getText() + "]";
						                  addToPendingList(((Declaration_listContext)_localctx).ID.getText(),"array"); 
						                  //insertIntoSymbolTable(((Declaration_listContext)_localctx).ID.getText(),"ID","array"); 
						              
						}
						break;
					case 3:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.dec3 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(207);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(208);
						match(ADDOP);
						setState(209);
						((Declaration_listContext)_localctx).ID = match(ID);

						                  Main.syntaxErrorCount++;   
						                  writeIntoParserLogFile(
						                      "Error at line "
						                      + ((Declaration_listContext)_localctx).ID.getLine() + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n"
						                  );  
						                  writeIntoErrorFile(
						                      "Error at line "
						                      + ((Declaration_listContext)_localctx).ID.getLine() + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n"            
						                  );  
						                  ((Declaration_listContext)_localctx).name_line = ((Declaration_listContext)_localctx).dec3.name_line;
						                         
						              
						}
						break;
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public String name_line;
		public boolean retuurn;
		public StatementsContext s1;
		public StatementContext s;
		public StatementContext s2;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		return statements(0);
	}

	private StatementsContext statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementsContext _localctx = new StatementsContext(_ctx, _parentState);
		StatementsContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_statements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(217);
			((StatementsContext)_localctx).s = statement();

			        writeIntoParserLogFile(
			            "Line " + (((StatementsContext)_localctx).s!=null?(((StatementsContext)_localctx).s.stop):null).getLine() + ": statements : statement\n\n" + ((StatementsContext)_localctx).s.name_line + "\n"
			        );
			        ((StatementsContext)_localctx).name_line =  ((StatementsContext)_localctx).s.name_line;
			        ((StatementsContext)_localctx).retuurn =  ((StatementsContext)_localctx).s.retuurn;

			    
			}
			_ctx.stop = _input.LT(-1);
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsContext(_parentctx, _parentState);
					_localctx.s1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(220);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(221);
					((StatementsContext)_localctx).s2 = statement();

					                  if(((StatementsContext)_localctx).s2.name_line!=null){
					                  //if(!((StatementsContext)_localctx).s2.name_line.equalsIgnoreCase("debug")){
					                      writeIntoParserLogFile(
					                          "Line " + (((StatementsContext)_localctx).s2!=null?(((StatementsContext)_localctx).s2.stop):null).getLine() + ": statements : statements statement\n\n" + ((StatementsContext)_localctx).s1.name_line + "\n" + ((StatementsContext)_localctx).s2.name_line + "\n"
					                      );
					                      ((StatementsContext)_localctx).name_line =  ((StatementsContext)_localctx).s1.name_line + "\n" + ((StatementsContext)_localctx).s2.name_line;
					                    } else {
					                     ((StatementsContext)_localctx).name_line =  ((StatementsContext)_localctx).s1.name_line; 
					                    }
					                  
					                  ((StatementsContext)_localctx).retuurn =  ((StatementsContext)_localctx).s2.retuurn;
					              
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public String name_line;
		public boolean retuurn;
		public int lbl;
		public Var_declarationContext v;
		public ExpressionContext e;
		public ExpressionContext em;
		public Case_statementsContext cs;
		public Expression_statementContext ex;
		public Compound_statementContext c;
		public Expression_statementContext e1;
		public Expression_statementContext e2;
		public ExpressionContext e3;
		public StatementContext s;
		public Token BREAK;
		public StatementContext s1;
		public StatementContext s2;
		public Token CONTINUE;
		public Token ID;
		public Token SEMICOLON;
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public TerminalNode COLON() { return getToken(C2105131Parser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SWITCH() { return getToken(C2105131Parser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(C2105131Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105131Parser.RPAREN, 0); }
		public TerminalNode LCURL() { return getToken(C2105131Parser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(C2105131Parser.RCURL, 0); }
		public Case_statementsContext case_statements() {
			return getRuleContext(Case_statementsContext.class,0);
		}
		public TerminalNode GOTO() { return getToken(C2105131Parser.GOTO, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105131Parser.SEMICOLON, 0); }
		public List<Expression_statementContext> expression_statement() {
			return getRuleContexts(Expression_statementContext.class);
		}
		public Expression_statementContext expression_statement(int i) {
			return getRuleContext(Expression_statementContext.class,i);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public TerminalNode FOR() { return getToken(C2105131Parser.FOR, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode IF() { return getToken(C2105131Parser.IF, 0); }
		public TerminalNode BREAK() { return getToken(C2105131Parser.BREAK, 0); }
		public TerminalNode ELSE() { return getToken(C2105131Parser.ELSE, 0); }
		public TerminalNode CONTINUE() { return getToken(C2105131Parser.CONTINUE, 0); }
		public TerminalNode WHILE() { return getToken(C2105131Parser.WHILE, 0); }
		public TerminalNode PRINTLN() { return getToken(C2105131Parser.PRINTLN, 0); }
		public TerminalNode ID() { return getToken(C2105131Parser.ID, 0); }
		public TerminalNode RETURN() { return getToken(C2105131Parser.RETURN, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				((StatementContext)_localctx).v = var_declaration();

				        writeIntoParserLogFile(
				            "Line " + (((StatementContext)_localctx).v!=null?(((StatementContext)_localctx).v.stop):null).getLine() + ": statement : var_declaration\n\n" + ((StatementContext)_localctx).v.name_line + "\n"
				        );
				        ((StatementContext)_localctx).name_line =  ((StatementContext)_localctx).v.name_line;
				        ((StatementContext)_localctx).retuurn = false;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				((StatementContext)_localctx).e = expression();
				setState(233);
				match(COLON);

				        writeIntoParserLogFile(
				            "Line " + (((StatementContext)_localctx).e!=null?(((StatementContext)_localctx).e.stop):null).getLine() + ": statement : expression COLON\n\n"  +((StatementContext)_localctx).e.name_line + ":\n"
				        );        
				        Main.st.insert(((StatementContext)_localctx).e.name_line,"label");
				        ((StatementContext)_localctx).name_line = ((StatementContext)_localctx).e.name_line+":";
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(236);
				match(SWITCH);
				setState(237);
				match(LPAREN);
				setState(238);
				((StatementContext)_localctx).em = expression();
				setState(239);
				match(RPAREN);
				setState(240);
				match(LCURL);
				setState(241);
				((StatementContext)_localctx).cs = case_statements(0);
				setState(242);
				match(RCURL);

				        writeIntoParserLogFile(
				            "Line " + (((StatementContext)_localctx).cs!=null?(((StatementContext)_localctx).cs.stop):null).getLine() + ": statements : SWITCH LPAREN expression RPAREN compound_statement\n\n" + " switch("+((StatementContext)_localctx).em.name_line+"){" +((StatementContext)_localctx).cs.name_line + "}\n"
				        );
				        ((StatementContext)_localctx).name_line =  " switch("+((StatementContext)_localctx).em.name_line+")" +((StatementContext)_localctx).cs.name_line;        
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(245);
				match(GOTO);
				setState(246);
				((StatementContext)_localctx).e = expression();
				setState(247);
				match(SEMICOLON);

				        if(Main.st.lookup(((StatementContext)_localctx).e.name_line)==null){
				            Main.syntaxErrorCount++;
				            writeIntoParserLogFile("Error at line " + ((StatementContext)_localctx).e.name_line + ": No label declared " + ((StatementContext)_localctx).e.name_line + ";\n");
				            writeIntoErrorFile("Error at line " + ((StatementContext)_localctx).e.name_line + ": No label declared " + ((StatementContext)_localctx).e.name_line + ";\n");
				    }  
				        writeIntoParserLogFile(
				            "Line " + (((StatementContext)_localctx).e!=null?(((StatementContext)_localctx).e.stop):null).getLine() + ": statement : GOTO expression\n\n" +"goto " +((StatementContext)_localctx).e.name_line + ";\n"
				        );
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(250);
				((StatementContext)_localctx).ex = expression_statement();

				        if(((StatementContext)_localctx).ex.name_line!=null){
				        //if(!((StatementContext)_localctx).ex.name_line.equalsIgnoreCase("debug")){ 
				        writeIntoParserLogFile(
				            "Line " + (((StatementContext)_localctx).ex!=null?(((StatementContext)_localctx).ex.stop):null).getLine() + ": statement : expression_statement\n\n" + ((StatementContext)_localctx).ex.name_line + "\n"
				        );
				        
				        //}
				        }
				        ((StatementContext)_localctx).name_line =  ((StatementContext)_localctx).ex.name_line;
				        
				        ((StatementContext)_localctx).retuurn = false;
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(253);
				((StatementContext)_localctx).c = compound_statement();

				        writeIntoParserLogFile(
				            "Line " + (((StatementContext)_localctx).c!=null?(((StatementContext)_localctx).c.stop):null).getLine() + ": statement : compound_statement\n\n" + ((StatementContext)_localctx).c.name_line + "\n"
				        );
				        ((StatementContext)_localctx).name_line =  ((StatementContext)_localctx).c.name_line;
				        ((StatementContext)_localctx).retuurn = false;
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(256);
				match(FOR);
				 
				        
				    
				setState(258);
				match(LPAREN);
				setState(259);
				((StatementContext)_localctx).e1 = expression_statement();
				 
				        newLabel();
				        int forlabel = label;
				        writeIntoAsmFile(";for label --denotes i=0");
				    
				setState(261);
				((StatementContext)_localctx).e2 = expression_statement();
				 
				        newLabel();
				        writeIntoAsmFile(";after check label,if true, will come here jumping");
				        label++; //elseLabel
				        int endL = label;
				        writeIntoAsmFile("\tPOP AX");
				        stack_offset-=2;
				        writeIntoAsmFile("\tCMP AX,0");
				        writeIntoAsmFile("\tJE L"+ endL + "     ;jumping to else, as AX is 0");

				        label++; //true label
				        int trueL = label;
				        label++; //inc
				        int increase = label;

				        //will jump to true, as we didnt jump to false
				        writeIntoAsmFile("\tJMP L"+trueL+"       ;will jump to true, as we didnt jump to false");
				        writeIntoAsmFile("L"+increase+":       ;after this label, loop will go to increase i");

				        
				        //writeIntoAsmFile("\tJMP L"+endL+"  ;jumping to end of loop,works if for doent print other labels");
				    
				setState(263);
				((StatementContext)_localctx).e3 = expression();
				setState(264);
				match(RPAREN);
				 
				        
				        writeIntoAsmFile(";after inc ");
				        writeIntoAsmFile("JMP L"+forlabel);    
				        writeIntoAsmFile("L"+trueL+":    ;this is the true label,after this, main loop execution");

				    
				setState(266);
				((StatementContext)_localctx).s = statement();

				        //get statements last label 
				        // int next = label+1;
				        // writeIntoAsmFile("\tJMP L"+next+" ;jumping out of forlabel");
				        writeIntoParserLogFile(
				            "Line " + (((StatementContext)_localctx).s!=null?(((StatementContext)_localctx).s.stop):null).getLine() + ": statement : FOR LPAREN expression_statement expression_statement expression RPAREN statement\n\n"
				            + "for(" + ((StatementContext)_localctx).e1.name_line + "" + ((StatementContext)_localctx).e2.name_line + "" + ((StatementContext)_localctx).e3.name_line + ")" + ((StatementContext)_localctx).s.name_line + "\n"
				        );
				        ((StatementContext)_localctx).name_line =  "for(" + ((StatementContext)_localctx).e1.name_line + "" + ((StatementContext)_localctx).e2.name_line + "" + ((StatementContext)_localctx).e3.name_line + ")" + ((StatementContext)_localctx).s.name_line;
				        ((StatementContext)_localctx).retuurn = false;
				        // int inc = afterChecklabel+1;
				        // writeIntoAsmFile("\tJMP L"+inc+" ;jumping to increase"); 
				        // newLabel();
				        // stack.push("L"+label);
				        // writeIntoAsmFile(";for end label"); 

				        writeIntoAsmFile("\tJMP L"+increase+" ;jumping to increase label");
				        writeIntoAsmFile("\tL"+endL+":  ;fir end label");    
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(269);
				match(IF);
				setState(270);
				match(LPAREN);
				setState(271);
				((StatementContext)_localctx).e = expression();
				setState(272);
				match(RPAREN);
				setState(273);
				((StatementContext)_localctx).BREAK = match(BREAK);
				setState(274);
				match(SEMICOLON);

				        writeIntoParserLogFile(
				            "Line " + ((StatementContext)_localctx).BREAK.getLine() + ": statement : IF LPAREN expression RPAREN BREAK SEMICOLON\n\n"
				            + "if(" + ((StatementContext)_localctx).e.name_line + ")" +  " break;\n"
				        );
				        ((StatementContext)_localctx).name_line =  "if(" + ((StatementContext)_localctx).e.name_line + ")" +  " break;\n";
				        ((StatementContext)_localctx).retuurn = false;
				    
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(277);
				match(IF);
				 
				        //currlabel = 6 
				    
				setState(279);
				match(LPAREN);
				setState(280);
				((StatementContext)_localctx).e = expression();
				setState(281);
				match(RPAREN);
				 
				        int next = label+2;
				        //writeIntoAsmFile("\tCMP AX,0"); //if false, jump to next label
				        writeIntoAsmFile("\tJMP L"+next); //jmp to label 8, curr label = 6, next label 7=statement's label
				    
				setState(283);
				((StatementContext)_localctx).s = statement();

				        //label 7 created in statement
				        // newLabel(); //label 8
				        // next = label+2;
				        // writeIntoAsmFile("\tJMP L"+next);
				        writeIntoParserLogFile(
				            "Line " + (((StatementContext)_localctx).s!=null?(((StatementContext)_localctx).s.stop):null).getLine() + ": statement : IF LPAREN expression RPAREN statement\n\n"
				            + "if(" + ((StatementContext)_localctx).e.name_line + ")" + ((StatementContext)_localctx).s.name_line + "\n"
				        );
				        ((StatementContext)_localctx).name_line =  "if(" + ((StatementContext)_localctx).e.name_line + ")" + ((StatementContext)_localctx).s.name_line;
				        ((StatementContext)_localctx).retuurn = false;
				        
				    
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(286);
				match(IF);
				setState(287);
				match(LPAREN);
				setState(288);
				((StatementContext)_localctx).e = expression();
				setState(289);
				match(RPAREN);
				 
				        int next = label+3; //
				        //this section is under not equals of expression region. so it should jump to label+2 (label+1 is for equals) 
				        //writeIntoAsmFile("\tCMP AX,0"); //if false, jump to next label
				        writeIntoAsmFile("\tJMP L"+next); //jmp to label 8, curr label = 6, next label 7=statement's label        
				    
				setState(291);
				((StatementContext)_localctx).s1 = statement();
				 
				        //label 7 created in statement
				        newLabel(); //label 8 for else if , redundant ig 
				        next = label+5;
				        writeIntoAsmFile("\tJMP L"+next);
				    
				setState(293);
				match(ELSE);
				setState(294);
				((StatementContext)_localctx).s2 = statement();

				     
				        writeIntoParserLogFile(
				            "Line " + (((StatementContext)_localctx).s2!=null?(((StatementContext)_localctx).s2.stop):null).getLine() + ": statement : IF LPAREN expression RPAREN statement ELSE statement\n\n"
				            + "if(" + ((StatementContext)_localctx).e.name_line + ")" + ((StatementContext)_localctx).s1.name_line + "else " + ((StatementContext)_localctx).s2.name_line + "\n"
				        );
				        ((StatementContext)_localctx).name_line =  "if(" + ((StatementContext)_localctx).e.name_line + ")" + ((StatementContext)_localctx).s1.name_line + "else " + ((StatementContext)_localctx).s2.name_line;
				        ((StatementContext)_localctx).retuurn = false;
				        newLabel();
				        newLabel();
				        newLabel(); //last label 
				        writeIntoAsmFile(";End of if else");
				    
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(297);
				((StatementContext)_localctx).CONTINUE = match(CONTINUE);
				setState(298);
				match(SEMICOLON);

				        Main.syntaxErrorCount++;
				        writeIntoParserLogFile(
				            "Error at line " + ((StatementContext)_localctx).CONTINUE.getLine() + ":\n\n"
				            + "CONTINUE outside loop\n"
				        );    
				    
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(300);
				match(WHILE);
				 
				        newLabel();
				        int whileLabel = label;
				        writeIntoAsmFile(";while label : "+whileLabel);
				        
				        // label++;
				        // int decAndcondCheck = label;
				        // writeIntoAsmFile("L"+decAndcondCheck+":   ;will come here to update var and check condn");
				        // label++;
				        // int mainOperation = label;
				        // writeIntoAsmFile("\tJMP L"+mainOperation+"  ;jumping to main cause");
				    
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(302);
				match(WHILE);
				 
				        newLabel();
				        int whileLabel = label;
				        writeIntoAsmFile(";while label : "+whileLabel);
				        
				    
				setState(304);
				match(LPAREN);
				setState(305);
				((StatementContext)_localctx).e = expression();
				 
				        writeIntoAsmFile(";found the place after AX,0");
				        label++;
				        int stmt_label = label;
				        label++;
				        int endL = label;
				        if (!(((StatementContext)_localctx).e.name_line.contains("++") || ((StatementContext)_localctx).e.name_line.contains("--"))) { 
				            writeIntoAsmFile("\tJMP L" + endL + " ; will jump to end if reaches here");
				        }
				        else 
				        { 
				            writeIntoAsmFile("\tPUSH AX; pushing the decreased result if dec op");
				        }

				        writeIntoAsmFile("L"+stmt_label+":  ;will jump here from compare,if true");
				    
				setState(307);
				match(RPAREN);
				setState(308);
				((StatementContext)_localctx).s = statement();

				        writeIntoParserLogFile(
				            "Line " + (((StatementContext)_localctx).s!=null?(((StatementContext)_localctx).s.stop):null).getLine() + ": statement : WHILE LPAREN expression RPAREN statement\n\n"
				            + "while(" + ((StatementContext)_localctx).e.name_line + ")" + ((StatementContext)_localctx).s.name_line + "\n"
				        );
				        ((StatementContext)_localctx).name_line =  "while(" + ((StatementContext)_localctx).e.name_line + ")" + ((StatementContext)_localctx).s.name_line;
				        ((StatementContext)_localctx).retuurn = false;
				        if ((((StatementContext)_localctx).e.name_line.contains("++") || ((StatementContext)_localctx).e.name_line.contains("--"))) { 
				            writeIntoAsmFile("\tPOP AX ;getting the decreased result of AX,if dec op");
				        }
				        
				        writeIntoAsmFile("\tCMP AX,0");
				        int nextLabel = label+1;
				       
				        writeIntoAsmFile("\tJE L"+nextLabel);
				        
				        writeIntoAsmFile("\tJMP L"+whileLabel+";whilelabel jump");
				        writeIntoAsmFile("L"+endL+":  ;will jump here ,if ends");

				    
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(311);
				match(PRINTLN);
				setState(312);
				match(LPAREN);
				setState(313);
				((StatementContext)_localctx).ID = match(ID);
				setState(314);
				match(RPAREN);
				setState(315);
				((StatementContext)_localctx).SEMICOLON = match(SEMICOLON);

				        writeIntoParserLogFile(
				            "Line " + ((StatementContext)_localctx).SEMICOLON.getLine() + ": statement : PRINTLN LPAREN ID RPAREN SEMICOLON\n"
				        );

				        boolean b = lookUp(((StatementContext)_localctx).ID.getText());
				        if(b==false){
				            Main.syntaxErrorCount++;
				        writeIntoParserLogFile(
				            "Error at line "
				            + ((StatementContext)_localctx).ID.getLine() + ": Undeclared variable " + ((StatementContext)_localctx).ID.getText() + "\n"
				        );        
				        writeIntoErrorFile(
				            "Error at line "
				            + ((StatementContext)_localctx).ID.getLine() + ": Undeclared variable " + ((StatementContext)_localctx).ID.getText() + "\n"            
				        );      
				        } 
				        writeIntoParserLogFile(
				            "printf(" + ((StatementContext)_localctx).ID.getText() + ");\n"
				        );
				        
				        ((StatementContext)_localctx).name_line =  "printf(" + ((StatementContext)_localctx).ID.getText() + ");";
				        ((StatementContext)_localctx).retuurn = false;
				    
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(317);
				match(RETURN);
				setState(318);
				((StatementContext)_localctx).e = expression();
				setState(319);
				((StatementContext)_localctx).SEMICOLON = match(SEMICOLON);

				        writeIntoParserLogFile(
				            "Line " + ((StatementContext)_localctx).SEMICOLON.getLine() + ": statement : RETURN expression SEMICOLON\n\n"
				            + "return " + ((StatementContext)_localctx).e.name_line + ";\n"
				        );
				        ((StatementContext)_localctx).name_line =  "return " + ((StatementContext)_localctx).e.name_line + ";";
				        ((StatementContext)_localctx).retuurn = true;
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Case_statementsContext extends ParserRuleContext {
		public String name_line;
		public Case_statementsContext c1;
		public Case_statementContext c;
		public Case_statementContext c2;
		public Case_statementContext case_statement() {
			return getRuleContext(Case_statementContext.class,0);
		}
		public Case_statementsContext case_statements() {
			return getRuleContext(Case_statementsContext.class,0);
		}
		public Case_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterCase_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitCase_statements(this);
		}
	}

	public final Case_statementsContext case_statements() throws RecognitionException {
		return case_statements(0);
	}

	private Case_statementsContext case_statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Case_statementsContext _localctx = new Case_statementsContext(_ctx, _parentState);
		Case_statementsContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_case_statements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(325);
			((Case_statementsContext)_localctx).c = case_statement();
			 ((Case_statementsContext)_localctx).name_line = ((Case_statementsContext)_localctx).c.name_line;
			}
			_ctx.stop = _input.LT(-1);
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Case_statementsContext(_parentctx, _parentState);
					_localctx.c1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_case_statements);
					setState(328);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(329);
					((Case_statementsContext)_localctx).c2 = case_statement();

					                  ((Case_statementsContext)_localctx).name_line = ((Case_statementsContext)_localctx).c1.name_line + " "+((Case_statementsContext)_localctx).c2.name_line;
					              
					}
					} 
				}
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Case_statementContext extends ParserRuleContext {
		public String name_line;
		public Token CONST_INT;
		public StatementsContext st;
		public TerminalNode CASE() { return getToken(C2105131Parser.CASE, 0); }
		public TerminalNode CONST_INT() { return getToken(C2105131Parser.CONST_INT, 0); }
		public TerminalNode COLON() { return getToken(C2105131Parser.COLON, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Case_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterCase_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitCase_statement(this);
		}
	}

	public final Case_statementContext case_statement() throws RecognitionException {
		Case_statementContext _localctx = new Case_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_case_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(CASE);
			setState(338);
			((Case_statementContext)_localctx).CONST_INT = match(CONST_INT);
			setState(339);
			match(COLON);
			setState(340);
			((Case_statementContext)_localctx).st = statements(0);

			            writeIntoParserLogFile(
			            "Line "
			            + ((Case_statementContext)_localctx).CONST_INT.getLine()+ ": case_statement : CASE factor COLON statements BREAK SEMICOLON\n\n" +"case "+((Case_statementContext)_localctx).CONST_INT.getText()  +":"+((Case_statementContext)_localctx).st.name_line +"break;\n"
			        );        
			        ((Case_statementContext)_localctx).name_line =  "case "+((Case_statementContext)_localctx).CONST_INT.getText()  +":"+((Case_statementContext)_localctx).st.name_line +"break;";
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_statementContext extends ParserRuleContext {
		public String name_line;
		public Token SEMICOLON;
		public ExpressionContext ex;
		public TerminalNode SEMICOLON() { return getToken(C2105131Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterExpression_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitExpression_statement(this);
		}
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression_statement);
		try {
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				((Expression_statementContext)_localctx).SEMICOLON = match(SEMICOLON);

				        writeIntoParserLogFile(
				            "Line " + ((Expression_statementContext)_localctx).SEMICOLON.getLine() + ": expression_statement : SEMICOLON\n\n;\n"
				        );
				        ((Expression_statementContext)_localctx).name_line =  ";";
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				((Expression_statementContext)_localctx).ex = expression();
				setState(346);
				((Expression_statementContext)_localctx).SEMICOLON = match(SEMICOLON);

				        if(((Expression_statementContext)_localctx).ex.name_line!=null){
				        if(!((Expression_statementContext)_localctx).ex.name_line.equalsIgnoreCase("debug")){
				        //"debug check: [" + ((Expression_statementContext)_localctx).ex.name_line + "]\n"+
				        writeIntoParserLogFile(
				            "Line " + ((Expression_statementContext)_localctx).SEMICOLON.getLine() + ": expression_statement : expression SEMICOLON\n\n" + ((Expression_statementContext)_localctx).ex.name_line + ";\n"
				        );
				        ((Expression_statementContext)_localctx).name_line =  ((Expression_statementContext)_localctx).ex.name_line + ";";
				        }
				        }else{ 
				            ((Expression_statementContext)_localctx).name_line =   "debug";
				         }
				        
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Forin_statementContext extends ParserRuleContext {
		public String name_line;
		public Foreach_statementContext fe;
		public Simple_expressionContext s1;
		public TerminalNode TO() { return getToken(C2105131Parser.TO, 0); }
		public Foreach_statementContext foreach_statement() {
			return getRuleContext(Foreach_statementContext.class,0);
		}
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public Forin_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forin_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterForin_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitForin_statement(this);
		}
	}

	public final Forin_statementContext forin_statement() throws RecognitionException {
		Forin_statementContext _localctx = new Forin_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forin_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			((Forin_statementContext)_localctx).fe = foreach_statement();
			setState(352);
			match(TO);
			setState(353);
			((Forin_statementContext)_localctx).s1 = simple_expression(0);

			        ((Forin_statementContext)_localctx).name_line =  ((Forin_statementContext)_localctx).fe.name_line + " to " + ((Forin_statementContext)_localctx).s1.name_line;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Foreach_statementContext extends ParserRuleContext {
		public String name_line;
		public Simple_expressionContext s1;
		public Simple_expressionContext s2;
		public TerminalNode IN() { return getToken(C2105131Parser.IN, 0); }
		public List<Simple_expressionContext> simple_expression() {
			return getRuleContexts(Simple_expressionContext.class);
		}
		public Simple_expressionContext simple_expression(int i) {
			return getRuleContext(Simple_expressionContext.class,i);
		}
		public Foreach_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterForeach_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitForeach_statement(this);
		}
	}

	public final Foreach_statementContext foreach_statement() throws RecognitionException {
		Foreach_statementContext _localctx = new Foreach_statementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_foreach_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			((Foreach_statementContext)_localctx).s1 = simple_expression(0);
			setState(357);
			match(IN);
			setState(358);
			((Foreach_statementContext)_localctx).s2 = simple_expression(0);

			        
			        if(Main.st.lookup(((Foreach_statementContext)_localctx).s1.name_line)!=null){
			        
			        if(!Main.st.lookup(((Foreach_statementContext)_localctx).s1.name_line).getIDType().equalsIgnoreCase("int")){
			            Main.syntaxErrorCount++;
			            writeIntoParserLogFile("Error at line " + (((Foreach_statementContext)_localctx).s2!=null?(((Foreach_statementContext)_localctx).s2.stop):null).getLine() + ": Loop variable "+ ((Foreach_statementContext)_localctx).s1.name_line + " is not an integer\n" );
			            writeIntoErrorFile("Error at line " + (((Foreach_statementContext)_localctx).s1!=null?(((Foreach_statementContext)_localctx).s1.stop):null).getLine() + ": Loop variable "+ ((Foreach_statementContext)_localctx).s1.name_line + " is not an integer\n" );
			        }
			        }        
			        if(Main.st.lookup(((Foreach_statementContext)_localctx).s2.name_line)!=null){
			        
			        if(!Main.st.lookup(((Foreach_statementContext)_localctx).s2.name_line).getIDType().equalsIgnoreCase("array")){
			            Main.syntaxErrorCount++;
			            writeIntoParserLogFile("Error at line " + (((Foreach_statementContext)_localctx).s2!=null?(((Foreach_statementContext)_localctx).s2.stop):null).getLine() + ": "+ ((Foreach_statementContext)_localctx).s2.name_line + " is not an array\n" );
			            writeIntoErrorFile("Error at line " + (((Foreach_statementContext)_localctx).s2!=null?(((Foreach_statementContext)_localctx).s2.stop):null).getLine() + ": "+ ((Foreach_statementContext)_localctx).s2.name_line + " is not an array\n" );
			        }
			        }
			        ((Foreach_statementContext)_localctx).name_line =  ((Foreach_statementContext)_localctx).s1.name_line + " in " + ((Foreach_statementContext)_localctx).s2.name_line;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public String name_line;
		public Token ID;
		public ExpressionContext e;
		public TerminalNode ID() { return getToken(C2105131Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C2105131Parser.LTHIRD, 0); }
		public TerminalNode RTHIRD() { return getToken(C2105131Parser.RTHIRD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_variable);
		try {
			setState(369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				((VariableContext)_localctx).ID = match(ID);

				        writeIntoParserLogFile(
				        "Line "
				        + ((VariableContext)_localctx).ID.getLine() + ": variable : ID\n" 
				    );    
				    ((VariableContext)_localctx).name_line = ((VariableContext)_localctx).ID.getText();   
				    if(Main.st.lookup(((VariableContext)_localctx).ID.getText())==null){
				            Main.syntaxErrorCount++;
				            writeIntoParserLogFile("Error at line " + ((VariableContext)_localctx).ID.getLine() + ": Undeclared variable " + ((VariableContext)_localctx).ID.getText() + "\n");
				            writeIntoErrorFile("Error at line " + ((VariableContext)_localctx).ID.getLine() + ": Undeclared variable " + ((VariableContext)_localctx).ID.getText() + "\n");
				    }  
				    if(Main.st.lookup(((VariableContext)_localctx).ID.getText())!=null){
				        
				        if(Main.st.lookup(((VariableContext)_localctx).ID.getText()).getIDType().equalsIgnoreCase("array")){
				            Main.syntaxErrorCount++;
				            writeIntoParserLogFile("Error at line " + ((VariableContext)_localctx).ID.getLine() + ": Type mismatch, " + ((VariableContext)_localctx).ID.getText() + " is an array\n");
				            writeIntoErrorFile("Error at line " + ((VariableContext)_localctx).ID.getLine() + ": Type mismatch, " + ((VariableContext)_localctx).ID.getText() + " is an array\n");
				        }
				        
				        for (SymbolInfo sym : Main.pendingInsertions) {
				            if (sym.getName().equals(((VariableContext)_localctx).ID.getText())) {
				                if (sym.getIDType().equalsIgnoreCase("array")) {
				                    Main.syntaxErrorCount++;
				                    writeIntoParserLogFile("Error at line " + ((VariableContext)_localctx).ID.getLine() + ": Type mismatch, " + ((VariableContext)_localctx).ID.getText() + " is an array\n");
				                    writeIntoErrorFile("Error at line " + ((VariableContext)_localctx).ID.getLine() + ": Type mismatch, " + ((VariableContext)_localctx).ID.getText() + " is an array\n");
				                }
				                break; 
				            }
				        }
				    }
				    

				    writeIntoParserLogFile(((VariableContext)_localctx).ID.getText()+"\n");

				    //addToPendingList(((VariableContext)_localctx).ID.getText());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(363);
				((VariableContext)_localctx).ID = match(ID);
				setState(364);
				match(LTHIRD);
				setState(365);
				((VariableContext)_localctx).e = expression();
				setState(366);
				match(RTHIRD);

				        writeIntoParserLogFile(
				        "Line "
				        + ((VariableContext)_localctx).ID.getLine() + ": variable : ID LTHIRD expression RTHIRD\n" 
				    );

				        if(Main.st.lookup(((VariableContext)_localctx).ID.getText())!=null){
				            if(!Main.st.lookup(((VariableContext)_localctx).ID.getText()).getIDType().equalsIgnoreCase("array")){

				                Main.syntaxErrorCount++;
				                writeIntoParserLogFile(
				                    "Error at line "
				                    + ((VariableContext)_localctx).ID.getLine() + ": "+((VariableContext)_localctx).ID.getText()+" not an array\n"
				                ); 
				                writeIntoErrorFile(
				                    "Error at line "
				                    + ((VariableContext)_localctx).ID.getLine() + ": "+((VariableContext)_localctx).ID.getText()+" not an array\n"
				                );
				            }
				        }


				        if(!((VariableContext)_localctx).e.type.equalsIgnoreCase("CONST_INT")){
				        Main.syntaxErrorCount++;
				        writeIntoParserLogFile(
				            "Error at line "
				            + ((VariableContext)_localctx).ID.getLine() + ": Expression inside third brackets not an integer\n"
				        ); 
				        writeIntoErrorFile(
				            "Error at line "
				            + ((VariableContext)_localctx).ID.getLine() + ": Expression inside third brackets not an integer\n"        
				        );  
				        } 

				        writeIntoParserLogFile(
				            ((VariableContext)_localctx).ID.getText() + "[" + ((VariableContext)_localctx).e.name_line+ "]\n"
				        );

				    ((VariableContext)_localctx).name_line = ((VariableContext)_localctx).ID.getText() + "[" + ((VariableContext)_localctx).e.name_line+ "]";  
				   // addToPendingList(((VariableContext)_localctx).ID.getText());      
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public String name_line;
		public String type;
		public Logic_expressionContext l;
		public VariableContext v;
		public Token a;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(C2105131Parser.ASSIGNOP, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		try {
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(371);
				((ExpressionContext)_localctx).l = logic_expression();

				        if(!((ExpressionContext)_localctx).l.name_line.equalsIgnoreCase("debug")){
				            writeIntoParserLogFile(
				            "Line "
				            + (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() + ": expression : logic_expression\n\n" + ((ExpressionContext)_localctx).l.name_line +"\n"
				        ); 
				         }
				       
				    ((ExpressionContext)_localctx).name_line = ((ExpressionContext)_localctx).l.name_line;
				    ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).l.type;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(374);
				((ExpressionContext)_localctx).v = variable();
				setState(375);
				((ExpressionContext)_localctx).a = match(ASSIGNOP);
				setState(376);
				((ExpressionContext)_localctx).l = logic_expression();

				        newLabel();
				        if(!((ExpressionContext)_localctx).l.name_line.equalsIgnoreCase("debug")){ 
				                writeIntoParserLogFile(
				                "Line "
				                + (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() + ": expression : variable ASSIGNOP logic_expression\n" 
				            );  
				            ((ExpressionContext)_localctx).name_line = ((ExpressionContext)_localctx).v.name_line+""+ (((ExpressionContext)_localctx).a!=null?((ExpressionContext)_localctx).a.getText():null) + "" + ((ExpressionContext)_localctx).l.name_line;
				            
				         } else{
				            ((ExpressionContext)_localctx).name_line = ((ExpressionContext)_localctx).l.name_line;
				          }
				        
				        
				        String fullName = ((ExpressionContext)_localctx).v.name_line;
				        String actualName = fullName.contains("[") ? fullName.substring(0, fullName.indexOf("[")): fullName;
				        boolean isError = false;
				        if(((ExpressionContext)_localctx).l.type!=null){  
				            if(((ExpressionContext)_localctx).l.type.equalsIgnoreCase("void")){
				                Main.syntaxErrorCount++;
				                writeIntoParserLogFile("Error at line "  + (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() + ": Void function used in expression\n");
				                writeIntoErrorFile("Error at line " +  (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() + ": Void function used in expression\n");  
				                isError = true;          
				            }
				        }

				        // if(Main.st.lookup(((ExpressionContext)_localctx).v.name_line)==null){
				        //     writeIntoParserLogFile("debug at line "  + (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() +((ExpressionContext)_localctx).v.name_line+" not found in symbol table\n");
				        // }

				        if(Main.st.lookup(actualName)!=null && !isError){
				            SymbolInfo sym2 = Main.st.lookup(((ExpressionContext)_localctx).l.name_line);
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
				                        writeIntoAsmFile("\tMOV AX,"+((ExpressionContext)_localctx).l.name_line+";Global variable;rare");
				                    }
				                    else
				                    { 
				                       if (stck_off2 < 0) {
				                            writeIntoAsmFile("\tMOV AX,[BP+" + (-stck_off2) + "];rare");
				                        } else {
				                            writeIntoAsmFile("\tMOV AX,[BP-" + stck_off2 + "];rare");
				                        }

				                    }
				                }
				                
				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				                
				                //writeIntoAsmFile("\tMOV AX,"+((ExpressionContext)_localctx).l.name_line);
				                writeIntoAsmFile("\tMOV "+actualName+",AX;LHS is global variable");
				            }
				            else 
				            {
				                if(sym2==null)
				                { 
				                    writeIntoAsmFile("\tPOP AX;getting assignop's RHS val fromm stack,as logical expr is pushed to stack");
				                }                
				               if (stck_off < 0) {
				                    writeIntoAsmFile("\tMOV [BP+" + (-stck_off) + "],AX ; LHS is local variable");
				                } else {
				                    writeIntoAsmFile("\tMOV [BP-" + stck_off + "],AX ; LHS is local variable");
				                }

				            }
				            //writeIntoParserLogFile("debug at line "  + (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() +IDtokenType+"\n");
				            if(!IDtokenType.equalsIgnoreCase(normalizeType(((ExpressionContext)_localctx).l.type)) && !IDtokenType.equalsIgnoreCase("array") && ((ExpressionContext)_localctx).l.type!=null){
				                if(!(IDtokenType.equalsIgnoreCase("float") && normalizeType(((ExpressionContext)_localctx).l.type).equalsIgnoreCase("int"))){
				                    Main.syntaxErrorCount++;
				                    writeIntoParserLogFile("Error at line "  + (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() + ": Type Mismatch\n");
				                    writeIntoErrorFile("Error at line " +  (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() + ": Type Mismatch\n");
				                 }
				            }
				            if(IDtokenType.equalsIgnoreCase("array")&& ((ExpressionContext)_localctx).l.type!=null){
				                //writeIntoParserLogFile("debug at line "  + (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() +sym.arrayType+"\n");
				                if(!sym.arrayType.equalsIgnoreCase(normalizeType(((ExpressionContext)_localctx).l.type))){
				                    Main.syntaxErrorCount++;
				                    writeIntoParserLogFile("Error at line "  + (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() + ": Type Mismatch\n");
				                    writeIntoErrorFile("Error at line " +  (((ExpressionContext)_localctx).l!=null?(((ExpressionContext)_localctx).l.stop):null).getLine() + ": Type Mismatch\n");                    
				                }
				            }
				        }
				        if(!((ExpressionContext)_localctx).l.name_line.equalsIgnoreCase("debug")){ 
				        writeIntoParserLogFile(
				            ((ExpressionContext)_localctx).v.name_line+""+ (((ExpressionContext)_localctx).a!=null?((ExpressionContext)_localctx).a.getText():null) + "" + ((ExpressionContext)_localctx).l.name_line +"\n"
				        );
				        }
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ternary_expressionContext extends ParserRuleContext {
		public String name_line;
		public Logic_expressionContext l1;
		public Logic_expressionContext l4;
		public Logic_expressionContext l2;
		public Logic_expressionContext l3;
		public TerminalNode LPAREN() { return getToken(C2105131Parser.LPAREN, 0); }
		public TerminalNode RELOP() { return getToken(C2105131Parser.RELOP, 0); }
		public TerminalNode RPAREN() { return getToken(C2105131Parser.RPAREN, 0); }
		public TerminalNode QMARK() { return getToken(C2105131Parser.QMARK, 0); }
		public TerminalNode COLON() { return getToken(C2105131Parser.COLON, 0); }
		public List<Logic_expressionContext> logic_expression() {
			return getRuleContexts(Logic_expressionContext.class);
		}
		public Logic_expressionContext logic_expression(int i) {
			return getRuleContext(Logic_expressionContext.class,i);
		}
		public Ternary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterTernary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitTernary_expression(this);
		}
	}

	public final Ternary_expressionContext ternary_expression() throws RecognitionException {
		Ternary_expressionContext _localctx = new Ternary_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ternary_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(LPAREN);
			setState(382);
			((Ternary_expressionContext)_localctx).l1 = logic_expression();
			setState(383);
			match(RELOP);
			setState(384);
			((Ternary_expressionContext)_localctx).l4 = logic_expression();
			setState(385);
			match(RPAREN);
			setState(386);
			match(QMARK);
			setState(387);
			((Ternary_expressionContext)_localctx).l2 = logic_expression();
			setState(388);
			match(COLON);
			setState(389);
			((Ternary_expressionContext)_localctx).l3 = logic_expression();

			        ((Ternary_expressionContext)_localctx).name_line =  "(" + ((Ternary_expressionContext)_localctx).l1.name_line + "< " +((Ternary_expressionContext)_localctx).l4.name_line +")? " + ((Ternary_expressionContext)_localctx).l2.name_line + ": " +((Ternary_expressionContext)_localctx).l3.name_line; 
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_expressionContext extends ParserRuleContext {
		public String name_line;
		public String type;
		public boolean isConst;
		public Rel_expressionContext r;
		public Token LOGICOP;
		public Rel_expressionContext re;
		public List<Rel_expressionContext> rel_expression() {
			return getRuleContexts(Rel_expressionContext.class);
		}
		public Rel_expressionContext rel_expression(int i) {
			return getRuleContext(Rel_expressionContext.class,i);
		}
		public TerminalNode LOGICOP() { return getToken(C2105131Parser.LOGICOP, 0); }
		public Logic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterLogic_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitLogic_expression(this);
		}
	}

	public final Logic_expressionContext logic_expression() throws RecognitionException {
		Logic_expressionContext _localctx = new Logic_expressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_logic_expression);
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(392);
				((Logic_expressionContext)_localctx).r = rel_expression();

				        ((Logic_expressionContext)_localctx).isConst = ((Logic_expressionContext)_localctx).r.isConst;
				        if(!((Logic_expressionContext)_localctx).r.name_line.equalsIgnoreCase("debug")){  
				            writeIntoParserLogFile(
				            "Line "
				            + (((Logic_expressionContext)_localctx).r!=null?(((Logic_expressionContext)_localctx).r.stop):null).getLine() + ": logic_expression : rel_expression\n\n" + ((Logic_expressionContext)_localctx).r.name_line +"\n"
				            );
				        }
				        ((Logic_expressionContext)_localctx).name_line = ((Logic_expressionContext)_localctx).r.name_line;
				        ((Logic_expressionContext)_localctx).type =  ((Logic_expressionContext)_localctx).r.type;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				((Logic_expressionContext)_localctx).r = rel_expression();
				 
				        newLabel();
				        //push the result to stack AX 

				        SymbolInfo sym = Main.st.lookup(((Logic_expressionContext)_localctx).r.name_line);
				        if(sym==null)
				        { 
				            //some constant
				            writeIntoAsmFile("\tMOV AX,"+((Logic_expressionContext)_localctx).r.name_line);
				            // writeIntoAsmFile("\tPUSH AX");
				            // stack_offset += 2;

				        }
				        else {
				            int offset = sym.getStackOffset();
				            if(offset==-1)
				            {
				                writeIntoAsmFile("\tMOV AX,"+((Logic_expressionContext)_localctx).r.name_line);
				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				            }
				            else
				            {
				                //writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");

				                if (offset < 0) {
				                    writeIntoAsmFile("\tMOV [BP+" + (-offset) + "],AX ; ");
				                } else {
				                    writeIntoAsmFile("\tMOV [BP-" + offset + "],AX ; ");
				                }

				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				            } 
				        } 
				        
				        writeIntoAsmFile("\t MOV DX,AX");
				    
				setState(397);
				((Logic_expressionContext)_localctx).LOGICOP = match(LOGICOP);
				setState(398);
				((Logic_expressionContext)_localctx).re = rel_expression();

				       sym = Main.st.lookup(((Logic_expressionContext)_localctx).re.name_line);
				        if(sym==null)
				        { 
				            
				            //writeIntoAsmFile("\tMOV AX,"+((Logic_expressionContext)_localctx).re.name_line); //this is constant,this should be redundant
				            writeIntoAsmFile("\tPOP AX;getting from stack"); //getting the stored value
				            stack_offset-=2;
				        }
				        else {
				            int offset = sym.getStackOffset();
				            if(offset==-1)
				            {
				                writeIntoAsmFile("\tMOV AX,"+((Logic_expressionContext)_localctx).re.name_line);
				                writeIntoAsmFile("\tPUSH AX");
				                stack_offset+=2;
				            }
				            else{
				                
				                //writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
				                if (offset < 0) {
				                    writeIntoAsmFile("\tMOV [BP+" + (-offset) + "],AX ;");
				                } else {
				                    writeIntoAsmFile("\tMOV [BP-" + offset + "],AX ; ");
				                }

				                writeIntoAsmFile("\tPUSH AX");
				                stack_offset+=2;
				            } 
				        }
				        //store logicop result in AX  

				        //DX has the LHS value,Ax has the RHS value
				        
				        if(((Logic_expressionContext)_localctx).LOGICOP.getText().equals("||"))
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
				        else if(((Logic_expressionContext)_localctx).LOGICOP.getText().equals("&&"))
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
				        + (((Logic_expressionContext)_localctx).re!=null?(((Logic_expressionContext)_localctx).re.stop):null).getLine() + ": logic_expression : rel_expression LOGICOP rel_expression\n\n" + ((Logic_expressionContext)_localctx).r.name_line+ "" + ((Logic_expressionContext)_localctx).LOGICOP.getText() + "" + ((Logic_expressionContext)_localctx).re.name_line +"\n"
				    );          
				        ((Logic_expressionContext)_localctx).name_line = ((Logic_expressionContext)_localctx).r.name_line+ "" + ((Logic_expressionContext)_localctx).LOGICOP.getText() + "" + ((Logic_expressionContext)_localctx).re.name_line;
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rel_expressionContext extends ParserRuleContext {
		public String name_line;
		public String type;
		public boolean isConst;
		public Simple_expressionContext s;
		public Token RELOP;
		public Simple_expressionContext s1;
		public List<Simple_expressionContext> simple_expression() {
			return getRuleContexts(Simple_expressionContext.class);
		}
		public Simple_expressionContext simple_expression(int i) {
			return getRuleContext(Simple_expressionContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(C2105131Parser.RELOP, 0); }
		public Rel_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterRel_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitRel_expression(this);
		}
	}

	public final Rel_expressionContext rel_expression() throws RecognitionException {
		Rel_expressionContext _localctx = new Rel_expressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_rel_expression);
		try {
			setState(412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				((Rel_expressionContext)_localctx).s = simple_expression(0);

				        ((Rel_expressionContext)_localctx).isConst = ((Rel_expressionContext)_localctx).s.isConst;
				        if(!((Rel_expressionContext)_localctx).s.name_line.equalsIgnoreCase("debug")){ 
				                writeIntoParserLogFile(
				                "Line "
				                + (((Rel_expressionContext)_localctx).s!=null?(((Rel_expressionContext)_localctx).s.stop):null).getLine() + ": rel_expression : simple_expression\n\n" + ((Rel_expressionContext)_localctx).s.name_line +"\n"
				            );
				        }
				        ((Rel_expressionContext)_localctx).name_line = ((Rel_expressionContext)_localctx).s.name_line;
				        ((Rel_expressionContext)_localctx).type =  ((Rel_expressionContext)_localctx).s.type;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(406);
				((Rel_expressionContext)_localctx).s = simple_expression(0);

				        newLabel();
				        ((Rel_expressionContext)_localctx).isConst = false;
				        //push the result to stack AX 

				        SymbolInfo sym = Main.st.lookup(((Rel_expressionContext)_localctx).s.name_line);
				        if(sym==null)
				        { 
				            //some constant
				            
				            writeIntoAsmFile(Main.st.getAllScopesAsString());
				            // writeIntoAsmFile("\tPUSH AX");
				            // stack_offset+=2;
				        }
				        else {
				            int offset = sym.getStackOffset();
				            if(offset==-1)
				            {
				                writeIntoAsmFile("\t stack offset -1 MOV AX,"+((Rel_expressionContext)_localctx).s.name_line);
				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				            }
				            else
				            {
				                //writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
				                if (offset < 0) {
				                    writeIntoAsmFile("\tMOV AX,[BP+" + (-offset) + "] ;");
				                } else {
				                    writeIntoAsmFile("\tMOV AX,[BP-" + offset + "] ; ");
				                }
				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				            } 
				        } 
				        
				        writeIntoAsmFile("\t MOV DX,AX");
				    
				setState(408);
				((Rel_expressionContext)_localctx).RELOP = match(RELOP);
				setState(409);
				((Rel_expressionContext)_localctx).s1 = simple_expression(0);


				        
				        sym = Main.st.lookup(((Rel_expressionContext)_localctx).s1.name_line);
				        if(sym==null)
				        { 
				            
				            writeIntoAsmFile("\tPOP AX;because it is already in stack");
				            // writeIntoAsmFile("\tPUSH AX");
				            // stack_offset+=2;
				        }
				        else {
				            int offset = sym.getStackOffset();
				            if(offset==-1)
				            {
				                writeIntoAsmFile("\tMOV AX,"+((Rel_expressionContext)_localctx).s1.name_line);
				            }
				            else{
				                
				                //writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
				                if (offset < 0) {
				                    writeIntoAsmFile("\tMOV AX,[BP+" + (-offset) + "] ;");
				                } else {
				                    writeIntoAsmFile("\tMOV AX,[BP-" + offset + "] ; ");
				                }
				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				            } 
				        }
				        //store relop result in AX  

				        //DX has the RHS value,Ax has the LHS value
				        writeIntoAsmFile("\tCMP DX,AX");
				        if(((Rel_expressionContext)_localctx).RELOP.getText().equals("<="))
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
				        if(((Rel_expressionContext)_localctx).RELOP.getText().equals("<"))
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
				        if(((Rel_expressionContext)_localctx).RELOP.getText().equals(">"))
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
				        else if(((Rel_expressionContext)_localctx).RELOP.getText().equals("!="))
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
				        else if(((Rel_expressionContext)_localctx).RELOP.getText().equals("=="))
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
				        + (((Rel_expressionContext)_localctx).s1!=null?(((Rel_expressionContext)_localctx).s1.stop):null).getLine() + ": rel_expression : simple_expression RELOP simple_expression\n\n" + ((Rel_expressionContext)_localctx).s.name_line +"" +((Rel_expressionContext)_localctx).RELOP.getText() +""+((Rel_expressionContext)_localctx).s1.name_line +"\n"
				    );
				        ((Rel_expressionContext)_localctx).name_line = ((Rel_expressionContext)_localctx).s.name_line +"" +((Rel_expressionContext)_localctx).RELOP.getText()+""+((Rel_expressionContext)_localctx).s1.name_line;
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_expressionContext extends ParserRuleContext {
		public String name_line;
		public String type;
		public boolean isConst;
		public Simple_expressionContext s;
		public TermContext t;
		public Token ADDOP;
		public Token ASSIGNOP;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(C2105131Parser.ADDOP, 0); }
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(C2105131Parser.ASSIGNOP, 0); }
		public Simple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterSimple_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitSimple_expression(this);
		}
	}

	public final Simple_expressionContext simple_expression() throws RecognitionException {
		return simple_expression(0);
	}

	private Simple_expressionContext simple_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Simple_expressionContext _localctx = new Simple_expressionContext(_ctx, _parentState);
		Simple_expressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_simple_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(415);
				((Simple_expressionContext)_localctx).t = term(0);

				        ((Simple_expressionContext)_localctx).isConst = ((Simple_expressionContext)_localctx).t.isConst;
				        writeIntoParserLogFile(
				        "Line "
				        + (((Simple_expressionContext)_localctx).t!=null?(((Simple_expressionContext)_localctx).t.stop):null).getLine() + ": simple_expression : term\n\n" + ((Simple_expressionContext)_localctx).t.name_line +"\n"
				    );
				        ((Simple_expressionContext)_localctx).name_line = ((Simple_expressionContext)_localctx).t.name_line;
				        ((Simple_expressionContext)_localctx).type =  ((Simple_expressionContext)_localctx).t.type;
				    
				}
				break;
			case 2:
				{
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(432);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(430);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new Simple_expressionContext(_parentctx, _parentState);
						_localctx.s = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_simple_expression);
						setState(421);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(422);
						((Simple_expressionContext)_localctx).ADDOP = match(ADDOP);
						setState(423);
						((Simple_expressionContext)_localctx).t = term(0);

						                  
						                  newLabel();

						              
						                  ((Simple_expressionContext)_localctx).isConst = false;
						                  writeIntoAsmFile("\tPOP AX; popping the latest result to AX");
						                  stack_offset-=2;
						                  writeIntoAsmFile("\tMOV DX,AX");

						                 SymbolInfo sym = Main.st.lookup(((Simple_expressionContext)_localctx).s.name_line);
						                  if(sym==null)
						                  { 
						                      
						                      writeIntoAsmFile("\tPOP AX; popping the second result from stack");
						                      stack_offset-=2;
						                  }
						                  else {
						                      int offset = sym.getStackOffset();
						                      if(offset==-1)
						                      {
						                          writeIntoAsmFile("\tMOV AX,"+((Simple_expressionContext)_localctx).s.name_line+";getting the LHS argument in ADDOP from global variable");
						                          // writeIntoAsmFile("\tPUSH AX");
						                          // stack_offset+=2;
						                      }
						                      else{
						                          //writeIntoAsmFile("sym name: "+sym.getName());
						                          if (offset < 0) {
						                              writeIntoAsmFile("\tMOV AX,[BP+" + (-offset) + "] ;getting the LHS argument in ADDOP from global variable");
						                          } else {
						                              writeIntoAsmFile("\tMOV AX,[BP-" + offset + "]; ");
						                          }
						                          //writeIntoAsmFile("\tMOV AX,[BP-"+offset+"];getting the LHS argument in ADDOP from global variable");
						                          // writeIntoAsmFile("\tPUSH AX");
						                          // stack_offset+=2;
						                      } 
						                  }
						           
						                  writeIntoParserLogFile(
						                  "Line "
						                  + (((Simple_expressionContext)_localctx).t!=null?(((Simple_expressionContext)_localctx).t.stop):null).getLine() + ": simple_expression : simple_expression ADDOP term\n\n" +((Simple_expressionContext)_localctx).s.name_line+""+((Simple_expressionContext)_localctx).ADDOP.getText()+"" +((Simple_expressionContext)_localctx).t.name_line +"\n"
						              );
						                  ((Simple_expressionContext)_localctx).name_line = ((Simple_expressionContext)_localctx).s.name_line+""+((Simple_expressionContext)_localctx).ADDOP.getText()+"" +((Simple_expressionContext)_localctx).t.name_line;
						                  // writeIntoAsmFile("\tPOP AX");
						                  // stack_offset -= 2;
						                  if(((Simple_expressionContext)_localctx).ADDOP.getText().equals("+"))
						                  { 
						                      writeIntoAsmFile("\tADD AX,DX;Adding in ADDOP");
						                  }
						                  else 
						                  { 
						                      writeIntoAsmFile("\tSUB AX,DX;subtracting in ADDOP");
						                  }
						                  
						                  writeIntoAsmFile("\tPUSH AX;pushing the result of addop(simple expression) to stack");
						              
						}
						break;
					case 2:
						{
						_localctx = new Simple_expressionContext(_parentctx, _parentState);
						_localctx.s = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_simple_expression);
						setState(426);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(427);
						((Simple_expressionContext)_localctx).ADDOP = match(ADDOP);
						setState(428);
						((Simple_expressionContext)_localctx).ASSIGNOP = match(ASSIGNOP);

						                  Main.syntaxErrorCount++;
						                  writeIntoParserLogFile(
						                      "Error at line " + ((Simple_expressionContext)_localctx).ASSIGNOP.getLine() + ": syntax error, unexpected ASSIGNOP\n"  
						                      
						                  );
						                  writeIntoErrorFile(
						                      "Error at line " + ((Simple_expressionContext)_localctx).ASSIGNOP.getLine() + ": syntax error, unexpected ASSIGNOP\n"
						                  );
						                  ((Simple_expressionContext)_localctx).name_line = "debug";
						              
						}
						break;
					}
					} 
				}
				setState(434);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public String name_line;
		public String type;
		public boolean isConst;
		public TermContext t;
		public Unary_expressionContext u;
		public Token MULOP;
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode MULOP() { return getToken(C2105131Parser.MULOP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(436);
			((TermContext)_localctx).u = unary_expression();

			        ((TermContext)_localctx).isConst =  true;
			        if(!((TermContext)_localctx).u.name_line.equalsIgnoreCase("debug")){ 
			            writeIntoParserLogFile(
			            "Line "
			            + (((TermContext)_localctx).u!=null?(((TermContext)_localctx).u.stop):null).getLine() + ": term : unary_expression\n\n" +((TermContext)_localctx).u.name_line +"\n"
			        );
			         }

			        ((TermContext)_localctx).name_line = ((TermContext)_localctx).u.name_line;
			        ((TermContext)_localctx).type = ((TermContext)_localctx).u.type;
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(446);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(439);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(440);
					((TermContext)_localctx).MULOP = match(MULOP);
					setState(441);
					((TermContext)_localctx).u = unary_expression();

					                  newLabel();
					                  ((TermContext)_localctx).isConst =  false;
					                  SymbolInfo sym = Main.st.lookup(((TermContext)_localctx).u.name_line);
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
					                          writeIntoAsmFile("\tMOV AX,"+((TermContext)_localctx).u.name_line);
					                          // writeIntoAsmFile("\tPUSH AX");
					                          // stack_offset+=2;
					                      }
					                      else{

					                          //writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
					                          if (offset < 0) {
					                              writeIntoAsmFile("\tMOV AX,[BP+" + (-offset) + "]");
					                          } else {
					                              writeIntoAsmFile("\tMOV AX,[BP-" + offset + "]");
					                          }
					                          // writeIntoAsmFile("\tPUSH AX");
					                          // stack_offset+=2;
					                      } 
					                  }
					                  


					                  
					                  writeIntoAsmFile("\tMOV CX,AX");
					                  

					                  sym = Main.st.lookup(((TermContext)_localctx).t.name_line);
					                          
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
					                          writeIntoAsmFile("\tMOV AX,"+((TermContext)_localctx).t.name_line);
					                          // writeIntoAsmFile("\tPUSH AX");
					                          // stack_offset+=2;
					                      }
					                      else{

					                         // writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
					                          if (offset < 0) {
					                              writeIntoAsmFile("\tMOV [BP+" + (-offset) + "],AX ;");
					                          } else {
					                              writeIntoAsmFile("\tMOV [BP-" + offset + "],AX ; ");
					                          }
					                          // writeIntoAsmFile("\tPUSH AX");
					                          // stack_offset+=2;
					                      } 
					                  } 

					                  writeIntoAsmFile("\tCWD");

					                  if(((TermContext)_localctx).MULOP.getText().equals("*"))
					                  { 
					                      writeIntoAsmFile("\tMUL CX");
					                      writeIntoAsmFile("\tPUSH AX");
					                  }
					                  else{ 
					                      writeIntoAsmFile("\tDIV CX");
					                      //writeIntoAsmFile("\tPUSH CX"); //may have to remove it 
					                  }

					                  if(((TermContext)_localctx).MULOP.getText().equals("%"))
					                  { 
					                      writeIntoAsmFile("\tPUSH DX");
					                      // writeIntoAsmFile("\tPOP AX"); //may have to remove it, handled in other place 
					                      // stack_offset-=2;
					                  }
					                  
					                  writeIntoParserLogFile(
					                  "Line "
					                  + (((TermContext)_localctx).u!=null?(((TermContext)_localctx).u.stop):null).getLine() + ": term : term MULOP unary_expression\n" 
					              );

					                  
					                  if(((TermContext)_localctx).u.name_line.equalsIgnoreCase("0") && ((TermContext)_localctx).MULOP.getText().equalsIgnoreCase("%")){ 
					                      Main.syntaxErrorCount++;
					                      writeIntoParserLogFile(
					                      "Error at line "
					                      + (((TermContext)_localctx).u!=null?(((TermContext)_localctx).u.stop):null).getLine() + ": Modulus by Zero" +"\n"
					                  ); 
					                      writeIntoErrorFile(
					                      "Error at line "
					                      + (((TermContext)_localctx).u!=null?(((TermContext)_localctx).u.stop):null).getLine() + ": Modulus by Zero" +"\n"
					                  ); 
					                  }

					                  
					                  else if(((TermContext)_localctx).u.type!=null){
					                          if(((TermContext)_localctx).u.type.equalsIgnoreCase("void")){

					                              Main.syntaxErrorCount++;
					                              writeIntoParserLogFile(
					                              "Error at line "
					                              + (((TermContext)_localctx).u!=null?(((TermContext)_localctx).u.stop):null).getLine() + ": Void function used in expression" +"\n"
					                          ); 
					                              writeIntoErrorFile(
					                              "Error at line "
					                              + (((TermContext)_localctx).u!=null?(((TermContext)_localctx).u.stop):null).getLine() + ": Void function used in expression" +"\n"
					                          );                    
					                          }

					                          else if(!((TermContext)_localctx).u.type.equalsIgnoreCase("CONST_INT")){
					                              Main.syntaxErrorCount++;
					                              writeIntoParserLogFile(
					                              "Error at line "
					                              + (((TermContext)_localctx).u!=null?(((TermContext)_localctx).u.stop):null).getLine() + ": Non-Integer operand on modulus operator" +"\n"
					                          ); 
					                              writeIntoErrorFile(
					                              "Error at line "
					                              + (((TermContext)_localctx).u!=null?(((TermContext)_localctx).u.stop):null).getLine() + ": Non-Integer operand on modulus operator" +"\n"
					                          );       
					                      }
					                  }


					              writeIntoParserLogFile(((TermContext)_localctx).t.name_line+""+((TermContext)_localctx).MULOP.getText()+"" +((TermContext)_localctx).u.name_line +"\n");     
					                  ((TermContext)_localctx).name_line = ((TermContext)_localctx).t.name_line+""+((TermContext)_localctx).MULOP.getText()+"" +((TermContext)_localctx).u.name_line;
					              
					}
					} 
				}
				setState(448);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_expressionContext extends ParserRuleContext {
		public String name_line;
		public String type;
		public boolean isConst;
		public Token ADDOP;
		public Unary_expressionContext u;
		public Token NOT;
		public FactorContext f;
		public TerminalNode ADDOP() { return getToken(C2105131Parser.ADDOP, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(C2105131Parser.NOT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitUnary_expression(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unary_expression);
		try {
			setState(460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				((Unary_expressionContext)_localctx).ADDOP = match(ADDOP);
				setState(450);
				((Unary_expressionContext)_localctx).u = unary_expression();

				        
				        newLabel();
				        

				        SymbolInfo sym = Main.st.lookup(((Unary_expressionContext)_localctx).u.name_line);
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
				                writeIntoAsmFile("\tMOV AX,"+((Unary_expressionContext)_localctx).u.name_line);
				                writeIntoAsmFile("\tNEG AX");
				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				            }
				            else
				            {
				                //writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
				                if (offset < 0) {
				                    writeIntoAsmFile("\tMOV [BP+" + (-offset) + "],AX ;");
				                } else {
				                    writeIntoAsmFile("\tMOV [BP-" + offset + "],AX ; ");
				                }
				                writeIntoAsmFile("\tNEG AX");
				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				            } 
				        }         
				        writeIntoParserLogFile(
				        "Line "
				        + (((Unary_expressionContext)_localctx).u!=null?(((Unary_expressionContext)_localctx).u.stop):null).getLine() + ": unary_expression : ADDOP unary_expression\n\n" + ((Unary_expressionContext)_localctx).ADDOP.getText()+"" +((Unary_expressionContext)_localctx).u.name_line +"\n"
				    );
				        ((Unary_expressionContext)_localctx).name_line = ((Unary_expressionContext)_localctx).ADDOP.getText()+"" +((Unary_expressionContext)_localctx).u.name_line;
				    
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
				((Unary_expressionContext)_localctx).NOT = match(NOT);
				setState(454);
				((Unary_expressionContext)_localctx).u = unary_expression();

				        ((Unary_expressionContext)_localctx).isConst =  false;
				        writeIntoParserLogFile(
				        "Line "
				        + (((Unary_expressionContext)_localctx).u!=null?(((Unary_expressionContext)_localctx).u.stop):null).getLine() + ": unary_expression : NOT unary_expression\n\n" +((Unary_expressionContext)_localctx).NOT.getText()+"" +((Unary_expressionContext)_localctx).u.name_line +"\n"
				    );
				        ((Unary_expressionContext)_localctx).name_line = ((Unary_expressionContext)_localctx).NOT.getText()+"" +((Unary_expressionContext)_localctx).u.name_line;
				    
				}
				break;
			case LPAREN:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(457);
				((Unary_expressionContext)_localctx).f = factor();

				        ((Unary_expressionContext)_localctx).isConst =  true;
				        if(!((Unary_expressionContext)_localctx).f.name_line.equalsIgnoreCase("debug")){ 
				            writeIntoParserLogFile(
				            "Line "
				            + (((Unary_expressionContext)_localctx).f!=null?(((Unary_expressionContext)_localctx).f.stop):null).getLine() + ": unary_expression : factor\n\n" +((Unary_expressionContext)_localctx).f.name_line +"\n"
				        );
				         }

				        ((Unary_expressionContext)_localctx).name_line = ((Unary_expressionContext)_localctx).f.name_line;
				        ((Unary_expressionContext)_localctx).type = ((Unary_expressionContext)_localctx).f.type;
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public String name_line;
		public String type;
		public VariableContext v;
		public Token ID;
		public Token RPAREN;
		public Argument_listContext a;
		public ExpressionContext e;
		public Token CONST_INT;
		public Token CONST_FLOAT;
		public Token INCOP;
		public Token DECOP;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ID() { return getToken(C2105131Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105131Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105131Parser.RPAREN, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CONST_INT() { return getToken(C2105131Parser.CONST_INT, 0); }
		public TerminalNode CONST_FLOAT() { return getToken(C2105131Parser.CONST_FLOAT, 0); }
		public TerminalNode INCOP() { return getToken(C2105131Parser.INCOP, 0); }
		public TerminalNode DECOP() { return getToken(C2105131Parser.DECOP, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_factor);
		try {
			setState(492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(462);
				((FactorContext)_localctx).v = variable();

				        writeIntoParserLogFile(
				        "Line "
				        + (((FactorContext)_localctx).v!=null?(((FactorContext)_localctx).v.stop):null).getLine() + ": factor : variable\n\n" +((FactorContext)_localctx).v.name_line +"\n"
				    );
				        ((FactorContext)_localctx).name_line = ((FactorContext)_localctx).v.name_line;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(465);
				((FactorContext)_localctx).ID = match(ID);
				setState(466);
				match(LPAREN);
				setState(467);
				((FactorContext)_localctx).RPAREN = match(RPAREN);
				 
				        newLabel();
				        writeIntoAsmFile("\tCALL "+((FactorContext)_localctx).ID.getText());    
				        writeIntoAsmFile("\tPUSH AX;pushing the return value of function to stack");    
				        writeIntoParserLogFile(
				            "Line " + ((FactorContext)_localctx).RPAREN.getLine() + ": factor : ID LPAREN RPAREN\n"
				        );   
				        ((FactorContext)_localctx).name_line =  ((FactorContext)_localctx).ID.getText() + "("  + ")";     
				        SymbolInfo funcSymbol = Main.st.lookup(((FactorContext)_localctx).ID.getText());

				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(469);
				((FactorContext)_localctx).ID = match(ID);
				setState(470);
				match(LPAREN);
				setState(471);
				((FactorContext)_localctx).a = argument_list();
				setState(472);
				((FactorContext)_localctx).RPAREN = match(RPAREN);

				        writeIntoParserLogFile(
				            "Line " + ((FactorContext)_localctx).RPAREN.getLine() + ": factor : ID LPAREN argument_list RPAREN\n"
				        );
				        ((FactorContext)_localctx).name_line =  ((FactorContext)_localctx).ID.getText() + "(" + ((FactorContext)_localctx).a.name_line + ")";

				        SymbolInfo funcSymbol = Main.st.lookup(((FactorContext)_localctx).ID.getText());

				            if(((FactorContext)_localctx).ID.getText().equals("println"))
				            {
				                
				                newLabel();
				                SymbolInfo id = Main.st.lookup(((FactorContext)_localctx).a.name_line);
				                if(id!=null)
				                {
				                    if(id.getStackOffset()!=-1)
				                    {
				                        //writeIntoAsmFile("\tMOV AX,[BP-"+id.getStackOffset()+"]");
				                        int offset = id.getStackOffset();
				                        if (offset < 0) {
				                            writeIntoAsmFile("\tMOV AX,[BP+" + (-offset) + "]");
				                        } else {
				                            writeIntoAsmFile("\tMOV AX,[BP-" + offset + "]");
				                        }

				                        // writeIntoAsmFile("\tPUSH AX");
				                        // stack_offset+=2;
				                        writeIntoAsmFile("\tCALL print_output");
				                        writeIntoAsmFile("\tCALL new_line");
				                    }
				                    else{
				                            writeIntoAsmFile("\tMOV AX,"+((FactorContext)_localctx).a.name_line);
				                            // writeIntoAsmFile("\tPUSH AX");
				                            // stack_offset+=2;
				                            writeIntoAsmFile("\tCALL print_output");
				                            writeIntoAsmFile("\tCALL new_line");
				                     }
				                }
				                else {
				                        writeIntoAsmFile("\tMOV AX,"+((FactorContext)_localctx).a.name_line);
				                        // writeIntoAsmFile("\tPUSH AX");
				                        // stack_offset+=2;
				                        writeIntoAsmFile("\tCALL print_output");
				                        writeIntoAsmFile("\tCALL new_line");
				                 }

				            }
				            else { 
				                newLabel();
				                List<String> actualArgs = new ArrayList<>();
				                if (!((FactorContext)_localctx).a.name_line.trim().isEmpty()) {
				                    String[] argDefs = ((FactorContext)_localctx).a.name_line.split(",");
				                    for (String def : argDefs) {
				                        String[] tokens = def.trim().split(" ");
				                        if (tokens.length > 0) {
				                            actualArgs.add(tokens[0]);
				                            
				                        }
				                    }
				                }
				               // writeIntoAsmFile("actual arg size = "+actualArgs.size());
				                for(int i=actualArgs.size();i>0;i--)
				                { 
				                    SymbolInfo sym = Main.st.lookup(actualArgs.get(i-1));
				                    if(sym == null)
				                    { 
				                        writeIntoAsmFile("\tPUSH "+actualArgs.get(i-1));
				                    }
				                    else{ 
				                        int off = sym.getStackOffset();
				                        if(off==-1)
				                        { 
				                            writeIntoAsmFile("\tPUSH "+actualArgs.get(i-1));
				                        }
				                        else{ 
				                            //writeIntoAsmFile("\tMOV AX,[BP-"+off+"]");
				                            if (off < 0) {
				                                writeIntoAsmFile("\tMOV AX,[BP+" + (-off) + "]");
				                                 writeIntoAsmFile("\tPUSH AX");
				                                 stack_offset+=2;
				                            } else {
				                                writeIntoAsmFile("\tMOV AX,[BP-" + off + "]");
				                                 writeIntoAsmFile("\tPUSH AX");
				                                 stack_offset+=2;
				                            }

				                            // writeIntoAsmFile("\tPUSH AX");
				                            // stack_offset+=2;
				                        }
				                    }
				                }
				                writeIntoAsmFile("\tCALL "+((FactorContext)_localctx).ID.getText());
				                writeIntoAsmFile("\tPUSH AX;pushing the return value of function to stack");
				            }
				        if (funcSymbol == null) {
				            Main.syntaxErrorCount++;
				            

				            writeIntoParserLogFile(
				                "Error at line " + ((FactorContext)_localctx).RPAREN.getLine() + ": Undefined function " + ((FactorContext)_localctx).ID.getText() +  "\n"
				                
				            );
				            writeIntoErrorFile(
				                "Error at line " + ((FactorContext)_localctx).RPAREN.getLine() + ": Undefined function " + ((FactorContext)_localctx).ID.getText() +  "\n"
				            );
				        }

				        else if (funcSymbol != null && funcSymbol.getIDType().equals("function")) {
				        // if(funcSymbol.getName().equals("foo4")){
				        // writeIntoParserLogFile(
				        //     "debug "
				        //     + ((FactorContext)_localctx).RPAREN.getLine() + ":"  + " "+ funcSymbol.getName() +  "return type:" + funcSymbol.returnType + "\n"
				        // ); 

				        // }
				            ((FactorContext)_localctx).type =  funcSymbol.returnType;
				            List<String> expectedParams = funcSymbol.paramList;

				            List<String> actualArgs = new ArrayList<>();
				            if (!((FactorContext)_localctx).a.name_line.trim().isEmpty()) {
				                String[] argDefs = ((FactorContext)_localctx).a.name_line.split(",");
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
				                    "Error at line " + ((FactorContext)_localctx).RPAREN.getLine() + ": Total number of arguments mismatch with declaration in function " + ((FactorContext)_localctx).ID.getText() + "\n"
				                );
				                writeIntoErrorFile(
				                  
				                    "Error at line " + ((FactorContext)_localctx).RPAREN.getLine() + ": Total number of arguments mismatch with declaration in function " + ((FactorContext)_localctx).ID.getText() + "\n"
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
				                            "Error at line " + ((FactorContext)_localctx).RPAREN.getLine() + ": "+(i + 1)+ "th argument mismatch in function " + ((FactorContext)_localctx).ID.getText() +  "\n"
				                            
				                        );
				                        writeIntoErrorFile(
				                            "Error at line " + ((FactorContext)_localctx).RPAREN.getLine() + ": "+(i + 1)+ "th argument mismatch in function " + ((FactorContext)_localctx).ID.getText() +  "\n"
				                        );
				                        break;
				                    }
				                }
				            }
				            
				        }
				            writeIntoParserLogFile(
				                ((FactorContext)_localctx).ID.getText() + "(" + ((FactorContext)_localctx).a.name_line + ")\n"
				            );
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(475);
				match(LPAREN);
				setState(476);
				((FactorContext)_localctx).e = expression();
				setState(477);
				((FactorContext)_localctx).RPAREN = match(RPAREN);

				        writeIntoParserLogFile(
				        "Line "
				        + ((FactorContext)_localctx).RPAREN.getLine() + ": factor : LPAREN expression RPAREN\n\n" +"(" +((FactorContext)_localctx).e.name_line +")\n"
				    );
				        ((FactorContext)_localctx).name_line = "(" +((FactorContext)_localctx).e.name_line +")";
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(480);
				((FactorContext)_localctx).CONST_INT = match(CONST_INT);

				        newLabel();
				        writeIntoAsmFile("\tMOV AX,"+((FactorContext)_localctx).CONST_INT.getText());
				        writeIntoAsmFile("\tPUSH AX");
				        stack_offset += 2;
				        writeIntoParserLogFile(
				        "Line "
				        + ((FactorContext)_localctx).CONST_INT.getLine() + ": factor : CONST_INT\n\n" +((FactorContext)_localctx).CONST_INT.getText() +"\n"
				    );
				        ((FactorContext)_localctx).name_line = ((FactorContext)_localctx).CONST_INT.getText();
				        ((FactorContext)_localctx).type = "CONST_INT";
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(482);
				((FactorContext)_localctx).CONST_FLOAT = match(CONST_FLOAT);

				        newLabel();
				        writeIntoAsmFile("\tMOV AX,"+((FactorContext)_localctx).CONST_FLOAT.getText());
				        writeIntoAsmFile("\tPUSH AX");
				        stack_offset += 2;
				        writeIntoParserLogFile(
				        "Line "
				        + ((FactorContext)_localctx).CONST_FLOAT.getLine() + ": factor : CONST_FLOAT\n\n" +((FactorContext)_localctx).CONST_FLOAT.getText() +"\n"
				    );
				        ((FactorContext)_localctx).name_line = ((FactorContext)_localctx).CONST_FLOAT.getText();
				        ((FactorContext)_localctx).type = "CONST_FLOAT";
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(484);
				((FactorContext)_localctx).v = variable();
				setState(485);
				((FactorContext)_localctx).INCOP = match(INCOP);

				        
				        newLabel();
				        //push the result to stack AX 

				        SymbolInfo sym = Main.st.lookup(((FactorContext)_localctx).v.name_line);
				        if(sym==null)
				        { 
				            //some constant
				            writeIntoAsmFile("\tMOV AX,"+((FactorContext)_localctx).v.name_line);
				            writeIntoAsmFile("\tPUSH AX");
				            stack_offset+=2;
				        }
				        else {
				            int offset = sym.getStackOffset();
				            if(offset==-1)
				            {
				                writeIntoAsmFile("\tMOV AX,"+((FactorContext)_localctx).v.name_line);
				                writeIntoAsmFile("\tINC AX");
				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				                writeIntoAsmFile("\tMOV "+((FactorContext)_localctx).v.name_line+"AX");
				            }
				            else
				            {
				                //writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
				                
				                    if (offset < 0) {
				                        writeIntoAsmFile("\tMOV AX,[BP+" + (-offset) + "]");
				                    } else {
				                        writeIntoAsmFile("\tMOV AX,[BP-" + offset + "]");
				                    }

				                writeIntoAsmFile("\tINC AX");
				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				                writeIntoAsmFile("\tMOV [BP-"+offset+"],AX");
				            } 
				        } 
				        
				        writeIntoParserLogFile(
				        "Line "
				        + ((FactorContext)_localctx).INCOP.getLine() + ": factor : variable INCOP\n\n" +((FactorContext)_localctx).v.name_line +((FactorContext)_localctx).INCOP.getText() +"\n"
				    );
				        ((FactorContext)_localctx).name_line = ((FactorContext)_localctx).v.name_line +((FactorContext)_localctx).INCOP.getText();
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(488);
				((FactorContext)_localctx).v = variable();
				setState(489);
				((FactorContext)_localctx).DECOP = match(DECOP);

				        
				        newLabel();


				        SymbolInfo sym = Main.st.lookup(((FactorContext)_localctx).v.name_line);
				        if(sym==null)
				        { 
				            //some constant
				            writeIntoAsmFile("\tMOV AX,"+((FactorContext)_localctx).v.name_line);
				            writeIntoAsmFile("\tPUSH AX");
				            stack_offset+=2;
				        }
				        else {
				            int offset = sym.getStackOffset();
				            if(offset==-1)
				            {
				                writeIntoAsmFile("\tMOV AX,"+((FactorContext)_localctx).v.name_line);
				                writeIntoAsmFile("\tDEC AX");
				                writeIntoAsmFile("\tMOV "+((FactorContext)_localctx).v.name_line+"AX");
				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				            }
				            else
				            {
				                //writeIntoAsmFile("\tMOV AX,[BP-"+offset+"]");
				                
				                if (offset < 0) {
				                    writeIntoAsmFile("\tMOV AX,[BP+" + (-offset) + "]");
				                } else {
				                    writeIntoAsmFile("\tMOV AX,[BP-" + offset + "]");
				                }

				                writeIntoAsmFile("\tDEC AX");
				               // writeIntoAsmFile("\tMOV [BP-"+offset+"],AX");
				                if (offset < 0) {
				                    writeIntoAsmFile("\tMOV [BP+" + (-offset) + "],AX");
				                } else {
				                    writeIntoAsmFile("\tMOV [BP-" + offset + "],AX");
				                }

				                // writeIntoAsmFile("\tPUSH AX");
				                // stack_offset+=2;
				            } 
				        }         
				        writeIntoParserLogFile(
				        "Line "
				        + ((FactorContext)_localctx).DECOP.getLine() + ": factor : variable DECOP\n\n" +((FactorContext)_localctx).v.name_line +((FactorContext)_localctx).DECOP.getText() +"\n"
				    );
				        ((FactorContext)_localctx).name_line = ((FactorContext)_localctx).v.name_line +((FactorContext)_localctx).DECOP.getText();
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Argument_listContext extends ParserRuleContext {
		public String name_line;
		public ArgumentsContext a;
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterArgument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitArgument_list(this);
		}
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_argument_list);
		try {
			setState(498);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(494);
				((Argument_listContext)_localctx).a = arguments(0);

				        writeIntoParserLogFile(
				        "Line "
				        + (((Argument_listContext)_localctx).a!=null?(((Argument_listContext)_localctx).a.stop):null).getLine() + ": argument_list : arguments\n\n" +((Argument_listContext)_localctx).a.name_line +"\n"
				    );
				        ((Argument_listContext)_localctx).name_line = ((Argument_listContext)_localctx).a.name_line;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public String name_line;
		public ArgumentsContext a;
		public Logic_expressionContext l1;
		public Logic_expressionContext l;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C2105131Parser.COMMA, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105131ParserListener ) ((C2105131ParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		return arguments(0);
	}

	private ArgumentsContext arguments(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, _parentState);
		ArgumentsContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(501);
			((ArgumentsContext)_localctx).l1 = logic_expression();

			        writeIntoParserLogFile(
			        "Line "
			        + (((ArgumentsContext)_localctx).l1!=null?(((ArgumentsContext)_localctx).l1.stop):null).getLine() + ": arguments : logic_expression\n\n" +((ArgumentsContext)_localctx).l1.name_line +"\n"
			    );
			        ((ArgumentsContext)_localctx).name_line = ((ArgumentsContext)_localctx).l1.name_line;
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(511);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentsContext(_parentctx, _parentState);
					_localctx.a = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_arguments);
					setState(504);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(505);
					match(COMMA);
					setState(506);
					((ArgumentsContext)_localctx).l = logic_expression();

					                  writeIntoParserLogFile(
					                  "Line "
					                  + (((ArgumentsContext)_localctx).l!=null?(((ArgumentsContext)_localctx).l.stop):null).getLine() + ": arguments : arguments COMMA logic_expression\n\n" +((ArgumentsContext)_localctx).a.name_line + "," + ((ArgumentsContext)_localctx).l.name_line +"\n"
					              );
					                  ((ArgumentsContext)_localctx).name_line = ((ArgumentsContext)_localctx).a.name_line + "," + ((ArgumentsContext)_localctx).l.name_line;
					              
					}
					} 
				}
				setState(513);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return program_sempred((ProgramContext)_localctx, predIndex);
		case 5:
			return parameter_list_sempred((Parameter_listContext)_localctx, predIndex);
		case 10:
			return declaration_list_sempred((Declaration_listContext)_localctx, predIndex);
		case 11:
			return statements_sempred((StatementsContext)_localctx, predIndex);
		case 13:
			return case_statements_sempred((Case_statementsContext)_localctx, predIndex);
		case 23:
			return simple_expression_sempred((Simple_expressionContext)_localctx, predIndex);
		case 24:
			return term_sempred((TermContext)_localctx, predIndex);
		case 28:
			return arguments_sempred((ArgumentsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean program_sempred(ProgramContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean parameter_list_sempred(Parameter_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean declaration_list_sempred(Declaration_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean case_statements_sempred(Case_statementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simple_expression_sempred(Simple_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arguments_sempred(ArgumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u0203\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001G\b\u0001\n\u0001\f\u0001J\t\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002U\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003f\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004z\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u0088\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u0095\b\u0005\n\u0005\f\u0005\u0098\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00a3\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00af\b\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00b9\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c3"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00d4\b\n\n"+
		"\n\f\n\u00d7\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00e1\b\u000b\n"+
		"\u000b\f\u000b\u00e4\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0143\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u014d"+
		"\b\r\n\r\f\r\u0150\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u015e\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0172\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u017c\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u0192\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u019d\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u01a4\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u01af\b\u0017\n\u0017\f\u0017\u01b2\t\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0005\u0018\u01bd\b\u0018\n\u0018\f\u0018\u01c0\t\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u01cd\b\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u01ed\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0003\u001b\u01f3\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c"+
		"\u01fe\b\u001c\n\u001c\f\u001c\u0201\t\u001c\u0001\u001c\u0000\b\u0002"+
		"\n\u0014\u0016\u001a.08\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468\u0000\u0000\u021a"+
		"\u0000:\u0001\u0000\u0000\u0000\u0002>\u0001\u0000\u0000\u0000\u0004T"+
		"\u0001\u0000\u0000\u0000\u0006e\u0001\u0000\u0000\u0000\by\u0001\u0000"+
		"\u0000\u0000\n\u0087\u0001\u0000\u0000\u0000\f\u00a2\u0001\u0000\u0000"+
		"\u0000\u000e\u00ae\u0001\u0000\u0000\u0000\u0010\u00b0\u0001\u0000\u0000"+
		"\u0000\u0012\u00b8\u0001\u0000\u0000\u0000\u0014\u00c2\u0001\u0000\u0000"+
		"\u0000\u0016\u00d8\u0001\u0000\u0000\u0000\u0018\u0142\u0001\u0000\u0000"+
		"\u0000\u001a\u0144\u0001\u0000\u0000\u0000\u001c\u0151\u0001\u0000\u0000"+
		"\u0000\u001e\u015d\u0001\u0000\u0000\u0000 \u015f\u0001\u0000\u0000\u0000"+
		"\"\u0164\u0001\u0000\u0000\u0000$\u0171\u0001\u0000\u0000\u0000&\u017b"+
		"\u0001\u0000\u0000\u0000(\u017d\u0001\u0000\u0000\u0000*\u0191\u0001\u0000"+
		"\u0000\u0000,\u019c\u0001\u0000\u0000\u0000.\u01a3\u0001\u0000\u0000\u0000"+
		"0\u01b3\u0001\u0000\u0000\u00002\u01cc\u0001\u0000\u0000\u00004\u01ec"+
		"\u0001\u0000\u0000\u00006\u01f2\u0001\u0000\u0000\u00008\u01f4\u0001\u0000"+
		"\u0000\u0000:;\u0006\u0000\uffff\uffff\u0000;<\u0003\u0002\u0001\u0000"+
		"<=\u0006\u0000\uffff\uffff\u0000=\u0001\u0001\u0000\u0000\u0000>?\u0006"+
		"\u0001\uffff\uffff\u0000?@\u0003\u0004\u0002\u0000@A\u0006\u0001\uffff"+
		"\uffff\u0000AH\u0001\u0000\u0000\u0000BC\n\u0002\u0000\u0000CD\u0003\u0004"+
		"\u0002\u0000DE\u0006\u0001\uffff\uffff\u0000EG\u0001\u0000\u0000\u0000"+
		"FB\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000HI\u0001\u0000\u0000\u0000I\u0003\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000KL\u0003\u000e\u0007\u0000LM\u0006\u0002\uffff\uffff"+
		"\u0000MU\u0001\u0000\u0000\u0000NO\u0003\u0006\u0003\u0000OP\u0006\u0002"+
		"\uffff\uffff\u0000PU\u0001\u0000\u0000\u0000QR\u0003\b\u0004\u0000RS\u0006"+
		"\u0002\uffff\uffff\u0000SU\u0001\u0000\u0000\u0000TK\u0001\u0000\u0000"+
		"\u0000TN\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000U\u0005\u0001"+
		"\u0000\u0000\u0000VW\u0003\u0012\t\u0000WX\u0005,\u0000\u0000XY\u0005"+
		"\u001b\u0000\u0000YZ\u0003\n\u0005\u0000Z[\u0005\u001c\u0000\u0000[\\"+
		"\u0005!\u0000\u0000\\]\u0006\u0003\uffff\uffff\u0000]f\u0001\u0000\u0000"+
		"\u0000^_\u0003\u0012\t\u0000_`\u0005,\u0000\u0000`a\u0005\u001b\u0000"+
		"\u0000ab\u0005\u001c\u0000\u0000bc\u0005!\u0000\u0000cd\u0006\u0003\uffff"+
		"\uffff\u0000df\u0001\u0000\u0000\u0000eV\u0001\u0000\u0000\u0000e^\u0001"+
		"\u0000\u0000\u0000f\u0007\u0001\u0000\u0000\u0000gh\u0003\u0012\t\u0000"+
		"hi\u0005,\u0000\u0000ij\u0006\u0004\uffff\uffff\u0000jk\u0005\u001b\u0000"+
		"\u0000kl\u0003\n\u0005\u0000lm\u0006\u0004\uffff\uffff\u0000mn\u0005\u001c"+
		"\u0000\u0000no\u0003\f\u0006\u0000op\u0006\u0004\uffff\uffff\u0000pz\u0001"+
		"\u0000\u0000\u0000qr\u0003\u0012\t\u0000rs\u0005,\u0000\u0000st\u0006"+
		"\u0004\uffff\uffff\u0000tu\u0005\u001b\u0000\u0000uv\u0005\u001c\u0000"+
		"\u0000vw\u0003\f\u0006\u0000wx\u0006\u0004\uffff\uffff\u0000xz\u0001\u0000"+
		"\u0000\u0000yg\u0001\u0000\u0000\u0000yq\u0001\u0000\u0000\u0000z\t\u0001"+
		"\u0000\u0000\u0000{|\u0006\u0005\uffff\uffff\u0000|}\u0003\u0012\t\u0000"+
		"}~\u0005,\u0000\u0000~\u007f\u0006\u0005\uffff\uffff\u0000\u007f\u0088"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0003\u0012\t\u0000\u0081\u0082\u0006"+
		"\u0005\uffff\uffff\u0000\u0082\u0088\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0003\u0012\t\u0000\u0084\u0085\u0005#\u0000\u0000\u0085\u0086\u0006"+
		"\u0005\uffff\uffff\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087{\u0001"+
		"\u0000\u0000\u0000\u0087\u0080\u0001\u0000\u0000\u0000\u0087\u0083\u0001"+
		"\u0000\u0000\u0000\u0088\u0096\u0001\u0000\u0000\u0000\u0089\u008a\n\u0005"+
		"\u0000\u0000\u008a\u008b\u0005\"\u0000\u0000\u008b\u008c\u0003\u0012\t"+
		"\u0000\u008c\u008d\u0005,\u0000\u0000\u008d\u008e\u0006\u0005\uffff\uffff"+
		"\u0000\u008e\u0095\u0001\u0000\u0000\u0000\u008f\u0090\n\u0004\u0000\u0000"+
		"\u0090\u0091\u0005\"\u0000\u0000\u0091\u0092\u0003\u0012\t\u0000\u0092"+
		"\u0093\u0006\u0005\uffff\uffff\u0000\u0093\u0095\u0001\u0000\u0000\u0000"+
		"\u0094\u0089\u0001\u0000\u0000\u0000\u0094\u008f\u0001\u0000\u0000\u0000"+
		"\u0095\u0098\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u000b\u0001\u0000\u0000\u0000"+
		"\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u001d\u0000\u0000"+
		"\u009a\u009b\u0006\u0006\uffff\uffff\u0000\u009b\u009c\u0003\u0016\u000b"+
		"\u0000\u009c\u009d\u0005\u001e\u0000\u0000\u009d\u009e\u0006\u0006\uffff"+
		"\uffff\u0000\u009e\u00a3\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u001d"+
		"\u0000\u0000\u00a0\u00a1\u0005\u001e\u0000\u0000\u00a1\u00a3\u0006\u0006"+
		"\uffff\uffff\u0000\u00a2\u0099\u0001\u0000\u0000\u0000\u00a2\u009f\u0001"+
		"\u0000\u0000\u0000\u00a3\r\u0001\u0000\u0000\u0000\u00a4\u00a5\u0003\u0012"+
		"\t\u0000\u00a5\u00a6\u0003\u0014\n\u0000\u00a6\u00a7\u0005!\u0000\u0000"+
		"\u00a7\u00a8\u0006\u0007\uffff\uffff\u0000\u00a8\u00af\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0003\u0012\t\u0000\u00aa\u00ab\u0003\u0010\b\u0000"+
		"\u00ab\u00ac\u0005!\u0000\u0000\u00ac\u00ad\u0006\u0007\uffff\uffff\u0000"+
		"\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00a4\u0001\u0000\u0000\u0000"+
		"\u00ae\u00a9\u0001\u0000\u0000\u0000\u00af\u000f\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0006\b\uffff\uffff\u0000\u00b1\u0011\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005\u0013\u0000\u0000\u00b3\u00b9\u0006\t\uffff\uffff\u0000"+
		"\u00b4\u00b5\u0005\u0014\u0000\u0000\u00b5\u00b9\u0006\t\uffff\uffff\u0000"+
		"\u00b6\u00b7\u0005\u0015\u0000\u0000\u00b7\u00b9\u0006\t\uffff\uffff\u0000"+
		"\u00b8\u00b2\u0001\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u0013\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0006\n\uffff\uffff\u0000\u00bb\u00bc\u0005,\u0000\u0000"+
		"\u00bc\u00c3\u0006\n\uffff\uffff\u0000\u00bd\u00be\u0005,\u0000\u0000"+
		"\u00be\u00bf\u0005\u001f\u0000\u0000\u00bf\u00c0\u0005-\u0000\u0000\u00c0"+
		"\u00c1\u0005 \u0000\u0000\u00c1\u00c3\u0006\n\uffff\uffff\u0000\u00c2"+
		"\u00ba\u0001\u0000\u0000\u0000\u00c2\u00bd\u0001\u0000\u0000\u0000\u00c3"+
		"\u00d5\u0001\u0000\u0000\u0000\u00c4\u00c5\n\u0005\u0000\u0000\u00c5\u00c6"+
		"\u0005\"\u0000\u0000\u00c6\u00c7\u0005,\u0000\u0000\u00c7\u00d4\u0006"+
		"\n\uffff\uffff\u0000\u00c8\u00c9\n\u0004\u0000\u0000\u00c9\u00ca\u0005"+
		"\"\u0000\u0000\u00ca\u00cb\u0005,\u0000\u0000\u00cb\u00cc\u0005\u001f"+
		"\u0000\u0000\u00cc\u00cd\u0005-\u0000\u0000\u00cd\u00ce\u0005 \u0000\u0000"+
		"\u00ce\u00d4\u0006\n\uffff\uffff\u0000\u00cf\u00d0\n\u0003\u0000\u0000"+
		"\u00d0\u00d1\u0005#\u0000\u0000\u00d1\u00d2\u0005,\u0000\u0000\u00d2\u00d4"+
		"\u0006\n\uffff\uffff\u0000\u00d3\u00c4\u0001\u0000\u0000\u0000\u00d3\u00c8"+
		"\u0001\u0000\u0000\u0000\u00d3\u00cf\u0001\u0000\u0000\u0000\u00d4\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d6\u0015\u0001\u0000\u0000\u0000\u00d7\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0006\u000b\uffff\uffff\u0000\u00d9"+
		"\u00da\u0003\u0018\f\u0000\u00da\u00db\u0006\u000b\uffff\uffff\u0000\u00db"+
		"\u00e2\u0001\u0000\u0000\u0000\u00dc\u00dd\n\u0001\u0000\u0000\u00dd\u00de"+
		"\u0003\u0018\f\u0000\u00de\u00df\u0006\u000b\uffff\uffff\u0000\u00df\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e0\u00dc\u0001\u0000\u0000\u0000\u00e1\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e3\u0017\u0001\u0000\u0000\u0000\u00e4\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0003\u000e\u0007\u0000\u00e6\u00e7"+
		"\u0006\f\uffff\uffff\u0000\u00e7\u0143\u0001\u0000\u0000\u0000\u00e8\u00e9"+
		"\u0003&\u0013\u0000\u00e9\u00ea\u0005\u0019\u0000\u0000\u00ea\u00eb\u0006"+
		"\f\uffff\uffff\u0000\u00eb\u0143\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005"+
		"\u0007\u0000\u0000\u00ed\u00ee\u0005\u001b\u0000\u0000\u00ee\u00ef\u0003"+
		"&\u0013\u0000\u00ef\u00f0\u0005\u001c\u0000\u0000\u00f0\u00f1\u0005\u001d"+
		"\u0000\u0000\u00f1\u00f2\u0003\u001a\r\u0000\u00f2\u00f3\u0005\u001e\u0000"+
		"\u0000\u00f3\u00f4\u0006\f\uffff\uffff\u0000\u00f4\u0143\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0005\u0018\u0000\u0000\u00f6\u00f7\u0003&\u0013\u0000"+
		"\u00f7\u00f8\u0005!\u0000\u0000\u00f8\u00f9\u0006\f\uffff\uffff\u0000"+
		"\u00f9\u0143\u0001\u0000\u0000\u0000\u00fa\u00fb\u0003\u001e\u000f\u0000"+
		"\u00fb\u00fc\u0006\f\uffff\uffff\u0000\u00fc\u0143\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fe\u0003\f\u0006\u0000\u00fe\u00ff\u0006\f\uffff\uffff\u0000"+
		"\u00ff\u0143\u0001\u0000\u0000\u0000\u0100\u0101\u0005\u000b\u0000\u0000"+
		"\u0101\u0102\u0006\f\uffff\uffff\u0000\u0102\u0103\u0005\u001b\u0000\u0000"+
		"\u0103\u0104\u0003\u001e\u000f\u0000\u0104\u0105\u0006\f\uffff\uffff\u0000"+
		"\u0105\u0106\u0003\u001e\u000f\u0000\u0106\u0107\u0006\f\uffff\uffff\u0000"+
		"\u0107\u0108\u0003&\u0013\u0000\u0108\u0109\u0005\u001c\u0000\u0000\u0109"+
		"\u010a\u0006\f\uffff\uffff\u0000\u010a\u010b\u0003\u0018\f\u0000\u010b"+
		"\u010c\u0006\f\uffff\uffff\u0000\u010c\u0143\u0001\u0000\u0000\u0000\u010d"+
		"\u010e\u0005\u0005\u0000\u0000\u010e\u010f\u0005\u001b\u0000\u0000\u010f"+
		"\u0110\u0003&\u0013\u0000\u0110\u0111\u0005\u001c\u0000\u0000\u0111\u0112"+
		"\u0005\u0016\u0000\u0000\u0112\u0113\u0005!\u0000\u0000\u0113\u0114\u0006"+
		"\f\uffff\uffff\u0000\u0114\u0143\u0001\u0000\u0000\u0000\u0115\u0116\u0005"+
		"\u0005\u0000\u0000\u0116\u0117\u0006\f\uffff\uffff\u0000\u0117\u0118\u0005"+
		"\u001b\u0000\u0000\u0118\u0119\u0003&\u0013\u0000\u0119\u011a\u0005\u001c"+
		"\u0000\u0000\u011a\u011b\u0006\f\uffff\uffff\u0000\u011b\u011c\u0003\u0018"+
		"\f\u0000\u011c\u011d\u0006\f\uffff\uffff\u0000\u011d\u0143\u0001\u0000"+
		"\u0000\u0000\u011e\u011f\u0005\u0005\u0000\u0000\u011f\u0120\u0005\u001b"+
		"\u0000\u0000\u0120\u0121\u0003&\u0013\u0000\u0121\u0122\u0005\u001c\u0000"+
		"\u0000\u0122\u0123\u0006\f\uffff\uffff\u0000\u0123\u0124\u0003\u0018\f"+
		"\u0000\u0124\u0125\u0006\f\uffff\uffff\u0000\u0125\u0126\u0005\n\u0000"+
		"\u0000\u0126\u0127\u0003\u0018\f\u0000\u0127\u0128\u0006\f\uffff\uffff"+
		"\u0000\u0128\u0143\u0001\u0000\u0000\u0000\u0129\u012a\u0005\u0017\u0000"+
		"\u0000\u012a\u012b\u0005!\u0000\u0000\u012b\u0143\u0006\f\uffff\uffff"+
		"\u0000\u012c\u012d\u0005\u000f\u0000\u0000\u012d\u0143\u0006\f\uffff\uffff"+
		"\u0000\u012e\u012f\u0005\u000f\u0000\u0000\u012f\u0130\u0006\f\uffff\uffff"+
		"\u0000\u0130\u0131\u0005\u001b\u0000\u0000\u0131\u0132\u0003&\u0013\u0000"+
		"\u0132\u0133\u0006\f\uffff\uffff\u0000\u0133\u0134\u0005\u001c\u0000\u0000"+
		"\u0134\u0135\u0003\u0018\f\u0000\u0135\u0136\u0006\f\uffff\uffff\u0000"+
		"\u0136\u0143\u0001\u0000\u0000\u0000\u0137\u0138\u0005\u0011\u0000\u0000"+
		"\u0138\u0139\u0005\u001b\u0000\u0000\u0139\u013a\u0005,\u0000\u0000\u013a"+
		"\u013b\u0005\u001c\u0000\u0000\u013b\u013c\u0005!\u0000\u0000\u013c\u0143"+
		"\u0006\f\uffff\uffff\u0000\u013d\u013e\u0005\u0012\u0000\u0000\u013e\u013f"+
		"\u0003&\u0013\u0000\u013f\u0140\u0005!\u0000\u0000\u0140\u0141\u0006\f"+
		"\uffff\uffff\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u00e5\u0001"+
		"\u0000\u0000\u0000\u0142\u00e8\u0001\u0000\u0000\u0000\u0142\u00ec\u0001"+
		"\u0000\u0000\u0000\u0142\u00f5\u0001\u0000\u0000\u0000\u0142\u00fa\u0001"+
		"\u0000\u0000\u0000\u0142\u00fd\u0001\u0000\u0000\u0000\u0142\u0100\u0001"+
		"\u0000\u0000\u0000\u0142\u010d\u0001\u0000\u0000\u0000\u0142\u0115\u0001"+
		"\u0000\u0000\u0000\u0142\u011e\u0001\u0000\u0000\u0000\u0142\u0129\u0001"+
		"\u0000\u0000\u0000\u0142\u012c\u0001\u0000\u0000\u0000\u0142\u012e\u0001"+
		"\u0000\u0000\u0000\u0142\u0137\u0001\u0000\u0000\u0000\u0142\u013d\u0001"+
		"\u0000\u0000\u0000\u0143\u0019\u0001\u0000\u0000\u0000\u0144\u0145\u0006"+
		"\r\uffff\uffff\u0000\u0145\u0146\u0003\u001c\u000e\u0000\u0146\u0147\u0006"+
		"\r\uffff\uffff\u0000\u0147\u014e\u0001\u0000\u0000\u0000\u0148\u0149\n"+
		"\u0001\u0000\u0000\u0149\u014a\u0003\u001c\u000e\u0000\u014a\u014b\u0006"+
		"\r\uffff\uffff\u0000\u014b\u014d\u0001\u0000\u0000\u0000\u014c\u0148\u0001"+
		"\u0000\u0000\u0000\u014d\u0150\u0001\u0000\u0000\u0000\u014e\u014c\u0001"+
		"\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f\u001b\u0001"+
		"\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0151\u0152\u0005"+
		"\u0006\u0000\u0000\u0152\u0153\u0005-\u0000\u0000\u0153\u0154\u0005\u0019"+
		"\u0000\u0000\u0154\u0155\u0003\u0016\u000b\u0000\u0155\u0156\u0006\u000e"+
		"\uffff\uffff\u0000\u0156\u001d\u0001\u0000\u0000\u0000\u0157\u0158\u0005"+
		"!\u0000\u0000\u0158\u015e\u0006\u000f\uffff\uffff\u0000\u0159\u015a\u0003"+
		"&\u0013\u0000\u015a\u015b\u0005!\u0000\u0000\u015b\u015c\u0006\u000f\uffff"+
		"\uffff\u0000\u015c\u015e\u0001\u0000\u0000\u0000\u015d\u0157\u0001\u0000"+
		"\u0000\u0000\u015d\u0159\u0001\u0000\u0000\u0000\u015e\u001f\u0001\u0000"+
		"\u0000\u0000\u015f\u0160\u0003\"\u0011\u0000\u0160\u0161\u0005\t\u0000"+
		"\u0000\u0161\u0162\u0003.\u0017\u0000\u0162\u0163\u0006\u0010\uffff\uffff"+
		"\u0000\u0163!\u0001\u0000\u0000\u0000\u0164\u0165\u0003.\u0017\u0000\u0165"+
		"\u0166\u0005\b\u0000\u0000\u0166\u0167\u0003.\u0017\u0000\u0167\u0168"+
		"\u0006\u0011\uffff\uffff\u0000\u0168#\u0001\u0000\u0000\u0000\u0169\u016a"+
		"\u0005,\u0000\u0000\u016a\u0172\u0006\u0012\uffff\uffff\u0000\u016b\u016c"+
		"\u0005,\u0000\u0000\u016c\u016d\u0005\u001f\u0000\u0000\u016d\u016e\u0003"+
		"&\u0013\u0000\u016e\u016f\u0005 \u0000\u0000\u016f\u0170\u0006\u0012\uffff"+
		"\uffff\u0000\u0170\u0172\u0001\u0000\u0000\u0000\u0171\u0169\u0001\u0000"+
		"\u0000\u0000\u0171\u016b\u0001\u0000\u0000\u0000\u0172%\u0001\u0000\u0000"+
		"\u0000\u0173\u0174\u0003*\u0015\u0000\u0174\u0175\u0006\u0013\uffff\uffff"+
		"\u0000\u0175\u017c\u0001\u0000\u0000\u0000\u0176\u0177\u0003$\u0012\u0000"+
		"\u0177\u0178\u0005+\u0000\u0000\u0178\u0179\u0003*\u0015\u0000\u0179\u017a"+
		"\u0006\u0013\uffff\uffff\u0000\u017a\u017c\u0001\u0000\u0000\u0000\u017b"+
		"\u0173\u0001\u0000\u0000\u0000\u017b\u0176\u0001\u0000\u0000\u0000\u017c"+
		"\'\u0001\u0000\u0000\u0000\u017d\u017e\u0005\u001b\u0000\u0000\u017e\u017f"+
		"\u0003*\u0015\u0000\u017f\u0180\u0005)\u0000\u0000\u0180\u0181\u0003*"+
		"\u0015\u0000\u0181\u0182\u0005\u001c\u0000\u0000\u0182\u0183\u0005\u001a"+
		"\u0000\u0000\u0183\u0184\u0003*\u0015\u0000\u0184\u0185\u0005\u0019\u0000"+
		"\u0000\u0185\u0186\u0003*\u0015\u0000\u0186\u0187\u0006\u0014\uffff\uffff"+
		"\u0000\u0187)\u0001\u0000\u0000\u0000\u0188\u0189\u0003,\u0016\u0000\u0189"+
		"\u018a\u0006\u0015\uffff\uffff\u0000\u018a\u0192\u0001\u0000\u0000\u0000"+
		"\u018b\u018c\u0003,\u0016\u0000\u018c\u018d\u0006\u0015\uffff\uffff\u0000"+
		"\u018d\u018e\u0005*\u0000\u0000\u018e\u018f\u0003,\u0016\u0000\u018f\u0190"+
		"\u0006\u0015\uffff\uffff\u0000\u0190\u0192\u0001\u0000\u0000\u0000\u0191"+
		"\u0188\u0001\u0000\u0000\u0000\u0191\u018b\u0001\u0000\u0000\u0000\u0192"+
		"+\u0001\u0000\u0000\u0000\u0193\u0194\u0003.\u0017\u0000\u0194\u0195\u0006"+
		"\u0016\uffff\uffff\u0000\u0195\u019d\u0001\u0000\u0000\u0000\u0196\u0197"+
		"\u0003.\u0017\u0000\u0197\u0198\u0006\u0016\uffff\uffff\u0000\u0198\u0199"+
		"\u0005)\u0000\u0000\u0199\u019a\u0003.\u0017\u0000\u019a\u019b\u0006\u0016"+
		"\uffff\uffff\u0000\u019b\u019d\u0001\u0000\u0000\u0000\u019c\u0193\u0001"+
		"\u0000\u0000\u0000\u019c\u0196\u0001\u0000\u0000\u0000\u019d-\u0001\u0000"+
		"\u0000\u0000\u019e\u019f\u0006\u0017\uffff\uffff\u0000\u019f\u01a0\u0003"+
		"0\u0018\u0000\u01a0\u01a1\u0006\u0017\uffff\uffff\u0000\u01a1\u01a4\u0001"+
		"\u0000\u0000\u0000\u01a2\u01a4\u0001\u0000\u0000\u0000\u01a3\u019e\u0001"+
		"\u0000\u0000\u0000\u01a3\u01a2\u0001\u0000\u0000\u0000\u01a4\u01b0\u0001"+
		"\u0000\u0000\u0000\u01a5\u01a6\n\u0003\u0000\u0000\u01a6\u01a7\u0005#"+
		"\u0000\u0000\u01a7\u01a8\u00030\u0018\u0000\u01a8\u01a9\u0006\u0017\uffff"+
		"\uffff\u0000\u01a9\u01af\u0001\u0000\u0000\u0000\u01aa\u01ab\n\u0002\u0000"+
		"\u0000\u01ab\u01ac\u0005#\u0000\u0000\u01ac\u01ad\u0005+\u0000\u0000\u01ad"+
		"\u01af\u0006\u0017\uffff\uffff\u0000\u01ae\u01a5\u0001\u0000\u0000\u0000"+
		"\u01ae\u01aa\u0001\u0000\u0000\u0000\u01af\u01b2\u0001\u0000\u0000\u0000"+
		"\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000"+
		"\u01b1/\u0001\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000\u0000\u0000\u01b3"+
		"\u01b4\u0006\u0018\uffff\uffff\u0000\u01b4\u01b5\u00032\u0019\u0000\u01b5"+
		"\u01b6\u0006\u0018\uffff\uffff\u0000\u01b6\u01be\u0001\u0000\u0000\u0000"+
		"\u01b7\u01b8\n\u0001\u0000\u0000\u01b8\u01b9\u0005%\u0000\u0000\u01b9"+
		"\u01ba\u00032\u0019\u0000\u01ba\u01bb\u0006\u0018\uffff\uffff\u0000\u01bb"+
		"\u01bd\u0001\u0000\u0000\u0000\u01bc\u01b7\u0001\u0000\u0000\u0000\u01bd"+
		"\u01c0\u0001\u0000\u0000\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01be"+
		"\u01bf\u0001\u0000\u0000\u0000\u01bf1\u0001\u0000\u0000\u0000\u01c0\u01be"+
		"\u0001\u0000\u0000\u0000\u01c1\u01c2\u0005#\u0000\u0000\u01c2\u01c3\u0003"+
		"2\u0019\u0000\u01c3\u01c4\u0006\u0019\uffff\uffff\u0000\u01c4\u01cd\u0001"+
		"\u0000\u0000\u0000\u01c5\u01c6\u0005(\u0000\u0000\u01c6\u01c7\u00032\u0019"+
		"\u0000\u01c7\u01c8\u0006\u0019\uffff\uffff\u0000\u01c8\u01cd\u0001\u0000"+
		"\u0000\u0000\u01c9\u01ca\u00034\u001a\u0000\u01ca\u01cb\u0006\u0019\uffff"+
		"\uffff\u0000\u01cb\u01cd\u0001\u0000\u0000\u0000\u01cc\u01c1\u0001\u0000"+
		"\u0000\u0000\u01cc\u01c5\u0001\u0000\u0000\u0000\u01cc\u01c9\u0001\u0000"+
		"\u0000\u0000\u01cd3\u0001\u0000\u0000\u0000\u01ce\u01cf\u0003$\u0012\u0000"+
		"\u01cf\u01d0\u0006\u001a\uffff\uffff\u0000\u01d0\u01ed\u0001\u0000\u0000"+
		"\u0000\u01d1\u01d2\u0005,\u0000\u0000\u01d2\u01d3\u0005\u001b\u0000\u0000"+
		"\u01d3\u01d4\u0005\u001c\u0000\u0000\u01d4\u01ed\u0006\u001a\uffff\uffff"+
		"\u0000\u01d5\u01d6\u0005,\u0000\u0000\u01d6\u01d7\u0005\u001b\u0000\u0000"+
		"\u01d7\u01d8\u00036\u001b\u0000\u01d8\u01d9\u0005\u001c\u0000\u0000\u01d9"+
		"\u01da\u0006\u001a\uffff\uffff\u0000\u01da\u01ed\u0001\u0000\u0000\u0000"+
		"\u01db\u01dc\u0005\u001b\u0000\u0000\u01dc\u01dd\u0003&\u0013\u0000\u01dd"+
		"\u01de\u0005\u001c\u0000\u0000\u01de\u01df\u0006\u001a\uffff\uffff\u0000"+
		"\u01df\u01ed\u0001\u0000\u0000\u0000\u01e0\u01e1\u0005-\u0000\u0000\u01e1"+
		"\u01ed\u0006\u001a\uffff\uffff\u0000\u01e2\u01e3\u0005.\u0000\u0000\u01e3"+
		"\u01ed\u0006\u001a\uffff\uffff\u0000\u01e4\u01e5\u0003$\u0012\u0000\u01e5"+
		"\u01e6\u0005&\u0000\u0000\u01e6\u01e7\u0006\u001a\uffff\uffff\u0000\u01e7"+
		"\u01ed\u0001\u0000\u0000\u0000\u01e8\u01e9\u0003$\u0012\u0000\u01e9\u01ea"+
		"\u0005\'\u0000\u0000\u01ea\u01eb\u0006\u001a\uffff\uffff\u0000\u01eb\u01ed"+
		"\u0001\u0000\u0000\u0000\u01ec\u01ce\u0001\u0000\u0000\u0000\u01ec\u01d1"+
		"\u0001\u0000\u0000\u0000\u01ec\u01d5\u0001\u0000\u0000\u0000\u01ec\u01db"+
		"\u0001\u0000\u0000\u0000\u01ec\u01e0\u0001\u0000\u0000\u0000\u01ec\u01e2"+
		"\u0001\u0000\u0000\u0000\u01ec\u01e4\u0001\u0000\u0000\u0000\u01ec\u01e8"+
		"\u0001\u0000\u0000\u0000\u01ed5\u0001\u0000\u0000\u0000\u01ee\u01ef\u0003"+
		"8\u001c\u0000\u01ef\u01f0\u0006\u001b\uffff\uffff\u0000\u01f0\u01f3\u0001"+
		"\u0000\u0000\u0000\u01f1\u01f3\u0001\u0000\u0000\u0000\u01f2\u01ee\u0001"+
		"\u0000\u0000\u0000\u01f2\u01f1\u0001\u0000\u0000\u0000\u01f37\u0001\u0000"+
		"\u0000\u0000\u01f4\u01f5\u0006\u001c\uffff\uffff\u0000\u01f5\u01f6\u0003"+
		"*\u0015\u0000\u01f6\u01f7\u0006\u001c\uffff\uffff\u0000\u01f7\u01ff\u0001"+
		"\u0000\u0000\u0000\u01f8\u01f9\n\u0002\u0000\u0000\u01f9\u01fa\u0005\""+
		"\u0000\u0000\u01fa\u01fb\u0003*\u0015\u0000\u01fb\u01fc\u0006\u001c\uffff"+
		"\uffff\u0000\u01fc\u01fe\u0001\u0000\u0000\u0000\u01fd\u01f8\u0001\u0000"+
		"\u0000\u0000\u01fe\u0201\u0001\u0000\u0000\u0000\u01ff\u01fd\u0001\u0000"+
		"\u0000\u0000\u01ff\u0200\u0001\u0000\u0000\u0000\u02009\u0001\u0000\u0000"+
		"\u0000\u0201\u01ff\u0001\u0000\u0000\u0000\u001dHTey\u0087\u0094\u0096"+
		"\u00a2\u00ae\u00b8\u00c2\u00d3\u00d5\u00e2\u0142\u014e\u015d\u0171\u017b"+
		"\u0191\u019c\u01a3\u01ae\u01b0\u01be\u01cc\u01ec\u01f2\u01ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}