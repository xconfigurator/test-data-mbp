# 一个新的MyBatis-Plus脚手架
[参考视频](https://www.bilibili.com/video/BV19K4y1L7MT?p=65)  
这个视频里面讲了MyBatis-Plus自动配置原理。可以多听几遍！  
自动配置以下
- SqlSessionFactory  
- mapperLocations，有默认值(在MybatisPlusProperties.java中)  
    - classpath*:/mapper/**/*.xml  
    - classpath*是多个jar包中，只要在类路径下。  
- SqlSessionTemplate  


```shell
Quick setup — if you’ve done this kind of thing before
or	
git@github.com:xconfigurator/test-data-mbp.git
Get started by creating a new file or uploading an existing file. We recommend every repository include a README, LICENSE, and .gitignore.

…or create a new repository on the command line
echo "# test-data-mbp" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:xconfigurator/test-data-mbp.git
git push -u origin main
…or push an existing repository from the command line
git remote add origin git@github.com:xconfigurator/test-data-mbp.git
git branch -M main
git push -u origin main
…or import code from another repository
You can initialize this repository with code from a Subversion, Mercurial, or TFS project.

```

