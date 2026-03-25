<template>
  <div class="info-panel">
    <h2>{{ title }}</h2>

    <ul>
      <li v-for="(d, index) in decisions" :key="index">
        {{ d.action }}
      </li>
    </ul>

    <slot />
  </div>
</template>

<script setup>
defineProps({
  title: {
    type: String,
    default: "Information"
  },
  decisions: {
    type: Array,
    default: () => []
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

.info-panel {
  max-height: 750px;
  overflow-y: scroll;
}
</style>