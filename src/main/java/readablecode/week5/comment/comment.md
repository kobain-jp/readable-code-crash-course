
StringBuilerのJavaDocから学び改善する

```
https://docs.oracle.com/javase/jp/7/api/java/lang/StringBuilder.html
>StringBuffer と互換性がある API を提供しますが、同期化は保証されません。
>StringBuilder のインスタンスは、複数のスレッドで使用するには安全ではありません。このような同期が必要な場合は、StringBuffer を使用することをお勧めします。
*読み手の立場にたって、StringBufferとの違いと利用時の注意点を記載している。

TODO 
以下はStringBuilderの引数なしコンストラクタですが、
特定の条件の場合にpublic StringBuilder(int capacity) を利用した方が良いです。
コメントにその情報を追記し、プログラマが効率的にStringBuilderを利用できるようにガイドしてください。

    /**
     * Constructs a string builder with no characters in it and an
     * initial capacity of 16 characters.
     * 文字を持たず、初期容量が 16 文字である文字列ビルダーを構築します
     */
    public StringBuilder() {
        super(16);
    }

なぜ初期容量を16にしたのでしょうか？それはコメントがないから誰もわからないですね。
5.2 の観点のようにコメントしてくれればよかったのに。。。

```




