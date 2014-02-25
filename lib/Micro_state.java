package lib;
import lib.*;

public class Micro_state {
	// instance value
	public int irep_count;
	public int sp;
	public int current_irep;

	public lib.RClass[] classes = new lib.RClass[Config.MICRO_CLASS_SIZE];
	public lib.Micro_irep[] ireps = new lib.Micro_irep[Config.MICRO_IREP_SIZE];
	public lib.Mrb_value[] stack = new lib.Mrb_value[Config.MICRO_STACK_SIZE];
	public lib.Wordcode op = new lib.Wordcode();
	public lib.RProc[] procs = new lib.RProc[Config.MICRO_RPROC_SIZE];

	//constructor
	public Micro_state() {
		this.irep_count = 0;
		this.sp = 0;
		this.current_irep = 0;
	}

	// setter method
	public void set_irep_count(int sIrep_count) {
		irep_count = sIrep_count;
	}
	public void set_sp(int sSp) {
		sp = sSp;
	}
	public void set_current_irep(int sCurrent_irep) {
		current_irep = sCurrent_irep;
	}

	// classes
	public void set_classes_tt(int index, int tt) {
		classes[index].set_tt(tt);
	}
	public void set_classes_cname(int index, long cname) {
		classes[index].set_cname(cname);
	}
	public void set_classes_super_rc(int index, short super_rc) {
		classes[index].set_super_rc(super_rc);
	}

	// stack
// ???	
//	public void stack_tt(int index, int tt) {
//		stack[index].set_tt(tt);
//	}

	public void set_stack_union_f(int index, float f) {
		stack[index].set_union_f(f);
	}
	public void set_stack_union_i(int index, int i) {
		stack[index].set_union_i(i);
	}
	public void set_stack_union_sym(int index, int sym) {
		stack[index].set_union_sym(sym);
	}
	public void set_stack_union_aclass(int index, short aclass) {
		stack[index].set_union_aclass(aclass);
	}
	
	// op
//	public void set_op_all( );
	public void set_op_bytes(int bytes, char[] sByte) {
		op.set_bytes(bytes, sByte);
	}
	public void set_op_bytes_all(char[] sByte) {
		op.set_bytes_all(sByte);
	}
	public void set_op_union_a(int a) {
		op.set_union_a(a);
	}
	public void set_op_union_bx(int bx) {
		op.set_union_bx(bx);
	}
	public void set_op_union_op(int sOp) {
		op.set_union_op(sOp);
	}
 
 	// procs
 	public void set_procs_empty(int index, int empty) {
 		procs[index].set_empty(empty);
 	}
 	public void set_procs_cfunc_flag(int index, int cfunc_flag) {
 		procs[index].set_cfunc_flag(cfunc_flag);
 	}
 	public void set_procs_obj_id(int index, int obj_id) {
 		procs[index].set_obj_id(obj_id);
 	}
 	public void set_procs_method_id(int index, long method_id) {
 		procs[index].set_method_id(method_id);
 	}
 	public void set_procs_union_irep_idx(int index, int irep_idx) {
 		procs[index].set_union_irep_idx(irep_idx);
  	}
  	public void set_procs_union_cfunc_union_f(int index, float f) {
  		procs[index].set_union_cfunc_union_f(f);
  	}
  	public void set_procs_union_cfunc_union_i(int index, int i) {
  		procs[index].set_union_cfunc_union_i(i);
  	}
  	public void set_procs_union_cfunc_union_sym(int index, int sym) {
  		procs[index].set_union_cfunc_union_sym(sym);
  	}
  	public void set_procs_union_cfunc_union_aclass(int index, short aclass) {
  		procs[index].set_union_cfunc_union_aclass(aclass);
  	}
}