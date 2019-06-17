<template>
  <div class="search">
    <searchname :searchvar="searchvar"></searchname>
  </div>
</template>
<script>
import {mapActions} from 'vuex'
import {mapGetters} from 'vuex'
import searchname from '@/pages/searchname.vue'
export default {
    name: 'Search',
    components: {
        searchname
    },
    data(){
        return{
            searchvar: this.$route.params.searchvar
        }
    },
    methods:{
        ...mapActions(['callSearchResult']),
        searchSuccess(){

        },
        searchFailure(){

        }
    },
    computed:{
        ...mapGetters(['getSearchData'])
    },
    created(){
        if(this.searchvar!=='')
        {
            this.$store.dispatch('callSearchResult',{
                searchvar: this.searchvar,
                success: this.searchSuccess,
                failure: this.searchFailure
            })
        }
    }
}
</script>
