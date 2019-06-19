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
                            <div class="fdiv">Email:</div>
                            <b-form-input type="email" name="email" :state="checkEmail" v-model="signupChild.emailAdd"/>
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">Password:</div>
                            <b-form-input id="popPassword" type="password" name="password" :state="checkPassword" v-model="signupChild.password"/>
                            <b-popover
                            target="popPassword"
                            placement="top"
                            triggers="focus"
                            content="8 to 20 characters which contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character"
                            ></b-popover>
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">Confirm Password:</div>
                            <b-form-input type="password" name="confirmpassword" :state="checkConfirmPassword" v-model="confirmPassword"/>
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">First Name:</div>
                            <b-form-input type="text" name="firstName" :state="checkFirstName" v-model="signupChild.firstName"/>
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">Last Name:</div>
                            <b-form-input type="text" name="lastName" :state="checkLastName" v-model="signupChild.lastName"/>
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">Phone:</div>
                            <b-form-input type="tel" name="phone" :state="checkPhoneNumber" v-model="signupChild.phoneNumber"/>
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
                confirmPassword: null,
                stateVar: {
                    firstName: null,
                    lastName: null,
                    emailAdd: null,
                    password: null,
                    phoneNumber: null,
                    confirmPassword: null
                }
            }
        },
        methods: {
            ...mapActions(['setSignupData']),
            signupSuccess(){
                this.$bvToast.toast("Signup Success!!",{
                    title: "Success Message",
                    toaster: "b-toaster-top-center",
                    solid: true
                })
                router.push({path: "/login"})
            },
            signupFailure(msg){
                this.$bvToast.toast(msg,{
                    title: "Error Message",
                    toaster: "b-toaster-top-center",
                    solid: true
                })
            },
            callSignup(){
                if(this.stateVar.firstName===true && this.stateVar.lastName===true && this.stateVar.emailAdd===true && this.stateVar.password===true  && this.stateVar.confirmPassword===true && this.stateVar.phoneNumber===true){
                    this.$store.dispatch('setSignupData', {
                        data: this.signupChild,
                        success: this.signupSuccess,
                        failure: this.signupFailure
                    })
                }
                else{
                    this.$bvToast.toast("Fill the form Properly!!",{
                        title: "Error Message",
                        toaster: "b-toaster-top-center",
                        solid: true
                    })
                }
            }
        },
        computed:{
            checkEmail(){
                if(this.signupChild.emailAdd === null)
                    return null
                else{
                    let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                    if(this.signupChild.emailAdd.match(mailformat)){
                        this.stateVar.emailAdd = true;
                        return true
                    }
                    else{
                        this.stateVar.emailAdd = false;
                        return false
                    }
                }
            },
            checkPassword(){
                if(this.signupChild.password === null)
                    return null
                else{
                    let decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
                    if(this.signupChild.password.match(decimal)){
                        this.stateVar.password = true;
                        return true
                    }
                    else{
                        this.stateVar.password = false;
                        return false
                    }
                }
            },
            checkConfirmPassword(){
                if(this.confirmPassword === null)
                    return null
                else{
                    if(this.confirmPassword===this.signupChild.password){
                        this.stateVar.confirmPassword = true;
                        return true
                    }
                    else{
                        this.stateVar.confirmPassword = false;
                        return false
                    }
                }
            },
            checkFirstName(){
                if(this.signupChild.firstName === null)
                    return null
                else{
                    if(this.signupChild.firstName!=""){
                        this.stateVar.firstName = true;
                        return true
                    }
                    else{
                        this.stateVar.firstName = false;
                        return false
                    }
                }
            },
            checkLastName(){
                if(this.signupChild.lastName === null)
                    return null
                else{
                    if(this.signupChild.lastName!=""){
                        this.stateVar.lastName = true;
                        return true
                    }
                    else{
                        this.stateVar.lastName = false;
                        return false
                    }
                }
            },
            checkPhoneNumber(){
                if(this.signupChild.phoneNumber === null)
                    return null
                else{
                    let phoneno = /^\d{10}$/;
                    if(this.signupChild.phoneNumber.match(phoneno)){
                        this.stateVar.phoneNumber = true;
                        return true
                    }
                    else{
                        this.stateVar.phoneNumber = false;
                        return false
                    }
                }
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
    outline: none!important;
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


textarea:focus,
input[type="text"]:focus,
input[type="password"]:focus,
input[type="datetime"]:focus,
input[type="datetime-local"]:focus,
input[type="date"]:focus,
input[type="month"]:focus,
input[type="time"]:focus,
input[type="week"]:focus,
input[type="number"]:focus,
input[type="email"]:focus,
input[type="url"]:focus,
input[type="search"]:focus,
input[type="tel"]:focus,
input[type="color"]:focus,
.uneditable-input:focus {   
  box-shadow: 0 1px 1px #ffffff inset, 0 0 8px #ffffff;
  outline: 0 none;
}
</style>