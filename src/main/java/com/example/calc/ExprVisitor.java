// Generated from src/main/antlr4/Expr.g4 by ANTLR 4.13.2

  package com.example.calc;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(ExprParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcDefStat}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefStat(ExprParser.FuncDefStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(ExprParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(ExprParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(ExprParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(ExprParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code toTerm}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToTerm(ExprParser.ToTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(ExprParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code div}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(ExprParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code implicitMul}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitMul(ExprParser.ImplicitMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(ExprParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code toPow}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPow(ExprParser.ToPowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code power}
	 * labeled alternative in {@link ExprParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(ExprParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code toUnary}
	 * labeled alternative in {@link ExprParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToUnary(ExprParser.ToUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusUnary}
	 * labeled alternative in {@link ExprParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusUnary(ExprParser.PlusUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusUnary}
	 * labeled alternative in {@link ExprParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusUnary(ExprParser.MinusUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code toPrimary}
	 * labeled alternative in {@link ExprParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPrimary(ExprParser.ToPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ExprParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(ExprParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(ExprParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ExprParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(ExprParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(ExprParser.ArgListContext ctx);
}