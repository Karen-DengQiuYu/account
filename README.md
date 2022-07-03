# 记账系统

功能实现

4.4.1 查看账单

个人记账系统主要分为了左右两列。左边对应的是导航条，右边为主体部分。首页的主体部分主要是记录了今日的收入总数、今日的支出总数、今日的记录数量和最近的收支情况采用Echarts折线图和柱状图显示对应的收支。

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image002.jpg)

图4-17 查看近期的收支界面

用户查看个人账单，在页面上显示，显示类型、日期、项目、收入支出方式、金额、备注等信息。进行相应的操作，比如修改删除等。左侧可以点击全选按钮，点击左上角的删除，实现批量删除功能。可以通过选择分类方式和时间动态显示列表。点击下面的分页按钮实现分页查看账单。

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image004.jpg)

图4-18  查看账单列表界面



![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image006.jpg)

图4-19  查看账单列表界面



用户点击收支图导航条。通过折线图显示近期的收支情况，这里会统计近一周内的收支情况，图片横轴显示了日期，纵轴显示了该日期的收入支出总和。



![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image008.jpg)

图4-20  查看账单图表界面

用户点击分类图导航条。分类图显示了每一种分类，对应的金额。可以输入相应的日期显示目标时间段内的分类情况，这里的的分类图使用的是饼图的方式实现的。



 

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image010.jpg)

图4-21  查看账单分类图界面

用户点击收入图导航条。可以显示收入的情况，也可以通过输入相应的日期显示目标时间段内的收入情况，收入图使用的是折线图。

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image012.jpg)

图4-22  查看收入账单界面

用户点击支出图导航条。可以显示支出的情况，也可以通过输如相应的日期显示目标时间段内的收入情况，收入图使用的是折线图。

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image014.jpg)

图4-23  查看支出账单界面

4.4.2 管理收入

用户进行收入记录。选择对应的记账分类，如，工资、意外收入等。以及对应的支付账户，如，银行卡、微信等。

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image016.jpg)

图4-24  管理收入界面

 

4.4.3 管理支出



用户进行支出记录。选择对应的记账分类，如，餐饮、服饰等。以及对应的支付账户，如，银行卡、微信、花呗等。



![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image018.jpg)

图4-25 管理支出界面

4.4.4 预警提示

预警提示功能，设置一个消费阈值（设置预算值），如每个月娱乐分类不能超过1000元，一旦超过，会给出消息提示。



![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image020.jpg)

图4-26  预警提示界面



4.4.5 管理理财



输入名称，选择日期，输入金额，选择年利率，考虑到用户安全问题，这里的年利率支持手动输入，输入备注添加个人理财的备注信息。

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image022.jpg)

图4-27  管理理财界面

4.4.6 管理税务

输入名称，选择日期，这里可以点击添加按钮输入工资值，个人税会自动计算相应的值。考虑到用户安全问题，这里的个人税支持手动输入，输入备注添加个人理财。点击图表导航栏支持可以查看到个人税务的情况。

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image024.jpg)

图4-28  管理税务界面

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image026.jpg)

图4-29  管理税务界面



4.4.7 管理预算

点击添加可以添加预算以及预算值，列表显示预算点击显示会进入每个预算的图表显示，这里采用的是饼图的方式实现。

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image028.jpg)

图4-30 管理预算界面

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image030.jpg)

图4-31 预算管理界面

4.4.8 管理新闻

点击添加导航条，实现对新闻添加。调用的是百度富文本编辑器进行对新闻的新增。



![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image032.jpg)

图4-32 新闻添加界面

点击列表导航条出现新闻列表，在新闻的列表操作栏中点击相应的按钮实现对新闻进行相应的管理，如修改，删除等操作。可以点击左上角的复选框实现批量新闻删除

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image034.jpg)

图4-33 新闻列表界面

4.4.9 管理权限



一般指根据系统设置的安全规则或者安全策略。权限管理页面就是在管理对应的权限。在个人记账系统中主要是通过用户表和权限表的映射关系来改变权限。个人记账系统判断Session中用户中有权限管理。采用的是权限三张表：用户表、权限表、用户权限对应表。在左侧导航条中会出现权限管理。点击权限管理，右侧主体部分会出现权限管理的列表。管理员用户可以对每个用户的权限进行管理，添加对应的权限，如给root用户添加新闻管理权限。登录root账户，该账户就拥有了新闻管理的权限。

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image036.jpg)

图4-34 管理权限界面（管理员）

其他用户不拥有权限管理功能和新闻管理功能。

![img](file:////Users/karen/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image038.jpg)

图4-35 管理权限界面（用户）

4.5 本章小结

本章主要介绍了对个人记账系统的架构设计，功能具体设计，数据库具体实现，功能具体实现。