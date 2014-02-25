package lib;
import lib.*;

public class Micro_irep {
	// instance value
	public lib.Wordcode code = new lib.Wordcode();

	// 本来はuint8_t　、今回はuint16_tに拡張し、charで置換
	public static char pools_ptr;
	public static char syms_ptr;

	public static short locals;
	public static short regs;
	public static short syms;
	public static short pools;

	// constructor
	public Micro_irep() {
		short init = 0;
		this.locals = init;
		this.regs = init;
		this.syms = init;
		this.pools = init;	
	}

	// setter method
	public void set_code_bytes(int bytes, char[] sBytes) {
		code.set_bytes(bytes, sBytes);
	}
	public void set_code_bytes_all(char[] sBytes){
		code.set_bytes_all(sBytes);
	}
	public void set_code_union_a(int a) {
		code.set_union_a(a);
	}
	public void set_code_union_bx(int bx) {
		code.set_union_bx(bx);
	}
	public void set_code_union_op(int op) {
		code.set_union_op(op);
	}

	public void set_pools_ptr(char sPools_ptr) {
		pools_ptr = sPools_ptr;
	}
	public void set_syms_ptr(char sSyms_ptr) {
		syms_ptr = sSyms_ptr;
	}

	public void set_locals(short sLocals) {
		locals = sLocals;
	}
	public void set_regs(short sRegs) {
		regs = sRegs;
	}
	public void set_syms(short sSyms) {
		syms = sSyms;
	}
	public void set_pools(short sPools) {
		pools = sPools;
	}
}