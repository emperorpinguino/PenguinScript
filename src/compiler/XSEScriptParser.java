package compiler;// Generated from C:/Users/adris/IdeaProjects/PoleParser/src\XSEScript.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XSEScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, WHITESPACE=7, NEWLINE=8, 
		ASSIG=9, EQ=10, NE=11, GE=12, GT=13, LE=14, LT=15, IF=16, THEN=17, ELSE=18, 
		END=19, TRUE=20, FALSE=21, CHECKGENDER=22, CHOICE=23, STRING=24, FLAG=25, 
		VAR=26, HEX_LIT=27, COMMENT=28, DEC_LIT=29, COMMAND=30, ID=31;
	public static final int
		RULE_program = 0, RULE_instruction = 1, RULE_v_assig = 2, RULE_value = 3, 
		RULE_f_assig = 4, RULE_bool = 5, RULE_instr = 6, RULE_args = 7, RULE_list = 8, 
		RULE_tuple = 9, RULE_elem = 10, RULE_cond = 11, RULE_b_expr = 12, RULE_choice = 13, 
		RULE_op = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instruction", "v_assig", "value", "f_assig", "bool", "instr", 
			"args", "list", "tuple", "elem", "cond", "b_expr", "choice", "op"
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

	@Override
	public String getGrammarFileName() { return "compiler/XSEScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XSEScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				instruction();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FLAG) | (1L << VAR) | (1L << COMMENT) | (1L << COMMAND))) != 0) );
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

	public static class InstructionContext extends ParserRuleContext {
		public V_assigContext v_assig() {
			return getRuleContext(V_assigContext.class,0);
		}
		public F_assigContext f_assig() {
			return getRuleContext(F_assigContext.class,0);
		}
		public InstrContext instr() {
			return getRuleContext(InstrContext.class,0);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(XSEScriptParser.COMMENT, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		int _la;
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case FLAG:
			case VAR:
			case COMMAND:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(39);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(35);
					v_assig();
					}
					break;
				case FLAG:
					{
					setState(36);
					f_assig();
					}
					break;
				case COMMAND:
					{
					setState(37);
					instr();
					}
					break;
				case IF:
					{
					setState(38);
					cond();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(41);
					match(T__0);
					}
					}
					setState(44); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__0 );
				}
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(COMMENT);
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

	public static class V_assigContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(XSEScriptParser.VAR, 0); }
		public TerminalNode ASSIG() { return getToken(XSEScriptParser.ASSIG, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public V_assigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_v_assig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterV_assig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitV_assig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitV_assig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final V_assigContext v_assig() throws RecognitionException {
		V_assigContext _localctx = new V_assigContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_v_assig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(VAR);
			setState(50);
			match(ASSIG);
			setState(51);
			value();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode DEC_LIT() { return getToken(XSEScriptParser.DEC_LIT, 0); }
		public TerminalNode HEX_LIT() { return getToken(XSEScriptParser.HEX_LIT, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==HEX_LIT || _la==DEC_LIT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class F_assigContext extends ParserRuleContext {
		public TerminalNode FLAG() { return getToken(XSEScriptParser.FLAG, 0); }
		public TerminalNode ASSIG() { return getToken(XSEScriptParser.ASSIG, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public F_assigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_assig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterF_assig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitF_assig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitF_assig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final F_assigContext f_assig() throws RecognitionException {
		F_assigContext _localctx = new F_assigContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_f_assig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(FLAG);
			setState(56);
			match(ASSIG);
			setState(57);
			bool();
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

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(XSEScriptParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(XSEScriptParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class InstrContext extends ParserRuleContext {
		public TerminalNode COMMAND() { return getToken(XSEScriptParser.COMMAND, 0); }
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitInstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(COMMAND);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << STRING) | (1L << FLAG) | (1L << HEX_LIT) | (1L << DEC_LIT) | (1L << ID))) != 0)) {
				{
				{
				setState(62);
				args();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ArgsContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XSEScriptParser.STRING, 0); }
		public TerminalNode ID() { return getToken(XSEScriptParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public TerminalNode FLAG() { return getToken(XSEScriptParser.FLAG, 0); }
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_args);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(STRING);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(ID);
				}
				break;
			case HEX_LIT:
			case DEC_LIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				value();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				list();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				tuple();
				}
				break;
			case FLAG:
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
				match(FLAG);
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

	public static class ListContext extends ParserRuleContext {
		public List<ElemContext> elem() {
			return getRuleContexts(ElemContext.class);
		}
		public ElemContext elem(int i) {
			return getRuleContext(ElemContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__1);
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				}
				break;
			case HEX_LIT:
			case DEC_LIT:
			case ID:
				{
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(78);
						elem();
						setState(79);
						match(T__2);
						}
						} 
					}
					setState(85);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(86);
				elem();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(89);
			match(T__3);
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

	public static class TupleContext extends ParserRuleContext {
		public List<ElemContext> elem() {
			return getRuleContexts(ElemContext.class);
		}
		public ElemContext elem(int i) {
			return getRuleContext(ElemContext.class,i);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__4);
			setState(92);
			elem();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(93);
				match(T__2);
				setState(94);
				elem();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(T__5);
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

	public static class ElemContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XSEScriptParser.ID, 0); }
		public TerminalNode DEC_LIT() { return getToken(XSEScriptParser.DEC_LIT, 0); }
		public TerminalNode HEX_LIT() { return getToken(XSEScriptParser.HEX_LIT, 0); }
		public ElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterElem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitElem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElemContext elem() throws RecognitionException {
		ElemContext _localctx = new ElemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HEX_LIT) | (1L << DEC_LIT) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class CondContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(XSEScriptParser.IF, 0); }
		public B_exprContext b_expr() {
			return getRuleContext(B_exprContext.class,0);
		}
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public TerminalNode END() { return getToken(XSEScriptParser.END, 0); }
		public TerminalNode ELSE() { return getToken(XSEScriptParser.ELSE, 0); }
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(IF);
			setState(105);
			b_expr();
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				match(T__0);
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(111);
			program();
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case END:
				{
				}
				break;
			case ELSE:
				{
				setState(113);
				match(ELSE);
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(114);
					match(T__0);
					}
					}
					setState(117); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__0 );
				setState(119);
				program();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(122);
			match(END);
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

	public static class B_exprContext extends ParserRuleContext {
		public TerminalNode CHECKGENDER() { return getToken(XSEScriptParser.CHECKGENDER, 0); }
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public TerminalNode VAR() { return getToken(XSEScriptParser.VAR, 0); }
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode FLAG() { return getToken(XSEScriptParser.FLAG, 0); }
		public B_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_b_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterB_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitB_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitB_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final B_exprContext b_expr() throws RecognitionException {
		B_exprContext _localctx = new B_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_b_expr);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHECKGENDER:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(CHECKGENDER);
				}
				break;
			case CHOICE:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				choice();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(126);
				match(VAR);
				setState(127);
				op();
				setState(128);
				value();
				}
				}
				break;
			case FLAG:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(FLAG);
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

	public static class ChoiceContext extends ParserRuleContext {
		public TerminalNode CHOICE() { return getToken(XSEScriptParser.CHOICE, 0); }
		public TerminalNode STRING() { return getToken(XSEScriptParser.STRING, 0); }
		public ChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceContext choice() throws RecognitionException {
		ChoiceContext _localctx = new ChoiceContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_choice);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(CHOICE);
			setState(134);
			match(STRING);
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

	public static class OpContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(XSEScriptParser.LT, 0); }
		public TerminalNode EQ() { return getToken(XSEScriptParser.EQ, 0); }
		public TerminalNode GT() { return getToken(XSEScriptParser.GT, 0); }
		public TerminalNode LE() { return getToken(XSEScriptParser.LE, 0); }
		public TerminalNode GE() { return getToken(XSEScriptParser.GE, 0); }
		public TerminalNode NE() { return getToken(XSEScriptParser.NE, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XSEScriptListener) ((XSEScriptListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XSEScriptVisitor ) return ((XSEScriptVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NE) | (1L << GE) | (1L << GT) | (1L << LE) | (1L << LT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u008d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\6\2\"\n\2\r\2\16"+
		"\2#\3\3\3\3\3\3\3\3\5\3*\n\3\3\3\6\3-\n\3\r\3\16\3.\3\3\5\3\62\n\3\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\7\bB\n\b\f\b\16\b"+
		"E\13\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tM\n\t\3\n\3\n\3\n\3\n\3\n\7\nT\n\n\f"+
		"\n\16\nW\13\n\3\n\5\nZ\n\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13b\n\13\f\13"+
		"\16\13e\13\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\6\rn\n\r\r\r\16\ro\3\r\3\r"+
		"\3\r\3\r\6\rv\n\r\r\r\16\rw\3\r\5\r{\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u0086\n\16\3\17\3\17\3\17\3\20\3\20\3\20\2\2\21\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36\2\6\4\2\35\35\37\37\3\2\26\27\5\2"+
		"\35\35\37\37!!\3\2\f\21\2\u0092\2!\3\2\2\2\4\61\3\2\2\2\6\63\3\2\2\2\b"+
		"\67\3\2\2\2\n9\3\2\2\2\f=\3\2\2\2\16?\3\2\2\2\20L\3\2\2\2\22N\3\2\2\2"+
		"\24]\3\2\2\2\26h\3\2\2\2\30j\3\2\2\2\32\u0085\3\2\2\2\34\u0087\3\2\2\2"+
		"\36\u008a\3\2\2\2 \"\5\4\3\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2"+
		"$\3\3\2\2\2%*\5\6\4\2&*\5\n\6\2\'*\5\16\b\2(*\5\30\r\2)%\3\2\2\2)&\3\2"+
		"\2\2)\'\3\2\2\2)(\3\2\2\2*,\3\2\2\2+-\7\3\2\2,+\3\2\2\2-.\3\2\2\2.,\3"+
		"\2\2\2./\3\2\2\2/\62\3\2\2\2\60\62\7\36\2\2\61)\3\2\2\2\61\60\3\2\2\2"+
		"\62\5\3\2\2\2\63\64\7\34\2\2\64\65\7\13\2\2\65\66\5\b\5\2\66\7\3\2\2\2"+
		"\678\t\2\2\28\t\3\2\2\29:\7\33\2\2:;\7\13\2\2;<\5\f\7\2<\13\3\2\2\2=>"+
		"\t\3\2\2>\r\3\2\2\2?C\7 \2\2@B\5\20\t\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2"+
		"CD\3\2\2\2D\17\3\2\2\2EC\3\2\2\2FM\7\32\2\2GM\7!\2\2HM\5\b\5\2IM\5\22"+
		"\n\2JM\5\24\13\2KM\7\33\2\2LF\3\2\2\2LG\3\2\2\2LH\3\2\2\2LI\3\2\2\2LJ"+
		"\3\2\2\2LK\3\2\2\2M\21\3\2\2\2NY\7\4\2\2OZ\3\2\2\2PQ\5\26\f\2QR\7\5\2"+
		"\2RT\3\2\2\2SP\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2"+
		"\2XZ\5\26\f\2YO\3\2\2\2YU\3\2\2\2Z[\3\2\2\2[\\\7\6\2\2\\\23\3\2\2\2]^"+
		"\7\7\2\2^c\5\26\f\2_`\7\5\2\2`b\5\26\f\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2"+
		"cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7\b\2\2g\25\3\2\2\2hi\t\4\2\2i\27\3\2"+
		"\2\2jk\7\22\2\2km\5\32\16\2ln\7\3\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op"+
		"\3\2\2\2pq\3\2\2\2qz\5\2\2\2r{\3\2\2\2su\7\24\2\2tv\7\3\2\2ut\3\2\2\2"+
		"vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2y{\5\2\2\2zr\3\2\2\2zs\3\2\2\2"+
		"{|\3\2\2\2|}\7\25\2\2}\31\3\2\2\2~\u0086\7\30\2\2\177\u0086\5\34\17\2"+
		"\u0080\u0081\7\34\2\2\u0081\u0082\5\36\20\2\u0082\u0083\5\b\5\2\u0083"+
		"\u0086\3\2\2\2\u0084\u0086\7\33\2\2\u0085~\3\2\2\2\u0085\177\3\2\2\2\u0085"+
		"\u0080\3\2\2\2\u0085\u0084\3\2\2\2\u0086\33\3\2\2\2\u0087\u0088\7\31\2"+
		"\2\u0088\u0089\7\32\2\2\u0089\35\3\2\2\2\u008a\u008b\t\5\2\2\u008b\37"+
		"\3\2\2\2\17#).\61CLUYcowz\u0085";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}