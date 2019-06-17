<template>
  <div class="about">
    <h1>This is an about page</h1>
    <sign-up></sign-up>
    <!--product></product-->
  </div>
</template>
<script>
import SignUp from "@/pages/SignUp.vue"
export default {
  name: 'About',
  components: {
    SignUp
  }
}
</script>
