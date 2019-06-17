<template>
  <div id="app">
    <navbar></navbar>
    <transition
        name="fade"
        mode="out-in"
      >
    <router-view/></transition>
    <footer class="footerCass">
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
export default {
  name: 'App',
  components: {
    Navbar
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: #EAEAEA;
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
