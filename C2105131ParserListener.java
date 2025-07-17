// Generated from C2105131Parser.g4 by ANTLR 4.13.2

import java.io.BufferedWriter;
import java.io.IOException;
import SymbolTable.SymbolInfo;

import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link C2105131Parser}.
 */
public interface C2105131ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(C2105131Parser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(C2105131Parser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(C2105131Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(C2105131Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(C2105131Parser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(C2105131Parser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#func_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunc_declaration(C2105131Parser.Func_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#func_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunc_declaration(C2105131Parser.Func_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#func_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunc_definition(C2105131Parser.Func_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#func_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunc_definition(C2105131Parser.Func_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(C2105131Parser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(C2105131Parser.Parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement(C2105131Parser.Compound_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement(C2105131Parser.Compound_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVar_declaration(C2105131Parser.Var_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVar_declaration(C2105131Parser.Var_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#declaration_list_err}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_list_err(C2105131Parser.Declaration_list_errContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#declaration_list_err}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_list_err(C2105131Parser.Declaration_list_errContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void enterType_specifier(C2105131Parser.Type_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void exitType_specifier(C2105131Parser.Type_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_list(C2105131Parser.Declaration_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_list(C2105131Parser.Declaration_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(C2105131Parser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(C2105131Parser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(C2105131Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(C2105131Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#case_statements}.
	 * @param ctx the parse tree
	 */
	void enterCase_statements(C2105131Parser.Case_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#case_statements}.
	 * @param ctx the parse tree
	 */
	void exitCase_statements(C2105131Parser.Case_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#case_statement}.
	 * @param ctx the parse tree
	 */
	void enterCase_statement(C2105131Parser.Case_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#case_statement}.
	 * @param ctx the parse tree
	 */
	void exitCase_statement(C2105131Parser.Case_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(C2105131Parser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(C2105131Parser.Expression_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#forin_statement}.
	 * @param ctx the parse tree
	 */
	void enterForin_statement(C2105131Parser.Forin_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#forin_statement}.
	 * @param ctx the parse tree
	 */
	void exitForin_statement(C2105131Parser.Forin_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#foreach_statement}.
	 * @param ctx the parse tree
	 */
	void enterForeach_statement(C2105131Parser.Foreach_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#foreach_statement}.
	 * @param ctx the parse tree
	 */
	void exitForeach_statement(C2105131Parser.Foreach_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(C2105131Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(C2105131Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(C2105131Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(C2105131Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#ternary_expression}.
	 * @param ctx the parse tree
	 */
	void enterTernary_expression(C2105131Parser.Ternary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#ternary_expression}.
	 * @param ctx the parse tree
	 */
	void exitTernary_expression(C2105131Parser.Ternary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#logic_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogic_expression(C2105131Parser.Logic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#logic_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogic_expression(C2105131Parser.Logic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void enterRel_expression(C2105131Parser.Rel_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void exitRel_expression(C2105131Parser.Rel_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expression(C2105131Parser.Simple_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expression(C2105131Parser.Simple_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(C2105131Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(C2105131Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(C2105131Parser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(C2105131Parser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(C2105131Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(C2105131Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#argument_list}.
	 * @param ctx the parse tree
	 */
	void enterArgument_list(C2105131Parser.Argument_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#argument_list}.
	 * @param ctx the parse tree
	 */
	void exitArgument_list(C2105131Parser.Argument_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105131Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(C2105131Parser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105131Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(C2105131Parser.ArgumentsContext ctx);
}