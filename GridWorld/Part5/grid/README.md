# README文件 15331271申朋超

##

这是一些图的实现源代码，不过因为有了所给的源代码中有了Bounded类，所以我们只需要以它为模板改变数组的处理方式即可
### Part5 SparseBoundedGrid类

比较于BoundedGrid类我们只需要将其二维数组替换为
```
private LinkedList<OccupantInCol>[] StoreInRow;
```

然后再将后面方法中的处理方式稍加改动即可

还要加上```class OccupantInCol```类来表示列数

### Part5 SparseBoundedGrid2类

实现方式与上一个类相似不过我们此次用的类型是``` private Map<Location, E> occupantMap;```

处理方式相同并且无需加其他类来标识列数但是需要引入```import java.util.HashMap;
import java.util.Map;```

### Part5 UnboundedGrid2类

同上不过数据类型将MAP替换为二维数组，处理方式进行相应修改即可