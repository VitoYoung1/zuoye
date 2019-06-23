#include"yunsuan.h"
#include <iostream>
#include <string>
using namespace std;

string numplus(string num1, string num2)
{
	if (num1.size()<num2.size())     //把num1固定为位数较大的数
	{
		string temp = num1;
		num1 = num2;
		num2 = temp;
	}
	int length1 = num1.size(), length2 = num2.size();
	int flag = 0, a, b, sum;                         //flag是进位标记
	while (length1>0)                                //从低位开始把对应的位相加
	{
		a = num1[length1 - 1] - '0';                //获取num1当前位的数字
		if (length2 > 0)                            //如果num2还没加完
			b = num2[length2 - 1] - '0';                //获取num2当前位的数字
		else
			b = 0;                                      //如果num2加完了，num2对应位上就没有数来加了
		sum = a + b + flag;                         //num1与num2对应位上的数字相加，再加上进位位
		if (sum >= 10)                              //如果加起来大于于10，那就需要进位了
		{
			num1[length1 - 1] = '0' + sum % 10;     //计算加完之后，当前位应该是多少
			flag = 1;                           //把进位标记置1
		}
		else
		{
			num1[length1 - 1] = '0' + sum;          //计算加完之后，当前位应该是多少
			flag = 0;                               //把进位标记置0
		}
		length1--;                                  //向高位移动1位
		length2--;                                  //向高位移动1位
	}
	if (1 == flag)                                  //如果两个数对应位都加完了，进位位是1，说明位数要增加1了
		num1 = "1" + num1;
	return num1;
}

string numminus(string num1, string num2)
{
	if (num1.size() < num2.size())     //把num1固定为位数较大的数
	{
		string temp = num1;
		num1 = num2;
		num2 = temp;
	}
		int overflow = 0;  //借位标志
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