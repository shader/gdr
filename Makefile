JFLAGS = -g -cp "lib/swt/swt.jar:."
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

clean:
	$(RM) *.class
