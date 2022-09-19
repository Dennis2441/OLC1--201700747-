package analizadores;
import java_cup.runtime.Symbol; 
import analizadores.Ventana;


public class Lexico implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;
 
    public String consola  = "";
public static Lista lista1= new Lista();
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Lexico (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Lexico (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Lexico () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
 
    yyline = 1; 
    yychar = 1; 
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NOT_ACCEPT,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NOT_ACCEPT,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NOT_ACCEPT,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NOT_ACCEPT,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NOT_ACCEPT,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NOT_ACCEPT,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NOT_ACCEPT,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NOT_ACCEPT,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NOT_ACCEPT,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NOT_ACCEPT,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NOT_ACCEPT,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NOT_ACCEPT,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NOT_ACCEPT,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NOT_ACCEPT,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NOT_ACCEPT,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NOT_ACCEPT,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NOT_ACCEPT,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NOT_ACCEPT,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NOT_ACCEPT,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NOT_ACCEPT,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NO_ANCHOR,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR,
		/* 133 */ YY_NO_ANCHOR,
		/* 134 */ YY_NO_ANCHOR,
		/* 135 */ YY_NO_ANCHOR,
		/* 136 */ YY_NO_ANCHOR,
		/* 137 */ YY_NO_ANCHOR,
		/* 138 */ YY_NO_ANCHOR,
		/* 139 */ YY_NO_ANCHOR,
		/* 140 */ YY_NO_ANCHOR,
		/* 141 */ YY_NO_ANCHOR,
		/* 142 */ YY_NO_ANCHOR,
		/* 143 */ YY_NO_ANCHOR,
		/* 144 */ YY_NO_ANCHOR,
		/* 145 */ YY_NO_ANCHOR,
		/* 146 */ YY_NO_ANCHOR,
		/* 147 */ YY_NO_ANCHOR,
		/* 148 */ YY_NO_ANCHOR,
		/* 149 */ YY_NO_ANCHOR,
		/* 150 */ YY_NO_ANCHOR,
		/* 151 */ YY_NO_ANCHOR,
		/* 152 */ YY_NO_ANCHOR,
		/* 153 */ YY_NO_ANCHOR,
		/* 154 */ YY_NOT_ACCEPT,
		/* 155 */ YY_NO_ANCHOR,
		/* 156 */ YY_NO_ANCHOR,
		/* 157 */ YY_NO_ANCHOR,
		/* 158 */ YY_NO_ANCHOR,
		/* 159 */ YY_NO_ANCHOR,
		/* 160 */ YY_NO_ANCHOR,
		/* 161 */ YY_NO_ANCHOR,
		/* 162 */ YY_NO_ANCHOR,
		/* 163 */ YY_NO_ANCHOR,
		/* 164 */ YY_NO_ANCHOR,
		/* 165 */ YY_NO_ANCHOR,
		/* 166 */ YY_NO_ANCHOR,
		/* 167 */ YY_NO_ANCHOR,
		/* 168 */ YY_NO_ANCHOR,
		/* 169 */ YY_NO_ANCHOR,
		/* 170 */ YY_NO_ANCHOR,
		/* 171 */ YY_NO_ANCHOR,
		/* 172 */ YY_NO_ANCHOR,
		/* 173 */ YY_NO_ANCHOR,
		/* 174 */ YY_NO_ANCHOR,
		/* 175 */ YY_NO_ANCHOR,
		/* 176 */ YY_NO_ANCHOR,
		/* 177 */ YY_NO_ANCHOR,
		/* 178 */ YY_NO_ANCHOR,
		/* 179 */ YY_NO_ANCHOR,
		/* 180 */ YY_NO_ANCHOR,
		/* 181 */ YY_NO_ANCHOR,
		/* 182 */ YY_NO_ANCHOR,
		/* 183 */ YY_NO_ANCHOR,
		/* 184 */ YY_NO_ANCHOR,
		/* 185 */ YY_NO_ANCHOR,
		/* 186 */ YY_NO_ANCHOR,
		/* 187 */ YY_NO_ANCHOR,
		/* 188 */ YY_NO_ANCHOR,
		/* 189 */ YY_NO_ANCHOR,
		/* 190 */ YY_NO_ANCHOR,
		/* 191 */ YY_NO_ANCHOR,
		/* 192 */ YY_NO_ANCHOR,
		/* 193 */ YY_NO_ANCHOR,
		/* 194 */ YY_NO_ANCHOR,
		/* 195 */ YY_NO_ANCHOR,
		/* 196 */ YY_NO_ANCHOR,
		/* 197 */ YY_NO_ANCHOR,
		/* 198 */ YY_NO_ANCHOR,
		/* 199 */ YY_NO_ANCHOR,
		/* 200 */ YY_NO_ANCHOR,
		/* 201 */ YY_NO_ANCHOR,
		/* 202 */ YY_NO_ANCHOR,
		/* 203 */ YY_NO_ANCHOR,
		/* 204 */ YY_NO_ANCHOR,
		/* 205 */ YY_NO_ANCHOR,
		/* 206 */ YY_NO_ANCHOR,
		/* 207 */ YY_NO_ANCHOR,
		/* 208 */ YY_NO_ANCHOR,
		/* 209 */ YY_NO_ANCHOR,
		/* 210 */ YY_NO_ANCHOR,
		/* 211 */ YY_NO_ANCHOR,
		/* 212 */ YY_NO_ANCHOR,
		/* 213 */ YY_NO_ANCHOR,
		/* 214 */ YY_NO_ANCHOR,
		/* 215 */ YY_NO_ANCHOR,
		/* 216 */ YY_NO_ANCHOR,
		/* 217 */ YY_NO_ANCHOR,
		/* 218 */ YY_NO_ANCHOR,
		/* 219 */ YY_NO_ANCHOR,
		/* 220 */ YY_NO_ANCHOR,
		/* 221 */ YY_NO_ANCHOR,
		/* 222 */ YY_NO_ANCHOR,
		/* 223 */ YY_NO_ANCHOR,
		/* 224 */ YY_NO_ANCHOR,
		/* 225 */ YY_NO_ANCHOR,
		/* 226 */ YY_NO_ANCHOR,
		/* 227 */ YY_NO_ANCHOR,
		/* 228 */ YY_NO_ANCHOR,
		/* 229 */ YY_NO_ANCHOR,
		/* 230 */ YY_NO_ANCHOR,
		/* 231 */ YY_NO_ANCHOR,
		/* 232 */ YY_NO_ANCHOR,
		/* 233 */ YY_NO_ANCHOR,
		/* 234 */ YY_NO_ANCHOR,
		/* 235 */ YY_NO_ANCHOR,
		/* 236 */ YY_NO_ANCHOR,
		/* 237 */ YY_NO_ANCHOR,
		/* 238 */ YY_NO_ANCHOR,
		/* 239 */ YY_NO_ANCHOR,
		/* 240 */ YY_NO_ANCHOR,
		/* 241 */ YY_NO_ANCHOR,
		/* 242 */ YY_NO_ANCHOR,
		/* 243 */ YY_NO_ANCHOR,
		/* 244 */ YY_NO_ANCHOR,
		/* 245 */ YY_NO_ANCHOR,
		/* 246 */ YY_NO_ANCHOR,
		/* 247 */ YY_NO_ANCHOR,
		/* 248 */ YY_NO_ANCHOR,
		/* 249 */ YY_NO_ANCHOR,
		/* 250 */ YY_NO_ANCHOR,
		/* 251 */ YY_NO_ANCHOR,
		/* 252 */ YY_NO_ANCHOR,
		/* 253 */ YY_NO_ANCHOR,
		/* 254 */ YY_NO_ANCHOR,
		/* 255 */ YY_NO_ANCHOR,
		/* 256 */ YY_NO_ANCHOR,
		/* 257 */ YY_NO_ANCHOR,
		/* 258 */ YY_NO_ANCHOR,
		/* 259 */ YY_NO_ANCHOR,
		/* 260 */ YY_NO_ANCHOR,
		/* 261 */ YY_NO_ANCHOR,
		/* 262 */ YY_NO_ANCHOR,
		/* 263 */ YY_NO_ANCHOR,
		/* 264 */ YY_NO_ANCHOR,
		/* 265 */ YY_NO_ANCHOR,
		/* 266 */ YY_NO_ANCHOR,
		/* 267 */ YY_NO_ANCHOR,
		/* 268 */ YY_NO_ANCHOR,
		/* 269 */ YY_NO_ANCHOR,
		/* 270 */ YY_NO_ANCHOR,
		/* 271 */ YY_NO_ANCHOR,
		/* 272 */ YY_NO_ANCHOR,
		/* 273 */ YY_NO_ANCHOR,
		/* 274 */ YY_NO_ANCHOR,
		/* 275 */ YY_NO_ANCHOR,
		/* 276 */ YY_NO_ANCHOR,
		/* 277 */ YY_NO_ANCHOR,
		/* 278 */ YY_NO_ANCHOR,
		/* 279 */ YY_NO_ANCHOR,
		/* 280 */ YY_NO_ANCHOR,
		/* 281 */ YY_NO_ANCHOR,
		/* 282 */ YY_NO_ANCHOR,
		/* 283 */ YY_NO_ANCHOR,
		/* 284 */ YY_NO_ANCHOR,
		/* 285 */ YY_NO_ANCHOR,
		/* 286 */ YY_NO_ANCHOR,
		/* 287 */ YY_NO_ANCHOR,
		/* 288 */ YY_NO_ANCHOR,
		/* 289 */ YY_NO_ANCHOR,
		/* 290 */ YY_NO_ANCHOR,
		/* 291 */ YY_NO_ANCHOR,
		/* 292 */ YY_NO_ANCHOR,
		/* 293 */ YY_NO_ANCHOR,
		/* 294 */ YY_NO_ANCHOR,
		/* 295 */ YY_NO_ANCHOR,
		/* 296 */ YY_NO_ANCHOR,
		/* 297 */ YY_NO_ANCHOR,
		/* 298 */ YY_NO_ANCHOR,
		/* 299 */ YY_NO_ANCHOR,
		/* 300 */ YY_NO_ANCHOR,
		/* 301 */ YY_NO_ANCHOR,
		/* 302 */ YY_NO_ANCHOR,
		/* 303 */ YY_NO_ANCHOR,
		/* 304 */ YY_NO_ANCHOR,
		/* 305 */ YY_NO_ANCHOR,
		/* 306 */ YY_NO_ANCHOR,
		/* 307 */ YY_NO_ANCHOR,
		/* 308 */ YY_NO_ANCHOR,
		/* 309 */ YY_NO_ANCHOR,
		/* 310 */ YY_NO_ANCHOR,
		/* 311 */ YY_NO_ANCHOR,
		/* 312 */ YY_NO_ANCHOR,
		/* 313 */ YY_NO_ANCHOR,
		/* 314 */ YY_NO_ANCHOR,
		/* 315 */ YY_NO_ANCHOR,
		/* 316 */ YY_NO_ANCHOR,
		/* 317 */ YY_NO_ANCHOR,
		/* 318 */ YY_NO_ANCHOR,
		/* 319 */ YY_NO_ANCHOR,
		/* 320 */ YY_NO_ANCHOR,
		/* 321 */ YY_NO_ANCHOR,
		/* 322 */ YY_NO_ANCHOR,
		/* 323 */ YY_NO_ANCHOR,
		/* 324 */ YY_NO_ANCHOR,
		/* 325 */ YY_NO_ANCHOR,
		/* 326 */ YY_NO_ANCHOR,
		/* 327 */ YY_NO_ANCHOR,
		/* 328 */ YY_NO_ANCHOR,
		/* 329 */ YY_NO_ANCHOR,
		/* 330 */ YY_NO_ANCHOR,
		/* 331 */ YY_NO_ANCHOR,
		/* 332 */ YY_NO_ANCHOR,
		/* 333 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"49:9,50,44,49:2,45,49:18,14,40,51,39,49:2,41,54,26,27,34,33,30,31,47,35,46:" +
"10,49,25,42,19,32,36,49,3,43,20,16,1,17,12,22,11,24,53,4,7,13,9,21,23,6,15," +
"18,5,2,53:2,8,53,28,52,29,49,10,49,3,43,20,16,1,17,12,22,11,24,53,4,7,13,9," +
"21,23,6,15,18,5,2,53:2,8,53,49,48,49:66,38,49:2,37,49:31,37,49:65309,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,334,
"0,1,2,3,4,1:7,5,1:3,6,1,7,1:4,8,9,1,10,1:3,9:2,11,12,1,13,9:2,1,9,1,9:3,14," +
"9:15,15,9:6,1,9:2,1,9:3,1,9:6,16,17,18,1,19,20,21,22,23,24,19,12,25,26,19,2" +
"7,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,5" +
"2,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,7" +
"7,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101" +
",102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,12" +
"0,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,1" +
"39,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157," +
"158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176" +
",177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,19" +
"5,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,2" +
"14,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232," +
"233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251" +
",252,253,254,255,256,9,257,258,259,260,261,262,263")[0];

	private int yy_nxt[][] = unpackFromString(264,55,
"1,2,317,326:3,328,153,326,237,326,3,326,264,4,82,329,155,326,5,198,199,238," +
"326:2,6,7,8,9,10,11,12,13,14,15,16,17,18,84,19,20,88,21,200,22,83,23,84:3,8" +
"3,91,84,326,94,-1:56,326,265,326:10,266,-1,267,326:3,-1,326:4,268,-1:18,326" +
",-1:2,326,-1:6,326,-1:2,326:6,272,326:4,202,90,-1,326:4,-1,326:5,-1:18,326," +
"-1:2,326,-1:6,326,-1:2,81,-1:12,83,-1:5,86,-1:24,83,-1:4,83,-1:36,25,-1:56," +
"89,26,-1:57,27,-1:62,23,92,-1:8,326:13,-1,326:4,-1,326:5,-1:18,326,-1:2,326" +
",-1:6,326,-1:2,26:43,-1:2,26:9,-1,326:9,168,326:3,-1,326:4,-1,326:5,-1:18,3" +
"26,-1:2,326,-1:6,326,-1:15,33,-1:31,33,-1,33,-1:16,113,-1:45,326:9,226,326:" +
"3,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:9,230,326:3,-1,326" +
":4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:16,103,-1:40,203,326:9,24,326:2," +
"-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:15,83,-1:30,83,-1:4,83,-1:" +
"5,95:50,29,97,95:2,-1:9,105,-1:46,326:13,-1,326,30,326:2,-1,326:5,-1:18,326" +
",-1:2,326,-1:6,326,-1:42,28,-1:14,89:33,107,-1,89:19,-1,326:10,207,282,326," +
"-1,326:3,31,-1,283,326:4,-1:18,326,-1:2,326,-1:6,326,-1:2,326:12,32,-1,326:" +
"4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,99:50,-1,101,99:2,-1,326:8,36,3" +
"26:4,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,95:50,85,97,95:2,-1" +
",326:2,37,326:10,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:55,34,-1," +
"39,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:7,99,-1:6,99,-1:" +
"4,99,-1:32,99:2,-1,34,-1,326:13,40,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,3" +
"26,-1:11,109,-1:45,326:3,41,326:9,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6" +
",326,-1:14,35,-1:42,326:12,42,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326" +
",-1:36,38,-1:20,326:8,43,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,32" +
"6,-1:12,111,-1:44,326:2,44,326:10,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6" +
",326,-1:13,115,-1:43,326:5,45,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1" +
":6,326,-1:3,117,-1:53,326:8,46,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-" +
"1:6,326,-1:6,154,-1:50,326:8,47,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,326," +
"-1:6,326,-1:4,119,-1:52,326:8,48,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,326" +
",-1:6,326,-1:5,123,-1:51,225,326:9,49,326:2,-1,326:4,-1,326:5,-1:18,326,-1:" +
"2,326,-1:6,326,-1:5,67,-1:51,326:2,50,326:10,-1,326:4,-1,326:5,-1:18,326,-1" +
":2,326,-1:6,326,-1:10,125,-1:46,326:5,51,326:7,-1,326:4,-1,326:5,-1:18,326," +
"-1:2,326,-1:6,326,-1:7,70,-1:49,326:5,52,326:7,-1,326:4,-1,326:5,-1:18,326," +
"-1:2,326,-1:6,326,-1:2,326:12,53,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6," +
"326,-1:2,326:10,54,326:2,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2" +
",326:12,55,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,56," +
"326:3,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:5,57,326:7,-1,326:4,-1," +
"326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:5,58,326:7,-1,326:4,-1,326:5,-1:" +
"18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,59,326:3,-1,326:5,-1:18,326,-1:2,32" +
"6,-1:6,326,-1:2,326:5,60,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,32" +
"6,-1:2,326:5,61,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,62" +
",326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,63,326:10," +
"-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:5,64,326:7,-1,326:4," +
"-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,65,326:10,-1,326:4,-1,326:5" +
",-1:18,326,-1:2,326,-1:6,326,-1:2,326:8,66,326:4,-1,326:4,-1,326:5,-1:18,32" +
"6,-1:2,326,-1:6,326,-1:2,326:12,68,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:" +
"6,326,-1:2,69,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326" +
":8,71,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:3,72,326" +
":9,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:12,73,-1,326:4,-1" +
",326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,74,326:4,-1,326:5,-1:18,326," +
"-1:2,326,-1:6,326,-1:2,326:13,-1,75,326:3,-1,326:5,-1:18,326,-1:2,326,-1:6," +
"326,-1:2,76,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:3" +
",77,326:9,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:3,78,326:9" +
",-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,79,326:3,-1,3" +
"26:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:8,80,326:4,-1,326:4,-1,326:5,-1:1" +
"8,326,-1:2,326,-1:6,326,-1:2,239,326,271,326:5,87,326,320,326:2,-1,326:4,-1" +
",326:5,-1:18,326,-1:2,326,-1:6,326,-1:4,121,-1:52,326:2,204,326,273,326:5,9" +
"3,326:2,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:6,96,326:5,2" +
"86,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:5,98,326:7,-1,326" +
":4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:3,100,-1,326:5,-" +
"1:18,326,-1:2,326,-1:6,326,-1:2,326:10,102,326:2,-1,326:4,-1,326:5,-1:18,32" +
"6,-1:2,326,-1:6,326,-1:2,326:2,104,326:10,-1,326:4,-1,326:5,-1:18,326,-1:2," +
"326,-1:6,326,-1:2,326:4,106,326:8,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6" +
",326,-1:2,326:13,-1,108,326:3,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326" +
":13,-1,326:3,110,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,112,326:12,-1,32" +
"6:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326,114,326:2,-1,32" +
"6:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:10,116,326:2,-1,326:4,-1,326:5,-1:" +
"18,326,-1:2,326,-1:6,326,-1:2,326:5,118,326:7,-1,326:4,-1,326:5,-1:18,326,-" +
"1:2,326,-1:6,326,-1:2,326:6,296,326,173,326:4,-1,120,326,297,326,-1,220,221" +
",326:3,-1:18,326,-1:2,326,-1:6,326,-1:2,326:12,122,-1,326:4,-1,326:5,-1:18," +
"326,-1:2,326,-1:6,326,-1:2,326:2,124,326:10,-1,326:4,-1,326:5,-1:18,326,-1:" +
"2,326,-1:6,326,-1:2,326:10,126,326:2,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-" +
"1:6,326,-1:2,326:8,127,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326," +
"-1:2,326:13,-1,128,326:3,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,12" +
"9,326:10,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,130,326:12,-1,3" +
"26:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,131,326:10,-1,326:4,-1" +
",326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,132,326:10,-1,326:4,-1,326:5," +
"-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,133,326:10,-1,326:4,-1,326:5,-1:18,3" +
"26,-1:2,326,-1:6,326,-1:2,326:10,134,326:2,-1,326:4,-1,326:5,-1:18,326,-1:2" +
",326,-1:6,326,-1:2,326:2,135,326:10,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1" +
":6,326,-1:2,326:13,-1,136,326:3,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,3" +
"26:5,137,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,138,326:1" +
"2,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:10,139,326:2,-1,32" +
"6:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:5,140,326:7,-1,326:4,-1,3" +
"26:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:4,141,326:8,-1,326:4,-1,326:5,-1:" +
"18,326,-1:2,326,-1:6,326,-1:2,326:4,142,326:8,-1,326:4,-1,326:5,-1:18,326,-" +
"1:2,326,-1:6,326,-1:2,326:13,-1,326,143,326:2,-1,326:5,-1:18,326,-1:2,326,-" +
"1:6,326,-1:2,326:2,144,326:10,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326" +
",-1:2,326:8,145,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,32" +
"6:3,146,326:9,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,147," +
"326:10,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:3,1" +
"48,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,149,326:10,-1,326:4,-1,3" +
"26:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,150,326:10,-1,326:4,-1,326:5,-1" +
":18,326,-1:2,326,-1:6,326,-1:2,326:8,151,326:4,-1,326:4,-1,326:5,-1:18,326," +
"-1:2,326,-1:6,326,-1:2,326:10,152,326:2,-1,326:4,-1,326:5,-1:18,326,-1:2,32" +
"6,-1:6,326,-1:2,326:2,241,326:5,156,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2," +
"326,-1:6,326,-1:2,326:2,157,326:5,318,326:4,-1,326:4,-1,326:5,-1:18,326,-1:" +
"2,326,-1:6,326,-1:2,326:7,158,274,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,32" +
"6,-1:6,326,-1:2,326:13,-1,159,326:3,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1" +
":2,326:4,160,326:8,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:1" +
"1,161,326,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:3,162,326:" +
"9,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,163,326:3,-1" +
",164,326:4,-1:18,326,-1:2,326,-1:6,326,-1:2,326:8,165,326:4,-1,326:4,-1,326" +
":5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:4,-1,166,326:4,-1:18,326," +
"-1:2,326,-1:6,326,-1:2,167,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6" +
",326,-1:2,169,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326" +
":4,170,326:8,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,3" +
"26:3,171,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:10,172,326:2,-1,326:" +
"4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,174,326:12,-1,326:4,-1,326:5,-1" +
":18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:4,-1,175,326:4,-1:18,326,-1:2," +
"326,-1:6,326,-1:2,326:13,-1,326:3,176,-1,326:5,-1:18,326,-1:2,326,-1:6,326," +
"-1:2,326:12,177,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:5,17" +
"8,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:6,179,326:6," +
"-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,180,326:3,-1,3" +
"26:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,181,326:10,-1,326:4,-1,326:5,-1" +
":18,326,-1:2,326,-1:6,326,-1:2,326:2,182,326:10,-1,326:4,-1,326:5,-1:18,326" +
",-1:2,326,-1:6,326,-1:2,326:13,-1,326:3,183,-1,326:5,-1:18,326,-1:2,326,-1:" +
"6,326,-1:2,326:13,-1,326:4,-1,184,326:4,-1:18,326,-1:2,326,-1:6,326,-1:2,18" +
"5,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:11,186,326," +
"-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:4,-1,326:3" +
",187,326,-1:18,326,-1:2,326,-1:6,326,-1:2,326:8,188,326:4,-1,326:4,-1,326:5" +
",-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:3,189,-1,326:5,-1:18,326,-1" +
":2,326,-1:6,326,-1:2,326:10,190,326:2,-1,326:4,-1,326:5,-1:18,326,-1:2,326," +
"-1:6,326,-1:2,326:12,191,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2" +
",326:5,192,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:12," +
"193,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:4,194,326:8,-1,3" +
"26:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:4,195,326:8,-1,326:4,-1," +
"326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:5,196,326:7,-1,326:4,-1,326:5,-1" +
":18,326,-1:2,326,-1:6,326,-1:2,326:5,197,326:7,-1,326:4,-1,326:5,-1:18,326," +
"-1:2,326,-1:6,326,-1:2,326:9,201,326:3,-1,326:4,-1,326:5,-1:18,326,-1:2,326" +
",-1:6,326,-1:2,326:2,205,326:10,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,3" +
"26,-1:2,326:12,279,-1,326:3,206,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,3" +
"26:6,208,326:6,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:5,285" +
",326:7,-1,326,209,326:2,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:3,210" +
",326:9,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,211,326:12,-1,326" +
":4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:4,-1,212,326:4,-" +
"1:18,326,-1:2,326,-1:6,326,-1:2,326:3,213,326:9,-1,326:4,-1,326:5,-1:18,326" +
",-1:2,326,-1:6,326,-1:2,326:12,214,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:" +
"6,326,-1:2,326:4,215,326:8,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1" +
":2,326:5,216,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:1" +
"3,-1,326:3,217,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:10,218,326:2,-" +
"1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,219,326:12,-1,326:4,-1,32" +
"6:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:4,-1,222,326:4,-1:18,326" +
",-1:2,326,-1:6,326,-1:2,326:12,223,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:" +
"6,326,-1:2,326:13,-1,326,224,326:2,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:" +
"2,326:13,-1,326:3,227,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:12,228," +
"-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:4,-1,229,3" +
"26:4,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:3,231,-1,326:5,-1:18,32" +
"6,-1:2,326,-1:6,326,-1:2,232,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1" +
":6,326,-1:2,326:11,233,326,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1" +
":2,326:11,234,326,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13" +
",-1,326:3,235,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,236,326:10,-1" +
",326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:4,240,326:8,-1,326:4,-" +
"1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,242,326:10,-1,326:4,-1,326:5" +
",-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:3,275,-1,326:5,-1:18,326,-1" +
":2,326,-1:6,326,-1:2,326:9,276,326:3,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-" +
"1:6,326,-1:2,277,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2," +
"326:5,321,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-" +
"1,326:3,278,-1,326,243,326:3,-1:18,326,-1:2,326,-1:6,326,-1:2,326:7,333,326" +
":5,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:4,-1,32" +
"6,281,326:3,-1:18,326,-1:2,326,-1:6,326,-1:2,326:12,244,-1,326:4,-1,326:5,-" +
"1:18,326,-1:2,326,-1:6,326,-1:2,326:8,245,326:4,-1,326:4,-1,326:5,-1:18,326" +
",-1:2,326,-1:6,326,-1:2,326:8,246,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,32" +
"6,-1:6,326,-1:2,326:13,-1,326,288,326:2,-1,326:5,-1:18,326,-1:2,326,-1:6,32" +
"6,-1:2,326:13,-1,326:4,-1,247,326:4,-1:18,326,-1:2,326,-1:6,326,-1:2,326:8," +
"248,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:8,322,326:" +
"4,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:12,249,-1,326:4,-1" +
",326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:5,250,326:7,-1,326:4,-1,326:5,-" +
"1:18,326,-1:2,326,-1:6,326,-1:2,326:5,251,326:7,-1,326:4,-1,326:5,-1:18,326" +
",-1:2,326,-1:6,326,-1:2,326:5,290,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,32" +
"6,-1:6,326,-1:2,326:3,291,326:9,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,3" +
"26,-1:2,326:2,252,326:10,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2" +
",326:9,292,326:3,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,253,326" +
":12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:10,293,326:2,-1," +
"326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,254,326:10,-1,326:4,-" +
"1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,295,326:12,-1,326:4,-1,326:5,-1:18" +
",326,-1:2,326,-1:6,326,-1:2,326:8,323,326:4,-1,326:4,-1,326:5,-1:18,326,-1:" +
"2,326,-1:6,326,-1:2,326:13,-1,326:4,-1,326,298,326:3,-1:18,326,-1:2,326,-1:" +
"6,326,-1:2,326:13,-1,326:2,299,326,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:" +
"2,326:9,300,326:3,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:6," +
"301,326:6,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,255,326:9,324," +
"326:2,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:4,303,326:8,-1" +
",326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:2,304,326:10,-1,326:4," +
"-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,327,326:12,-1,326:4,-1,326:5,-1:1" +
"8,326,-1:2,326,-1:6,326,-1:2,326:8,305,326:4,-1,326:4,-1,326:5,-1:18,326,-1" +
":2,326,-1:6,326,-1:2,256,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,3" +
"26,-1:2,326:13,-1,326:4,-1,306,326:4,-1:18,326,-1:2,326,-1:6,326,-1:2,326:1" +
"2,257,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:5,308,326:7,-1" +
",326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:9,310,326:3,-1,326:4,-" +
"1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:8,312,326:4,-1,326:4,-1,326:5," +
"-1:18,326,-1:2,326,-1:6,326,-1:2,326:12,258,-1,326:4,-1,326:5,-1:18,326,-1:" +
"2,326,-1:6,326,-1:2,326:2,313,326:10,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-" +
"1:6,326,-1:2,326:5,259,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326," +
"-1:2,326:10,260,326:2,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,32" +
"6:10,261,326:2,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:12,31" +
"4,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:6,315,326:6,-1,326" +
":4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326:3,316,-1,326:5,-" +
"1:18,326,-1:2,326,-1:6,326,-1:2,262,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2" +
",326,-1:6,326,-1:2,326:5,263,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:" +
"6,326,-1:2,269,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,32" +
"6:13,-1,326:3,287,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:9,284,326:3" +
",-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,280,326:12,-1,326:4,-1," +
"326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,326:13,-1,326,289,326:2,-1,326:5,-1:" +
"18,326,-1:2,326,-1:6,326,-1:2,326:5,294,326:7,-1,326:4,-1,326:5,-1:18,326,-" +
"1:2,326,-1:6,326,-1:2,326:9,302,326:3,-1,326:4,-1,326:5,-1:18,326,-1:2,326," +
"-1:6,326,-1:2,307,326:12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2" +
",326:9,311,326:3,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,309,326" +
":12,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,270,326:12,-1,326:4," +
"-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1:2,319,326:12,-1,326:4,-1,326:5,-1:1" +
"8,326,-1:2,326,-1:6,326,-1:2,326:8,325,326:4,-1,326:4,-1,326:5,-1:18,326,-1" +
":2,326,-1:6,326,-1:2,326:9,330,326:3,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-" +
"1:6,326,-1:2,326:5,331,326:7,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326," +
"-1:2,326:8,332,326:4,-1,326:4,-1,326:5,-1:18,326,-1:2,326,-1:6,326,-1");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -3:
						break;
					case 3:
						{return new Symbol(sym.admiraciona,yyline,yychar, yytext());}
					case -4:
						break;
					case 4:
						{}
					case -5:
						break;
					case 5:
						{return new Symbol(sym.Igual,yyline,yychar, yytext());}
					case -6:
						break;
					case 6:
						{return new Symbol(sym.PTCOMA,yyline,yychar, yytext());}
					case -7:
						break;
					case 7:
						{return new Symbol(sym.PARIZQ,yyline,yychar, yytext());}
					case -8:
						break;
					case 8:
						{return new Symbol(sym.PARDER,yyline,yychar, yytext());}
					case -9:
						break;
					case 9:
						{return new Symbol(sym.CORIZQ,yyline,yychar, yytext());}
					case -10:
						break;
					case 10:
						{return new Symbol(sym.CORDER,yyline,yychar, yytext());}
					case -11:
						break;
					case 11:
						{return new Symbol(sym.COMA,yyline,yychar, yytext());}
					case -12:
						break;
					case 12:
						{return new Symbol(sym.MENOS,yyline,yychar, yytext());}
					case -13:
						break;
					case 13:
						{return new Symbol(sym.mayor,yyline,yychar, yytext());}
					case -14:
						break;
					case 14:
						{return new Symbol(sym.MAS,yyline,yychar, yytext());}
					case -15:
						break;
					case 15:
						{return new Symbol(sym.POR,yyline,yychar, yytext());}
					case -16:
						break;
					case 16:
						{return new Symbol(sym.DIVIDIDO,yyline,yychar, yytext());}
					case -17:
						break;
					case 17:
						{return new Symbol(sym.intera,yyline,yychar, yytext());}
					case -18:
						break;
					case 18:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
        Ventana.errorlexico=Ventana.errorlexico+"Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar+"\n";
lista1.agregarAlInicio("error", yytext(), yychar, yyline);
}
					case -19:
						break;
					case 19:
						{return new Symbol(sym.interc,yyline,yychar, yytext());}
					case -20:
						break;
					case 20:
						{return new Symbol(sym.admiracionb,yyline,yychar, yytext());}
					case -21:
						break;
					case 21:
						{return new Symbol(sym.menor,yyline,yychar, yytext());}
					case -22:
						break;
					case 22:
						{yychar=1;}
					case -23:
						break;
					case 23:
						{return new Symbol(sym.ENTERO,yyline,yychar, yytext());}
					case -24:
						break;
					case 24:
						{return new Symbol(sym.Condicional_si,yyline,yychar, yytext());}
					case -25:
						break;
					case 25:
						{return new Symbol(sym.FLECHA, yyline, yychar, yytext());}
					case -26:
						break;
					case 26:
						{return new Symbol(sym.cM_LINE,yyline,yychar, yytext());}
					case -27:
						break;
					case 27:
						{return new Symbol(sym.interc,yyline,yychar, yytext());}
					case -28:
						break;
					case 28:
						{return new Symbol(sym.andd,yyline,yychar, yytext());}
					case -29:
						break;
					case 29:
						{return new Symbol(sym.cADENA,yyline,yychar, yytext());}
					case -30:
						break;
					case 30:
						{return new Symbol(sym.Modulo,yyline,yychar, yytext());}
					case -31:
						break;
					case 31:
						{return new Symbol(sym.T_dato,yyline,yychar, yytext());}
					case -32:
						break;
					case 32:
						{return new Symbol(sym.FIN,yyline,yychar, yytext());}
					case -33:
						break;
					case 33:
						{return new Symbol(sym.DECIMAL,yyline,yychar, yytext());}
					case -34:
						break;
					case 34:
						{return new Symbol(sym.cHAR, yyline, yychar, yytext());}
					case -35:
						break;
					case 35:
						{return new Symbol(sym.CON,yyline,yychar, yytext());}
					case -36:
						break;
					case 36:
						{return new Symbol(sym.COMO,yyline,yychar, yytext());}
					case -37:
						break;
					case 37:
						{return new Symbol(sym.Para,yyline,yychar, yytext());}
					case -38:
						break;
					case 38:
						{return new Symbol(sym.cM_MULT,yyline,yychar, yytext());}
					case -39:
						break;
					case 39:
						{return new Symbol(sym.T_dato,yyline,yychar, yytext());}
					case -40:
						break;
					case 40:
						{return new Symbol(sym.O_si,yyline,yychar, yytext());}
					case -41:
						break;
					case 41:
						{return new Symbol(sym.Igual,yyline,yychar, yytext());}
					case -42:
						break;
					case 42:
						{return new Symbol(sym.Segun,yyline,yychar, yytext());}
					case -43:
						break;
					case 43:
						{return new Symbol(sym.Op_booleano,yyline,yychar, yytext());}
					case -44:
						break;
					case 44:
						{return new Symbol(sym.Hasta,yyline,yychar, yytext());}
					case -45:
						break;
					case 45:
						{return new Symbol(sym.Hacer,yyline,yychar, yytext());}
					case -46:
						break;
					case 46:
						{return new Symbol(sym.Metodo,yyline,yychar, yytext());}
					case -47:
						break;
					case 47:
						{return new Symbol(sym.INICIO,yyline,yychar, yytext());}
					case -48:
						break;
					case 48:
						{return new Symbol(sym.T_dato,yyline,yychar, yytext());}
					case -49:
						break;
					case 49:
						{return new Symbol(sym.Fin_si,yyline,yychar, yytext());}
					case -50:
						break;
					case 50:
						{return new Symbol(sym.T_dato,yyline,yychar, yytext());}
					case -51:
						break;
					case 51:
						{return new Symbol(sym.REVALUAR,yyline,yychar,
                             yytext());}
					case -52:
						break;
					case 52:
						{return new Symbol(sym.Repetir,yyline,yychar, yytext());}
					case -53:
						break;
					case 53:
						{return new Symbol(sym.Funcion,yyline,yychar, yytext());}
					case -54:
						break;
					case 54:
						{return new Symbol(sym.Fin_osi,yyline,yychar, yytext());}
					case -55:
						break;
					case 55:
						{return new Symbol(sym.T_dato,yyline,yychar, yytext());}
					case -56:
						break;
					case 56:
						{return new Symbol(sym.Entonces,yyline,yychar, yytext());}
					case -57:
						break;
					case 57:
						{return new Symbol(sym.EJECUTAR,yyline,yychar, yytext());}
					case -58:
						break;
					case 58:
						{return new Symbol(sym.Retornar,yyline,yychar, yytext());}
					case -59:
						break;
					case 59:
						{return new Symbol(sym.Mientras,yyline,yychar, yytext());}
					case -60:
						break;
					case 60:
						{return new Symbol(sym.IMPRIMIR,yyline,yychar, yytext());}
					case -61:
						break;
					case 61:
						{return new Symbol(sym.INGRESAR,yyline,yychar, yytext());}
					case -62:
						break;
					case 62:
						{return new Symbol(sym.Fin_case,yyline,yychar, yytext());}
					case -63:
						break;
					case 63:
						{return new Symbol(sym.Fin_para,yyline,yychar, yytext());}
					case -64:
						break;
					case 64:
						{return new Symbol(sym.T_dato,yyline,yychar, yytext());}
					case -65:
						break;
					case 65:
						{return new Symbol(sym.Potencia,yyline,yychar, yytext());}
					case -66:
						break;
					case 66:
						{return new Symbol(sym.Op_booleano,yyline,yychar, yytext());}
					case -67:
						break;
					case 67:
						{return new Symbol(sym.esiGual,yyline,yychar, yytext());}
					case -68:
						break;
					case 68:
						{return new Symbol(sym.Fin_segun,yyline,yychar, yytext());}
					case -69:
						break;
					case 69:
						{return new Symbol(sym.Hasta_que,yyline,yychar, yytext());}
					case -70:
						break;
					case 70:
						{return new Symbol(sym.CON_VALOR,yyline,yychar, yytext());}
					case -71:
						break;
					case 71:
						{return new Symbol(sym.Fin_metodo,yyline,yychar, yytext());}
					case -72:
						break;
					case 72:
						{return new Symbol(sym.INCREMENTAL,yyline,yychar, yytext());}
					case -73:
						break;
					case 73:
						{return new Symbol(sym.Fin_funcion,yyline,yychar, yytext());}
					case -74:
						break;
					case 74:
						{return new Symbol(sym.IMPRIMIR_NL,yyline,yychar, yytext());}
					case -75:
						break;
					case 75:
						{return new Symbol(sym.Fin_mientras,yyline,yychar, yytext());}
					case -76:
						break;
					case 76:
						{return new Symbol(sym.esdifeErente,yyline,yychar, yytext());}
					case -77:
						break;
					case 77:
						{return new Symbol(sym.menorigual,yyline,yychar, yytext());}
					case -78:
						break;
					case 78:
						{return new Symbol(sym.Mayorigual,yyline,yychar, yytext());}
					case -79:
						break;
					case 79:
						{return new Symbol(sym.Con_parametros,yyline,yychar, yytext());}
					case -80:
						break;
					case 80:
						{return new Symbol(sym.De_lo_contrario,yyline,yychar, yytext());}
					case -81:
						break;
					case 82:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -82:
						break;
					case 83:
						{}
					case -83:
						break;
					case 84:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
        Ventana.errorlexico=Ventana.errorlexico+"Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar+"\n";
lista1.agregarAlInicio("error", yytext(), yychar, yyline);
}
					case -84:
						break;
					case 85:
						{return new Symbol(sym.cADENA,yyline,yychar, yytext());}
					case -85:
						break;
					case 87:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -86:
						break;
					case 88:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
        Ventana.errorlexico=Ventana.errorlexico+"Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar+"\n";
lista1.agregarAlInicio("error", yytext(), yychar, yyline);
}
					case -87:
						break;
					case 90:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -88:
						break;
					case 91:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
        Ventana.errorlexico=Ventana.errorlexico+"Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar+"\n";
lista1.agregarAlInicio("error", yytext(), yychar, yyline);
}
					case -89:
						break;
					case 93:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -90:
						break;
					case 94:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
        Ventana.errorlexico=Ventana.errorlexico+"Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar+"\n";
lista1.agregarAlInicio("error", yytext(), yychar, yyline);
}
					case -91:
						break;
					case 96:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -92:
						break;
					case 98:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -93:
						break;
					case 100:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -94:
						break;
					case 102:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -95:
						break;
					case 104:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -96:
						break;
					case 106:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -97:
						break;
					case 108:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -98:
						break;
					case 110:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -99:
						break;
					case 112:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -100:
						break;
					case 114:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -101:
						break;
					case 116:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -102:
						break;
					case 118:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -103:
						break;
					case 120:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -104:
						break;
					case 122:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -105:
						break;
					case 124:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -106:
						break;
					case 126:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -107:
						break;
					case 127:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -108:
						break;
					case 128:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -109:
						break;
					case 129:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -110:
						break;
					case 130:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -111:
						break;
					case 131:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -112:
						break;
					case 132:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -113:
						break;
					case 133:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -114:
						break;
					case 134:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -115:
						break;
					case 135:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -116:
						break;
					case 136:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -117:
						break;
					case 137:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -118:
						break;
					case 138:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -119:
						break;
					case 139:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -120:
						break;
					case 140:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -121:
						break;
					case 141:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -122:
						break;
					case 142:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -123:
						break;
					case 143:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -124:
						break;
					case 144:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -125:
						break;
					case 145:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -126:
						break;
					case 146:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -127:
						break;
					case 147:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -128:
						break;
					case 148:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -129:
						break;
					case 149:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -130:
						break;
					case 150:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -131:
						break;
					case 151:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -132:
						break;
					case 152:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -133:
						break;
					case 153:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -134:
						break;
					case 155:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -135:
						break;
					case 156:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -136:
						break;
					case 157:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -137:
						break;
					case 158:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -138:
						break;
					case 159:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -139:
						break;
					case 160:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -140:
						break;
					case 161:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -141:
						break;
					case 162:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -142:
						break;
					case 163:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -143:
						break;
					case 164:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -144:
						break;
					case 165:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -145:
						break;
					case 166:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -146:
						break;
					case 167:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -147:
						break;
					case 168:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -148:
						break;
					case 169:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -149:
						break;
					case 170:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -150:
						break;
					case 171:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -151:
						break;
					case 172:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -152:
						break;
					case 173:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -153:
						break;
					case 174:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -154:
						break;
					case 175:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -155:
						break;
					case 176:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -156:
						break;
					case 177:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -157:
						break;
					case 178:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -158:
						break;
					case 179:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -159:
						break;
					case 180:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -160:
						break;
					case 181:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -161:
						break;
					case 182:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -162:
						break;
					case 183:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -163:
						break;
					case 184:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -164:
						break;
					case 185:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -165:
						break;
					case 186:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -166:
						break;
					case 187:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -167:
						break;
					case 188:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -168:
						break;
					case 189:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -169:
						break;
					case 190:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -170:
						break;
					case 191:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -171:
						break;
					case 192:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -172:
						break;
					case 193:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -173:
						break;
					case 194:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -174:
						break;
					case 195:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -175:
						break;
					case 196:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -176:
						break;
					case 197:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -177:
						break;
					case 198:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -178:
						break;
					case 199:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -179:
						break;
					case 200:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -180:
						break;
					case 201:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -181:
						break;
					case 202:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -182:
						break;
					case 203:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -183:
						break;
					case 204:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -184:
						break;
					case 205:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -185:
						break;
					case 206:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -186:
						break;
					case 207:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -187:
						break;
					case 208:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -188:
						break;
					case 209:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -189:
						break;
					case 210:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -190:
						break;
					case 211:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -191:
						break;
					case 212:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -192:
						break;
					case 213:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -193:
						break;
					case 214:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -194:
						break;
					case 215:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -195:
						break;
					case 216:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -196:
						break;
					case 217:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -197:
						break;
					case 218:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -198:
						break;
					case 219:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -199:
						break;
					case 220:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -200:
						break;
					case 221:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -201:
						break;
					case 222:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -202:
						break;
					case 223:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -203:
						break;
					case 224:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -204:
						break;
					case 225:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -205:
						break;
					case 226:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -206:
						break;
					case 227:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -207:
						break;
					case 228:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -208:
						break;
					case 229:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -209:
						break;
					case 230:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -210:
						break;
					case 231:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -211:
						break;
					case 232:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -212:
						break;
					case 233:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -213:
						break;
					case 234:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -214:
						break;
					case 235:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -215:
						break;
					case 236:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -216:
						break;
					case 237:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -217:
						break;
					case 238:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -218:
						break;
					case 239:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -219:
						break;
					case 240:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -220:
						break;
					case 241:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -221:
						break;
					case 242:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -222:
						break;
					case 243:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -223:
						break;
					case 244:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -224:
						break;
					case 245:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -225:
						break;
					case 246:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -226:
						break;
					case 247:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -227:
						break;
					case 248:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -228:
						break;
					case 249:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -229:
						break;
					case 250:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -230:
						break;
					case 251:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -231:
						break;
					case 252:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -232:
						break;
					case 253:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -233:
						break;
					case 254:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -234:
						break;
					case 255:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -235:
						break;
					case 256:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -236:
						break;
					case 257:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -237:
						break;
					case 258:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -238:
						break;
					case 259:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -239:
						break;
					case 260:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -240:
						break;
					case 261:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -241:
						break;
					case 262:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -242:
						break;
					case 263:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -243:
						break;
					case 264:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -244:
						break;
					case 265:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -245:
						break;
					case 266:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -246:
						break;
					case 267:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -247:
						break;
					case 268:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -248:
						break;
					case 269:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -249:
						break;
					case 270:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -250:
						break;
					case 271:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -251:
						break;
					case 272:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -252:
						break;
					case 273:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -253:
						break;
					case 274:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -254:
						break;
					case 275:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -255:
						break;
					case 276:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -256:
						break;
					case 277:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -257:
						break;
					case 278:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -258:
						break;
					case 279:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -259:
						break;
					case 280:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -260:
						break;
					case 281:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -261:
						break;
					case 282:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -262:
						break;
					case 283:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -263:
						break;
					case 284:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -264:
						break;
					case 285:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -265:
						break;
					case 286:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -266:
						break;
					case 287:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -267:
						break;
					case 288:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -268:
						break;
					case 289:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -269:
						break;
					case 290:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -270:
						break;
					case 291:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -271:
						break;
					case 292:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -272:
						break;
					case 293:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -273:
						break;
					case 294:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -274:
						break;
					case 295:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -275:
						break;
					case 296:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -276:
						break;
					case 297:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -277:
						break;
					case 298:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -278:
						break;
					case 299:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -279:
						break;
					case 300:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -280:
						break;
					case 301:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -281:
						break;
					case 302:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -282:
						break;
					case 303:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -283:
						break;
					case 304:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -284:
						break;
					case 305:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -285:
						break;
					case 306:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -286:
						break;
					case 307:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -287:
						break;
					case 308:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -288:
						break;
					case 309:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -289:
						break;
					case 310:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -290:
						break;
					case 311:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -291:
						break;
					case 312:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -292:
						break;
					case 313:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -293:
						break;
					case 314:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -294:
						break;
					case 315:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -295:
						break;
					case 316:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -296:
						break;
					case 317:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -297:
						break;
					case 318:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -298:
						break;
					case 319:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -299:
						break;
					case 320:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -300:
						break;
					case 321:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -301:
						break;
					case 322:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -302:
						break;
					case 323:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -303:
						break;
					case 324:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -304:
						break;
					case 325:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -305:
						break;
					case 326:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -306:
						break;
					case 327:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -307:
						break;
					case 328:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -308:
						break;
					case 329:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -309:
						break;
					case 330:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -310:
						break;
					case 331:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -311:
						break;
					case 332:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -312:
						break;
					case 333:
						{return new Symbol(sym.iDENTIFICADOR,yyline,yychar, yytext());}
					case -313:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
