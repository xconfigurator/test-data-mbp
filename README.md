# 一个新的MyBatis-Plus脚手架
[参考视频](https://www.bilibili.com/video/BV19K4y1L7MT?p=65)  
这个视频里面讲了MyBatis-Plus自动配置原理。可以多听几遍！  
自动配置以下
- SqlSessionFactory  
- mapperLocations，有默认值(在MybatisPlusProperties.java中)  
    - classpath*:/mapper/**/*.xml  
    - classpath*是多个jar包中，只要在类路径下。  
- SqlSessionTemplate  


# 代码生成器
>添加依赖后，按照官网给出生成示例修改后运行即可。
0. [参考视频 TODO 50]()
1. [历史版本](https://www.mybatis-plus.com/guide/generator.html)
2. [3.5.1+](https://www.mybatis-plus.com/guide/generator-new.html)
```shell
FastAutoGenerator.create("url", "username", "password")
	.globalConfig(builder -> {
		builder.author("baomidou") // 设置作者
            .enableSwagger() // 开启 swagger 模式
			.fileOverride() // 覆盖已生成文件
			.outputDir("D://"); // 指定输出目录
	})
	.packageConfig(builder -> {
		builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
			.moduleName("system") // 设置父包模块名
            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://")); // 设置mapperXml生成路径
	})
	.strategyConfig(builder -> {
		builder.addInclude("t_simple") // 设置需要生成的表名
			.addTablePrefix("t_", "c_"); // 设置过滤表前缀
	})
	.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
	.execute();
```


# MybatisX
[MybatisX](https://baomidou.com/pages/ba5b24/#%E5%8A%9F%E8%83%BD)


# GitHub
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
