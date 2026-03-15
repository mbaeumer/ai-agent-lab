<template>
  <aside class="panel">
    <h2 class="title">{{ title }}</h2>

    <div class="content">
      <slot />
    </div>
  </aside>
</template>

<script setup>
defineProps({
  title: {
    type: String,
    default: "Information"
  }
})
</script>

<style scoped>
.panel {
  width: 300px;
  background: #f3f4f6;
  border-left: 2px solid #ddd;
  padding: 20px;
}

.title {
  margin-top: 0;
}

.content {
  line-height: 1.6;
}
</style>