// Generated from src/main/antlr4/Expr.g4 by ANTLR 4.13.2

  package com.example.calc;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		NUMBER=10, ID=11, STRING=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"NUMBER", "ID", "STRING", "WS", "DIGIT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "','", "'+'", "'-'", "'*'", "'/'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "NUMBER", 
			"ID", "STRING", "WS"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\r`\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0004\t1\b\t\u000b\t\f\t2\u0001"+
		"\t\u0001\t\u0004\t7\b\t\u000b\t\f\t8\u0003\t;\b\t\u0001\t\u0001\t\u0003"+
		"\t?\b\t\u0001\t\u0004\tB\b\t\u000b\t\f\tC\u0003\tF\b\t\u0001\n\u0001\n"+
		"\u0005\nJ\b\n\n\n\f\nM\t\n\u0001\u000b\u0001\u000b\u0005\u000bQ\b\u000b"+
		"\n\u000b\f\u000bT\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0004\fY\b\f"+
		"\u000b\f\f\fZ\u0001\f\u0001\f\u0001\r\u0001\r\u0000\u0000\u000e\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u0000\u0001"+
		"\u0000\u0007\u0002\u0000EEee\u0002\u0000++--\u0003\u0000AZ__az\u0004\u0000"+
		"09AZ__az\u0003\u0000\n\n\r\r\"\"\u0003\u0000\t\n\r\r  \u0001\u000009g"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003\u001f"+
		"\u0001\u0000\u0000\u0000\u0005!\u0001\u0000\u0000\u0000\u0007#\u0001\u0000"+
		"\u0000\u0000\t%\u0001\u0000\u0000\u0000\u000b\'\u0001\u0000\u0000\u0000"+
		"\r)\u0001\u0000\u0000\u0000\u000f+\u0001\u0000\u0000\u0000\u0011-\u0001"+
		"\u0000\u0000\u0000\u00130\u0001\u0000\u0000\u0000\u0015G\u0001\u0000\u0000"+
		"\u0000\u0017N\u0001\u0000\u0000\u0000\u0019X\u0001\u0000\u0000\u0000\u001b"+
		"^\u0001\u0000\u0000\u0000\u001d\u001e\u0005=\u0000\u0000\u001e\u0002\u0001"+
		"\u0000\u0000\u0000\u001f \u0005(\u0000\u0000 \u0004\u0001\u0000\u0000"+
		"\u0000!\"\u0005)\u0000\u0000\"\u0006\u0001\u0000\u0000\u0000#$\u0005,"+
		"\u0000\u0000$\b\u0001\u0000\u0000\u0000%&\u0005+\u0000\u0000&\n\u0001"+
		"\u0000\u0000\u0000\'(\u0005-\u0000\u0000(\f\u0001\u0000\u0000\u0000)*"+
		"\u0005*\u0000\u0000*\u000e\u0001\u0000\u0000\u0000+,\u0005/\u0000\u0000"+
		",\u0010\u0001\u0000\u0000\u0000-.\u0005^\u0000\u0000.\u0012\u0001\u0000"+
		"\u0000\u0000/1\u0003\u001b\r\u00000/\u0001\u0000\u0000\u000012\u0001\u0000"+
		"\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u00003:\u0001"+
		"\u0000\u0000\u000046\u0005.\u0000\u000057\u0003\u001b\r\u000065\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u0000"+
		"89\u0001\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:4\u0001\u0000\u0000"+
		"\u0000:;\u0001\u0000\u0000\u0000;E\u0001\u0000\u0000\u0000<>\u0007\u0000"+
		"\u0000\u0000=?\u0007\u0001\u0000\u0000>=\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@B\u0003\u001b\r\u0000A@\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000E<\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000F\u0014\u0001\u0000\u0000\u0000GK\u0007"+
		"\u0002\u0000\u0000HJ\u0007\u0003\u0000\u0000IH\u0001\u0000\u0000\u0000"+
		"JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000L\u0016\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NR\u0005"+
		"\"\u0000\u0000OQ\b\u0004\u0000\u0000PO\u0001\u0000\u0000\u0000QT\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"SU\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UV\u0005\"\u0000\u0000"+
		"V\u0018\u0001\u0000\u0000\u0000WY\u0007\u0005\u0000\u0000XW\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0006\f\u0000\u0000]"+
		"\u001a\u0001\u0000\u0000\u0000^_\u0007\u0006\u0000\u0000_\u001c\u0001"+
		"\u0000\u0000\u0000\n\u000028:>CEKRZ\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}