#include <iostream>
#include <fstream>
#include <vector>
#include <string>

// YOU CURRENTLY NEED A PRE-CREATED TXT FILE THIS WILL NOT BE THE CASE UPON RELEASE

using namespace std;

// Function to display the menu and get user input for row and data
void displayMenu(int& selectedRow, string& newData) {
    cout << "1. Vitamin A\n";
    cout << "2. Vitamin B1\n";
    cout << "3. Vitamin B2\n";
    cout << "4. Vitamin B3\n";
    cout << "5. Vitamin B4\n";
    cout << "6. Vitamin B5\n";
    cout << "7. Vitamin B6\n";
    cout << "8. Vitamin B7\n";
    cout << "9. Vitamin B9\n";
    cout << "10. Vitamin B12\n";
    cout << "11. Vitamin C\n";
    cout << "12. Vitamin D\n";
    cout << "13. Vitamin E\n";
    cout << "14. Vitamin K\n";
    cout << "15. Calcium\n";
    cout << "16. Phosphorus\n";
    cout << "17. Magnesium\n";
    cout << "18. Iron\n";
    cout << "19. Zinc\n";
    cout << "20. Copper\n";
    cout << "21. Potassium\n";
    cout << "22. Sodium\n";
    cout << "23. Chloride\n";
    cout << "Select a number corresponding to desired nutrient to input: ";
    cin >> selectedRow;
    cin.ignore(); // Ignore newline character
    cout << "Enter data to append: ";
    getline(cin, newData);
}

// Function to append data to the selected row in a file
void appendToRow(int selectedRow, const string& newData) {
    ifstream inputFile("data.txt");
    vector<string> lines;
    string line;

    // Read all lines from the file
    while (getline(inputFile, line)) {
        lines.push_back(line);
    }
    inputFile.close();

    // Modify the selected row with the new data
    if (selectedRow > 0 && selectedRow <= lines.size()) {
        lines[selectedRow - 1] += ", " + newData; // Append newData to the existing row data
    } else {
        cerr << "Invalid row number!" << endl;
        return;
    }

    // Write modified lines back to the file
    ofstream outputFile("data.txt");
    for (const string& modifiedLine : lines) {
        outputFile << modifiedLine << endl;
    }
    outputFile.close();
}

int main() {
    int selectedRow;
    string newData;

    displayMenu(selectedRow, newData);
    appendToRow(selectedRow, newData);

    cout << "Data appended to row " << selectedRow << " successfully!" << endl;

    return 0;
}
