<script setup>
import { ref, onMounted, onUnmounted } from 'vue'

const newPlayerPosition = ref(null)
const moveRightTrigger = ref(0)
const moveVector = ref(null)
const game = ref(null)

let running = true

onMounted(() => {
  const poll = async () => {
    while (running) {
      try {
        const res = await $fetch('http://localhost:8080/api/game/state')
        game.value = res
      } catch (e) {
        console.error(e)
      }

      await new Promise(resolve => setTimeout(resolve, 750))
    }
  }

  poll()
})

onUnmounted(() => {
  running = false
})

function addPlayer() {
  newPlayerPosition.value = {
    x: 200,
    y: 150
  }
}

function moveRight() {
  moveRightTrigger.value++
}

async function movePlayerFromBackend() { // NEW
  try {
    const result = await $fetch('http://localhost:8080/api/test/move') // NEW

    moveVector.value = result // NEW (expected {dx, dy})

  } catch (error) {
    console.error("Backend error", error)
  }
}

async function initGame() { // NEW
  try {
    const result = await $fetch('http://localhost:8080/api/game/init') // NEW

    game.value = result // NEW (expected {dx, dy})

  } catch (error) {
    console.error("Backend error", error)
  }
}

async function startGame() { // NEW
  try {
    await $fetch('http://localhost:8080/api/game/start', {
      method: 'POST'
    })
  } catch (error) {
    console.error("Backend error", error)
  }
}
</script>

<template>
  <div>
    <AppHeader />

    <main class="layout">
      <div class="game-area">
        <div class="controls">
          <button @click="addPlayer">Add player</button>
          <button @click="moveRight">Move player right ➡️</button>
          <button @click="movePlayerFromBackend">Move player</button>
          <button @click="initGame">Init game</button>
          <button @click="startGame">Start game</button>
        </div>
        <ClientOnly>
          <CanvasBoard 
            :width="800" 
            :height="800"
            :newPlayerPosition="newPlayerPosition" 
            :moveRightTrigger="moveRightTrigger"
            :moveVector="moveVector"
            :game="game"
            />
        </ClientOnly>
      </div>

      <InfoPanel title="Game Info">
        <p>Welcome to the soccer game.</p>
        <p>Click on the field to interact.</p>
        <p>Score: 0 - 0</p>
      </InfoPanel>
    </main>
  </div>
</template>

<style>
.layout {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  gap: 20px;
  padding: 20px;
}

/* Prevent canvas container from expanding */
.game-area {
  flex: 0 0 auto;
}
</style>