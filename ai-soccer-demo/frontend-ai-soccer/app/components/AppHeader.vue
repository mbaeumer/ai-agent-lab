<template>
  <header class="header">
    <nav class="nav">
      <NuxtLink to="/" class="logo">⚽ Soccer Game</NuxtLink>

      <div class="links">
        <NuxtLink to="/">Home</NuxtLink>
        <NuxtLink to="/game">Game</NuxtLink>
        <NuxtLink to="/about">About</NuxtLink>
      </div>
    </nav>
  </header>
</template>

<style scoped>
.header {
  background: #1f2937;
  padding: 16px 24px;
  color: white;
}

.nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  font-weight: bold;
  font-size: 20px;
  text-decoration: none;
  color: white;
}

.links {
  display: flex;
  gap: 20px;
}

.links a {
  color: white;
  text-decoration: none;
}

.links a:hover {
  text-decoration: underline;
}
</style>