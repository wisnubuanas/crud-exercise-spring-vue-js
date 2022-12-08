<template>
  <div class="ml-4">
    <!-- <button  type="submit" class="btn btn-primary mt-3 mb-5">Add Data</button>  -->
    <router-link to="/add" class="btn btn-primary mt-3 mb-5">Add Data</router-link>
  </div>
</template>

<script>
export default {
    name: 'AddComponents',
    props: {
    msg: String
  }
}
</script>

<style>

</style>