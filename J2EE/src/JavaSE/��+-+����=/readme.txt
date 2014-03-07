java实现国际程序的基本思路

	java程序的国际化思路是将程序中的标签,提示等信息放在资源文件中.程序需要支持的国家\语言环境.则必须提供对应的资源文件.资源文件是key-value对.
	每个资源文件中的key是不变的.但value则随不同国家\语言变化.


java程序的国际化主要通过如下3个类完成;
	+ java.util.ResourceBundle:  用于加载一个资源包
	+ java.util.Locale: 对应一个特定的国家/区域,语言环境
	+ java.text.MessageFormat: 用于将信息格式化
	为了实现程序的国际化,必须先提供程序所需要的资源文件,资源文件的内容是很多key-value对.其中key是程序使用的部分,而value则是程序界面的显示
	资源文件的命名可以有如下3种形式.
 		+ baseName_language_country.properties
 		+ baseName_language.properties
 		+ baseName.properties
	其中baseName是资源文件的基本名,用户可以自由定义,而language和country都不可随意变化,必须是java所支持的语言和国家.(java支持的国家和语言可以通过
Locale类的getAvailableLocale方法获取.)
