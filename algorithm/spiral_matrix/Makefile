title := SpiralMatrix

all: $(title).class

$(title).class: *.java
	javac *.java

again:
	javac *.java

run: $(title).class
	java $(title)

edit:
	emacs -nw $(title).java

clean:
	rm *.class
