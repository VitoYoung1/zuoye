#pragma once
#include <iostream>
#include <string>
using namespace std;
class plus
{
public:
	string num1;
	string num2;

    string numplus(string num1, string num2);
	plus(void);
	~plus(void);
};
class minus
{
public:
	string num1;
	string num2;

	string numminus(string num1, string num2);
	minus(void);
	~minus(void);
};