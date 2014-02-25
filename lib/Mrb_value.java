package lib;
import lib.*;

public class Mrb_value {
	// instance value
	//public lib.Mrb_vtype_t tt = new lib.Mrb_vtype_t();
	public int tt;
	public lib.Mrb_value_union union = new lib.Mrb_value_union();

	// constructor
	public Mrb_value() {
	}

	//setter method
	public void set_tt(int sTt){
		tt = sTt;
	}

	public void set_union_f(float f) {
		union.set_f(f);
	}
	public void set_union_i(int i) {
		union.set_i(i);
	}
	public void set_union_sym(int sym) {
		union.set_sym(sym);
	}
	public void set_union_aclass(short aclass) {
		union.set_class(aclass);
	}
}