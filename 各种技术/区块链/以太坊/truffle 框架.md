### 测试

测试全部

`truffle test`

测试某个指定文件

`truffle test  ./test/Testxxx.js`

`truffle test  ./test/Testxxx.so`

测试代码  
```js
  const SaveEquipmentStorage = artifacts.require("SaveEquipmentStorage.sol");
  
  contract('SaveEquipmentStorage', (accounts) => {
    it('insert success', async () => {
      const equip = await SaveEquipmentStorage.deployed();
      await equip.insert("1", "EEEEEEE", "FFFFFF", "RRRRRR");
      let stat = await equip.searchrule.call("1");
      console.log(stat+"----");
    });
  
    it('insert success 2', async () => {
      const equip = await SaveEquipmentStorage.deployed();
      await equip.insert("2", "Ggggggg", "eeeeeee", "777777777");
      // 获取多个返回值
      let arr = await equip.search.call("1");
      console.log("----"+arr.esId);
    });
  
    it('add test', async () => {
      const equip = await SaveEquipmentStorage.deployed();
      let num = await equip.add.call();
      console.log("--"+num+"--");
      console.log("测试add");
    });
  });
```

  

- 获取部署的合约，三种方式：

  MyContract.deployed() 在CONTRACT()内只部署1次，再次调用则获得同一个实例

  MyContract.new() 每次调用重新部署一个，每次调用都获得不同实例

  MyContract.at(address) 获取已经存在的合约实例

- call()及合约操作

  在js测试文件里的call()不是Solidity里面的call()。

  合约的函数和状态变量分为“执行”和“查询”，使用call()表示“查询”。大部分情况下都是把合约看作js对象，按照正常情况调用。但是有几点：

  （1）查询状态变量，要加(), 如：instance.val()或者instance.val.call()

  （2）查询状态变量或者执行不修改状态变量的函数，用instance.xxxx.call()模式

  （3）合约函数instance.someFun()“执行”操作得不到合约执行结果的return返回，但真实执行了。使用instance.someFun.call()“查询”操作能得到合约执行结果的return返回，但是没有真正在合约里面执行过。
  
- 部署 truffle migrate --reset --network development

# geth 客户端

- 余额

  eth.getBalance(eth.accounts[0])

- 解锁 账户0 密码 10000秒 

  personal.unlockAccount(eth.accounts[0], "123456", 10000)

