<template>
    <div class="card-body">
        <h5 class="card-title">Success!</h5>
        <p class="card-text" >Your Data Has Been {{ Judul }} !</p>
        <router-link to="/home" class="btn btn-primary">Close</router-link>
    </div>
</template>

<script>
export default {
name : 'SuccesComponent',
data() {
    return {
      Judul: null,
    };
  },
  methods: {
    ubahJudul() {
      let route = this.$route.fullPath;
      if (route === "/add") {
        this.Judul = "inputed";
      } else if (route === "/home"){
        this.Judul = " deleted";
      } else {
        this.Judul = "updated";
      }
    },
  },
  mounted() {
    this.ubahJudul();
  },
};
</script>

<style scoped>

</style>