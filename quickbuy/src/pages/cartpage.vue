<template>
    <div class="cartpage">
        <b-container>
            <b-row style="text-align:left;">
                <b-col cols="12" class="card" style="padding: 15px 0 5px 40px"><h2>Cart</h2></b-col>
            </b-row>
<hr>
            <b-row>
                <b-col cols="10">
                    <b-row class="merchantRow" v-for="(ele, index) in getCartData.productClassList" :key="index">
                        <b-col cols="3" class="cardMerchant">
                            <img :src="require('../'+ele.imgurl)" class="img-responsive imgMerchant" :alt="ele.pname" id="displayImg">
                        </b-col>
                        <b-col cols="7" style="text-align: left" class="cardMerchant">
                            <div class="myHeader">
                                <h3>{{ele.pname}}</h3>
                                <p style="padding:10px 0 0 0; margin:0">by: {{ele.merchantName}}</p>
                                <p style="padding:10px 0 0 0; margin:0">₹{{ele.price}}</p>
                            </div>
                        </b-col>
                        <b-col cols="2" class="cardMerchant">
                            <b-row align-v="center" align-h="center" style="height: 35%">
                                <button style="padding:0; width: 60px; height:40px;font-size:20px" @click="addToCartFunction(ele)">+</button>
                            </b-row>
                            <b-row align-v="center" align-h="center" style="height: 30%">
                                <h4>{{ele.quantity}}</h4>
                            </b-row>
                            <b-row align-v="center" align-h="center" style="height: 35%">
                                <button style="padding:0; width: 60px; height:40px;font-size:20px" @click="removeFromCartFunction(ele)">-</button>
                            </b-row>
                        </b-col>
                    </b-row>
                </b-col>
                <b-col cols="2">
                    <b-row class="merchantRow" align-h="center">
                        <button @click="checkoutFunction()" style="width: auto">Check Out</button>
                    </b-row>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
import {mapActions} from 'vuex'
import {mapGetters} from 'vuex'
import router from '../router'
export default {
    name: 'cartpage',
    data(){
        return{

        }
    },
    methods:{
        ...mapActions(['removeFromCart', 'addToCart']),
        addToCartFunction(ele){
            this.$store.dispatch('addToCart',{
                data: ele,
                success: ()=>{},
                failure: ()=>{alert("No product added to cart!!")}
            })
            this.$forceUpdate();
        },
        removeFromCartFunction(ele){
            this.$store.dispatch('removeFromCart',{
                data: ele,
                success: ()=>{},
                failure: ()=>{alert("No product added to cart!!")}
            })
            this.$forceUpdate();
        },
        checkoutFunction(){
            router.push({path:"/cart/order"})
        }
    },
    computed:{
        ...mapGetters(['getCartData'])
    }
}
</script>

<style scoped>
.card{
    border: none;
    border-radius: 0;
    box-shadow: 0 4px 16px 0 rgba(0,0,0,0.1);
    height: auto;
}
.merchantRow{
    margin-bottom: 20px;
}
.cardMerchant{
    border: none;
    border-radius: 0;
    box-shadow: 0 1px 2px 0 rgba(0,0,0,0.1);
    height: auto;
    background-color: white;
    height: 200px;
}
.imgMerchant{
    height: 100%;
}
.myHeader{
    padding: 10px;
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
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
}
button:hover{
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.4), 0 6px 20px 0 rgba(0,0,0,0.19);
}
</style>
