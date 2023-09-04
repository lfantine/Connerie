#include "programme.hpp"
#include <fstream>


void	tester1() {

	// Définissez le nom de l'exécutable que vous souhaitez exécuter
	const char* test1 = "demo.exe";
	const char* test2 = "demo.exe test";
	const char* test3 = "demo.exe test test2";

	// Définissez le nom du fichier de sortie
	const char* outputFileName = "output.txt";

	// Utilisez la fonction sprintf() pour créer la commande avec redirection
	char command[256];
	snprintf(command, sizeof(command), "%s > %s", test1, outputFileName);
	system(command);

	snprintf(command, sizeof(command), "%s >> %s", test2, outputFileName);
	system(command);

	snprintf(command, sizeof(command), "%s >> %s", test3, outputFileName);
	system(command);


	std::ifstream outfile(outputFileName);
	std::string ligne;
	int	lineNb = 0;

	while (std::getline(outfile, ligne)) {
      	// std::cout << "|" << ligne << "|" << std::endl;
		if (lineNb == 0){
			if (ligne == "1 arguments")
				std::cout << "TEST 1 : O" << std::endl;
			else
				std::cout << "TEST 1 : N" << std::endl;
		}
		if (lineNb == 1){
			if (ligne == "2 arguments test")
				std::cout << "TEST 2 : O" << std::endl;
			else
				std::cout << "TEST 2 : N" << std::endl;
		}
		if (lineNb == 2){
			if (ligne == "3 arguments test test2")
				std::cout << "TEST 3 : O" << std::endl;
			else
				std::cout << "TEST 3 : N" << std::endl;
		}
		lineNb++;
    	}
	outfile.close();
	if (remove(outputFileName) == 0) {
      //   std::cout << "Le fichier a ete supprime avec succes." << std::endl;
	} else {
		std::cerr << "Erreur lors de la suppression du fichier." << std::endl;
	}
}

void	tester3() {

	// Définissez le nom de l'exécutable que vous souhaitez exécuter
	const char* test1 = "demo.exe";
	const char* test2 = "demo.exe **42*11";
	const char* test3 = "demo.exe blabal1111l9";
	const char* test4 = "demo.exe nochiffre";

	// Définissez le nom du fichier de sortie
	const char* outputFileName = "output.txt";

	// Utilisez la fonction sprintf() pour créer la commande avec redirection
	char command[256];
	snprintf(command, sizeof(command), "%s > %s", test1, outputFileName);
	system(command);

	snprintf(command, sizeof(command), "%s >> %s", test2, outputFileName);
	system(command);

	snprintf(command, sizeof(command), "%s >> %s", test3, outputFileName);
	system(command);

	snprintf(command, sizeof(command), "%s >> %s", test4, outputFileName);
	system(command);


	std::ifstream outfile(outputFileName);
	std::string ligne;
	int	lineNb = 0;

	while (std::getline(outfile, ligne)) {
      	// std::cout << "|" << ligne << "|" << std::endl;
		if (lineNb == 0){
			if (ligne == "Pas de nombre")
				std::cout << "TEST 1 : O" << std::endl;
			else
				std::cout << "TEST 1 : N" << std::endl;
		}
		if (lineNb == 1){
			if (ligne == "nombre de dizaine : 4")
				std::cout << "TEST 2 : O" << std::endl;
			else
				std::cout << "TEST 2 : N" << std::endl;
		}
		if (lineNb == 2){
			if (ligne == "nombre de dizaine : 111")
				std::cout << "TEST 3 : O" << std::endl;
			else
				std::cout << "TEST 3 : N" << std::endl;
		}
		if (lineNb == 3){
			if (ligne == "Pas de nombre")
				std::cout << "TEST 4 : O" << std::endl;
			else
				std::cout << "TEST 4 : N" << std::endl;
		}
		lineNb++;
    	}
	outfile.close();
	if (remove(outputFileName) == 0) {
      //   std::cout << "Le fichier a ete supprime avec succes." << std::endl;
	} else {
		std::cerr << "Erreur lors de la suppression du fichier." << std::endl;
	}
}

int	main(int argc, char **argv) {
	std::cout << std::endl << "Programme starting ! " << std::endl << std::endl;
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
		std::cout << "Launch test 1 ! " << std::endl;
		tester1();
	} else if (chiffre == 3) {
		std::cout << "Launch test 3 ! " << std::endl;
		tester3();
	}
	else {
		std::cout << "pas de test disponible  ! " << std::endl;
	}

	static_cast<void>(argv);
	std::cout << std::endl << "Programme ending ! " << std::endl << std::endl;
	
	return 0;
}