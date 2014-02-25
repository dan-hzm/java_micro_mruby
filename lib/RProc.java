package lib;
import lib.*;

public class  RProc {
	// instance value
	public int empty;
	public int cfunc_flag;
	public int obj_id;
	public long method_id;

	public lib.RProc_union union = new lib.RProc_union();

	//constructor
	public RProc() {
		this.empty = 0;
		this.cfunc_flag = 0;
		this.obj_id = 0;
		this.method_id = 0L;
	}

	// setter method
	public void set_empty(int sEmpty) {
		empty = sEmpty;
	}
	public void set_cfunc_flag(int sCfunc_flag) {
		cfunc_flag = sCfunc_flag;
	}
	public void set_obj_id(int sObj_id) {
		obj_id = sObj_id;
	}
	public void set_method_id(long sMethod_id) {
		method_id = sMethod_id;
	}

	public void set_union_irep_idx(int irep_idx) {
		union.set_irep_idx(irep_idx);
	}
	public void set_union_cfunc_union_f(float f) {
		union.set_cfunc_union_f(f);
	}
	public void set_union_cfunc_union_i(int i) {
		union.set_cfunc_union_i(i);
	}
	public void set_union_cfunc_union_sym(int sym) {
		union.set_cfunc_union_sym(sym);
	}
	public void set_union_cfunc_union_aclass(short aclass) {
		union.set_cfunc_union_aclass(aclass);
	}
}