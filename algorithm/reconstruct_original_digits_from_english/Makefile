name = ReconstructOriginalDigitsFromEnglish

flags = -Xlint:unchecked

target: all

all: $(name).class
	javac $(flags) $(name).java

edit:
	vim $(name).java

again:
	javac $(flags) $(name).java

run: $(name).class
	java $(name)
