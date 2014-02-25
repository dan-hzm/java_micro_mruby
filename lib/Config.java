package lib;

public class Config {
  // 関数宣言
  // public void init_method(micro_state *state);

  // config.h
  public static final int MICRO_CLASS_SIZE = 40; // クラスの総数
  public static final int MICRO_IREP_SIZE = 20; // irepの総数
  public static final int MICRO_RPROC_SIZE = 200; // procの総数
  public static final int MICRO_OBJECT_SIZE = 1000; // オブジェクトの総数
  public static final int MICRO_STACK_SIZE = 500; // スタックサイズ
 
 /*
    private int value;

    // constructor
    private Mrb_vtype_t(int n) {
      this.value = n;
    }
    public int get_value() {
      return this.value;
    }
  };
*/
}