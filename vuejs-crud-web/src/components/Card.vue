<template>
  <div class="row mb-5 mt-3 mr-3 ml-3">
    <div v-for="item in studentData" :key="item.id" class="p-3 col-4">
      <div class="card">
        <div class="card-body">
          <h2 class="card-title">{{ item.nama }}</h2>
          <h3 class="card-text"> test </h3>
          <h5>Email : xxxxxxxx</h5>
          <h5>Soft Skill : xxxxxxxx</h5>
          <h5>Hard Skill : xxxxxxxx</h5>
          <h5>Interest : xxxxxxxx</h5>
          <router-link to="/update" type="submit" class="btn btn-primary mt-3">Update</router-link>
          <router-link to="/delete" type="submit" class="btn btn-danger mt-3 ml-3">Delete</router-link>
        </div>

      </div>

    </div>

  </div>
</template>

<script>
import studentService from '@/services/studentService';

export default {
  name: 'CardComponents',
data() {
  return{
    studentData : null,
  }
},

methods : {
  viewStudent(){
    studentService.getAll()
    .then(response => {
      this.studentData = response.data;
      console.log(this.studentData);
    })
    .catch(e => {
      console.log(e);
    });
  }
},
mounted(){
  this.viewStudent();
},
}
</script>

<style>

</style>