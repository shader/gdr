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

default: classes

classes: $(CLASSES:.java=.class)

32bit: classes

64bit: ARCH = 64bit
64bit: classes

clean:
	$(RM) *.class
