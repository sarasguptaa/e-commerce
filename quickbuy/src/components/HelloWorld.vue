<template>
  <div class="hello">
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
      <b-carousel-slide v-for="(ele, index) in imgArr" :key="index" :img-src="require('../img/'+ele+'.jpg')" >
      </b-carousel-slide>
    </b-carousel>
  </div>
    <div>
      <b-container>
        <b-row class="randomProductsClass flex-row flex-nowrap" align-v="center">

            <li v-for="(ele, index) in getSub1Data" :key="index" @click="clickFunction(ele.body.pid)" class="col-2 card" style="font-size:14px;cursor: pointer"><img :src="require('../'+ele.body.imgurl)" alt="" style="width:150px;"><br><br>{{ele.body.pname}}</li>
          
        </b-row>
        <b-row class="randomProductsClass flex-row flex-nowrap" align-v="center">
            <li v-for="(ele, index) in getSub2Data" :key="index" @click="clickFunction(ele.body.pid)" class="col-2 card" style="font-size:14px;cursor: pointer">
              <img :src="require('../'+ele.body.imgurl)" alt="" style="width:150px;">
              <br><br>{{ele.body.pname}}</li>

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
      slide: null,
      imgArr: [1,2,3,4,5,6]
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
