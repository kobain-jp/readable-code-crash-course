
### 一般的な名前を知る 3.1 - 3.6

メソッド名
https://qiita.com/KeithYokoma/items/2193cf79ba76563e3db6

クラス名
https://qiita.com/KeithYokoma/items/ee21fec6a3ebb5d1e9a8

### 名前以上のこと（副作用 or ユーザが期待していない動き）をしない　3.7

e.g

```
bad　userNameとpassworのマッチングのみならずsessionを作成している
boolean auth(String userName,String passwrod){
	//userNameとpasswordを照合
	//正しければsessionを作成する <-- authの名前以上のこと
}	

ok : createSessionは外に出す

if(auth(userName,password){
   createSession();
}


```

### 有名なオープンソースのリポジトリで自身が使った動詞や名詞を検索する

https://github.com/spring-projects/spring-boot
https://github.com/google/guava




