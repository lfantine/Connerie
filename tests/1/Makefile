PROGRAM = Main

JAVAC = javac

EXE_EXT = .exe

JAVAC_FLAGS = -g

FILE= ./Main.java \
	./Player.java \

default: $(PROGRAM)$(EXE_EXT)

$(PROGRAM)$(EXE_EXT):
	@ECHO compilation started :
	@ECHO ${FILE}
	${JAVAC} ${JAVAC_FLAGS} ${FILE}

clean:
	@del *.class


re: clean $(PROGRAM)$(EXE_EXT)

.PHONY: default clean re