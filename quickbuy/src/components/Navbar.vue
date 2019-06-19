<template>
    <div class="myNavBar">
        <div id="nav">
        <b-navbar toggleable="lg" class="navbarclass">
            <b-navbar-brand class="navItemsClass" to="/"><img src="@/img/logo1.png" alt="logo"></b-navbar-brand>
        
            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
        
            <b-collapse id="nav-collapse" is-nav>
                <b-nav-form class="mx-auto" onkeypress="return event.keyCode != 13">
                    <b-input-group>
                        <b-dropdown slot="prepend" text="All" class="mySearchClass">
                          <span >
                            <b-dropdown-group v-for="(ele,index) in getNavbarData" :key="index" :id="ele.cname" :header="ele.cname">
                                <b-dropdown-item-button v-for="(element,ind) in ele.subname" :key="ind" @click="gotoCatDisplay(ele.cname, element, ele.subcid[ind])">{{element}}</b-dropdown-item-button>
                            </b-dropdown-group>
                          </span>
                        </b-dropdown>
                      <b-form-input size="sm" placeholder="Search" v-model="searchvar" @keyup.enter="searchFunction()"></b-form-input>
                      <b-input-group-append>
                        <b-button size="sm" class="my-2 my-sm-0 mySearchClass" @click="searchFunction()">    <font-awesome-icon icon="search" /></b-button>
                      </b-input-group-append>
                    </b-input-group>
                  </b-nav-form>
              <b-navbar-nav class="ml-auto">
                <b-nav-item v-if="getLoginData" style="font-size:30px; font-weight: bold">
                  <span class="navItemsClass">
                    <b-dropdown style="margin-bottom: 4px;" :text="getLoginData.firstName">
                        <b-dropdown-item-button @click="orderhistoryFunction()" style="font-size:17px; font-weight: bold">
                          <font-awesome-icon icon="clipboard" /> Order History
                        </b-dropdown-item-button>
                        <b-dropdown-item-button @click="logoutFunction()" style="font-size:17px; font-weight: bold">
                          <font-awesome-icon icon="sign-out-alt" /> Logout
                        </b-dropdown-item-button>
                    </b-dropdown>
                  </span>
                </b-nav-item>

                <b-nav-item v-if="!getLoginData" style="font-size:30px" to="/login"><span class="navItemsClass"><font-awesome-icon icon="user" /></span></b-nav-item>
                <b-nav-item style="font-size:30px" to="/cart">
                  <span class="navItemsClass">
                      <font-awesome-layers>
                        <font-awesome-icon icon="shopping-cart" />
                        <font-awesome-layers-text v-if="getLoginData"
                          class="text-white fa-layers-counter" style="top:33px; right:15px; transform: scale(.4); background-color:#232f3e"
                          transform=" up-1 right-2">{{getCartData.productClassList.length}}</font-awesome-layers-text>
                      </font-awesome-layers>
                  </span>
                </b-nav-item>
              </b-navbar-nav>
            </b-collapse>
          </b-navbar>
    </div>
    </div>
</template>

<script>
import {mapActions} from 'vuex'
import {mapGetters} from 'vuex'
import router from '../router'
export default {
    name: 'Navbar',
    data(){
        return{
            searchvar: ''
        }
    },
    methods: {
        ...mapActions(['callSearchResult','getAllRecords',"updateUserId","emptyCart"]),
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
                router.push({path: '/search/'+this.searchvar})
            }
        },
        logoutFunction(){
          localStorage.clear('mysession');
          this.$store.dispatch('updateUserId',"");
          this.$store.dispatch('emptyCart');
          router.push({path:"/"});
          this.$router.go()
          //location.reload()
        },
        orderhistoryFunction(){
          router.push({path:"/user/orderhistory"})
        },
        gotoCatDisplay(cname, subname, subcidvar){
          router.push({path: '/category/'+cname+'/subcategory/'+subname+'/'+subcidvar})
        }
    },
    computed: {
        ...mapGetters(['getSearchData','getNavbarData','getLoginData', 'getCartData'])
    },
    created(){
      this.$store.dispatch('getAllRecords', {
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
.navItemsClass:hover{
  cursor: pointer!important;
  font-size: 35px;
}
.mySearchClass{
  font-size: 20px
}
.subDropdown:focus .dropdown-item {
    display: block;
    margin-top: 0;
 }

</style>
