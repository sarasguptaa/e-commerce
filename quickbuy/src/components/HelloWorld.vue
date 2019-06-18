<template>
  <div class="hello">
    <!--h1>{{ msg }}</h1>
    <p>
      For a guide and recipes on how to configure / customize this project,<br>
      check out the
      <a href="https://cli.vuejs.org" target="_blank" rel="noopener">vue-cli documentation</a>.
    </p>
    <h3>Installed CLI Plugins</h3>
    <ul>
      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-babel" target="_blank" rel="noopener">babel</a></li>
      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-eslint" target="_blank" rel="noopener">eslint</a></li>
    </ul>
    <h3>Essential Links</h3>
    <ul>
      <li><a href="https://vuejs.org" target="_blank" rel="noopener">Core Docs</a></li>
      <li><a href="https://forum.vuejs.org" target="_blank" rel="noopener">Forum</a></li>
      <li><a href="https://chat.vuejs.org" target="_blank" rel="noopener">Community Chat</a></li>
      <li><a href="https://twitter.com/vuejs" target="_blank" rel="noopener">Twitter</a></li>
      <li><a href="https://news.vuejs.org" target="_blank" rel="noopener">News</a></li>
    </ul>
    <h3>Ecosystem</h3>
    <ul>
      <li><a href="https://router.vuejs.org" target="_blank" rel="noopener">vue-router</a></li>
      <li><a href="https://vuex.vuejs.org" target="_blank" rel="noopener">vuex</a></li>
      <li><a href="https://github.com/vuejs/vue-devtools#vue-devtools" target="_blank" rel="noopener">vue-devtools</a></li>
      <li><a href="https://vue-loader.vuejs.org" target="_blank" rel="noopener">vue-loader</a></li>
      <li><a href="https://github.com/vuejs/awesome-vue" target="_blank" rel="noopener">awesome-vue</a></li>
    </ul-->
    
    <div>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      style="text-shadow: 1px 1px 2px #333;"
    >
      <!-- Slides with image only -->
      <b-carousel-slide v-for="(ele, index) in getRandomData" :key="index" :img-src="require('../'+ele.imgurl)">
      </b-carousel-slide>
    </b-carousel>
  </div>
    <div>
      <b-container>
        <b-row class="randomProductsClass flex-row flex-nowrap" align-v="center">
            <li v-for="(ele, index) in getSub2Data" :key="index" @click="clickFunction(ele.body.pid)" class="col-2 card" style="font-size:14px">
              <img :src="require('../'+ele.body.imgurl)" alt="" style="width:150px;">
              <br><br>{{ele.body.pname}}</li>

        </b-row>
        <b-row class="randomProductsClass flex-row flex-nowrap" align-v="center">

            <li v-for="(ele, index) in getSub1Data" :key="index" @click="clickFunction(ele.body.pid)" class="col-2 card" style="font-size:14px"><img :src="require('../'+ele.body.imgurl)" alt="" style="width:150px;"><br><br>{{ele.body.pname}}</li>
          
        </b-row>
      </b-container>
    </div><br><br>
    <b-container>
      <b-row>
        <b-col>Lorem ipsum dolor sit amet consectetur adipisicing elit. Distinctio ipsam, voluptatem, impedit saepe deserunt rem aliquid incidunt itaque ratione omnis deleniti assumenda earum accusamus amet, labore sunt esse perferendis molestias.</b-col>
        <b-col>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Error nihil, tempore omnis, quidem nesciunt vel nulla asperiores quos voluptate quasi eveniet quod enim voluptatum quo eos necessitatibus consectetur atque ad?</b-col>
        <b-col>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Soluta corporis cum saepe sequi quos reprehenderit possimus unde veritatis, minima fugiat quibusdam consequatur id eveniet tenetur veniam, totam est autem facere.</b-col>
      </b-row>
    </b-container><br><br>
  </div>
</template>

<script>
import {mapActions} from 'vuex'
import {mapGetters} from 'vuex'
import router from '../router'

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return{
      slide: null
    }
  },
  methods: {
    ...mapActions(['homeDisplayProd', 'homeDisplaySubProd1','homeDisplaySubProd2','getRandomProd']),
    clickFunction(pid){
      router.push({ path: '/products/'+pid})
    }
  },
  computed: {
    ...mapGetters(['getHomeData','getSub1Data', 'getSub2Data','getRandomData'])
  },
  created(){
    this.$store.dispatch('homeDisplayProd',{
      success: ()=>{},
      failure: ()=>{}
    })
    this.$store.dispatch('homeDisplaySubProd1',{
      success: ()=>{},
      failure: ()=>{}
    })
    this.$store.dispatch('homeDisplaySubProd2',{
      success: ()=>{},
      failure: ()=>{}
    })
    this.$store.dispatch('getRandomProd',{
      success: ()=>{},
      failure: ()=>{}
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.card{
  border: none;
  border-radius: 0;
  margin:0 5px 0 0px;
  display: inline;
}
</style>
