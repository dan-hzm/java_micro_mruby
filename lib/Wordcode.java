package lib;
import java.io.*;
import lib.*;

public class Wordcode {
	// instance value
	public char[] bytes = new char[4];
	public lib.Wordcode_union union = new lib.Wordcode_union();

	// constructor
	public Wordcode() {
	}

	// setter method
	public void set_bytes(int index, char[] sByte) {
		switch (index){
		case 0:
			bytes[0]=sByte[0];
			break;
		case 1:
			bytes[1]=sByte[1];
			break;
		case 2:
			bytes[2]=sByte[2];
			break;
		case 3:
			bytes[3]=sByte[3];
			break;
		}
	}
	public void set_bytes_all(char[] sByte) {
		int i = 0;
		for( i=0 ; i<4 ; i++) {
			bytes[i] = sByte[i];
		}
	}
	public void set_union_a(int a) {
		union.set_a(a);
	}
	public void set_union_bx(int bx) {
		union.set_bx(bx);
	}
	public void set_union_op(int op) {
		union.set_op(op);
	}
}