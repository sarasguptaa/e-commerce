<template>
    <div class="signup">
        <div>
            <ul>
                <li><div class="fdiv">Email:</div><input type="email" name="email" v-model="signupChild.emailAdd"></li><br>
                <li><div class="fdiv">Password:</div><input type="password" name="password" v-model="signupChild.password"></li><br>
                <li><div class="fdiv">First Name:</div><input type="text" name="firstName" v-model="signupChild.firstName"></li><br>
                <li><div class="fdiv">Last Name:</div><input type="text" name="lastName" v-model="signupChild.lastName"></li><br>
                <li><div class="fdiv">Phone:</div><input type="tel" name="phone" v-model="signupChild.phoneNumber"></li>

                <li><button @click="callSignup">Submit</button></li>
            </ul>
        </div>
    </div>
</template>

<script>
    import {mapActions} from 'vuex'
    export default {
        name: "SignUp.vue",
        data(){
            return {
                signupChild: {
                    firstName: null,
                    lastName: null,
                    emailAdd: null,
                    password: null,
                    phoneNumber: null
                }
            }
        },
        methods: {
            ...mapActions(['setSignupData']),
            signupSuccess(){

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
    ul{
        list-style: none;
    }
    input{
        text-align: right;
    }
    .fdiv{
        display: inline-block;
        width: 100px;
        text-align: left
    }
</style>