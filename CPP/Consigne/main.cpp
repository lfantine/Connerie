#include "programme.hpp"


int	main(int argc, char **argv) {
	std::cout << std::endl << "Programme starting ! " << std::endl;
	if (argc != 2) {
		std::cout << "Il faut juste 1 argument soit le nujmero de l'exercice ..." << std::endl;
		std::cout << "Exemple : ./exercice.exe 1" << std::endl;
		std::cout << "Programme ending ! " << std::endl << std::endl;
		return -1;
	}
	std::string num = argv[1];
	if (num.length() > 1 || !std::isdigit(argv[1][0])){
		std::cout << "Please entre juste le chiffre de l'exercice stp ..." << std::endl;
		std::cout << "Exemple : ./exercice.exe 1" << std::endl;
		std::cout << "Programme ending ! " << std::endl << std::endl;
		return -1;
	}

	int	chiffre = std::atoi(argv[1]);
	Exercice *exos = new Exercice(chiffre);
	bool	running = true;
	std::string	in;

	while (running) {
		std::cout << "What you want to do ?\n\n >>> ";
		std::getline(std::cin, in);
		if (in == "HELP")
			std::cout << "\n\n- \"HELP\" show the commande\n- \"EXIT\" exit the programme\n- \"CONS\" show the consigne\n- \"HINT\" show the hint\n\n" << std::endl;
		else if (in == "EXIT") {
			std::cout << "\nExiting !\n" << std::endl;
			running = false;
		}
		else if (in == "CONS")
			exos->Consigne();
		else if (in == "HINT")
			exos->Hint();
		else
			std::cout << "\nCommande invalide\n" << std::endl;
		in = "";
	}

	delete exos;
	static_cast<void>(argv);
	std::cout << "Programme ending ! " << std::endl << std::endl;
	
	return 0;
}