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
    // TODO 4 use summary variables or extract method for following condition 
    // 8.2 3.6
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

  // vie
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
