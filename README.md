
java micro mruby　　

# 著者

以下の者の修士研究です。

九州工業大学　情報工学府　情報システム専攻　機械情報分野　田中和明研究室  
2013年度　修士2年　佐藤　弾

# 研究題目

mrubyのJavaへの実装と評価に関する研究

# 概要

本研究は、mrubyをJava環境下で動作させるために、
Javaによる書き換えを行っています。
なお、足掛かりとして機能を整数のみに制限した
micro mrubyを使用しています。

* micro mruby (https://github.com/)

# 内容

+ root
	+ Makefileはmicro mrubyから持ってきてます
	+ 使用する際は、`make java`を行うとVMがUTF8でJavaコンパイルされます

+ lib
	+ Javaで書き換えた変数等を格納しています
	+ Makefileで`make`することで次のことが行われます
	1. 全てのJava fileがコンパイルされ、生成したclass fileを下層のlibに格納します
	2. 全てのJava fileをコンパイルし、class fileを現在のdirに生成します

+ コンパイル手順
	+ libの中を先に`make`します
	+ その後にrootで`make java`します

# 現状
lib内のfileは書き換えできています  
しかし、VM.javaに関しては書き換え途中です
