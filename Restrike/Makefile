PROGRAM = Main

JAVAC = javac

EXE_EXT = .exe

JAVAC_FLAGS = -g

FILE= ./main.java \

default: $(PROGRAM)$(EXE_EXT)

$(PROGRAM)$(EXE_EXT):
	@ECHO compilation started :
	@ECHO ${FILE}
	${JAVAC} ${JAVAC_FLAGS} ${FILE}

clean:
	@del /s /q *.class

re: clean $(PROGRAM)$(EXE_EXT)

ree: re
	java main

.PHONY: default clean re