# gatling-boilerplate
Gatlingを使った性能試験シナリオを集めたBoilerplate

SBT pluginを利用しGatlingを実行します。

# Getting Started

## MacOSで動かす場合

[Java SE Development Kit 8 (JDK 8)](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) のインストールを行う。

`java -version` を実行して以下のように表示されればOKです。

```
java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
```

`brew install sbt` を実行します。

以下のように表示されたら成功しています。

```
Welcome to Scala 2.12.8 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_131).
Type in expressions for evaluation. Or try :help.
```

## JDKのバージョンについて

おそらく新しいJDKでも動作するとは思いますが、動作確認は行っておりません。

## プロジェクトを `git clone` する

```bash
git clone https://github.com/keitakn/gatling-boilerplate.git && cd gatling-boilerplate
```

## SBTを起動

```bash
sbt
```

## 全てのテストを実行します

```bash
gatling:test
```

## 特定のテストだけを実行します

```bash
gatling:testOnly computerdatabase.BasicSimulation
```

## テストの一覧を取得します

```bash
tasks gatling -v
```

# 参考資料
- [公式ドキュメント](https://gatling.io/docs/current/)

# 実行用サーバーの構築
それほど高スペックのサーバーは必要ないとは思いますが以下を参考にkernelパラメーターのチューニングを行っておいたほうが良いです。

https://gatling.io/docs/current/general/operations/#os-tuning
