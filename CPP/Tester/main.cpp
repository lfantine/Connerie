#include "programme.hpp"

bool	tester1() {

	int result = system("./EXECUTABLE/demo.exe test");

	if (result == 0)
		return true;
	else
		return false;
}

int	main(int argc, char **argv) {
	std::cout << std::endl << "Programme starting ! " << std::endl;
	if (argc != 2) {
		std::cout << "Il faut juste 1 argument soit le nujmero de l'exercice ..." << std::endl;
		std::cout << "Exemple : ./tester.exe 1" << std::endl;
		std::cout << "Programme ending ! " << std::endl << std::endl;
		return -1;
	}
	std::string num = argv[1];
	if (num.length() > 1 || !std::isdigit(argv[1][0])){
		std::cout << "Please entre juste le chiffre de l'exercice stp ..." << std::endl;
		std::cout << "Exemple : ./tester.exe 1" << std::endl;
		std::cout << "Programme ending ! " << std::endl << std::endl;
		return -1;
	}

	int	chiffre = std::atoi(argv[1]);
	// bool	result = false;

	if (chiffre == 1) {
		tester1();
	}

	static_cast<void>(argv);
	std::cout << "Programme ending ! " << std::endl << std::endl;
	
	return 0;
}