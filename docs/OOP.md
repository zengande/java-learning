# Java OOP
Java 面向对象编程

## 数据隐藏与封装
### 访问控制
1. 访问包

    Java 不直接支持包的访问控制，访问控制一般在类和类的成员这些层级完成。
    > 已经加载的包始终可以被同一个包中的代码访问。一个包在其他包中是否能访问，取决于这个包在宿主系统中的部署方式。
    > 例如：如果组成包的类文件存储在同一目录中，那么用户必须能访问这个目录和其中的文件才能访问包。
2. 访问类
   
   默认情况下，顶层类在定义它的包中可访问。但是如果顶层类声明为 public，那么在任何地方都能访问。
   
3. 访问成员
   
    类的成员在类的主体始终可访问。默认情况下，在定义这个类的包中也可以访问成员。这种默认访问登记一把叫做`包访问`（C# internal?）。

**类中成员的可访问性**
<table>
    <thead>
        <tr>
            <th rowspan="2">能否访问</th>
            <th colspan="4">成员可见性</th>
        </tr>
        <tr>
            <th>公开</th>
            <th>受保护</th>
            <th>默认</th>
            <th>私有</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>定义成员的类</td>
            <td>✅</td>
            <td>✅</td>
            <td>✅</td>
            <td>✅</td>
        </tr>
      <tr>
            <td>同一个包中的类</td>
            <td>✅</td>
            <td>✅</td>
            <td>✅</td>
            <td>❌</td>
        </tr>
      <tr>
            <td>不同包中的子类</td>
            <td>✅</td>
            <td>✅</td>
            <td>❌</td>
            <td>❌</td>
        </tr>
      <tr>
            <td>不同的包，也不是子类</td>
            <td>✅</td>
            <td>❌</td>
            <td>❌</td>
            <td>❌</td>
        </tr>
    </tbody>
</table>

**使用可见性修饰符的经验法则**
* 只使用 public 声明组成类的公开 API 的方法和常量。使用 public 声明的字段只能是常量和不能修改的对象，而且必须同时使用 final 声明。
* 使用 protected 声明大多数使用这个类的程序员不会用到的方法和字段，但在其他包中定义的子类可能会用到。
    
    > 使用 protected 声明的成员是类的公开 API 的一部分，必须为其编写文档，而且不能轻易修改。
* 如果字段和方法供类的内部实现细节使用，但是同一个包协作的类也要使用，那么就使用默认的包可见性。
* 使用 private 声明只在类的内部使用，在其他地方都要隐藏的方法和字段。
> 如果不确定该使用 protected、包还是 private 可见性，那么就先使用 private。

## 修饰符
**Java 修饰符（部分）**
<table>
    <tr>
        <th>修饰符</th>
        <th>用于</th>
        <th>意义</th>
    </tr>
    <tr>
        <td>default</td>
        <td>Method</td>
        <td>这个接口方法的实现是可选的。</td>
    </tr>
    <tr>
        <td rowspan="4">final</td>
        <td>Class</td>
        <td>不能创建这个类的子类（C# sealed）</td>
    </tr>
  	<tr>
  			<td>Field</td>
      	<td>这个字段的值不能改变。static final 修饰的字段是编译时常量</td>
  	</tr>
  	<tr>
  			<td>Method</td>
      	<td>不能覆盖这个方法</td>
  	</tr>
  	<tr>
  			<td>Variable</td>
      	<td>值不能改变的局部变量、方法参数或异常参数</td>
  	</tr>
  	<tr>
  			<td>native</td>
      	<td>Method</td>
      	<td>这个方法使用某种与平台无关的方法实现（经常使用 C）。没有提供主体。</td>
  	</tr>
  	<tr>
        <td rowspan="2">strictfp</td>
        <td>Class</td>
        <td>这个类中的所有方法都隐式声明为 strictfp</td>
    </tr>
  	<tr>
  			<td>Method</td>
      	<td>这个方法必须严格遵守 IEEE 754 标准的方式执行浮点运算。具体而言，所有的数值，包括中间结果，都要使用 IEEE float 或 double 类型表示，而且不能利用本地平台浮点格式或硬件提供的额外精度或取值范围。</td>
  	</tr>
  	<tr>
  			<td>synchronized</td>
  			<td>Method</td>
      	<td>这个方法对类或实例执行非原子操作，确保不能让两个线程同时修改类或实例。</td>
  	</tr>
  	<tr>
  			<td>transient</td>
  			<td>Field</td>
      	<td>这个字段不是对象持久化状态的一部分，因此不会随对象一起序列化，在对象序列化时使用。</td>
  	</tr>
  	<tr>
  			<td>volatile</td>
  			<td>Field</td>
      	<td>这个字段能被异步线程访问，因此必须对其做些特定的优化，这个修饰符有时可以替代 synchronized。</td>
  	</tr>
</table>