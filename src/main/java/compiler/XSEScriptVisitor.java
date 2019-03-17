// Generated from C:/Users/adris/IdeaProjects/PenguinScript/src/main.java.compiler\XSEScript.g4 by ANTLR 4.7.2
package main.java.compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XSEScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XSEScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(XSEScriptParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(XSEScriptParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#v_assig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitV_assig(XSEScriptParser.V_assigContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(XSEScriptParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#f_assig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_assig(XSEScriptParser.F_assigContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(XSEScriptParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstr(XSEScriptParser.InstrContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(XSEScriptParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(XSEScriptParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(XSEScriptParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElem(XSEScriptParser.ElemContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(XSEScriptParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#b_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitB_expr(XSEScriptParser.B_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(XSEScriptParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link XSEScriptParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(XSEScriptParser.OpContext ctx);
}