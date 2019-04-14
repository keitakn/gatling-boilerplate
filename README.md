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

# サンプルシナリオ

## computerdatabase.BasicSimulation

[公式](https://github.com/gatling/gatling-sbt-plugin-demo) にあるサンプルシナリオそのままです。

## computerdatabase.ComputerWorld

[公式](https://github.com/gatling/gatling-sbt-plugin-demo) にあるサンプルシナリオそのままです。

## qiita.FetchUsersItemsSimulation

```bash
gatling:testOnly qiita.FetchUsersItemsSimulation
```

概要は下記の通りです。

1. `src/test/resources/qiita/users.csv` からQiitaのユーザー情報を取得
1. `/api/v2/users/:user_id` にリクエストを送信しレスポンスのユーザーIDを変数に格納
1. 2の返り値のユーザーIDを使って `/api/v2/users/:user_id/items` にリクエストを送信する

一見無駄な処理ですが、APIの返り値を利用し次のAPIリクエストを行うケースのサンプルとして作成しました。

実際にQiitaのAPIにリクエストを送る事になるので無闇に多数のリクエストを送る行為は避けて下さい。

`QIITA_ACCESS_TOKEN` が存在する場合、QiitaAPIへのリクエスト時にリクエストヘッダーに追加します。

[direnv](https://github.com/direnv/direnv) 等を使って環境変数を設定すると良いでしょう。

# 参考資料
- [公式ドキュメント](https://gatling.io/docs/current/)

# コーディング規約
- [Effective Scala](http://twitter.github.io/effectivescala/index-ja.html)

`Scalafmt` が利用出来るのでそちらを利用するのが良いでしょう。

`scalafmtAll` を実行してください。

その他の操作に関しては [こちら](https://scalameta.org/scalafmt/docs/installation.html) を参照して下さい。

# 実行用サーバーの構築
それほど高スペックのサーバーは必要ないとは思いますが以下を参考にkernelパラメーターのチューニングを行っておいたほうが良いです。

https://gatling.io/docs/current/general/operations/#os-tuning
