<template>
    <div>
      <Header></Header>
      <!-- <BackButton></BackButton> -->
      <AddForm></AddForm>
      <SuccesForm class="d-none"></SuccesForm>
      <Footer></Footer>
    </div>
  </template>
  
  <script>
  import Header from '../components/Header.vue'
  // import BackButton from '../components/BackButton.vue'
  import AddForm from '../components/AddForm.vue'
  import SuccesForm from '../components/SuccesForm.vue'
  import Footer from '../components/Footer.vue'
  
  export default {
      name: 'UpdatePage',
      components: {
      Header,
      // BackButton,
      AddForm,
      SuccesForm,
      Footer
    }
  }
  </script>
  
  <style>
  
  </style>