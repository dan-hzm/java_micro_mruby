package lib;

public class Opcode_enum {
    /*-----------------------------------------------------------------------
     * operation code  operand description
    ------------------------------------------------------------------------*/
    public static final int OP_NOP = 0;                                                             
    public static final int OP_MOVE = 1;    
    public static final int OP_LOADL = 2;   
    public static final int OP_LOADI = 3;
    public static final int OP_LOADSYM = 4;
    public static final int OP_LOADNIL = 5;
    public static final int OP_LOADSELF = 6;
    public static final int OP_LOADT = 7;   
    public static final int OP_LOADF = 8;   

    public static final int OP_GETGLOBAL = 9;
    public static final int OP_SETGLOBAL = 10;
    public static final int OP_GETSPECIAL = 11;
    public static final int OP_SETSPECIAL = 12;
    public static final int OP_GETIV = 13;
    public static final int OP_SETIV = 14;
    public static final int OP_GETCV = 15;
    public static final int OP_SETCV = 16;
    public static final int OP_GETCONST = 17;
    public static final int OP_SETCONST = 18;
    public static final int OP_GETMCNST = 19;
    public static final int OP_SETMCNST = 20;
    public static final int OP_GETUPVAR = 21;
    public static final int OP_SETUPVAR = 22;

    public static final int OP_JMP = 23;
    public static final int OP_JMPIF = 24;
    public static final int OP_JMPNOT = 25;
    public static final int OP_ONERR = 26;
    public static final int OP_RESCUE = 27;
    public static final int OP_POPERR = 28;
    public static final int OP_RAISE = 29;
    public static final int OP_EPUSH = 30;
    public static final int OP_EPOP = 31;

    public static final int OP_SEND = 32;
    public static final int OP_SENDB = 33;
    public static final int OP_FSEND = 34;
    public static final int OP_CALL = 35;
    public static final int OP_SUPER = 36;
    public static final int OP_ARGARY = 37;
    public static final int OP_ENTER = 38;
    public static final int OP_KARG = 39;
    public static final int OP_KDICT = 40;

    public static final int OP_RETURN = 41;
    public static final int OP_TAILCALL = 42;
    public static final int OP_BLKPUSH = 43;

    public static final int OP_ADD = 44;
    public static final int OP_ADDI = 45;
    public static final int OP_SUB = 46;
    public static final int OP_SUBI = 47;
    public static final int OP_MUL = 48;
    public static final int OP_DIV = 49;
    public static final int OP_EQ = 50;
    public static final int OP_LT = 51;
    public static final int OP_LE = 52;
    public static final int OP_GT = 53;
    public static final int OP_GE = 54;

    public static final int OP_ARRAY = 55;
    public static final int OP_ARYCAT = 56;
    public static final int OP_ARYPUSH = 57;
    public static final int OP_AREF = 58;
    public static final int OP_ASET = 59;
    public static final int OP_APOST = 60;

    public static final int OP_STRING = 61;
    public static final int OP_STRCAT = 62;

    public static final int OP_HASH = 63;
    public static final int OP_LAMBDA = 64;
    public static final int OP_RANGE = 65;

    public static final int OP_OCLASS = 66;
    public static final int OP_CLASS = 67;
    public static final int OP_MODULE = 68;
    public static final int OP_EXEC = 69;
    public static final int OP_METHOD = 70;
    public static final int OP_SCLASS = 71;
    public static final int OP_TCLASS = 72;

    public static final int OP_DEBUG = 73;
    public static final int OP_STOP = 74;
    public static final int OP_ERR = 75;

    public static final int OP_RSVD1 = 76;
    public static final int OP_RSVD2 = 77;
    public static final int OP_RSVD3 = 78;
    public static final int OP_RSVD4 = 79;
    public static final int OP_RSVD5 = 80;

 /*   private int value;
    Status(int value) {
        this.value;
    }
    public int intValue() {
        return value;
    }
*/   

}