### 一、为什么需要这个标准？

以太坊是一个分布式的智能合约平台，可以分发代币(Token)。
 访问 [https://etherscan.io/tokens](https://link.jianshu.com?t=https%3A%2F%2Fetherscan.io%2Ftokens) 可以了解到，截止到发稿前以太坊上已有  **69254** 个代币的智能合约。
 如果这么多代币的标准不统一，对于其他人来查看代码是相当痛苦的，众筹的人也就没有办法来检查代币分发的是否合理，也没有办法做到多种钱包的兼容。

为了我们发布的Token被以太坊钱包支持，要求我们在实现代币的时候必须要遵守的协议，如指定代币名称、总量、实现代币交易函数等。

所以才推出了一种以太坊代币的标准：ERC20标准。

### 二、标准里包含了哪些内容？

ERC20标准实际上就是一个合约接口标准。

##### Method

###### 1、name

```tsx
function name() constant returns (string name) 
```

返回string类型的ERC20代币的名字，例如：StatusNetwork

###### 2、symbol

```tsx
function symbol() constant returns (string symbol)
```

返回string类型的ERC20代币的符号，也就是代币的简称，例如：SNT。

###### 3、decimals

```jsx
function decimals() constant returns (uint8 decimals)
```

支持几位小数点后几位。如果设置为3。也就是支持0.001表示。

###### 4、totalSupply

```jsx
function totalSupply() constant returns (uint256 totalSupply)
```

发行代币的总量，可以通过这个函数来获取。所有智能合约发行的代币总量是一定的，totalSupply必须设置初始值。如果不设置初始值，这个代币发行就说明有问题。

###### 5、balanceOf

```jsx
function balanceOf(address _owner) constant returns (uint256 balance)
```

输入地址，可以获取该地址代币的余额。

###### 6、transfer

```jsx
function transfer(address _to, uint256 _value) returns (bool success)
```

调用transfer函数将自己的token转账给_to地址，_value为转账个数

###### 7、approve



```jsx
function approve(address _spender, uint256 _value) returns (bool success)
```

批准_spender账户从自己的账户转移_value个token。可以分多次转移。

###### 8、transferFrom

```jsx
function transferFrom(address _from, address _to, uint256 _value) returns (bool success)
```

与approve搭配使用，approve批准之后，调用transferFrom函数来转移token。

###### 9、allowance

```jsx
function allowance(address _owner, address _spender) constant returns (uint256 remaining)
```

返回_spender还能提取token的个数。

###### 10、approve、transferFrom及allowance解释：

账户A有1000个ETH，想允许B账户随意调用100个ETH。A账户按照以下形式调用approve函数approve(B,100)。当B账户想用这100个ETH中的10个ETH给C账户时，则调用transferFrom(A, C, 10)。这时调用allowance(A, B)可以查看B账户还能够调用A账户多少个token。

##### Events

###### 11、Transfer

```csharp
event Transfer(address indexed _from, address indexed _to, uint256 _value)
```

当成功转移token时，一定要触发Transfer事件

###### 12、Approval

```csharp
event Approval(address indexed _owner, address indexed _spender, uint256 _value)
```

当调用approval函数成功时，一定要触发Approval事件

### 三、总结

如果想在以太坊上部署自己的合约，可以参考这个标准来实现相应的方法



作者：海阳之新
链接：https://www.jianshu.com/p/496f8ba43036
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

