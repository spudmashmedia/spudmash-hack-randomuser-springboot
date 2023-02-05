<script>
import UserCard from './UserCard.vue';
const API_URL = `http://localhost:3001`;

export default {
  components: { UserCard },
  data: () => ({
    users: null,
    info: null,
    error: null,
  }),
  methods: {
    async fetchData() {
      const url = `${API_URL}/user?count=100`;
      let res = await (await fetch(url)).json();
      this.users = res?.data;
      this.error = res?.error;
    },
  },
  mounted() {
    this.fetchData();
  },
};
</script>
<template>
  <div class="m-8">
    <div></div>
    <div v-if="!users">Loading...</div>
    <pre v-else>
        <ul class="flex flex-row-2 flex-wrap gap-10">
            <li v-for="user in this.users" :key="user?.id">
                <user-card :user="user" />
            </li>
        </ul>
    </pre>
  </div>
</template>

<style scoped>
.text {
  color: white;
}
</style>
