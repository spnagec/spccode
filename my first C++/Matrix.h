#include<iostream>
namespace usemath {
#include <math.h>
}
using namespace std;
class Matrix
{
  private:
    int rows;
    int columns;
    double * value;


  public:
     Matrix(int rows, int columns);//constructor the value is 0
    Matrix(int rows, int columns, double values[]);//constructor the value is from user
    Matrix(const Matrix & matrix2);//copy constructor
    ~Matrix();


    int rl(int i, int j) const;
//swap rows and columns,make value[i]->value[rl(i,j)]
    void set(int row, int column, double value);//change the value
    Matrix getRow(int row);//get a row data from Matrix
    Matrix getColumn(int column);//get a column data from Matrix
    void print();//print the Matrix


    Matrix operator + (const Matrix & matrix2) const;//reload "+"
    Matrix operator - (const Matrix & matrix2) const;//reload "-"
    Matrix operator + (double value) const;//reload "+" for a number
    Matrix operator - (double value) const;//reload"-"for a number
    Matrix operator * (const Matrix & matrix2) const;//reload"*"
    Matrix operator * (double value) const;//reload"*"


    Matrix max() const;//get a max from every column,if Matrxi only has a column,get a max from row
    Matrix min() const;//get a min from every column,if Matrxi only has a column,get a min from row
    Matrix sum() const;//get a sum from every column,if Matrxi only has a column,get a sum from row


    Matrix pow(double exponent);//get pow(value[i],exponent)
    Matrix exp();//get exp(value[i])
    Matrix log();//get log(value[i])
    Matrix abs();//get abs(value[i])
};
