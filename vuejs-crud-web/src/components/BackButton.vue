<template>
    <div class="ml-4">
      <!-- <button type="submit" class="btn btn-primary mt-3 mb-5 ">Back</button>  -->
      <router-link to="/home" class="btn btn-primary mt-3 mb-5">Back</router-link>
    </div>
  </template>
  
  <script>
  export default {
      name: 'BackComponents',
      props: {
      msg: String
    }
  }
  </script>
  
  <style>
  
  </style>