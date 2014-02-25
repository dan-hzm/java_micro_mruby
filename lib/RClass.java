package lib;

public class RClass {
	// instance value
	public int tt = 0;
	public long cname;
	public short super_rc;

	// constructor
	public RClass(int tt, long cname, short super_rc) {
		this.tt = tt;
		this.cname = cname;
		this.super_rc = super_rc;
	}

	// setter method
	public void set_tt(int sTt) {
		tt = sTt;
	}
	public void set_cname(long sCname) {
		cname = sCname;
	}
	public void set_super_rc(short sSuper) {
		super_rc = sSuper;
	}
}