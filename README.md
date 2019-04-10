# gatling-boilerplate
Gatlingを使った性能試験シナリオを集めたBoilerplate

SBT pluginを利用しGatlingを実行します。

# Getting Started

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
