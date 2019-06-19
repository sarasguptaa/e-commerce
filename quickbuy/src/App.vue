<template>
  <div id="app">
    <navbar></navbar>
    <transition
        name="fade"
        mode="out-in"
      >
    <router-view :key="$route.fullPath" /></transition>
    <footer class="footerCass" style="bottom: 0; position: absolute;width: 100%">
      <b-container>
        <b-row align-v="center" align-h="center" style="min-height: 7rem;">
          Conditions of Use | Privacy Notice | Interest-Based Ads <span style="color: #999!important;font-size:14px;margin-left:10px">&copy; Coviam Quickbuy</span>
        </b-row>
      </b-container>
    </footer>
  </div>
</template>

<script>
import Navbar from '@/components/Navbar.vue'
import { mapActions, mapGetters } from 'vuex';
export default {
  name: 'App',
  components: {
    Navbar
  },
  methods: {
    ...mapActions(['getCart','loginCheck'])
  },
  computed:{
    ...mapGetters(['getLoginData'])
  },
  created(){
    let temp=JSON.parse(localStorage.getItem('mysession'))
    this.$store.dispatch('loginCheck',temp)
    if(this.getLoginData){
      this.$store.dispatch('getCart',{
          data: this.getLoginData.userId,
          success: ()=>{},
          failure: ()=>{}
      })
    }
  }
}
</script>

<style>
html, body {
  height: 100%;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: #EAEAEA;
  min-height: 100%;
  position: relative;
  padding-bottom: 100px;
}
.fade-enter-active,
.fade-leave-active {
  transition-duration: 0.3s;
  transition-property: opacity;
  transition-timing-function: ease;
}

.fade-enter,
.fade-leave-active {
  opacity: 0
}
</style>
