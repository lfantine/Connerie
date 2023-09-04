#include <iostream>

int	main(int argc, char **argv) {

	if (argc < 2){
		std::cout << "Pas de nombre" << std::endl;
		return -1;
	}

	int	yes = 0;
	std::string line = argv[1];
	int result = 0;
	for (int i = 0; i < static_cast<int>(line.length()); i++){
		if (std::isdigit(argv[1][i])){
			yes = 1;
			result = argv[1][i++] - 48;
			while (i < static_cast<int>(line.length()) && std::isdigit(argv[1][i])){
				result *= 10;
				result += argv[1][i++] - 48;
			}
			break ;
		}
	}
	if (yes == 0){
		std::cout << "Pas de nombre" << std::endl;
		return -1;
	}
	std::cout << "nombre de dizaine : " << (result / 10) << std::endl;
	return 0;
}