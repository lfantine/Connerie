EXEC = exercice.exe
NAME = demo
CXX = g++
CC = c++
SRCS = main.cpp
INCS	=.
FLAGS = -Wall -Werror -Wextra -std=c++98
OBJS = $(SRCS:.cpp=.o)

ifeq ($(OS),Windows_NT)
all: $(EXEC)

$(EXEC): $(OBJS)
	@echo Compilation started ...
	@$(CXX) $(FLAGS) $(OBJS) -o $(EXEC)
	@echo Compilation finished !

%.o: %.cpp
	@$(CXX) $(FLAGS) -c $< -o $@

clean: 
	@echo delete : ${OBJS} ${EXEC}
	@del $(OBJS) $(EXEC)

re: clean all

else ifeq ($(shell uname -s),Darwin)
    # Règles spécifiques à macOS
all		: $(NAME)

${NAME}	: ${OBJS}
		clear
		@${CC} ${FLAGS} ${OBJS} -o ${NAME}

clean:
	@echo delete : ${OBJS}
	@rm -rf $(OBJS)

fclean: clean
	@echo delete : ${NAME}
	@rm -rf $(NAME)

re: fclean all

else
    $(error Système d'exploitation non pris en charge)
endif