// Generated from src/main/antlr4/Expr.g4 by ANTLR 4.13.2

  package com.example.calc;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(ExprParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(ExprParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcDefStat}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefStat(ExprParser.FuncDefStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcDefStat}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefStat(ExprParser.FuncDefStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(ExprParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(ExprParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(ExprParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(ExprParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(ExprParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(ExprParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd(ExprParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd(ExprParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toTerm}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterToTerm(ExprParser.ToTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toTerm}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitToTerm(ExprParser.ToTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sub}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSub(ExprParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSub(ExprParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code div}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDiv(ExprParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code div}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDiv(ExprParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code implicitMul}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterImplicitMul(ExprParser.ImplicitMulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code implicitMul}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitImplicitMul(ExprParser.ImplicitMulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mul}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMul(ExprParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMul(ExprParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toPow}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterToPow(ExprParser.ToPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toPow}
	 * labeled alternative in {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitToPow(ExprParser.ToPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code power}
	 * labeled alternative in {@link ExprParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPower(ExprParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code power}
	 * labeled alternative in {@link ExprParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPower(ExprParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toUnary}
	 * labeled alternative in {@link ExprParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterToUnary(ExprParser.ToUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toUnary}
	 * labeled alternative in {@link ExprParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitToUnary(ExprParser.ToUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusUnary}
	 * labeled alternative in {@link ExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterPlusUnary(ExprParser.PlusUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusUnary}
	 * labeled alternative in {@link ExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitPlusUnary(ExprParser.PlusUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusUnary}
	 * labeled alternative in {@link ExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterMinusUnary(ExprParser.MinusUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusUnary}
	 * labeled alternative in {@link ExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitMinusUnary(ExprParser.MinusUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toPrimary}
	 * labeled alternative in {@link ExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterToPrimary(ExprParser.ToPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toPrimary}
	 * labeled alternative in {@link ExprParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitToPrimary(ExprParser.ToPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ExprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ExprParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(ExprParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(ExprParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(ExprParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(ExprParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterId(ExprParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitId(ExprParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterParens(ExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitParens(ExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(ExprParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(ExprParser.ArgListContext ctx);
}