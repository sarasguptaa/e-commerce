<template>
    <div class="myNavBar">
        <div id="nav">
        <b-navbar toggleable="lg" class="navbarclass">
            <b-navbar-brand class="navItemsClass" to="/">QUICKBUY</b-navbar-brand>
        
            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
        
            <b-collapse id="nav-collapse" is-nav>
              <!--b-navbar-nav>
                <b-nav-item to="/"><span class="navItemsClass">Home</span></b-nav-item>
                <b-nav-item to="/about"><span class="navItemsClass">About</span></b-nav-item>
              </b-navbar-nav-->
                <b-nav-form class="mx-auto">
                    <b-input-group>
                        <b-dropdown slot="prepend" text="All" class="mySearchClass">
                            <b-dropdown-item v-for="(ele,index) in getCatData" :key="index">{{ele.cname}}</b-dropdown-item>
                            <b-dropdown-item to="/about">Action A</b-dropdown-item>
                          </b-dropdown>
                      <b-form-input size="sm" placeholder="Search" v-model="searchvar"></b-form-input>
                      <b-input-group-append>
                        <b-button size="sm" class="my-2 my-sm-0 mySearchClass" :to="'/search/'+ searchvar" @click="searchFunction()">Search</b-button>
                      </b-input-group-append>
                    </b-input-group>
                  </b-nav-form>
              <!-- Right aligned nav items -->
              <b-navbar-nav class="ml-auto">
                <b-nav-item-dropdown right>
                  <!-- Using 'button-content' slot -->
                  <template slot="button-content"><em>User</em></template>
                  <b-dropdown-item href="#">Profile</b-dropdown-item>
                  <b-dropdown-item href="#">Sign Out</b-dropdown-item>
                </b-nav-item-dropdown>
              </b-navbar-nav>
            </b-collapse>
          </b-navbar>
    </div>
    </div>
</template>

<script>
import {mapActions} from 'vuex'
import {mapGetters} from 'vuex'
export default {
    name: 'Navbar',
    data(){
        return{
            searchvar: ''
        }
    },
    methods: {
        ...mapActions(['callSearchResult','getAllCategories','getAllSubcategories']),
        searchSuccess(){

        },
        searchFailure(){

        },
        searchFunction(){
            if(this.searchvar!='')
            {
                this.$store.dispatch('callSearchResult', {
                    searchvar: this.searchvar,
                    success: this.searchSuccess,
                    failure: this.searchFailure
                });
            }
        }
    },
    computed: {
        ...mapGetters(['getSearchData','getCatData','getSubcatData'])
    },
    created(){
      this.$store.dispatch('getAllCategories', {
          success: this.searchSuccess,
          failure: this.searchFailure
      });
      this.$store.dispatch('getAllSubcategories', {
          success: this.searchSuccess,
          failure: this.searchFailure
      });
    }
}
</script>

<style scoped>
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
