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
                        <div class="star-ratings-sprite" ><span :style="'width:'+ getBestProdData.merchantRating*20+'%'" class="star-ratings-sprite-rating"></span></div>
                        <p style="padding:10px 0 0 0; margin:0">by: {{getBestProdData.merchantName}}</p>
                        <p style="padding:10px 0 0 0; margin:0">₹{{getBestProdData.price}}</p>
                    </div>
                    <hr style="margin:6px 0 16px 0">
                    <p>
                        <!--CARRIER - This phone is locked to Simple Mobile from Tracfone, which means this device can only be used on the Simple Mobile wireless network.
                        <br><br>PLANS - Simple Mobile offers a variety of coverage plans, including 30-Day Unlimited Talk, Text & Data. No activation fees, no credit checks, and no hassles on a nationwide lightning-fast network. For more information or plan options, please visit the Simple Mobile website.
                        <br><br>ACTIVATION - You’ll receive a Simple Mobile SIM kit with this iPhone. Follow the instructions to get service activated with the Simple Mobile plan of your choice.
                        <br><br>5.5-inch Retina HD display
                        <br><br>IP67 water and dust resistant (maximum depth of 1 meter up to 30 minutes)
                        <br><br>12MP camera and 4K video
                        <br><br>7MP FaceTime HD Camera with Retina flash-->
                        {{getBestProdData.desc}}
                    </p>
                </b-col>
                <b-col cols="2">
                    <button>Add to Cart</button><br><br>
                    <button>Buy Now</button>
                </b-col>
            </b-row>
        </b-container>
        <br>
        <!--b-container>
            <b-row>
                <b-col cols="10" class="card" style="padding: 15px 0 5px 10px"><h2>Other Merchants</h2></b-col>
            </b-row><br>
            <b-row class="merchantRow">
                <b-col cols="4" class="cardMerchant">
                    <img src="@/img/iphone.jpg" class="img-responsive imgMerchant" alt="iphone" id="displayImg">
                </b-col>
                <b-col cols="6" style="text-align: left" class="cardMerchant">
                    <div class="myHeader">
                        <h3>Apple iPhone 7 Plus (32GB) Silver</h3>
                        <div class="star-ratings-sprite" ><span style="width:50%" class="star-ratings-sprite-rating"></span></div>
                        <p style="padding:10px 0 0 0; margin:0">by: ABCD</p>
                    </div>
                </b-col>
                <b-col cols="2">
                    <button>Check Out</button><br><br>
                    <button>Buy Now</button>
                </b-col>
            </b-row>
        </b-container-->
         <b-container>
            <b-row>
                <b-col cols="12" class="card" style="padding: 15px 0 5px 10px"><h2>Other Merchants</h2></b-col>
            </b-row><br>
            <b-row>
                <b-col v-for="(ele, index) in getAllPidProdData" :key="index" cols="4" class="card" style="font-size: 18px">
                    <b-row>
                        <img :src="require('../'+ele.imgurl)" class="img-responsive imgMain" alt="iphone" id="displayImg">
                    </b-row>
                    <hr>
                    <b-row style="text-align: left">
                        <div class="myHeader">
                        <h4>{{ele.pname}}</h4>
                        <div class="star-ratings-sprite" ><span :style="'width:'+ ele.merchantRating*20+'%'" class="star-ratings-sprite-rating"></span></div>
                        <p style="padding:10px 0 0 0; margin:0">by: {{ele.merchantName}}</p>
                        <p style="padding:10px 0 0 0; margin:0">₹{{ele.price}}</p>
                    </div>
                    </b-row>
                    <b-row style="margin-bottom:1px;">
                        <button>Add to Cart</button>
                    </b-row>
                    
                    <b-row>
                        <button>Buy Now</button>
                    </b-row>
                </b-col>
            </b-row>
         </b-container>
        <br>
    </div>
</template>

<script>
import {mapActions} from 'vuex'
import {mapGetters} from 'vuex'
export default {
    name:'product',
    props: ['prodpid'],
    methods: {
        ...mapActions(['getAllProdWithSamePid', 'getBestProdPid'])
    },
    computed: {
        ...mapGetters(['getAllPidProdData','getBestProdData'])
    },
    created(){
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
    height: auto;
    background-color: white;
    height: 200px;
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
