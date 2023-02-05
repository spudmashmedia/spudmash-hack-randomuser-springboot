<script>
export default {
  props: ["user"],
  methods: {},
  mounted() {},
};
</script>
<template>
  <div class="flex flex-row bg-slate-700 rounded-md w-60 p-4 text-slate-100 drop-shadow-lg">
    <div v-if="!user" class="text-white">Loading...</div>
    <pre v-else>
        <img :src="user?.profileImageUrl" class="rounded-full w-44 m-2" />
        <div class="text-2xl font-bold">{{ user.firstName }} {{ user.lastName }}</div>
        <div class="text-sm">{{ user.email }}</div>
        <div>{{ user.country }}</div>
    </pre>
  </div>
</template>

<style scoped></style>
