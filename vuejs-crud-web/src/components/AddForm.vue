<template>
    <div>
        <div class="ml-4">
            <router-link to="/" class="btn btn-primary mt-3 mb-5" v-show="!succes">Back</router-link>
        </div>
        <div class="border border-primary p-5 mt-5 mb-5 rounded" style="width: fit-content; margin:auto">
        <form @submit.prevent="inputStudent" v-show="!success">
                <h3 class="text-center mb-5">Add Student</h3>
    
                <div class="form-row">
                    <div class="form-group col-md-6">
                    <label for="stdname">Student Name</label>
                    <input v-model="studentData.nama" type="text" class="form-control" id="stdname" placeholder="Enter name" required>
                    </div>
                    <div class="form-group col-md-6">
                    <label for="soft">Soft Skills</label>
                    <input v-model="studentData.soft_skill" type="text" class="form-control" id="soft" placeholder="Enter soft skills" required>
                    </div>
                </div>
    
                <div class="form-row">
                    <div class="form-group col-md-3">
                    <label for="age">Student Age</label>
                    <input v-model="studentData.umur" type="text" class="form-control" placeholder="Enter age" required>
                    </div>
                    <div class="form-group col-md-3">
                    <label for="gender">Gender</label>
                    <select v-model="studentData.jenis_kelamin" id="gender" class="form-control" required>
                        <option selected>  </option>
                        <option>Male</option>
                        <option>Female</option>
                    </select>
                    </div>
                    <div class="form-group col-md-6">
                    <label for="hard">Hard Skills</label>
                    <input v-model="studentData.hard_skill" type="text" class="form-control" id="hard" placeholder="Enter hard skill" required>
                    </div>
                </div>
    
                <div class="form-row">
                    <div class="form-group col-md-6">
                    <label for="inputEmail4">Student Email</label>
                    <input v-model="studentData.email" type="email" class="form-control" id="email" placeholder="Email" required>
                    </div>
                    <div class="form-group col-md-6">
                    <label for="interest">Interest</label>
                        <select v-model="studentData.interest" class="form-control" required>
                                <option selected>   </option>
                                <option value="Data Science">Data Science</option>
                                <option value="Network">Network</option>
                                <option value="Web Frontend">Web Frontend</option>
                                <option value="Web Backend">Web Backend</option>
                                <option value="Mobile Apps">Mobile Apps</option>
                        </select>
                    </div>
                </div>
    
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="self">Self Description</label>
                        <textarea v-model="studentData.deskripsi_diri" style="overflow: auto;" cols="55" rows="5" id="self" placeholder=" " required></textarea>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">{{ buttonValue }}</button> 
            </form>
                <SuccesForm v-show="success"></SuccesForm>
        </div>
    </div>
</template>

<script>
import studentService from '../services/studentService'
import SuccesForm from '../components/SuccesForm.vue'

export default {
    name: 'AddformComponents',
    components: {
        SuccesForm,
    },
    data(){
    return{
      studentData:{
          "deskripsi_diri": null,
          "email": null,
          "hard_skill": null,
          "interest": null,
          "jenis_kelamin": null,
          "nama": null,
          "soft_skill": null,
          "umur": null
      },
    success : false,
    buttonValue : "Submit"
  }
},
methods: {
        inputStudent() {
            let data = this.studentData;
            let id = this.$route.params.id;
            let route = this.$route.fullPath;
            if (route === "/add") {
                studentService.create(data)
                    .then((response) => {
                        console.log(response.data);
                        this.success = true;
                    })
                    .catch((e) => {
                        console.log(e);
                    });
            } else {
                studentService.updateStudent(id, data)
                    .then((response) => {
                        console.log(response.data);
                        this.success = true;
                    })
                    .catch((e) => {
                        console.log(e);
                    });
            }
        },
        updateGetId() {
            let id = this.$route.params.id;
            if (id > 0) {
                this.buttonValue = "Update";
            }
            studentService.updateGetId(id)
                .then((response) => {
                    this.studentData = response.data;
                    console.log(this.studentData);
                })
                .catch((e) => {
                    console.log(e);
                });
        },
    },
    mounted() {
        if ((this.$route.params.id > 0)) {
            this.updateGetId();
        }
    },
};
</script>

<style>

</style>