package lib;

public class Opcode {

  public long GET_OPCODE(long w) {
    return ( (((w)      ) & 0x0000007f) );
  }
  public long GET_ARG_A(long w) {
    return ( (((w) >> 23) & 0x000001ff) );
  }
  public long GET_ARG_B(long w) {
    return ( (((w) >> 14) & 0x000001ff) );
  }
  public long GET_ARG_C(long w) {
    return ( (((w) >>  7) & 0x0000007f) );
  }
  public long GET_ARG_Bx(long w) {
    return ( (((w) >>  7) & 0x0000ffff) ); 
  } 
  public long GET_ARG_sBx(long w) {
    return ( (((w) >>  7) & 0x0000ffff)-0x7fff );
  }
}
