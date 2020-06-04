# SSH 服务器免密登录快速配置

#使用 ssh-keygen 生成公钥和私钥
执行如下命令生成免密登录钥匙

> cd ~
> ~/ssh-keygen

命令执行过程中的交互直接三个回车即可

#将 ssh 公钥复制到目标服务器
执行如下命令:

# 默认端口 22

> ssh-copy-id -i .ssh/id_rsa.pub root@192.168.0.102

# 指定端口 59022

> ssh-copy-id -i .ssh/id_rsa.pub -p 59022 root@192.168.0.103

# 检测免密登录

执行如下命令:

免密登录成功则意味着上述设置生效

> ssh root@192.168.0.102
>
> ssh -p 59022 root@192.168.0.103



# 在多台虚拟机上同步文件,使用时直接  xsync  文件或文件夹名，即将该文件同步到其他服务器相同位置。

```bash
#!/bin/bash

#1 获取输入参数个数，如果没有参数，直接退出

pcount=$#

if((pcount==0)); then

echo no args;

exit;

fi


#2 获取文件名称

p1=$1

fname=`basename $p1`

echo fname=$fname


#3 获取上级目录到绝对路径

pdir=`cd -P $(dirname $p1); pwd`

echo pdir=$pdir

#4 获取当前用户名称

user=`whoami`


#5 循环
for ((hadoop=100; hadoop<=106; hadoop++)) ; 
do

        #echo $pdir/$fname $user@hadoop$host:$pdir
    
        echo --------------- hadoop$host ----------------
    
        rsync -rvl $pdir/$fname $user@hadoop$host:$pdir

done
```
