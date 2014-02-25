# in lib
JJ		= javac
OBJS	= *.java
OUTPUT	= ./

ENCODE	= -J-Dfile.encoding=UTF8
PROGRAM = lib

#OBJS	= DEFINE.java Micro_irep.java Micro_state.java Mrb_value.java 
#Opcode.java RClass.java RProc.java Wordcode.java

all:	$(PROGRAM)

$(PROGRAM):		$(OBJS)
	$(JJ) -d $(OUTPUT) $(OBJS) $(ENCODE)
	$(JJ) $(OBJS) $(ENCODE)

clean:
	rm -f *.class *~ 
