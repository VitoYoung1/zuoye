#include"yunsuan.h"
#include <iostream>
#include <string>
using namespace std;

string numplus(string num1, string num2)
{
	if (num1.size()<num2.size())     //��num1�̶�Ϊλ���ϴ����
	{
		string temp = num1;
		num1 = num2;
		num2 = temp;
	}
	int length1 = num1.size(), length2 = num2.size();
	int flag = 0, a, b, sum;                         //flag�ǽ�λ���
	while (length1>0)                                //�ӵ�λ��ʼ�Ѷ�Ӧ��λ���
	{
		a = num1[length1 - 1] - '0';                //��ȡnum1��ǰλ������
		if (length2 > 0)                            //���num2��û����
			b = num2[length2 - 1] - '0';                //��ȡnum2��ǰλ������
		else
			b = 0;                                      //���num2�����ˣ�num2��Ӧλ�Ͼ�û����������
		sum = a + b + flag;                         //num1��num2��Ӧλ�ϵ�������ӣ��ټ��Ͻ�λλ
		if (sum >= 10)                              //���������������10���Ǿ���Ҫ��λ��
		{
			num1[length1 - 1] = '0' + sum % 10;     //�������֮�󣬵�ǰλӦ���Ƕ���
			flag = 1;                           //�ѽ�λ�����1
		}
		else
		{
			num1[length1 - 1] = '0' + sum;          //�������֮�󣬵�ǰλӦ���Ƕ���
			flag = 0;                               //�ѽ�λ�����0
		}
		length1--;                                  //���λ�ƶ�1λ
		length2--;                                  //���λ�ƶ�1λ
	}
	if (1 == flag)                                  //�����������Ӧλ�������ˣ���λλ��1��˵��λ��Ҫ����1��
		num1 = "1" + num1;
	return num1;
}

string numminus(string num1, string num2)
{
	if (num1.size() < num2.size())     //��num1�̶�Ϊλ���ϴ����
	{
		string temp = num1;
		num1 = num2;
		num2 = temp;
	}
		int overflow = 0;  //��λ��־
		int i, j;
		for (i = (num1.length() - 1), j = num2.length() - 1; i >= 0, j >= 0; i--, j--)
		{
			if ((num1[i] + overflow) < num2[j])
			{
				num1[i] = (num1[i] - '0') + overflow + 10 - (num2[j] - '0') + '0';
				overflow = -1;
			}
			else
			{
				num1[i] = (num1[i] - '0') - (num2[j] - '0') + '0';
				overflow = 0;
			}
		}
		while (i >= 0)
		{
			if ((num1[i] - '0' + overflow) < 0)
			{
				num1[i] = num2[i] + overflow + 10;
				overflow = -1;
			}
			else
			{
				num1[i] = num1[i];
			}
			i--;
		}
		return num1;
}