package compiler;// Generated from C:/Users/adris/IdeaProjects/PoleParser/src\XSEScript.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XSEScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, WHITESPACE=7, NEWLINE=8, 
		ASSIG=9, EQ=10, NE=11, GE=12, GT=13, LE=14, LT=15, IF=16, THEN=17, ELSE=18, 
		END=19, TRUE=20, FALSE=21, CHECKGENDER=22, CHOICE=23, STRING=24, FLAG=25, 
		VAR=26, HEX_LIT=27, COMMENT=28, DEC_LIT=29, COMMAND=30, ID=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "WHITESPACE", "NEWLINE", 
			"ASSIG", "EQ", "NE", "GE", "GT", "LE", "LT", "QUOTE", "IF", "THEN", "ELSE", 
			"END", "TRUE", "FALSE", "CHECKGENDER", "CHOICE", "STRING", "FLAG", "VAR", 
			"HEX_LIT", "COMMENT", "DEC_LIT", "COMMAND", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\n'", "'['", "','", "']'", "'('", "')'", null, null, "'='", "'=='", 
			"'!='", "'>='", "'>'", "'<='", "'<'", "'if'", "'then'", "'else'", "'end'", 
			"'true'", "'false'", "'checkgender'", "'choice'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "WHITESPACE", "NEWLINE", "ASSIG", 
			"EQ", "NE", "GE", "GT", "LE", "LT", "IF", "THEN", "ELSE", "END", "TRUE", 
			"FALSE", "CHECKGENDER", "CHOICE", "STRING", "FLAG", "VAR", "HEX_LIT", 
			"COMMENT", "DEC_LIT", "COMMAND", "ID"
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


	public XSEScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "compiler/XSEScript.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00dc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\5\bQ\n\b\3\b\3"+
		"\b\3\t\6\tV\n\t\r\t\16\tW\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\7\32\u009f\n\32\f\32\16\32\u00a2\13\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\6\33\u00ab\n\33\r\33\16\33\u00ac\3\34\3\34\3\34\3\34"+
		"\3\34\6\34\u00b4\n\34\r\34\16\34\u00b5\3\35\3\35\3\35\3\35\6\35\u00bc"+
		"\n\35\r\35\16\35\u00bd\3\36\3\36\3\36\3\36\7\36\u00c4\n\36\f\36\16\36"+
		"\u00c7\13\36\3\36\6\36\u00ca\n\36\r\36\16\36\u00cb\3\37\6\37\u00cf\n\37"+
		"\r\37\16\37\u00d0\3 \6 \u00d4\n \r \16 \u00d5\3!\6!\u00d9\n!\r!\16!\u00da"+
		"\4\u00a0\u00c5\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\2#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65"+
		"\33\67\349\35;\36=\37? A!\3\2\7\5\3\13\13\17\17\"\"\4\2\62;CH\3\2\62;"+
		"\3\2c|\4\2\62;C\\\2\u00e4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5E\3"+
		"\2\2\2\7G\3\2\2\2\tI\3\2\2\2\13K\3\2\2\2\rM\3\2\2\2\17P\3\2\2\2\21U\3"+
		"\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27^\3\2\2\2\31a\3\2\2\2\33d\3\2\2\2\35"+
		"f\3\2\2\2\37i\3\2\2\2!k\3\2\2\2#m\3\2\2\2%p\3\2\2\2\'u\3\2\2\2)z\3\2\2"+
		"\2+~\3\2\2\2-\u0083\3\2\2\2/\u0089\3\2\2\2\61\u0095\3\2\2\2\63\u009c\3"+
		"\2\2\2\65\u00a5\3\2\2\2\67\u00ae\3\2\2\29\u00b7\3\2\2\2;\u00bf\3\2\2\2"+
		"=\u00ce\3\2\2\2?\u00d3\3\2\2\2A\u00d8\3\2\2\2CD\7\f\2\2D\4\3\2\2\2EF\7"+
		"]\2\2F\6\3\2\2\2GH\7.\2\2H\b\3\2\2\2IJ\7_\2\2J\n\3\2\2\2KL\7*\2\2L\f\3"+
		"\2\2\2MN\7+\2\2N\16\3\2\2\2OQ\t\2\2\2PO\3\2\2\2QR\3\2\2\2RS\b\b\2\2S\20"+
		"\3\2\2\2TV\7\f\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\22\3\2\2\2"+
		"YZ\7?\2\2Z\24\3\2\2\2[\\\7?\2\2\\]\7?\2\2]\26\3\2\2\2^_\7#\2\2_`\7?\2"+
		"\2`\30\3\2\2\2ab\7@\2\2bc\7?\2\2c\32\3\2\2\2de\7@\2\2e\34\3\2\2\2fg\7"+
		">\2\2gh\7?\2\2h\36\3\2\2\2ij\7>\2\2j \3\2\2\2kl\7)\2\2l\"\3\2\2\2mn\7"+
		"k\2\2no\7h\2\2o$\3\2\2\2pq\7v\2\2qr\7j\2\2rs\7g\2\2st\7p\2\2t&\3\2\2\2"+
		"uv\7g\2\2vw\7n\2\2wx\7u\2\2xy\7g\2\2y(\3\2\2\2z{\7g\2\2{|\7p\2\2|}\7f"+
		"\2\2}*\3\2\2\2~\177\7v\2\2\177\u0080\7t\2\2\u0080\u0081\7w\2\2\u0081\u0082"+
		"\7g\2\2\u0082,\3\2\2\2\u0083\u0084\7h\2\2\u0084\u0085\7c\2\2\u0085\u0086"+
		"\7n\2\2\u0086\u0087\7u\2\2\u0087\u0088\7g\2\2\u0088.\3\2\2\2\u0089\u008a"+
		"\7e\2\2\u008a\u008b\7j\2\2\u008b\u008c\7g\2\2\u008c\u008d\7e\2\2\u008d"+
		"\u008e\7m\2\2\u008e\u008f\7i\2\2\u008f\u0090\7g\2\2\u0090\u0091\7p\2\2"+
		"\u0091\u0092\7f\2\2\u0092\u0093\7g\2\2\u0093\u0094\7t\2\2\u0094\60\3\2"+
		"\2\2\u0095\u0096\7e\2\2\u0096\u0097\7j\2\2\u0097\u0098\7q\2\2\u0098\u0099"+
		"\7k\2\2\u0099\u009a\7e\2\2\u009a\u009b\7g\2\2\u009b\62\3\2\2\2\u009c\u00a0"+
		"\5!\21\2\u009d\u009f\13\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2"+
		"\u00a0\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0"+
		"\3\2\2\2\u00a3\u00a4\5!\21\2\u00a4\64\3\2\2\2\u00a5\u00a6\7h\2\2\u00a6"+
		"\u00a7\7\62\2\2\u00a7\u00a8\7z\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00ab\t\3"+
		"\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\66\3\2\2\2\u00ae\u00af\7x\2\2\u00af\u00b0\7\62\2"+
		"\2\u00b0\u00b1\7z\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b4\t\3\2\2\u00b3\u00b2"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"8\3\2\2\2\u00b7\u00b8\7\62\2\2\u00b8\u00b9\7z\2\2\u00b9\u00bb\3\2\2\2"+
		"\u00ba\u00bc\t\3\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be:\3\2\2\2\u00bf\u00c0\7\61\2\2\u00c0"+
		"\u00c1\7\61\2\2\u00c1\u00c5\3\2\2\2\u00c2\u00c4\13\2\2\2\u00c3\u00c2\3"+
		"\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00ca\7\f\2\2\u00c9\u00c8\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"<\3\2\2\2\u00cd\u00cf\t\4\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2"+
		"\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1>\3\2\2\2\u00d2\u00d4\t"+
		"\5\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6@\3\2\2\2\u00d7\u00d9\t\6\2\2\u00d8\u00d7\3\2\2\2"+
		"\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00dbB\3"+
		"\2\2\2\16\2PW\u00a0\u00ac\u00b5\u00bd\u00c5\u00cb\u00d0\u00d5\u00da\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}