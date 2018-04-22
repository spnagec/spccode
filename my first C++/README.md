这是一个矩阵类，拥有多种处理方法，具体如下：
```
Matrix(int rows, int columns)//构造函数
Matrix(int rows, int columns, double values[])//构造函数，给对象赋值
Matrix(const Matrix & matrix2)//拷贝构造函数
int rl(int i, int j)//行列转换
Matrix getRow(int row)//取行
Matrix getColumn(int column)//取列
void print()//打印函数
Matrix operator + (const Matrix & matrix2)//重载符号+
Matrix operator - (const Matrix & matrix2)//重载符号-
Matrix operator + (double value)//重载符号+
Matrix operator - (double value)//重载符号-
Matrix operator * (const Matrix & matrix2)//重载符号*
Matrix operator * (double value)//重载符号*
Matrix max() const//取各列最大值若只有一行则取本行最大值
Matrix min() const//取各列最小值若只有一行则取本行最小值
Matrix sum() const//求各列元素的和若只有一行则求本行元素的和
Matrix pow(double exponent)//求各个元素的exponext次幂
Matrix exp()//求e的幂级
Matrix log()//求元素的ln
Matrix abs()//求元素绝对值
~Matrix()//析构函数
```
