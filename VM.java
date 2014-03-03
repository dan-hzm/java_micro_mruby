import lib.*;
import java.io.*;

class VM {
  // マクロ定義
	public class Constants{
		public static final int DEBUG = 1;
    public boolean IDENT_EQUAL(char[] ptr, char[] str){
      return (((ptr[0])==(str[0]))&((ptr[1])==(str[1]))&((ptr[2])==(str[2]))&((ptr[3])==(str[3])));
    }
	}

  // 初期化関数
	public int init_vm() { 
  	// micro_stateオブジェクト生成 & 初期化
    lib.Micro_state state = new lib.Micro_state();
    state = new Micro_state();

 		// CLASS初期化
 		int i;
 		for( i=0 ; i<Config.MICRO_CLASS_SIZE ; i++ ) {
   		state.set_classes_tt(i, Mrb_vtype_t.MRB_TT_FREE);
 		}

 		// STACK初期化
 		for( i=0 ; i<Config.MICRO_STACK_SIZE ; i++ ) {
   		state.stack[i].set_tt(Mrb_vtype_t.MRB_TT_FREE);
   		state.set_stack_union_i(i, 0);
 		}
 
 		// 組込みメソッド
// task    init_method(state);
// init.c は未設定
 		return 0;
	}

	public int load_mrb_from_pointer(char[] ptr) { 
    int i;
    VM.Constants ident = new VM.Constants();

    int index = 0;
    char[] comp_1 = {'E', 'N', 'D'};
    while( !ident.IDENT_EQUAL(ptr, comp_1)) {
      char[] comp_2 = {'R', 'I', 'T', 'E'};
      char[] comp_3 = {'I', 'R', 'E', 'P'};
      if( ident.IDENT_EQUAL(ptr, comp_2) ){
        // ptr += 22;
        index += 22;
      } else if( ident.IDENT_EQUAL(ptr,comp_3) ){
        // ヘッダをスキップ
        int irep_count = ptr[12] * 256 + ptr[13];
        // ptr += 16;
        index += 16;
        while( irep_count-- > 0 ){
          lib.Micro_irep irep = new lib.Micro_irep(); 
          // micro_irep *irep = &state->ireps[state->irep_count++];
          // ポインタirepにstate構造体内のireps[]の中身を移し替えしている
          // 命令語の処理
          // irep->code = (wordcode *)(ptr + 12);
          // wordcode全部を移し替え？
          //irep.set_code_bytes_all(ptr + 12);
          int inst_count = ((ptr[9]*256) + ptr[10])*256 + ptr[11];
          // 作業用スペース
          irep.set_locals( (short)(ptr[4] * 256 + ptr[5]) );
          irep.set_regs( (short)(ptr[6] * 256 + ptr[7]) );
          // poolの処理
          ptr += 12 + inst_count * 4;
          irep.set_pools( (ptr[1] * 256 + ptr[2]) * 256 + ptr[3]);
          // poolのskip処理
          irep.set_pools_ptr(ptr + 4);
          // symbolの処理
          ptr += 4 + irep.pools;  // ???
          irep.set_syms_ptr(ptr + 4);
          irep.set_syms( (ptr[1] * 256 + ptr[2]) * 256 + ptr[3] );
          // symsのskip処理
          ptr += 4;
          for( i=0 ; i<irep.syms ; i++ ){
            int skip_size = ptr[0] * 256 + ptr[1];
            ptr += 2 + skip_size + 1;
          }
        }
      }
    }
  return 0;
  }

	public char sym_search(int sym){ 
// task    micro_irep *irep = state->ireps +  state->current_irep;
    // state->irepsは配列のどれを指しているのか？
    //　current_irepはint型
    lib.Micro_irep irep = new lib.Micro_irep();
 		char p = irep.syms_ptr;
  	
  	while( sym > 0 ){
    	int inc = (int)(p[0]*256+p[1]);
    	p += inc + 3;
    	sym--;
  	}

	  return (char)(p+2);
	}

	public long sym_search_hash(int sym) {
  	return sym_search(sym);
	}

	public int search_method(short c, long h) {
  	int i;
    lib.RProc p = new lib.RProc();

  	for( i=0 ; i<Config.MICRO_RPROC_SIZE ; i++ ){
    	if( true /*p.empty*/ ) continue;
    	if( p.method_id == h ) return i;
  		}
  
  	return -1;
	}

	public int vm_run(){ 
		lib.Micro_state state = new lib.Micro_state();
    state = new Micro_state();
    // state->op = state->ireps[0].code;
    state.set_op_bytes_all(state.ireps[0].code.bytes);
    state.set_op_union_a(state.ireps[0].code.union.a);
    state.set_op_union_bx(state.ireps[0].code.union.bx);
    state.set_op_union_op(state.ireps[0].code.union.op);

  	state.set_sp(0);

// task
//　selfを引数として取ってきた場合は何が格納されているのか？
    lib.Mrb_value self = new lib.Mrb_value();
    // state->stack[state->sp] = self
    state.set_stack_union_f(state.sp, self.union.f);
    state.set_stack_union_i(state.sp, self.union.i);
    state.set_stack_union_sym(state.sp, self.union.sym);
    state.set_stack_union_aclass(state.sp, self.union.aclass);

		while( true ){
			int jump_flag = 0;

			//レジスタ
      lib.Mrb_value[] regs = new lib.Mrb_value[10]; // 仮に10と設定する
// task ここから下はttは一先ず省略
      // mrb_value *regs = &state->stack[state->sp];
      int i;
      for( i=0 ; i<10 ; i++){
        regs[i].set_union_f(state.stack[state.sp].union.f);
        regs[i].set_union_i(state.stack[state.sp].union.i);
        regs[i].set_union_sym(state.stack[state.sp].union.sym);      
        regs[i].set_union_aclass(state.stack[state.sp].union.aclass);
      }

      long word = state.op.bytes[0];
    	word *= 256;
      word += state.op.bytes[1];
    	word *= 256;
      word += state.op.bytes[2];
    	word *= 256;
      word += state.op.bytes[3];

      lib.Opcode opcode = new lib.Opcode(); 
			switch ( (int)(opcode.GET_OPCODE(word)) ) {
  			case Opcode_enum.OP_NOP:
  				break;
		
  			case Opcode_enum.OP_MOVE:
   		  	// regs[opcode.GET_ARG_A(word)] = regs[opcode.GET_ARG_B(word)];
          regs[(int)(opcode.GET_ARG_A(word))].set_union_f(regs[(int)(opcode.GET_ARG_B(word))].union.f);
          regs[(int)(opcode.GET_ARG_A(word))].set_union_i(regs[(int)(opcode.GET_ARG_B((int)word))].union.i);
          regs[(int)(opcode.GET_ARG_A(word))].set_union_sym(regs[(int)(opcode.GET_ARG_B((int)word))].union.sym);
          regs[(int)(opcode.GET_ARG_A(word))].set_union_aclass(regs[(int)(opcode.GET_ARG_B((int)word))].union.aclass);
     			break;

       	case Opcode_enum.OP_LOADI: {
    			int a = (int)(opcode.GET_ARG_A(word));
// task    			regs[a].tt = vtype.MRB_TT_FIXNUM;
// mrb_valueのtt変更
   	  		regs[a].set_union_i((int)(opcode.GET_ARG_sBx(word)));
   	  	} break;

      	case Opcode_enum.OP_LOADSELF:
   	  		// regs[opcode.GET_ARG_A(word)] = regs[0];
   	  		regs[(int)(opcode.GET_ARG_A(word))].set_union_f(regs[0].union.f);
          regs[(int)(opcode.GET_ARG_A(word))].set_union_i(regs[0].union.i);
          regs[(int)(opcode.GET_ARG_A(word))].set_union_sym(regs[0].union.sym);
          regs[(int)(opcode.GET_ARG_A(word))].set_union_aclass(regs[0].union.aclass);
          break;

   	  	case Opcode_enum.OP_LOADNIL:
// task     			regs[opcode.GET_ARG_A(word)].tt = define.MRB_TT_FALSE;
     	 		break;
      
    	  case Opcode_enum.OP_SEND: {
   	  		int a = (int)(opcode.GET_ARG_A(word));
     			int n = (int)(opcode.GET_ARG_C(word));
     			int sym = (int)(opcode.GET_ARG_B(word));
    			
          lib.Mrb_value recv = new lib.Mrb_value(); // 仮に10と設定する

          VM own = new VM();
   	  	 	long h = own.sym_search_hash(sym);
          int proc_idx = own.search_method(recv.union.aclass, h);
          if( proc_idx >= 0 ){
		  	    // スタック
		  	    state.set_sp(state.sp + a);
		  	    // メソッド呼び出し
            lib.RProc p = new lib.RProc();
            p.set_empty(state.procs[proc_idx].empty);
            p.set_cfunc_flag(state.procs[proc_idx].cfunc_flag);
            p.set_obj_id(state.procs[proc_idx].obj_id);
            p.set_method_id(state.procs[proc_idx].method_id);
            p.set_union_irep_idx(state.procs[proc_idx].union.irep_idx);
            p.set_union_cfunc_union_f(state.procs[proc_idx].union.cfunc.union.f);
            p.set_union_cfunc_union_i(state.procs[proc_idx].union.cfunc.union.i);
            p.set_union_cfunc_union_sym(state.procs[proc_idx].union.cfunc.union.sym);
            p.set_union_cfunc_union_aclass(state.procs[proc_idx].union.cfunc.union.aclass);
            if( true ) { // p->cfunc
              // C関数
              // p->cfunc(state, recv);
// task					  p.union.cfunc(state, recv); // cfuncは関数？ RProc_union
		  	    } else {
  		  			System.out.println("Ruby関数 not implemented");
		  	    }
		  	    // スタックを戻す
		  	    state.set_sp(state.sp - a);
     	  	}
   	  	} break;

  	    case Opcode_enum.OP_LE: {
     	  	int a = (int)(opcode.GET_ARG_A(word));
   			  if( regs[a].tt == Mrb_vtype_t.MRB_TT_FIXNUM && regs[a+1].tt == Mrb_vtype_t.MRB_TT_FIXNUM ){
   			  	if( regs[a].union.i <= regs[a+1].union.i ){
// task	  		  		regs[a].tt = define.MRB_TT_TRUE;
	  			  } else {
// task     		  	regs[a].tt = define.MRB_TT_FALSE;
   	   	  	}
          } else {
		      	System.out.println("Not implemented OP_LE");
   	    	}
    		} break;

  	   	case Opcode_enum.OP_JMP: {
// task   			  state.op += opcode.GET_ARG_sBx(word);
// opはwordcodeでbytesかunionどちらを操作しているのか？
   	  	 	jump_flag = 1;
    		} break;

     		case Opcode_enum.OP_JMPIF: {
   			if( regs[(int)(opcode.GET_ARG_A(word))].tt != Mrb_vtype_t.MRB_TT_FALSE ){
// task			    state.op += opcode.GET_ARG_sBx(word);
	        jump_flag = 1;
   			}
     		} break;
      
     		case Opcode_enum.OP_ADD: {
   	  	int a = (int)(opcode.GET_ARG_A(word));
   	  	if( regs[a].tt == Mrb_vtype_t.MRB_TT_FIXNUM && regs[a+1].tt == Mrb_vtype_t.MRB_TT_FIXNUM ){
			    regs[a].set_union_i(regs[a].union.i + regs[a+1].union.i);
   	  	} else {
			    System.out.println("Not implemented OP_ADD");
   	  	}
     		} break;

     		case Opcode_enum.OP_ADDI: {
   	  	int a = (int)(opcode.GET_ARG_A(word));
   	  	if( regs[a].tt == Mrb_vtype_t.MRB_TT_FIXNUM ){
			    regs[a].set_union_i(regs[a].union.i + (int)(opcode.GET_ARG_C(word)));
   	  	} else {
			    System.out.println("Not implemented OP_ADDI");
   	 		}
     		} break;

     		case Opcode_enum.OP_SUB: {
   	  	int a = (int)(opcode.GET_ARG_A(word));
   	  	if( regs[a].tt == Mrb_vtype_t.MRB_TT_FIXNUM && regs[a+1].tt == Mrb_vtype_t.MRB_TT_FIXNUM ){
			    regs[a].set_union_i(regs[a].union.i - regs[a+1].union.i);
   	  	} else {
			    System.out.println("Not implemented OP_SUB");
     		}
     		} break;

     		case Opcode_enum.OP_MUL: {
     		int a = (int)(opcode.GET_ARG_A(word));
     		if( regs[a].tt == Mrb_vtype_t.MRB_TT_FIXNUM && regs[a+1].tt == Mrb_vtype_t.MRB_TT_FIXNUM ){
			    regs[a].set_union_i(regs[a].union.i * regs[a+1].union.i);
   	  	} else {
			    System.out.println("Not implemented OP_MUL");
 	  		}
     		} break;

     		case Opcode_enum.OP_STOP:
   			return 0;
   			break;

      	default:
     		System.out.printf("not implemented (op=%ld)", opcode.GET_OPCODE(word));
     		break;  
   		}

     	// Next or Jump
     	if( jump_flag == 0 ); //state->op++;
		  }
    }

    // test
    public static void main(String[] args) {
      System.out.println("test fin.");    
    }
}