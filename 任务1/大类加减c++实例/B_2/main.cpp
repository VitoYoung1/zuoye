#include"yunsuan.h"
#include<iostream>
using namespace std;
int main()
{
	cout << "20173562  杨景智" << endl;
	cout << "请选择功能：" << endl;
	cout << "1 大数加法   2 大数减法" << endl;
	int k;
	do
	{
        cin >> k;
		if (k == 1)
		{
			cout << "请输入两个数:" << endl;
			string numplus(string num1, string num2);
			string num1, num2;
			cin >> num1 >> num2;
			cout << "两数之和为：" << endl;
			cout << numplus(num1, num2) << endl;
		}
		else if (k == 2)
		{
			cout << "请输入两个数:" << endl;
			string numminus(string num1, string num2);
			string num1, num2;
			cin >> num1 >> num2;
			cout << "两数之差为：" << endl;
			if (num1.size() >= num2.size())
			{
				cout << numminus(num1, num2) << endl;
			}
			else
			{
				cout<< "-"<< numminus(num1, num2) << endl;
			}
        }
	} while (k > 0 || k < 3);
}