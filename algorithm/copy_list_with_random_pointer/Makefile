title := CopyListWithRandomPointer

all: $(title).class

$(title).class: *.java
	javac *.java

again:
	javac *.java

run: $(title).class
	java $(title)

edit:
	vim $(title).java

clean:
	rm *.class
