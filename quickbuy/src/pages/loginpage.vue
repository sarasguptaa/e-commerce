<template>
    <div class="loginpage">
        <b-container>
            <b-row>
                <b-col cols="3"></b-col>
                <b-col cols="6" class="card mainform">
                    <b-row align-h="center">
                        <h2>Login</h2>
                    </b-row>
                    <hr>
                    <b-row>
                        <b-col cols="12" style="text-align: center">
                            <div class="fdiv">Email:</div><input type="email" name="email" v-model="loginChild.emailAdd">
                        </b-col>
                    </b-row>
                    <br>
                    <b-row>
                        <b-col cols="12">
                            <div class="fdiv">Password:</div><input type="password" name="password" v-model="loginChild.password">
                        </b-col>
                    </b-row>
                    <hr>
                    <b-row>
                        <b-col cols="12">
                            <button @click="callLogin()">Submit</button>
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
import {mapGetters} from 'vuex'
export default {
    name: "loginpage",
    data(){
        return {
            loginChild: {
                emailAdd: null,
                password: null
            }
        }
    },
    methods: {
        ...mapActions(['setLoginData']),
        loginSuccess(){
            localStorage.setItem('mysession', JSON.stringify(getLoginData));
            alert("Login Success!")
        },
        loginFailure(msg){
            alert(msg)
        },
        callLogin(){
            this.$store.dispatch('setLoginData', {
                data: this.loginChild,
                success: this.loginSuccess,
                failure: this.loginFailure
            })
        }
    },
    computed: {
        ...mapGetters(['getLoginData'])
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