<template>
  <div>
    <Header></Header>
    <!-- <AddButton></AddButton> -->
    <Kotak></Kotak>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '../components/Header.vue'
// import AddButton from '../components/AddButton.vue'
import Kotak from '../components/Kotak.vue'
import Footer from '../components/Footer.vue'

export default {
    name: 'AddPage',
    components: {
    Header,
    // AddButton,
    Kotak,
    Footer
  }
}
</script>

<style>

</style>