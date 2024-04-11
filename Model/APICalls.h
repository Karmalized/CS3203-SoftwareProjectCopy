#include <iostream>
using namespace std;

//based on the FDCID entered, this function calls the USDA API in the terminal and returns an array of floats containing the corresponding values in the food
float* getMicrosMacOS(int FDCID) {
    //add the name of the food to query
    string command = "curl https://api.nal.usda.gov/fdc/v1/food/" + to_string(FDCID) + "?format=abridged&nutrients=303?api_key=EJqqZ091EK4ClsyEODAyasD7GRmyhLmSlpyQ9wCw";
    //execute the curl command in console
    system(command.c_str());
    //get the response from the api
    float* x;
    return x;
}

