package com.example.calc;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;
import java.io.*;
import com.google.gson.*;

public class EvalVisitor extends ExprBaseVisitor<Double> {
    private final Map<String, Double> vars = new HashMap<>();
    private final Map<String, UserFunction> functions = new HashMap<>();
    private final PlotterFX plotter;
    private final StringBuilder output;

    public EvalVisitor(PlotterFX plotter, StringBuilder output) {
        this.plotter = plotter;
        this.output = output;
    }

    public static class UserFunction {
        public final List<String> params;
        public final ExprParser.ExprContext expr;
        public UserFunction(List<String> params, ExprParser.ExprContext expr) {
            this.params = params; this.expr = expr;
        }
    }

    @Override
    public Double visitAssignStat(ExprParser.AssignStatContext ctx) {
        String name = ctx.ID().getText();
        Double val = visit(ctx.expr());
        vars.put(name, val);
        append(name + " = " + val);
        return val;
    }

    @Override
    public Double visitFuncDefStat(ExprParser.FuncDefStatContext ctx) {
        return visit(ctx.funcDef());
    }

    @Override
    public Double visitFuncDef(ExprParser.FuncDefContext ctx) {
        String fname = ctx.ID().getText();
        List<String> params = new ArrayList<>();
        if (ctx.paramList() != null)
            for (TerminalNode id : ctx.paramList().ID()) params.add(id.getText());
        functions.put(fname, new UserFunction(params, ctx.expr()));
        append("Defined function: " + fname);
        return 0.0;
    }

    @Override
    public Double visitExprStat(ExprParser.ExprStatContext ctx) {
        Double v = visit(ctx.expr());
        append("" + v);
        return v;
    }

    @Override
    public Double visitAdd(ExprParser.AddContext ctx) { return visit(ctx.expr()) + visit(ctx.term()); }
    @Override
    public Double visitSub(ExprParser.SubContext ctx) { return visit(ctx.expr()) - visit(ctx.term()); }
    @Override
    public Double visitMul(ExprParser.MulContext ctx) { return visit(ctx.term()) * visit(ctx.pow()); }
    @Override
    public Double visitDiv(ExprParser.DivContext ctx) { return visit(ctx.term()) / visit(ctx.pow()); }
    @Override
    public Double visitPower(ExprParser.PowerContext ctx) { return Math.pow(visit(ctx.unary()), visit(ctx.pow())); }
    @Override
    public Double visitPlusUnary(ExprParser.PlusUnaryContext ctx) { return visit(ctx.unary()); }
    @Override
    public Double visitMinusUnary(ExprParser.MinusUnaryContext ctx) { return -visit(ctx.unary()); }
    @Override
    public Double visitNumber(ExprParser.NumberContext ctx) { return Double.parseDouble(ctx.NUMBER().getText()); }
    @Override
    public Double visitParens(ExprParser.ParensContext ctx) { return visit(ctx.expr()); }

    @Override
    public Double visitId(ExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (vars.containsKey(id)) return vars.get(id);
        throw new RuntimeException("Undefined variable: " + id);
    }

    @Override
    public Double visitStringLiteral(ExprParser.StringLiteralContext ctx) {
        // Return 0.0 (dummy) because plotting uses it only for color extraction
        // but store the string value in a map if needed
        return 0.0;
    }


    @Override
    public Double visitFuncCall(ExprParser.FuncCallContext ctx) {
        String fname = ctx.ID().getText();
        List<ExprParser.ExprContext> args = new ArrayList<>();
        if (ctx.argList() != null) args.addAll(ctx.argList().expr());

        if (fname.equalsIgnoreCase("plot"))
            return handlePlot(args, ctx);

        double[] avals = new double[args.size()];
        for (int i = 0; i < args.size(); ++i) avals[i] = visit(args.get(i));

        if (functions.containsKey(fname)) {
            UserFunction uf = functions.get(fname);
            if (uf.params.size() != avals.length) throw new RuntimeException("Wrong args for " + fname);
            Map<String, Double> backup = new HashMap<>(vars);
            for (int i = 0; i < uf.params.size(); ++i) vars.put(uf.params.get(i), avals[i]);
            double result = visit(uf.expr);
            vars.clear(); vars.putAll(backup);
            return result;
        }

        return switch (fname.toLowerCase()) {
            case "sin" -> Math.sin(avals[0]);
            case "cos" -> Math.cos(avals[0]);
            case "tan" -> Math.tan(avals[0]);
            case "sqrt" -> Math.sqrt(avals[0]);
            case "abs" -> Math.abs(avals[0]);
            case "ln" -> Math.log(avals[0]);
            case "exp" -> Math.exp(avals[0]);
            case "pow" -> Math.pow(avals[0], avals[1]);
            default -> throw new RuntimeException("Unknown function: " + fname);
        };
    }

    private Double handlePlot(List<ExprParser.ExprContext> args, ExprParser.FuncCallContext ctx) {
        if (args.size() < 3) throw new RuntimeException("plot(expr,xmin,xmax[,color])");
        ExprParser.ExprContext exprCtx = args.get(0);
        double xmin = visit(args.get(1));
        double xmax = visit(args.get(2));
        String color = (args.size() >= 4) ? ctx.argList().expr(3).getText().replace("\"", "") : "black";
        int samples = 400;

        double[] xs = new double[samples];
        double[] ys = new double[samples];
        Map<String, Double> backup = new HashMap<>(vars);
        try {
            for (int i = 0; i < samples; ++i) {
                double t = (double)i / (samples - 1);
                double x = xmin + t * (xmax - xmin);
                vars.put("x", x);
                ys[i] = visit(exprCtx);
                xs[i] = x;
            }
        } finally { vars.clear(); vars.putAll(backup); }

        plotter.addPlot(ctx.getText(), xs, ys, color);
        append("Plotted: " + ctx.getText());
        return 0.0;
    }

    private void append(String s) {
        output.append(s).append("\n");
    }

    public void saveSession(String filename) {
        try (Writer writer = new FileWriter(filename)) {
            JsonObject root = new JsonObject();

            JsonObject varsJson = new JsonObject();
            for (var e : vars.entrySet()) varsJson.addProperty(e.getKey(), e.getValue());
            root.add("vars", varsJson);

            JsonObject funcsJson = new JsonObject();
            for (var e : functions.entrySet()) {
                JsonObject fobj = new JsonObject();
                fobj.add("params", new Gson().toJsonTree(e.getValue().params));
                fobj.addProperty("expr", e.getValue().expr.getText());
                funcsJson.add(e.getKey(), fobj);
            }
            root.add("functions", funcsJson);

            new GsonBuilder().setPrettyPrinting().create().toJson(root, writer);
        } catch (Exception e) {
            System.err.println("Error saving session: " + e.getMessage());
        }
    }

    public void loadSession(String filename) {
        try (Reader reader = new FileReader(filename)) {
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();

            vars.clear();
            JsonObject varsJson = root.getAsJsonObject("vars");
            for (String key : varsJson.keySet()) {
                vars.put(key, varsJson.get(key).getAsDouble());
            }

            functions.clear();
            JsonObject funcsJson = root.getAsJsonObject("functions");
            for (String fname : funcsJson.keySet()) {
                JsonObject fobj = funcsJson.getAsJsonObject(fname);
                List<String> params = new Gson().fromJson(fobj.get("params"), List.class);
                // Re-parse function expression
                CharStream input = CharStreams.fromString(fobj.get("expr").getAsString());
                ExprLexer lexer = new ExprLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                ExprParser parser = new ExprParser(tokens);
                ExprParser.ExprContext exprCtx = parser.expr();
                functions.put(fname, new UserFunction(params, exprCtx));
            }
        } catch (Exception e) {
            System.err.println("Error loading session: " + e.getMessage());
        }
    }
}
