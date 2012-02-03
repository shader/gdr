ARCH = 32bit
JFLAGS = -g -cp "lib/$(ARCH)/swt/swt.jar:."
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        GDR.java \
        Edge.java \
        Node.java \
        Graph.java \
	View.java \
	Reader.java

default: classes gdr

.PHONY: gdr
gdr: 
	echo "#! /bin/sh" > gdr
	echo 'java -cp "./lib/$(ARCH)/swt/swt.jar:." -Djava.library.path="swt" GDR $$*' >> gdr
	chmod +x gdr

classes: $(CLASSES:.java=.class)

32bit: classes gdr

64bit: ARCH = 64bit
64bit: classes gdr

.PHONY: clean
clean:
	$(RM) *.class

