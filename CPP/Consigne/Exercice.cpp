#include "Exercice.hpp"
#include <ctime>
#include <windows.h>


Exercice::Exercice(int level) {
	// std::cout << "Constructor called !" << std::endl;
	this->_level = level;
	this->_consigne1 = "\nExercice 1 :\nCreer un programme qui me print le nombre d'arguments et les arguments a la suite.\nExemple:\nInput: ./demo test encore\nOutput: 2 arguments test encore\n";
	this->_hint1 = "\nIndice 1 :\nUtilise int argc et char **argv\n";
	this->_consigne3 = "\nExercice 3 :\nCreer un programme dans lequel on rentre un string en input et on doit recuperer le nombre de dizaine du premier nombre dans le string.\nSi aucun nombre est present le programme print \"Pas de nombre\" dans la console.\nExemple: input \"**42*11*\" et output \"nombre de dizaine : 4\"\n";
	this->_hint3 = "\nIndice 3 :\nC'est le meme que on a fais sur JAVA demerde toi\n";


	this->_pasSet = "\nExercice pas encore fait oupsi ;)\n";
}

Exercice::~Exercice() {
	// std::cout << "Deconstructor called !" << std::endl;
}

void sleep_ms(unsigned int milliseconds) {
	clock_t start_time = clock();
	clock_t now_time = clock();
	// std::cout << "time start = " << start_time << " et now " << now_time << std::endl << "\r";
	while ( now_time - start_time < static_cast<long int>(milliseconds)) {
			// // Effacer la ligne précédente
			// CONSOLE_SCREEN_BUFFER_INFO csbi;
			// HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);
			// COORD cursorPosition;

			// GetConsoleScreenBufferInfo(console, &csbi);
			// cursorPosition.X = 0;
			// cursorPosition.Y = csbi.dwCursorPosition.Y - 1;
			// SetConsoleCursorPosition(console, cursorPosition);
			// std::cout << "time start = " << start_time << " et now " << now_time << std::endl << "\r";
		now_time = clock();
	}
}

void	Exercice::PrintRealist(std::string s, unsigned int speed) {
	for (int i = 0; i < static_cast<int>(s.length()); i++) {
		std::cout << s[i];
		if (i + 1 < static_cast<int>(s.length())) {
			sleep_ms(speed);
		}
	}
	sleep_ms(50);
	std::cout << std::endl;
}

void	Exercice::Consigne() {
	if (this->_level == 1)
		this->PrintRealist(this->_consigne1, 50);
	else if (this->_level == 2)
		this->PrintRealist(this->_pasSet, 50);
	else if (this->_level == 3)
		this->PrintRealist(this->_consigne3, 50);
	else
		this->PrintRealist(this->_pasSet, 50);
}

void	Exercice::Hint() {
	if (this->_level == 1)
		this->PrintRealist(this->_hint1, 50);
	else if (this->_level == 2)
		this->PrintRealist(this->_pasSet, 50);
	else if (this->_level == 3)
		this->PrintRealist(this->_hint3, 50);
	else
		this->PrintRealist(this->_pasSet, 50);
}