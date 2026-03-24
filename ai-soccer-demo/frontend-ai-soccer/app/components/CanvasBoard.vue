<template>
  <canvas
    ref="canvasRef"
    :width="width"
    :height="height"
    class="canvas"
  />
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount, watch } from 'vue'

const props = defineProps({
  width: { type: Number, default: 800 },
  height: { type: Number, default: 1000 },
  newPlayerPosition: Object,
  moveRightTrigger: Number,
  moveVector: Object,
  game: Object
})

const canvasRef = ref(null)
let ctx = null
let animationId = null

let my_ball = null

const ball = {
  x: 100,
  y: 100,
  radius: 10,
  dx: 1,
  dy: 0
}

const players = []

function update() {
  ball.x += ball.dx
  ball.y += ball.dy

  if (ball.x + ball.radius > props.width || ball.x - ball.radius < 0) {
    ball.dx *= 0
  }

  if (ball.y + ball.radius > props.height || ball.y - ball.radius < 0) {
    ball.dy *= -1
  }
}

function drawBall() {
  ctx.beginPath()
  ctx.arc(ball.x, ball.y, 10, 0, Math.PI * 2)
  ctx.fillStyle = 'white'
  ctx.fill()
}

function drawMyBall() {
  if (!my_ball) return
  ctx.beginPath()
  ctx.arc(my_ball.position.x, my_ball.position.y, 10, 0, Math.PI * 2)
  ctx.fillStyle = 'white'
  ctx.fill()
}

function drawe_middle(){
  ctx.beginPath()           // Start new path
  ctx.moveTo(0, props.height/2)        // Starting point (x, y)
  ctx.lineTo(props.width, props.height/2)      // End point (x, y)
  ctx.strokeStyle = 'white'
  ctx.stroke()    
  ctx.strokeRect(300, 0, 200, 5);
}

function draw_player(player){
  ctx.beginPath()
  ctx.arc(player.position.x, player.position.y, 15, 0, Math.PI * 2)
  ctx.fillStyle = 'red'
  ctx.fill()
}

function loop() {
  ctx.clearRect(0, 0, props.width, props.height)
  update()
  drawBall()
  drawe_middle()
  drawMyBall()
  players.forEach(player => draw_player(player))

  animationId = requestAnimationFrame(loop)
}

onMounted(() => {
  const canvas = canvasRef.value
  ctx = canvas.getContext('2d')
  loop()
})

onBeforeUnmount(() => {
  cancelAnimationFrame(animationId)
})

watch(() => props.newPlayerPosition, (pos) => {
  if (!pos) return

  players.push({
    x: pos.x,
    y: pos.y,
    radius: 15
  })
})

watch(() => props.moveRightTrigger, () => {
  if (players.length === 0) return

  const player = players[0]
  player.x += 10
})

watch(() => props.moveVector, (vec) => { // NEW
  if (!vec) return                        // NEW
  if (players.length === 0) return        // NEW

  const player = players[0]               // NEW

  player.position.x += vec.dx                      // NEW
  player.position.y += vec.dy                      // NEW
})

watch(() => props.game, (my_game) => { 
  if (!my_game) return            
  my_ball = my_game.ball       
  const player = my_game.player
  if (players.length === 0){
    players.push(player)
  }else{
    players[0] = player
  }
})
</script>

<style scoped>
.canvas {
  border: 2px solid black;
  background: green;

}
</style>