# 10秒チャレンジゲームを作ろう


# スタート地点

index.html
```
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>timer</title>
</head>

<body>
    <div id="counter">00:000</div>
    <input type="button" value="start" id="btnStart">
    <input type="button" value="stop" id="btnStop">
    <input type="button" value="reset" id="btnReset">
    <script src="https://unpkg.com/dayjs@1.8.21/dayjs.min.js"></script>
    <script src="app.js"></script>
</body>

</html>
```

# タイマーを作る上で知るべき3つ

## 経過時間ミリ秒を出す

`let sDate = new Date();`

ちょっと待つ

```
let eDate = new Date();

let elapsedTimeMills = eDate - sDate;
console.log(elapsedTimeMills);

```

new Dateした時の値は1970年1月1日からの経過ミリ秒数、それの差分を使う
https://developer.mozilla.org/ja/docs/Web/JavaScript/Reference/Global_Objects/Date


## 経過時間ミリ秒 -> 00:000の形式にする

今日入れているこれはdate formatter

`<script src="https://unpkg.com/dayjs@1.8.21/dayjs.min.js"></script>`
https://github.com/iamkun/dayjs

`dayjs(new Date()).format("YYYY/MM/DD");`

`let sDate = new Date();`

ちょっと待つ

```
let eDate = new Date();

let elapsedTimeMills = eDate - sDate;
console.log(dayjs(elapsedTimeMills).format("ss:SSS"));

```

## 定期的に画面を更新

開始

```
let intervalId = setInterval(function () {
      console.log("called");
      
    }, 5000);
```

停止

```
clearInterval(intervalId);
```

## さあ今回は自分で実装してみよう 

step1 ボタンの制御以外

app.js

```
(function () {

  // data
  let startTime = 0;
  let elapsedTime = 0;
  let intervalId = 0;

  // set elements to variable
  const displayElement = undefined; //TODO
  const startBtnElement = undefined; //TODO
  const stopBtnElement = undefined; //TODO
  const resetBtnElement = undefined; //TODO

  // bind click event and defined function
  startBtnElement.addEventListener("",function(){}); // TODO
  stopBtnElement.addEventListener("",function(){}); // TODO
  resetBtnElement.addEventListener("",function(){}); // TODO

  // 初期描画のために
  render();

  // controller
  function start() {
      // TODO
      // startTimeにstart時刻をセット
　　　 // setIntervalで定期的な描画ロジックをコールしよう
      // - 経過時間を計算
      // - ビューを更新
  }

  // controller
  function stop() {
      // TODO
      // clearIntervalを呼ぶ
   
  }

  // controller
  function reset() {
     // TODO
     // データをリセット
     // 描画
  }

  // view
  function render() {
      renderCounter()
      renderBtns
  }

  // view
  function renderCounter() {
    　// 経過時間を画面に表示
  }

  // view
  function renderBtns() {
     // step2
  }

  // model
  function calcElapsedTimeMills() {
      // TODO
      // 経過時間を計算して返す
  }

})();


```

step2 マスクの制御を入れよう

```
  let maskStartTime = 5000;
  let maskEndTime = 15000;

```

step3 ボタンの制御を入れよう

```

  // ボタン制御用ステータス定数
  const STATUS_NOT_STARTED = 0;
  const STATUS_RUNNING = 1;
  const STATUS_FINISHED = 2;

  // ボタンの状態を保持する変数
  let status = STATUS_NOT_STARTED;

```


## 完成系

app.js

```
(function () {
  // constant
  const STATUS_NOT_STARTED = 0;
  const STATUS_RUNNING = 1;
  const STATUS_FINISHED = 2;

  // data
  let startTime = 0;
  let elapsedTimeMills = 0;
  let status = STATUS_NOT_STARTED;
  let intervalId = 0;
  let maskStartTime = 5000;
  let maskEndTime = 15000;

  // set elemetns to variable
  const displayElement = document.getElementById("counter");
  const startBtnElement = document.getElementById("btnStart");
  const stopBtnElement = document.getElementById("btnStop");
  const resetBtnElement = document.getElementById("btnReset");

  // bind Event to element
  startBtnElement.addEventListener("click", start);
  stopBtnElement.addEventListener("click", stop);
  resetBtnElement.addEventListener("click", reset);

  render();

  // controller
  function start() {
    startTime = new Date();
    status = STATUS_RUNNING;
    intervalId = setInterval(function () {
      calcElapsedTimeMills();
      renderCounter();
    }, 1);
    render();
  }

  // controller
  function stop() {
    clearInterval(intervalId);
    status = STATUS_FINISHED;
    render();
  }

  // controller
  function reset() {
    elapsedTime = 0;
    status = STATUS_NOT_STARTED;
    render();
  }

  // view
  function render() {
    renderCounter();
    renderBtns();
  }

  // view
  function renderCounter() {
    //Timer
    if (
      status == STATUS_RUNNING &&
      elapsedTimeMills > maskStartTime &&
      elapsedTimeMills < maskEndTime
    ) {
      displayElement.innerHTML = "??:???";
    } else {
      displayElement.innerHTML = dayjs(elapsedTimeMills).format("ss:SSS");
    }
  }

  // view
  function renderBtns() {
    startBtnElement.disabled =
      status === STATUS_RUNNING || status === STATUS_FINISHED;
    stopBtnElement.disabled = status !== STATUS_RUNNING;
    resetBtnElement.disabled = status !== STATUS_FINISHED;
  }

  // model
  function calcElapsedTimeMills() {
    elapsedTimeMills = new Date() - startTime;
  }
})();



```





