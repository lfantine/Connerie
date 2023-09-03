#pragma once
#include <iostream>

class Exercice
{
	private:
		std::string _consigne1;
		std::string _hint1;
		std::string _consigne3;
		std::string _hint3;

		std::string _pasSet;
		int		_level;

	public:
		Exercice(int level);
		~Exercice();

		void	PrintRealist(std::string s, unsigned int speed);
		void	Consigne();
		void	Hint();
};

#include "Exercice.cpp"