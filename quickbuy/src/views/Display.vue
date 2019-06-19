<template>
  <div class="search">
    <displaycat :subcidvar="subcidvar" :subname="subname" :cname="cname"></displaycat>
  </div>
</template>
<script>
import displaycat from '@/pages/displaycat.vue'
export default {
    name: 'Display',
    components: {
        displaycat
    },
    data(){
        return{
            subcidvar: this.$route.params.subcidvar,
            subname: this.$route.params.subname,
            cname: this.$route.params.cname
        }
    },
    watch:{
        subcidvar: function(val){
            debugger
            this.$forceUpdate()
        }
    }
}
</script>
