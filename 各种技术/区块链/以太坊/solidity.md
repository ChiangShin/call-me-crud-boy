### 整型

`int` / `uint` ：分别表示有符号和无符号的不同位数的整型变量。 支持关键字 `uint8` 到 `uint256`（无符号，从 8 位到 256 位）以及 `int8` 到 `int256`，以 `8` 位为步长递增。 `uint` 和 `int` 分别是 `uint256` 和 `int256` 的别名。

### 使用钱包转移金额

payable 关键字表示可以通过这个方法充值

this.balance 获取合约账户金额

```javascript
function pay() payable{

}
function getBalance() renturn(uint){
    return this.balance;
}
```

- #### 我们可以直接输入account.transfer(10 ether) 就代表给账户转账

  如果我们的函数里面没有任何操作，但是又payable属性，那么msg.value的之就会直接转移给合约账户

  ```javascript
  function transfer() payable{
   address account = 0x7876878;
   account.transfer(10 ether);
  }
  ```

- constant 关键字标志不能改变。0.5.0版本中被废弃在函数中使用

  view的作用和constant一模一样，可以读取状态变量但是不能改；pure则更为严格，pure修饰的函数不能改也不能读状态变量，否则编译通不过。

  ```javascript
  pragma solidity ^0.4.21;
  
  contract constantViewPure{
      string name;
      uint public age;
      
      function constantViewPure() public{
          name = "liushiming";
          age = 29;
      }
      
      function getAgeByConstant() public constant returns(uint){
          age += 1;  //声明为constant，在函数体中又试图去改变状态变量的值，编译会报warning, 但是可以通过
          return age;  // return 30, 但是！状态变量age的值不会改变，仍然为29！
      } 
      
      function getAgeByView() public view returns(uint){
          age += 1; //view和constant效果一致，编译会报warning，但是可以通过
          return age; // return 30，但是！状态变量age的值不会改变，仍然为29！
      }
      
      function getAgeByPure() public pure returns(uint){
          return age; //编译报错！pure比constant和view都要严格，pure完全禁止读写状态变量！
          return 1;
      }
  }
  ```

- 函数重载（参数数量不同，类型不同）

- 函数返回值

  ```javascript
  function t1() returns(uint){
      return 2;
  }
  // 返回值命名,直接给返回值赋值
  function t2() returns(uint aa){
      aa = 89;
  }
  // 以最后返回为准
  function t3() returns(uint aa){
      aa = 89;
      return 34;
  }
  //多返回值
  function t4() returns(uint aa，uint bb){
      aa = 89;
      bb = 6;
  }
  function t7() returns(uint aa，uint bb){
      return (3,34);
  }
  ```

