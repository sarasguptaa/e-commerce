<template>
  <div class="Products">
    <product :prodpid="prodpid" :searchvar="searchvar"></product>
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
          searchvar: this.$route.params.searchvar
      }
  }
}
</script>
