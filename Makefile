# in develop
CC            = gcc
CFLAGS        = -O0 -Wall -g
#CFLAGS        = -O4 -Wall 
DEST          = /usr/local/bin
LDFLAGS       = -L/usr/local/lib
LIBS          = 
OBJS          = ../main.o ../vm.o ../hash.o ../proc.o ../init.o ../debug.o
PROGRAM       = micro

JJ 			  = javac
JOBJS         = vm.java
ENCODE        = -J-Dfile.encoding=UTF8
#MAKE          = make
#MOBJ          = ./lib/Makefile

all:            $(PROGRAM)

$(PROGRAM):     $(OBJS)
	$(CC) $(OBJS) $(LDFLAGS) $(LIBS) -o $(PROGRAM)

main.o : ../main.c ../sample1.c
vm.o : vm.c ../vm.h
hash.o : ../hash.c ../hash.h
proc.o : ../proc.c ../proc.h ../vm.h
init.o : ../init.c
debug.o : ../debug.h ../vm.h

clean:
	rm -f *.o *~ $(PROGRAM)

java:	
	$(JJ) $(JOBJS) $(ENCODE)
	
#lib:	$(MOBJ)
#	$(MAKE) $(MOBJ)

#main.o : ../main.c ../sample1.c
#vm.o : vm.c ../vm.h
#hash.o : ../hash.c ../hash.h
#proc.o : ../proc.c ../proc.h ../vm.h
#init.o : ../init.c
#debug.o : ../debug.h ../vm.h
