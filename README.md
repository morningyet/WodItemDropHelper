# WodItemDropHelper 1.0.1   20190907

一个爬虫系统 用于爬取http://canto.world-of-dungeons.org 注册英雄下的战报,掉落信息<br/>
主要爬取登录页,战报列表页,战报物品生成页,英雄属性页和论坛掉落列表<br/>
解析出掉落列表与掉落统计库对比,并记录各项信息,最后生成可直接于游戏论坛发布的bbcode代码信息.<br/>

应用技术SpringBoot,HttpClint,Jsoup,Mabatis/Mysql 等<br/><br/>
使用方式:<br/>
<br/>pre0.1.安装idea,安装Mysql,记住自己的登入账户密码,推荐navicat测试数据库链接
<br/>pre0.2.mysql建库建表,建表语句在resources/sql下
<br/>pre0.3.application.yaml修改对应数据源链接方式
<br/>1.org.canto.crawler.commons.MySecret修改自己的账号密码
<br/>2.org.canto.crawler.commons.MyHero填入自己英雄的id和名称.目前最多6个.id是游戏里网址后面的session_hero_id=里的数字
<br/>3.org.canto.crawler.server.ItemsDropUpdateServer 复制物品掉落原始文件,修改46行到它的绝对路径;原始文件我放在resources/item路径下了
<br/>4.运行项目,控制台无报错的话,网址是127.0.0.1:8082
<br/>5.首次运行请点击  物品掉落信息  最新战报信息录入 两个链接
<br/>6.进入mysql看是否生成对应的原始数据表
<br/>7.点击start! 分析战报
<br/>8.填表获取对应地城的已经掉落物品列表
<br/>
<br/>After1.对于毕业地城的英雄没什么用
<br/>After2.有时候会报错NullException,因为服务器太卡了,重新运行一下什么的
<br/>After3.系统部署到公共服务器也没什么卵用,因为会查多号...所以自己玩自己的吧..
<br/>
<br/>Kite1.自动切换Mini
<br/>Kite2.自动清包
<br/>Kite3.自动地城加速...
<br/>







<br/>
生成掉落统计 eg.<br/>
<br/>
北京第三区交通委提醒您：<br/>
道路千万条，安全第一条。<br/>
行车不规范，亲人两行泪。<br/>
<br/>
来自十二光年外的Ezantoh智能小助手为您准确播报:<br/>
英雄名: [hero:爱故乡的夏ver 2.0]<br/>
最新一次统计的时间: [b]2019-09-05 12:02[/b]<br/>
<br/>
[size=17][b][*]脱帽，向亲王致敬！[/b][/size]<br/>
[item:雷鸣食人魔战锤] Lv1<br/>
[item:黑锋蛇舌] Lv2<br/>
[item:镀金绳鞋] Lv3<br/>
[item:卡杜亚之火] Lv4<br/>
:y:[item:麻醉剂] Lv4<br/>
[item:卡拉希雪兔皮毛] Lv5<br/>
[item:雪蓟] Lv5<br/>
[item:冷酷仙灵] Lv5<br/>
[item:哈里发的金苹果] Lv6<br/>
[item:塔米尔的安全手套] Lv7<br/>
[item:塔米尔的安全靴] Lv7<br/>
[item:皇家财富钱袋] Lv7<br/>
:y:[item:致塔米尔的信] Lv7<br/>

