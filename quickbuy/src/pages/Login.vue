<template>
    <div class="login">
        <div>
            <ul>
                <li><div class="fdiv">Email:</div><input type="email" name="email" v-model="loginChild.emailAdd"></li><br>
                <li><div class="fdiv">Password:</div><input type="password" name="password" v-model="loginChild.password"></li><br>
                <li><button @click="callLogin">Submit</button></li>
            </ul>
        </div>
    </div>
</template>

<script>
        import {mapActions} from 'vuex'
        import {mapGetters} from 'vuex'
        export default {
            name: "Login.vue",
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