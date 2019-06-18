<template>
    <div class="signuppage">
        <b-container>
            <b-row>
                <b-col cols="3"></b-col>
                <b-col cols="6" class="card mainform">
                    <b-row align-h="center">
                        <h2>Signup</h2>
                    </b-row>
                    <hr>
                    <b-row>
                        <b-col cols="12" style="text-align: center">
                            <div class="fdiv">Email:</div><input type="email" name="email" v-model="signupChild.emailAdd">
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">Password:</div><input type="password" name="password" v-model="signupChild.password">
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">Confirm Password:</div><input type="password" name="confirmpassword" v-model="confirmPassword">
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">First Name:</div><input type="text" name="firstName" v-model="signupChild.firstName">
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">Last Name:</div><input type="text" name="lastName" v-model="signupChild.lastName">
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">Phone:</div><input type="tel" name="phone" v-model="signupChild.phoneNumber">
                        </b-col>
                    </b-row>
                    <hr>
                    <b-row>
                        <b-col cols="12">
                            <button @click="callSignup()">Submit</button>
                        </b-col>
                    </b-row>
                </b-col>
                <b-col cols="3"></b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import {mapActions} from 'vuex'
    import router from "../router"
    export default {
        name: "signuppage",
        data(){
            return {
                signupChild: {
                    firstName: null,
                    lastName: null,
                    emailAdd: null,
                    password: null,
                    phoneNumber: null
                },
                confirmPassword: null
            }
        },
        methods: {
            ...mapActions(['setSignupData']),
            signupSuccess(){
                alert("Signup Success!!");
                router.push({path: "/login"})
            },
            signupFailure(msg){
                alert(msg)
            },
            callSignup(){
                this.$store.dispatch('setSignupData', {
                    data: this.signupChild,
                    success: this.signupSuccess,
                    failure: this.signupFailure
                })
            }
        }
    }
</script>

<style scoped>
input{
    border: none;
    border-bottom: 2px solid #232f3e;
    width: 100%;
}
input:focus{
    outline: none;
}
.card{
    border: none;
    border-radius: 0;
    box-shadow: 0 4px 16px 0 rgba(0,0,0,0.1);
    height: auto;
}
.mainform{
    padding: 20px 20px;
    margin: 20px 0;
}
.fdiv{
    width: 80%;
    text-align: left;
    font-weight: bolder;
}
button {
  background-color: #ffffff; /* Green */
  border: none;
  color: #232f3e;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,0.2);
  border: 1px solid;
  border-color: #232f3e;
  font-weight: bold
}
button:hover{
    color: #ffffff;
    background-color: #232f3e;
    border: 1px solid;
    border-color: #232f3e;
}
</style>