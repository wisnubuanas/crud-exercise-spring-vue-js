<template>
    <div>
        <div class="ml-4">
            <router-link to="/add" class="btn btn-primary mt-3 mb-5" v-show="!succes">Add Data</router-link>
        </div>
        <div class="container-fluid">
                <div class="d-flex flex-wrap ml-5" style="width: fit-content; margin:auto">        
                    <tr v-for="(item) in studentData" :key="item.id" v-show="!succes">
                        <div class="card-body border border-primary rounded mt-2 m-2" style="width : 300px;">
                    
                            <h5>{{ item.nama  + "," + " " + item.umur + " " + "Years Old" }}</h5>
                            <p>{{ item.deskripsi_diri }}</p>
                            <tbody>
                                <tr class="d-flex flex-column ">
    
                                        <td class="p-1">{{ "Email           : " + item.email }}</td>
                                        <td class="p-1">{{ "Soft Skill      : " + item.soft_skill }}</td>
                                        <td class="p-1">{{ "Hard Skill      : " + item.hard_skill }}</td>
                                        <td class="p-1">{{ "Interest        : " + item.interest }}</td>
    
                                </tr>
                                <div class="d-flex justify-content-between">
                                    <div>
                                        <router-link :to="{ path: '/update/' + item.id }">
                                        <button class="btn btn-sm btn-primary mr-2 mt-2"> Update </button>
                                        </router-link>
                                        <router-link to="/"> 
                                            <button class="btn btn-sm btn-danger mr-2 mt-2" @click="deleteStudentFunc(item.id)">Delete</button>
                                        </router-link>
                                        <img class="male" v-if="item.jenis_kelamin == 'Male'" src="../assets/male.png">
                                        <img class="female" v-else-if="item.jenis_kelamin == 'Female'" src="../assets/female.png">
                                    </div>
                                </div>
                                <!-- <div>
                                    <td class="d-flex">
                                        <button class="btn btn-sm btn-primary mr-2 text-white mt-2" @click="$emit('updateStudentFunc', item)">Update</button>
                                        <button class="btn btn-sm btn-danger mr-2 text-white mt-2" @click="deleteStudentFunc(item.id)">Delete</button>
                                        <img class="male" v-if="item.jenis_kelamin == 'Male'" src="../assets/male.png">
                                        <img class="female" v-else-if="item.jenis_kelamin == 'Female'" src="../assets/female.png">
                                    </td>
                                </div> -->
    
                            </tbody>
                        </div>
                    </tr>
            </div>
            <SuccesForm v-show="succes"></SuccesForm>
        </div>

    </div>
  </template>
  
  <script>
  import studentService from "@/services/studentService"
  import SuccesForm from "./SuccesForm.vue";
  
  export default {
    name: 'KotakComponents',
    components: {
        SuccesForm,
    },
    data(){
        return{
            studentData : null,
            succes : false
        };
    },
      methods : {
          getStudent(){
              studentService.getAll()
                  .then(response => {
                      this.studentData = response.data;
                      console.log(this.studentData);
                  })
                  .catch(e => {
                      console.log(e);
                  });
          },
          deleteStudentFunc(id){
              if(confirm("Apakah anda yakin hapus?")){
                  studentService.deleteStudent(id)
                      .then(response => {
                          console.log(response.data);
                          this.succes = true;
                      })
                      .catch(e => {
                          console.log(e);
                      });
                //   location.reload();
              }else{
                  alert("Hapus dibatalkan!")
              }
          }
      },
      mounted(){
          this.getStudent();
      }
  }
  </script>
  
  <style>
  .male {
    margin-left : 70px;
    width : 30px;
    height : auto;
  }
  .female {
    margin-left: 70px;
    width : 20px;
    height : auto;
  }
  </style>