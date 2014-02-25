package lib;
import lib.*;

public class RProc_union {
	// instance value
	public int irep_idx;
	public lib.Mrb_value cfunc = new lib.Mrb_value();

	//constructor = init
	public RProc_union() {
		this.irep_idx = 0;
	}

	// setter method
	public void set_irep_idx(int sIrep_idx) {
		irep_idx = sIrep_idx;
	}

//	public void set_cfunc_tt();
	public void set_cfunc_union_f(float f) {
		cfunc.set_union_f(f);
	}
	public void set_cfunc_union_i(int i) {
		cfunc.set_union_i(i);
	}
	public void set_cfunc_union_sym(int sym) {
		cfunc.set_union_sym(sym);
	}
	public void set_cfunc_union_aclass(short aclass) {
		cfunc.set_union_aclass(aclass);
	}
}