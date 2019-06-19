<template>
    <div class="product">
        <b-container>
            <b-row>
                <b-col cols="4" class="card">
                    <img :src="require('../'+getBestProdData.imgurl)" class="img-responsive imgMain" id="displayImg">
                </b-col>
                <b-col cols="6" style="text-align: left" class="card">
                    <div class="myHeader">
                        <h3>{{getBestProdData.pname}}</h3>
                        <div class="star-ratings-sprite" ><span :style="'width:'+ getBestProdData.merchantRating*100+'%'" class="star-ratings-sprite-rating"></span></div>
                        <p style="padding:10px 0 0 0; margin:0">by: {{getBestProdData.merchantName}}</p>
                        <p style="padding:10px 0 0 0; margin:0">Stock: {{getBestProdData.stock}}</p>
                        <p style="padding:10px 0 0 0; margin:0">₹{{getBestProdData.price}}</p>
                    </div>
                    <hr style="margin:6px 0 16px 0">
                    <p>
                        {{getBestProdData.desc}}
                    </p>
                </b-col>
                <b-col cols="2">
                    <button @click="addToCartFunction(getBestProdData)">Add to Cart</button><br><br>
                </b-col>
            </b-row>
        </b-container>
        <br>
         <b-container>
            <b-row>
                <b-col cols="12" class="card" style="padding: 15px 0 5px 10px"><h2>Other Merchants</h2></b-col>
            </b-row><br>
            <b-row>
                <b-col v-for="(ele, index) in getAllPidProdData" :key="index" cols="4" style="font-size: 18px;">
                    <b-container class="cardMerchant" style="margin-bottom: 10px">
                        <b-row style="text-align: left;">
                            <div class="myHeader">
                            <h4 style="font-size: 2.5vh">{{ele.pname}}</h4>
                            <div class="star-ratings-sprite" ><span :style="'width:'+ ele.merchantRating*100+'%'" class="star-ratings-sprite-rating"></span></div>
                            <p style="padding:10px 0 0 0; margin:0">by: {{ele.merchantName}}</p>
                            <p style="padding:10px 0 0 0; margin:0">Stock: {{ele.stock}}</p>
                            <p style="padding:10px 0 0 0; margin:0">₹{{ele.price}}</p>
                        </div>
                        </b-row>
                        <b-row style="margin-bottom:1px;">
                            <button @click="addToCartFunction(ele)">Add to Cart</button>
                        </b-row>
                    </b-container>
                </b-col>
            </b-row>
            <hr>
         </b-container>
    </div>
</template>

<script>
import {mapActions} from 'vuex'
import {mapGetters} from 'vuex'
import router from "../router"
export default {
    name:'product',
    props: ['prodpid','searchvar'],
    methods: {
        ...mapActions(['getAllProdWithSamePid', 'getBestProdPid','addToCart', 'getAllProdWithSamePidSearch', 'getBestProdPidSearch']),
        addToCartFunction(ele){
            if(localStorage.getItem('mysession'))
            {
                this.$store.dispatch('addToCart',{
                    data: ele,
                    success: ()=>{this.$bvToast.toast("Product added to cart!!",{
                        title: "Success Message",
                        toaster: "b-toaster-top-center",
                        solid: true
                    })},
                    failure: ()=>{this.$bvToast.toast("Product not added to cart!!",{
                        title: "Failure Message",
                        toaster: "b-toaster-top-center",
                        solid: true
                    })}
                })
            }
            else{
                this.$bvToast.toast("Please Login!!",{
                    title: "Warning",
                    toaster: "b-toaster-top-center",
                    solid: true
                })
                router.push({path:"/login"})
            }
        }
    },
    computed: {
        ...mapGetters(['getAllPidProdData','getBestProdData'])
    },
    created(){
        if(this.searchvar==null){
            this.$store.dispatch('getAllProdWithSamePid',{
                data: this.prodpid,
                success: ()=>{},
                failure: ()=>{}
            })
            this.$store.dispatch('getBestProdPid',{
                data: this.prodpid,
                success: ()=>{},
                failure: ()=>{}
            })
        }
        else{
            this.$store.dispatch('getAllProdWithSamePidSearch',{
                data: this.prodpid,
                success: ()=>{},
                failure: ()=>{}
            })
            this.$store.dispatch('getBestProdPidSearch',{
                data: this.prodpid,
                success: ()=>{},
                failure: ()=>{}
            })
        }
    }
}
</script>

<style scoped>
.product{
    margin-top: 20px;
}
.imgMain{
    width: 100%;
}
.imgMerchant{
    height: 100%;
}
.card{
    border: none;
    border-radius: 0;
    box-shadow: 0 1px 2px 0 rgba(0,0,0,0.1);
    height: auto;
}
.cardMerchant{
    border: none;
    border-radius: 0;
    box-shadow: 0 1px 2px 0 rgba(0,0,0,0.1);
    background-color: white;
    height: auto;
}
.cardMerchant:hover{
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}
.myHeader{
    padding: 10px;
}
p{
    padding-left: 10px;
}
button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  width: 100%;
}
button:hover{
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}
.star-ratings-sprite {
    
    background: url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/2605/star-rating-sprite.png") repeat-x;
    font-size: 0;
    height: 21px;
    line-height: 0;
    overflow: hidden;
    text-indent: -999em;
    width: 110px;
    margin: 0 0 0 0;
}
.star-ratings-sprite-rating {
    background: url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/2605/star-rating-sprite.png") repeat-x;
    background-position: 0 100%;
    float: left;
    height: 21px;
    display:block;
    text-align: left;
}
.merchantRow{
    margin-bottom: 20px;
}
</style>
