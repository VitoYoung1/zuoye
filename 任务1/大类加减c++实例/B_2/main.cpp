#include"yunsuan.h"
#include<iostream>
using namespace std;
int main()
{
	cout << "20173562  ���" << endl;
	cout << "��ѡ���ܣ�" << endl;
	cout << "1 �����ӷ�   2 ��������" << endl;
	int k;
	do
	{
        cin >> k;
		if (k == 1)
		{
			cout << "������������:" << endl;
			string numplus(string num1, string num2);
			string num1, num2;
			cin >> num1 >> num2;
			cout << "����֮��Ϊ��" << endl;
			cout << numplus(num1, num2) << endl;
		}
		else if (k == 2)
		{
			cout << "������������:" << endl;
			string numminus(string num1, string num2);
			string num1, num2;
			cin >> num1 >> num2;
			cout << "����֮��Ϊ��" << endl;
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