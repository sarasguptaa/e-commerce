<template>
  <div class="Products">
    <product :prodpid="prodpid"></product>
  </div>
</template>
<script>
import product from "@/pages/product.vue"
export default {
  name: 'Products',
  components: {
    product
  },
  data(){
      return{
          prodpid: this.$route.params.prodpid,
      }
  }
}
</script>
