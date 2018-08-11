# Movie_Review_Website
> 实训web项目，使用SSH框架的一个类豆瓣影评网站

### PS: 因为tomcat不允许访问本地绝对路径，故配置了路径映射。
* 需要找到本地tomcat安装目录下的conf文件夹中的server.xml文件（直接替换不保证不出问题）
* 加入github上的这个server.xml文件末尾的那个标签(绝对路径可自己设置):
>>		<Context path="/photo" docBase="D:\douban_images\" debug="0" reloadable="true" crossContext="true" />
