// Generated from C:/Users/adris/IdeaProjects/PenguinScript/src/main.java.compiler\XSEScript.g4 by ANTLR 4.7.2
package main.java.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XSEScriptParser}.
 */
public interface XSEScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(XSEScriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(XSEScriptParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(XSEScriptParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(XSEScriptParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#v_assig}.
	 * @param ctx the parse tree
	 */
	void enterV_assig(XSEScriptParser.V_assigContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#v_assig}.
	 * @param ctx the parse tree
	 */
	void exitV_assig(XSEScriptParser.V_assigContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(XSEScriptParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(XSEScriptParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#f_assig}.
	 * @param ctx the parse tree
	 */
	void enterF_assig(XSEScriptParser.F_assigContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#f_assig}.
	 * @param ctx the parse tree
	 */
	void exitF_assig(XSEScriptParser.F_assigContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(XSEScriptParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(XSEScriptParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#instr}.
	 * @param ctx the parse tree
	 */
	void enterInstr(XSEScriptParser.InstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#instr}.
	 * @param ctx the parse tree
	 */
	void exitInstr(XSEScriptParser.InstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(XSEScriptParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(XSEScriptParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(XSEScriptParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(XSEScriptParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(XSEScriptParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(XSEScriptParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#elem}.
	 * @param ctx the parse tree
	 */
	void enterElem(XSEScriptParser.ElemContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#elem}.
	 * @param ctx the parse tree
	 */
	void exitElem(XSEScriptParser.ElemContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(XSEScriptParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(XSEScriptParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#b_expr}.
	 * @param ctx the parse tree
	 */
	void enterB_expr(XSEScriptParser.B_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#b_expr}.
	 * @param ctx the parse tree
	 */
	void exitB_expr(XSEScriptParser.B_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterChoice(XSEScriptParser.ChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitChoice(XSEScriptParser.ChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link XSEScriptParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(XSEScriptParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XSEScriptParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(XSEScriptParser.OpContext ctx);
}