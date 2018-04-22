#include"Matrix.h"
Matrix::Matrix(int rows, int columns)//constructor the value is 0
{
  this->rows = rows;
  this->columns = columns;
  value = new double[rows*columns];
  for(int i = 0;i < rows*columns;i++)
value[i] = 0;
}

Matrix::Matrix(int rows, int columns, double values[])//constructor the value is from user
{
  this->rows = rows;
  this->columns = columns;
  value = new double[rows*columns];
  for(int i = 0;i < rows*columns;i++)
value[i] = values[i];
}

Matrix::Matrix(const Matrix & matrix2)//copy constructor
{
  this->rows = matrix2.rows;
  this->columns = matrix2.columns;
  this->value = new double[matrix2.rows*matrix2.columns];
  for(int i = 0;i < rows*columns;i++)
this->value[i] = matrix2.value[i];
}

int Matrix::rl(int i, int j) const {
//swap rows and columns,make value[i]->value[rl(i,j)]
  return (i-1)*this->columns+j-1;
}

void Matrix::set(int row, int column, double value)//change the value
{
  this->value[(row-1)*this->columns+column-1] = value;
}

Matrix Matrix::getRow(int row)//get a row data from Matrix
{
  Matrix m(1,this->columns);
  m.columns = this->columns;
  for(int i = 0;i < this->columns;i++)
  m.value[i] = value[rl(row,i+1)];
  return m;
}

Matrix Matrix::getColumn(int column)//get a column data from Matrix
{
  Matrix m(this->rows,1);
  m.columns = 1;
  for(int i = 0;i < this->rows;i++)
  m.value[i] = value[rl(i+1,column)];
  return m;
}

void Matrix::print()//print the Matrix
{
  for(int i = 0;i < rows*columns;i++)
  {
    cout << "    " << value[i];//four spaces before every number
    if((i+1)%columns == 0)
      cout << endl;//go to the next row
  }
}

Matrix Matrix::operator + (const Matrix & matrix2) const//reload "+"
{
  Matrix m1 = *this;
//are two Matrixs available?
  if(m1.rows != matrix2.rows||m1.columns != matrix2.columns) 
  {
    cout << "your data is error" << endl;
    return *this;
  }
  for(int i = 0; i < rows; i++)
  {
    for(int j = 0; j < columns; j++)
    {
      m1.value[rl(i+1,j+1)] = m1.value[rl(i+1,j+1)] + matrix2.value[rl(i+1,j+1)];
    }
  }
  return m1;
}

Matrix Matrix::operator - (const Matrix & matrix2) const//reload "-"
{
  Matrix m1 = *this;
//are two Matrixs available?
  if(m1.rows != matrix2.rows||m1.columns != matrix2.columns)
  {
    cout << "your data is error" << endl;
    return *this;
  }
  for(int i = 0; i < rows; i++)
  {
    for(int j = 0; j < columns; j++)
    {
      m1.value[rl(i+1,j+1)] = m1.value[rl(i+1,j+1)] - matrix2.value[rl(i+1,j+1)];
    }
  }
  return m1;
}

Matrix Matrix::operator + (double value) const//reload "+" for a number
{
  Matrix m1 = *this;
  for(int i = 0; i < rows; i++)
  {
    for(int j = 0; j < columns; j++)
    {
      m1.value[rl(i+1,j+1)] = m1.value[rl(i+1,j+1)] + value;
    }
  }
  return m1;
}

Matrix Matrix::operator - (double value) const//reload"-"for a number
{
  Matrix m1 = *this;
  for(int i = 0; i < rows; i++)
  {
    for(int j = 0; j < columns; j++)
    {
      m1.value[rl(i+1,j+1)] = m1.value[rl(i+1,j+1)] - value;
    }
  }
  return m1;
}

Matrix Matrix::operator * (const Matrix & matrix2) const//reload"*"
{
  Matrix a = *this;
//are two Matrixs available?
  if(a.columns != matrix2.rows)
  {
  cout << "your data is error" << endl;
  return *this;
  }
  Matrix b(a.rows, matrix2.columns);
  for(int i = 0; i < b.rows; i++)
  {
    for(int j = 0; j < b.columns; j++)
    {
      double sum = 0;
      for(int k = 0; k < matrix2.rows; k++)
      {
        sum = sum + a.value[a.rl(i+1,k+1)] * matrix2.value[matrix2.rl(k+1,j+1)];
      }
      b.value[b.rl(i+1,j+1)] = sum;
    }
  }
  return b;
}

Matrix Matrix::operator * (double value) const//reload"*"
{
  Matrix a = *this;
  for(int i = 0; i < rows; i++)
  {
    for(int j = 0; j < columns; j++)
    {
      a.value[rl(i+1,j+1)] = a.value[rl(i+1,j+1)] * value;
    }
  }
  return a;
}

Matrix Matrix::max() const
{
  Matrix sim = *this;
  if(sim.rows == 1)
//get a max number
  {
    Matrix a(1, 1);
    a.value[rl(1, 1)] = sim.value[rl(1, 1)];
    for(int i = 0; i < sim.columns; i++)
    {
      if(a.value[0] < sim.value[i])
      a.value[0] = sim.value[i];
    }
    return a;
  }
  else
//get a row max number
  {
    Matrix b(1, sim.columns);
    for(int i = 0; i < sim.columns; i++)
    {
      b.value[rl(1, i+1)] = sim.value[rl(1, i+1)];
      for(int j = 0; j < sim.rows; j++)
      {
        if(b.value[rl(1,i+1)] < sim.value[rl(j+1,i+1)])
        b.value[rl(1,i+1)] = sim.value[rl(j+1,i+1)];
      }
    }
    return b;
  }
}

Matrix Matrix::min() const//get a row min number
{
  Matrix sim = *this;
  if(sim.rows == 1)
  {
    Matrix a(1, 1);
    a.value[rl(1, 1)] = sim.value[rl(1, 1)];
    for(int i = 0; i < sim.columns; i++)
    {
      if(a.value[0] > sim.value[i])
      a.value[0] = sim.value[i];
    }
    return a;
  }
  else
//get a row max number
  {
    Matrix b(1, sim.columns);
    for(int i = 0; i < sim.columns; i++)
    {
      b.value[rl(1, i+1)] = sim.value[rl(1, i+1)];
      for(int j = 0; j < sim.rows; j++)
      {
        if(b.value[rl(1,i+1)] > sim.value[rl(j+1,i+1)])
        b.value[rl(1,i+1)] = sim.value[rl(j+1,i+1)];
      }
    }
    return b;
  }
}

Matrix Matrix::sum() const
{
  Matrix sim = *this;
  if(sim.rows == 1)
  {
    Matrix a(1, 1);
    for(int i = 0; i < sim.columns; i++)
    {
      a.value[0] = a.value[0] + sim.value[i];
    }
    return a;
  }
  else
  {
    Matrix b(1, sim.columns);
    for(int i = 0; i < sim.columns; i++)
    {
      for(int j = 0; j < sim.rows; j++)
      {
        b.value[rl(1,i+1)] = b.value[rl(1,i+1)] + sim.value[rl(j+1,i+1)];
      }
    }
    return b;
  }
}

Matrix Matrix::pow(double exponent)
{
  Matrix sim = *this;
  for(int i = 0; i < sim.rows; i++)
  {
    for(int j = 0; j < sim.columns; j++)
    {
      sim.value[rl(i+1, j+1)] = usemath::pow(sim.value[rl(i+1, j+1)], exponent);
    }
  }
  return sim;
}

Matrix Matrix::exp()
{
  Matrix sim = *this;
  for(int i = 0; i < sim.rows; i++)
  {
    for(int j = 0; j < sim.columns; j++)
    {
      sim.value[rl(i+1, j+1)] = usemath::exp(sim.value[rl(i+1, j+1)]);
    }
  }
  return sim;
}

Matrix Matrix::log()
{
  Matrix sim = *this;
  for(int i = 0; i < sim.rows; i++)
  {
    for(int j = 0; j < sim.columns; j++)
    {
      sim.value[rl(i+1, j+1)] = usemath::log(sim.value[rl(i+1, j+1)]);
    }
  }
  return sim;
}

Matrix Matrix::abs()
{
  Matrix sim = *this;
  for(int i = 0; i < sim.rows; i++)
  {
    for(int j = 0; j < sim.columns; j++)
    {
      sim.value[rl(i+1, j+1)] = usemath::fabs(sim.value[rl(i+1, j+1)]);
    }
  }
  return sim;
}

Matrix::~Matrix()
{
  delete[] value;
}

Matrix read() { 
int rows; 
int columns; 
double values[1000]; 
cin >> rows >> columns; 
for (int i = 0; i < rows * columns; ++ i) { 
    cin >> values[i]; 
} 
Matrix matrix(rows, columns, values); 
return matrix; 
} 
 
int main() { 
Matrix matrix = read(); // calls copy constructor 
 
double exponent; 
cin >> exponent; 
 
matrix.print(); 
cout << endl; 
matrix.pow(exponent).print(); 
cout << endl; 
matrix.exp().print(); 
cout << endl; 
matrix.log().print(); 
cout << endl; 
matrix.abs().print(); 
cout << endl; 
}
